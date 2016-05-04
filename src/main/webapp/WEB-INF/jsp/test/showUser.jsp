<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>测试</title>
  </head>
  
  <body>
  	${name}tt
    ${user.userName}
    <c:out value="${user.userName}"></c:out>
  </body>
</html>

<script type="text/javascript">
//判断当前浏览器是否支持WebSocket  
if('WebSocket' in window){
	alert("000");
    websocket = new WebSocket("ws://localhost:8080/mspj/websocket");
}  
else{  
    alert('Not support websocket')  
}  

</script>