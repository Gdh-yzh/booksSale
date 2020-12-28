<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>wyu图书管理系统</title>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">
<script src="bootstrap-3.3.7-dist/jquery.min.js"></script>
<link rel="stylesheet" href="css/lms_bs.css">
</head>
<body>
	<div class="container-fluid">
		<!-- 顶部 -->
		<div class="row" id="div_topRow">
			<div class="col-md-12">
				<div style="width: 100%;">
					<img alt="" src="login_style/img/selfImg/logo1.PNG"
						style="width: 300px">
					<div id="div_userInfo" class="hidden-xs"
						style="width: 300px; float: right; padding: 10px;">
						您好,${reader.readername}<br> <span class="glyphicon glyphicon-time"
							aria-hidden="true"></span><span id="ptime"></span>
					</div>
				</div>
			</div>
		</div>
		<!-- 导航栏 -->
		<div class="row" id="div_topNavbarRow">
			<div class="col-md-12 hidden-xs">
				<nav class="navbar navbar-blue"><!-- navbar-blue -->
					<div class="container-fluid">
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse"
							id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
								<li  class="active"id="welcome"><a href="#"><span
										class="glyphicon glyphicon-home" aria-hidden="true"></span>首页
										<span class="sr-only"></span></a></li>
								<li id="addBorrow"><a href="#"><span
										class="glyphicon glyphicon-log-out" aria-hidden="true"></span>借阅</a></li>
								<li id="returnBorrow"><a href="#"><span
										class="glyphicon glyphicon-log-in" aria-hidden="true"></span>归还</a></li>
								<li id="queryBook2"><a href="#"><span
										class="glyphicon glyphicon-search" aria-hidden="true"></span>图书查询</a></li>
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown" role="button" aria-haspopup="true"
									aria-expanded="false"><span
										class="glyphicon glyphicon-list" aria-hidden="true"></span>分类<span
										class="caret" style="padding-right: 0px;"></span></a>
									<ul class="dropdown-menu">
										<li id="classification_book"><a href="#"><span
												class="glyphicon glyphicon-align-left" aria-hidden="true"></span>图书分类</a></li>
										<li id="publishhouse"><a href="#"><span
												class="glyphicon glyphicon-align-left" aria-hidden="true"></span>出版社分类</a></li>
										<li id="typecirculation_book"><a href="#"><span
												class="glyphicon glyphicon-align-left" aria-hidden="true"></span>图书流通分类</a></li>
										<li role="separator" class="divider"></li>
										<li id="type_reader"><a href="#"><span
												class="glyphicon glyphicon-align-left" aria-hidden="true"></span>读者类型</a></li>
										<li id="typebook_cf"><a href="#"><span
												class="glyphicon glyphicon-align-left" aria-hidden="true"></span>图书类型</a></li>
										<li role="separator" class="divider"></li>
										<li id="status_book"><a href="#"><span
												class="glyphicon glyphicon-align-left" aria-hidden="true"></span>图书状态</a></li>
									</ul></li>
								<li id="exit"><a href="#"><span
										class="glyphicon glyphicon-log-out" aria-hidden="true"></span>退出</a></li>
							</ul>
						</div>
						<!-- /.navbar-collapse -->
					</div>
					<!-- /.container-fluid -->
				</nav>
			</div>
		</div>
		<!-- 整体中间部分 -->
		<div class="row" id="div_centerRow">
			<!-- 左布局 -->
			<div id="div_left" class="col-md-2">
				<!-- 第一个折叠菜单 -->
				<div class="panel panel-default" id="one">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapseOne"><span
								class="glyphicon glyphicon-book" aria-hidden="true"></span>系统功能<span
								id="be_rightIcon" class="glyphicon glyphicon-menu-down"
								aria-hidden="true"></span></a>
						</h4>
					</div>
					<div id="collapseOne" class="panel-collapse collapse in">
						<div class="panel-body">
							<ul>
								<li id="queryBook"><a href="#"><span
										class="glyphicon glyphicon-align-left" aria-hidden="true"></span>图书查询</a></li>
								<li id="addborrow2"><a href="#"><span
										class="glyphicon glyphicon-align-left" aria-hidden="true"></span>图书借阅</a></li>
								<li id="returnBorrow2"><a href="#"><span
										class="glyphicon glyphicon-align-left" aria-hidden="true"></span>图书归还</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<!-- 中布局 -->
			<div id="div_center" class="col-md-9">
				<div class="breadcrumb">
					当前路径:<span id="titlePath" class="text-primary">首页</span>
				</div>
				<!-- 16:9 aspect ratio -->
				<div class="embed-responsive embed-responsive-16by9">
					<iframe class="embed-responsive iframe" id="iframe_pl"></iframe>
				</div>
			</div>
			<!-- 右布局 -->
			<div id="div_right" class="col-md-1" style="border: none;">
				<div class="breadcrumb">
				系统说明:
				</div>
				<p style="width: 100px;padding-left: 15px;">本系统为读者提供更为简单便捷的线上图书馆服务。</p>
			</div>
		</div>
		<div class="row" id="div_buttonRow">
			<div class="col-md-12 hidden-xs">
				<h5>gdh@wyu版权所有</h5>
			</div>
		</div>
	</div>
