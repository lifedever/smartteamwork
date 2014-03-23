<%@ tag language="java" pageEncoding="utf-8" body-content="empty"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="sec" tagdir="/WEB-INF/tags/sec"%>

<%@ attribute name="nav" type="java.lang.String"%>

<nav class="navbar navbar-default" role="navigation">
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
			<li <c:if test="${nav eq 'index' }"> class="active"</c:if>><a href="/"><span
					class="glyphicon glyphicon-home"></span> 首页</a></li>
			<li <c:if test="${nav eq 'project' }"> class="active"</c:if>><a href="/project/"><span
					class="glyphicon glyphicon-hdd"></span> 项目管理</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<shiro:user>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><span
						class="glyphicon glyphicon-user"></span> <sec:user property="realname" /><b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">我的主页</a></li>
						<li class="divider"></li>
						<li><a href="/signout">退出</a></li>
					</ul></li>
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
</nav>