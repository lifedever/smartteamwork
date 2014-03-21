package net.wincn.controller;

import org.apache.log4j.Logger;

import com.jfinal.core.Controller;

public class IndexController extends Controller {

	private static final Logger log = Logger.getLogger(IndexController.class);

	public void index() {
		setAttr("site", "Smart Teamwork");
	}

}
