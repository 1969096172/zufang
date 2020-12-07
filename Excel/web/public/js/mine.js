$(function(){
    // alert("现在来使用JS");
    var clone = $("#care_banner .banner_box .box_poto li").first().clone();
    $(".banner .banner_box .box_poto").append(clone);
     // imgLength = $("")
    var num=0;  //var创建了一个全局对象的属性,带不可删除属性
    var timer=null;
    go();
    $("#care_banner").mouseenter(function(){//实现当鼠标移动到box上时，不执行自动轮播功能
        clearInterval(timer);//移动进去时清除定时器
    }).mouseleave(function(){
        go();//移出后执行go函数
    });
    $(".on").eq(0).css("backgroundColor","orange");
    //页面加载后默认是第一张图，则让第一个导航圆点变为“选中色”。
    function go(){
      timer=setInterval(function(){//设置定时器
            num++;//用一个全局变量来控制图的运动次数
            if(num>3){//如果移动到了最后一张图，则num赋值1，调整ul边距（相当于初始化）
                num=1;
                $(".box_poto").css("margin-left","0px");
            }
            if(num==3){//由于圆点只有3个，而图片有4张，当移动到第4张图片时，给第一个圆点“选中色”。
                $(".on").css("backgroundColor","transparent");//transparent背景透明
                $(".on").eq(0).css("backgroundColor","orange");
            }
            else{//图片运动一次，导航圆点也动态的变换，这里先让所有圆点变为“不选中色”，再让当前圆点变为“选中色”。
                $(".on").css("backgroundColor","transparent");
                $(".on").eq(num).css("backgroundColor","orange");
            }
            $(".box_poto").animate({"marginLeft":-144*num+"px"},1000);//使用animate实行运动功能
        },3000);//延迟时间
    }
 
    $(".on").each(function (index) {//遍历每一个圆点添加点击事件，点击当前圆点则让num值赋为当前圆点的索引
        $(this).click(function () {//click处理频繁请求
            num=index;
            $(".on").css("backgroundColor","transparent");
            $(".on").eq(num).css("backgroundColor","orange");
            $(".box_poto").stop().animate({"marginLeft":-144*num+"px"},1000);//stop停止匹配元素正在进行的动画
        })
    });
 
    $(".btn_r").click(function(){ //右按钮点击事件，每点击一次num++,这里有很多的判断，是用来消除一些BUG的。
        if(num<=4){num++;}
        if(num>3){
            num=1;
            $(".box_poto").css("margin-left","0px");
        }
        if(num==4){
            $(".on").css("backgroundColor","transparent");
            $(".on").eq(0).css("backgroundColor","orange");
        }
        else{
            $(".on").css("backgroundColor","transparent");
            $(".on").eq(num).css("backgroundColor","orange");
        }
        $(".box_poto").stop().animate({"marginLeft":-144*num+"px"},1000);
 
    });
 
    $(".btn_1").click(function(){//左按钮点击事件
        if(num>=0){num--;}
        if(num<0){
            num=3;
            $(".on").css("backgroundColor","transparent");
            $(".on").eq(3).css("backgroundColor","orange");
            $(".box_poto").stop().animate({"marginLeft":-144*num+"px"},0);
            num=2;
        }
        else{
            $(".on").css("backgroundColor","transparent");
            $(".on").eq(num).css("backgroundColor","orange");
        }
        $(".box_poto").stop().animate({"marginLeft":-144*num+"px"},1000);
 
    });
 
 });