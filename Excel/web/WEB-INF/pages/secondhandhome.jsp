<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/24
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%
    String jsUrl=request.getContextPath()+"/public/js/";
    String cssUrl=request.getContextPath()+"/public/css/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>二手交易平台</title>
    <link href="<%=cssUrl%>secondhandhome.css" rel="stylesheet">

</head>
<body>
<c:if test="${sessionScope['userid'] ne null}">
    <%
        int userid = (int) session.getAttribute("userid");
        System.out.println(userid);
    %>

</c:if>
<%@ include file="/commons/header.jsp" %>
<div id="container">
    <a href="#"><div class="logo"></div></a>
    <form>
        <div  class="search">
            <input type="text" size="40" name="search" class="search1" placeholder="电视">
            <input type="submit" name="submit" class="submit" value="搜索">
        </div>
    </form>
</div>
<div id="content">
    <ul id="content_ul">
        <li class="action act"> 全部商品</li>
        <li class="act">日常用品</li>
        <li class="act">书籍</li>
        <li class="act">服装</li>
        <li class="act">电子用品</li>
    </ul>
    <div id="content_main">
        <div class="select" style="display: block;">
            <c:forEach items="${goodslist.list}" var="goods">
                <div class="select_content">
                    <img src="${pageContext.request.contextPath}/public/img/cup.jpg" alt="#" class="con_photo">
                    <div class="se_con_text">
                        <p>${goods.goodsname }</p>
                        <p>${goods.goodsname }</p>
                        <p>12.0元</p>
                        <p>20.0元</p>
                        <p><a>九成新</a></p>
                        <p>正在出售</p>
                    </div>
                </div>
            </c:forEach>

        </div>
        <div class="select">3</div>
        <div class="select">4</div>
        <div class="select">5</div>
    </div>
</div>
<%@ include file="/commons/footer.jsp" %>
<script type="text/javascript" src="<%=jsUrl%>secondhandhome.js"></script>
<!-- vue开发环境版本，包含了有帮助的命令警告 -->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</body>
</html>
