checkLogin(orderPayPage);

function orderPayPage(user) {
	if(user == null) {
		location.href = "/html/user/login.html?redirect=" + encodeURIComponent(window.location.href);
	} else {
		init(user);
	}
};

var sPara = parseQuery(window.location.search);

$.ajax({
    type: "GET",
    cache: !1,
    dataType: "json",
    data: {
        id: sPara.order_id
    },
    url: window.g_base.apibase + "/order/verifyOrderOvertime",//'/js/time.txt', //"/cgi/order/serve_time",
    success: function(t) {
    }
})

$(".pay-type.WX").attr("data-orderid",sPara.order_id);
var wxOpen = "http://open.weixin.qq.com/connect/oauth2/authorize?appid=wxdd005183eae96215&redirect_uri=http://1hf.bohosi.com/api/order/pay/wxpay?order_id=" + sPara.order_id + "&response_type=code&scope=snsapi_base#wechat_redirect";
	
$(".pay-type.WX").on("click",function(){window.location.assign(wxOpen)});
//$(".pay-type.WX").on("click", function(){pay();});
$(".pay-type.ZFB").attr("data-orderid",sPara.order_id);
$(".pay-type.ZFB").on("click",function(){window.location.assign("/api/order/pay/alipay?order_id=" +  sPara.order_id )});
$(".pay-type.UP").attr("data-orderid",sPara.order_id);
$(".pay-type.UP").on("click",function(){window.location.assign("/api/order/pay/unionpay?order_id=" +  sPara.order_id)});
$(".LastPayTime").attr("data-time", dateStr(new Date(parseFloat(sPara.lastpay))));
$(".payment").html("应付房费 &nbsp; &nbsp;<span class=\"payable\"><b>￥</b>" + sPara.price + "</span>&nbsp; &nbsp;");
var s;
if ($(".LastPayTime").length) {
    var s, c = new Date($(".LastPayTime").data("time").replace(/-/g, "/"));
    $.ajax({
        type: "GET",
        cache: !1,
        dataType: "json",
        url: window.g_base.apibase + "/commUtil/getUTC0SysTime",//'/js/time.txt', //"/cgi/order/serve_time",
        success: function(t) {
            s = (c - new Date(t.now)) / 1e3,
            e(),
            setInterval(function() {
                e()
            }, 1e3)
        }
    })
}

function e() {
    if (s--,
    s <= 0)
        return void $(".LastPayTime").text("00:00");
    var e = Math.floor(s / 60)
      , t = Math.floor(s - 60 * e);
    $(".LastPayTime").text(e + ":" + (t < 10 ? "0" + t : t))
}





