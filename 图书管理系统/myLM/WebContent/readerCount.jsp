<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>读者统计</title>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/readerCount.css">
<link
	href="bootstrap-dateTimePicket4.17.47/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<link 
	href="bootstrap-select-1.13.9/css/bootstrap-select.min.css"
	rel="stylesheet">
<link 
	href="bootstrapvalidator-master/css/bootstrapValidator.min.css"
	rel="stylesheet">
</head>
<body>
<div class="div_table">
	<table id="readerText" class="table">
		<thead>
			<p class="text-center"><b>-- 读者统计 --</b></p>
		</thead>
		<tr class="danger">
			<td>读者数量:</td>
			<td id="td_readerAmounts"></td>
		</tr>
	</table>	
	</div>
</body>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="bootstrap-3.3.7-dist/jquery.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<!-- 日期 -->
<script src="bootstrap-select-1.13.9/js/bootstrap-select.min.js"></script>
<script src="monent-2.24.0/moment-with-locales.min.js"></script>
<script src="bootstrap-dateTimePicket4.17.47/js/bootstrap-datetimepicker.min.js"></script>
<script src="bootstrapvalidator-master/js/bootstrapValidator.min.js"></script>
<script type="text/javascript">
$(function() {
	getReaderCount();
})
function getReaderCount(){
	var path = "readerAmounts";
	var url = '${pageContext.request.contextPath}/' + path;
	$.ajax({
		url : url,
		type : "POST",
		dataType : "json",
		success : function(data) {
			console.log(data.amounts);
			$("#td_readerAmounts").html(data.amounts+"个");
		},
		error : function(ds) {
			console.log(ds);
		}
	});
}
</script>
</html>