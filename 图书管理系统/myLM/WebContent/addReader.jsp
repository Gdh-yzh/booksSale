<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加读者</title>
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
			action="${pageContext.request.contextPath}/addReader" method="post"
			role="form">
			<div class="row" >
				<div class="col-md-12">
					<p class=" text_bg"><b>读者信息</b></p>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-4">
					<label class="col-md-4  control-label" for="readernumber">*读者编号:</label>
					<div class="col-md-8">
						<input name="readernumber" id="readernumber" type="text" class="form-control "
							placeholder="读者编号" aria-describedby="basic-addon1">
					</div>
				</div>
				<div class="form-group col-md-4">
					<label class="col-md-4   control-label" for="readername">*读者名:</label>
					<div class="col-md-8">
						<input name="readername" id="readername" type="text" class="form-control"
							placeholder="读者名" aria-describedby="basic-addon1" maxlength="20">
					</div>
				</div>
				<div class="form-group col-md-4">
					<label class="col-md-4   control-label" for="password">*密码:</label>
					<div class="col-md-8">
						<input name="password" id="password" type="password" class="form-control"
							placeholder="密码" aria-describedby="basic-addon1" maxlength="40">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-4">
					<label class="col-md-4  control-label" for="readertypenumber">*读者类型:</label>
					<div class="col-md-8">
						<select name="readertypenumber" class="selectpicker form-control"
							id="readertypeName"></select>
					</div>
				</div>
				<div class="form-group col-md-4">
					<label class="col-md-4 control-label" for="registrationdate">*注册日期:</label>
					<!--指定 date标记-->
					<div class="col-md-8">
						<div class='input-group date' id='datetimepicker1'>
						<!-- readerTypeNumber 读者类型 -->
							<input type='text' class="form-control" id="registrationDate" />
							<span class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
					</div>
				</div>
				<div class="form-group col-md-4">
					<label class="col-md-4   control-label" for="expirationdays">*有效期:</label>
					<div class="col-md-8">
						<input name="expirationdays" id="expirationdays" type="text" class="form-control"
							placeholder="有效期" aria-describedby="basic-addon1" maxlength="20">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<input name="readertypename" id="readertypename" type="hidden">
				</div>
			</div>
			<div class="row" id="div_input">
				<div class="col-md-6">
					<button id="reset" type="reset" name="reset"
						class="btn btn-primary" style="float: left">清空</button>
				</div>
				<div class="col-md-6">
					<button type="submit" id="button" name="submit"
						class="btn btn-primary" style="float: right">添加</button>
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
							<td>读者编号:</td>
							<td><span style="color: #337ab7" id="re_readerNumber"></span></td>
						</tr>
						<tr>
							<td>读者名:</td>
							<td><span id="re_readerName"></span></td>
						</tr>
						<tr>
							<td>密码:</td>
							<td><span id="re_passWord"></span></td>
						</tr>
						<tr>
							<td>读者类型:</td>
							<td><span id="re_readerType"></span></td>
						</tr>
						<tr>
							<td>注册日期:</td>
							<td><span id="re_registrationDate"></span></td>
						</tr>
						<tr>
							<td>有效期:</td>
							<td><span id="re_expirationDays"></span></td>
						</tr>
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
					<p>用户编码已存在</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
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
						添加读者 <span style="color: green" class="glyphicon  glyphicon-alert"></span>
					</h4>
				</div>
				<div class="modal-body">
					<p>是否添加读者？</p>
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
						console.log("<option value ='"
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
				//alert('查询图书流通类别错误');
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
				var readertypename = $("#readertypeName").find(
				"option:selected").val();
				//console.log(readertypename + ":readertypename");
				$('#readertypename').val(readertypename);
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
						$("#re_readerNumber").html(data[0].readernumber);
						$("#re_readerName").html(data[0].readername);
						$("#re_passWord").html(data[0].password);
						$("#re_readerType").html(data[0].typeReader.readertype);
						$("#re_registrationDate").html(data[0].registrationdate);
						$("#re_expirationDays").html(data[0].expirationdays);
					},
					error : function() {
						//alert("ajax添加失败");
						
						$('#myModalFail').modal('show');
					}
				})
			})
	$(function() {
		//读者类型
		getSelectType("findTypeReader", "#readertypeName", "readertypenumber",
		"readertype");
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
		$("#readernumber").bind("keyup", function() {
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
				readernumber : {
					validators : {
						notEmpty : {
							message : '用户编码不能为空'
						},
						stringLength : {
							min : 5,
							max : 5,
							message : '用户编码的长度为5位'
						},
						digits : {
							message : '用户编码只能输入数字'
						}
					}
				},
				readername : {
					validators : {
						notEmpty : {
							message : '读者名不能为空'
						},
					}
				},
				password : {
					validators : {
						notEmpty : {
							message : '密码不能为空'
						},
						stringLength : {
							min : 6,
							message : '密码至少需要6位'
						}
					}
				},
				expirationdays : {
					validators : {
						notEmpty : {
							message : '有效期不能为空'
						},
						digits : {
							message : '有效期只能输入数字'
						}
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
	$("#readertypeName").selectpicker({
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