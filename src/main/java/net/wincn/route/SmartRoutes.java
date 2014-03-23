package net.wincn.route;

import net.wincn.controller.IndexController;
import net.wincn.controller.LoginController;
import net.wincn.controller.ProjectController;
import net.wincn.controller.UserController;

import com.jfinal.config.Routes;

/**
 * 前台路由
 *
 * @author gefangshuai
 * @createDate 2014年3月20日 下午12:55:19
 */
public class SmartRoutes extends Routes {

    @Override
    public void config() {
        add("/", IndexController.class);
        add("/login", LoginController.class);
        
        add("/user", UserController.class, "user");
		add("/project", ProjectController.class, "project");
    }
    
}
