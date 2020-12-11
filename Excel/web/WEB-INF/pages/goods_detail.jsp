<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 安生
  Date: 2020/12/10
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%
    String jsUrl=request.getContextPath()+"/public/js/";
    String cssUrl=request.getContextPath()+"/public/css/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>详情</title>
    <link href="<%=cssUrl%>detail.css" rel="stylesheet">
    <link href="<%=cssUrl%>secondhandhome.css" rel="stylesheet">
</head>
<body>
<%@ include file="/commons/header.jsp" %>
<center>
    <div class="image">
        <img src="${goodsdt.goodurl }" style="width:200px;height:200px;"/>
    </div>
    <div class="caption" id="buy">
        <br><br>
        品牌：${goodsdt.brand }${userdtid}
        <br><br>
        原价: ￥${goodsdt.oldprice }
        <br><br>
        现价: ￥${goodsdt.newprice }
        <br><br>
        几成新: ${goodsdt.newkind }
        <br><br>
        商品备注：${goodsdt.remark }
        <br><br>
        <a href="index.jsp?userid=${userdtid}" class="btn-default"><button class="btn1">继续购物</button></a>
        <a @click="onc" class="btn-continue"><button class="btn2">{{one}}</button></a>
        <form action="${pageContext.request.contextPath }/homeServlet?method=dtchmoy" v-if="shif" method="post">
            <input type="hidden" value="${goodsdt.goodsid }" name="dtgoodsid">
            <input type="hidden" value="${goodsdt.newprice }" name="dtnewprice">
            <input type="hidden" value="${userdtid}" name="dtuserid">
            <table>
                <tr>
                    <td>请输入卡号：</td>
                    <td><input type="text" value="" name="dtcardid"></td>
                    <button  name="submit" value="submit">购买</button>
                </tr>
            </table>
        </form>
    </div>
</center>
<%@ include file="/commons/footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script>
    var buy = new Vue({
        el:"#buy",
        data:{
            one:"点击购买",
            shif:false
        },
        methods:{
            onc:function () {
                this.shif = !this.shif;
            }
        }
    })
</script>
</body>
</html>


