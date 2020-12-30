<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<title>生成订单 - 淘书斋网</title>
		<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/page_bottom.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<%@include file="/common/head1.jsp"%>
		<div class="login_step">
			生成订单骤:
			<span class="red_bold">1.确认订单</span> > 2.填写送货地址 > 3.订单成功
		</div>
		<div class="fill_message">

			<table class="tab_login">
				<tr>
					<td valign="top" class="w1" style="text-align: left">
						<b>序号</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品名称</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品单价</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品数量</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>小计</b>
					</td>
				</tr>

				<c:forEach items="${s_car }" var="map" varStatus="status">
				<!-- 订单开始 -->
					<tr>
						<td valign="top">
							${status.count}
						</td>
						<td valign="top">
							${map.value.pro.productName }
						</td>
						<td valign="top">
							${map.value.pro.dangPrice }
						</td>
						<td valign="top">
							${map.value.num }
						</td>
						<td valign="top">
							${map.value.pro.dangPrice*map.value.num }
						</td>
					</tr>
					
				<!-- 订单结束 -->
				</c:forEach>
				
				<tr>
					<td valign="top" class="w1" style="text-align: left" colspan="5">
						<b>总价￥${totalDang }</b>
					</td>
				</tr>
			</table>
			<br />
			<br />
			<br />
			<div class="login_in">
				<a href="${pageContext.request.contextPath}/car.do?method=4"><input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="取消" /></a>
			
				<a href="${pageContext.request.contextPath}/order.do?method=1"><input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="下一步" /></a>
		
			</div>

		</div>
		<%@include file="/common/foot1.jsp"%>
	</body>
</html>

