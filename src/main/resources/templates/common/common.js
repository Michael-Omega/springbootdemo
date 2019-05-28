var host="localhost:8080/";
var storage = window.localStorage;
var token = storage.getItem("token");
function post(url,params,fnc) {

    if (null==token){
        post.apply(postfncNoToken,[url,params,fnc]);
    }else {
        post.apply(postfnc,[url,params,fnc]);
    }

    var postfncNoToken = function(url,params,fnc){
        $.ajax({
            url:host+url,
            data:params ||{},
            type:"post",
            dataType:"json",
            header:{
                "content-type":"application/x-www-form-urlencoded;charset=UTF-8"
            },
            success : function (res) {
                fnc.apply(this,arguments);
            },
            fail:function (error) {
                
            }
        })
    };


    var postfnc = function(url,params,fnc){
        $.ajax({
            url:host+url,
            data:params ||{},
            type:"post",
            dataType:"json",
            header:{
                "content-type":"application/x-www-form-urlencoded;charset=UTF-8",
                "Authorization":token
            },
            success : function (data) {
                fnc.apply(this,arguments);
            },
            fail:function (error) {
                
            }
        })
    };


    
}