<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp"%>
<!-- 省市文件过大，只有在使用时引用 -->
<script type="text/javascript" src="${_base}/scripts/sitejs/jquery.cityselect.js"></script>
<script type="text/javascript">

(function($) {
	$.Controller = function() {
		this.settings = $.extend(true, {}, $.Controller.defaults);//构造方法：将管理页面的变量赋给this.settings
	};
	$.extend($.Controller, {
		defaults : {// 声明全局变量
			result : "#result",
			qryBtn : "#qryBtn"
		},
		prototype : {// 声明全局方法
			init : function() {
				var _this = this;
				//初始化省市下拉列表
				$("#provcity").citySelect({
					nodata:"none",
					required:false
				});
				//绑定事件
				_this.bindEvents();
			},
			bindEvents : function() {
				var _this = this;
				$(_this.settings.qryBtn).bind("click", function () {
					_this.query();
				});
				
			},
			query:function(page){
				var _this = this;
				var param = {};
				if(page){
					param.pageNo=page;
				}else{
					param.pageNo=1;
				}
				param.brandCode=$("#brandCode").val();
				param.projectCode=$("#projectCode").val();
				param.provinceCode=$("#provinceCode").val();
				param.cityCode=$("#cityCode").val();
				param.receiveTimeStart=$("#receiveTimeStart").val();
				param.receiveTimeEnd=$("#receiveTimeEnd").val();
				param.merchantName=$("#merchantName").val();
				//发送查询请求
				var content_url = "${_base}/order/query";
				$.ajax({
					async : false,
					type : "POST",
					url : content_url,
					modal : true,
					showBusi : false,
					data : param,
					success : function(data) {
						$(_this.settings.result).html(data);
					},
					error:function(data){
						$.dialog.alert("数据请求失败！");
					}
				});
			}
			
			
			
		}
	});
})(jQuery);
</script>
<!--主题内容-->
 <div class="wrapper">
  <div class="wp-content">
   <div class="query_list_main">
           <div class="query"><!--查询区域-->
            <div class="query_nones">
            
            <ul>
             <li class="field">品牌：</li>
             <li>
             <!-- 
              <select class="query_select form-control" >
               <option>正常</option>
              </select>
               -->
               <lb:select cssClass="query_select form-control" id="brandCode" columnName="BRAND_CODE" defaultLabel="全部" tableName="ORD_ORDER"></lb:select>
             </li>
             <div class="wih50">
              <li class="field">项目编码：</li>
              <li><input id="projectCode" type="text" class="query_input form-control"></li>
             </div>
            </ul>
			<ul>
			
				<div id="provcity">
				<li class="field">省份：</li>
				<li>
					<select id="provinceCode" class="query_select form-control prov"></select>
				</li>
				<div class="wih50">
	             <li class="field">城市：</li>
	             <li>
	              <select id="cityCode" class="query_select form-control city"></select>
	             </li>
	            </div>
	            
				</div>
			</ul>
            
            <ul>
             <li class="field">商场名称：</li>
             <li><input id= "merchantName" type="text" class="query_input form-control"></li>
             <div class="wih50">
              <li class="field">接单时间：</li>
              <li><input id="receiveTimeStart" type="text" class="query_input form-control"><a href="#"><i class="icon-calendar"></i></a></li>
              <span class="centerx">-</span>
              <li><input id="receiveTimeEnd" type="text" class="query_input form-control"><a href="#"><i class="icon-calendar"></i></a></li>
             </div>
            </ul>

            <ul>
            <li class="field"></li>
            <li class="query_btn"><a href="#" id="qryBtn">查询</a></li>
            </ul>
           
            </div>
        </div>
     </div>
      <div class="query_list_cnt">
       <div class="query_duan"><!--查询区域-->
         <div class="shenq shenq_noborder">订单信息</div>
            <div class="query_last theone">
             <!-- <ul><li><p class="new_jia"> <a href="#"><i class="icon-plus"></i></a></p><p class="new_xinz"><a href="#">新增渠道</a></p></li></ul> -->
            </div>  
          </div>
          <div id="result">
          
          </div>
   </div>
   </div>
  </div>
<!--主题内容结束-->

<%@ include file="/jsp/common/footer.jsp"%>
