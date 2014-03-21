package net.wincn.route;

import net.wincn.controller.LoginController;
import net.wincn.controller.ProjectController;
import net.wincn.controller.UserController;

import com.jfinal.config.Routes;

public class UserRoute extends Routes {

	@Override
	public void config() {
		add("/user", UserController.class, "user");
		add("/project", ProjectController.class, "project");
		add("/login", LoginController.class);
	}
}
