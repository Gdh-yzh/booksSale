<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书归还</title>
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
</head>
<body>
	<div id="div_addBook" class="container"
		style="border: solid #eee 1px; padding: 10px;margin-top: 10px;">
		<form class="form-horizontal"
			action="${pageContext.request.contextPath}/addBook" method="post"
			role="form">
			<div class="row">
				<div class="col-md-12 col-sm-12">
					<p class=" text_bg">
						<b>归还信息</b>
					</p>
				</div>
			</div>			
			<div class="form-group col-md-4 col-sm-4">
				<label class="col-md-4  control-label" for="booknumber">图书编号</label>
				<div class="col-md-8">
					<input name="booknumber" id="bo_booknumber" type="text"
						class="form-control " placeholder="图书编号"
						aria-describedby="basic-addon1" maxlength="20">
				</div>
			</div>			
			<div class="col-md-1 col-sm-1">
				<button type="button" id="bo_queryBook" class="btn btn-primary">查询</button>
			</div>			
			<div class="form-group col-md-4 col-sm-4">
				<label class="col-md-4   control-label" for="readernumber">读者编号</label>
				<div class="col-md-8">
					<input name="readernumber" id="bo_readernumber" type="text"
						class="form-control" placeholder="读者编号"
						aria-describedby="basic-addon1" maxlength="20">
				</div>
			</div>
			<div class="col-md-3 col-sm-3">
				<button type="button" id="bo_queryReader" class="btn btn-primary">查询</button>
				<button type="reset" id="bo_reset" class="btn btn-default">清空</button>
				<a type="button" id="bt_show" class="btn"
					style="float: right; display: none;">显示</a>
			</div>
		</form>
	</div>	
	<div class="container div_border" id="div_borrow"
		style="display: none;">
		<p class=" text_bg">
			<b>借阅信息</b>
		</p>
		<br>
		<div id="div_success" style="display: none;">
			<table id="bookText" class="table">
				<thead>
					<p class="text-center">-- 图书信息 --</p>
				</thead>
				<tr class="danger">
					<td>图书名</td>
					<td>图书编号</td>
					<td>ISBN</td>
					<td>图书类型</td>
					<td>图书状态</td>
					<td>剩余归还天数</td>
				</tr>
				<tr>
					<td id="td_title"></td>
					<td id="td_booknumber"></td>
					<td id="td_isbn"></td>
					<td id="td_typebookCfname"></td>
					<td id="td_bookstatus"></td>
					<td id="td_days"></td>
				</tr>
			</table>
			<table id="readerText" class="table">
				<thead>
					<p class="text-center">-- 读者信息 --</p>
				</thead>
				<tr class="danger">
					<td>读者名</td>
					<td>读者编号</td>
					<td>读者类型</td>
				</tr>
				<tr>
					<td id="td_readername"></td>
					<td id="td_readernumber"></td>
					<td id="td_readertype"></td>
				</tr>
			</table>
			<div>
				<button type="button" id="bt_return" class="btn btn-primary"
					style="float: right;">一键归还</button>
			</div>
			<div>
				<a type="button" id="bt_hide" class="btn">隐藏</a>
			</div>
		</div>
		<div id="div_fail" style="display: none;">
			<p id="fali_p" class="text-center">-- 无借阅信息 --</p>
		</div>
	</div>
	<!-- Modal -->
	<!--借阅消息返回 -->
	<div class="modal fade" id="myModalBorrowReturn" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"></button>
					<h4 id="tag_title" class="modal-title" id="myModalLabel"></h4>
				</div>
				<div class="modal-body">
					<p id="tag_body"></p>
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
<!-- 日期 -->
<script src="bootstrap-select-1.13.9/js/bootstrap-select.min.js"></script>
<script src="monent-2.24.0/moment-with-locales.min.js"></script>
<script src="bootstrap-dateTimePicket4.17.47/js/bootstrap-datetimepicker.min.js"></script>
<script src="bootstrapvalidator-master/js/bootstrapValidator.min.js"></script>
<script type="text/javascript">
var return_borrownumber="";
	//图书查询
	$("#bo_queryBook")
			.click(
					function() {
						validator();
						$('form').data('bootstrapValidator').revalidateField(
							'booknumber');
						//$('form').data('bootstrapValidator').validate();
						//var flag = $("form").data("bootstrapValidator").isValid();//校验合格
						var flag = $("form").data("bootstrapValidator")
								.isValidField("booknumber");
						console.log(flag);
						if (flag) {
							var url = '${pageContext.request.contextPath}/'
									+ "returnBorrowBybooknumber";
							//再执行关闭
							$
									.ajax({
										async : false,
										type : "POST",
										url : url,
										//contentType : "application/x-www-form-urlencoded; charset=utf-8",
										data : $("form").serialize(),
										dataType : "text",
										success : function(data) {
											$("#div_borrow").show();
											var dataJson = jQuery
													.parseJSON(data);
											console.log("data:" + data);
											console.log("dataJson:" + dataJson);
											if (dataJson.tag == "有借阅记录") {
												$("#div_success").show();
												$("#div_fail").hide();
												var getBook = dataJson.book[0];
												var getReader = dataJson.reader[0];
												var getBorrow = dataJson.borrow[0];
												var borrowdate = getBorrow.borrowdate;
												var returndate = getBorrow.returndate;
												return_borrownumber = getBorrow.borrownumber;
												var day = (returndate - borrowdate)
														/ (1000 * 3600 * 24);
												if (day < 0) {
													day = "逾期/" + day;
												}
												$('#tag_title')
														.html(
																"借阅成功"
																		+ "<span style='color: #337ab7'"+" class='glyphicon  glyphicon-ok'></span>");
												$('#tag_body').html(
														dataJson.tag);
												$('#div_borrow').show();
												console.log("getBook.title:"
														+ getBook.title);
												$('#td_title').html(
														getBook.title);
												$('#td_booknumber').html(
														getBook.booknumber);
												$('#td_isbn')
														.html(getBook.isbn);
												$('#td_days').html(day + "天");
												$('#td_typebookCfname')
														.html(
																getBook.typebookCf.typebookCfname);
												$('#td_bookstatus')
														.html(
																getBook.statusBook.bookstatus);
												$('#td_readername').html(
														getReader.readername);
												$('#td_readernumber').html(
														getReader.readernumber);
												$('#td_readertype')
														.html(
																getReader.typeReader.readertype);
											} else {
												$("#div_fail").show();
												$("#div_success").hide();
												$("#fali_p").html(
														"-- " + dataJson.tag
																+ " --");
												$("#bt_show").hide();
											}
										},
										error : function() {
											$("#div_fail").show();
											$("#div_success").hide();
											$("#fali_p").html("-- 查询失败 --");
											$("#bt_show").hide();
											console.log("失败");
										}
									})
						}
					});
	//读者查询
	$("#bo_queryReader")
			.click(
					function() {
						validator();
						$('form').data('bootstrapValidator').revalidateField(
								'readernumber');
						//$('form').data('bootstrapValidator').validate();
						//var flag = $("form").data("bootstrapValidator").isValid();//校验合格
						var flag = $("form").data("bootstrapValidator")
								.isValidField("readernumber");
						console.log(flag);
						if (flag) {
							var url = '${pageContext.request.contextPath}/'
									+ "returnBorrowByreadernumber";
							//再执行关闭
							$
									.ajax({
										async : false,
										type : "POST",
										url : url,
										//contentType : "application/x-www-form-urlencoded; charset=utf-8",
										data : $("form").serialize(),
										dataType : "text",
										success : function(data) {
											$("#div_borrow").show();
											var dataJson = jQuery
													.parseJSON(data);
											console.log("data:" + data);
											console.log("dataJson:" + dataJson);
											if (dataJson.tag == "有借阅记录") {
												$("#div_success").show();
												$("#div_fail").hide();
												var getBook = dataJson.book[0];
												var getReader = dataJson.reader[0];
												var getBorrow = dataJson.borrow[0];
												var borrowdate = getBorrow.borrowdate;
												var returndate = getBorrow.returndate;
												return_borrownumber = getBorrow.borrownumber;
												var day = (returndate - borrowdate)
														/ (1000 * 3600 * 24);
												if (day < 0) {
													day = "逾期/" + day;
												}
												$('#tag_title')
														.html(
																"借阅成功"
																		+ "<span style='color: #337ab7'"+" class='glyphicon  glyphicon-ok'></span>");
												$('#tag_body').html(
														dataJson.tag);
												$('#div_borrow').show();
												console.log("getBook.title:"
														+ getBook.title);
												$('#td_title').html(
														getBook.title);
												$('#td_booknumber').html(
														getBook.booknumber);
												$('#td_isbn')
														.html(getBook.isbn);
												$('#td_days').html(day + "天");
												$('#td_typebookCfname')
														.html(
																getBook.typebookCf.typebookCfname);
												$('#td_bookstatus')
														.html(
																getBook.statusBook.bookstatus);
												$('#td_readername').html(
														getReader.readername);
												$('#td_readernumber').html(
														getReader.readernumber);
												$('#td_readertype')
														.html(
																getReader.typeReader.readertype);
											} else {
												$("#div_fail").show();
												$("#div_success").hide();
												$("#fali_p").html(
														"-- " + dataJson.tag
																+ " --");
												$("#bt_show").hide();
											}
										},
										error : function() {
											$("#div_fail").show();
											$("#div_success").hide();
											$("#fali_p").html("-- 查询失败 --");
											$("#bt_show").hide();
											console.log("失败");
										}
									})
						}
					});
    //归还成功
	$("#bt_return").click(function() {
		if(return_borrownumber==""){
			console.log("借阅编号为空");
		}else{
			console.log("借阅编号ok");
			var url = '${pageContext.request.contextPath}/'+ "returnBook";
			$.ajax({
				async : false,
				type : "POST",
				url : url,
				//contentType : "application/x-www-form-urlencoded; charset=utf-8",
				data :{ borrownumber:return_borrownumber},
				dataType : "text",
				success : function(data) {				
					$('#myModalBorrowReturn').modal('show');
					if(data==2){
						console.log("归还成功");					
					$('#tag_title').html("归还图书"+ "<span style='color: #337ab7'"+" class='glyphicon  glyphicon-ok'></span>");
					$('#tag_body').html('图书归还成功');
					}else{
						console.log("归还失败data："+data);
						$('#tag_title').html("归还失败"+ "<span style='color: red'"+" class='glyphicon  glyphicon-remove'></span>");
				$('#tag_body').html('图书归还失败');
					}			
				},			
				error : function() {
					$('#myModalBorrowReturn').modal('show');			
					console.log("归还错误");
					$('#tag_title').html("归还失败"+ "<span style='color: red'"+" class='glyphicon  glyphicon-remove'></span>");
					$('#tag_body').html('图书归还失败');
				}
			})			
		}
	});
		$('#myModalBorrowReturn').on('hidden.bs.modal', function() {
		$('#tag_body').html("");
		$('#tag_title').html("");
		$("#div_borrow").hide();
		reset();
	});
	//重置
	$("#bo_reset").click(function() {
		//重置表单验证
		reset();
	});
	//隐藏
	$("#bt_hide").click(function() {
		$("#div_borrow").hide();
		$("#bt_show").show();
	})
	$("#bt_show").click(function() {
		$("#div_borrow").show();
		$("#bt_show").hide();
	})
	function reset() {
		$('#bo_booknumber').val("");
		$('#bo_readernumber').val("");
		$("form").data('bootstrapValidator').resetForm();
	}
	$(function() {
		//开启表单验证
		//validator();
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
				booknumber : {
					validators : {
						notEmpty : {
							message : '图书编号不能为空'
						},
						digits : {
							message : '图书编号只能输入数字'
						}
					}
				},
				readernumber : {
					validators : {
						notEmpty : {
							message : '读者编号不能为空'
						},
						digits : {
							message : '读者编号只能输入数字'
						}
					}
				},
			},
		})
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
	//模态框居中 myModalBorrowReturn myModalBorrowReturn myModalCertain
	$('#myModalBorrowReturn').on('show.bs.modal', function(e) {
		modalCenter("#myModalBorrowReturn");
	})
	$('#myModalCertain').on('show.bs.modal', function(e) {
		modalCenter("#myModalCertain");
	})
</script>
</html>