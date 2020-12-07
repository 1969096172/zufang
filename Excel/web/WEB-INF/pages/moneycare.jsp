<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/5
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 style="text-align: center; color: #555555">绑定银行卡</h3>
<c:if test="${sessionScope['user_re'] ne null}">
    <h6 style="color: red">${sessionScope['user_re']}</h6>
</c:if>
<form action="${pageContext.request.contextPath }/mineServelet?method=addmoney" method=post >
    <table>
        <tbody>
        <tr>
            <td><input placeholder="请输入卡号" name=accountcare style="background-color: #E0E0E0; border: none; outline-color: #ffffff;"></td>
            <td><input type=hidden value="500.0" name=accountmoney></td>
            <td><input type=hidden value="${sessionScope['userre']}" name=accountuserid></td>
            <td><input type=submit value=确认 style="height: 20px; background-color: #ffffff; outline-color: #E0E0E0; border: none"></td>
            <td><input type=reset value=重置 style="height: 20px; background-color: #ffffff; outline-color: #E0E0E0; border: none"></td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
