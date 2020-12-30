<%@page contentType="text/html;charset=utf-8"%>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">

	<!--热销图书A开始-->
	<c:forEach items="${datas['newBooks'] }" var="newBooks">
	<div class="second_d_wai">
		<div class="img">
			<a href="${pageContext.request.contextPath}/main.do?id=${newBooks.id }&method=1"><img
					src="${pageContext.request.contextPath}/productImages/${newBooks.productPic }" border=0 /> </a>
		</div>
		<div class="shuming">
			<a href="${pageContext.request.contextPath}/main.do?id=${newBooks.id }&method=1" >${newBooks.productName }</a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：￥${newBooks.fixedPrice }
		</div>
		<div class="price">
			淘书斋价：￥${newBooks.dangPrice }
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	</c:forEach>
	<!--热销图书A结束-->

</div>
<div class="clear"></div>