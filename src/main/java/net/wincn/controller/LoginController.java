package net.wincn.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Enumeration;

import org.apache.commons.lang3.StringUtils;

import net.wincn.interceptor.SessionInterceptor;
import net.wincn.model.User;
import net.wincn.validator.LoginValidator;

import com.jfinal.aop.Before;
import com.jfinal.aop.ClearInterceptor;
import com.jfinal.aop.ClearLayer;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

@Before(SessionInterceptor.class)
public class LoginController extends Controller {

	/**
	 * 登录页面
	 */
	@ClearInterceptor(ClearLayer.ALL)
	@ActionKey("signin")
	public void signin() {
		String url = getPara(0);

		setAttr("from", url);
		renderFreeMarker("/WEB-INF/views/signin.html");
	}

	/**
	 * 用户登录
	 */
	@ClearInterceptor(ClearLayer.ALL)
	@ActionKey("login")
	public void login() {
		String from = getPara(0);
		User user = getModel(User.class);
		User dbUser = User.dao.findFirst("select * from user where username = ?", user.getStr(User.USERNAME));

		if (dbUser != null && dbUser.getStr(User.PASSWORD).equals(user.getStr(User.PASSWORD))) {
			setSessionAttr("sessionUser", dbUser);
			try {
				redirect(StringUtils.isBlank(from) ? "/" : URLDecoder.decode(from, "utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else {
			redirect("/signin");
		}
	}

	/**
	 * 退出页面
	 */
	@ActionKey("signout")
	public void loginout() {
		Enumeration<String> names = getSession().getAttributeNames();
		while (names.hasMoreElements()) {
			removeSessionAttr(names.nextElement());
		}
		redirect("/signin");
	}

	/**
	 * 用户注册页面
	 */
	@ActionKey("signup")
	@ClearInterceptor(ClearLayer.ALL)
	public void signup() {
		renderFreeMarker("/WEB-INF/views/signup.html");
	}

	@Before(LoginValidator.class)
	@ActionKey("register")
	@ClearInterceptor(ClearLayer.ALL)
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
