package net.wincn.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

public class SessionInterceptor implements Interceptor {

	@Override
	public void intercept(ActionInvocation ai) {
		Object user = ai.getController().getSessionAttr("sessionUser");
		if (user == null) {
			ai.getController().redirect("/signin");
		}else{
			ai.invoke();
		}
	}

}
