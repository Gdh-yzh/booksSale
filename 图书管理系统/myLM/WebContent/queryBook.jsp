<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>图书查询</title>
<link rel="stylesheet" href="css/bookManagement.css">
<link rel="stylesheet" href="css/queryBook.css">
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
<link href="bootstrapvalidator-master/css/bootstrapValidator.min.css"
	rel="stylesheet">
</head>
<body>
	<div id="toolbar" title="图书查询" class="container" 
		style="border: solid #eee 1px; padding: 10px;">
		<form id="form_query">
			<table id="table_query">
				<thead>
					<p style="background: #eee;padding: 5px;"><b>图书查询</b></p>
				</thead>
				<tr>
					<td><b>图书编号:</b></td>
					<td><input id="booknumber" name="booknumber" type="text" style=" margin-right: 20px"
						class="form-control"></td>
					<td><b>ISBN:</b></td>
					<td><input id="isbn" name="isbn" type="text" style=" margin-right: 20px"
						class="form-control"></td>
					<td><b>图书名:</b></td>
					<td><input id="title" name="title" type="text" style=" margin-right: 20px"
						class="form-control"></td>
					<td><b>作者:</b></td>
					<td><input id="author" name="author" type="text" style=" margin-right: 20px"
						class="form-control"></td>
				</tr>
				<tr>
					<td><b>译者:</b></td>
					<td><input id="translator" name="translator" type="text"
						class="form-control"></td>
					<td><b>索书号:</b></td>
					<td><input id="callnumber" name="callnumber" type="text"
						class="form-control"></td>
					<td><b>借出次数:</b></td>
					<td><input id="borrowtimes" name="borrowtimes" type="number"
						class="form-control"
						oninput="if(value.length>7)value=value.slice(0,7)"></td>
					<td><b>出版社:</b></td>
					<td><div>
							<select name="publishhousenumber"
								class="selectpicker form-control" id="publishhousenumber"
								name="bookstatusnumber"></select>
						</div></td>
				</tr>
				<tr>
					<td><b>图书分类:</b></td>
					<td><div>
							<select name="classificationnumber"
								class="selectpicker form-control" id="classificationnumber"></select>
						</div></td>
					<td><b>流通分类:</b></td>
					<td><div>
							<select name="typecirculationnumber"
								class="selectpicker form-control" id="typecirculationnumber"></select>
						</div></td>
					<td><b>图书状态:</b></td>
					<td><div>
							<select name="bookstatusnumber" class="selectpicker form-control"
								id="bookstatusnumber"></select>
						</div></td>
					<td><b>图书类型:</b></td>
					<td><div>
							<select name="typebookCfnumber" class="selectpicker form-control"
								id="typebookCfnumber"></select>
						</div></td>
				</tr>	
				<tr>
					<td>
						<button id="btn_query" type="button" class="btn btn-primary"
							style=" margin-right: 5px">查询</button>
					</td>
					<td>
						<button type="reset" class="btn btn-primary" id="btn_reset"
							>清空</button>
					</td>
				</tr>	
			</table>
		</form>
		<hr>
	</div>
	<div id="div_table" class="table-responsive" style="display: none;" >
		<table id="table_table" class=" table-striped "
			style="table-layout: fixed;"></table>
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
						图书信息<span class="text-info" id="span_edit"
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
									<a class="text-primary"><b>基本信息</b></a>
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
									<a class="text-primary"><b>馆藏信息</b></a>
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
									<label class="col-md-4  control-label" for="typebookCfnumber">*图书种类:</label>
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
										for="typecirculationnumber">*流通类别:</label>
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
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
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
	//多选
	var idlist = {};
	function inbootstrapTable() {
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
									text : "",
									sortOrder : params.sortOrder,
									sortName : params.sortName,
									bookString : $("#form_query").serialize(),
								//bookString:JSON.stringify($("#form_query").serializeArray()),
								// 页码
								};
							},
							queryParamsType : "undefined",
							//queryParamsType : "",
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
										},
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
										},
										visible : false
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
											return row.classificationBook.classificationletter
													.toLocaleUpperCase()
													+ " "
													+ row.classificationBook.classificationtype;
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
									},
									{
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
									} ],
							onRefresh : function() {
								getAllSelect();
							},//刷新前
							onSearch : function(text) {
								search(text);
							},
							onSort : function(name, order) {
								sort(name, order);
							},
						//ajax:getAjax,
						//onPageChange : getAjax,
						});
	}
	//次数
	$('#borrowtimes').change(function() {
		var times = $('#borrowtimes').val();
		if (times < 0) {
			$('#borrowtimes').val(-times);
		}
	});
	//时间初始化
	function initDateTime() {
		var startDateTime = $('#datetimepicker_1').datetimepicker({
			//新的
			format : 'YYYY-MM-DD',
			locale : moment.locale('zh-cn'),
			minDate : "1949-01-01",
			maxDate : new Date(),
		});
		var endDateTime = $('#datetimepicker_2').datetimepicker({
			//新的
			format : 'YYYY-MM-DD',
			locale : moment.locale('zh-cn'),
			maxDate : new Date(),
		})
		startDateTime.on('dp.change', function(e) {
			endDateTime.data('DateTimePicker').minDate(e.date);
		});
		endDateTime.on('dp.change', function(e) {
			startDateTime.data('DateTimePicker').maxDate(e.date);
		});
		$('#publishyear').val("");
		$('#publishyearEnd').val("");
	}
	//时间控件
	function time() {
		var startTime = $('#datetimepicker1').val();
		//console.log("startTime:" + startTime);
		//时间日期控件初始化
		$('#datetimepicker_2').datetimepicker({
			//新的
			format : 'YYYY-MM-DD',
			locale : moment.locale('zh-cn'),
			//showClear:false,
			minDate : startTime,
			//locale : moment.locale('zh-cn'),
			maxDate : new Date(),
			//defaultDate : false
		});
	}
	//查询select初始化
	function initQuerySelect() {
		addYearText("#publishyear", "开始年份");
		InitpublishyearEnd("#publishyearEnd");
		//addYear("#publishyear");
		//流通类别url, number, id, keyOne, keyTwo
		getSelectType("findTypecirculationBook", 0, "#typecirculationnumber",
				"typecirculationnumber", "typecirculationname");
		//分类
		getSelectTypeTwo("findClassificationBook", 0, "#classificationnumber",
				"classificationnumber", "classificationtype",
				"classificationletter");
		//出版社
		getSelectType("findPublishhouse", 0, "#publishhousenumber",
				"publishhousenumber", "publishhousename");
		//状态
		getSelectType("findStatusBook", 0, "#bookstatusnumber",
				"bookstatusnumber", "bookstatus");
		//种类
		getSelectType("findTypebookCf", 0, "#typebookCfnumber",
				"typebookCfnumber", "typebookCfname");
	}
	//结束时间
	function InitpublishyearEnd(id) {
		$(id).empty();
		$(id).append("<option value ='0'>--结束年份--</option>");
		$(id).val("0");
		$(id).selectpicker('refresh');
		$(id).selectpicker('show');
	}
	//出版年份
	function addYearText(id, text) {
		$(id).empty();
		j = parseInt(new Date().getFullYear());
		$(id).append("<option value ='0' >--" + text + "--</option>");
		for (var i = j; i > 1800; i--) {
			$(id).append("<option value ='"
					+ i + "'>" + i + "</option>");
		}
		//$().html();
		//$(id).val("0");
		//$(id).selectpicker('refresh');
		//$(id).selectpicker('render');
		//$(id).selectpicker('show');
		//selectpicker(id);
	}
	//结束年份
	function endYear(id, startYear) {
		var idSelected = $("#publishyearEnd").val();
		$(id).empty();
		console.log("startYear:" + startYear);
		j = parseInt(new Date().getFullYear());
		$(id).append("<option value ='0'>--结束年份--</option>");
		for (var i = j; i >= startYear; i--) {
			$(id).append("<option value ='"
					+ i + "'>" + i + "</option>");
		}
		if (startYear <= idSelected) {
			$(id).val(idSelected);
		} else {
			$(id).val(0);
		}
		$(id).selectpicker('refresh');
		$(id).selectpicker('show');
	}
	//结束的下拉框,显示状态
	$('#publishyearEnd').on('show.bs.select', function(e) {
		var startYear = $("#publishyear").val();
		if (startYear != 0) {
			endYear('#publishyearEnd', startYear);
		} else {
		}
		//绑定下拉显示列表触发事件
	});
	//更改下拉值
	$('#publishyear').on('changed.bs.select', function(e) {
		var startYear = $("#publishyear").val();
		console.log("changed startYear:" + startYear);
		var endYear = $("#publishyearEnd").val();
		if (endYear != 0) {
			if (startYear > endYear) {
				$("#publishyearEnd").val(0);
				$('#publishyearEnd').selectpicker('refresh');
				$('#publishyearEnd').selectpicker('show');
			}
		}
		if (startYear == 0) {
			console.log("here" + startYear);
			//setEndYear();
			InitpublishyearEnd("#publishyearEnd");
		}
	});
	function sort(name, order) {
		var path = "findBooksQueryBySort";
		var url = '${pageContext.request.contextPath}/' + path;
		$('#table_table').bootstrapTable('refresh', {
			url : url,
		//query : data
		});
	}
	//清空
	$("#btn_reset").click(function() {
		reset("#publishyear", "0");
		//reset("#publishyearEnd", "0");
		InitpublishyearEnd("#publishyearEnd");
		//setEndYear();
		//initDateTime();
		//time();
		reset("#typecirculationnumber", "0");
		reset("#classificationnumber", "0");
		reset("#publishhousenumber", "0");
		reset("#bookstatusnumber", "0");
		reset("#typebookCfnumber", "0");
		//alert("reset");
	})
	function reset(id, number) {
		$(id).selectpicker('refresh');
		$(id).val(number);
		$(id).selectpicker('refresh');
		$(id).selectpicker('show');
	}
	$("#btn_query").click(function() {
		//getAjax();
		$('#div_table').show();
		queryTest();
	})
	function queryTest() {
		var path = "findBooksQuery";
		var url = '${pageContext.request.contextPath}/' + path;
		$('#table_table').bootstrapTable('refresh', {
			url : url,
		//query : datas,
		//query : data
		});
	}
	function getAjax() {
		var pagesize = $("#table_table").bootstrapTable("getOptions").pageSize;
		var pagenumber = $("#table_table").bootstrapTable("getOptions").pageNumber;
		//var data = $("#form_query").serializeArray();
		//var data = {"title":"春天"};
		//var data = JSON.stringify($("#form_query").serializeObject())
		//alert(text);
		var path = "queryBooks";
		var url = '${pageContext.request.contextPath}/' + path;
		$.ajax({
			url : url,
			type : "POST",
			data : $("#form_query").serialize() + "&pageSize=" + pagesize
					+ "&pagenNmber=" + pagenumber,
			dataType : "json",
			success : function(rs) {
				console.log(rs);
				//var message = rs.array;
				$('#table_table').bootstrapTable('load', rs);
				//debugger;
			},
			error : function(rs) {
				console.log(rs)
			}
		});
	}
	//获取多选
	function getAllSelect(options) {
		idlist = $('#table_table').bootstrapTable('getAllSelections');
		var data = $('#table_table').bootstrapTable('getAllSelections');
		return data;
	}
	function initModelButton() {
		noEdit();
	}
	//获取参数
	//给所有的input添加不可编辑
	function noEdit() {
		//	$("#resetButton").attr('disabled', true);
		$('#div_addBook').find('input').attr('readonly', true);
		$('#div_addBook').find('textarea').attr('readonly', true);
		$('#div_addBook').find('select').attr('disabled', "disabled");
		//添加disable样式
		$('.bootstrap-select').find('button').addClass('disabled');
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
				"classificationtype", "classificationletter");
		//出版社
		getSelectType("findPublishhouse", row.publishhousenumber,
				"#publishHouseName", "publishhousenumber", "publishhousename");
		//状态
		getSelectType("findStatusBook", row.bookstatusnumber, "#bookStatus",
				"bookstatusnumber", "bookstatus");
		//种类
		getSelectType("findTypebookCf", row.typebookCfnumber,
				"#typeBook_CFName", "typebookCfnumber", "typebookCfname");
	}
	//模态框居中
	function modalCenter(id) {
		var height = window.innerHeight;
		var item_height = 100;
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
	//jq初始化
	$(function() {
		//表格初始化
		inbootstrapTable();
		//选择框初始化
		initQuerySelect();
		$(window).resize(function() {
			$('#table_table').bootstrapTable('resetView');
		});
		//表格高度
		$(".fixed-table-container").css("height",
				window.parent.innerHeight - 500);
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
			minDate : '1990-7-1',
			maxDate : new Date(),
			defaultDate : false
		});
		//年份的select框
		addYear("#publishYear");
		//model按钮初始化
		initModelButton();
		//input只输入数字
		//移动列宽
		initDateTime();
	});
	function selectpicker(id) {
		$(id).selectpicker({
			noneSelectedText : '--请选择--', //默认显示内容
		});
	}
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
				$(id).append("<option value ='0'>--请选择--</option>");
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
				$(id).append("<option value ='0'>--请选择--</option>");
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
				alert('查询图书流通类别错误');
			}
		});
	}
	//出版年份
	function addYear(id) {
		$(id).empty();
		j = parseInt(new Date().getFullYear());
		$(id).append("<option value ='0'>--开始年份--</option>");
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
</script>
</html>