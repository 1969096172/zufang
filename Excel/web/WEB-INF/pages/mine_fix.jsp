<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/4
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    input{
        width: 100px;
        height: 15px;
        font-size: 5px;
    }
    .text{
        font-size: 5px;
    }

</style>
<body>

<form action="${pageContext.request.contextPath }/mineServelet?method=getmine_fixgo" method=post  enctype="multipart/form-data">
    <input type=hidden value="${sessionScope['usermineM'].userid}" name=userID >
    <table>
        <tbody>
        <tr>
            <td align=right class="text">头像</td>
            <td><input type="file" value="${sessionScope['usermineM'].userurl}" name=img style="height: 22px"></td>
        </tr>
        <tr>
            <td align=right class="text">用户</td>
            <td><input value="${sessionScope['usermineM'].username}" name=account></td>
        </tr>
        <tr>
            <td align=right class="text">密码</td>
            <td><input type="password" value="${sessionScope['usermineM'].userpassword}" name=password></td>
        </tr>
        <tr>
            <td align=right class="text">电话</td>
            <td><input value="${sessionScope['usermineM'].usertel}" name=tel></td>
        </tr>
        <tr>
            <td align=right class="text">地址</td>
            <td><input value="${sessionScope['usermineM'].useraddress}" name=address></td>
        </tr>
        <input type=hidden value="${sessionScope['usermineM'].adminid}" name=adminid>
        <tr>
            <td></td>
            <td><input type=submit value=确认 style="height: 20px; background-color: #ffffff; outline-color: #FAEDF9; border: none"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type=reset value=重置 style="height: 20px; background-color: #ffffff; outline-color: #FAEDF9; border: none"></td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
