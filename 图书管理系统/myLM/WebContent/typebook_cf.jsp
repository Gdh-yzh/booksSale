<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书类型</title>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap-table-master/dist/bootstrap-table.min.css">
<link
	href="bootstrap-dateTimePicket4.17.47/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<link 
	href="bootstrap-select-1.13.9/css/bootstrap-select.min.css"
	rel="stylesheet">
<link
	href="bootstrap-table-master/src/extensions/fixed-columns/bootstrap-table-fixed-columns.scss"
	rel="stylesheet">
<link 
	href="bootstrapvalidator-master/css/bootstrapValidator.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="table-responsive container">
		<div class="center-block" style="width: 80%; padding: 5px">
			<p class="text-center bg-danger" style="padding: 5px"><b>图书类型</b></p>
			<table id="table_table" class=" table-striped "
				style="table-layout: fixed;"></table>
		</div>
	</div>
</body>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="bootstrap-3.3.7-dist/jquery.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="bootstrap-table-master/dist/bootstrap-table.min.js"></script>
<script src="bootstrap-table-master/src/extensions/fixed-columns/bootstrap-table-fixed-columns.js"></script>
<script src="bootstrap-table-master/dist/locale/bootstrap-table-zh-CN.js"></script>
<!-- 日期 -->
<script src="bootstrap-select-1.13.9/js/bootstrap-select.min.js"></script>
<script src="monent-2.24.0/moment-with-locales.min.js"></script>
<script src="bootstrap-dateTimePicket4.17.47/js/bootstrap-datetimepicker.min.js"></script>
<script src="bootstrap-dateTimePicket4.17.47/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="bootstrapvalidator-master/js/bootstrapValidator.min.js"></script>
<script type="text/javascript">
	$('#table_table')
			.bootstrapTable(
					{
						url : '${pageContext.request.contextPath}/findTypebookCf', // 表格数据来源
						//method : 'post',
						//pagination : true,//启动分页
						//search : true,
						pageSize : 50,//初始页记录数
						pageList : [ 10, 15, 20, 50 ], //记录数可选列表
						//showColumns : true,
						//showRefresh : true,
						//toolbar : '#toolbar',
						//showToggle : true,
						pageNumber : 1, //初始化加载第一页，默认第一页
						locale : "zh-CN",//中文
						striped : true,//设置为 true 会有隔行变色效果
						singleSelect : false, //多选
						maintainSelected : true,//保持翻页记住被选
						clickToSelect : true, //是否启用点击选中行
						//固定列
						fixedColumns : true,
						//fixedNumber : 1,//固定列的数量
						//onDblClickRow : ondouble,
						classes : 'table table-sm table-bordered table-hover ',
						queryParams : function(params) {
							return {
								pageNumber : params.pageNumber, //每页多少条数据
								pageSize : params.pageSize,
							}
						},
						queryParamsType : "",
						//服务器分页
						//	sidePagination : "server",
						contentType : "application/x-www-form-urlencoded",
						dataType : "json",
						columns : [
								{
									field : 'classificationnumber',
									title : '序号',
									align : "center",
									width : 50,
									formatter : function(value, row, index) {
										var pageNumber = $("#table_table")
												.bootstrapTable("getOptions").pageNumber;
										var pageSize = $("#table_table")
												.bootstrapTable("getOptions").pageSize;
										return (pageNumber - 1) * pageSize
												+ index + 1;
									},
									visible : false,
								}, {
									field : 'select',
									title : '选择',
									align : "center",
									checkbox : true,
									visible : false,
								//editable:true,
								}, {
									field : 'typebookCfnumber',
									title : '图书类型编号',
									align : "center",
									width : 100
								}, {
									field : 'typebookCfname',
									title : '图书类型',
									align : "center",
									width : 100
								}, {
									field : 'overduedailymoney',
									title : '每日逾期金额',
									align : "center",
									width : 150,
									editable : true,
									formatter : function(value, row, index) {
										return value+"元";
									}
								} ],
						onDblClickCell : function(field, value, row, $element) {
							//ondouble(field, value, row, $element);
						},
					//editable:true,
					});
	$(function() {
		//bootstrapTable();
		$('#table_table').bootstrapTable();
	})
	$('#table_table').editable({
		type : 'text',
		pk : 1,
		url : '/post',
		title : 'Enter username'
	});
</script>
</html>