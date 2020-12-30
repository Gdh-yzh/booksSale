<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>登录 - 淘书斋网</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/user.login_form.js"></script>

	</head>
	<body>


		<%@include file="/common/head1.jsp"%>

		<div class="enter_part">

			<%@include file="/common/introduce.jsp"%>

			<div class="enter_in">
				<div class="bj_top"></div>
				<div class="center">
					<div style="height: 30px; padding: 5px; color: red" id="divErrorMssage">
					
					</div>
					<div class="main">
						<h3>
							登录淘书斋网
						</h3>

						<form method="post" action="${pageContext.request.contextPath}/user/login.do?method=1" id="ctl00">
						
							<ul>
								<li>
									<span>请输入Email地址：</span>
									<input type="text" name="email" id="txtUsername" class="textbox" />
								</li>
								<li>
									<span class="blank">密码：</span>
									<input type="password" name="password" id="txtPassword"
										class="textbox" />
								</li>
								<li>
									<input type="submit" id="btnSignCheck" class="button_enter"
										value="登 录" />


								</li>
							</ul>
							<span style="color:red" id="txtLoginErr">${login_err }</span>
							<input type="hidden" name="uri" value="${uri}" />
						</form>
					</div>
					<div class="user_new">
						<p>
							您还不是淘书斋网用户？
						</p>
						<p class="set_up">
							<a href="${pageContext.request.contextPath}/regist.do?method=0">创建一个新用户&gt;&gt;</a>
						</p>
					</div>
				</div>
			</div>
		</div>

		<%@include file="/common/foot1.jsp"%>

	</body>
</html>

