package net.wincn.config;

import net.wincn.handler.SmartHandler;
import net.wincn.model.Role;
import net.wincn.model.User;
import net.wincn.route.FrontRoute;
import net.wincn.route.UserRoute;

import org.apache.log4j.Logger;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.plugin.shiro.ShiroInterceptor;
import com.jfinal.ext.plugin.shiro.ShiroPlugin;
import com.jfinal.kit.StringKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
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
	private boolean isLocal = StringKit.isBlank(json);
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
		me.add(new FrontRoute());
		me.add(new UserRoute());
	}

	@Override
	public void configPlugin(Plugins me) {
		// 插件
		me.add(new EhCachePlugin());
		me.add(new ShiroPlugin(routes));

		String dbname, username, password, host, port;
		dbname = getProperty("dbname");
		username = getProperty("username", "root");
		password = getProperty("password", "root");
		host = getProperty("host", "localhost");
		port = getProperty("port", "3306");
		C3p0Plugin cp = new C3p0Plugin("jdbc:mysql://" + host + ":" + port + "/" + dbname, username, password);
		me.add(cp);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
		if (isLocal) {
			arp.setShowSql(true);
		}
		me.add(arp);
		// 添加model
		arp.addMapping("users", User.class);
		arp.addMapping("roles", Role.class);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		me.add(new ShiroInterceptor());

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
