$(function () {

    $(".loginBtn").click(function () {
        $.post("common/login",$("#form").serialize(),resp =>{

            if(resp.status == 20000){
                location.replace("./pages/book.html");
            }else {
                $("#tips").show()
                //给标签的身体写值
                $("#tips").text(resp.msg)
            }
        })
    })

})
