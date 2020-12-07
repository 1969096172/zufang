<%@ page import="com.li.ers.service.MineService" %>
<%@ page import="com.li.ers.servlet.MineServelet" %>
<%@ page import="java.util.List" %>
<%@ page import="com.li.ers.model.Kind" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/5
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .iput{
            outline-color: #FAEDF9;
            border-radius: 10px;
        }
    </style>
</head>
<body>
<h3 style="text-align: center; color: #555555">发布商品</h3>
<c:if test="${sessionScope['goods_re'] ne null}">
    <h6 style="color: red">${sessionScope['goods_re']}</h6>
</c:if>
<form action="${pageContext.request.contextPath}/mineServelet?method=addgoods" method="post" enctype="multipart/form-data">
    <table>
        <tbody>
        <tr>
            <td>
                <span>商品图片</span>
                <input type="file" name="goodurl">
            </td>
        </tr>
        <tr>
            <td>
                <select>
                    <%
                        MineService mineService = new MineService();
                        List<Kind> kindlist = mineService.getkind();
                        for (Kind kind: kindlist){
                    %>
                    <option name="kindid" value="<%=kind.getKindid()%>"><%=kind.getKindname()%></option>
                    <%}%>
                </select>
<%--                <input type="text" name="kindid" placeholder="商品名称" value="1" class="iput" />--%>

            </td>
            <td>
                <input type="text" name="goodsname" placeholder="商品名称" class="iput" />
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" name="newprice" placeholder="商品现价"  class="iput"/>
            </td>
            <td>
                <input type="text" name="oldprice" placeholder="商品原价"  class="iput"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" name="brand" placeholder="品牌"  class="iput"/>
            </td>
            <td>
                <input type="text" name="newkind" placeholder="几成新"  class="iput"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" name="remark" placeholder="备注" class="iput" style="height: 100px; width: 150px;"/>
            </td>
        </tr>
        <input type="hidden" name="userid" value="${sessionScope['userre']}"  class="iput"/>
        <tr>
            <td>
                <button name="submit" value="submit" style="outline-color: #ffffff; border-radius: 10px; background-color: #ffffff; ">发布</button>
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
