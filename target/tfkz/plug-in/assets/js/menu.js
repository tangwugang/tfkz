/**
 * $('#id').menu();
 * @param $
 */

;(function($) { 
	var menu="";
	$.fn.menu = function(options) {
		var defaults = {    
			width: 120,
	        top: 0,
	        left: 0,
	        items: null,
	        shadow: true
		};    
		
	 // Extend our default options with those provided.    
	   var opts = $.extend(defaults, options); 
	  // Our plugin implementation code goes here. 
	  //init(opts);
	   hide();
	   init(opts);
	};
	var init= function(opts){
		menu+='<div id="rMenu"><ul class="dropdown-menu" style="z-index: 1000; display: block; top: '+opts.top+'px; left: '+opts.left+'px;">';
		$.each(opts.items,function(i,n){
			   menu+='<li><a href="javascript:;"><i class="o-menu-add"></i>'+n.text+'</a></li>';
			   //alert("top "+opts.top+" left "+opts.left +" item "+n.text);
			   
		   });
		   menu+='</ul></div>';
		   $('body').append(menu);
	};
	
	var hide = function(){
			$('#rMenu ul .dropdown-menu').attr("style","display: none;");
	};
	
})(jQuery); 