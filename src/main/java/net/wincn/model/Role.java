package net.wincn.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

public class Role extends Model<Role> {
	private static final long serialVersionUID = 1L;
	public static final Role dao = new Role();

	public List<User> getUsers() {
		return User.dao.find("select u.* from users join user_roles ur on u.id = ur.user_id where ur.role_id = ?",
				get("id"));
	}
}
