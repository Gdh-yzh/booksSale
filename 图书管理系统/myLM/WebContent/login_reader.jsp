<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>wyu图书管理系统-登录界面</title>
<style type="text/css"></style>
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<script type="text/javascript" src="login_style/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="login_style/css/supersized.css">
<link rel="stylesheet" href="login_style/css/login.css">
</head>
<body>
	<div id="div_topName">
		<div align="right" style="line-height: 50px; padding-right: 20px;font-weight: bold;font-size: 25px;">
			<i>wyu图书管理系统</i>
		</div>
	</div>
	<div id="div_login">
		<div id="div_select">
			<table>
				<tr>
					<td><a id="login">用户登录</a></td>
				</tr>
			</table>
		</div>
		<div id="div_form">
			<form action="${pageContext.request.contextPath}/loginReader" method="post">
				<table>
					<tr>
						<td colspan="1"><input type="text" name="number"
							placeholder="用户编码"></td>
						<td class="td1"><img src="login_style/img/user.png" alt=""
							style="width: 20px;"></td>
					</tr>
					<tr>
						<td><input type="password" name="password" placeholder="密码"></td>
						<td class="td1"><img src="login_style/img/password.png"
							alt="" style="width: 20px;"></td>
					</tr>
					<tr style="background-color: inherit">
						<td colspan="3">
							<div id="div_button">
								<input id="input_submit" type="submit" value="登录">
							</div>
						</td>
					</tr>
					<tr style="background-color: inherit">
						<td colspan="3">
							<div id="div_beizhu">
								<a style="float: right;color: white;font-size: 14px;">该系统仅供图书管理员使用，如需申请用户账号请向图书馆提出纸质申请</a>
							</div>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<script src="login_style/js/supersized.3.2.7.min.js"></script>
	<script src="login_style/js/supersized-init.js"></script>
</body>
<!-- js:javascript代码 -->
<script type="text/javascript">
	$(function() {
		var loginfo = '${loginfo}';
		if (loginfo != "") {
			$.messager.alert('登录失败', loginfo, 'error');
		}
	});
</script>
</html>