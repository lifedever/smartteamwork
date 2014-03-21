package net.wincn.controller.user;

import net.wincn.interceptor.SessionInterceptor;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * Created by gefangshuai on 2014-03-20-0020.
 */
@Before(SessionInterceptor.class)
public class ProjectController extends Controller {

	public void add() {

	}
}
