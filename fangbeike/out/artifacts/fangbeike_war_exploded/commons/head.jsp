<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/19
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header ">
    <ul class="header__wrapper w1150 clear typeUserInfo" id="top">
        <li class="header__item fl">
            <label id="nnowdate">2020/6/29 下午2:48:53 星期一</label>
            <script>
                setInterval("nnowdate.innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
            </script>
        </li>

        <li class="header__item fl">
            <a href="${pageContext.request.contextPath}/homeServlet?method=gatfang" target="_blank">首页</a>
        </li>
        <li class="header__item fl">贝壳-F</li>

        <c:if test="${sessionScope['userid'] eq null}">
            <li class="header__aside fr pointer typeShowUser" data-el="login" data-event_id="10794" data-event_action="target=login">
                        <span data-el="login_box">
                        <a href="loginServlet?method=getlogin" data-el="btn_login" data-id="dialog_tel" class="btn-login">登录/注册</a>
                        </span>
            </li>
        </c:if>
        <c:if test="${sessionScope['userid'] ne null}">
            <%
                int userid = (int) session.getAttribute("userid");

            %>
            <li class="header__aside fr pointer typeShowUser" data-el="login" data-event_id="10794" data-event_action="target=login">
                        <span data-el="login_box">
                        <a href="loginServlet?method=getlogin" data-el="btn_login" data-id="dialog_tel" class="btn-login">个人中心</a>
                        </span>
            </li>
        </c:if>
    </ul>
</div>
