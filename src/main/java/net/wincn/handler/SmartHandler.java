package net.wincn.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.wincn.config.SiteConfig;
import net.wincn.model.User;

import com.jfinal.handler.Handler;

public class SmartHandler extends Handler {
	@Override
	public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
		request.setAttribute("path", request.getContextPath());
		if (target.endsWith(".html")) {
			target = target.substring(0, target.length() - 5);
		}
		// 设置站点信息
		request.setAttribute("siteTitle", SiteConfig.TITLE);
		request.setAttribute("siteName", SiteConfig.NAME);
		
		// 设置用户信息
		User user = (User) request.getSession().getAttribute("sessionUser");
		if(user != null){
			request.setAttribute("user", user);
		}
		
		nextHandler.handle(target, request, response, isHandled);
	}
}
