package net.wincn.controller;

import net.wincn.model.User;
import net.wincn.validator.LoginValidator;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;

import com.jfinal.aop.Before;
import com.jfinal.aop.ClearInterceptor;
import com.jfinal.aop.ClearLayer;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

public class LoginController extends Controller {

	/**
	 * 登录页面
	 */
	@ClearInterceptor(ClearLayer.ALL)
	@ActionKey("signin")
	public void signin() {
		String url = getPara(0);
		setAttr("from", url);
	}

	/**
	 * 用户登录
	 */
	@ClearInterceptor(ClearLayer.ALL)
	@ActionKey("login")
	public void login() {
		Subject user = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(getPara("username"), getPara("password"));
		token.setRememberMe(true);
		try {
			user.login(token);
			redirect(WebUtils.getSavedRequest(getRequest()).getRequestUrl()); // 跳回到登录前的页面
		} catch (Exception e) {
			token.clear();
			redirect("/singin");
		}
	}

	/**
	 * 退出页面
	 */
	@ActionKey("signout")
	public void loginout() {
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		redirect("/signin");
	}

	/**
	 * 用户注册页面
	 */
	@ActionKey("signup")
	@ClearInterceptor(ClearLayer.ALL)
	public void signup() {
	}

	@Before(LoginValidator.class)
	@ActionKey("register")
	public void regediter() {
		User user = getModel(User.class);
		if (User.dao.findFirst("select * from user where username = ?", user.getStr("username")) != null) {
			setAttr("errors", "用户已被注册！");
			render("/WEB-INF/views/signup.html");
		} else {
			setAttr("success", "用户注册成功！");
			render("/WEB-INF/views/signin.html");
		}
	}
}
