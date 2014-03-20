package net.wincn.route;

import net.wincn.controller.user.UserController;

import com.jfinal.config.Routes;

public class UserRoute extends Routes{

	@Override
	public void config() {
		add("/user", UserController.class, "user");
	}

}
