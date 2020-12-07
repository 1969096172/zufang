<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/3
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String jsUrl=request.getContextPath()+"/public/js/";
    String cssUrl=request.getContextPath()+"/public/css/";
%>
<html>
<head>
    <title>个人中心</title>
    <link href="<%=cssUrl%>mine.css" rel="stylesheet">
    <link href="<%=cssUrl%>header.css" rel="stylesheet">
    <link href="<%=cssUrl%>footer.css" rel="stylesheet">
</head>
<body>
<%--<c:if test="${sessionScope['userS'] ne null}">--%>
<%--    ${sessionScope['userS']}--%>
<%--</c:if>--%>
<%@ include file="/commons/header_mine.jsp" %>
<div id="contenter">
    <div id="photo">


        <img src="<c:if test="${sessionScope['userS'] ne null}">
                    ${sessionScope['userS'].userurl}
                </c:if>
                <c:if test="${sessionScope['userS'] eq null}">
                    ${pageContext.request.contextPath}/public/img/cup.jpg
                </c:if>" alt="#"
             STYLE="width: 90%; height: 70%; margin: auto; padding-top: 10px; border-radius: 50%; display: block"></div>
    <div class="lianjie11"></div>
    <div class="lianjie1"></div>
    <div class="lianjie0"></div>
    <div class="lianjie2"></div>
    <div class="lianjie3"></div>
    <div class="lianjie4"></div>
    <div class="lianjie5"></div>
    <div class="lianjie6"></div>
    <div class="lianjie7"></div>
    <div class="lianjie8"></div>
    <div class="lianjie9"></div>
    <div class="lianjie10"></div>

    <div id="menu">
        <div id="menu_choic">
            <div class="menu_choic_money">
                <h3>绑卡</h3>
                <p><a href="${pageContext.request.contextPath}/mineServelet?method=getminemoney&userid=${sessionScope['userS'].userid}" target="minenav">点击绑卡</a></p>
            </div>
            <div class="menu_choic_money">
                <h3>购物车</h3>
                <p><a href="" target="minenav">点击查看</a></p>
            </div>
            <div class="menu_choic_money">
                <h3>商品管理</h3>
                <p><a style="color: rgb(0, 233, 233);" href="${pageContext.request.contextPath}/mineServelet?method=setminerelgoods&userid=${sessionScope['userS'].userid}" target="minenav">点击管理</a> </p>
            </div>
            <div class="menu_choic_money">
                <h3>发布商品</h3>
                <p><a href="${pageContext.request.contextPath}/mineServelet?method=getminerelgoods&userid=${sessionScope['userS'].userid}" target="minenav">点击发布</a></p>
            </div>
        </div>
    </div>
    <div id="choic">
        <div><a href="homeServlet?method=getgoods">返回首页</a></div>
        <p style="text-align: center">个人信息管理</p>
        <iframe src="${pageContext.request.contextPath}/mineServelet?method=getminefix&userid=${sessionScope['userS'].userid}" frameborder="0" width="100%" height="70%" scrolling="no"></iframe>
    </div>
</div>
<div id="content">
    <div id="order">
        <div id="order_content_img">
            <iframe src="${pageContext.request.contextPath}/mineServelet?method=setminerelgoods&userid=${sessionScope['userS'].userid}" name="minenav" frameborder="0"width="100%" height="70%" scrolling="yes"></iframe>
        </div>
    </div>
    <div id="care">
        <div id="care_pro">
            <h3>我的关注</h3>
            <div class="care_text" style="background: linear-gradient(rgb(253, 199, 82),rgb(130, 253, 82));">
                <h4>关注商品</h4>
                <p>0</p>
            </div>
            <div class="care_text" style="background: linear-gradient(rgb(130, 253, 82),rgb(233, 193, 107));">
                <h4>关注店铺</h4>
                <p>0</p>
            </div>
            <div class="care_text" style="background: linear-gradient(rgb(209, 211, 114),rgb(229, 107, 233));">
                <h4>特别关心购乐客</h4>
                <p>0</p>
            </div>
        </div>
        <div id="care_banner">
            <div class="banner_box">
                <ul class="box_poto">
                    <li><img src="${pageContext.request.contextPath}/public/img/banner1.jpg" alt="" style="width: 144px; height: 144px;"></li>
                    <li><img src="${pageContext.request.contextPath}/public/img/banner2.jpg" alt=""></li>
                    <li><img src="${pageContext.request.contextPath}/public/img/banner3.jpg" alt=""></li>
                    <li><img src="${pageContext.request.contextPath}/public/img/banner1.jpg" alt=""></li>
                </ul>
                <ul class="num">
                    <li class="on"></li>
                    <li class="on"></li>
                    <li class="on"></li>
                </ul>
            </div>
            <ul class="num">
                <li class="on"></li>
                <li class="on"></li>
                <li class="on"></li>
            </ul>
            <div class="btn btn_1"><</div>
            <div class="btn btn_r">></div>
        </div>
    </div>
</div>
<%@ include file="/commons/footer.jsp" %>
<script type="text/javascript" src="<%=jsUrl%>mine.js"></script>
<script type="text/javascript">
    $("header .nav .nav_u li:nth-child(2)").mouseenter(function(){//鼠标移动到
        $("header .nav .nav_u .nav_u_u").css("display","block");//ul显示
        $("header .nav .nav_u li:nth-child(2)").css("background-color","#fff")//相应li标签背景变化
        $("header .nav .nav_u li:nth-child(2) a").css("color","rgb(245, 10, 10)")//相应a标签字体颜色变化

    });
    $("header .nav .nav_u .nav_u_u").mouseleave(function(){//鼠标离开
        $("header .nav .nav_u .nav_u_u").css("display","none");//ul隐藏
        $("header .nav .nav_u li:nth-child(2)").css("background-color","#F0A7A7")//相应li标签背景变化
        $("header .nav .nav_u li:nth-child(2) a").css("color","#fff")//相应a标签字体颜色变化
    });

    var buttonDelete = document.getElementsByClassName("button-delete")[0],
        show = document.getElementsByClassName("show")[0],
        selectBox = document.getElementsByClassName("selectBox")[0],
        p = document.getElementsByTagName("p")[0];
    buttonDelete.onclick = function () {
        //保存this指向，这里的this就是button-delete按钮
        var self = this;
        // 给show添加class样式
        show.classList.add("showStyle");
        // self.style.opacity=0;
        setTimeout(function(){
            // 延迟300毫秒将selectBox显示出来如果没有延迟会有一些难看的动画
            selectBox.style.visibility = "visible";
        },300)
        //延迟500毫秒将所有元素还原
        setTimeout(function(){
            // self.style.display = "none";
            selectBox.style.transform = "translateX(0)";
            p.style.marginTop = "15px";
        },500)
    }
    selectBox.onclick = function(){
        show.classList.remove("showStyle");
    }
</script>
</body>
</html>
