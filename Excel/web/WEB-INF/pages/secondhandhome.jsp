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
    <link href="<%=cssUrl%>search.css" rel="stylesheet">

</head>
<body>
<c:if test="${sessionScope['userid'] ne null}">
    <%
        int userid = (int) session.getAttribute("userid");
        System.out.println(userid);
    %>

</c:if>
<%--获取头--%>
<%@ include file="/commons/header.jsp" %>
<div id="container">
    <form action="${pageContext.request.contextPath }/homeServlet?method=getgoods" method="post">
        <div class="search">
            <div class="btn">从</div>
            <input type="text" class="color" name="minPrice" placeholder="最低价格"/>
            <div class="btn">到</div>
            <input type="text" class="color" name="maxPrice" placeholder="最高价格"/>
            <button type="submit" class="searchBtn"> 查询</button>
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
        <div class="select" style="display: block;" >
            <c:forEach items="${goodslist.list}" var="goods">
                <c:if test="${goods.adminid != 1 && goods.status == 0}">
                    <div class="select_content" onclick="window.location.href='${pageContext.request.contextPath}/homeServlet?method=getdetails&goodsdetid=${goods.goodsid}&userdetid=${userid}';return false">
                        <img src="${goods.goodurl}" alt="#" class="con_photo">
                        <div class="se_con_text">
                            <p>${goods.goodsname }</p>
                            <p>${goods.remark}</p>
                            <p>${goods.newprice}元</p>
                            <p>${goods.oldprice}元</p>
                            <p><a>${goods.newkind}成新</a></p>
                            <p>正在出售</p>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
        <div class="select" style="display: block;">
            <c:forEach items="${goodslist.list}" var="goods">

                <c:if test="${goods.adminid != 1}">
                    <c:if test="${goods.kindid==1}">
                        <div class="select_content" onclick="window.location.href='${pageContext.request.contextPath}/homeServlet?method=getdetails&goodsdetid=${goods.goodsid}&userdetid=${userid}';return false">
                            <img src="${goods.goodurl}" alt="#" class="con_photo">
                            <div class="se_con_text">
                                <p>${goods.goodsname }</p>
                                <p>${goods.remark}</p>
                                <p>${goods.newprice}元</p>
                                <p>${goods.oldprice}元</p>
                                <p class="new-status">${goods.newkind}成新</p>
                                <p>正在出售</p>
                            </div>
                        </div>
                    </c:if>
                </c:if>
            </c:forEach>

        </div>
        <div class="select">
            <c:forEach items="${goodslist.list}" var="goods">
                <c:if test="${goods.adminid != 1}">
                    <c:if test="${goods.kindid==2}">
                        <div class="select_content" onclick="window.location.href='${pageContext.request.contextPath}/homeServlet?method=getdetails&goodsdetid=${goods.goodsid}&userdetid=${userid}';return false">
                            <img src="${goods.goodurl}" alt="#" class="con_photo">
                            <div class="se_con_text">
                                <p>${goods.goodsname }</p>
                                <p>${goods.remark}</p>
                                <p>${goods.newprice}元</p>
                                <p>${goods.oldprice}元</p>
                                <p><a>${goods.newkind}成新</a></p>
                                <p>正在出售</p>
                            </div>
                        </div>
                    </c:if>
                </c:if>
            </c:forEach>
        </div>
        <div class="select">
            <c:forEach items="${goodslist.list}" var="goods">
                <c:if test="${goods.adminid != 1}">
                    <c:if test="${goods.kindid==3}">
                        <div class="select_content" onclick="window.location.href='${pageContext.request.contextPath}/homeServlet?method=getdetails&goodsdetid=${goods.goodsid}&userdetid=${userid}';return false">
                            <img src="${goods.goodurl}" alt="#" class="con_photo">
                            <div class="se_con_text">
                                <p>${goods.goodsname }</p>
                                <p>${goods.remark}</p>
                                <p>${goods.newprice}元</p>
                                <p>${goods.oldprice}元</p>
                                <p><a>${goods.newkind}成新</a></p>
                                <p>正在出售</p>
                            </div>
                        </div>
                    </c:if>
                </c:if>
            </c:forEach>
        </div>
        <div class="select">
            <c:forEach items="${goodslist.list}" var="goods">
                <c:if test="${goods.adminid != 1}">
                    <c:if test="${goods.kindid==4}">
                        <div class="select_content" onclick="window.location.href='${pageContext.request.contextPath}/homeServlet?method=getdetails&goodsdetid=${goods.goodsid}&userdetid=${userid}';return false">
                            <img src="${goods.goodurl}" alt="#" class="con_photo">
                            <div class="se_con_text">
                                <p>${goods.goodsname }</p>
                                <p>${goods.remark}</p>
                                <p>${goods.newprice}元</p>
                                <p>${goods.oldprice}元</p>
                                <p><a>${goods.newkind}成新</a></p>
                                <p>正在出售</p>
                            </div>
                        </div>
                    </c:if>
                </c:if>
            </c:forEach>
        </div>
        <div class="container">
            共 <span class="badge">${goodslist.totalPageNumber }</span> 页
            &nbsp;&nbsp;
            当前第 <span class="badge">${goodslist.pageNo } </span> 页
            &nbsp;&nbsp;

            <c:if test="${goodslist.hasPrev }">
                <a class="btn btn-default" role = "button" href="homeServlet?method=getgoods&pageNo=1">首页</a>
                &nbsp;&nbsp;
                <a class="btn btn-default" role = "button" href="homeServlet?method=getgoods&pageNo=${goodslist.prevPage }">上一页</a>
            </c:if>

            &nbsp;&nbsp;

            <c:if test="${goodslist.hasNext }">
                <a class="btn btn-default" role = "button" href="homeServlet?method=getgoods&pageNo=${goodslist.nextPage }">下一页</a>
                &nbsp;&nbsp;
                <a class="btn btn-default" role = "button" href="homeServlet?method=getgoods&pageNo=${goodslist.totalPageNumber }">末页</a>
            </c:if>

            &nbsp;&nbsp;

            转到 <input  type="text" size="1" id="pageNo"  data-dismiss="alert" aria-label="Close"/> 页
        </div>
    </div>
</div>
<%@ include file="/commons/footer.jsp" %>
<script type="text/javascript" src="<%=jsUrl%>secondhandhome.js"></script>
<!-- vue开发环境版本，包含了有帮助的命令警告 -->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</body>
</html>
