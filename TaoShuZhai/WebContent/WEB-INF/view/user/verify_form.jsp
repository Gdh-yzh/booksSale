<%@page contentType="text/html;charset=utf-8"%>
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
			注册步骤: 1.填写信息 >
			<span class="red_bold">2.验证邮箱</span> > 3.注册成功
		</div>
		<form action="regist.do?method=2" method="post">
			<div class="validate_email">
				<h2>
					感谢您注册淘书斋网！现在请按以下步骤完成您的注册!
				</h2>
				<div class="look_email">
					<h4>
						第一步：查看您的电子邮箱
					</h4>
					<div class="mess reduce_h">
						我们给您发送了验证邮件，邮件地址为：
						<a href="${pageContext.request.contextPath}/emailcode.jsp" target="_blank" ><span class="red"><span id="lblEmail">${s_user.email }</span></a>
						</span>
						<span class="t1"> 
						请登录您的邮箱收信。
					</div>
					<h4>
						第二步：输入验证码
					</h4>
					<div class="mess">
						<span class="write_in">输入您收到邮件中的验证码：</span>
						<input name="code" type="text" id="validatecode" class="yzm_text" 
						value="${s_user.emailVerifyCode}-${s_user.id }" />
						<input class="finsh" type="submit" value="完 成" id="Button1" />
						<span id="errorMsg" class="no_right">${verify_err }</span>
					</div>
				</div>
			</div>
		</form>
		<%@include file="/common/foot1.jsp"%>
	</body>
</html>

