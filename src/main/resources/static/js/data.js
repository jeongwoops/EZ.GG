$(function(){
    $("#a").on("click",getData);
});

function getData() {
    $.ajax({
        type:"get",
        url:"test.jsp",
        data:{
            v1:$("#v1").val(),
            v2:$("#v2").val()
        },
        dataType:"text",
        success:
    })
}