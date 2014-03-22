package net.wincn.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.wincn.config.SiteConfig;

import com.jfinal.handler.Handler;

public class SmartHandler extends Handler {
	@Override
	public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
		request.setAttribute("path", request.getContextPath());
		if (target.endsWith(".html")) {
			target = target.substring(0, target.length() - 5);
		}
		if (target.endsWith(".jsp")) {
			target = target.substring(0, target.length() - 4);
		}
		// 设置站点信息
		request.setAttribute("siteTitle", SiteConfig.TITLE);
		request.setAttribute("siteName", SiteConfig.NAME);

		nextHandler.handle(target, request, response, isHandled);
	}
}
