//全局ajax返回函数
$(function () {
    $.ajaxSetup({
        global: true,
        complete: function (XMLHttpRequest, textStatus) {
            var responseJSON = XMLHttpRequest.responseJSON;
            if(responseJSON.status == 20003){
                location.href = "nologin.html"
            }

            if(responseJSON.status == 20004){
                location.href = "error.html"
            }
        }
    })
})
