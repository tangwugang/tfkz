// JavaScript Document

	   
$(document).ready(function(){
	//全局的ajax访问，处理ajax清求时sesion超时  
	 $.ajaxSetup({   
	     contentType:"application/x-www-form-urlencoded;charset=utf-8",   
	     complete:function(XMLHttpRequest,textStatus){   
	      if(XMLHttpRequest.status == 403){//session过期   
		    	//判断如果当前页面不为主框架，则将主框架进行跳转
		  	  	var tagert_URL = "loginController.do?login";
		  	    if(self==top){
		  	    	window.location.href = tagert_URL;
		  	    }else{
		  	    	top.location.href = tagert_URL;
		  	    }
	         }   
	       }   
	 });
	 
	 //App.init();
	 
	 
});


