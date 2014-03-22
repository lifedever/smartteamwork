<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="../layout/header.jsp"></jsp:include>
<body>
	<jsp:include page="../layout/nav.jsp"></jsp:include>
	<div class="container">
		<div class="row margin50-t">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<h1 class="text-center margin30-b">
					${siteTitle}
				</h1>
				<form role="form" method="post" action="/login/${from}">
					<legend><span class="glyphicon glyphicon-user"></span> 用户登录</legend>
					<div class="form-group">
						<input type="text" class="form-control" id="username" name="username" placeholder="输入用户名">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="password" name="password" placeholder="输入密码">
					</div>
					<button type="submit" class="btn btn-primary btn-block form-control">登录</button>

					<div class="checkbox pull-left">
						<label> <input type="checkbox"> 记住密码
						</label>
					</div>
					<div class=" pull-right margin10-t">
						<a href="/signup">注册账号</a>
					</div>
				</form>

			</div>

		</div>
		<jsp:include page="../layout/footer.jsp"></jsp:include>
	</div>
</body>
</html>