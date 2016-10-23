checkLogin(init);
$(document).ready(function(){
	$(".account .icon-left").on("click", function(e) {
	    1 != $(".account.show").length && ($(this).parents(".account").removeClass("show"),
	    $(this).parents(".account").prev().removeClass("over"))
	}),
	
	
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
        var d = window.g_base.apibase + "/holder/loginByPasswd"
          , h = {};
        t ? h = {
            mobile: phone,
            password: pass
        } : (d = window.g_base.apibase + "/holder/loginByVerifyCode",
        h = {
            mobile: phone,
            code: vcode
        });
        var f = JSON.stringify(h);
        $.ajax({
            url: d,
            type: "post",
            headers: {'Content-type': 'application/json;charset=UTF-8'},
            dataType: "json",
            data: f,
            xhrFields: {
                withCredentials: !0
            },
            success: function(i) {
            	"A00000" === i.status ? (
            			$(".two-loginerror").hide(),
            			alertMsg("登录成功"),
                        setTimeout(function() {
                        	jumpTo()
                        }, 1e3)) : alertMsg(i.msg)
            },
            error: function(i) {
            	alertMsg("登录失败 系统错误");
            }
        })
    });
	function jumpTo(){
		var para = parseQuery(window.location.search);
		
		if (para && para.redirect)
			window.location.href = para.redirect;
		else 
			window.location.href = "/";
	}
    
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




