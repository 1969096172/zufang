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
    <script>
        // 获取cookie信息
        function getCookie(name) {
            var cookies = document.cookie.split('; ');
            for (var i = 0; i < cookies.length; i++) {
                var crumb = cookies[i].split('=');
                if (name === crumb[0]) {
                    return crumb[1]
                }
            }
            return ''
        }
        // 灯塔加载完成后的回调函数
        ;;
        (function DT() {
            var uuid = getCookie('lianjia_uuid')
            window.dt && dt.set({
                pid: 'rent_fe_pc', // [必填]项目id, 由灯塔项目组统一分配
                uuid: uuid,
                ucid: uuid, // [可选]用户ucid, 用于发生异常时追踪用户信息, 一般在cookie中可以取到, 没有可传空字符串
                is_test: Boolean(''), // 是否为测试数据, 默认为false(测试模式下打点数据仅供浏览, 不会展示在系统中)
                record: {
                    time_on_page: true, // 是否监控用户在线时长数据, 默认为true
                    performance: true, // 是否监控页面载入性能, 默认为true
                    js_error: true, //  是否监控页面报错信息, 默认为true
                    // 配置需要监控的页面报错类别, 仅在js_error为true时生效, 默认均为true(可以将配置改为false, 以屏蔽不需要上报的错误类别)
                    js_error_report_config: {
                        ERROR_RUNTIME: true, // js运行时报错
                        ERROR_SCRIPT: true, // js资源加载失败
                        ERROR_STYLE: true, // css资源加载失败
                        ERROR_IMAGE: false, // 图片资源加载失败
                        ERROR_AUDIO: true, // 音频资源加载失败
                        ERROR_VIDEO: true, // 视频资源加载失败
                        ERROR_CONSOLE: false, // vue运行时报错
                        ERROR_TRY_CATCH: true,
                        checkErrorNeedReport: function(desc, stack) {
                            // 外网内容不上报
                            if (!/\/\/(s1\.ljcdn\.com\/)/.test(desc) && !/\/\/(s1\.ljcdn\.com\/)/.test(stack)) {
                                return false;
                            }

                            // 是否上报错误，默认为上报
                            var needReport = true

                            // 报错是否是从IMSDK中报出的
                            var isThrowFromIM = (desc.indexOf('web-im-sdk') > -1)

                            // desc 命中以下关键字的其中一个，即过滤掉，不上报错误，注： 从从IMSDK中报出的（第一类）
                            var filterStr = ['未登录', '/msg/sync ajax fail', '登录令牌缺失', 'Session服务出错']

                            // desc 命中以下关键字的其中一个，即可过滤掉，不上报信息，注： 并不是从从IMSDK中报出的（第二类）
                            var filterStr2 = ['MyAppGetHTMLElementsAtPoint', 'vivoNewsDetailPage', 'Script error']

                            //是否在desc中命中了关键字符串
                            var hitKeyStr = false // 第一类
                            var hitKeyStr2 = false // 第二类

                            var i = 0,
                                len = filterStr.length;
                            for (; i < len; i++) {
                                if (desc.indexOf(filterStr[i]) > -1) {
                                    hitKeyStr = true
                                    break
                                }
                            }

                            var j = 0,
                                len2 = filterStr2.length;
                            for (; j < len2; j++) {
                                if (desc.indexOf(filterStr2[j]) > -1) {
                                    hitKeyStr2 = true
                                    break
                                }
                            }

                            // 错误是从IM中抛出，并且错误信息包含登录等内容时,或者命中第二类关键词，过滤掉，不上报
                            if ((isThrowFromIM && hitKeyStr) || hitKeyStr2) {
                                needReport = false
                            }

                            return needReport
                        }
                    }
                },
                version: '1.0.0',
                getPageType: function(location) {
                    return location.host + location.pathname
                }
            })
        })()
    </script>

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
    .cor{
        color: #0075FF;
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
        <%@ include file="/commons/head.jsp"%>
        <form action="${pageContext.request.contextPath }/homeServlet?method=gatfang" method="post">
            <div class="search__area">
                <!-- 租房导航 -->
                <div class="beike__nav">
                    <a href="${pageContext.request.contextPath}/homeServlet?method=gatfang" class="home_text"><img class="home_img" src="${pageContext.request.contextPath}/public/img/home.png"></a>
                    <ul class="beike__nav--tab">
                        <li>
                            <a class="cur" href="${pageContext.request.contextPath}/homeServlet?method=gatfang">贝壳-F</a>
                        </li>
                    </ul>
                </div>

                <!-- 搜索房源sug -->
                <div class="search w1150" id="search">
                    <!-- <a class="search__logo" href="/"></a> -->
                    <div class="search__wrap">
                        <input class="search__input fl" type="text" placeholder="请输入区域、商圈或小区名开始找房" autocomplete="off" value="" name="ming">

                        <button class="search__button fl" id="signUp" style="outline-color: #fff; border: none"></button>
                    </div>

                </div>
            </div>
            <!-- 列表页面包屑 -->
            <div class="bread__nav w1150 ">
                <p class="bread__nav__wrapper oneline">
                    <a href="https://cd.zu.ke.com/">成都贝壳-F网</a>&nbsp;&gt;&nbsp;
                <h1>
                    <a href="https://cd.zu.ke.com/zufang/">成都租房</a>
                </h1>
                </p>
            </div>
            <!-- 筛选项 -->
            <div class="filter">
                <div class="filter__wrapper w1150" id="filter">
                    <ul class="filter__item--noaside">
                        <li class="filter__item--level1 down strong" data-tab="1" data-el="area" data-antitarget="station"><a href="/zufang/" onclick="return false;">按区域</a></li>
                    </ul>
                    <ul data-target="area" class="">
                        <li data-id="0" data-type="district" class="filter__item--level2 filter__item--aside strong">
                            <p rel="nofollow">不限
                                <input class="filter_radio" type="radio" name="radio1" value="" style="width: 15px;height: 15px; transform: translateY(-11%)"/>
                            </p>
                        </li>
                        <li data-id="510104" data-type="district" class="filter__item--level2  ">
                            <p>锦江
                                <input class="filter_radio" type="radio" name="radio1" value="锦江" style="width: 15px;height: 15px; transform: translateY(-11%)"/>
                            </p>
                        </li>
                        <li data-id="510105" data-type="district" class="filter__item--level2  ">
                            <p>青羊
                                <input class="filter_radio" type="radio" name="radio1" value="青羊" style="width: 15px;height: 15px; transform: translateY(-11%)"/>
                            </p>
                        </li>
                        <li data-id="510107" data-type="district" class="filter__item--level2  ">
                            <p>武侯
                                <input class="filter_radio" type="radio" name="radio1" value="武侯" style="width: 15px;height: 15px; transform: translateY(-11%)"/>
                            </p>
                        </li>
                        <li data-id="990002" data-type="district" class="filter__item--level2  ">
                            <p>高新
                                <input class="filter_radio" type="radio" name="radio1" value="高新" style="width: 15px;height: 15px; transform: translateY(-11%)"/>
                            </p>
                        </li>
                        <li data-id="510108" data-type="district" class="filter__item--level2  ">
                            <p >成华
                                <input class="filter_radio" type="radio" name="radio1" value="成华" style="width: 15px;height: 15px; transform: translateY(-11%)"/>
                            </p>
                        </li>
                        <li data-id="510106" data-type="district" class="filter__item--level2  ">
                            <p >金牛
                                <input class="filter_radio" type="radio" name="radio1" value="金牛" style="width: 15px;height: 15px; transform: translateY(-11%)"/>
                            </p>
                        </li>
                        <li data-id="23008850" data-type="district" class="filter__item--level2  ">
                            <p>天府新区
                                <input class="filter_radio" type="radio" name="radio1" value="天府新区" style="width: 15px;height: 15px; transform: translateY(-11%)"/>
                            </p>
                        </li>
                        <li data-id="23009121" data-type="district" class="filter__item--level2  ">
                            <p>高新西
                                <input class="filter_radio" type="radio" name="radio1" value="高新西" style="width: 15px;height: 15px; transform: translateY(-11%)"/>
                            </p>
                        </li>
                        <li data-id="510122" data-type="district" class="filter__item--level2  ">
                            <p>双流
                                <input class="filter_radio" type="radio" name="radio1" value="双流" style="width: 15px;height: 15px; transform: translateY(-11%)"/>
                            </p>
                        </li>
                    </ul>
<%--                    租赁方式--%>
                    <ul class="filter__ul" data-el="rentType" id="fangs">
                        <li class="filter__item--level4 filter__item--aside">
                            <a href="javascript:;" style="transform: translateY(50%)">方式</a></li>
                        <li data-id="0" class="filter__item--level4 strong">
                            <label for="man"  :class="{cor:buxian}" @click="onbuxian">
                                <input type="radio" value="" name="zufangs"  id="man" style="width: 0px;"/>
                                不限
                            </label>
                        </li>
                        <li data-id="200600000001" class="filter__item--level4 ">
                                <label for="man2" :class="{cor:zhengzu}" @click="onzhangzu">
                                    <input type="radio" value="整租" name="zufangs"  id="man2" style="width: 0px;"/>
                                    整租
                                </label>
                            </a>

                        </li>
                        <li data-id="200600000002" class="filter__item--level4 ">
                            <label for="man3"  :class="{cor:hezu}" @click="onhezu">
                                <input type="radio" value="合租" name="zufangs"  id="man3" style="width: 0px;"/>
                                合租
                            </label>
                        </li>
                    </ul>

                    <ul class="filter__ul" data-el="filterPrice">
                        <li class="filter__item--level5 filter__item--aside"><a href="javascript:;">租金</a></li>
                        <li class="filter__item--input" data-url="/zufang/brp{min}erp{max}/">
                            <input type="text" name="minpic" value="">
                            -
                            <input name="maxpic" type="text" value="">元
                        </li>
                    </ul>
                    <ul class="filter__ul">
                        <li class="filter__item--level5 filter__item--aside"><a href="javascript:;">户型</a></li>
                        <li class="filter__item--level5 check ">
                            <p>
                                <input class="filter_radio" type="radio" name="radio2" value="1" style="width: 15px;height: 15px; transform: translateY(-11%)"/>
                                一居
                            </p>
                        </li>
                        <li class="filter__item--level5 check ">
                            <p>
                                <input class="filter_radio" type="radio" name="radio2" value="2" style="width: 15px;height: 15px; transform: translateY(-11%)"/>
                                二居
                            </p>                        </li>
                        <li class="filter__item--level5 check ">
                            <p>
                                <input class="filter_radio" type="radio" name="radio2" value="3" style="width: 15px;height: 15px; transform: translateY(-11%)"/>
                                三居
                            </p>                        </li>
                        <li class="filter__item--level5 check ">
                            <p>
                                <input class="filter_radio" type="radio" name="radio2" value="4" style="width: 15px;height: 15px; transform: translateY(-11%)"/>
                                四居
                            </p>
                        </li>
                    </ul>
                <div class="filter__item--more" data-el="filterMore">收起<i class="more-icon"></i></div>
            </div>
        </div>
    </form>

        <!-- 房源列表相关信息 -->
        <div class="content w1150" id="content">
            <div class="content__article">
                <!-- 搜索结果信息 -->
                <p class="content__title">
                    已为您找到 <span class="content__title--hl">xxx</span> 套 <a href="https://cd.zu.ke.com/zufang/" target="_blank" style="text-decoration:none;color:black">租房</a>
                    <span class="content__title--aside"><a href="/zufang/" id="clearUrl">清空条件</a></span>
                </p>
                <!-- 有结果时，房源列表 -->
                <div class="content__list">
                    <!-- 房源列表模块 -->
                    <div class="content__list--item">
                            <!-- 左边图片 -->
                            <a class="content__list--item--aside" target="_blank" href="homeServlet?method=gofxiangqing">
                                <img
                                        src="https://s1.ljcdn.com/matrix_pc/dist/pc/src/resource/default/250-182.png?_v=20201214143047025"
                                        data-src="https://ke-image.ljcdn.com/rent-user-avatar/ac7acf4c-2a2c-45ed-84a0-c3947e44c8e2.250x182.jpg"
                                        class="lazyload">
                                <!-- 是否展示vr图片 -->
                                <i class="vr-logo"></i>
                            </a>
                            <!-- 右边内容 -->
                            <div class="content__list--item--main">
                                <!-- title -->
                                <p class="content__list--item--title twoline">
                                    <a target="_blank" href="/apartment/26828.html">
                                        独栋·佳寓 武侯新城科创园店 地铁口 可月付 1室1厅
                                    </a>
                                </p>
                                <!-- house info -->
                                <p class="content__list--item--des">
                                    18㎡
                                    <i>/</i>6间在租 <i>/</i>
                                    1室1厅1卫
                                </p>
                                <!-- tags -->
                                <p class="content__list--item--bottom oneline">
                                    <i class="content__item__tag--authorization_apartment">独栋公寓</i>
                                    <i class="content__item__tag--rent_period_month">月租</i>
                                    <i class="content__item__tag--is_subway_house">近地铁</i>
                                    <i class="content__item__tag--deposit_1_pay_1">押一付一</i>
                                </p>
                                <!-- brand -->
                                <p class="content__list--item--brand oneline">
                                    <span class="brand">佳寓</span>
                                    <span class="content__list--item--time">1个月前维护</span>
                                </p>

                                <!-- price -->
                                <span class="content__list--item-price"><em>1219-1340</em> 元/月</span>
                            </div>
                        </a>
                    </div>
                </div>

                <!-- 列表分页模块 -->
                <div class="content__pg" data-el="page_navigation" data-url="/zufang/pg{page}/" data-totalPage=10 data-curPage=1>
                </div>
            </div>
        </div>
    </div>
    <!-- 检索出房源结果时，添加检索id埋点 -->
    <input type="hidden" id="queryId" value="392325117734506496">
    <script src="https://s1.ljcdn.com/agent-sj-sdk/1.2.0/agent-sj-sdk.js"></script>
    <script>
        g_conf.pageId = 'rentalList';
        g_conf.requestId = '12181131869163';
        g_conf.resblockId = '';
        g_conf.total = '33825';
        g_conf.cityId = '510100'
        var __requireList = ['https://s1.ljcdn.com/matrix_pc/dist/pc/src/page/list/index.js?_v=20201214143047025'];
        document.getElementById('clearUrl').href = '/zufang/brp{min}erp{max}/'.split('zufang/')[0] + 'zufang/';
    </script>
</div>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script>
    var fang  = new Vue({
        el:"#fangs",
        data:{
            buxian:true,
            zhengzu:false,
            hezu:false
        },
        methods:{
            onbuxian:function () {
                this.buxian = true;
                this.zhengzu = false;
                this.hezu = false;
            },
            onzhangzu:function () {
                this.buxian = false;
                this.zhengzu = true;
                this.hezu = false;
            },
            onhezu:function () {
                this.buxian = false;
                this.zhengzu = false;
                this.hezu = true;
            }
        }
    })
</script>
</body>


<!-- 页面依赖JS加载 -->

<!-- common.js线上引入灯塔 -->
<script type="text/javascript" src="https://s1.ljcdn.com/matrix_pc/dist/pc/src/common/common.js?_v=20201214143047025" crossorigin="anonymous"></script>

<script>
    // var __basePath = 'https://s1.ljcdn.com/matrix_pc/dist/pc/src?_v=20201214143047025'.split("?") || [];
    // require.config({
    //     //baseUrl: __basePath[0],
    //     paths: {},
    //     urlArgs: __basePath[1],
    //     crossorigin: Boolean('1') //线上环境加该属性,需要再amd.js中单独配置一下
    // });
    var config = {
        "fe_root": "https:\/\/s1.ljcdn.com\/matrix_pc\/dist\/pc",
        "version": "20201214143047025",
        "js_ns": "m_pages_zufangSearch",
        "cur_city_id": "510100",
        "cur_city_name": "\u6210\u90fd",
        "cur_city_short": "cd"
    };
    (function() {
        for (var i = 0, len = __requireList.length; i < len; i++) {
            var item = __requireList[i]
            item = item.split("?")[0]
            require([item], function(engine) {
                engine.init()
            })
        }
    })()
</script>

<!-- 埋点配置文件 -->

<script>
    window.__UDL_CONFIG = window.__UDL_CONFIG || {}
    window.__UDL_CONFIG.pid = window.__UDL_CONFIG.pid || "bigc_pc_rent"
    window.__UDL_CONFIG.env = ('prod' === 'prod' ? "dac" : 'test')
    window.__UDL_CONFIG["uicode"] = g_conf.pageId || ''

    var _script = document.createElement('script')
    _script.type = 'text/javascript'
    // 该属性是为了配合接入灯塔，所有script标签都需加的属性
    _script.setAttribute('crossorigin', 'anonymous')
    document.getElementsByTagName('head')[0].appendChild(_script)
    if (window.__UDL_CONFIG.env === 'test') {
        _script.src = '//test-s1.ljcdn.com/matrix_pc/dist/pc/third/dig.js?' + __basePath[1]
    } else {
        _script.src = '//s1.ljcdn.com/matrix_pc/dist/pc/third/dig.js?' + __basePath[1]
    }
</script>
</html>
