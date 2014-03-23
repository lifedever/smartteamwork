package net.wincn.support.interceptor;

import org.apache.commons.lang3.StringUtils;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

/**
 * 导航拦截器
 * 
 * @author gefangshuai
 * @createDate 2014年3月23日 上午7:34:47
 */
public class NavInterceptor implements Interceptor {

	@Override
	public void intercept(ActionInvocation ai) {
		String nav = getNavByControllerKey(ai.getControllerKey());
		if (nav != null)
			ai.getController().setAttr("nav", nav);
		ai.invoke();
	}

	private String getNavByControllerKey(String controllerKey) {
		String nav = StringUtils.substringBetween(controllerKey, "/");
		nav = nav == null ? StringUtils.substringAfter(controllerKey, "/") : nav;
		nav = nav == null||nav.equals("") ? "index" : nav;
		return nav;
	}

}
