<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加图书</title>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/addBook.css">
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
	<div id="div_addBook" class="container" style="border: solid #eee 1px;padding: 10px;margin-top: 10px;">
		<form class="form-horizontal"
			action="${pageContext.request.contextPath}/addBook" method="post"
			role="form">
			<div class="row" >
				<div class="col-md-12">
					<p class=" text_bg"><b>图书信息</b></p>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-4">
					<label class="col-md-4  control-label" for="isbn">*ISBN:</label>
					<div class="col-md-8">
						<input name="isbn" id="ISBN" type="text" class="form-control "
							placeholder="ISBN" aria-describedby="basic-addon1">
					</div>
				</div>
				<div class="form-group col-md-4">
					<label class="col-md-4   control-label" for="title">*图书名:</label>
					<div class="col-md-8">
						<input name="title" id="title" type="text" class="form-control"
							placeholder="图书名" aria-describedby="basic-addon1" maxlength="20">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-4">
					<label class="col-md-4   control-label" for="author">*作者:</label>
					<div class="col-md-8">
						<input name="author" id="author" type="text" class="form-control"
							placeholder="作者" aria-describedby="basic-addon1" maxlength="40">
					</div>
				</div>
				<div class="form-group col-md-4">
					<label class="col-md-4  control-label " for="translator">译者:</label>
					<div class="col-md-8">
						<input name="translator" id="translator" type="text"
							class="form-control" placeholder="译者"
							aria-describedby="basic-addon1" maxlength="40">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-4">
					<label class="col-md-4  control-label" for="publishhousenumber">*出版社:</label>
					<div class="col-md-8">
						<select name="publishhousenumber"
							class="selectpicker form-control" id="publishHouseName"></select>
					</div>
				</div>
				<div class="form-group col-md-4">
					<label class="col-md-4   control-label" for="publishyear">*出版年份:</label>
					<div class="col-md-8">
						<select name="publishyear" class="selectpicker form-control"
							id="publishYear" class="form-control"></select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<hr style="border-top: 1px dashed #CCC" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<p  class="text_bg"><b>馆藏信息</b></p>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-4">
					<label class="col-md-4  control-label" for="callnumber">索书号:</label>
					<div class="col-md-8">
						<input name="callnumber" id="callNumber" type="text"
							class="form-control" placeholder="索书号"
							aria-describedby="basic-addon1" maxlength="40">
					</div>
				</div>
				<div class="form-group col-md-4">
					<label class="col-md-4  control-label" for="typebookCfnumber">*图书类型:</label>
					<div class="col-md-8">
						<select name="typebookCfnumber" class="selectpicker form-control"
							id="typeBook_CFName"></select>
					</div>
				</div>
				<div class="form-group col-md-4">
					<label class="col-md-4 control-label" for="entrydate">*入库日期:</label>
					<!--指定 date标记-->
					<div class="col-md-8">
						<div class='input-group date' id='datetimepicker1'>
							<input type='text' class="form-control" id="entryDate" />
							<span class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-4">
					<label class="col-md-4  control-label" for="classificationnumber">*图书分类:</label>
					<div class="col-md-8">
						<select name="classificationnumber"
							class="selectpicker form-control" id="classificationType"></select>
					</div>
				</div>
				<div class="form-group col-md-4">
					<label class="col-md-4  control-label" for="typecirculationnumber">*流通分类:</label>
					<div class="col-md-8">
						<select name="typecirculationnumber"
							class="selectpicker form-control" id="typeCirculationName"></select>
					</div>
				</div>
				<div class="form-group col-md-4">
					<label class="col-md-4  control-label" for="bookstatusnumber">*图书状态:</label>
					<div class="col-md-8">
						<select name="bookstatusnumber" class="selectpicker form-control"
							id="bookStatus"></select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<label for="summary">简介:</label>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<textarea rows="3" name="summary" id="summary" class="form-control"></textarea>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<input name="publishhousename" id="publishhousename" type="hidden">
					<input name="typecirculationname" id="typecirculationname"
						type="hidden"> <input name="bookstatus" id="bookstatus"
						type="hidden"> <input name="typebookcfname"
						id="typebookcfname" type="hidden"> <input
						name="classificationtype" id="classificationtype" type="hidden">
				</div>
			</div>
			<div class="row" id="div_input">
				<div class="col-md-6" style="float: left">
					<button id="reset" type="reset" name="reset"
						class="btn btn-primary">清空</button>
					<button type="submit" id="button" name="submit"
						class="btn btn-primary">添加</button>
				</div>
				<div class="col-md-6">
					<a class="btn btn-primary" href="importBooks.jsp" role="button" 
						id="import" style="float: right">导入图书表格</a>
				</div>
			</div>
		</form>
	</div>
	<!-- Modal -->
	<!-- 添加 -->
	<div class="modal fade" id="myModalOK" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"></button>
					<h4 class="modal-title" id="myModalLabel">
						添加成功 <span style="color: #337ab7"
							class="glyphicon  glyphicon-ok"></span>
					</h4>
				</div>
				<div class="modal-body">
					<table>
						<tr>
							<td>图书编号:</td>
							<td><span style="color: #337ab7" id="re_bookNumber"></span></td>
						</tr>
						<tr>
							<td>ISBN:</td>
							<td><span id="re_isbn"></span></td>
						</tr>
						<tr>
							<td>图书名:</td>
							<td><span id="re_title"></span></td>
						</tr>
						<tr>
							<td>作者:</td>
							<td><span id="re_author"></span></td>
						</tr>
						<tr>
							<td>译者:</td>
							<td><span id="re_translator"></span></td>
						</tr>
						<tr>
							<td>出版社:</td>
							<td><span id="re_publish"></span></td>
						</tr>
						<tr>
							<td>出版年份:</td>
							<td><span id="re_publishYear"></span></td>
						</tr>
						<tr>
							<td>索书号:</td>
							<td><span id="re_callNumber"></span></td>
						</tr>
						<tr>
							<td>图书类型:</td>
							<td><span id="re_CFType"></span></td>
						</tr>
						<tr>
							<td>入库日期:</td>
							<td><span id="re_entryDate"></span></td>
						</tr>
						<tr>
							<td>图书分类:</td>
							<td><span id="re_classType"></span></td>
						</tr>
						<tr>
							<td>流通分类:</td>
							<td><span id="re_CirType"></span></td>
						</tr>
						<tr>
							<td>图书状态:</td>
							<td><span id="re_bookStatus"></span></td>
						</tr>
						<tr>
							<td>简介:</td>
							<td><span id="re_summary"></span></td>
						</tr>
						<tr>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 取消 -->
	<div class="modal fade" id="myModalFail" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"></button>
					<h4 class="modal-title" id="myModalLabel">
						添加失败 <span style="color: red" class="glyphicon  glyphicon-remove"></span>
					</h4>
				</div>
				<div class="modal-body">
					<p>添加图书失败，请核对信息再重新添加!</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-default">确定</button>
				</div>
			</div>
		</div>
	</div>
