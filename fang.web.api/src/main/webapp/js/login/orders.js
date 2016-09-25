checkLogin(init);
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
                t = 3,
                location.hash = "#no-checkin";
                break;
            case 3:
                $(".order-type-contain .slide-chunk").addClass("no-remark"),
                $(".order-contain").addClass("no-remark"),
                t = 5,
                location.hash = "#no-remark";
            }
        });

"#no-pay" == location.hash && ($(".order-type-contain .slide-chunk").addClass("no-pay"),
        $(".order-contain").addClass("no-pay"),
        t = 1);
"#no-checkin" == location.hash && ($(".order-type-contain .slide-chunk").addClass("no-checkin"),
        $(".order-contain").addClass("no-checkin"),
        t = 3);
"#no-remark" == location.hash && ($(".order-type-contain .slide-chunk").addClass("no-remark"),
        $(".order-contain").addClass("no-remark"),
		t = 5);




/*webpackJsonp([10], [function(a, e, r) {
    var o = r(1);
    r(2),
    r(4);
    r(10)(function(a) {
        a.user_info.is_login || (location.href = "/home/login?redirectUrl=" + encodeURIComponent(location.href))
    }),
    $(function() {
        function a(a) {
            var e = $('<section class="order-piece"></section>')
              , r = '<p class="room-title">' + a.room_type_name + " &nbsp;&nbsp;<span>" + a.apartment_name + "</span></p>";
            r += '<a class="order-info" href="/order/orderdetail?order_id=' + a.order_id + '">',
            r += '<img class="room-img" src="' + a.image_url + '" alt="">',
            r += '<div class="detail-info">',
            r += '<p class="info-item checkin">入住 &nbsp;&nbsp;<span>' + a.begin_date + "</span></p><br>",
            r += '<p class="info-item checkout">退房 &nbsp;&nbsp;<span>' + a.end_date + "</span></p><br>";
            var n = "";
            switch (n += a.bedroom_count ? a.bedroom_count + "室" : "1室",
            n += a.sitting_room_count ? a.sitting_room_count + "厅" : "",
            n += a.kitchen_count ? a.kitchen_count + "厨" : "",
            n += a.bathroom_count ? a.bathroom_count + "卫" : "",
            r += '<p class="info-item roomtype-nu"><span class="type">' + n + '</span> &nbsp;&nbsp;共<span class="">' + a.room_count + "</span>套</p><br>",
            r += '<p class="info-item payment">订单总额 &nbsp;&nbsp;￥<span>' + a.pay_price + "</span></p>",
            r += '<i class="icon-right"></i>',
            a.user_display_status) {
            case 1:
                r += '<i class="icon-no-pay order-type"></i>',
                r += "</div>",
                r += "</a>",
                r += '<div class="operate operate-db">',
                r += '<span class="pay-time"><i class="icon-clock"></i>&nbsp;<i data-time="' + a.last_pay_seconds + '" class="LastPayTime"></i></span>',
                r += '<a class="now-pay" href="/order/orderpay?order_id=' + a.order_id + '">立即支付</a><a class="again-order" href="/apartment/detail?room_type_id=' + a.room_type_id + '">再次预订</a>';
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
                r += '<a class="remark-order" href="/order/orderdetail?order_id=' + a.order_id + '#remark">点评订单</a><a class="again-order" href="/Apartment/Detail?room_type_id=' + a.room_type_id + '">再次预订</a>';
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
        var e = $("#myorder")
          , n = r(11)
          , t = (new n(e),
        0)
          , s = ["all-order", "no-payment-order", "", "no-checkin-order", "", "no-remark-order"];
        $(".order-type-contain .order-type").on("click", function(a) {
            switch ($(".order-type-contain .slide-chunk").removeClass("all no-pay no-checkin no-remark"),
            $(".order-contain").removeClass("all no-pay no-checkin no-remark"),
            $(".order-type-contain .order-type").indexOf(a.target, 0)) {
            case 0:
                $(".order-type-contain .slide-chunk").addClass("all"),
                $(".order-contain").addClass("all"),
                t = 0,
                location.hash = "",
                dplus.track("页面浏览", {
                    "页面名称": "全部订单列表页"
                }),
                dplus.track("访问全部订单列表页");
                break;
            case 1:
                $(".order-type-contain .slide-chunk").addClass("no-pay"),
                $(".order-contain").addClass("no-pay"),
                t = 1,
                location.hash = "#no-pay",
                dplus.track("页面浏览", {
                    "页面名称": "待支付订单列表页"
                }),
                dplus.track("访问待支付订单列表页");
                break;
            case 2:
                $(".order-type-contain .slide-chunk").addClass("no-checkin"),
                $(".order-contain").addClass("no-checkin"),
                t = 3,
                location.hash = "#no-checkin",
                dplus.track("页面浏览", {
                    "页面名称": "待入住订单列表页"
                }),
                dplus.track("访问待入住订单列表页");
                break;
            case 3:
                $(".order-type-contain .slide-chunk").addClass("no-remark"),
                $(".order-contain").addClass("no-remark"),
                t = 5,
                location.hash = "#no-remark",
                dplus.track("页面浏览", {
                    "页面名称": "待点评订单列表页"
                }),
                dplus.track("访问待点评订单列表页")
            }
        }),
        "" == location.hash && (dplus.track("页面浏览", {
            "页面名称": "全部订单列表页"
        }),
        dplus.track("访问全部订单列表页")),
        "#no-pay" == location.hash && ($(".order-type-contain .slide-chunk").addClass("no-pay"),
        $(".order-contain").addClass("no-pay"),
        t = 1,
        dplus.track("页面浏览", {
            "页面名称": "待支付订单列表页"
        }),
        dplus.track("访问待支付订单列表页")),
        "#no-checkin" == location.hash && ($(".order-type-contain .slide-chunk").addClass("no-checkin"),
        $(".order-contain").addClass("no-checkin"),
        t = 3,
        dplus.track("页面浏览", {
            "页面名称": "待入住订单列表页"
        }),
        dplus.track("访问待入住订单列表页")),
        "#no-remark" == location.hash && ($(".order-type-contain .slide-chunk").addClass("no-remark"),
        $(".order-contain").addClass("no-remark"),
        t = 5,
        dplus.track("页面浏览", {
            "页面名称": "待点评订单列表页"
        }),
        dplus.track("访问待点评订单列表页"));
        var i = !0;
        s.map(function(e, r) {
            if ("" != e) {
                var n = r;
                o.ajax({
                    url: window.g_base.apibase + "/order/get_my_orders?key=" + Math.random(),
                    data: {
                        status: n,
                        page_index: 1,
                        page_size: 10
                    },
                    cache: !1,
                    dataType: "json",
                    xhrFields: {
                        withCredentials: !0
                    },
                    success: function(e) {
                        e.data.list.length < 10 && ($(".order-content." + s[n]).data("index", 0),
                        $(".order-content." + s[n]).find(".load").hide()),
                        e.data.list.length || $(".order-content." + s[n]).html('<p class="no-order-tip"><img src="/public/img/noorder.png">暂无该类型订单</p>'),
                        e.data.list.map(function(e) {
                            var r = a(e)
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
        }),
        $(".order-content").scroll(function(e) {
            var r = $(this)[0].scrollHeight
              , n = $(this)[0].scrollTop
              , d = $(e.target).height();
            n + d >= r - 5 && !function() {
                var e = t;
                0 != $(".order-content." + s[e]).data("index") && (i || (i = !0,
                o.get(window.g_base.apibase + "/order/get_my_orders", {
                    status: e,
                    page_index: $(".order-content." + s[e]).data("index") + 1,
                    page_size: 10
                }, function(r) {
                    return r.data.list.length ? (r.data.list.map(function(r) {
                        var n = a(r)
                          , t = $(".LastPayTime", n)
                          , i = $(t).data("time");
                        t.length && setInterval(function() {
                            if (i--,
                            i <= 0)
                                return void $(t).text("已过支付时间");
                            var a = Math.floor(i / 60)
                              , e = Math.floor(i - 60 * a);
                            $(t).text(a + ":" + (e < 10 ? "0" + e : e))
                        }, 1e3),
                        $(".order-content." + s[e] + ">div").append(n)
                    }),
                    $(".order-content." + s[e]).data("index", $(".order-content." + s[e]).data("index") + 1),
                    void (i = !1)) : ($(".order-content." + s[e]).data("index", 0),
                    void $(".order-content." + s[e]).find(".load").hide())
                })))
            }()
        })
    })
}
]);*/
