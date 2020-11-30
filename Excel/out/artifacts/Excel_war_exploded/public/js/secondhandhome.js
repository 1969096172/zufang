var mouse = document.querySelectorAll(".act");
var pb = document.querySelectorAll(".select");
for(var i=0; i<mouse.length; i++){
    mouse[i].setAttribute('index',i);//添加指定的属性，并为其赋指定的值。如果这个指定的属性已存在，则仅设置/更改值。
    mouse[i].onclick = function (){
        for(var i=0; i<mouse.length; i++){
            mouse[i].className = "";
        }
        this.className = "action";
        var index = this.getAttribute('index');
        for(var i = 0; i<pb.length; i++){
            pb[i].style.display = "none";
        }
        pb[index].style.display = "block";
    }
}