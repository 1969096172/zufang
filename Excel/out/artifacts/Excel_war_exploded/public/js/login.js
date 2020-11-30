const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => container.classList.add('right-panel-active'));
signInButton.addEventListener('click', () => container.classList.remove('right-panel-active'));

//登录密码确认
function getFormInfo(){
    var params = serializeForm('login');
    alert(params); //返回修改后数组的长度
}

//获取指定form中的所有的<input>对象
function getElements(formId) {
    var form = document.getElementById(formId);
    var elements = new Array();  //Array 对象用于在单个的变量中存储多个值
    var tagElements = form.getElementsByTagName('input');
    for (var j = 0; j < tagElements.length; j++){
        elements.push(tagElements[j]); //从数组末端添加项,

    }
    return elements;
}

//获取单个input中的【name,value】数组
function inputSelector(element) {
    if (element.checked)
        return [element.name, element.value];
}

function input(element) {
    switch (element.type.toLowerCase()) {
        case 'text':
        case 'password':
            return [element.name, element.value];
            return inputSelector(element);
    }
    return false;
}

//组合URL
function serializeElement(element) {
    var method = element.tagName.toLowerCase();
    var parameter = input(element);

    if (parameter) {
        var key = encodeURIComponent(parameter[0]);
        if (key.length == 0) return;

        if (parameter[1].constructor != Array)
            parameter[1] = [parameter[1]];

        var values = parameter[1];
        var results = [];
        for (var i=0; i<values.length; i++) {
            results.push(encodeURIComponent(values[i]));
        }
        return results.join('&');
    }
}

//调用方法
function serializeForm(formId) {
    var elements = getElements(formId);
    var queryComponents = new Array();
    var cw='错误';
    for (var i = 0; i < elements.length; i++) {
        var queryComponent = serializeElement(elements[0]);
        var queryComponentw = serializeElement(elements[1]);
    }
    if (queryComponent==1 && queryComponentw==2){
        window.open("file:///E:/biao/ex2/%E6%9C%9F%E6%9C%AB%E4%B8%BB%E7%95%8C%E9%9D%A2.html");
    }
    else{
        return queryComponents;
    }

}