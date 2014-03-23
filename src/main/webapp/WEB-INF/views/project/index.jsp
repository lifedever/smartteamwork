<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/tags.jsp"%>
<!DOCTYPE html>
<html>
<jsp:include page="../layout/header.jsp"></jsp:include>
<body>
	<jsp:include page="../layout/nav.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-md-12 text-center margin30-b">
				<h3>
					Hi 
					<sec:user property="realname" />
					，这是你所有的项目
				</h3>
			</div>
			<div class="col-sm-6 col-md-3">
				<div class="thumbnail">
					<a href="#" class="thumbnail">
						<img src="/assets/imgs/metro/016.png" class="blur">
					</a>
					<div class="caption">
						<h3>项目一</h3>
						<p>
							<a href="#" class="btn btn-primary" role="button">Button</a> 
							<a href="#" class="btn btn-default" role="button">Button</a>
						</p>
					</div>
				</div>
			</div>
			<div class="col-sm-6 col-md-3">
				 <a href="#" class="thumbnail">
					<img src="/assets/imgs/new.png"  class="blur">
				</a>					
			</div>
		</div>
		<jsp:include page="../layout/footer.jsp"></jsp:include>
		<script type="text/javascript">
		</script>
	</div>
</body>
</html>