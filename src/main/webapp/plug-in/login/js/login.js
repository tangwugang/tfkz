//防止多次点击登录
var c = 0;

$(function(){
		getCookie();
		//回车登录
		$(document).keydown(function(e){
			if(e.keyCode == 13) {
				submit();
			}
		});
		// 点击登录
		$('.login_btn').click(function(e) {
			submit();
		});
		
		$('input').change(function(){
			hideError();
		});
});


if(top!=this){//当这个窗口出现在iframe里，表示其目前已经timeout，需要把外面的框架窗口也重定向登录页面
	  top.location='${ctx}/loginController.do?login';
}

//刷新验证码
function reload(){
	//var url="${ctx}/servlet/ValidCode?rand=" +new Date().getTime();
	//$("#validImg").attr("src",url);
	//alert('////');
}


//登录处理函数
function Login() {
	setCookie();
	var actionurl=$('form').attr('action');//提交路径
	var checkurl=$('form').attr('check');//验证路径
	 var formData = new Object();
	var data=$(":input").each(function() {
		 formData[this.name] =$("input[name='"+this.name+"']").val();
	});
	$.ajax({
		async : false,
		cache : false,
		type : 'POST',
		url : checkurl,// 请求的action路径
		data : formData,
		error : function() {// 请求失败处理函数
		},
		success : function(data) {
			var d = $.parseJSON(data);
			if (d.success) {
				setTimeout("changBtn('登录成功!请稍后....')",1000);
				setTimeout("window.location.href='"+actionurl+"'", 1000);
			} else {
				c = 0;
				hideError();
				showError(d.msg);
				changBtn('登录');
			}
		}
	});
}
//设置cookie
function setCookie(){
	if ($('input[type="checkbox"]').attr("checked")) {
		$("input[iscookie='true']").each(function() {
			$.cookie(this.name, $("input[name='"+this.name+"']").val(), "/",24);
			$.cookie("COOKIE_NAME","true", "/",24);
		});
	} 
	/*else {
		$("input[iscookie='true']").each(function() {
			$.cookie(this.name,null);
			$.cookie("COOKIE_NAME",null);
		});
	}*/
}

//读取cookie
function getCookie(){
	var COOKIE_NAME=$.cookie("COOKIE_NAME");
	if (COOKIE_NAME !=null) {
		$("input[iscookie='true']").each(function() {
			$($("input[name='"+this.name+"']").val( $.cookie(this.name)));
		});
	} 
}



//表单提交
function submit(){
	if(c >0){return false;}
	var submit = true;
	$("input[nullmsg]").each(function() {
		if ($("input[name='"+this.name+"']").val() == "") {
			hideError();
			showError($("input[name='"+this.name+"']").attr("nullmsg"), 1000);
			$("input[name='"+this.name+"']").focus();
			//setTimeout('hideError()', 1000);
			submit = false;
			return false;
		}
	});
	if (submit) {
		c++;
		changBtn('核实中..');
		setTimeout("Login()", 1000);
	}

}

function changBtn(str){
	$('.login_btn').empty();
	$('.login_btn').text(str);
}

//显示错误提示
function showError(str) {
	$('<div class="warm">'+str+'</div>').appendTo($('.error'));
}

function hideError() {
	$('.error').empty();
}