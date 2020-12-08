<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/8
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .atcolor{
            color: aqua;
        }
    </style>
</head>
<body>
<h3 style="text-align: center; color: #555555">订单</h3>
<h3 style="clear: none;">未完成</h3>
<c:forEach items="${sessionScope['goodsM']}" var="goodsM">
    <div style="float: left; margin: 10px">
        <img src="${goodsM.goodurl}" alt="#" style="width: 50px; height: 50px;">
        <p style="font-size: 13px; text-align: center; color: #bfbfbf">${goodsM.goodsname}</p>
    </div>
</c:forEach>
<h3  style="clear: both">已完成</h3>
<c:forEach items="${sessionScope['goodsM2']}" var="goodsM2">
    <div style="float: left; margin: 10px">
        <img src="${goodsM2.goodurl}" alt="#" style="width: 50px; height: 50px;">
        <p style="font-size: 13px; text-align: center; color: #bfbfbf">${goodsM2.goodsname}</p>
    </div>
</c:forEach>
</body>
</html>
