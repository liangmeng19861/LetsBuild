<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="list">
	<!--列表区域-->
	<table width="100%" border="0">
		<thead>
			<tr class="tr_bj">
				<td>项目编码</td>
				<td>项目名称</td>
				<td>品牌</td>
				<td>省份</td>
				<td>地市</td>
				<td>状态</td>
				<td>操作</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="" var="">
				<tr valign="middle">
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><img src="images/icon1.png"> 接单立项</td>
					<td><a href="#">报价</a></td>
	
				</tr>
			</c:forEach>
			<tr valign="middle">
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><img src="images/icon2.png"> 已报价</td>
				<td><a href="#">下单制作</a></td>

			</tr>
			<tr valign="middle">
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><img src="images/icon3.png"> 已验收</td>
				<td><a href="#">申请开票</a></td>

			</tr>
			<tr valign="middle">
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><img src="images/icon4.png"> 已制作</td>
				<td><a href="#">验收</a></td>

			</tr>
		</tbody>
	</table>
</div>
<!--分页-->
<div class="Paging">
	<nav>
		<ul class="pagination">
			<li><a href="#" aria-label="Previous"> <span
					aria-hidden="true">«</span>
			</a></li>
			<li class="cutt"><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#" aria-label="Next"> <span aria-hidden="true">»</span>
			</a></li>
		</ul>
	</nav>

</div>