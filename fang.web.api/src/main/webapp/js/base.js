// JavaScript Document
var user;

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
	
	$(".get-code").on("click",function() {
		type = $(this).attr("data-msg");
		mobile = $(this).parent().prev().find(".phone").val();
		if (!mobile)
            return void alertMsg("请输入手机号码！");
        if (!RegExpClass.isPhone(mobile))
            return void alertMsg("请输入正确的手机号码！");
		c = {
	            mobile: mobile,
	            type: type
	        };
		$.ajax({
            url: window.g_base.apibase + "/smsUtil/sendVerifyCode",
            type: "post",
            headers: {'Content-type': 'application/json;charset=UTF-8'},
            dataType: "json",
            data: JSON.stringify(c),
            xhrFields: {
                withCredentials: !0
            },
            success: function(i) {
            	"A00000" != i.status  && (
            			alertMsg("发送失败，请重试"));
            },
            error: function(i) {
            	alertMsg("登录失败 系统错误");
            }
        });
		
		//倒计时
		$(this).addClass("count"),
		p=null, u=-1, waiteTime = 60;
		u = waiteTime,
        clearTimeout(p),
        o();
		$(".get-code").attr("disabled","true");
        
		function o() {
            u <= 0 ? ($(".get-code").text("发送验证码"),
            $(".get-code").removeClass("count"),
            $(".get-code").removeAttr("disabled"),
            u = waiteTime) : ($(".get-code").text(u + "秒后再试"),
            u--,
            p = setTimeout(o, 1e3))
        }
	});
	
});


function checkLogin(callBack) {
	$.ajax({
        type: "GET",
        url: "/api/user/checkUserLogin?_key=" + Math.random(),
        xhrFields: {
            withCredentials: !0
        },
        dataType: "json",
        success: function(s) {
            if("A00000" == s.status && s.data != null && s.data.isLogin === 1) {
            	$("#logined").removeClass("hide");
            	user = s.data;
            	callBack(s.data)
            } else {
            	$("#notLogin").removeClass("hide");
            	callBack(s.data)
            }
        }
    });
};

function init(e) {
    (e != null && e.isLogin === 1) ? 
   		 $("#loginInfoWrap").html('<a href="/html/user/index.html" class="sider-mine">个人中心</a>') : 
   			$("#loginInfoWrap").html('<a href="/html/user/login.html" class="sider-mine">个人中心<span>(未登录)</span></a>');
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
	
	function genSwiper(e) {
	    if (e && !(e.length <= 0))
	        for (var t in e) {
	            var a = e[t]
	              , i = (document.body.clientWidth / 750 * 420,
	            $("#imgBox" + a.roomId));
	            (function(e) {
	                new Swiper(e,{
	                    initialSlide: 0,
	                    touchAngle: 30,
	                    threshold: 10,
	                    loop: !0,
	                    touchMoveStopPropagation: !1,
	                    preloadImages: !1,
	                    onSlideChangeStart: function(t) {
	                        if (1 != t.activeIndex) {
	                            var a = e.find(".swiper-slide-active").find("img");
	                            a.hasClass("swiper-lazy") && (a.attr({
	                                src: a.data("src")
	                            }),
	                            a.removeClass("swiper-lazy"))
	                        }
	                    },
	                    onSlideChangeEnd: function(t) {
	                        e.find(".curPage").text(+e.find(".swiper-slide-active").attr("data-swiper-slide-index") + 1)
	                    }
	                })
	            }
	            ).bind(this, i)()
	        }
	}	
	
	function parseQuery(e) {
	    for (var t = {},
	    i = e.substr(1).split("&"), n = 0; n < i.length; n++) {
	        var s = i[n].split("=");
	        t[decodeURIComponent(s[0])] = decodeURIComponent(s[1] || "")
	    }
	    return t
	} 
	
	function dateStr(date) {
		var year = date.getFullYear();
		var mm = date.getMonth() + 1;
		var dd = date.getDate();
		
		var hh = date.getHours();
		var mi = date.getMinutes();
		var ss = date.getSeconds();
		
		var str = year + "-" + (mm < 10 ? "0"+mm : mm) + "-" + (dd < 10 ? "0"+dd : dd) + " " + (hh < 10 ? "0"+hh : hh) + ":"
			+ (mi < 10 ? "0"+mi : mi) + ":" + (ss < 10 ? "0"+ss : ss);
		return  str;
	}
	
try{ document.domain = 'bohosi.com';}catch(e){}
            window.g_base = {"sitebase":"http://1hf.bohosi.com","apibase":"http://1hf.bohosi.com/api"}