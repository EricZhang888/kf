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
                return void alertMsg("请输入手机号码！");
            if (!RegExpClass.isPhone(phone))
                return void alertMsg("请输入正确的手机号码！");
            if (!pass)
                return void alertMsg("密码不能为空！");
            if (!RegExpClass.isPassword(pass))
                return void alertMsg("密码格式不正确！请输入6-18位的密码！")
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
	
	//找回密码下一步
    $(".jump-setPassword").on("click", function() {
        var e = $(this).parents("form").serializeArray()[0].value
          , t = $(this).parents("form").serializeArray()[1].value;
        checkPhoneAndVcode(e, t) && ($(".findPassword").addClass("over"),
        $(".setPassword").addClass("show"))
    });
    
    
    //设置新密码
    $(".affirm-password").on("click", function() {
    	//alert(md5("123456"));
        var pwd1 = $(this).parents("form").serializeArray()[0].value
          , pwd2 = $(this).parents("form").serializeArray()[1].value;
        if (!pwd1.length)
            return void alertMsg("密码不能为空！");
        if (!RegExpClass.isPassword(pwd1))
            return void alertMsg("密码格式不正确！请输入6-18位的密码！");
        if (!pwd2.length)
            return void alertMsg("请再次输入新密码！");
        if (pwd1 != pwd2)
            return void alertMsg("两次输入的密码不一致！");
        var n = $(".jump-setPassword")
          , a = n.parents("form").serializeArray()[0].value
          , s = n.parents("form").serializeArray()[1].value
          , l = window.g_base.apibase + "/user/change_password_by_mobile"
          , c = {
            mobile: a,
            code: s,
            passwd: pwd1
        }
          , u = JSON.stringify(c);
        o.ajax({
            url: l,
            type: "post",
            dataType: "json",
            data: u,
            xhrFields: {
                withCredentials: !0
            },
            success: function(i) {
                0 === i.status ? (alertMsg("密码修改成功"),
                setTimeout(function() {
                    window.location.href = "/"
                }, 1e3)) : alertMsg(i.msg)
            },
            error: function(i) {
            	alertMsg(i)
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
};


//md5

var md5 = function(e) {
    var t, n, s, a, r, f, m, g, v, w = Array(), y = 7, x = 12, b = 17, T = 22, S = 5, E = 9, C = 14, k = 20, P = 4, z = 11, M = 16, L = 23, D = 6, I = 10, A = 15, H = 21;
    for (e = u(e),
    w = d(e),
    f = 1732584193,
    m = 4023233417,
    g = 2562383102,
    v = 271733878,
    t = 0; t < w.length; t += 16)
        n = f,
        s = m,
        a = g,
        r = v,
        f = o(f, m, g, v, w[t + 0], y, 3614090360),
        v = o(v, f, m, g, w[t + 1], x, 3905402710),
        g = o(g, v, f, m, w[t + 2], b, 606105819),
        m = o(m, g, v, f, w[t + 3], T, 3250441966),
        f = o(f, m, g, v, w[t + 4], y, 4118548399),
        v = o(v, f, m, g, w[t + 5], x, 1200080426),
        g = o(g, v, f, m, w[t + 6], b, 2821735955),
        m = o(m, g, v, f, w[t + 7], T, 4249261313),
        f = o(f, m, g, v, w[t + 8], y, 1770035416),
        v = o(v, f, m, g, w[t + 9], x, 2336552879),
        g = o(g, v, f, m, w[t + 10], b, 4294925233),
        m = o(m, g, v, f, w[t + 11], T, 2304563134),
        f = o(f, m, g, v, w[t + 12], y, 1804603682),
        v = o(v, f, m, g, w[t + 13], x, 4254626195),
        g = o(g, v, f, m, w[t + 14], b, 2792965006),
        m = o(m, g, v, f, w[t + 15], T, 1236535329),
        f = l(f, m, g, v, w[t + 1], S, 4129170786),
        v = l(v, f, m, g, w[t + 6], E, 3225465664),
        g = l(g, v, f, m, w[t + 11], C, 643717713),
        m = l(m, g, v, f, w[t + 0], k, 3921069994),
        f = l(f, m, g, v, w[t + 5], S, 3593408605),
        v = l(v, f, m, g, w[t + 10], E, 38016083),
        g = l(g, v, f, m, w[t + 15], C, 3634488961),
        m = l(m, g, v, f, w[t + 4], k, 3889429448),
        f = l(f, m, g, v, w[t + 9], S, 568446438),
        v = l(v, f, m, g, w[t + 14], E, 3275163606),
        g = l(g, v, f, m, w[t + 3], C, 4107603335),
        m = l(m, g, v, f, w[t + 8], k, 1163531501),
        f = l(f, m, g, v, w[t + 13], S, 2850285829),
        v = l(v, f, m, g, w[t + 2], E, 4243563512),
        g = l(g, v, f, m, w[t + 7], C, 1735328473),
        m = l(m, g, v, f, w[t + 12], k, 2368359562),
        f = c(f, m, g, v, w[t + 5], P, 4294588738),
        v = c(v, f, m, g, w[t + 8], z, 2272392833),
        g = c(g, v, f, m, w[t + 11], M, 1839030562),
        m = c(m, g, v, f, w[t + 14], L, 4259657740),
        f = c(f, m, g, v, w[t + 1], P, 2763975236),
        v = c(v, f, m, g, w[t + 4], z, 1272893353),
        g = c(g, v, f, m, w[t + 7], M, 4139469664),
        m = c(m, g, v, f, w[t + 10], L, 3200236656),
        f = c(f, m, g, v, w[t + 13], P, 681279174),
        v = c(v, f, m, g, w[t + 0], z, 3936430074),
        g = c(g, v, f, m, w[t + 3], M, 3572445317),
        m = c(m, g, v, f, w[t + 6], L, 76029189),
        f = c(f, m, g, v, w[t + 9], P, 3654602809),
        v = c(v, f, m, g, w[t + 12], z, 3873151461),
        g = c(g, v, f, m, w[t + 15], M, 530742520),
        m = c(m, g, v, f, w[t + 2], L, 3299628645),
        f = p(f, m, g, v, w[t + 0], D, 4096336452),
        v = p(v, f, m, g, w[t + 7], I, 1126891415),
        g = p(g, v, f, m, w[t + 14], A, 2878612391),
        m = p(m, g, v, f, w[t + 5], H, 4237533241),
        f = p(f, m, g, v, w[t + 12], D, 1700485571),
        v = p(v, f, m, g, w[t + 3], I, 2399980690),
        g = p(g, v, f, m, w[t + 10], A, 4293915773),
        m = p(m, g, v, f, w[t + 1], H, 2240044497),
        f = p(f, m, g, v, w[t + 8], D, 1873313359),
        v = p(v, f, m, g, w[t + 15], I, 4264355552),
        g = p(g, v, f, m, w[t + 6], A, 2734768916),
        m = p(m, g, v, f, w[t + 13], H, 1309151649),
        f = p(f, m, g, v, w[t + 4], D, 4149444226),
        v = p(v, f, m, g, w[t + 11], I, 3174756917),
        g = p(g, v, f, m, w[t + 2], A, 718787259),
        m = p(m, g, v, f, w[t + 9], H, 3951481745),
        f = i(f, n),
        m = i(m, s),
        g = i(g, a),
        v = i(v, r);
    var X = h(f) + h(m) + h(g) + h(v);
    return X.toLowerCase()
};

