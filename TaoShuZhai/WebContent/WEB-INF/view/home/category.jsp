<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		<!--1级分类开始  遍历结果集，显示category的name-->
		<c:forEach items="${datas['category']}" var="category">
			<div class="bg_old" onmouseover="this.className = 'bg_white';" onmouseout="this.className = 'bg_old';">
				<h3>
					<!--显示category的name-->
					[<a href='#'>${category.name}</a>]
				</h3>
				<ul class="ul_left_list">
					<c:forEach items="${category.subCats}" var="subCats">
						<!--2级分类开始  遍历2级结果集，显示subCats.name，建一个超链接c1=category.id&c2=subCats.id-->
						<li>
							<a href='${pageContext.request.contextPath}/main/booklistAction?c1=${category.id}&c2=${subCats.id}'>${subCats.name}</a>
						</li>
						<!--2级分类结束-->
					</c:forEach>
				</ul>
				
				<div class="empty_left">
				</div>
			</div>

			<div class="more2">
			</div>
			<!--1级分类结束-->
		</c:forEach>
		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
