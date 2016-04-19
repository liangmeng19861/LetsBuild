<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp"%>

<!--主题内容-->
 <div class="wrapper">
  <div class="wp-content">
      <div class="wp-frame">
         <div class="shenq shenq_noborder">接单立项</div>
       <div class="wp-form">
          <ul>
          <li>
          <p class="word">品牌</p>
          <p class=""><input type="text"  class="int-medium"></p>
          </li>
          <li>
          <p class="word">项目编码</p>
          <p class=""><input type="text"  class="int-medium"></p>
          </li>
         </ul>
          <ul>
          <li>
          <p class="word">省份</p>
          <p class=""><select class="select-medium">
               <option>北京</option>
              </select></p>
          </li>
          <li>
          <p class="word">城市</p>
          <p class=""><select class="select-medium">
               <option>北京</option>
              </select></p>
          </li>
         </ul>
         <ul>
          <li>
          <p class="word">商户名称</p>
          <p class=""><input type="text"  class="int-medium"></p>
          </li>
          <li>
          <p class="word">接单时间</p>
          <p class=""><input type="text"  class="int-medium"></p>
          <p><i class="icon-calendar"></i></p>
          </li>
         </ul>
         <ul>
          <li>
          <p class="word">商户地址</p>
          <p class=""><input type="text"  class="int-medium"></p>
          </li>
          <li>
          <p class="word">联系人</p>
          <p class=""><input type="text"  class="int-medium"></p>
          </li>
         </ul>
          <ul>
          <li>
          <p class="word">联系人电话</p>
          <p class=""><input type="text"  class="int-medium"></p>
          </li>
          <li>
          <p class="word">业务类型</p>
          <p class=""><select class="select-medium">
               <option>新柜制作</option>
              </select></p>
          </li>
         </ul>
         
      </div>
   		<div class="wp-btn"><a href="#">取消</a><a href="订单管理－我的订单.html">提交订单</a></div>
      </div>
   </div>
  </div>
<!--主题内容结束-->  


<%@ include file="/jsp/common/footer.jsp"%>