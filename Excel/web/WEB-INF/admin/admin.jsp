<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/9
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理</title>
    <%
        String jsUrl=request.getContextPath()+"/public/js/";
        String cssUrl=request.getContextPath()+"/public/css/";
    %>
    <link href="<%=cssUrl%>secondhandhome.css" rel="stylesheet">

</head>
<body>

<%@ include file="/commons/header_admin.jsp" %>

</body>
</html>
