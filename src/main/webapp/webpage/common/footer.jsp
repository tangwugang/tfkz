<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<!-- BEGIN FOOTER -->
	<div class="footer">
		<div class="footer-inner">
			2013 &copy; Metronic by keenthemes.
		</div>
		<div class="footer-tools">
			<span class="go-top">
			<i class="icon-angle-up"></i>
			</span>
		</div>
	</div>
	<!-- END FOOTER -->
	<!-- BEGIN JAVASCRIPTS -->
   <script type="text/javascript">
   $(function(){
	   App.init();
	   //检测浏览器是否活跃
	   setInterval(function(){
		   $.post('systemController.do?isActiveOfBrowser',function(){});
	   }, 1000*60);
   });
   </script>  
   <!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>