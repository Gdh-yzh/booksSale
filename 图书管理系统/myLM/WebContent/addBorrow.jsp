<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书借阅</title>
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
					<p class=" text_bg"><b>借阅信息</b></p>
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
			<div class="form-group col-md-4 col-sm-4">
				<label class="col-md-4   control-label" for="readernumber">读者编号</label>
				<div class="col-md-8">
					<input name="readernumber" id="bo_readernumber" type="text"
						class="form-control" placeholder="读者编号"
						aria-describedby="basic-addon1" maxlength="20">
				</div>
			</div>
			<div class="col-md-4 col-sm-4">
				<button type="submit" id="bo_sumbit" name="submit"
					class="btn btn-primary">借阅</button>
					<button type="reset" id="bo_reset" name="reset"
					class="btn btn-default">清空</button>
					<a type="button" id="bt_show" 
					class="btn btn-default" style="float: right;display: none;">显示</a>
			</div>
		</form>
	</div>
	<div class="container div_border" id="div_borrow" style="display: none;">
	<p class=" text_bg" ><b>恭喜读者成功借阅图书</b></p>
	<br>
		<table id="bookText" class="table">
			<thead ><p class="text-center">-- 图书信息 --</p>
			</thead>
			<tr class="danger">
				<td>图书名</td>
				<td>图书编号</td>
				<td>ISBN</td>
				<td>作者</td>
				<td>出版社</td>
				<td>图书类型</td>
				<td>图书状态</td>
			</tr>
			<tr >
				<td id="td_title"></td>
				<td id="td_booknumber"></td>
				<td id="td_isbn"></td>
				<td id="td_author"></td>
				<td id="td_publishhousename"></td>
				<td id="td_typebookCfname"></td>
				<td id="td_bookstatus"></td>
			</tr>
		</table>
		<br>
		<table id="readerText" class="table">
			<thead ><p class="text-center">-- 读者信息 --</p>
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
		<a type="button" id="bt_hide" 
					class="btn btn-default" style="float: right;">隐藏</a>
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
						借阅图书 <span style="color: green" class="glyphicon  glyphicon-alert"></span>
					</h4>
				</div>
				<div class="modal-body">
					<p>是否借阅图书？</p>
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
	$("#bo_sumbit").click(function() {
		validator();
		$('form').data('bootstrapValidator').validate();
		var flag = $("form").data("bootstrapValidator").isValid();//校验合格
		//alert(flag);
		if (flag) {
			$('#myModalCertain').modal('show');
		}
	})
	//重置
	$("#bo_reset").click(function() {
		//重置表单验证
		reset();
	});
	//隐藏
	$("#bt_hide").click(function(){
		$("#div_borrow").hide();
		$("#bt_show").show();
	})
	$("#bt_show").click(function(){
		$("#div_borrow").show();
		$("#bt_show").hide();
	})	
	//确认添加的点击事件
	$("#certainOk")
			.click(
					function() {
						$('#myModalCertain').modal('hide');

						// Use Ajax to submit form data 提交至form标签中的action，result自定义
						var url = '${pageContext.request.contextPath}/'
								+ "borrowQuery";
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
										//alert("ajax添加成功");
										//模态框
										var dataJson = jQuery.parseJSON(data);
										//console.log(data + ":wo");
										$('#myModalBorrowReturn').modal('show');
										if (dataJson.tag == "借阅成功") {
											console.log("借阅成功:"
													+ dataJson.book[0]
													+ dataJson.reader[0]);
											var getBook = dataJson.book[0];
											var getReader = dataJson.reader[0];
											$('#tag_title')
													.html(
															"借阅成功"
																	+ "<span style='color: #337ab7'"+" class='glyphicon  glyphicon-ok'></span>");
											$('#tag_body').html(dataJson.tag);
											$('#div_borrow').show();
											console.log("getBook.title:"
													+ getBook.title);
											$('#td_title').html(getBook.title);
											$('#td_booknumber').html(
													getBook.booknumber);
											$('#td_isbn').html(getBook.isbn);
											$('#td_author')
													.html(getBook.author);
											$('#td_publishhousename').html(
													getBook.publishhouse.publishhousename);
											$('#td_typebookCfname').html(
													getBook.typebookCf.typebookCfname);
											$('#td_bookstatus').html(
													getBook.statusBook.bookstatus);
											$('#td_readername').html(
													getReader.readername);
											$('#td_readernumber').html(
													getReader.readernumber);
											$('#td_readertype').html(
													getReader.typeReader.readertype);
										} else {
											//console.log(dataJson.tag);
											$('#tag_title')
													.html(
															"借阅失败"
																	+ "<span style='color: red'"+" class='glyphicon  glyphicon-remove'></span>");
											$('#tag_body').html(dataJson.tag);
											;
										}
									},
									error : function() {
										$('#myModalBorrowReturn').modal('show');
										$('#tag_title')
												.html(
														"借阅失败"
																+ "<span style='color: red'"+"	class='glyphicon  glyphicon-remove'></span>");
									}
								})
					})
	//模态框的关闭事件
	$('#myModalBorrowReturn').on('hidden.bs.modal', function() {
		$('#tag_body').html("");
		$('#tag_title').html("");
		reset();
	});
	function reset(){
		$('#bo_booknumber').val("");
		$('#bo_readernumber').val("");
		$("form").data('bootstrapValidator').resetForm();
	}
	$(function() {
		//开启表单验证
		validator();
		$("#div_border").hover(function() {
			$("#div_a").css("visibility", "visible");
		}, function() {
			$("#div_a").css("visibility", "hidden");
		});
		//年份的select框
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