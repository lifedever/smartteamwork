<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="${path}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${path}/assets/js/bootstrap.min.js"></script>
<script type="text/javascript">
	(function(){
		$searchInp = $('#searchInp');
		$searchInp.val() == ''?$searchInp.css('width', '100px'):$searchInp.css('width', '200px');
		$searchInp.on('focus', function(){
			$this = $(this);
			$this.animate({ 
				width: '200px'
			},300);
		});
		$searchInp.on('blur', function(){
			if(!$searchInp.val()){
				$this = $(this);
				$this.animate({ 
					width: '100px'
				},300);
			}
		});
	})();
</script>