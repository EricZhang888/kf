checkLogin(ordersPage);
var sIndex =0;
var load = true;

function ordersPage(user) {
	if(user == null || user.isLogin === 0) {
		location.href = "/html/user/login.html?redirect=" + encodeURIComponent(window.location.href);
	} else {
		init(user);
	}
};

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
		            page: 0,
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
		                
		                $(".order-content." + s[n] + ">div").append(r)
		            }),
		            i = !1
		        }
		    })
		}
	})
},

$(".order-content").scroll(function(e) {
    var r = $(this)[0].scrollHeight, n = $(this)[0].scrollTop, d = $(e.target).height();
    var e = sIndex;
    //n + d >= r - 5
    if(n + d >= r - 5) {
    	if(0 != $(".order-content." + s[e]).attr("data-index") && load) {
    		load = false;
    		$.ajax({
				type: "GET",
		        url: window.g_base.apibase + "/order/getOrdersByBooker?key=" + Math.random(),//"/js/myorders.json",//,
		        data: {
		            status: e,
		            page: $(".order-content." + s[e]).attr("data-index"),
		            size: 10
		        },
		        cache: !1,
		        dataType: "json",
		        xhrFields: {
		            withCredentials: !0
		        },
		        success: function(r) {
		        	return r.data.content.length ? (r.data.content.map(function(r) {
    	                var n = genOrderHtml(r)
    	                  , t = $(".LastPayTime", n)
    	                  , i = $(t).data("time");
    	                $(".order-content." + s[e] + ">div").append(n)
    	            }),
    	            $(".order-content." + s[e]).data("index", $(".order-content." + s[e]).data("index") + 1),
    	            void (load = true)) : ($(".order-content." + s[e]).attr("data-index", 0),
    	            		void (load = true),
    	            void $(".order-content." + s[e]).find(".load").hide())
		        }
		    })
    	}
    }
})
)

$(".order-type-contain .order-type").on("click", function(a) {
	$(".order-type-contain .slide-chunk").removeClass("all no-pay no-checkin no-remark");
    $(".order-contain").removeClass("all no-pay no-checkin no-remark");
    switch ($.inArray(a.target, $(".order-type-contain .order-type"))) {
    case 0:
        $(".order-type-contain .slide-chunk").addClass("all");
        $(".order-contain").addClass("all");
        window.sIndex = 0;
        location.hash = "";
        break;
    case 1:
        $(".order-type-contain .slide-chunk").addClass("no-pay");
        $(".order-contain").addClass("no-pay");
        window.sIndex = 1;
        location.hash = "#no-pay";
        break;
    case 2:
        $(".order-type-contain .slide-chunk").addClass("no-checkin");
        $(".order-contain").addClass("no-checkin");
        window.sIndex = 2;
        location.hash = "#no-checkin";
        break;
    case 3:
        $(".order-type-contain .slide-chunk").addClass("no-remark")
        $(".order-contain").addClass("no-remark")
        window.sIndex = 6;
        location.hash = "#no-remark";
    }
});

"#no-pay" == location.hash && ($(".order-type-contain .slide-chunk").addClass("no-pay"),
$(".order-contain").addClass("no-pay"),window.sIndex = 1);

"#no-checkin" == location.hash && ($(".order-type-contain .slide-chunk").addClass("no-checkin"),
$(".order-contain").addClass("no-checkin"),window.sIndex = 2);

"#no-remark" == location.hash && ($(".order-type-contain .slide-chunk").addClass("no-remark"),
$(".order-contain").addClass("no-remark"),window.sIndex = 6);


function genOrderHtml(a) {
    var e = $('<section class="order-piece"></section>')
      , r = '<p class="room-title">' + a.roomName + " &nbsp;&nbsp;<span>" + a.apartmentName + "</span></p>";
    r += '<a class="order-info" href="/html/user/order/orderDetail.html?order_id=' + a.id + '">',
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
    switch (a.userDisplayStatus) {
    case 1:
        r += '<i class="icon-no-pay order-type"></i>',
        r += "</div>",
        r += "</a>",
        r += '<div class="operate operate-db">',
        r += '<span class="pay-time"><i data-time="' + dateStr(new Date(a.lastPayTime)) + '" class="LastPayTime"></i></span>',
        r += '<a class="now-pay" href="/html/user/orderpay/cardpay.html?order_id=' + a.id + '&price='+ a.price + '&lastpay='+ a.lastPayTime + '">立即支付</a><a class="again-order" href="/roomDetail.html?id=' + a.roomId + '">再次预订</a>';
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
        r += '<a class="remark-order" href="/html/user/order/orderDetail.html?order_id=' + a.id + '#remark">点评订单</a><a class="again-order" href="/roomDetail.html?id=' + a.roomId + '">再次预订</a>';
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
