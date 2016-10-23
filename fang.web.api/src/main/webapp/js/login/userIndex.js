//登陆判断
checkLogin(initialLoginIndex);
function initialLoginIndex(user) {
	if(user == null || user.isLogin === 0) {
		location.href = "/";
	}
	
	$("#noPayOrders").text(user.noPayOrders);
	$("#noCheckInOrders").text(user.noCheckInOrders);
	$("#noMarkOrders").text(user.noMarkOrders);
	$(".user-content .phone .has-phone").text(user.phone);
	$(".password-page .input-contain .phone").attr("value", user.phone);
	if(user.pwd != null) {
		$(".user-content .password .item-key").text("修改密码");
		$(".password-page .es_header .title").text("修改密码");
		$($(".password-page .input-contain")[4]).addClass("none");
	} else {
		$(".user-content .password .item-key").text("设置密码");
		$(".password-page .es_header .title").text("设置密码");
		$($(".password-page .input-contain")[0]).addClass("none");
	}
}





//退出登录
$(".exit-login").on("tap click", function() {
            $("#mask").show(),
            $(".exit-operate-contain").show()
});

$(".userule-contain .close,.exit-login-cancel").on("tap click", function() {
    $("#mask").hide(),
    $(".userule-contain").hide(),
    $(".exit-operate-contain").hide()
});

$(".module-enter .userinf").on("tap click", function() {
    $(".index-show").css("margin-left", "0");
});

$(".index-show .es_header .left-icon").on("tap click", function() {
    $(".index-show").css("margin-left", "100%");
    $(".single-operate").removeClass("page-sile-left");
});

$(".user-info-caontain .password").on("tap click", function() {
    $(".password-page").addClass("page-sile-left")
});

$(".single-operate .es_header .left-icon").on("tap click", function() {
    $(".single-operate").removeClass("page-sile-left")
}),

//确认退出登录
$(".exit-login-affirm").on("tap click", function() {
    $.ajax({
        url: window.g_base.apibase + "/user/userLogout",
        type: "get",
        dataType: "json",
        data: "",
        xhrFields: {
            withCredentials: !0
        },
        success: function(s) {
            "A00000" === s.status ? ($(".exit-operate-contain").hide(),
            alertMsg("退出成功！"),
            $("#mask,.operate-tip").on("tap click", function() {
                location.reload();
            }),
            setTimeout(function() {
                location.reload();
            }, 2e3)) : alertMsg("操作失败（" + s.msg + "）")
        },
        error: function() {
        	alertMsg("操作失败，请重试")
        }
    })
});

//用旧密码修改 新密码
$(".password-page .save-button button").on("tap click", function() {
    var s = "";
    if (!$(".password-page .input-contain:first-child").hasClass("none")) {
        if (s = $(".password-page .oldPassword").val().trim().replace(" ", ""),
        "" == s)
            return void alertMsg("请输入旧密码！");
        if (!RegExpClass.isPassword(s))
            return void alertMsg("旧密码格式不正确！")
    }
    var a = $(".password-page .newPassword").val().trim().replace(" ", "")
      , n = $(".password-page .newPasswordAgain").val().trim().replace(" ", "")
      , o = $(".password-page .phone").val().trim().replace(" ", "")
      , r = $(".password-page .code").val().trim().replace(" ", "");
    if ("" == a)
        return void alertMsg("请输入新密码！");
    if (!RegExpClass.isPassword(a))
        return void alertMsg("新密码格式不正确！");
    if (!n.length)
        return void alertMsg("请再次输入新密码！");
    if (a != n)
        return void alertMsg("两次输入的新密码不一致！");
    if (!s && !r)
        return void alertMsg("请输入手机短信验证码");
    var c = "/user/changePasswordByOld"
        , p = {
          oldPasswd: s,
          newPasswd: a
      };
      s || (c = "/user/changePasswordByMobile",
      p = {
          mobile: o,
          code: r,
          password: a
      }),
    c = window.g_base.apibase + c,
    $.ajax({
        url: c,
        type: "post",
        dataType: "json",
        headers: {'Content-type': 'application/json;charset=UTF-8'},
        data: JSON.stringify(p),
        xhrFields: {
            withCredentials: !0
        },
        success: function(s) {
            "A00000" === s.status ? (alertMsg("修改成功"),
            $(".password-page .oldPassword").val(""),
            $(".password-page .newPassword").val(""),
            $(".password-page .newPasswordAgain").val(""),
            $(".index-show .item-info.password .item-key").html("修改密码"),
            $(".single-operate.password-page .title").html("修改密码"),
            $(".password-page .input-contain:first-child").removeClass("none"),
            $(".password-page").removeClass("page-sile-left"),
            setTimeout(function() {
                location.href = "/html/user/home/index.html"
            }, 500)) : alertMsg("操作失败（" + s.msg + "）")
        },
        error: function() {
        	alertMsg("操作失败，请重试")
        }
    })
});