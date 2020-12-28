<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>读者查询</title>
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
	<div id="toolbar" title="读者查询" class="container" 
		style="border: solid #eee 1px; padding: 10px;">
		<form id="form_query">
			<table id="table_query">
				<thead>
					<p style="background: #eee;padding: 5px;"><b>读者查询</b></p>
				</thead>
				<tr>
					<td><b>读者编号:</b></td>
					<td><input id="readernumber" name="readernumber" type="text" style=" margin-right: 20px"
						class="form-control"></td>
					<td><b>读者名:</b></td>
					<td><input id="readername" name="readername" type="text" style=" margin-right: 20px"
						class="form-control"></td>
					<td><b>读者状态:</b></td>
					<td><div style=" margin-right: 20px" >
							<select name="readerstatusnumber" class="selectpicker form-control"
								id="readerstatusnumber"></select>
						</div></td>
					<td><b>读者类型:</b></td>
					<td><div style=" margin-right: 20px" >
							<select name="readertypenumber" class="selectpicker form-control"
								id="readertypenumber"></select>
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
	var oldReader = new Object();
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
									readerString : $("#form_query").serialize(),
								//readerString:JSON.stringify($("#form_query").serializeArray()),
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
											if (row.readernumber == data[i].readernumber) //根据行里字段判断是否选中
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
									field : 'readernumber',
									title : '读者编号',
									align : "center",
									width : 150
								},
								{
									field : 'readername',
									title : '读者名',
									align : "center",
									width : 150
								},
								{
									field : 'registrationdate',
									title : '注册日期',
									align : "center",
									width : 150,
									formatter : function(value, row, index) {
										return timestampToTime(value);
									},
									sortable : true,
								},
								{
									field : 'expirationdays',
									title : '有效期',
									align : "center",
									width : 150,
									formatter : function(value, row, index) {
										return value + "天";
									},
									sortable : true,
								},
								{
									field : 'statusname',
									title : '读者状态',
									align : "center",
									width : 150,
									formatter : function(value, row, index) {
										return row.statusReader.statusname;
									},
								},
								{
									field : 'readertype',
									title : '读者类型',
									align : "center",
									width : 150,
									formatter : function(value, row, index) {
										return row.typeReader.readertype;
									},
								},
								{
									field : 'enddate',
									title : '到期日期',
									align : 'center',
									width : 150,
									formatter : function(value, row, index) {
										return timestampToTime(value);
									},
									sortable : true,
								},
								{
									field : 'password',
									title : '密码',
									align : "center",
									width : 100,
									formatter : function(value, row, index) {
										return "******";
									},
								}, {
									field : 'readerstatusnumber',
									title : '读者状态编号',
									align : "center",
									width : 150,
									visible:false
								}, {
									field : 'readertypenumber',
									title : '读者类型编号',
									align : "center",
									width : 150,
									visible:false
								}],
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
		$('#registrationdate').val("");
		$('#registrationdateEnd').val("");
		var startDateTime1 = $('#datetimepicker_3').datetimepicker({
			//新的
			format : 'YYYY-MM-DD',
			locale : moment.locale('zh-cn'),
			minDate : "1949-01-01",
			maxDate : new Date(),
		});
		var endDateTime1 = $('#datetimepicker_4').datetimepicker({
			//新的
			format : 'YYYY-MM-DD',
			locale : moment.locale('zh-cn'),
			maxDate : new Date(),
		})
		startDateTime1.on('dp.change', function(e) {
			endDateTime1.data('DateTimePicker').minDate(e.date);
		});
		endDateTime1.on('dp.change', function(e) {
			startDateTime1.data('DateTimePicker').maxDate(e.date);
		});
		$('#enddate').val("");
		$('#enddateEnd').val("");
	}
	//时间控件
	function time() {
		var startTime = $('#datetimepicker1').val();
		console.log("startTime:" + startTime);
		//时间日期控件初始化
		$('#datetimepicker_2').datetimepicker({
			//新的
			format : 'YYYY-MM-DD',
			locale : moment.locale('zh-cn'),
			//showClear:false,
			minDate : startTime,
			maxDate : new Date(),
			defaultDate : false
		});
		var startTime1 = $('#datetimepicker3').val();
		console.log("startTime1:" + startTime1);
		//时间日期控件初始化
		$('#datetimepicker_4').datetimepicker({
			//新的
			format : 'YYYY-MM-DD',
			locale : moment.locale('zh-cn'),
			//showClear:false,
			minDate : startTime1,
			maxDate : new Date(),
			defaultDate : false
		});
	}
	//查询select初始化
	function initQuerySelect() {
		//状态
		getSelectType("findStatusReader", 0, "#readerstatusnumber",
				"readerstatusnumber", "statusname");
		//类型
		getSelectType("findTypeReader", 0, "#readertypenumber",
				"readertypenumber", "readertype");
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
		var path = "findReadersQueryBySort";
		var url = '${pageContext.request.contextPath}/' + path;
		$('#table_table').bootstrapTable('refresh', {
			url : url,
		//query : data
		});
	}
	//清空
	$("#btn_reset").click(function() {
		//reset("#publishyear", "0");
		//reset("#publishyearEnd", "0");
		//InitpublishyearEnd("#publishyearEnd");
		//setEndYear();
		//initDateTime();
		reset("#readerstatusnumber", "0");
		reset("#readertypenumber", "0");
		//reset("#publishhousenumber", "0");
		//reset("#bookstatusnumber", "0");
		//reset("#typebookCfnumber", "0");
		//alert("reset");
	})
	function reset(id, number) {
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
		var path = "findReadersQuery";
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
		var path = "queryReaders";
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