<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<title>用户注册 - 淘书斋网</title>
		<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/page_bottom.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<%@include file="/common/head1.jsp"%>
		<div class="login_step">
			注册步骤: 1.填写信息 > 2.验证邮箱 >
			<span class="red_bold">3.注册成功</span>
		</div>


		<div class="login_success">
			<div class="login_bj">
				<div class="succ">
					<img src="${pageContext.request.contextPath}/images/login_success.jpg" />
				</div>
				<h5>
					${s_user.nickname }，欢迎加入淘书斋网
				</h5>
				<h6>
					请牢记您的登录邮件地址：${s_user.email }
				</h6>

				<ul>
					<li class="nobj">
						您现在可以：
					</li>
					<li>
						进入“
						<a href="#">我的淘书斋</a>”查看并管理您的个人信息
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/main/mainAction">浏览并选购商品</a>
					</li>
				</ul>
			</div>
		</div>

		<%@include file="/common/foot1.jsp"%>
	</body>
</html>

