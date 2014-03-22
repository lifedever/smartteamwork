<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/tags.jsp" %>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/"><span class="glyphicon glyphicon-thumbs-up"></span>${siteName}</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav ">
				<li class="active"><a href="/"><span class="glyphicon glyphicon-home"></span> 首页</a></li>
				<li><a href="/project/">项目管理</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<shiro:user>
					<li class="dropdown">
				        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> <shiro:principal /><b class="caret"></b></a>
				        <ul class="dropdown-menu">
				          <li><a href="#">我的主页</a></li>
				          <li class="divider"></li>
				          <li><a href="/signout">退出</a></li>
				        </ul>
					</li>
				</shiro:user>
				<shiro:guest>
					<li><a href="/signin">登录</a></li>
					<li><a href="/signup">注册</a></li>
				</shiro:guest>
			</ul>
			<form class="navbar-form navbar-right" role="search">
				<div class="form-group input-group margin10-lr">
					<input type="text" class="form-control search-query " style="border-radius: 15px;" placeholder="项目查询" id="searchInp">
				</div>
			</form>

		</div>
	</div>
</nav>