package net.wincn.controller.user;

import com.jfinal.aop.Before;
import com.jfinal.aop.ClearInterceptor;
import com.jfinal.aop.ClearLayer;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

import net.wincn.interceptor.SessionInterceptor;
import net.wincn.model.User;

@Before(SessionInterceptor.class)
public class LoginController extends Controller {
	
	@ClearInterceptor(ClearLayer.ALL)
	@ActionKey("signin")
	public void signin(){
		renderFreeMarker("/WEB-INF/views/login.html");
	}
	
	@ClearInterceptor(ClearLayer.ALL)
	@ActionKey("login")
	public void login() {
		User user = getModel(User.class);
		User dbUser = User.dao.findFirst("select * from user where username = ?", user.getStr(User.USERNAME));

		if (dbUser != null && dbUser.getStr(User.PASSWORD).equals(user.getStr(User.PASSWORD))) {
			setSessionAttr("sessionUser", dbUser);
			redirect("/");
		}
	}
}
