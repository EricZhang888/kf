checkLogin(orderPage);
function orderPage(user) {
	if(user == null) {
		location.href = "/html/user/login.html?redirect=" + encodeURIComponent(window.location.href);
	} else {
		init(user);
	}
};

var sPara = parseQuery(window.location.search);
var add = $(".orderform-content .form-title span")[0];
var dur = $(".orderform-content .form-title span")[1];
//initial start
$(add).append(sPara.address);
$(dur).text(sPara.checkin_date + " 入住" + " —— " + sPara.checkout_date + " 退房") ;
var date = sPara.checkin_date.split("-");
var roomN = sPara.roomName + " · " + sPara.siteName.replace(sPara.roomName,"")
$(".form-title").attr("data-checkin_date",sPara.checkin_date);
$(".form-title").attr("data-checkout_date",sPara.checkout_date);
$(".form-title p").text(roomN);
$(".sum-value").text(sPara.price);
$(".payable-value").text(sPara.price);
$(".warm-tip p").text("允许变更/取消,该订单允许在" + date[0] +"年" + date[1] + "月"+ (date[2]-1) +"日 12点前取消，可全额退款，已支付的房费将在5-7工作日退回到您的支付账户");
$("#roomId").val(sPara.roomId);
//initial end

$(".submit-order").on("click tap", function() {
    const e = this;
    var t = $(".checkin-man").val()
      , a = $(".checkin-phone").val();
    if ("" == t)
    	return void alertMsg("请输入联系人姓名！");
    if (!a.length)
        return void alertMsg("请输入联系人手机号码！");
    if (!RegExpClass.isPhone(a))
        return void alertMsg("联系人手机格式不正确！");
    if ($(this).hasClass("is-login")) {
    	var info = {
    			checkInDate:sPara.checkin_date,
    			checkOutDate:sPara.checkout_date,
    			price:sPara.price,
    			contactName:t,
    			contactPhone:a,
    			roomId:sPara.roomId,
    			channel: 0
    	}
    	
        $.ajax({
            type: "POST",
            url: window.g_base.apibase + "/order/createOrder",
            headers: {'Content-type': 'application/json;charset=UTF-8'},
            data: JSON.stringify(info),
            xhrFields: {
                withCredentials: !0
            },
            crossDomain: !0,
            dataType: "json",
            success: function(e) {
                'A00000' == e.status ? (alertMsg("提交成功"),
                $("#mask,.operate-tip").on("click tap", function() {
                    location.href = "/html/order/cardpay.html?order_id=" + e.orderId + "&price=" + sPara.price + "&lastpay=" + e.lastpay
                }),
                setTimeout(function() {
                    $("#mask").click(),
                    location.href = "/html/order/cardpay.html?order_id=" + e.orderId + "&price=" + sPara.price + "&lastpay=" + e.lastpay
                }, 1e3)) : alertMsg(e.msg)
            }
        })
    }
    setTimeout(function() {
        $("#mask").show(),
        $(e).hasClass("no-phone") ? $(".bind-phone").show() : $(".login-contain").show()
    }, 50)
})
