<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/common.jsp" %>
<%
	String contextPath = request.getContextPath();
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户信息</title>
</head>
<body>
	<table id="mydatagrid" class="easyui-datagrid" style="width:700px;height:250px"
			url="<%=contextPath %>/test/getUser.do?id=1"
			toolbar="#tb" pagination="true"
			rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
        <tr>
            <th field="id" width="50">编号</th>
            <th field="userName" width="50">名字</th>
            <th field="password" width="50">密码</th>
            <th field="age" width="50">年龄</th>
        </tr>
    </thead>
	</table>
	<div id="tb">
	    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">New User</a>
	    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Edit User</a>
	    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remove User</a>
	</div>
</body>
</html>

<script type="text/javascript">  
    var request = false;
    
    try {
     request = new XMLHttpRequest();
   } catch (trymicrosoft) {
     try {
       request = new ActiveXObject("Msxml2.XMLHTTP");
     } catch (othermicrosoft) {
       try {
         request = new ActiveXObject("Microsoft.XMLHTTP");
       } catch (failed) {
         request = false;
       }  
     }
   }
    //alert(request);
    var url = "<%=contextPath %>/test/getUser.do?id=1";
    alert(url);
    request.open("GET", url, true);
    request.onreadystatechange = updatePage;
    request.send(null);
    
    function updatePage(){
    	if (request.readyState == 4) {
	       if (request.status == 200) {
	         var result = request.responseText;
	         alert(result);
	       } else
	         alert("status is " + request.status);
	         
	     }
    }
</script>