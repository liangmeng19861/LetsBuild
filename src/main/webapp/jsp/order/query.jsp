<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/header.jsp"%>
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
               <lb:select cssClass="query_select form-control" name="" id="" columnName="BRAND_CODE" defaultLabel="全部" tableName="ORD_ORDER"></lb:select>
             </li>
             <div class="wih50">
              <li class="field">项目编码：</li>
              <li><input type="text" class="query_input form-control"></li>
             </div>
            </ul>
            
            <ul>
            <li class="field">省份：</li>
            <li>
              <select class="query_select form-control">
               <option>正常</option>
              </select>
            </li>
            <div class="wih50">
             <li class="field">城市：</li>
             <li>
              <select class="query_select form-control">
               <option>正常</option>
              </select>
             </li>
            </div>
            </ul>
            
            <ul>
             <li class="field">订单名称：</li>
             <li><input type="text" class="query_input form-control"></li>
             <div class="wih50">
              <li class="field">接单时间：</li>
              <li><input type="text" class="query_input form-control"><a href="#"><i class="icon-calendar"></i></a></li>
              <span class="centerx">-</span>
              <li><input type="text" class="query_input form-control"><a href="#"><i class="icon-calendar"></i></a></li>
             </div>
            </ul>

            <ul>
            <li class="field"></li>
            <li class="query_btn"><a href="#">查询</a></li>
            </ul>
           
            </div>
        </div>
     </div>
      <div class="query_list_cnt">
       <div class="query_duan"><!--查询区域-->
         <div class="shenq shenq_noborder">渠道信息</div>
            <div class="query_last theone">
             <ul><li><p class="new_jia"> <a href="#"><i class="icon-plus"></i></a></p><p class="new_xinz"><a href="#">新增渠道</a></p></li></ul>
            </div>
            
            </div>
            <div class="list"><!--列表区域-->
            <table width="100%" border="0">
              <thead><tr class="tr_bj">
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
              <tr valign="middle">
                <td> </td>
                <td> </td>
                <td> </td>
                <td> </td>
                <td> </td>
                <td><img src="images/icon1.png"> 接单立项</td>
                <td><a href="#">报价</a></td>
                                                                                                                                  
              </tr>
              <tr valign="middle">
                <td> </td>
                <td> </td>
                <td> </td>
                <td> </td>
                <td> </td>
                <td><img src="images/icon2.png"> 已报价</td>
                <td><a href="#">下单制作</a></td>
                                                                                                                                  
              </tr>
              <tr valign="middle">
                <td> </td>
                <td> </td>
                <td> </td>
                <td> </td>
                <td> </td>
                <td><img src="images/icon3.png"> 已验收</td>
                <td><a href="#">申请开票</a></td>
                                                                                                                                  
              </tr>
              <tr valign="middle">
                <td> </td>
                <td> </td>
                <td> </td>
                <td> </td>
                <td> </td>
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
            <li>
              <a href="#" aria-label="Previous">
                <span aria-hidden="true">«</span>
              </a>
            </li>
            <li class="cutt"><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li>
              <a href="#" aria-label="Next">
                <span aria-hidden="true">»</span>
              </a>
            </li>
          </ul>
        </nav>
            
    </div>
   </div>
   </div>
  </div>
<!--主题内容结束-->

<%@ include file="/jsp/common/footer.jsp"%>
