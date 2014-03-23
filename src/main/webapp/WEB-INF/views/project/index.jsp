<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/tags.jsp"%>
<%@include file="/tags.jsp"%>
<layout:container>
	<jsp:body>
		<div class="col-md-12 text-center">
			<h4 class="alert alert-info">
				Hi
				<sec:user property="realname" />
				，这是你所有的项目
			</h4>
		</div>
		<div class="col-sm-6 col-md-3">
			<div class="thumbnail">
				<a href="#" class=""> 
					<img src="/assets/imgs/metro/016.png" class="blur">
				</a>
				<div class="caption">
					<h4>项目一</h4>
					<p>
						<a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a>
					</p>
				</div>
			</div>
		</div>
	</jsp:body>
</layout:container>
<layout:js></layout:js>