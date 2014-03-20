package net.wincn.controller;

import com.jfinal.core.Controller;

public class IndexController extends Controller {
	public void index() {
		setAttr("site", "Smart Teamwork");
	}
}
