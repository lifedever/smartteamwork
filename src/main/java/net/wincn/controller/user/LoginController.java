package net.wincn.controller.user;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Enumeration;

import org.apache.commons.lang3.StringUtils;

import net.wincn.interceptor.SessionInterceptor;
import net.wincn.model.User;

import com.jfinal.aop.Before;
import com.jfinal.aop.ClearInterceptor;
import com.jfinal.aop.ClearLayer;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

@Before(SessionInterceptor.class)
public class LoginController extends Controller {

	@ClearInterceptor(ClearLayer.ALL)
	@ActionKey("signin")
	public void signin() {
		String url = getPara(0);

		setAttr("from", url);
		renderFreeMarker("/WEB-INF/views/login.html");
	}

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

	@ActionKey("signout")
	public void loginout() {
		Enumeration<String> names = getSession().getAttributeNames();
		while (names.hasMoreElements()) {
			removeSessionAttr(names.nextElement());
		}
		redirect("/signin");
	}
}
