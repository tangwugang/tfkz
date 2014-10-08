<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!-----------底部 s--------------------->
<div class="footer">
<c:set></c:set>
 <div class="f_time">${fns:formatDate('yyyy-MM-dd HH:ss:mm')}</div><!--f_time e-->
 <div class="welcome">
    <span>欢迎登录！</span><span>超级管理员</span>&nbsp;&nbsp;<span class="blue">张三三</span>
    <div class="list">
        <ul style="display:none;">
          <li><a href="">账户基本信息</a></li>
          <li><a href="">修改密码</a></li>
          <li><a href="">退出</a></li>
        </ul>
     </div>
 </div><!--welcome e-->
 <div class="clr"></div>
</div><!--footer e-->
<!-----------底部 e--------------------->
