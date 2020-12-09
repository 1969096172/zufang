<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/7
  Time: 9:32
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
<h3 style="text-align: center; color: #555555">发布商品</h3>
<h3 style="clear: none;">已上架</h3>
<c:forEach items="${sessionScope['goods0']}" var="goods0">
    <div style="float: left; margin: 10px">
        <img src="${goods0.goodurl}" alt="#" style="width: 50px; height: 50px;">
        <p style="font-size: 13px; text-align: center; color: #bfbfbf">${goods0.goodsname}</p>
        <a class="atcolor" href="mineServelet?method=deletegoods&deleteid=${goods0.goodsid}&userid=${sessionScope['userre']}">删除</a>
    </div>
</c:forEach>

<h3 style="clear: both">正在交易</h3>
<c:forEach items="${sessionScope['goods1']}" var="goods1">
    <div style="float: left; margin: 10px">
        <img src="${goods1.goodurl}" alt="#" style="width: 50px; height: 50px;">
        <p style="font-size: 13px; text-align: center; color: #bfbfbf">${goods1.goodsname}</p>
        <a class="atcolor" href="mineServelet?method=thisSGid&thisSGid=${goods1.goodsid}&thismoney=${goods1.newprice}&userid=${sessionScope['userre']}">确认</a>
        <a class="atcolor" href="mineServelet?method=reminegoods&thisSGid=${goods1.goodsid}&thismoney=${goods1.newprice}&userid=${sessionScope['userre']}">取消</a>
    </div>
</c:forEach>

<h3 style="clear: both">交易完成</h3>
<c:forEach items="${sessionScope['goods2']}" var="goods2">
    <div style="float: left; margin: 10px">
        <img src="${goods2.goodurl}" alt="#" style="width: 50px; height: 50px;">
        <p style="font-size: 13px; text-align: center; color: #bfbfbf">${goods2.goodsname}</p>
    </div>
</c:forEach>
</body>
</html>
