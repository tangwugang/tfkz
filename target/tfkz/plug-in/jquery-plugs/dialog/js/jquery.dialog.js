(function($) {
	var dialogId;
	$.fn.openWidow = function(options) {
		var divId = "dialog" + Math.round(Math.random() * 100);
		var settings = {
			id : divId,
			width : 300,
			height : 200,
			modal : true,
			iframe :false,
			buttons : {},
			show : "explode",
			hide : "highlight",
			title : "提示",
			text:"",
			url : "",
			close : function() {
				$("#" + this.id).remove();
				// debugger
				if (document.getElementById(this.id))
					document.body.removeChild(document.getElementById(this.id));
			}
		};
		if (options) {
			$.extend(settings, options);
		}
		dialogId = settings.id;
		$("body").append('<div id="'+ settings.id + '" title="Dialog Title" class="ui-dialog-ifram"><p class="loading"></p></div>');
		// Dialog
		$('#' + settings.id)
				.dialog(
						{
							autoOpen : false,
							title : settings.title,
							width : settings.width,
							height : settings.height,
							modal : true,
							bgiframe : true,
							show : settings.show,
							hide : settings.hide,
							buttons : settings.buttons,
							close : settings.close,
							open : function() {
								if(settings.iframe){
									$("#" + settings.id)
									.html(
											'<iframe src="'
													+ settings.url
													+ '" frameborder="0" height="100%" width="100%" id="dialogFrame" scrolling="no"></iframe>');
								}else{
									$("#" + settings.id)
									.html(settings.text);
								}
								
							},
							resizeStop : function() {
								$("#dialogFrame").css("width",
										parseInt($(this).css("width")) - 5);
								$("#dialogFrame").css("height",
										parseInt($(this).css("height")) - 5);
							}
						});

		$('#' + settings.id).dialog("open");
		return this;
	};
	return {
		$.openWidow.close = function(){
		    $('#'+dialogId).remove();
		};
	}
	
})(jQuery);