<!-- 确认添加？ -->
	<div class="modal fade" id="myModalCertain" tabindex="-1" role="dialog"
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
	function getSelectType(url, id, keyOne, keyTwo) {
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
					//$(id).val(number);
					$(id).selectpicker('refresh');
					$(id).selectpicker('show');
				}
			},
			error : function() {
				alert('查询图书流通类别错误');
			}
		});
		$(id).selectpicker({
			noneSelectedText : '--请选择--', //默认显示内容
		});
	}
	//分类的选择框
		function getSelectTypeTwo(url, id, keyOne, keyTwo,keyThree) {
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
										+ data[p][keyThree].toLocaleUpperCase()+" "+data[p][keyTwo] + "</option>");
					}
					//刷新和展示
					$(id).selectpicker('refresh');
					//$(id).val(number);
					$(id).selectpicker('refresh');
					$(id).selectpicker('show');
				}
			},
			error : function() {
				//alert('查询图书流通类别错误');
			}
		});
		$(id).selectpicker({
			noneSelectedText : '--请选择--', //默认显示内容
		});
	}
	//重置
	$("#reset").click(function() {
		//重置表单验证
		$("form").data('bootstrapValidator').resetForm();
		//$("form").data("bootstrapValidator", null);
		//重构验证
		//validator();
	});
	//确认添加的点击事件
	$("#certainOk").click(
			function() {
				$('#myModalCertain').modal('hide');
				$('#myModalOK').modal('show');
				var publishhousename = $("#publishHouseName").find(
						"option:selected").text();
				var typecirculationname = $("#typeCirculationName").find(
						"option:selected").text();
				var bookstatus = $("#bookStatus").find("option:selected")
						.text();
				var typebookcfname = $("#typeBook_CFName").find(
						"option:selected").text();
				var classificationtype = $("#classificationType").find(
						"option:selected").text();
				$('#publishhousename').val(publishhousename);
				$('#typecirculationname').val(typecirculationname);
				$('#bookstatus').val(bookstatus);
				$('#typebookcfname').val(typebookcfname);
				$('#classificationtype').val(classificationtype);
				//alert(""+$("#publishhousename").val());
				// Use Ajax to submit form data 提交至form标签中的action，result自定义
				//再执行关闭
				$.ajax({
					async : false,
					type : "POST",
					url : $('form').attr('action'),
					//contentType : "application/x-www-form-urlencoded; charset=utf-8",
					data : $("form").serialize(),
					dataType : "json",
					success : function(data) {
						//alert("ajax添加成功");
						//模态框
						$('#myModalOK').modal('show');
						$('#myModalOK').css({
							'overflow-y' : 'scroll'
						});
						//var jsonobj = eval('(' + data + ')');
						$("#re_bookNumber").html(data[0].booknumber);
						$("#re_isbn").html(data[0].isbn);
						$("#re_title").html(data[0].title);
						$("#re_author").html(data[0].author);
						$("#re_translator").html(data[0].translator);
						$("#re_publish").html(data[0].publishhouse.publishhousename);
						$("#re_callNumber").html(data[0].callnumber);
						$("#re_CFType").html(data[0].typebookCf.typebookCfname);
						$("#re_author").html(data[0].author);
						$("#re_entryDate").html(data[0].entrydate);
						$("#re_classType").html(data[0].classificationBook.classificationtype);
						$("#re_CirType").html(data[0].typecirculationBook.typecirculationname);
						$("#re_bookStatus").html(data[0].statusBook.bookstatus);
						$("#re_summary").html(data[0].summary);
						$("#re_publishYear").html(data[0].publishyear);
					},
					error : function() {
						$('#myModalFail').modal('show');
					}
				})
			})
	$(function() {
		//流通类别
		getSelectType("findTypecirculationBook", "#typeCirculationName",
				"typecirculationnumber", "typecirculationname");
		//分类
		getSelectTypeTwo("findClassificationBook", "#classificationType",
				"classificationnumber", "classificationtype","classificationletter");
		//出版社
		getSelectType("findPublishhouse", "#publishHouseName",
				"publishhousenumber", "publishhousename");
		//状态
		getSelectType("findStatusBook", "#bookStatus", "bookstatusnumber",
				"bookstatus");
		//种类
		getSelectType("findTypebookCf", "#typeBook_CFName", "typebookCfnumber",
				"typebookCfname");
		$('#datetimepicker1').datetimepicker({
			//新的
			format : 'YYYY-MM-DD',
			locale : moment.locale('zh-cn'),
			minDate : new Date(),
			maxDate : new Date()
		});
		$("#div_border").hover(function() {
			$("#div_a").css("visibility", "visible");
		}, function() {
			$("#div_a").css("visibility", "hidden");
		});
		//年份的select框
		addYear("#publishYear");
		//input只输入数字
		$("#ISBN").bind("keyup", function() {
			$(this).val($(this).val().replace(/[\D]/g, ""));
		});
		//开启表单验证
		validator();
	});
	//表单验证
	function validator() {
		$('form').bootstrapValidator({
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
			},
		}).on('success.form.bv', function(e) {//点击提交之后
			// 防止默认提交
			e.preventDefault();
			// 得到表单实例
			var $form = $(e.target);
			// Get the BootstrapValidator instance
			//var bv = $form.data('bootstrapValidator');
			//$('form').data('bootstrapValidator').validate();
			var flag = $("form").data("bootstrapValidator").isValid();//校验合格
			//alert(flag);
			if (flag) {
				$('#myModalCertain').modal('show');
			}
		});
	}
	//模态框的关闭事件
	$('#myModalOK').on('hidden.bs.modal', function() {
		window.location.reload();
	});
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
	$("#typeBook_CFName").selectpicker({
		noneSelectedText : '--请选择--', //默认显示内容
	});
	function addYear(id) {
		j = parseInt(new Date().getFullYear());
		for (var i = j; i > 1800; i--) {
			$(id).append("<option value ='"
					+ i + "'>" + i + "</option>");
		}
	}
	//模态框居中
	function modalCenter(id){
		var height = window.innerHeight;
		var item_height = 350 ;
		var top =(height - item_height)/2;
		if(top < 0 ){
			top = 0;
		}
		$(id).css("top",top+"px");
		//$(id).modal("show");
	}
	//模态框居中 myModalOK myModalFail myModalCertain
		$('#myModalFail').on('show.bs.modal', function (e) {
		modalCenter("#myModalFail");
		})
		$('#myModalCertain').on('show.bs.modal', function (e) {
		modalCenter("#myModalCertain");
		})
</script>
</html>