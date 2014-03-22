package net.wincn.support.realm;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


import net.wincn.model.Role;
import net.wincn.model.User;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;


public class ShiroDbRealm extends JdbcRealm {

	/**
	 * 授权查询时调用，进行授权但缓存中无用户信息时调用
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String loginName = (String) principals.fromRealm(getName()).iterator().next();
		User user = User.findUserByUsername(loginName);
		if (user != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			Set<String> permissions = new TreeSet<String>();
			List<Role> roles = user.getRoles();
			for (Role role : roles) {
				String ps = role.getStr("permissions");
				if (ps != null && ps.contains(":")) {
					permissions.addAll(Arrays.asList(ps.split(":")));
				} else {
					permissions.add(ps);
				}
			}

			info.setStringPermissions(permissions);
			return info;
		}
		return null;
	}


	/**
	 * 认证函数，登录时调用
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		User user = User.findUserByUsername(token.getUsername());
		if (user != null)
			return new SimpleAuthenticationInfo(user.getStr(User.USERNAME), user.getStr(User.PASSWORD), getName());
		return null;
	}

}
