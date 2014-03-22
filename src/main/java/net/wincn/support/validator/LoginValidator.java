package net.wincn.support.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class LoginValidator extends Validator{

	@Override
	protected void validate(Controller c) {
		validateRequired("user.username", "errors", "请输入用户名");
		validateRequired("user.password", "errors", "请输入密码");
		
	}

	@Override
	protected void handleError(Controller c) {
		c.keepPara("user.password");
		c.render("/WEB-INF/views/signup.html");
	}

}
