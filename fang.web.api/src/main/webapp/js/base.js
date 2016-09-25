// JavaScript Document


$(document).ready(function(){
	
	$(".menu-icon").on("tap click", function() {
	    $(".sideBar").show(),
	    $("#cfmask").show()
	});
	
	$("#mask").click(function() {
	    $(".operate-tip").addClass("opetate-tip-none"),
	    $("#mask").hide(),
	    $(".two-loginerror").hide()
	});
	
	$(".operate-tip").on("click", function() {
	    $(".operate-tip").addClass("opetate-tip-none"),
	    $("#mask").hide()
	});
	 
	$("#cfmask").on("tap click touchstart", function() {
		$(".sideBar").hide(),
		$("#cfmask").hide()
    });
});


function checkLogin(callBack) {
	$.ajax({
        type: "GET",
        url: "/api/user/checkUserLogin",
        xhrFields: {
            withCredentials: !0
        },
        dataType: "json",
        success: function(s) {
            if("A00000" == s.status && s.data != null) {
            	$("#logined").removeClass("hide");
            	callBack(s.data)
            } else {
            	$("#notLogin").removeClass("hide");
            	callBack(s.data)
            }
        }
    });
};

function init(e) {
    e != null ? 
   		 $("#loginInfoWrap").html('<a href="/html/user/home" class="sider-mine">我的1号房<span>(' + 1 + "待付)</span></a>") : 
   			$("#loginInfoWrap").html('<a href="/html/user/home" class="sider-mine">我的1号房<span>(已登录)</span></a>');
};
//正则表达式工具
 var RegExpClass = {
        isEmail: function(e) {
            var t = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
            return !!t.test(e)
        },
        isPhone: function(e) {
            var t = /\d{11}/;
            return !!t.test(e)
        },
        isNickName: function(e) {
            if (e.length > 10 || 0 == e.length)
                return !1;
            var t = /^([\u4E00-\u9FFF]*[\w]*)+$/;
            return !!t.test(e)
        },
        isPassword: function(e) {
            return !(e.length > 18 || e.length < 6)
        }
    };

 function alertMsg(msg) {
	    $(".operate-tip p").text(msg),
	    $(".operate-tip").removeClass("opetate-tip-none"),
	    $("#mask").show()
	}; 
 
try{ document.domain = 'bohosi.com';}catch(e){}
            window.g_base = {"sitebase":"http://192.168.1.103","apibase":"http://192.168.1.101/api"}