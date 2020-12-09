<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/25
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div id="main">
    <div id="main-content">
        <div class="nav-head">
            <ul>
                <div id="nowdate">
                    <label id="nnowdate">2020/6/29 下午2:48:53 星期一</label>
                    <script>
                        setInterval("nnowdate.innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
                    </script>
                </div>
                <li class="second-trading">二手交易平台后台管理</li>
            </ul>
        </div>


        <div class="nav-end">
            <ul>
                <c:if test="${sessionScope['adminid'] ne null}">
                    <li>当前用户:admin</li>
                    <li><a href="loginServlet?method=logout" style="color: #B0B0B0">退出</a></li>
                </c:if>
                <c:if test="${sessionScope['adminid'] eq null}">
                    <li><a href="loginServlet?method=getlogin" style="color: #B0B0B0">登录/注册</a></li>
                </c:if>
                <li>帮助</li>
                <li>关于</li>
            </ul>
        </div>
    </div>
</div>
