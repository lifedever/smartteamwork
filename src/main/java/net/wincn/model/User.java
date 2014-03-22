package net.wincn.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * 用户
 * 
 * @author gefangshuai
 * @createDate 2014年3月20日 下午1:50:52
 */
public class User extends Model<User> {

	private static final long serialVersionUID = -6114272070879297089L;
	public static final User dao = new User();

	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";

	public static User findUserByUsername(String username) {
		return dao.findFirst("select * from user where username = ?", username);
	}
}