<!-- 退出 -->
	<div class="modal fade" id="modal_exit" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"></button>
					<h4 id="tag_title" class="modal-title" id="myModalLabel">退出
					<span style="color: green" class="glyphicon  glyphicon-alert"></span></h4>
				</div>
				<div class="modal-body">
					<p id="info_body">是否退出wyu图书管理系统？</p>
				</div>
				<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-default" id="exit_ok">确定</button>
				</div>
			</div>
		</div>
	</div>
</body>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
	var mytime = setInterval(function() {
		getTime();
	}, 1000);
	function getTime() {
		var d = new Date();
		var M = (d.getMonth() + 1) < 10 ? ('0' + (d.getMonth() + 1)) : d
				.getMonth() + 1;
		var D = d.getDate() < 10 ? ('0' + d.getDate()) : d.getDate();
		var H = d.getHours() < 10 ? ('0' + d.getHours()) : d.getHours();
		var m = d.getMinutes() < 10 ? ('0' + d.getMinutes()) : d.getMinutes();
		var s = d.getSeconds() < 10 ? ('0' + d.getSeconds()) : d.getSeconds();
		var t = d.getFullYear() + "年" + M + "月" + D + "日&nbsp;&nbsp;" + H + ":"
				+ m + ":" + s + "&nbsp;&nbsp星期" + "日一二三四五六".charAt(d.getDay());
		$("#ptime").html(t);
	}
	//退出
	$("#exit").click(function(){
		$('#modal_exit').modal('show');	
	});
	$("#exit_ok").click(function(){
		window.location.href = "${pageContext.request.contextPath}/"+"login_reader.jsp";
	});
	$(function() {
		//默认加载
		$("#iframe_pl").attr("src", "welcome.jsp");
		path();
		changeBack();	
	});
	//改变背景颜色
	function changeBack(){
		$("#welcome").click(function() {
			//setBack("#welcome");
		});
	}
	function setBack(id){
		 $(id).removeClass("active").addClass("newactive");
		// alert("我来这里了");
	}
	//路径
	function path(){
		//局部加载
		$("#addBook").click(function() {
			changeLoad("#addBook", "addBook.jsp");
		});
		$("#welcome").click(function() {
			changeLoad("#welcome", "welcome.jsp");
		});
		$("#bookManagement").click(function() {
			changeLoad("#bookManagement", "bookManagement.jsp");
		});
		$("#classification_book").click(function() {
			changeLoad("#classification_book", "classification_book.jsp");
		});
		$("#publishhouse").click(function() {
			changeLoad("#publishhouse", "publishhouse.jsp");
		});
		$("#typecirculation_book").click(function() {
			changeLoad("#typecirculation_book", "typecirculation_book.jsp");
		});
		$("#type_reader").click(function() {
			changeLoad("#type_reader", "type_reader.jsp");
		});
		$("#typebook_cf").click(function() {
			changeLoad("#typebook_cf", "typebook_cf.jsp");
		});
		$("#status_book").click(function() {
			changeLoad("#status_book", "status_book.jsp");
		});
		$("#rold").click(function() {
			changeLoad("#rold", "rold.jsp");
		});
		$("#queryBook").click(function() {
			changeLoad("#queryBook", "queryBook.jsp");
		});
		$("#queryReader").click(function() {
			changeLoad("#queryReader", "queryReader.jsp");
		});
		$("#queryBook2").click(function() {
			changeLoad("#queryBook", "queryBook.jsp");
		});
		$("#readerManagement").click(function() {
			changeLoad("#readerManagement", "readermg.jsp");
		});
		$("#addReader").click(function() {
			changeLoad("#addReader", "addReader.jsp");
		});
		$("#addBorrow").click(function() {
			changeLoad("#addBorrow", "addBorrow.jsp");
		});
		$("#returnBorrow").click(function() {
			changeLoad("#returnBorrow", "returnBorrow.jsp");
		});
		//addborrow2  returnBorrow2
		$("#addborrow2").click(function() {
			changeLoad("#addBorrow", "addBorrow.jsp");
		});
		$("#returnBorrow2").click(function() {
			changeLoad("#returnBorrow", "returnBorrow.jsp");
		});
		$("#borrowManagement").click(function() {
			changeLoad("#borrowManagement", "borrowManagement.jsp");
		});
		$("#readerCount").click(function() {
			changeLoad("#readerCount", "readerCount.jsp");
		});
		$("#dataCount").click(function() {
			changeLoad("#dataCount", "dataCount.jsp");
		});
		$("#borrowCount2").click(function() {
			changeLoad("#borrowCount2", "borrowCount2.jsp");
		});
		$("#borrowCount").click(function() {
			changeLoad("#borrowCount", "borrowCount.jsp");
		});
	}
	function changeLoad(id, url) {
		title = $(id).text();
		if (title != $("#titlePath").text()) {
			$("#iframe_pl").attr("src", url);
			$("#titlePath").text(title);
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
	//模态框居中 myModalBorrowReturn myModalBorrowReturn myModalCertain
	$('#modal_exit').on('show.bs.modal', function(e) {
		modalCenter("#modal_exit");
	})
</script>
</html>