<%@page contentType="text/html;charset=utf-8"%>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
		<!--遍历返回的随机两本书-->
		<c:forEach items="${datas['books'] }" var="book">
		<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<a href="${pageContext.request.contextPath}/main.do?id=${book.id }&method=1" ><img src="${pageContext.request.contextPath}/productImages/${book.productPic }" width=70 border=0 /> </a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href="${pageContext.request.contextPath}/main.do?id=${book.id }&method=1" title='${productName }'>书名:${book.productName }</a>
				</h3>
				<h4>
					作者：${book.author } 著
					<br />
					出版社：${book.publishing }&nbsp;&nbsp;&nbsp;&nbsp;出版时间：${book.publishDt }
				</h4>
				<h5>
					简介:${book.description }
				</h5>
				<h6>
					定价：￥${book.fixedPrice }&nbsp;&nbsp;淘书斋价：￥${book.dangPrice }
				</h6>
				<div class=line_xx></div>
			</div>
		</div>
		</c:forEach>
		
	</div>
</div>
