<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/25
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%
    String jsUrl=request.getContextPath()+"/public/js/";
    String cssUrl=request.getContextPath()+"/public/css/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link href="<%=cssUrl%>login.css" rel="stylesheet">
</head>
<body>
<div class="container" id="container">
    <div class="form-container sign-up-container">
        <form action="servlet/loginServlet?method=adduser" method="post">
            <h1>注 册</h1>
            <span>选择以上方式登录或者使用您的账号</span>

            <input type="text" name="username" placeholder="账户"  />
            <input type="password" name="userpassword" placeholder="密码"  />
            <input type="text" name="usertel" placeholder="电话"  />
            <input type="text" name="useraddress" placeholder="地址"  />
            <button name="submit" value="submit">注 册</button>
        </form>
    </div>
    <div class="form-container sign-in-container">
        <form id="login" name="login" method="post" action="">
            <h1>登 录</h1>

            <span>选择以上方式登录或者使用您的账号</span>
            <input type="text" name="user" placeholder="账户"  />
            <input type="password" name="pass" placeholder="密码"  />
            <a href="#">忘记密码？</a>
            <!-- 使用js获取表单数据 -->
            <button  name="submit" value="submit" onclick="getFormInfo();">登 录</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>已有账号？</h1>
                <p>请使用您的账号进行登录</p>
                <button class="ghost" id="signIn">登录</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>没有账号？</h1>
                <p>立即注册加入我们，和我们一起开始旅程吧。</p>
                <button class="ghost" id="signUp">注册</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="<%=jsUrl%>login.js"></script>
</body>
</html>
