/**
Core script to handle the entire layout and base functions
**/
var App = function () {

    // IE mode
    var isRTL = false;
    var isIE8 = false;
    var isIE9 = false;
    var isIE10 = false;

    var sidebarWidth = 225;
    var sidebarCollapsedWidth = 35;

    var responsiveHandlers = [];

    // 换肤
    var layoutColorCodes = {
        'blue': '#4b8df8',
        'red': '#e02222',
        'green': '#35aa47',
        'purple': '#852b99',
        'grey': '#555555',
        'light-grey': '#fafafa',
        'yellow': '#ffb848'
    };

    var handleInit = function() {

        if ($('body').css('direction') == 'rtl') {
            isRTL = true;
        }

        isIE8 = !! navigator.userAgent.match(/MSIE 8.0/);
        isIE9 = !! navigator.userAgent.match(/MSIE 9.0/);
        isIE10 = !! navigator.userAgent.match(/MSIE 10/);
        
        if (isIE10) {
            jQuery('html').addClass('ie10'); // detect IE10 version
        }
    };

    /*from表单美化插件*/
    var handleUniform = function () {
        if (!jQuery().uniform) {
            return;
        }
        var test = $("input[type=checkbox]:not(.toggle), input[type=radio]:not(.toggle, .star)");
        if (test.size() > 0) {
            test.each(function () {
                    if ($(this).parents(".checker").size() == 0) {
                        $(this).show();
                        $(this).uniform();
                    }
                });
        }
    };

    
    /*读取 cookie*/
    var getCookie = function(cookie_name) {
    	var results = document.cookie.match('(^|;) ?' + cookie_name + '=([^;]*)(;|$)');
    	if (results){
    		return (unescape(results[2]));
    	}else{
    		return null;
    	}
    };
    
    var setCookie = function(key, value, exp, path, domain, secure) {
    	path = "/";
    	var cookie_string = key + "=" + escape(value);
    	if (exp) {
    		cookie_string += "; expires=" + exp.toGMTString();
    	}
    	if (path)
    		cookie_string += "; path=" + escape(path);
    	if (domain)
    		cookie_string += "; domain=" + escape(domain);
    	if (secure)
    		cookie_string += "; secure";
    	document.cookie = cookie_string;
    };
    
    //表单检验
	var handleValidForm = function (callback){
		$(".dataForm").Validform({
			tiptype:4,
			ajaxPost:true,
			callback:function(data){
				if(data.success==true){
					if(callback) {return callback(data);}
				}else{parent.App.alert(data.msg);}
			}
		});
	};
    
    var handleAlert = function(){
    	var alert = '';
    	alert+='<div id="modalAlert" class="modal hide fade" tabindex="-1" role="dialog"  aria-hidden="true" style="display: none;">';
    	alert+='<div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>';
    	alert+='<h3>系统提示</h3>';
    	alert+='</div><div class="modal-body"><p></p></div></div>';
    	jQuery('body').append(alert);
    };
    
    var handleConfirm = function(){
    	var confirm = '';
    	confirm+='<div id="modalConfirm" class="modal hide fade" tabindex="-1" role="dialog"  aria-hidden="true" style="display: none;">';
    	confirm+='<div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>';
    	confirm+='<h3>系统提示</h3>';
    	confirm+='</div><div class="modal-body"><p></p></div><div class="modal-footer"><button class="btn" data-dismiss="modal" data-value="no" aria-hidden="true">取消</button><button data-dismiss="modal" data-value="ok" class="btn blue">确定</button></div></div>';
    	jQuery('body').append(confirm);
    };
    
    var handleCheckBox = function(){
    	
    	jQuery('.group-checkable').change(function () {
            var set = jQuery(this).attr("data-set");
            var checked = jQuery(this).is(":checked");
            jQuery(set).each(function () {
                if (checked) {
                    $(this).attr("checked", true);
                } else {
                    $(this).attr("checked", false);
                }
            });
            jQuery.uniform.update(set);
        });

    };
    
    handleDadaTable = function(url){
    	if (!jQuery().dataTable) {
            return;
        }
    	$('#contentTable').dataTable( {
    		//"sAjaxSource": url
        });
    	
    };
    
    var handleniceScroll = function(){
    	jQuery('html').niceScroll({
    		styler:"fb",
    		cursorcolor:"#4A8BC2",
    		cursorwidth: '8', 
    		cursorborderradius: '0px', 
    		background: '#404040', 
    		cursorborder: '', 
    		zindex: '1000'});
    };

    //* END:CORE HANDLERS *//

    return {

        //main function to initiate template pages
        init: function () {
        	

            //IMPORTANT!!!: Do not modify the core handlers call order.
        	
        	//
        	
        	//
        	handleCheckBox();
        	//美化滚动条
        	handleniceScroll();

            //core handlers
           // handleInit();
           // handleResponsiveOnResize(); // 设置并处理web自适应   
            handleUniform();        
            //handleScrollers(); // handles slim scrolling contents 
           // handleResponsiveOnInit(); // handler responsive elements on page load

            //layout handlers
           // handleFixedSidebar(); // handles fixed sidebar menu
            //handleFixedSidebarHoverable(); // handles fixed sidebar on hover effect 
           // handleSidebarMenu(); // handles main menu
           // handleHorizontalMenu(); // handles horizontal menu
           // handleSidebarToggler(); // handles sidebar hide/show            
           //// handleFixInputPlaceholderForIE(); // fixes/enables html5 placeholder attribute for IE9, IE8
           // handleGoTop(); //handles scroll to top functionality in the footer
            //handleTheme(); // handles style customer tool

            //ui component handlers
            //handlePortletTools(); // handles portlet action bar functionality(refresh, configure, toggle, remove)
//            handleDropdowns(); // handle dropdowns
           // handleTabs(); // handle tabs
           // handleTooltips(); // handle bootstrap tooltips
           // handlePopovers(); // handles bootstrap popovers
           // handleAccordions(); //handles accordions
           // handleChoosenSelect(); // handles bootstrap chosen dropdowns     

            //App.addResponsiveHandler(handleChoosenSelect); // reinitiate chosen dropdown on main content resize. disable this line if you don't really use chosen dropdowns.
        },
        
        getCookie:function(cookie_name){
        	return getCookie(cookie_name);
        },

        fixContentHeight: function () {
            handleSidebarAndContentHeight();
        },

        addResponsiveHandler: function (func) {
            responsiveHandlers.push(func);
        },

        // useful function to make equal height for contacts stand side by side
        setEqualHeight: function (els) {
            var tallestEl = 0;
            els = jQuery(els);
            els.each(function () {
                    var currentHeight = $(this).height();
                    if (currentHeight > tallestEl) {
                        tallestColumn = currentHeight;
                    }
                });
            els.height(tallestEl);
        },

        // wrapper function to scroll to an element
        scrollTo: function (el, offeset) {
            pos = el ? el.offset().top : 0;
            jQuery('html,body').animate({
                    scrollTop: pos + (offeset ? offeset : 0)
                }, 'slow');
        },

        scrollTop: function () {
            App.scrollTo();
        },

        // wrapper function to  block element(indicate loading)
        blockUI: function (el, centerY) {
            var el = jQuery(el); 
            el.block({
                    message: '<img src="plug-in/assets/image/ajax-loading.jpg" align="">',
                    centerY: centerY != undefined ? centerY : true,
                    css: {
                        top: '10%',
                        border: 'none',
                        padding: '2px',
                        backgroundColor: 'none'
                    },
                    overlayCSS: {
                        backgroundColor: '#000',
                        opacity: 0.05,
                        cursor: 'wait'
                    }
                });
        },

        // wrapper function to  un-block element(finish loading)
        unblockUI: function (el) {
            jQuery(el).unblock({
                    onUnblock: function () {
                        jQuery(el).removeAttr("style");
                    }
                });
        },

        // initializes uniform elements
        initUniform: function (els) {

            if (els) {
                jQuery(els).each(function () {
                        if ($(this).parents(".checker").size() == 0) {
                            $(this).show();
                            $(this).uniform();
                        }
                    });
            } else {
                handleUniform();
            }

        },

        // initializes choosen dropdowns
        initChosenSelect: function (els) {
            $(els).chosen({
                    allow_single_deselect: true
                });
        },

        initFancybox: function () {
            handleFancybox();
        },

        getActualVal: function (el) {
            var el = jQuery(el);
            if (el.val() == el.attr("placeholder")) {
                return "";
            }

            return el.val();
        },

        getURLParameter: function (paramName) {
            var searchString = window.location.search.substring(1),
                i, val, params = searchString.split("&");

            for (i = 0; i < params.length; i++) {
                val = params[i].split("=");
                if (val[0] == paramName) {
                    return unescape(val[1]);
                }
            }
            return null;
        },

        // check for device touch support
        isTouchDevice: function () {
            try {
                document.createEvent("TouchEvent");
                return true;
            } catch (e) {
                return false;
            }
        },

        isIE8: function () {
            return isIE8;
        },

        isRTL: function () {
            return isRTL;
        },

        getLayoutColorCode: function (name) {
            if (layoutColorCodes[name]) {
                return layoutColorCodes[name];
            } else {
                return '';
            }
        },
        alert:function(context){
//        	if(context!=undefined && context!=''){
//        		$('.modal-body p').text(context);
//        	}
//        	$('#modalAlert').modal('show');
        	parent.$("body").openWidow({
        		text:"<div class=\"ui-widget\"><div class=\"ui-state-highlight ui-corner-all\"><p><span class=\"ui-icon ui-icon-info\" style=\"float: left; margin-right: .3em;\"></span>"+context+"</p></div></div>",
        		buttons:[{
        			text:"确定",
        			'class': 'btn blue',
    				click:function(){
    					App.alertClose();
    				}
        		}
        		]
        		
        	});
        	
        	
        },
        alertClose:function(){
//        	$('#modalAlert').modal('hide');
        	var d = parent.$("body").find("div");
			$.each(d, function(i, n){
				if($(n).hasClass("ui-dialog")==true){
					$(this).remove();
				}
				if($(n).hasClass("ui-dialog-ifram")==true){
					$(this).remove();
				}
				if($(n).hasClass("ui-widget-overlay")==true){
					$(this).remove();
				}
			});
        },
        confirmClose:function(){
        	var d = parent.$("body").find("div");
			$.each(d, function(i, n){
				if($(n).hasClass("ui-dialog")==true){
					$(this).remove();
				}
				if($(n).hasClass("ui-dialog-ifram")==true){
					$(this).remove();
				}
				if($(n).hasClass("ui-widget-overlay")==true){
					$(this).remove();
				}
			});
        },
        confirm:function(context,callback){
//        	if(context!=undefined && context!=''){
//        		$('.modal-body p').text(context);
//        	}
//        	$('#modalConfirm').modal('show');
//        	$('.modal-footer button').click(function(){
//        		if($(this).data("value")=='ok'){
//        			if(callback) {return callback(true);}//result true
//        		}
//        	});
        	parent.$("body").openWidow({
        		text:"<div class=\"ui-widget\"><div class=\"ui-state-highlight ui-corner-all\"><p><span class=\"ui-icon ui-icon-info\" style=\"float: left; margin-right: .3em;\"></span>"+context+"</p></div></div>",
        		buttons:[{
        			text:"取消",
        			'class': 'btn',
        			click:function(){
    					
    					if(callback) {
    						return callback(false);
    					}else{
    						App.confirmClose();
    					}//result true
    				}
        		},{
        			text:"确定",
        			'class': 'btn blue',
    				click:function(){
    					
    					if(callback) {
    						return callback(true);
    					}else{
    						App.confirmClose();	
    					}//result true
    				}
        		}
        		]
        		
        	});
        },
        //表单验证
        validform:function(callback){
        	handleValidForm(callback);
        },
        datatable:function(url){
        	handleDadaTable(url);
        }
        

        
    };
      
}();