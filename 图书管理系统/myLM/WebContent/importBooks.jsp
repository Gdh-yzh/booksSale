<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>导入图书表格</title>
</head>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/addBook.css">
<link rel="stylesheet" href="css/addBorrow.css">
<link
	href="bootstrap-dateTimePicket4.17.47/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<link 
	href="bootstrap-select-1.13.9/css/bootstrap-select.min.css"
	rel="stylesheet">
<link 
	href="bootstrapvalidator-master/css/bootstrapValidator.min.css"
	rel="stylesheet">
<link 
	href="bootstrap-fileinput-master/css/fileinput.min.css"
	rel="stylesheet">
<link 
	href="bootstrap-table-master/src/extensions/fixed-columns/bootstrap-table-fixed-columns.scss"
	rel="stylesheet">
<body>
	<div class="container my-4">
		<a class="btn btn-danger" href="addBook.jsp" role="button" 
						id="back" style="float:left;margin-bottom: 10px;margin-top: 10px;">返回</a>
		<a class="btn btn-primary" href="excel/book.xls" role="button" 
						id="back" style="float:left;margin-bottom: 10px;margin-top: 10px;margin-left: 10px;">下载表格模板</a>
		<!-- 上传文件 -->
		<form enctype="multipart/form-data" style="margin-top: 50px;">
			<div class="form-group">
				<div class="file-loading">
					<input id="file-1" name="file" type="file" multiple
						class="file-loading" data-overwrite-initial="false"
						data-min-file-count="1" data-theme="fas">
				</div>
			</div>
		</form>
	</div>
	<!-- 预览数据 -->
	<div id="toolbar" title="批量添加图书" class="container" 
		style="border: solid #eee 1px; padding: 10px;">
		<div id="div_table" class="table-responsive" style="display: none;">
			<button style="float:left;margin-bottom: 10px;" id="btn_addBooks" type="button" class="btn btn-primary" data-dismiss="modal">批量添加</button>
			<table id="table_table" class="table-striped"
				style="table-layout: fixed;"></table>
		</div>
	</div>
	<div class="modal" id="myModalhint" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"></button>
					<h4 class="modal-title" id="hintTitle">
						<span style="color: green" class="glyphicon  glyphicon-remove"></span>
					</h4>
				</div>
				<div class="modal-body">
					<div id="hintBody" style="margin: o auto"></div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 添加成功？ -->
	<div class="modal" id="myModalAddSuccess" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"></button>
					<h4 class="modal-title" id="myModalLabel">
						导表添加图书<span style="color: #337ab7" class="glyphicon  glyphicon-ok"></span>
					</h4>
				</div>
				<div class="modal-body">
					<p>添加成功</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 添加失败？ -->
	<div class="modal" id="myModalAddFail" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"></button>
					<h4 class="modal-title" id="myModalLabel">
						导表添加图书<span style="color: red" class="glyphicon  glyphicon-remove"></span>
					</h4>
				</div>
				<div class="modal-body">
					<p>添加失败</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
				</div>
			</div>
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
<script src="jquery-resizable-columns-gh-pages/colResizable-1.6.min.js"></script>
<script src="jquery-resizable-columns-gh-pages/dist/jquery.resizableColumns.min.js"></script>
<script src="bootstrap-table-master/dist/extensions/resizable/bootstrap-table-resizable.js"></script>
<script src="bootstrap-fileinput-master/js/fileinput.min.js"></script>
<script src="bootstrap-fileinput-master/js/locales/zh.js"></script>
<script type="text/javascript">
	//格式
	$("#file-1").fileinput({
		language : 'zh',
		theme : 'fas',
		uploadUrl : '${pageContext.request.contextPath}/' + "importBooks",
		allowedFileExtensions : [ 'xlsx', 'xls' ],
		overwriteInitial : false,
		maxFileSize : 1000,
		maxFilesNum : 1,
		//allowedFileTypes: ['image', 'video', 'flash'],
		slugCallback : function(filename) {
			return filename.replace('(', '_').replace(']', '_');
		}
	});
	//模态框居中
	function modalCenter(id) {
		var height = window.innerHeight;
		var item_height = 350;
		var top = (height - item_height) / 2;
		if (top < 0) {
			top = 0;
		}
		$(id).css("top", top + "px");
		//$(id).modal("show");
	}
	$("#file-1").on(
			"fileuploaded",
			function(event, data, previewId, index) {
				var res = JSON.stringify(data.response.total);
				console.log(JSON.stringify(data.response));
				if (res > 0) {
					console.log("成功");
					$(".fileinput-remove-button").click();
					//显示表格
					$('#div_table').show();				
					var path = "getDatas";
					var url = '${pageContext.request.contextPath}/' + path;
					//加载数据
					$('#table_table').bootstrapTable('refresh', {
						url : url,
					//query : datas,
					//query : data
					});					
				} else {
					console.log("失败");
					$(".fileinput-remove-button").click();
				}
			});
	$('#myModalhint').on('show.bs.modal', function(e) {
		modalCenter("#myModalhint");
	})
	$('#myModalAddSuccess').on('show.bs.modal', function(e) {
		modalCenter("#myModalAddSuccess");
	})
	$('#myModalAddFail').on('show.bs.modal', function(e) {
		modalCenter("#myModalDeleteFail");
	})
	//获取多选
	$("#btn_addBooks").click(function() {
		var datas = $('#table_table').bootstrapTable('getAllSelections');
		var amounts = $('#table_table td:eq(15)').text();
		//console.log("我是数据"+amounts[0]);
		if (datas.length == 0) {
			$('#myModalhint').modal('show');
			$('#hintBody').text("未选择有效的图书!");
			$('#hintTitle')
					.html(
							"无效的图书信息<span class='glyphicon glyphicon-alert' style='color:green; margin_left:5px'></span>");
			//alert("未选择");
		} else {
			//console.log("我是数据"+datas[0].isbn);
			//批量添加图书
			$.ajax({
				url : '${pageContext.request.contextPath}/' + "addManyBooks", //后台controller中的请求路径
				type : 'POST',
				// async : false,
				datatype : 'json',
				data : {"books":JSON.stringify(datas)},
				success : function(data) {
					if(data>0){
						//alert(data+"条数据添加成功");
						$('#myModalAddSuccess').modal('show');
						$('#div_table').hide();					
					}else{
						$('#myModalAddFail').modal('show');
					}
				},
				error : function() {
					$('#myModalAddFail').modal('show');
				}
			});
		}		
	});
	function modalHint(title, body) {
		$('#myModalhint').modal('show');		
	}
		$('#table_table')
				.bootstrapTable(
						{
							//url : '${pageContext.request.contextPath}/findBooksByText', // 表格数据来源
							//method : 'post',
							pagination : true,//启动分页
							//search : true,
							pageSize : 5,//初始页记录数
							pageList : [ 5, 10, 15, 20 ], //记录数可选列表
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
							resizable : false,//移动列宽
							queryParams : function(params) {
								//getParams(params);
								//alert(params.search);
								//alert(params.sort);
								return {
									//当前页									
									pageNumber : params.pageNumber, //每页多少条数据
									pageSize : params.pageSize,
									//text : params.searchText,
									//sortOrder : params.sortOrder,
									//sortName : params.sortName,
									//bookString : $("#div_table").serialize(),
								//bookString:JSON.stringify($("#form_query").serializeArray()),								
								// 页码
								};
							},
							queryParamsType : "undefined",
							//queryParamsType : "",
							//服务器分页
							//sidePagination : "server",
							//客户端分页
							sidePagination:'client',
							contentType : "application/x-www-form-urlencoded",
							dataType : "json",
							responseHandler : function(res) {
								//alert(res.rows[1].ClassificationBook);
								return {
									//return bootstrap-table能处理的数据格式 classificationtype publishhousename
									"total" : res.total,
									"rows" : res.rows,
								}
							},
							columns : [
									{
										field : 'number',
										title : '序号',
										align : "center",
										width : 50,
										formatter : function(value, row, index) {
											var pageNumber = $("#table_table")
													.bootstrapTable(
															"getOptions").pageNumber;
											var pageSize = $("#table_table")
													.bootstrapTable(
															"getOptions").pageSize;
											return (pageNumber - 1) * pageSize
													+ index + 1;
										}
									},
									{
										field : 'select',
										title : '选择',
										align : "center",
										checkbox : true,
										/*
										formatter : function(value, row, index) {
											var data = idlist;
											if (index == 9) {
												//alert(data.length + "  "+idlist.length);
											}
											for (var i = 0; i < data.length; i++) {
												//alert(data[i].booknumber);
												if (row.booknumber == data[i].booknumber) //根据行里字段判断是否选中
													return {
														checked : true
													//设置选中
													};
											}
											return value;
										}*/
									},
									{
										field : 'isbn',
										title : 'ISBN',
										align : "center",
										width : 150,
									},
									{
										field : 'title',
										title : '图书名',
										align : "center",
										width : 150
									},
									{
										field : 'author',
										title : '作者',
										align : "center",
										width : 150
									},
									{
										field : 'translator',
										title : '译者',
										align : "center",
										width : 150
									},
									{
										field : 'publishhousenumber',
										title : '出版社',
										align : "center",
										width : 100,
									},
									{
										field : 'publishyear',
										title : '出版年份',
										align : "center",
										width : 100,
										sortable : true,									
									},
									{
										field : 'callnumber',
										title : '索书号',
										align : "center",
										width : 100,
									},
									{
										field : 'typebookCfnumber',
										title : '图书类型',
										align : "center",
										width : 100,
									},
									{
										field : 'classificationnumber',
										title : '图书分类',
										align : "center",
										width : 100,									
									},
									{
										field : 'typecirculationnumber',
										title : '流通分类',
										align : "center",
										width : 100,
									},
									{
										field : 'bookstatusnumber',
										title : '图书状态',
										align : "center",
										width : 100,
									},
									{
										field : 'summary',
										title : '简介',
										align : 'center',
										width : 200,
									},
									{
										field : 'amount',
										title : '数量',
										align : "center",
										width : 100,
									} ],
						});
</script>
</html>