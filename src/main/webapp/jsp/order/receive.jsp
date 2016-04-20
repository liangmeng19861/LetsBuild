<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp"%>

<script type="text/javascript">

(function($) {

	$.Controller = function() {
		this.settings = $.extend(true, {}, $.Controller.defaults);//构造方法：将管理页面的变量赋给this.settings
	};
	$.extend($.Controller, {
		defaults : {// 声明全局变量
			submitBtn : "#submitBtn"
		},
		prototype : {// 声明全局方法
			init : function() {
				var _this = this;
				//初始化省市下拉列表
				$("#provcity").citySelect({
					nodata:"none",
					required:false
				});
				//初始化日期
				$('#receiveTime').datetimepicker({
					autoclose: true,
					todayBtn:true,
					todayHighlight:true,
					language:"zh-CN",
					format: 'yyyy-mm-dd hh:ii:ss'
				});
				//绑定事件
				_this.bindEvents();
			},
			bindEvents : function() {
				var _this = this;
				var param = {};
				$(_this.settings.submitBtn).bind("click", function () {
					param.brandCode=$("#brandCode").val();
					param.projectCode=$("#projectCode").val();
					param.provinceCode=$("#provinceCode").val();
					param.cityCode=$("#cityCode").val();
					param.merchant=$("#merchantName").val();
					param.receiveTime=$("#receiveTime").val();
					param.address=$("#address").val();
					param.contactName=$("#contactName").val();
					param.contactTel=$("#contactTel").val();
					param.type=$("#orderType").val();
					content_url = "${_base}/order/receive";
					$.ajax({
						async : false,
						type : "POST",
						url : content_url,
						modal : true,
						data : param,
						success : function(data) {
							alert(111);
							///$(_this.settings.result).html(data);
						},
						error:function(data){
							alert(222);
							//$.dialog.alert("数据请求失败！");
						}
					});
				});
			}
		}
	});
})(jQuery)
</script>

<!--主题内容-->
 <div class="wrapper">
  <div class="wp-content">
      <div class="wp-frame">
         <div class="shenq shenq_noborder">接单立项</div>
       <div class="wp-form">
          <ul>
          <li>
          <p class="word">品牌</p>
          <p class="">
          	<lb:select cssClass="int-medium" id="brandCode" columnName="BRAND_CODE" tableName="ORD_ORDER"></lb:select>
          </p>
          </li>
          <li>
          <p class="word">项目编码</p>
          <p class=""><input id="projectCode" type="text"  class="int-medium"></p>
          </li>
         </ul>
         <div id="provcity">
	          <ul>
	          <li>
	          <p class="word">省份</p>
	          <p class=""><select id="provinceCode" class="select-medium prov">
	               <option>北京</option>
	              </select></p>
	          </li>
	          <li>
	          <p class="word">城市</p>
	          <p class=""><select id="cityCode" class="select-medium city">
	               <option>北京</option>
	              </select></p>
	          </li>
	         </ul>
         </div>
         <ul>
          <li>
          <p class="word">商户名称</p>
          <p class=""><input id= "merchantName" type="text"  class="int-medium"></p>
          </li>
          <li>
          <p class="word">接单时间</p>
          <p class=""><input id="receiveTime" class="int-medium span2" size="16" type="text">
          <p><i class="icon-calendar"></i></p>
          </li>
         </ul>
         <ul>
          <li>
          <p class="word">商户地址</p>
          <p class=""><input id="address" type="text"  class="int-medium"></p>
          </li>
          <li>
          <p class="word">联系人</p>
          <p class=""><input id="contactName" type="text"  class="int-medium"></p>
          </li>
         </ul>
          <ul>
          <li>
          <p class="word">联系人电话</p>
          <p class=""><input id="contactTel" type="text"  class="int-medium"></p>
          </li>
          <li>
          <p class="word">业务类型</p>
          <p class="">
          	<lb:select cssClass="int-medium" id="orderType" columnName="TYPE" tableName="ORD_ORDER"></lb:select>
		 </p>
          </li>
         </ul>
         
      </div>
   		<div class="wp-btn"><a onclick="window.history.back()">取消</a><a id="submitBtn">提交订单</a></div>
      </div>
   </div>
  </div>
<!--主题内容结束-->  


<%@ include file="/jsp/common/footer.jsp"%>