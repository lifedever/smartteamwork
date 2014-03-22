package net.wincn.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.jfinal.core.Controller;

/**
 * 
 * @author gefangshuai
 * @createDate 2014年3月22日 下午10:24:37
 */
@RequiresPermissions("project")
public class ProjectController extends Controller {
	public void index() {

	}

	public void add() {

	}

}
