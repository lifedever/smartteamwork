<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/tags.jsp"%>
<layout:container>
	<jsp:body>
		<div class="row margin50-t">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<h1 class="text-center margin30-b">
					${siteTitle}
				</h1>
				<form role="form" method="post" action="/register">
					<legend>
						<span class="glyphicon glyphicon-user"></span> 用户注册</legend>
					<div class="form-group">
						<input type="text" class="form-control" id="username" name="user.username" placeholder="输入用户名">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="realname" name="user.realname" placeholder="输入真实姓名">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="password" name="user.password" placeholder="输入密码">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="confirm_password" placeholder="确认密码">
					</div>
					
					<button type="submit" class="btn btn-primary btn-block form-control">注册</button>

					<div class=" pull-left margin10-t">
						<a href="/signin">返回登录</a>
					</div>
				</form>
			</div>
		</div>
	</jsp:body>
</layout:container>