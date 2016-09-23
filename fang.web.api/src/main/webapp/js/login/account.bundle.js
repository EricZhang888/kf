$(document).ready(function(){
	//登录方式切换
	
	$(".jump-common").on("click", function(e) {
	    $(".phone-login").addClass("over"),
	    $(".common-login").addClass("show")
	}),
	$(".jump-phone").on("click", function(e) {
	    $(".phone-login").removeClass("over"),
	    $(".common-login").removeClass("show")
	}),
	$(".jump-findPassword").on("click", function(e) {
	    $(".common-login").addClass("over"),
	    $(".findPassword").addClass("show"),
	    $(".two-loginerror").hide(),
	    $("#mask").hide()
	}),
	$(".account .icon-left").on("click", function(e) {
	    1 != $(".account.show").length && ($(this).parents(".account").removeClass("show"),
	    $(this).parents(".account").prev().removeClass("over"))
	}),
	$("#mask").click(function() {
	    $(".operate-tip").addClass("opetate-tip-none"),
	    $("#mask").hide(),
	    $(".two-loginerror").hide()
	}),
	$(".operate-tip").on("click", function() {
	    $(".operate-tip").addClass("opetate-tip-none"),
	    $("#mask").hide()
	});
	
	$(".menu-icon").on("tap click", function() {
	    $(".sideBar").show(),
	    $("#cfmask").show()
	});
	 
	$("#cfmask").on("tap click touchstart", function() {
		$(".sideBar").hide(),
		$("#cfmask").hide()
    });
	//获取验证码按钮
	/*var f = $(".get-code");
    $(f).lenght && $(f).each(function(i, t) {
        var n = $(t);
        s(n, n.parent().prev().find(".phone"), {
            clsDis: "doing",
            clsCounting: "count",
            message: function(i) {
            	alertMsg(i)
            }
        })
    });*/
	
	//登录按钮
    $(".login").on("click", function() {
        var t = !0;
        //验证码登录
        if ($(this).hasClass("phone-button")) {
            t = !1;
            var phone = $(this).parents("form").serializeArray()[0].value
              , vcode = $(this).parents("form").serializeArray()[1].value;
            if (!checkPhoneAndVcode(phone, vcode))
                return
        } else {
        	//密码登录
            var phone = $(this).parents("form").serializeArray()[0].value
              , pass = $(this).parents("form").serializeArray()[1].value;
            if (!phone)
                return void e("请输入手机号码！");
            if (!RegExpClass.isPhone(phone))
                return void e("请输入正确的手机号码！");
            if (!pass)
                return void e("密码不能为空！");
            if (!RegExpClass.isPassword(pass))
                return void e("密码格式不正确！请输入6-18位的密码！")
        }
        var d = "/user/user_login"
          , h = {};
        t ? h = {
            platform: 3,
            mobile: l,
            passwd: o.md5(u)
        } : (d = "/user/user_code_login",
        h = {
            platform: 3,
            mobile: a,
            code: s
        }),
        d = window.g_base.apibase + d;
        var f = JSON.stringify(h);
        o.ajax({
            url: d,
            type: "post",
            dataType: "json",
            data: f,
            xhrFields: {
                withCredentials: !0
            },
            success: function(i) {
                if (0 === i.status) {
                    o(".two-loginerror").hide(),
                    e("登录成功");
                    var r = n.getQueryString("redirectUrl");
                    c(r) ? setTimeout(function() {
                        location.href = r
                    }, 200) : (o("#mask").click(function() {
                        location.href = "/" + location.hash.substr(2)
                    }),
                    o(".operate-tip").on("click", function() {
                        location.href = "/" + location.hash.substr(2)
                    }),
                    setTimeout(function() {
                        return "" != location.hash ? void (location.href = "/" + location.hash.substr(2)) : void (location.href = "/" + location.hash.substr(2))
                    }, 500))
                } else
                    11110 === i.status ? t && p++ : e(i.msg);
                t && 0 !== i.status && p >= 2 && (o(".operate-tip").addClass("opetate-tip-none"),
                o("#mask").show(),
                o(".two-loginerror").show())
            },
            error: function(i) {
                e("登录失败：" + i)
            }
        })
    });
	
	
});


//验证码登录校验
function checkPhoneAndVcode(phone, vcode) {
	var o = !0;
    do {
        if (!phone) {
        	alertMsg("请输入手机号码！"),
            o = !1;
            break
        }
        if (!RegExpClass.isPhone(phone)) {
        	alertMsg("请输入正确的手机号码！"),
            o = !1;
            break
        }
        if (!vcode) {
        	alertMsg("验证码不能为空！"),
            o = !1;
            break
        }
        if (!/\d/.test(vcode)) {
        	alertMsg("验证码错误！"),
            o = !1;
            break
        }
    } while (!1);return o
};

function alertMsg(msg) {
    $(".operate-tip p").text(msg),
    $(".operate-tip").removeClass("opetate-tip-none"),
    $("#mask").show()
}


