package net.wincn.config;

import net.wincn.route.SmartRoutes;
import net.wincn.support.handler.SmartHandler;
import net.wincn.support.interceptor.NavInterceptor;

import org.apache.log4j.Logger;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.plugin.shiro.ShiroInterceptor;
import com.jfinal.ext.plugin.shiro.ShiroPlugin;
import com.jfinal.ext.plugin.tablebind.AutoTableBindPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.render.ViewType;

/**
 * 核心配置文件
 * 
 * @author gefangshuai
 *
 */
public class SmartConfig extends JFinalConfig {
	private static final Logger log = Logger.getLogger(SmartConfig.class);

	private final String json = java.lang.System.getenv("VCAP_SERVICES");
	private Routes routes;

	@Override
	public void configConstant(Constants me) {
		log.debug(json);
		loadPropertyFile("application.properties");
		me.setViewType(ViewType.JSP);
		me.setBaseViewPath("/WEB-INF/views/");
		me.setBaseViewPath("/WEB-INF/views");
		me.setError404View("/404.jsp");
		me.setError500View("/500.jsp");

		/**
		 * 设置未授权
		 */
		me.setErrorView(401, "/unauthorized.jsp");
		me.setErrorView(403, "/forbid.jsp");

		// 开启debug模式
		me.setDevMode(true);

	}

	/**
	 * 站点配置信息
	 */
	private void siteConfig() {

		SiteConfig.NAME = getProperty("site.name");
		SiteConfig.TITLE = getProperty("site.title");
	}

	@Override
	public void configRoute(Routes me) {
		this.routes = me;
		me.add(new SmartRoutes());

	}

	@Override
	public void configPlugin(Plugins me) {
		// 插件
		me.add(new EhCachePlugin());
		me.add(new ShiroPlugin(routes));

		DruidPlugin druidPlugin = new DruidPlugin(getProperty("jdbc.url"), getProperty("jdbc.username"), getProperty("jdbc.password"));
		me.add(druidPlugin);

		// 添加自动绑定model与表插件
		AutoTableBindPlugin autoTableBindPlugin = new AutoTableBindPlugin(druidPlugin);
		autoTableBindPlugin.setShowSql(true);
		me.add(autoTableBindPlugin);

	}

	@Override
	public void configInterceptor(Interceptors me) {
		me.add(new ShiroInterceptor());
		me.add(new NavInterceptor());

	}

	@Override
	public void afterJFinalStart() {
		siteConfig();
	}

	@Override
	public void configHandler(Handlers me) {
		me.add(new SmartHandler());
	}

}
