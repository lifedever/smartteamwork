package net.wincn.interceptor;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

public class SessionInterceptor implements Interceptor {

	@Override
	public void intercept(ActionInvocation ai) {
		Object user = ai.getController().getSessionAttr("sessionUser");
		if (user == null) {
			String url = ai.getController().getRequest().getServletPath();//获取跳转的url
			ai.getController().setAttr("redirectUrl", url);
			try {
				ai.getController().redirect("/signin/" + URLEncoder.encode(url, "utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else {
			ai.invoke();
		}
	}

}
