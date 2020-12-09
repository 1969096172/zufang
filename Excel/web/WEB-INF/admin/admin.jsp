<%@ page import="com.li.ers.servlet.AdminServelet" %><%--
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
<div>
    <h2 style="text-align: center; margin-top: 50px;">商品管理</h2>
    <div style="width: 60%; height: 600px; margin: 20px auto; background-color: #bfbfbf">
        <c:forEach items="${sessionScope['goodsList']}" var="goods">
            <div style="float: left; margin: 10px">
                <img src="${goods.goodurl}" alt="#" style="width: 50px; height: 50px;">
                <p style="font-size: 13px; text-align: center; color: #ffffff">${goods.goodsname}</p>
                <a STYLE="color: aqua;" href="adminServelet?method=admingoodst&thisSGid=${goods.goodsid}&adminid=${sessionScope['adminid']}">同意上架</a>
                <a STYLE="color: aqua;" href="adminServelet?method=refusegoods&thisSGid=${goods.goodsid}&adminid=${sessionScope['adminid']}">拒绝上架</a>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>
