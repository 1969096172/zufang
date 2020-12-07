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
</head>
<body>
<h3 style="text-align: center; color: #555555">发布商品</h3>
<h3>已上架</h3>
<c:forEach items="${sessionScope['goods0']}" var="goods0">
    ${goods0.goodsname}

</c:forEach>
<h3>正在交易</h3>

<h3>交易完成</h3>
</body>
</html>
