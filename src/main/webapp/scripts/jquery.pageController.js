/**
 *页面ajax交互处理类
 *@version 1.0
 *@author liangmeng
 *2012-07-06
 */
		(function($){
			
			/*定义页面交互处理类*/
			$.PageManager = function(){
				this.settings = $.extend(true,{},$.PageManager.defaults);
			}
			
			/*为页面交互处理类扩展属性,并 继承方法*/
			$.extend($.PageManager,{
				/*扩展属性*/
				defaults: {
					
				},
				
				/*继承原型的方法*/
				prototype: {
					/**
					 * 封装ajax方法 ，增加处理中遮罩
					 */
					CPUAjax:function(options){
						var _this = this;
						/**1.转换各种回调函数*/
						var callbacks = {};
						if(typeof options.success=='function'){
							callbacks["success"] = options.success;
							delete options.success;
						} 
						if(typeof options.error=='function'){
							callbacks["error"] = options.error;
							delete options.error;
						} 
						/**2.获取提交方式、url、入参等参数*/
						var type = options.type?options.type:"POST";
						var url = options.url;
						var message = options.message?options.message:"正在处理中，请稍候...";
						var data = options.data;
						var dataType = options.dataType;
						var contentType = options.contentType;
						
						/**3.调用jquery的ajax方法*/
						$.ajax({						   
						   type: type,
						   url: url,
						   data: data,
						   dataType:dataType, 
						   contentType:contentType,
						   /**3.1 正在加载提示*/
						   beforeSend:function(){
						   	  jLoading(message);
						   },
						   success: function(ret_data){
						   	 /**3.2 隐藏加载提示*/
						   	 jHide();
						   	 /**3.3 调用成功回调方法*/
						     callbacks["success"].call(this,ret_data);
						   },
						   /**3.4 调用报错回调方法*/
						   error:function(XMLHttpRequest, textStatus, errorThrown){
						   	 callbacks["error"].call(this,textStatus);
						   }
						});
					}
				}
			})
		})(jQuery)
		var pageManager = new $.PageManager();