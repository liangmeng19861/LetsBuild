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
<html lang="en">
<head>
<meta charset="utf-8" />
<title>ADking订单系统</title>
<meta name="description"
	content="app, web app, responsive, responsive layout, admin, admin panel, admin dashboard, flat, flat ui, ui kit, AngularJS, ui route, charts, widgets, components" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<link rel="stylesheet" href="${_base}/styles/bootstrap.css"
	type="text/css" />
<link rel="stylesheet" href="${_base}/styles/font-awesome.css"
	type="text/css" />
<link rel="stylesheet" href="${_base}/styles/frame.css" type="text/css" />
<link rel="stylesheet" href="${_base}/styles/comp.css" type="text/css" />
<script type="text/javascript" src="${_base}/scripts/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${_base}/scripts/jquery.alerts.js"></script>
<script type="text/javascript"
	src="${_base}/scripts/jquery.pageController.js"></script>
<script type="text/javascript">
	/*声明一个页面管理对象*/
	var controller = null;

	/*当页面加载时执行的动作*/
	$(document).ready(function() {
		/*实例化页面管理类*/
		controller = new $.Controller();
		controller.init();
		/*页面加载时进行查询操作*/
	});

	(function($) {
		$.Controller = function() {
			this.settings = $.extend(true, {}, $.Controller.defaults);//构造方法：将管理页面的变量赋给this.settings
		};
		$.extend($.Controller, {
			defaults : {// 声明全局变量
				leftMenu : ".left-cnt li a"
			},
			prototype : {// 声明全局方法
				init : function() {
					var _this = this;
					_this.bindEvents();
					_this.initMenu();
				},
				bindEvents : function() {
					var _this = this;
					//$(_this.settings.leftMenu).bind("click", function() {
						//alert($(this).attr("menuid"))
					//});
				},
				initMenu:function(){
					//$.each($(_this.settings.leftMenu),function(){
						//if(window.location.pathname.sta)
					//});
					
				}
				
				
			}
		});
	})(jQuery);
</script>
</head>
<body>
	<!--头部-->
	<div class="header">
		<div class="logo">
			<a href="#"><img src="${_base}/images/logo.png"></a>
		</div>
		<div class="headcrumb">
			<ul>
				<li>我的订单</li>
				<li><i class="icon-angle-right"></i>订单详情</li>
			</ul>
		</div>
		<div class="nav">
			<!-- 二级菜单 -->
			<ul>
				<c:forEach items="${menulist}" var="menu" varStatus="i">
					<c:if test="${menu.pmenu == -1 && menu.current == 'YES' }">
						<c:forEach items="${menu.childMenu}" var="childMenu" varStatus="i">
							<c:choose>
								<c:when test="${childMenu.current == 'YES'}">
									<li class="current"><a href="${_base}${childMenu.url }">${childMenu.name }</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="${_base}${childMenu.url }">${childMenu.name }</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
				</c:forEach>
				<!-- 
				<li class="current"><a href="${_base}/order/edit">接单立项</a></li>
				<li><a href="#">我的订单</a></li>
				<li><a href="#">我的预警</a></li>
				 -->
			</ul>
		</div>
		<div class="user-cnt">
			<p>
				<img src="${_base}/images/login_user.png"><span>${fullname}</span><a
					href="${_base}/logout"><i class="icon-off"></i></a>
			</p>
		</div>
	</div>
	<!--头部结束-->

	<!--左侧菜单-->
	<div class="left-cnt">
		<ul>
			<!-- 一级菜单 -->
			<c:forEach items="${menulist}" var="menu" varStatus="i">
				<c:if test="${menu.pmenu == -1 }">
					<c:choose>
						<c:when test="${menu.current == 'YES'}">
							<li class="tpList${menu.id}"><a class="current"
								href="${_base}${menu.url}">${menu.name }</a></li>
						</c:when>
						<c:otherwise>
							<li class="tpList${menu.id}"><a href="${_base}${menu.url }">${menu.name }</a></li>
						</c:otherwise>
					</c:choose>
				</c:if>
			</c:forEach>
			<!-- 
			<li class="tpList1"><a class="current" href="#">订单管理</a></li>
			<li class="tpList2"><a href="#">财务管理</a></li>
			<li class="tpList3"><a href="#">押金管理</a></li>
			<li class="tpList4"><a href="#">垫付管理</a></li>
			<li class="tpList5"><a href="#">业务报表</a></li>
			<li class="tpList6"><a href="#">系统管理</a></li>
			 -->
		</ul>
	</div>
	<!--左侧菜单结束-->