package net.wincn.controller;

import net.wincn.interceptor.SessionInterceptor;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

@Before(SessionInterceptor.class)
public class UserController extends Controller {
	public void index(){
		
	}
    
	public void add() {
		
	}
}
