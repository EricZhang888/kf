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



function parseQuery(e) {
    for (var t = {},
    i = e.substr(1).split("&"), n = 0; n < i.length; n++) {
        var s = i[n].split("=");
        t[decodeURIComponent(s[0])] = decodeURIComponent(s[1] || "")
    }
    return t
}

var P = !0;	

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
//            	j.total_price = x,
//                j.room_count = k,
//                j.coupon_item_id_list = U,
//                j.contact_name = t,
//                j.contact_phone = a,
//                j.begin_date = j.checkin_date,
//                j.end_date = j.checkout_date,
//                j.platform = f ? 5 : 3,
//                j.channel = r.getCookie("CHANNEL_KEY") || "WAP",
//                j.is_book_blackgold = N
                
                if (!P) {
                	return;
                }
                return P = !1,
                void $.ajax({
                    type: "POST",
                    url: '/js/json.txt',//window.g_base.apibase + "/order/do_submit",
                    data: {},//JSON.stringify(j),
                    xhrFields: {
                        withCredentials: !0
                    },
                    crossDomain: !0,
                    dataType: "json",
                    success: function(e) {
                        P = !0,
                        0 == e.status ? (alertMsg("提交成功"),
                        $("#mask,.operate-tip").on("click tap", function() {
                            location.href = "/html/order/cardpay.html?order_id=11111"
                        }),
                        setTimeout(function() {
                            $("#mask").click(),
                            location.href = "/html/order/cardpay.html?order_id=123123"
                        }, 1e3)) : alertMsg(e.msg)
                    }
                })
            }
            setTimeout(function() {
                $("#mask").show(),
                $(e).hasClass("no-phone") ? $(".bind-phone").show() : $(".login-contain").show()
            }, 50)
        })