<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>借阅管理</title>
<link rel="stylesheet" href="css/bookManagement.css">
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
	<div class="table-responsive">
		<table id="table_table" class=" table-striped "
			style="table-layout: fixed;"></table>
	</div>
	<div id="toolbar" class="btn-group">
		<button id="btn_edit" type="button" class="btn btn-warning">
			<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>查看
		</button>
		<button id="btn_delete" type="button" class="btn btn-danger">
			<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
		</button>
	</div>
	<!-- Modal -->
	<div class="modal fade " id="myModalEdit" tabindex="-1" role="dialog"
		aria-labelledby="myModalEditLabel" data-backdrop="static"
		data-keyboard="false">
		<div class="modal-dialog modal-sm" role="document"
			style="width: 750px">
			<div class="modal-content">
				<!--头部 -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalEditLabel">
						查看<span style="color: green" class="glyphicon  glyphicon-alert"></span>
						<span class="text-info" id="span_edit"
							style="font-size: 14px;"></span>
					</h4>
				</div>
				<!-- 内容1 -->
				<div class="modal-body">
					<div id="div_addBook" class="container-fluid">
						<div class="col-md-10">
							<form class="form-horizontal" id="edit_table" method="post"
								role="form">
								<div class="col-md-10">
									<a class="text-primary">基本信息</a>
								</div>
								<div class="form-group col-md-10">
									<label class="col-md-4  control-label" for="borrownumber">借阅编号:</label>
									<div class="col-md-8">
										<input name="borrownumber" id="modal_borrownumber" type="text"
											class="form-control " placeholder="借阅编号"
											aria-describedby="basic-addon1" readonly="readonly">
									</div>
								</div>
								<div class="form-group col-md-10">
									<label class="col-md-4 control-label" for="title">图书名:</label>
									<div class="col-md-8">
										<input name="title" id="modal_title" type="text"
											class="form-control" placeholder="图书名"
											aria-describedby="basic-addon1" maxlength="20">
									</div>
								</div>
								<div class="form-group col-md-10">
									<label class="col-md-4 control-label" for="booknumber">图书编号:</label>
									<div class="col-md-8">
										<input name="booknumber" id="modal_booknumber" type="text"
											class="form-control" placeholder="图书编号"
											aria-describedby="basic-addon1" maxlength="20">
									</div>
								</div>
								<div class="form-group col-md-10">
									<label class="col-md-4  control-label" for="isbn ">ISBN:</label>
									<div class="col-md-8">
										<input name="isbn" id="modal_isbn" type="text"
											class="form-control" placeholder="ISBN"
											aria-describedby="basic-addon1" maxlength="20">
									</div>
								</div>
								<div class="form-group col-md-10">
									<label class="col-md-4  control-label" for="readername">读者名:</label>
									<div class="col-md-8">
										<input name="readername" id="modal_readername" type="text"
											class="form-control " placeholder="读者姓名"
											aria-describedby="basic-addon1">
									</div>
								</div>
								<div class="form-group col-md-10">
									<label class="col-md-4  control-label " for="readernumber">读者编号:</label>
									<div class="col-md-8">
										<input name="readernumber" id="modal_readernumber" type="text"
											class="form-control" placeholder="读者编号"
											aria-describedby="basic-addon1" maxlength="20">
									</div>
								</div>
								<div class="form-group col-md-10">
									<label class="col-md-4   control-label" for="statusborrowname">借阅状态:</label>
									<div class="col-md-8">

										<input name="statusborrowname" id="modal_statusborrowname"
											type="text" class="form-control" placeholder="借阅状态"
											aria-describedby="basic-addon1" maxlength="20">
									</div>
								</div>
								<div class="form-group col-md-10">
									<label class="col-md-4  control-label" for="borrowdate">借阅日期:</label>
									<div class="col-md-8">
										<input name="borrowdate" id="modal_borrowdate" type="text"
											class="form-control" placeholder="借阅日期"
											aria-describedby="basic-addon1" maxlength="20">
									</div>
								</div>
								<div class="form-group col-md-10">
									<label class="col-md-4  control-label" for="enddate">归还日期:</label>
									<div class="col-md-8">
										<input name="enddate" id="modal_enddate" type="text"
											class="form-control" placeholder="归还日期"
											aria-describedby="basic-addon1" maxlength="20">
									</div>
								</div>
								<div class="form-group col-md-10">
									<label class="col-md-4  control-label" for="returndate">到期日期:</label>
									<div class="col-md-8">
										<input name="returndate" id="modal_returndate" type="text"
											class="form-control" placeholder="到期日期"
											aria-describedby="basic-addon1" maxlength="20">
									</div>
								</div>
							</form>
						</div>
					</div>
					<!-- 脚部 -->
					<div class="modal-footer">
						<button id="resetButton" type="button" class="btn text-muted"
							style="float: left;">恢复</button>
						<button id="editButton" type="button" class="btn btn-primary" disabled="disabled">编辑</button>
						<button id="closeButton" type="button" class="btn btn-default">关闭</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 确认添加？ -->
	<div class="modal" id="myModalCertain" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" data-backdrop="static"
		data-keyboard="false">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"></button>
					<h4 class="modal-title" id="myModalLabel">
						添加借阅 <span style="color: green" class="glyphicon  glyphicon-alert"></span>
					</h4>
				</div>
				<div class="modal-body">
					<p>是否添加借阅？</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-default" id="certainOk">确定</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 取消添加？ -->
	<div class="modal" id="myModalCancel" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" data-backdrop="static"
		data-keyboard="false">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"></button>
					<h4 class="modal-title" id="myModalLabel">
						取消编辑<span style="color: green" class="glyphicon  glyphicon-alert"></span>
					</h4>
				</div>
				<div class="modal-body">
					<p>内容未保存,是否取消？</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-default" id="cancelOkButtin">确定</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 是否重置？ -->
	<div class="modal" id="myModalReset" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" data-backdrop="static"
		data-keyboard="false">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"></button>
					<h4 class="modal-title" id="myModalLabel">
						内容重置<span style="color: green" class="glyphicon  glyphicon-alert"></span>
					</h4>
				</div>
				<div class="modal-body">
					<p>是否重置内容？</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-default" id="resetOkButtin">确定</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 是否提交？ -->
	<div class="modal" id="myModalSubmit" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" data-backdrop="static"
		data-keyboard="false">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"></button>
					<h4 class="modal-title" id="myModalLabel">
						修改内容<span style="color: green" class="glyphicon  glyphicon-alert"></span>
					</h4>
				</div>
				<div class="modal-body">
					<p>是否保存？</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-default" id="submitOkButtin">确定</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 保存成功？ -->
	<div class="modal" id="myModalSuccess" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"></button>
					<h4 class="modal-title" id="myModalLabel">
						保存成功<span style="color: green" class="glyphicon  glyphicon-ok"></span>
					</h4>
				</div>
				<div class="modal-body">
					<p>借阅信息保存成功</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 保存成功？ -->
	<div class="modal" id="myModalPerFail" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"></button>
					<h4 class="modal-title" id="myModalLabel">
						保存失败<span style="color: green" class="glyphicon  glyphicon-remove"></span>
					</h4>
				</div>
				<div class="modal-body">
					<p>借阅信息保存失败</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 删除借阅？ -->
	<div class="modal" id="myModalDelete" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"></button>
					<h4 class="modal-title" id="myModalLabel">
						删除借阅信息<span style="color: green"
							class="glyphicon  glyphicon-remove"></span>
					</h4>
				</div>
				<div class="modal-body">
					<p>是否删除借阅信息？</p>
					<table style="margin: 0 auto">
						<tr>
							<td>借阅编号:</td>
							<td><span id="deleteBorrowNumber"></span></td>
						</tr>
						<tr>
							<td>图书名:</td>
							<td><span id="deleteTitle"></span></td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-default" id="myModalDeleteOK">删除</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 删除成功？ -->
	<div class="modal" id="myModalDeleteSuccess" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"></button>
					<h4 class="modal-title" id="myModalLabel">
						借阅删除<span style="color: #337ab7" class="glyphicon  glyphicon-ok"></span>
					</h4>
				</div>
				<div class="modal-body">
					<p>删除成功</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 删除失败？ -->
	<div class="modal" id="myModalDeleteFail" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"></button>
					<h4 class="modal-title" id="myModalLabel">
						借阅删除<span style="color: red" class="glyphicon  glyphicon-remove"></span>
					</h4>
				</div>
				<div class="modal-body">
					<p>删除失败</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 未归还图书删除失败？ -->
	<div class="modal" id="myModalDeletenoreturn" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"></button>
					<h4 class="modal-title" id="myModalLabel">
						借阅删除<span style="color: red" class="glyphicon  glyphicon-remove"></span>
					</h4>
				</div>
				<div class="modal-body">
					<p>存在图书处于未归还状态，删除失败</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 删除借阅？ -->
	<div class="modal" id="myModalDeleteBooks" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"></button>
					<h4 class="modal-title" id="myModalLabel">
						删除借阅信息<span style="color: green"
							class="glyphicon  glyphicon-remove"></span>
					</h4>
				</div>
				<div class="modal-body">
					<p>是否删除借阅信息？</p>
					<div id="div_deletebook" style="margin: o auto"></div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-default"
						id="myModalDeleteBooksOK">删除</button>
				</div>
			</div>
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
<script type="text/javascript">
	//$("#table_table").resizableColumns();
	//创建数组
	var oldBorrow = new Object();
	//改变后的数据
	var newReader = new Object();
	//多选
	var idlist = {};
	function inbootstrapTable() {
		$('#table_table')
				.bootstrapTable(
						{
							url : '${pageContext.request.contextPath}/findBorrowsByText', // 表格数据来源
							//method : 'post',
							pagination : true,//启动分页
							search : true,
							pageSize : 10,//初始页记录数
							pageList : [ 5, 10, 15, 20 ], //记录数可选列表
							showColumns : true,
							showRefresh : true,
							toolbar : '#toolbar',
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
							onDblClickRow : ondouble,
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
									text : params.searchText,
									sortOrder : params.sortOrder,
									sortName : params.sortName,
								// 页码
								};
							},
							queryParamsType : "",
							//服务器分页
							sidePagination : "server",
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
										}
									},
									{
										field : 'borrownumber',
										title : '借阅编号',
										align : "center",
										width : 150
									},
									{
										field : 'title',
										title : '图书名',
										align : "center",
										width : 150,
										formatter : function(value, row, index) {
											//console.log("readername"+row.reader.readername);
											return row.book.title;
										},
									},
									{
										field : 'booknumber',
										title : '图书编号',
										align : "center",
										width : 150
									},
									{
										field : 'readername',
										title : '读者名',
										align : "center",
										width : 150,
										formatter : function(value, row, index) {
											//console.log("readername"+row.reader.readername);
											return row.reader.readername;
										},
									},
									{
										field : 'readernumber',
										title : '读者编号',
										align : "center",
										width : 150
									},
									{
										field : 'statusborrowname',
										title : '借阅状态',
										align : "center",
										width : 150,
										formatter : function(value, row, index) {
											return row.statusborrow.statusborrowname;
										},
									},
									{
										field : 'borrowdate',
										title : '借阅日期',
										align : "center",
										width : 150,
										formatter : function(value, row, index) {
											return timestampToTime(value);
										},
										sortable : true,
									},
									{
										field : 'enddate',
										title : '归还日期',
										align : "center",
										width : 150,
										formatter : function(value, row, index) {
											return timestampToTime(value);
										},
										sortable : true,
									},
									{
										field : 'returndate',
										title : '到期日期',
										align : "center",
										width : 150,
										formatter : function(value, row, index) {
											return timestampToTime(value);
										},
										sortable : true,
									},
							],
							onCheck : function(row, $element) {
								getCheck(row, $element)
							},
							onUncheck : function(row, $element) {
								getCheck(row, $element)
							},
							onRefresh : function() {
								getAllSelect();
							},//刷新前
							onSearch : function(text) {
								search(text);
							},
							onSort : function(name, order) {
								sort(name, order);
							}
						});
	}
	function sort(name, order) {
		var pagesize = $("#table_table").bootstrapTable("getOptions").pageSize;
		var pagenumber = $("#table_table").bootstrapTable("getOptions").pageNumber;
		var sortorder = $("#table_table").bootstrapTable("getOptions").order;
		var sortname = $("#table_table").bootstrapTable("getOptions").sort;
		var text = $("#table_table").bootstrapTable("getOptions").search;
		var path = "findBorrowsBySort";
		var url = '${pageContext.request.contextPath}/' + path;
		//alert(sortname+"  "+text+" "+sortname+" "+pagenumber);
		var data = {
			//当前页
			pageNumber : pagenumber, //每页多少条数据
			pageSize : pagesize,
			sortOrder : sortorder,
			sortName : sortname,
			text : text,
		// 页码
		}
		$('#table_table').bootstrapTable('refresh', {
			url : url,
			//query : data
		});
	}
	function search(text) {
		var pagesize = $("#table_table").bootstrapTable("getOptions").pageSize;
		var pagenumber = $("#table_table").bootstrapTable("getOptions").pageNumber;
		var data = {
			//当前页
			pageNumber : pagenumber, //每页多少条数据
			pageSize : pagesize,
			text : text
		// 页码
		};
		//alert(text);
		var path = "findBorrowsByText";
		var path_2 = "findBorrows"
		var url = '${pageContext.request.contextPath}/' + path;
		var url_2 = '${pageContext.request.contextPath}/' + path_2;
		//$('#table_table').bootstrapTable('refresh', {url: url1,query:data});
		$('#table_table').bootstrapTable('refresh', {
			url : url,
			query : data
		});
	}
	//修改	
	$("#btn_edit")
			.click(
					function() {
						var data = getAllSelect();
						//alert("aaa刚好");
						if (data.length == 1) {
							ondouble(data[0]);
						} else if (data.length == 0) {
							modalHint(
									"无效的借阅信息<span class='glyphicon glyphicon-alert' style='color:green; margin_left:5px'></span>",
									"未选择有效的借阅!");
						} else {
							modalHint(
									"无效的借阅信息<span class='glyphicon glyphicon-remove' style='color:red; margin_left:5px'></span>",
									"不能同时查看多个借阅信息,请选择一个!");
						}
					})
	function modalHint(title, body) {
		$('#myModalhint').modal('show');
		$('#hintTitle').html(title);
		$('#hintBody').text(body);
	}
	//获取多选
	function getAllSelect(options) {
		idlist = $('#table_table').bootstrapTable('getAllSelections');
		var data = $('#table_table').bootstrapTable('getAllSelections');
		return data;
	}
	//删除按钮
	$("#btn_delete")
			.click(
					function() {
						var datas = getAllSelect();
						if (datas.length == 0) {
							$('#myModalhint').modal('show');
							$('#hintBody').text("未选择有效的借阅信息!");
							$('#hintTitle')
									.html(
											"无效的借阅信息<span class='glyphicon glyphicon-alert' style='color:green; margin_left:5px'></span>");
							//alert("未选择");
						} else if(datas.length > 1){
							modalHint(
									"无效的借阅信息<span class='glyphicon glyphicon-remove' style='color:red; margin_left:5px'></span>",
									"不能同时删除多个借阅信息,请选择一个!");
						} else {
							//alert("我选择了");
							$('#myModalDelete').modal('show');
							for (var i = 0; i < datas.length; i++) {
								$("#deleteBorrowNumber").html(datas[i].borrownumber);
								$("#deleteTitle").html(datas[i].book.title);
							//$("#myModalDeleteBooks").modal("show");
							//div_deletebook myModalDeleteBooksOK
							}
						}
					})
	//删除借阅
	$("#myModalDeleteOK").click(function() {
		var datas = getAllSelect();
		for (var i = 0; i < datas.length; i++) {
			statusborrowname=datas[i].statusborrow.statusborrowname
		}
		//alert(statusborrowname);
		if(statusborrowname == "已归还"){
		var path = "deleteBorrow";
		var number = {
				"number" : $("#deleteBorrowNumber").html()
			};
		$.ajax({
			url : '${pageContext.request.contextPath}/' + path, //后台controller中的请求路径
			type : 'POST',
			// async : false,
			datatype : 'text',
			data : number,
			success : function(data) {
				$("#myModalDelete").modal('hide');
				//alert(data);
				if (data == 0) {
					//alert("删除失败!");
					$('#myModalDeleteFail').modal('show');
					//$('#table_table').bootstrapTable('refresh');
					//alert("zheli ?")
				} else {
					//alert("删除成功!");
					//$("#myModalDelete").modal('hide');
					$('#myModalDeleteSuccess').modal('show');
					$('#table_table').bootstrapTable('refresh');
					//alert("ok ?")
				}
			},
			error : function(error) {
				$("#myModalDelete").modal('hide');
				$('#myModalDeleteExit').modal('show');
				//$('#table_table').bootstrapTable('refresh');
				//alert("error ?")
			}
		});}else{
			$('#myModalDeletenoreturn').modal('show');
		}
	})
	function getCheck(row, $element) {
	}
	$('#myModalDeleteBooks').on('hide.bs.modal', function() {
		$("#div_deletebook").empty();
	})
	$('#myModalDeleteBooks').on('hide.bs.modal', function() {
		$("#hintBody").empty();
		$("#hintTitle").empty();
	})
	//编辑按钮
	$("#editButton").click(function() {
		//是否是编辑状态
		if ($("#editButton").hasClass('btn-warning')) {
			getNewBook();
			var isTure = isBeUpdate();
			if (isTure) {
				//alert("内容没有被修改");
				//alert("我走了true");
				switchShowBook();
			} else {
				//alert("zhend ecuode");
				$('#myModalCancel').modal('show');
			}
		} else {
			//切换到编辑状态
			//打开是否添加模态框
			switchEditBook();
		}
	});
	//切换到查看的时候的界面
	function switchShowBook() {
		//改变按钮的背景色
		$("#editButton").attr("class", "btn btn-primary");
		$("#resetButton").attr("class", "btn text-muted");
		$("#closeButton").attr("class", "btn btn-default");
		//改变文字
		$("#editButton").text("编辑");
		$("#closeButton").text("关闭");
		//显示文字为空
		$("#span_edit").text("");
		//重置按钮不可按
		//$("#resetButton").attr('disabled', 'disabled');
		noEdit();
	}
	//编辑状态
	function switchEditBook() {
		//正在编辑
		//改变按钮的背景色
		$("#editButton").attr("class", "btn btn-warning");
		$("#resetButton").attr("class", "btn btn-default");
		$("#closeButton").attr("class", "btn btn-primary");
		//改变文字
		$("#editButton").text("取消");
		$("#closeButton").text("保存");
		$("#span_edit").text(" --编辑中--");
		//$("#resetButton").removeAttr("disabled");
		enableEdit();
	}
	//关闭按钮
	$("#closeButton").click(function() {
		var text = $("#closeButton").text();
		//alert(text);
		if (text == "保存") {
			$('#myModalSubmit').modal('show');
			//alert("woyao提交");
		} else {
			$('#myModalEdit').modal('hide');
		}
	});
	//获取修改后的内容
	function getNewBook() {
		newReaderData();
	}
	function isBeUpdate() {
		var tag = true;
		//val tag = 0;
		//readernumber;readername;registrationdate;expirationdays;readerstatusnumber;password;readertypenumber;enddate;
		var book = [ "readernumber", "readername", "registrationdate",
				"expirationdays", "readerstatusnumber", "password",
				"readertypenumber", "enddate" ];
		$.each(book, function(index, value) {
			// alert(index+"..."+newReader[value]);
			if (oldBorrow[value] != newReader[value]) {
				// alert(value+"  , "+oldBorrow[value] +" 不等于  "+newReader[value]);
				tag = false;
				return false;
			}
		});
		return tag
	}
	//提交按钮
	$("#submitOkButtin").click(function() {
		//alert("我正在提交");
		$('#myModalSubmit').modal('hide');
		$('#myModalEdit').css({
			'overflow-y' : 'scroll'
		});
		getNewBook();
		var isTure = isBeUpdate();
		if (isTure) {
			$('#myModalSuccess').modal('show');
		} else {
			//alert("内容被修改");
			$('#edit_table').data('bootstrapValidator').validate();
			var flag = $("form").data("bootstrapValidator").isValid();//校验合格
			//alert(flag);
			if (flag) {
				var path = "updateReader";
				$.ajax({
					url : '${pageContext.request.contextPath}/' + path, //后台controller中的请求路径
					type : 'POST',
					// async : false,
					datatype : 'json',
					data : $("#edit_table").serialize(),
					success : function(data) {
						//alert(data);
						if (data == 0) {
							//myModalPerFail
							//alert("保存失败");
							$('#myModalPerFail').modal('show');
						} else {
							//alert("保存成功");
							$('#myModalSuccess').modal('show');
							//"myModalSuccess" modal-header h4 modal-body modal-body glyphicon-ok
						}
					},
					error : function() {
						$('#myModalPerFail').modal('show');
					}
				})
				$('#edit_table').data("bootstrapValidator").resetForm();
			}
		}
	});
	//重置按钮
	$("#resetButton").click(function() {
		$('#myModalReset').modal('show');
		//resetToOldBook();
	});
	//确定取消
	$("#certainOk").click(function() {
		resetToOldBook();
		switchShowBook();
		$('#myModalEdit').css({
			'overflow-y' : 'scroll'
		});
	});
	//确定重置按钮
	$("#resetOkButtin").click(function() {
		resetToOldBook();
		$('#myModalReset').modal('hide');
		$('#myModalEdit').css({
			'overflow-y' : 'scroll'
		});
	});
	//hide模态框
	$('#myModalEdit').on('hide.bs.modal', function() {
		switchShowBook();
		//重置验证
		$('#edit_table').data("bootstrapValidator").resetForm();
		$('#table_table').bootstrapTable('refresh');
	})
	//保存成功
	$('#myModalSuccess').on('hide.bs.modal', function() {
		//切换到不可编辑状态
		switchShowBook();
	})
	//重置
	function resetToOldBook() {
		$("#modal_readernumber").val(oldBorrow.readernumber);
		$("#modal_readername").val(oldBorrow.readername);
		$("#modal_expirationdays").val(oldBorrow.expirationdays);
		$("#modal_password").val(oldBorrow.password);
		$("#modal_readertypenumber").val(oldBorrow.readertypenumber);
		$("#modal_readerstatusnumber").val(oldBorrow.readerstatusnumber);
		$("#modal_registrationdate").val(timestampToTime(oldBorrow.registrationdate));
		//$("#seClassification").val(row.seclassification);
		$("#modal_enddate").val(timestampToTime(oldBorrow.enddate));
		//选择框刷新
		$("#modal_readertypenumber").selectpicker('refresh');
		$("#modal_readerstatusnumber").selectpicker('refresh');
		//重置验证
		$('#edit_table').data("bootstrapValidator").resetForm();
	}
	//获取新数组的数据
	function newReaderData() {
		newReader.readernumber = $("#modal_readernumber").val();
		newReader.readername = $("#modal_readername").val();
		newReader.expirationdays = $("#modal_expirationdays").val();
		newReader.password = $("#modal_password").val();
		newReader.readertypenumber = $("#modal_readertypenumber").val();
		newReader.readerstatusnumber = $("#modal_readerstatusnumber").val();
		newReader.registrationdate = $("#modal_registrationdate").val();
		newReader.enddate = $("#modal_enddate").val();
	}
	//取消编辑的确定按钮
	$("#cancelOkButtin").click(function() {
		//重置
		resetToOldBook();
		//查看界面
		switchShowBook();
		$('#myModalCancel').modal('hide');
		$('#myModalEdit').css({
			'overflow-y' : 'scroll'
		});
	})
	function initModelButton() {
		noEdit();
	}
	//获取参数
	//给所有的input添加不可编辑
	function noEdit() {
		$("#resetButton").attr('disabled', true);
		$('#div_addBook').find('input').attr('readonly', true);
		$('#div_addBook').find('textarea').attr('readonly', true);
		$('#div_addBook').find('select').attr('disabled', "disabled");
		//添加disable样式
		$('.bootstrap-select').find('button').addClass('disabled');
	}
	function enableEdit() {
		$("#resetButton").removeAttr('disabled');
		$('#div_addBook').find('select').removeAttr("disabled");
		$('#div_addBook').find('input').attr('readonly', false);
		$('.disabled').removeClass("disabled");
		$('#div_addBook').find('textarea').attr('readonly', false);
		$('#div_addBook').find('#modal_readernumber').attr('readonly', true);
		$('#div_addBook').find('#modal_readernumber').attr('readonly', true);
		$('#div_addBook').find('#modal_registrationdate').attr('readonly', true);
		$('#div_addBook').find('#modal_enddate').attr('readonly', true);
		$('#div_addBook').find('#modal_password').attr('readonly', true);
	}
	//双击
	function ondouble(row, $element, field) {
		//readernumber;readername;registrationdate;expirationdays;readerstatusnumber;password;readertypenumber;enddate;
		oldBorrow.borrownumber=row.borrownumber;
		oldBorrow.title=row.book.title;
		oldBorrow.booknumber=row.book.booknumber;
		oldBorrow.readername=row.reader.readername;
		oldBorrow.readernumber=row.reader.readernumber;
		oldBorrow.isbn=row.book.isbn;
		oldBorrow.statusborrowname=row.statusborrow.statusborrowname;
		oldBorrow.borrowdate=row.borrowdate;
		oldBorrow.enddate=row.enddate;
		oldBorrow.returndate=row.returndate;
		$('#myModalEdit').modal('show');
		$("#modal_borrownumber").val(oldBorrow.borrownumber);
		$("#modal_title").val(oldBorrow.title);
		$("#modal_booknumber").val(oldBorrow.booknumber);
		$("#modal_readername").val(oldBorrow.readername);
		$("#modal_readernumber").val(oldBorrow.readernumber);
		$("#modal_isbn").val(oldBorrow.isbn);
		$("#modal_statusborrowname").val(oldBorrow.statusborrowname);
		$("#modal_borrowdate").val(timestampToTime(row.borrowdate));
		$("#modal_enddate").val(timestampToTime(row.enddate));
		$("#modal_returndate").val(timestampToTime(row.returndate));
	}
	//表格中增加按钮
	function addFunctionAlty(value, row, index) {
		/*
		return "<button class=\"btn btn-warning edit\" onclick=\"update('" + value
				+ "')\"> 修改 </button>" + "&nbsp;&nbsp;"
				+ "<button class=\"btn btn-danger del\" onclick=\"delete('" + value
				+ "')\"> 删除 </button>";*/
		return [
				'<a type="button" class="edit btn btn-warning" style="margin-right:5px">编辑</a>',
				'<a type="button" class="del btn btn-danger" >删除</a>' ]
				.join('');
	}
	//给按钮注册事件
	window.operateEvents = {
		"click .edit" : function(e, value, row, index) {
			//alert("编辑了caseId是："+row.caseId)
			ondouble(row);
		},
		"click .del" : function(e, value, row, index) {
			$('#myModalDelete').modal('show');
			$("#deleteBorrowNumber").html(row.borrownumber);
			$("#deleteTitle").html(row.book.title);
			//alert(row.borrownumber);
			//$(this).parent().parent().remove();
		}
	}
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
	//模态框居中
	$('#myModalReset').on('show.bs.modal', function(e) {
		modalCenter("#myModalReset");
	})
	$('#myModalCertain').on('show.bs.modal', function(e) {
		modalCenter("#myModalCertain");
	})
	$('#myModalCancel').on('show.bs.modal', function(e) {
		modalCenter("#myModalCancel");
	})
	$('#myModalSubmit').on('show.bs.modal', function(e) {
		modalCenter("#myModalSubmit");
	})
	$('#myModalSuccess').on('show.bs.modal', function(e) {
		modalCenter("#myModalSuccess");
	})
	$('#myModalPerFail').on('show.bs.modal', function(e) {
		modalCenter("#myModalPerFail");
	})
	$('#myModalDelete').on('show.bs.modal', function(e) {
		modalCenter("#myModalDelete");
	})
	$('#myModalDeleteSuccess').on('show.bs.modal', function(e) {
		modalCenter("#myModalDeleteSuccess");
	})
	$('#myModalDeleteFail').on('show.bs.modal', function(e) {
		modalCenter("#myModalDeleteFail");
	})
	$('#myModalDeletenoreturn').on('show.bs.modal', function(e) {
		modalCenter("#myModalDeletenoreturn");
	})
	$('#myModalDeleteBooks').on('show.bs.modal', function(e) {
		modalCenter("#myModalDeleteBooks");
	})
	$('#myModalhint').on('show.bs.modal', function(e) {
		modalCenter("#myModalhint");
	})
	//jq初始化
	$(function() {
		//表格初始化
		inbootstrapTable();
		$(window).resize(function() {
			$('#table_table').bootstrapTable('resetView');
		});
		//表格高度
		$(".fixed-table-container").css("height",
				window.parent.innerHeight - 325);
	})
	//表格超出宽度鼠标悬停显示td内容
	function paramsMatter(value, row, index, field) {
		var span = document.createElement('span');
		span.setAttribute('title', value);
		span.innerHTML = value;
		//$('#myModalEdit').modal('show');
		return span.outerHTML;
	}
	//将时间戳转化为日期
	function timestampToTime(timestamp) {
		var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
		Y = date.getFullYear();
		M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date
				.getMonth() + 1)
				+ '-';
		D = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate())
				+ ' ';
		h = (date.getHours() < 10 ? '0' + (date.getHours()) : date.getHours())
				+ ':';
		m = (date.getMinutes() < 10 ? '0' + (date.getMinutes()) : date
				.getMinutes())
				+ ':';
		s = (date.getSeconds() < 10 ? '0' + (date.getSeconds()) : date
				.getSeconds());
		if (Y <= 10) {
			var time = "";
		} else {
			time = Y + "-" + M + D;
		}
		return time;
	}
	//转化为年份
	function timestampToYear(timestamp) {
		var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
		Y = date.getFullYear();
		return Y;
	}
	$(function() {
		//时间日期控件初始化
		$('#datetimepicker1').datetimepicker({
			//新的
			format : 'YYYY-MM-DD',
			locale : moment.locale('zh-cn'),
			//showClear:false,
			minDate : '1990-7-1',
			maxDate : new Date()
		});
		$('#datetimepicker2').datetimepicker({
			//新的
			format : 'YYYY-MM-DD',
			locale : moment.locale('zh-cn'),
			//showClear:false,
			minDate : '1990-7-1',
			maxDate : new Date()
		});
		//年份的select框
		addYear("#publishYear");
		//model按钮初始化
		initModelButton();
		//input只输入数字
		//移动列宽
	});
	function getSelectType(url, number, id, keyOne, keyTwo) {
		$(id).selectpicker({
			noneSelectedText : '--请选择--', //默认显示内容
		});
		$.ajax({
			url : '${pageContext.request.contextPath}/' + url, //后台controller中的请求路径
			type : 'POST',
			// async : false,
			datatype : 'json',
			success : function(data) {
				$(id).empty();//每次点击按钮清空原来数据，防止无限加载。

				if (data) {
					for ( var p in data) {//遍历json数组时，这么写p为索引，0,1
						//valueone=data[p]+'.'+valueone
						$(id).append(
								"<option value ='"
								+ data[p][keyOne] + "'>"
										+ data[p][keyTwo] + "</option>");
					}
					//刷新和展示
					$(id).selectpicker('refresh');
					$(id).val(number);
					$(id).selectpicker('refresh');
					$(id).selectpicker('show');
				}
			},
			error : function() {
				alert('查询借阅流通类别错误');
			}
		});
	}
	//分类的select
	function getSelectTypeTwo(url, number, id, keyOne, keyTwo, keyThree) {
		$(id).selectpicker({
			noneSelectedText : '--请选择--', //默认显示内容
		});
		$.ajax({
			url : '${pageContext.request.contextPath}/' + url, //后台controller中的请求路径
			type : 'POST',
			// async : false,
			datatype : 'json',
			success : function(data) {
				$(id).empty();//每次点击按钮清空原来数据，防止无限加载。
				if (data) {
					for ( var p in data) {//遍历json数组时，这么写p为索引，0,1
						//valueone=data[p]+'.'+valueone
						$(id).append(
								"<option value ='"
								+ data[p][keyOne] + "'>"
										+ data[p][keyThree].toLocaleUpperCase()
										+ " " + data[p][keyTwo] + "</option>");
					}
					//刷新和展示
					$(id).selectpicker('refresh');
					$(id).val(number);
					$(id).selectpicker('refresh');
					$(id).selectpicker('show');
				}
			},
			error : function() {
				alert('查询借阅错误');
			}
		});
	}
	//出版年份
	function addYear(id) {
		j = parseInt(new Date().getFullYear());
		for (var i = j; i > 1800; i--) {
			$(id).append("<option value ='"
					+ i + "'>" + i + "</option>");
		}
	}
	//借阅次数--数字验证
	function checkNum(val) {
		$('#borrowTimes').val(val >= 0 ? val : 0);
		$('#edit_table').data("bootstrapValidator").revalidateField(
				'borrowtimes');//重新验证
		//重置验证
		//$('#edit_table').data("bootstrapValidator").resetForm();
		//$('#edit_table').data('bootstrapValidator').validate() ;//使验证生效;
		//$('#edit_table').data("bootstrapValidator").enableFieldValidators('borrowtimes', false);
		//$('#edit_table').data("bootstrapValidator").enableFieldValidators('borrowtimes', true);
		//$('#edit_table').data("bootstrapValidator").validateField('borrowtimes', true, 'regexp');
	}
	//表单验证
	$('#edit_table').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			isbn : {
				validators : {
					notEmpty : {
						message : 'ISBN不能为空'
					},
					stringLength : {
						min : 11,
						max : 13,
						message : 'ISBN的长度为11位或者13位'
					},
					digits : {
						message : 'ISBN只能输入数字'
					}
				}
			},
			title : {
				validators : {
					notEmpty : {
						message : '图书名不能为空'
					},
				}
			},
			author : {
				validators : {
					notEmpty : {
						message : '作者不能为空'
					},
				}
			},
			borrowtimes : {
				validators : {
					notEmpty : {
						message : '借出次数不能为空'
					},
					regexp : {
						regexp : /^\d+$/,
						message : '借出次数只能为0或者正整数'
					}
				}
			},
		},
	}).on('success.form.bv', function(e) {//点击提交之后
	});
	$("#edit_table").data('bootstrapValidator').updateStatus('borrowtimes',
			'NOT_VALIDATED').validateField('borrowtimes');
</script>
</html>