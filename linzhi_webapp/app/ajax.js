(function($){
    //备份jquery的ajax方法
    var _ajax=$.ajax;

    //重写jquery的ajax方法
    $.ajax=function(opt){
        //备份opt中error和success方法
        var fn = {
            error:function(XMLHttpRequest, textStatus, errorThrown){},
            success:function(data, textStatus){}
        }
        // if(!opt.url)
        // {
        //     return false
        // }

        if(opt.url.indexOf(".json")==-1&&opt.url.indexOf("http")==-1)
        {
           // opt.url = "http://localhost/" + opt.url;
           opt.url = "http://192.168.10.109:8080/" + opt.url;
            opt.type="post";
            opt.dataType= "json";
        }


        if(opt.data&&!opt.myType&&(typeof  opt.data)=="object")
        {
            opt.data=JSON.stringify(opt.data);
        }
        // opt.crossDomain=true;

        if(opt.error){
            fn.error=opt.error;
        }
        if(opt.success){
            fn.success=opt.success;
        }
        if(opt.myType)
        {
            opt.headers={
                'x-auth-token':localStorage.token?localStorage.token:""
            }
        }
        else
        {
            opt.headers={
                'Content-Type': 'application/json',
                //contentType: "text/xml",//(可以)
                //contentType:"application/x-www-form-urlencoded",//(可以)
                'X-Token':localStorage.token?localStorage.token:""
            }
        }
        //扩展增强处理
        var _opt = $.extend(opt,{
            error:function(XMLHttpRequest, textStatus, errorThrown){
                //错误方法增强处理

                fn.error(XMLHttpRequest, textStatus, errorThrown);
            },
            success:function(data, textStatus){
                //成功回调方法增强处理
                if(null != data["status"] && 1001 == data["status"]) {
                    window.top.location = "#/login";
                }
                fn.success(data, textStatus);
            }
        });
        _ajax(_opt);
    };
})(jQuery);