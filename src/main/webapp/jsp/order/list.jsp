<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.letsbuild.com/tag" prefix="lb" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String basepath = request.getContextPath();
			request.setAttribute("_base", basepath);

			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setHeader("Pragma", "No-cache");	
%>
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
			<c:forEach items="${ orderList}" var="order">
				<tr valign="middle">
					<td>${order.projectCode }</td>
					<td>${order.merchant }</td>
					<td>${order.brandCode }</td>
					<td>${order.provinceCode }</td>
					<td>${order.cityCode }</td>
					<td><lb:label columnName="STATUS" tableName="ORD_ORDER" value="${order.status}" ></lb:label></td>
					<td>
						<c:choose>
							<c:when test="${order.status == 1}"><a href="${_base}/order/quotes/${order.id}"><i class="icon-bar-chart"></i>报价</a></c:when>
							<c:when test="${order.status == 2}"><a href="${_base}/order/submit/${order.id}"><i class="icon-wrench"></i>下单</a></c:when>
							<c:when test="${order.status == 3}"><a href="${_base}/order/acceptance/${order.id}"><i class="icon-ok-circle"></i>验收</a></c:when>
							<c:when test="${order.status == 4}"><a href="${_base}/order/invoice/${order.id}"><i class="icon-book"></i>开票</a></c:when>
							<c:when test="${order.status == 5}"><a href="${_base}/order/income/${order.id}"><i class="icon-euro"></i>回款</a></c:when>
							<c:when test="${order.status == 6}"><a href="${_base}/order/edit/${order.id}"><i class="icon-edit"></i>修改</a></c:when>
						</c:choose>
						
					</td>
	
				</tr>
			</c:forEach>
			
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