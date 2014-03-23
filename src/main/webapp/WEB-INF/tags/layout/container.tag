<%@ tag language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>
<html>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="row">
					<div class="col-md-12">
						<jsp:include page="/WEB-INF/views/layout/nav.jsp"></jsp:include>
					</div>
					<div class="col-md-12">
						<jsp:doBody />
					</div>
					<div class="col-md-12">
						<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>
					</div>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
</body>
</html>