package net.wincn.route;

import net.wincn.controller.IndexController;

import com.jfinal.config.Routes;

/**
 * 前台路由
 *
 * @author gefangshuai
 * @createDate 2014年3月20日 下午12:55:19
 */
public class FrontRoute extends Routes {

    @Override
    public void config() {
        add("/", IndexController.class);
    }
    
}
