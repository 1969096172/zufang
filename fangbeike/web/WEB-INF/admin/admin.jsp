<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/18
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta http-equiv="Cache-Control" content="no-transform" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <meta http-equiv="Content-language" content="zh-CN" />
    <meta name="format-detection" content="telephone=no" />
    <meta name="applicable-device" content="pc">
    <meta http-equiv="Cache-Control" content="no-transform " />

    <title>贝壳-F</title>
    <!--地址信息-->
    <meta name="location" content="province=四川;city=成都">

    <!-- 网站ico图标 -->
    <link href="https://s1.ljcdn.com/matrix_pc/dist/pc/src/resource/img/favicon.ico?_v=20201214143047025" type="image/x-icon" rel="icon">

    <meta name="" mobile-agent content="format=[wml|xhtml|html5];url=https://m.ke.com/chuzu/cd/zufang/" />
    <link rel="alternate" media="only screen and (max-width:640px)" href="https://m.ke.com/chuzu/cd/zufang/">

    <!-- 是否需要加载common.css -->
    <link rel="stylesheet" href="https://s1.ljcdn.com/matrix_pc/dist/pc/src/common/css/common.css?_v=20201214143047025">

    <!-- 载入灯塔 -->
    <!-- 接入灯塔 -->
    <script src='//s1.ljcdn.com/link-static/resource/plat_framework/fee/js/1.4.0/index.js' crossorigin="anonymous"></script>
    <!-- 载入后台返回的css文件 -->
    <link rel="stylesheet" href="https://s1.ljcdn.com/matrix_pc/dist/pc/src/page/list/index.css?_v=20201214143047025">

    <!-- 预置全局变量 -->
    <script>
        var g_conf = {}
    </script>
</head>
<body>
<!-- 载入低版本浏览器样式 -->
<style>
    .browser__low {
        height: 100%;
        overflow: hidden
    }

    .browser__low--wrapper,
    .browser__low--inner {
        display: none
    }

    .browser__low .browser__low--wrapper {
        position: absolute;
        left: 0;
        right: 0;
        top: 0;
        bottom: 0;
        z-index: 199999;
        background: #000;
        opacity: .5;
        filter: alpha(opacity=50);
        display: block
    }

    .browser__low .browser__low--inner {
        background: #fff;
        position: absolute;
        left: 50%;
        top: 50%;
        z-index: 19999999;
        width: 360px;
        height: 100px;
        margin-top: -90px;
        margin-left: -200px;
        padding: 40px 20px;
        display: block
    }

    .browser__low .browser__low--inner p {
        font-size: 20px;
        padding-bottom: 40px
    }

    .browser__low .browser__low--inner a {
        display: inline-block;
        color: #fff;
        background: #2ab78e;
        padding: 10px 6px
    }
</style>
<div class="browser__low--wrapper"></div>
<div class="browser__low--inner">
    <p>您的浏览器版本过低，请升级：</p>
    <a href="https://www.baidu.com/s?wd=chrome" target="_blank">谷歌 Chrome浏览器</a>
</div>
<script>
    ;;
    (function() {
        if (!([].forEach)) {
            document.body.className += ' browser__low'
        }
    })()
</script>

<div class="wrapper">
    <link href='//s1.ljcdn.com/feroot/pc/asset/lianjiaIM/css/lianjiaim.css?v=15212312340214' property='stylesheet' rel="stylesheet">

    <div>
        <!-- 顶部总站导航 -->
        <div class="search__area">
            <!-- 租房导航 -->
            <div class="beike__nav">
                <a class="home_text"><img class="home_img" src="${pageContext.request.contextPath}/public/img/home.png"></a>
                <ul class="beike__nav--tab">
                    <li>
                        <a class="cur" href="/zufang/">贝壳-F</a>
                    </li>
                    <li>
                        <a class="cur" href="">预约看房处理</a>
                    </li>
                    <li>
                        <a class="cur" href="">发布房源</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>


</html>
