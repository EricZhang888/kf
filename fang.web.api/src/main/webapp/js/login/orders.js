checkLogin(init);

var s = ["all-order", "no-payment-order", "no-checkin-order", "", "", "", "no-remark-order"];
var e = $("#myorder");
$(document).ready(function(){
	s.map(function(e, n) {
		if("" != e) {
			$.ajax({
				type: "GET",
		        url: window.g_base.apibase + "/order/getOrdersByBooker?key=" + Math.random(),//"/js/myorders.json",//,
		        data: {
		            status: n,
		            number: 1,
		            size: 10
		        },
		        cache: !1,
		        dataType: "json",
		        xhrFields: {
		            withCredentials: !0
		        },
		        success: function(e) {
		            e.data.content.length < 10 && ($(".order-content." + s[n]).data("index", 0),
		            $(".order-content." + s[n]).find(".load").hide()),
		            e.data.content.length || $(".order-content." + s[n]).html('<p class="no-order-tip"><img src="/img/noorder.png">暂无该类型订单</p>'),
		            e.data.content.map(function(e) {
		                var r = genOrderHtml(e)
		                  , t = $(".LastPayTime", r)
		                  , i = $(t).data("time");
		                t.length && setInterval(function() {
		                    if (i--,
		                    i <= 0)
		                        return void $(t).text("已过支付时间");
		                    var a = Math.floor(i / 60)
		                      , e = Math.floor(i - 60 * a);
		                    $(t).text(a + ":" + (e < 10 ? "0" + e : e))
		                }, 1e3),
		                $(".order-content." + s[n] + ">div").append(r)
		            }),
		            i = !1
		        }
		    })
		}
	})
})

$(".order-type-contain .order-type").on("click", function(a) {
	$(".order-type-contain .slide-chunk").removeClass("all no-pay no-checkin no-remark");
    $(".order-contain").removeClass("all no-pay no-checkin no-remark");
    switch ($.inArray(a.target, $(".order-type-contain .order-type"))) {
    case 0:
        $(".order-type-contain .slide-chunk").addClass("all"),
        $(".order-contain").addClass("all"),
        t = 0,
        location.hash = "";
        break;
    case 1:
        $(".order-type-contain .slide-chunk").addClass("no-pay"),
        $(".order-contain").addClass("no-pay"),
        t = 1,
        location.hash = "#no-pay";
        break;
    case 2:
        $(".order-type-contain .slide-chunk").addClass("no-checkin"),
        $(".order-contain").addClass("no-checkin"),
        t = 2,
        location.hash = "#no-checkin";
        break;
    case 3:
        $(".order-type-contain .slide-chunk").addClass("no-remark"),
        $(".order-contain").addClass("no-remark"),
        t = 6,
        location.hash = "#no-remark";
    }
});

"#no-pay" == location.hash && ($(".order-type-contain .slide-chunk").addClass("no-pay"),
$(".order-contain").addClass("no-pay"),
t = 1);
"#no-checkin" == location.hash && ($(".order-type-contain .slide-chunk").addClass("no-checkin"),
$(".order-contain").addClass("no-checkin"),
t = 2);
"#no-remark" == location.hash && ($(".order-type-contain .slide-chunk").addClass("no-remark"),
$(".order-contain").addClass("no-remark"),
t = 6);


function genOrderHtml(a) {
    var e = $('<section class="order-piece"></section>')
      , r = '<p class="room-title">' + a.roomName + " &nbsp;&nbsp;<span>" + a.apartmentName + "</span></p>";
    r += '<a class="order-info" href="/html/order/orderDetail.html?order_id=' + a.id + '">',
    r += '<img class="room-img" src="/img/fang/' + a.roomId + '/' + a.roomImg + '" alt="">',
    r += '<div class="detail-info">',
    r += '<p class="info-item checkin">入住 &nbsp;&nbsp;<span>' + a.dateStart + "</span></p><br>",
    r += '<p class="info-item checkout">退房 &nbsp;&nbsp;<span>' + a.dateEnd + "</span></p><br>";
    var n = "";
    n += a.roomBedroomCount ? a.roomBedroomCount + "室" : "1室",
    	    n += a.roomSittingCount ? a.roomSittingCount + "厅" : "",
    	    n += a.roomKitchenCount ? a.roomKitchenCount + "厨" : "",
    	    n += a.roomBathroomCount ? a.roomBathroomCount + "卫" : "",
    	    r += '<p class="info-item roomtype-nu"><span class="type">' + n + '</span> &nbsp;&nbsp;</p><br>',
    	    r += '<p class="info-item payment">订单总额 &nbsp;&nbsp;￥<span>' + a.price + "</span></p>",
    	    r += '<i class="icon-right"></i>';
    switch (a.status) {
    case 1:
        r += '<i class="icon-no-pay order-type"></i>',
        r += "</div>",
        r += "</a>",
        r += '<div class="operate operate-db">',
        r += '<span class="pay-time"><i class="icon-clock"></i>&nbsp;<i data-time="' + a.lastPayTime + '" class="LastPayTime"></i></span>',
        r += '<a class="now-pay" href="/html/order/cardpay.html?order_id=' + a.id + '">立即支付</a><a class="again-order" href="/roomDetail.html?id=' + a.roomId + '">再次预订</a>';
        break;
    case 2:
        r += '<i class="icon-no-affirm order-type"></i>',
        r += "</div>",
        r += "</a>",
        r += '<div class="operate">';
        break;
    case 3:
        r += '<i class="icon-no-checkin order-type"></i>',
        r += "</div>",
        r += "</a>",
        r += '<div class="operate">';
        break;
    case 5:
        r += '<i class="icon-no-remark order-type"></i>',
        r += "</div>",
        r += "</a>",
        r += '<div class="operate operate-db">',
        r += '<a class="remark-order" href="/html/order/orderDetail.html?order_id=' + a.id + '#remark">点评订单</a><a class="again-order" href="/roomDetail.html?id=' + a.roomId + '">再次预订</a>';
        break;
    case 6:
        r += '<i class="icon-order-over order-type"></i>',
        r += "</div>",
        r += "</a>",
        r += '<div class="operate">';
        break;
    case 4:
        r += '<i class="icon-is-cancel order-type"></i>',
        r += "</div>",
        r += "</a>",
        r += '<div class="operate">'
    }
    return r += "</div>",
    e.append($(r))
}
