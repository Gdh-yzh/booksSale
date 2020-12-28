<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>图书管理</title>
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
		<button id="btn_delete" type="button" class="btn btn-danger">
			<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>批量删除
		</button>
	</div>
	<!-- Modal -->
	<div class="modal fade " id="myModalEdit" tabindex="-1" role="dialog"
		aria-labelledby="myModalEditLabel" data-backdrop="static"
		data-keyboard="false">
		<div class="modal-dialog modal-lg" role="document"
			style="width: 750px">
			<div class="modal-content">
				<!--头部 -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalEditLabel">
							修改<span style="color: green" class="glyphicon  glyphicon-alert"></span>
							<span class="text-info" id="span_edit"
							style="font-size: 14px;"></span>
					</h4>
				</div>
				<!-- 内容1 -->
				<div class="modal-body">
					<div id="div_addBook" class="container-fluid">
						<div class="col-md-12">
							<form class="form-horizontal" id="edit_table" method="post"
								role="form">
								<div class="col-md-12">
									<a class="text-primary">图书信息</a>
								</div>
								<div class="col-md-6">
									<div class="form-group col-md-12">
										<label class="col-md-4  control-label" for="booknumber">图书编号:</label>
										<div class="col-md-8 ">
											<input name="booknumber" id="bookNumber" type="text"
												class="form-control " placeholder="图书编号"
												aria-describedby="basic-addon1" readonly="readonly">
										</div>
									</div>
									<div class="form-group col-md-12">
										<label class="col-md-4  control-label" for="isbn">*ISBN:</label>
										<div class="col-md-8">
											<input name="isbn" id="ISBN" type="text"
												class="form-control " placeholder="ISBN"
												aria-describedby="basic-addon1">
										</div>
									</div>
									<div class="form-group col-md-12">
										<label class="col-md-4 control-label" for="title">*图书名:</label>
										<div class="col-md-8">
											<input name="title" id="title" type="text"
												class="form-control" placeholder="图书名"
												aria-describedby="basic-addon1" maxlength="20">
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group col-md-6">
										<label class="col-md-4   control-label" for="author">*作者:</label>
										<div class="col-md-8">
											<input name="author" id="author" type="text"
												class="form-control" placeholder="作者"
												aria-describedby="basic-addon1" maxlength="40">
										</div>
									</div>
									<div class="form-group col-md-6">
										<label class="col-md-4  control-label " for="translator">译者:</label>
										<div class="col-md-8">
											<input name="translator" id="translator" type="text"
												class="form-control" placeholder="译者"
												aria-describedby="basic-addon1" maxlength="40">
										</div>
									</div>
									<div class="form-group col-md-6">
										<label class="col-md-4  control-label"
											for="publishhousenumber ">出版社:</label>
										<div class="col-md-8">
											<select name="publishhousenumber"
												class="selectpicker form-control" id="publishHouseName"></select>
										</div>
									</div>
									<div class="form-group col-md-6">
										<label class="col-md-4  control-label" for="publishyear">出版年份:</label>
										<div class="col-md-8">
											<select name="publishyear" class="selectpicker form-control"
												id="publishYear"></select>
										</div>
									</div>
									<div class="col-md-12">
										<hr style="border-top: 1px dashed #CCC" />
									</div>
								</div>
								<div class="col-md-12">
									<a class="text-primary">馆藏信息</a>
								</div>
								<div class="form-group col-md-6">
									<label class="col-md-4  control-label" for="callnumber">索书号:</label>
									<div class="col-md-8">
										<input name="callnumber" id="callNumber" type="text"
											class="form-control" placeholder="索书号"
											aria-describedby="basic-addon1" maxlength="40">
									</div>
								</div>
								<div class="form-group col-md-6">
									<label class="col-md-4  control-label" for="typebookCfnumber">*图书类型:</label>
									<div class="col-md-8">
										<select name="typebookCfnumber"
											class="selectpicker form-control" id="typeBook_CFName"></select>
									</div>
								</div>
								<div class="form-group col-md-6">
									<label class="col-md-4  control-label " for="borrowtimes">借出次数:</label>
									<div class="col-md-8">
										<input name="borrowtimes" id="borrowTimes" type="number"
											class="form-control" placeholder="借出次数" maxlength="8"
											aria-describedby="basic-addon1" maxlength="40"
											onchange="checkNum(this.value)">
									</div>
								</div>
								<div class="form-group col-md-6">
									<label class="col-md-4  control-label"
										for="classificationnumber">*图书分类:</label>
									<div class="col-md-8">
										<select name="classificationnumber"
											class="selectpicker form-control" id="classificationType"></select>
									</div>
								</div>
								<div class="form-group col-md-6">
									<label class="col-md-4  control-label"
										for="typecirculationnumber">*流通分类:</label>

									<div class="col-md-8">
										<select name="typecirculationnumber"
											class="selectpicker form-control" id="typeCirculationName"></select>
									</div>
								</div>
								<div class="form-group col-md-6">
									<label class="col-md-4 control-label" for="bookstatusnumber">*图书状态:</label>
									<div class="col-md-8">
										<select name="bookstatusnumber"
											class="selectpicker form-control" id="bookStatus"></select>
									</div>
								</div>
								<div class="form-group col-md-6">
									<label class="col-md-4 control-label" for="entrydate">*入库日期:</label>
									<!--指定 date标记-->
									<div class="col-md-8">
										<div class='input-group date' id='datetimepicker1'>
											<input type='text' name="entrydate" class="form-control"
												id="entryDate" /> <span class="input-group-addon"> <span
												class="glyphicon glyphicon-calendar"></span>
											</span>
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<label for="summary">简介:</label>
								</div>
								<div class="col-md-12">
									<textarea rows="2" name="summary" id="summary"
										class="form-control"></textarea>
								</div>
								<div class="col-md-12">
									<input name="publishhousename" id="publishhousename"
										type="hidden"> <input name="typecirculationname"
										id="typecirculationname" type="hidden"> <input
										name="bookstatus" id="bookstatus" type="hidden"> <input
										name="typebookcfname" id="typebookcfname" type="hidden">
									<input name="classificationtype" id="classificationtype"
										type="hidden">
								</div>
							</form>
						</div>
					</div>
				</div>
				<!-- 脚部 -->
				<div class="modal-footer">
					<button id="resetButton" type="button" class="btn text-muted"
						style="float: left;">恢复</button>
					<button id="editButton" type="button" class="btn btn-primary">编辑</button>
					<button id="closeButton" type="button" class="btn btn-default">关闭</button>
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
						添加图书 <span style="color: green" class="glyphicon  glyphicon-alert"></span>
					</h4>
				</div>
				<div class="modal-body">
					<p>是否添加图书？</p>
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
					<p>图书信息保存成功</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 保存失败？ -->
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
					<p>图书信息保存失败</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 删除图书？ -->
	<div class="modal" id="myModalDelete" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"></button>
					<h4 class="modal-title" id="myModalLabel">
						删除图书信息<span style="color: green"
							class="glyphicon  glyphicon-remove"></span>
					</h4>
				</div>
				<div class="modal-body">
					<p>是否删除图书？</p>
					<table style="margin: 0 auto">
						<tr>
							<td>ISBN:</td>
							<td><span id="deleteISBN"></span></td>
						</tr>
						<tr>
							<td>图书编号:</td>
							<td><span id="deleteBookNumber"></span></td>
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
						图书删除<span style="color: #337ab7" class="glyphicon  glyphicon-ok"></span>
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
						图书删除<span style="color: red" class="glyphicon  glyphicon-remove"></span>
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
	<!-- 存在借阅记录？ -->
	<div class="modal" id="myModalDeleteExit" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"></button>
					<h4 class="modal-title" id="myModalLabel">
						图书删除<span style="color: red" class="glyphicon  glyphicon-remove"></span>
					</h4>
				</div>
				<div class="modal-body">
					<p>警告：图书存在借阅记录无法删除，请先到借阅管理界面删除相应借阅记录</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 删除一些图书？ -->
	<div class="modal" id="myModalDeleteBooks" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"></button>
					<h4 class="modal-title" id="myModalLabel">
						删除图书信息<span style="color: green"
							class="glyphicon  glyphicon-remove"></span>
					</h4>
				</div>
				<div class="modal-body">
					<p>是否删除图书？</p>
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
	var oldBook = new Object();
	//改变后的数据
	var newBook = new Object();
	//多选
	var idlist = {};
	function inbootstrapTable() {
		/*
		 $("#table_table").colResizable({
			 liveDrag:true,//拖动列时更新表布局
	            gripInnerHtml:"<div class='grip'></div>",
	            draggingClass:"dragging",
	            resizeMode:'overflow'//允许溢出父容器
		    });		
		*/
		$('#table_table')
				.bootstrapTable(
						{
							url : '${pageContext.request.contextPath}/findBooksByText', // 表格数据来源
							//method : 'post',
							pagination : true,//启动分页
							search : true,
							pageSize : 5,//初始页记录数
							pageList : [5, 10, 15, 20], //记录数可选列表
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
							resizable:false,//移动列宽
							queryParams : function(params) {
								//getParams(params);
								//alert(params.search);
								//alert(params.sort);
								return {
									//当前页
									pageNumber : params.pageNumber, //每页多少条数据
									pageSize : params.pageSize,
									text : params.searchText,
									sortOrder:params.sortOrder,
									sortName:params.sortName,					
								// 页码
								};
							},
							queryParamsType : "",
							//服务器分页
							sidePagination : "server",
							contentType : "application/x-www-form-urlencoded",
							dataType: "json", 
							responseHandler: function (res) {
								//alert(res.rows[1].ClassificationBook);					   
							    return{   
							    	//return bootstrap-table能处理的数据格式 classificationtype publishhousename
							    	"total":res.total,
							    	"rows":res.rows,
							    }},
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
										field : 'booknumber',
										title : '图书编号',
										align : "center",
										width : 150
									},
									{
										field : 'isbn',
										title : 'ISBN',
										align : "center",
										width : 150
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
										field : 'publishhousename',
										title : '出版社',
										align : "center",
										width : 150,
										formatter : function(value, row, index) {
											//alert(row);
											return row.publishhouse.publishhousename;
										},								
									},
									{
										field : 'summary',
										title : '简介',
										align : 'center',
										width : 150,
										formatter : 'paramsMatter'
									},
									{
										field : 'callnumber',
										title : '索书号',
										align : "center",
										width : 100
									},
									{
										field : 'imglocation',
										title : '图片位置',
										align : "center",
										visible : false,
										width : 50
									},
									{
										field : 'classificationtype',
										title : '图书分类',
										align : "center",
										width : 100,
										formatter : function(value, row, index) {
											//alert(row);
											return row.classificationBook.classificationletter.toLocaleUpperCase()+" "+row.classificationBook.classificationtype;
										},										
									},
									{
										field : 'seclassification',
										title : '二级分类',
										align : "center",
										width : 100,
										visible : false,										
									},
									{
										field : 'typecirculationname',
										title : '流通分类',
										align : "center",
										width : 100,
										formatter : function(value, row, index) {
											//alert(row);
											return row.typecirculationBook.typecirculationname;
										},
									},
									{
										field : 'borrowtimes',
										title : '借出次数',
										align : "center",
										width : 100,
										sortable : true,
									},
									{
										field : 'bookstatus',
										title : '图书状态',
										align : "center",
										width : 100,
										formatter : function(value, row, index) {
											//alert(row);
											console.log("我在这里:"+row.translator+",图书状态:"+row.classificationBook.classificationtype+";typebookCf:"+row.typecirculationBook.typecirculationname);
											return row.statusBook.bookstatus;
										},
									},
									{
										field : 'entrydate',
										title : '入库日期',
										align : "center",
										width : 150,
										formatter : function(value, row, index) {
											return timestampToTime(value);
										},
										sortable : true,
									},
									{
										field : 'publishyear',
										title : '出版年份',
										align : "center",
										width : 100,
										sortable : true,
										formatter : function(value, row, index) {
											return timestampToYear(value);
										},
									}, {
										field : 'typebookcfname',
										title : '图书类型',
										align : "center",
										width : 100,
										formatter : function(value, row, index) {
											//alert(row);
											return row.typebookCf.typebookCfname;
										},										
									}, {
										field : 'typecirculationnumber',
										title : '流通分类编号',
										align : "center",
										width : 150,
										visible : false,
									}, {
										field : 'classificationnumber',
										title : '图书分类编号',
										align : "center",
										width : 150,
										visible : false,
									}, {
										field : 'bookstatusnumber',
										title : '图书状态编号',
										align : "center",
										width : 150,
										visible : false,
									}, {
										field : 'typebookCfnumber',
										title : '图书类型编号',
										align : "center",
										width : 150,
										visible : false,
									}, {
										field : 'publishhousenumber',
										title : '出版社编号',
										align : "center",
										width : 150,
										visible : false,
									}, {
										field : 'operate',
										title : '操作',
										align : "center",
										width : 150,
										events : operateEvents,//给按钮注册事件
										formatter : addFunctionAlty
									//表格中增加按钮  
									} ],
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
		var path = "findBooksBySort";
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
		var path = "findBooksByText";
		var path_2 = "findBooks"
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
									"无效的图书信息<span class='glyphicon glyphicon-alert' style='color:green; margin_left:5px'></span>",
									"未选择有效的图书!");
						} else {
							modalHint(
									"无效的图书信息<span class='glyphicon glyphicon-remove' style='color:red; margin_left:5px'></span>",
									"不能同时修改多个图书信息,请选择一个!");
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
							$('#hintBody').text("未选择有效的图书!");
							$('#hintTitle')
									.html(
											"无效的图书信息<span class='glyphicon glyphicon-alert' style='color:green; margin_left:5px'></span>");
							//alert("未选择");
						} else {
							//alert("我选择了");
							$('#myModalDeleteBooks').modal('show');
							//$("#myModalDeleteBooks").modal("show");
							//div_deletebook myModalDeleteBooksOK
							for (var i = 0; i < datas.length; i++) {
								$("#div_deletebook").append(
										"<p>" + "ISBN:" + datas[i].isbn + "</p>" +
										"<p>" + "图书名:" + datas[i].title
												+ "</p>");
							}
						}
					})
	$("#myModalDeleteBooksOK").click(function() {
		var path = "deleteBooks";
		var datas = getAllSelect();
		var dataBookNumbers = [];
		for (var i = 0; i < idlist.length; i++) {
			dataBookNumbers[i] = datas[i].booknumber;
			//alert(idlist[i].booknumber);
		}
		$.ajax({
			url : '${pageContext.request.contextPath}/' + path, //后台controller中的请求路径
			type : 'POST',
			// async : false,
			data : JSON.stringify(dataBookNumbers),
			dataType : 'json',
			contentType : 'application/json',
			success : function(data) {
				//$("#myModalDelete").modal('hide');
				$('#myModalDeleteBooks').modal('hide');
				//alert(data);
				if (data == 0) {
					$("#myModalDeleteFail").modal('show');
				} else {
					$('#myModalDeleteSuccess').modal('show');
					$('#table_table').bootstrapTable('refresh');
				}
			},
			error : function(error) {
				$('#myModalDeleteBooks').modal('hide');
				$("#myModalDeleteExit").modal('show');
			}
		});
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
		newBook.booknumber = $("#bookNumber").val();
		newBook.ISBN = $("#ISBN").val();
		newBook.title = $("#title").val();
		newBook.author = $("#author").val();
		newBook.translator = $("#translator").val();
		newBook.summary = $("#summary").val();
		newBook.callNumber = $("#callNumber").val();
		//$("#seClassification").val(row.seclassification);
		newBook.borrowTimes = $("#borrowTimes").val();
		newBook.entryDate = $("#entryDate").val();
		newBook.publishYear = $("#publishYear").val();
		newBook.typecirculationnumber = $("#typeCirculationName").val();
		newBook.classificationnumber = $("#classificationType").val();
		newBook.publishhousenumber = $("#publishHouseName").val();
		newBook.typebookcfnumber = $("#typeBook_CFName").val();
		newBook.bookstatusnumber = $("#bookStatus").val();
	}
	function isBeUpdate() {
		var tag = true;
		//val tag = 0;
		//alert(oldBook.booknumber+"...."+newBook.booknumber);
		var book = [ "booknumber", "ISBN", "title", "author", "translator",
				"summary", "callNumber", "borrowTimes", "entryDate",
				"publishYear", "typecirculationnumber", "classificationnumber",
				"publishhousenumber", "typebookcfnumber", "bookstatusnumber" ];
		$.each(book, function(index, value) {
			// alert(index+"..."+newBook[value]);
			if (oldBook[value] != newBook[value]) {
				// alert(value+"  , "+oldBook[value] +" 不等于  "+newBook[value]);
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
				var path = "updateBook";
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
		$("#bookNumber").val(oldBook.booknumber);
		$("#ISBN").val(oldBook.ISBN);
		$("#title").val(oldBook.title);
		$("#author").val(oldBook.author);
		$("#translator").val(oldBook.translator);
		$("#summary").val(oldBook.summary);
		$("#callNumber").val(oldBook.callNumber);
		//$("#seClassification").val(row.seclassification);
		$("#borrowTimes").val(oldBook.borrowTimes);
		$("#entryDate").val(timestampToTime(oldBook.entryDate));
		$("#publishYear").val(oldBook.publishYear);
		$("#typeCirculationName").val(oldBook.typecirculationnumber);
		$("#classificationType").val(oldBook.classificationnumber);
		$("#publishHouseName").val(oldBook.publishhousenumber);
		$("#bookStatus").val(oldBook.typebookcfnumber);
		$("#typeBook_CFName").val(oldBook.bookstatusnumber);
		//选择框刷新
		$("#publishYear").selectpicker('refresh');
		$("#typeCirculationName").selectpicker('refresh');
		$("#classificationType").selectpicker('refresh');
		$("#publishHouseName").selectpicker('refresh');
		$("#bookStatus").selectpicker('refresh');
		$("#typeBook_CFName").selectpicker('refresh');
		//重置验证
		$('#edit_table').data("bootstrapValidator").resetForm();
	}
	//获取新数组的数据
	function newBookData() {
		newBook.booknumber = $("#bookNumber").val();
		newBook.ISBN = $("#ISBN").val();
		newBook.title = $("#title").val();
		newBook.author = $("#author").val();
		newBook.translator = $("#translator").val();
		newBook.summary = $("#summary").val();
		newBook.callNumber = $("#callNumber").val();
		newBook.borrowTimes = $("#borrowTimes").val();
		newBook.entryDate = $("#entryDate").val();
		newBook.publishYear = $("#publishYear").val();
		newBook.typecirculationnumber = $("#typeCirculationName").val();
		newBook.classificationnumber = $("#classificationType").val();
		newBook.publishhousenumber = $("#publishHouseName").val();
		newBook.typebookcfnumber = $("#bookStatus").val();
		newBook.bookstatusnumber = $("#typeBook_CFName").val();
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
		$('#div_addBook').find('#bookNumber').attr('readonly', true);
		$('#div_addBook').find('#entryDate').attr('readonly', true);
		$('#div_addBook').find('#ISBN').attr('readonly', true);
	}
	//双击
	function ondouble(row, $element, field) {
		oldBook.booknumber = row.booknumber;
		oldBook.ISBN = row.isbn;
		oldBook.title = row.title;
		oldBook.author = row.author;
		oldBook.translator = row.translator;
		oldBook.summary = row.summary;
		oldBook.callNumber = row.callnumber;
		//seClassification = row.seclassification;
		oldBook.borrowTimes = row.borrowtimes;
		oldBook.entryDate = timestampToTime(row.entrydate);
		oldBook.publishYear = timestampToYear(row.publishyear);
		//alert(publishYear);
		oldBook.typecirculationnumber = row.typecirculationnumber;
		oldBook.classificationnumber = row.classificationnumber;
		oldBook.publishhousenumber = row.publishhousenumber;
		oldBook.typebookcfnumber = row.typebookCfnumber;
		oldBook.bookstatusnumber = row.bookstatusnumber;
		$('#myModalEdit').modal('show');
		$("#bookNumber").val(row.booknumber);
		$("#ISBN").val(row.isbn);
		$("#title").val(row.title);
		$("#author").val(row.author);
		$("#translator").val(row.translator);
		$("#summary").val(row.summary);
		$("#callNumber").val(row.callnumber);
		//$("#imgLocation").val(row.imglocation);
		$("#seClassification").val(row.seclassification);
		$("#borrowTimes").val(row.borrowtimes);
		$("#entryDate").val(timestampToTime(row.entrydate));
		//addYear("#publishYear");
		$("#publishYear").val(timestampToYear(row.publishyear));
		$("#publishYear").selectpicker('refresh');
		//流通类别url, number, id, keyOne, keyTwo
		getSelectType("findTypecirculationBook", row.typecirculationnumber,
				"#typeCirculationName", "typecirculationnumber",
				"typecirculationname");
		//分类
		getSelectTypeTwo("findClassificationBook", row.classificationnumber,
				"#classificationType", "classificationnumber",
				"classificationtype","classificationletter");
		//出版社
		getSelectType("findPublishhouse", row.publishhousenumber,
				"#publishHouseName", "publishhousenumber", "publishhousename");
		//状态
		getSelectType("findStatusBook", row.bookstatusnumber, "#bookStatus",
				"bookstatusnumber", "bookstatus");
		//类型
		getSelectType("findTypebookCf", row.typebookCfnumber,
				"#typeBook_CFName", "typebookCfnumber", "typebookCfname");
	}
	//删除图书
	$("#myModalDeleteOK").click(function() {
		var path = "deleteBook";
		var number = {
			"number" : $("#deleteBookNumber").html()
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
		});
	})
	//表格中增加按钮
	function addFunctionAlty(value, row, index) {
		/*
		return "<button class=\"btn btn-warning edit\" onclick=\"update('" + value
				+ "')\"> 修改 </button>" + "&nbsp;&nbsp;"
				+ "<button class=\"btn btn-danger del\" onclick=\"delete('" + value
				+ "')\"> 删除 </button>";*/
		return [
				'<a type="button" class="edit btn btn-warning" style="margin-right:5px">修改</a>',
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
			$("#deleteBookNumber").html(row.booknumber);
			$("#deleteISBN").html(row.isbn);
			$("#deleteTitle").html(row.title);
			//alert(row.booknumber);
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
	$('#myModalDeleteExit').on('show.bs.modal', function(e) {
		modalCenter("#myModalDeleteExit");
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
		Y = date.getFullYear() + '-';
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
		return Y + M + D;
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
			minDate : new Date(),
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
				alert('查询图书流通类别错误');
			}
		});
	}
	//分类的select
	function getSelectTypeTwo(url, number, id, keyOne, keyTwo,keyThree) {
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
										+" "+data[p][keyTwo] + "</option>");
					}
					//刷新和展示
					$(id).selectpicker('refresh');
					$(id).val(number);
					$(id).selectpicker('refresh');
					$(id).selectpicker('show');
				}
			},
			error : function() {
				alert('查询图书错误');
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