webpackJsonp([0], [function(e, i, t) {
    var o = t(1)
      , n = (t(2),
    t(4))
      , r = t(5)
      , a = t(6)
      , s = t(7)
      , l = (t(9),
    t(10));
    o(function() {
        function e(e) {
            o(".operate-tip p").text(e),
            o(".operate-tip").removeClass("opetate-tip-none"),
            o("#mask").show()
        }
        function i(i, t) {
            var o = !0;
            do {
                if (!i) {
                    e("请输入手机号码！"),
                    o = !1;
                    break
                }
                if (!r.isPhone(i)) {
                    e("请输入正确的手机号码！"),
                    o = !1;
                    break
                }
                if (!t) {
                    e("验证码不能为空！"),
                    o = !1;
                    break
                }
                if (!/\d/.test(t)) {
                    e("验证码错误！"),
                    o = !1;
                    break
                }
            } while (!1);return o
        }
        function c(e) {
            var i = !1;
            if ("undefined" == typeof e || null == e)
                return !1;
            if (e && 0 == e.indexOf("/"))
                return !0;
            var t = /^http(s)?:\/\/((([\w-]+)\.)+[\w-]+)(\/[\w- .\/?%&=]*)?/
              , o = e.toLowerCase();
            0 != o.indexOf("http://") && 0 != o.indexOf("https://") && (e = "http://" + e);
            var n = e.match(t);
            if ("undefined" != typeof n && null != n) {
                i = u(o),
                i = i.toLowerCase();
                var r = i.split(".");
                if (r.length >= 2 && "estay" == r[r.length - 2] && "com" == r[r.length - 1])
                    return !0
            }
            return !1
        }
        function u(e) {
            var i = document.createElement("a");
            return i.href = e,
            i.hostname
        }
        l(function() {});
        var d = o(".account")
          , h = (o("input", ".account"),
        t(11));
        new h(d);
        o(".jump-common").on("click", function(e) {
            o(".phone-login").addClass("over"),
            o(".common-login").addClass("show")
        }),
        o(".jump-phone").on("click", function(e) {
            o(".phone-login").removeClass("over"),
            o(".common-login").removeClass("show")
        }),
        o(".jump-findPassword").on("click", function(e) {
            o(".common-login").addClass("over"),
            o(".findPassword").addClass("show"),
            o(".two-loginerror").hide(),
            o("#mask").hide()
        }),
        o(".account .icon-left").on("click", function(e) {
            1 != o(".account.show").length && (o(this).parents(".account").removeClass("show"),
            o(this).parents(".account").prev().removeClass("over"))
        }),
        o("#mask").click(function() {
            o(".operate-tip").addClass("opetate-tip-none"),
            o("#mask").hide(),
            o(".two-loginerror").hide()
        }),
        o(".operate-tip").on("click", function() {
            o(".operate-tip").addClass("opetate-tip-none"),
            o("#mask").hide()
        });
        var f = o(".get-code");
        f.size() && f.each(function(i, t) {
            var n = o(t);
            s(n, n.parent().prev().find(".phone"), {
                clsDis: "doing",
                clsCounting: "count",
                message: function(i) {
                    e(i)
                }
            })
        });
        var p = 0;
        o(".login").on("click", function() {
            var t = !0;
            if (o(this).hasClass("phone-button")) {
                t = !1;
                var a = o(this).parents("form").serializeArray()[0].value
                  , s = o(this).parents("form").serializeArray()[1].value;
                if (!i(a, s))
                    return
            } else {
                var l = o(this).parents("form").serializeArray()[0].value
                  , u = o(this).parents("form").serializeArray()[1].value;
                if (!l)
                    return void e("请输入手机号码！");
                if (!r.isPhone(l))
                    return void e("请输入正确的手机号码！");
                if (!u)
                    return void e("密码不能为空！");
                if (!r.isPassword(u))
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
        }),
        o(".exit-cancellogin").on("tap click", function() {
            o("#mask").hide(),
            o(".two-loginerror").hide()
        }),
        o(".jump-setPassword").on("click", function() {
            var e = o(this).parents("form").serializeArray()[0].value
              , t = o(this).parents("form").serializeArray()[1].value;
            i(e, t) && (o(".findPassword").addClass("over"),
            o(".setPassword").addClass("show"))
        }),
        o(".affirm-password").on("click", function() {
            var i = o(this).parents("form").serializeArray()[0].value
              , t = o(this).parents("form").serializeArray()[1].value;
            if (!i.length)
                return void e("密码不能为空！");
            if (!r.isPassword(i))
                return void e("密码格式不正确！请输入6-18位的密码！");
            if (!t.length)
                return void e("请再次输入新密码！");
            if (i != t)
                return void e("两次输入的密码不一致！");
            var n = o(".jump-setPassword")
              , a = n.parents("form").serializeArray()[0].value
              , s = n.parents("form").serializeArray()[1].value
              , l = window.g_base.apibase + "/user/change_password_by_mobile"
              , c = {
                platform: 3,
                mobile: a,
                code: s,
                passwd: o.md5(i)
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
                    0 === i.status ? (e("密码修改成功"),
                    setTimeout(function() {
                        window.location.href = "/"
                    }, 1e3)) : e(i.msg)
                },
                error: function(i) {
                    e(i)
                }
            })
        }),
        o(".input-contain input").on("keyup", function() {
            "" != o(this).val() ? o(this).siblings(".delete-input").show() : o(this).siblings(".delete-input").hide()
        }),
        o(".delete-input").on("click", function() {
            o(this).prev().val(""),
            o(this).hide()
        }),
        o("i[data-wechat]").on("click", function() {
            var e = n.getQueryString("redirectUrl");
            c(e) && a.SetCookie("wechatLoginRurl", e, 1 / 60 / 2),
            location.href = o(this).data("wechat")
        });
        var v = innerHeight;
        window.addEventListener("resize", function() {
            o(".phone-login").css("height", v)
        })
    })
}
]);
