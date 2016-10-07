//价格日历具体天的html增加
	function price_day_table(e, t, a, s) {
            for (var o, r = $('<div class="calendar-body"><table><tbody></tbody></table></div>'), c = new Date(t,a,1,0,0,0), l = c.getDay() , p = i(t, a), m = c.getDate() - l, h = !0; h; ) {
                o = $('<tr class="days"></tr>');
                for (var g = 0; g < 7; g++) {
                    var u = []
                      , _ = ""
                      , f = ""
                      , v = ""
                      , y = ""
                      , b = ""
                      , w = t + "-" + (a + 1) + "-" + m
                      , x = !1;
                    isLast = !0,
                    isFull = !1,
                    1 === m ? u.push("first-day") : m === p && u.push("last-day"),
                    m <= 0 || m > p ? u.push("null") : (e[m - 1].is_full_booked && (u.push("norder"),
                    isFull = !0),
                    _ = 'data-day="' + w + '"',
                    f = 'data-time="' + m + '"',
                    v = 'data-status="' + (m > 0 ? e[m - 1].is_full_booked : "0") + '"',
                    y = "data-lowprice=" + e[m - 1].price,
                    b = "data-aifee=" + e[m - 1].is_preferential_price,
                    dataIsFavor = e[m - 1].is_preferential_price,
                    1 === dataIsFavor && u.push("isFavor"),
                    n(w) < s ? (u.push("disabled"),
                    isLast = !1) : +n(w) === +s && (u.push("today"),
                    x = !0)),
                    u = u.length > 0 ? 'class="' + u.join(" ") + '"' : "",
                    o.append("<td " + u + " " + v + " " + b + " " + y + " " + _ + " " + f + ">" + (m > p || m <= 0 ? "" : function() {
                        var t, i = e[m - 1].price, n = e[m - 1].is_preferential_price;
                        return t = isLast ? function() {
                            return e[m - 1].is_full_booked ? "<p>满房</p>" : function() {
                                return x ? "今天" : 1 === m ? a + 1 + "月" : m
                            }()
                        }() : 1 === m ? a + 1 + "月" : m,
                        isLast ? function() {
                            return e[m - 1].is_full_booked ? "<p>满房</p>" : function() {
                                return 1 == n ? "<p>" + t + "<span>￥" + i + "</span><i></i></p>" : "<p>" + t + "<span>￥" + i + "</span></p>"
                            }()
                        }() : "<section>" + t + "</section>"
                    }()) + "</td>"),
                    m++
                }
                $("tbody", r).append(o),
                h = m <= p
            }
            return r
        }

	
	function initPrice() {
		var e = this
        , t = e.currentDate
        , a = new Date(t.getFullYear(),t.getMonth(),1,0,0,0)
        , i = a.getFullYear()
        , s = a.getMonth()
        , r = []
        , l = [];
		
		for (var p = 0; p < 3; p++) {
			r[p] = i,
            l[p] = s,
            a.setMonth(s + 1),
            i = a.getFullYear(),
            s = a.getMonth();
		}
            
		$.ajax({
            type: "GET",
            url: window.g_base.apibase + "/room/getPriceCalendar",
            xhrFields: {
                withCredentials: !0
            },
            data: {
                id: e.roomId
//                begin_date: o(i, s - 3),
//                end_date: o(i, s),
//                platform: 3
            },
            dataType: "json",
            success: function(a) {
                if ('A00000' != a.status || !a.data || a.data.length <= 0)
                    return e.nextBtnOperate(1, "noclick", "请重新选择房型"),
                    "";
                var i = [];
                a.data.map(function(e) {
                    for (var t = n(e.date).getMonth(), a = 0; a < l.length; a++)
                        t == l[a] && (i[a] = Array.isArray(i[a]) ? i[a] : [],
                        i[a].push(e))
                });
                for (var s = 0; s < 3; s++)
                    $(".rpWrapper").append(price_day_table(i[s], r[s], l[s], new Date(t.getFullYear(),t.getMonth(),t.getDate())));
                for (var o in a.data) {
                    var p = a.data[o];
                    if (0 == p.is_full_booked) {
                        e.isAllFull = !1;
                        break
                    }
                }
                var m = $(".rpWrapper")
                  , h = $(".rpWrapper").offset().top
                  , g = $(".today").offset().top
                  , u = g - h;
                m.scrollTop(u);
                var _ = [];
                e.beginDate && e.endDate && ($(".rpWrapper").find("td").each(function() {
                    var t = $(this),
                    a = $(this).attr("data-day"),
                    i = !!$(this).hasClass("norder");
                    a && (n(a) - n(e.beginDate) === 0 && addSelected(t, "checkIn", i),
                    n(a) - n(e.endDate) === 0 && addSelected(t, "checkOut"),
                    n(a) - n(e.beginDate) >= 0 && n(a) - n(e.endDate) < 0 && _.push(i))
                }),
                selectRange()),
                $.inArray(!0, _) > -1 ? e.isAllFull ? nextBtnOperate(1, "noclick", "请重新选择房型") : nextBtnOperate(1, "noclick", "请重新选择日期") : done(),
                bindEvent()
            },
            error: function(e, t) {
                console.log("Ajax error!")
            }
        })
	}
	
	function i(e, t) {
        return new Date(e,t + 1,0).getDate()
    }
	
	function n(e) {
        return e = e.split("-"),
        new Date(e[0],e[1] - 1,e[2],0,0,0)
    }
	
	function s(e, t) {
        return n(e) > n(t)
    }

	
	function addSelected(e, t, a) {
        var i = this
        , n = ""
        , s = e.data("lowprice")
        , o = e.data("aifee");
      e.data("status");
      if (a)
          n = "满房";
      else {
          switch (t) {
          case "checkIn":
              n = "入住",
              n += "<span>￥" + s + "</span>";
              break;
          case "checkOut":
              n = "退房"
          }
          1 == o && (n += "<i></i>")
      }
      e.addClass("selected " + t).find("p").html(n),
      i[t] = e
  }
	
	function done() {
        var e = this
          , t = $(".checkIn").attr("data-day")
          , a = $(".checkOut").attr("data-day");
        $.ajax({
            type: "GET",
            url: 'js/priceD.txt',//window.g_base.apibase + "/order/calculate_total_price",
            xhrFields: {
                withCredentials: !0
            },
            data: {
//                room_type_id: e.room_type_id,
//                begin_date: t,
//                end_date: a,
//                platform: 3,
//                room_count: 1
            },
            dataType: "json",
            success: function(i) {
                nextBtnOperate(0, "noclick", "下一步"),
                i.data.total_price < i.data.total_basic_price ? $(".original-price").html('<span class="abs1">房费总额</span><span class="abs2">门市价&yen;' + i.data.total_basic_price + "</span>") : $(".original-price").html("房费总额"),
                $(".price span").text(i.data.total_price),
                $(".rpDetail").html(bookDetail(i.data.day_price_list, t, a)),
                $(".arrow").addClass("visible"),
                e.rpWrapperDown = $(".date-w", $(".rpDetail")),
                e.rpWrapperDown.on("click", function(t) {
                    $(".rpCalendar").removeClass("noHeight"),
                    $(".rpDetail").addClass("noHeight"),
                    $(".arrow").removeClass("down")
                })
            },
            error: function(e, t) {
                console.log("Ajax error!")
            }
        })
    }
	
	function nextBtnOperate(e, t, a) {
        var i = this;
        0 == e ? $(".next").removeClass(t).text(a) : $(".next").addClass(t).text(a)
    }
	
	function bookDetail(e, t, a) {
        var t = n(t)
          , a = n(a)
          , i = "";
        i += '<p class="date-w"><i class="icon-calendar"></i>' + (t.getMonth() + 1) + "月" + t.getDate() + "日 入住 -- " + (a.getMonth() + 1) + "月" + a.getDate() + '日 退房<span class="down"><i class="icon-left"></i></span></p>',
        i += '<p class="tit">预订明细</p>',
        i += "<ul>";
        for (var s = 0; s < e.length; s++) {
            var o = e[s];
            i += "<li>",
            i += '<div class="date">' + (n(o.date).getMonth() + 1) + "月" + n(o.date).getDate() + "日</div>",
            i += '<div class="price-w">',
            i += o.preferential_price && o.preferential_price != o.basic_price ? '<span class="line-thro">门市价&nbsp;&nbsp;&yen;' + o.basic_price + "</span>特价&nbsp;&nbsp;&yen;" + o.preferential_price : "<span>门市价&nbsp;&nbsp;&yen;" + o.basic_price + "</span>",
            i += "</div>",
            i += "<li>"
        }
        return i += "</ul>"
    }
	
	
	function bindEvent() {
        var e = this;
        e.isAllFull || $(".rpWrapper").on("click", "td", function(t) {
            var a = $(this);
            if (!a.hasClass("null") && !a.hasClass("disabled"))
                if ($(".checkIn").length  && !$(".checkOut").length) {
                    var i = $(".checkIn").attr("data-day")
                      , n = a.attr("data-day");
                    if (!s(n, i)) {
                        if (a.hasClass("norder"))
                            return;
                        return removeSelected("checkIn"),
                        addSelected(a, "checkIn"),
                        void resetPrice()
                    }
                    checkOutCondition(n, a)
                } else if ($(".checkIn").length && $(".checkOut").length) {
                    if (a.hasClass("norder"))
                        return;
                    removeSelected("checkIn"),
                    removeSelected("checkOut"),
                    removeRange(),
                    addSelected(a, "checkIn"),
                    resetPrice()
                } else if (!$(".checkIn").length && !$(".checkOut").length) {
                    if (a.hasClass("norder"))
                        return;
                    addSelected(a, "checkIn"),
                    resetPrice()
                }
        }),
        $(".next").on("click", function(t) {
            if ($(this).hasClass("noclick"))
                console.log("不可点击");
            else {
                console.log("下一步");
                var a = e.checkIn.attr("data-day")
                  , i = e.checkOut.attr("data-day")
                  , n = "html/order/orderForm.html?roomId=" + e.roomId + "&checkin_date=" + a + "&checkout_date=" + i + "&address=" + $("#address").text() + "&roomName=" + $(".flex-item .nowrap strong").text() + "&siteName=" + $(".flex-item .nowrap").text() + "&price=" + $(".fl.price span").text();
                window.location.href = n
                //e.isLogin ? window.location.href = n : window.location.href = "/home/login?redirectUrl=" + encodeURIComponent(n)
            }
        }),
        $(".arrow").on("click", function(t) {
            $(this).hasClass("down") ? ($(".rpCalendar").removeClass("noHeight"),
            $(".rpDetail").addClass("noHeight"),
            $(this).removeClass("down")) : ($(".rpCalendar").addClass("noHeight"),
            $(".rpDetail").removeClass("noHeight"),
            $(this).addClass("down"))
        })
    }
	
	function removeSelected(e) {
        var t = this;
        if (t[e]) {
            var a = t[e].attr("data-time")
              , i = t[e].attr("data-aifee");
            if (a) {
                var n = t[e].attr("data-lowprice");
                t[e].hasClass("norder") ? t[e].removeClass("selected " + e).find("p").html("满房") : t[e].hasClass("today") ? (t[e].removeClass("selected " + e).find("p").html("今天<span>￥" + n + "</span>"),
                1 == i && t[e].removeClass("selected " + e).find("p").html("今天<span>￥" + n + "</span><i></i>")) : (t[e].removeClass("selected " + e).find("p").html(a + "<span>￥" + n + "</span>"),
                1 == i && t[e].removeClass("selected " + e).find("p").html(a + "<span>￥" + n + "</span><i></i>")),
                t[e] = void 0
            }
        }
    }
	
	function selectRange(){
        for (var e, t, a = this, i = n($(".checkIn").attr("data-day")), s = n($(".checkOut").attr("data-day")), o = !0; o; )
            e = i.getFullYear() + "-" + (i.getMonth() + 1) + "-" + i.getDate(),
            t = $('[data-day="' + e + '"]'),
            t.addClass("range"),
            a.range.push(t),
            i.setDate(i.getDate() + 1),
            o = i <= s
    }
	
	function removeRange() {
        for (var e, t = this, a = t.range; a.length; )
            e = a.pop(),
            e.removeClass("range");
        $(".rpWrapper td").removeClass(".range")
    }
	
	function checkOutCondition(e, t) {
        for (var a, i, s = this, o = n(e), r = n($(".checkIn").attr("data-day")), c = !0, l = !0; c; ) {
            if (a = r.getFullYear() + "-" + (r.getMonth() + 1) + "-" + r.getDate(),
            i = $('[data-day="' + a + '"]', $(".rpWrapper")),
            i.hasClass("norder")) {
                l = !1;
                break
            }
            r.setDate(r.getDate() + 1),
            c = r < o
        }
        l ? (addSelected(t, "checkOut"),
        selectRange(),
        done()) : alert("选择日期期间包含不可预订日期，请重新选择")
    }
	
	function resetPrice() {
        var e = this;
        nextBtnOperate(1, "noclick", "下一步"),
        $(".price span").text("---"),
        $(".original-price").html("房费总额"),
        $(".arrow").removeClass("visible"),
        $(".rpTips").html("")
    }
/*
 * 
 * function p(e, t, a, i, s, o) { var c = this; new Date; c.section = d(m),
 * e.html(c.section), c.element = d(".rpWrapper", c.section), c.td = d("td",
 * c.element), c.currentDate = n(s), c.checkIn = void 0, c.checkOut = void 0,
 * c.room_type_id = t, c.beginDate = a ? a : r(1), c.endDate = i ? i : r(2),
 * c.nextBtn = d(".next", c.section), c.price = d(".price span", c.section),
 * c.originalPrice = d(".original-price", c.section), c.rpDetail =
 * d(".rpDetail", c.section), c.rpCalendar = d(".rpCalendar", c.section),
 * c.rpTips = d(".rp-tips", c.section), c.rpWrapperDown = void 0, c.isAllFull =
 * !0, c.isLogin = o, c.arrow = d(".arrow", c.section), c.range = [],
 * c.canCalculateFlag = !1, c.init() } var d = a(1) , m = (a(4), '<div
 * class="rp-box"><p class="rp-tips"></p><div class="rpCalendar"><h3>选择入住退房日期</h3><div
 * class="weeks"><table><thead><tr><th class="weekend">日</th><th>一</th><th>二</th><th>三</th><th>四</th><th>五</th><th class="weekend">六</th></tr></thead></table></div><div
 * class="rpWrapper"></div></div><div class="rpDetail noHeight"></div><div
 * class="price-wrap"><div class="fl original-price">房费总额</div><div class="fl
 * price">&yen;<span>---</span></div><div class="fl arrow"><i
 * class="icon-left"></i></div><button class="fr next">下一步</button></div></div>');
 * p.prototype.resetPrice = function() { var e = this; e.nextBtnOperate(1,
 * "noclick", "下一步"), e.price.text("---"), e.originalPrice.html("房费总额"),
 * e.arrow.removeClass("visible"), e.rpTips.html("") } , p.prototype.bindEvent =
 * function() { var e = this; e.isAllFull || e.element.on("click", "td",
 * function(t) { var a = d(this); if (!a.hasClass("null") &&
 * !a.hasClass("disabled")) if (e.checkIn && !e.checkOut) { var i =
 * e.checkIn.attr("data-day") , n = a.attr("data-day"); if (!s(n, i)) { if
 * (a.hasClass("norder")) return; return e.removeSelected("checkIn"),
 * e.addSelected(a, "checkIn"), void e.resetPrice() } e.checkOutCondition(n, a) }
 * else if (e.checkIn && e.checkOut) { if (a.hasClass("norder")) return;
 * e.removeSelected("checkIn"), e.removeSelected("checkOut"), e.removeRange(),
 * e.addSelected(a, "checkIn"), e.resetPrice() } else if (!e.checkIn &&
 * !e.checkOut) { if (a.hasClass("norder")) return; e.addSelected(a, "checkIn"),
 * e.resetPrice() } }), e.nextBtn.on("click", function(t) { if
 * (d(this).hasClass("noclick")) console.log("不可点击"); else { console.log("下一步");
 * var a = e.checkIn.attr("data-day") , i = e.checkOut.attr("data-day") , n =
 * "/order/orderform?room_type_id=" + e.room_type_id + "&checkin_date=" + a +
 * "&checkout_date=" + i; e.isLogin ? window.location.href = n :
 * window.location.href = "/home/login?redirectUrl=" + encodeURIComponent(n) }
 * }), e.arrow.on("click", function(t) { d(this).hasClass("down") ?
 * (e.rpCalendar.removeClass("noHeight"), e.rpDetail.addClass("noHeight"),
 * d(this).removeClass("down")) : (e.rpCalendar.addClass("noHeight"),
 * e.rpDetail.removeClass("noHeight"), d(this).addClass("down")) }) } ,
 * p.prototype.done = function() { var e = this , t = e.checkIn.attr("data-day") ,
 * a = e.checkOut.attr("data-day"); d.ajax({ type: "GET", url:
 * window.g_base.apibase + "/order/calculate_total_price", xhrFields: {
 * withCredentials: !0 }, data: { room_type_id: e.room_type_id, begin_date: t,
 * end_date: a, platform: 3, room_count: 1 }, dataType: "json", success:
 * function(i) { e.nextBtnOperate(0, "noclick", "下一步"), i.data.total_price <
 * i.data.total_basic_price ? e.originalPrice.html('<span class="abs1">房费总额</span><span
 * class="abs2">门市价&yen;' + i.data.total_basic_price + "</span>") :
 * e.originalPrice.html("房费总额"), e.price.text(i.data.total_price),
 * e.rpDetail.html(l(i.data.day_price_list, t, a)), e.arrow.addClass("visible"),
 * e.rpWrapperDown = d(".date-w", e.rpDetail), e.rpWrapperDown.on("click",
 * function(t) { e.rpCalendar.removeClass("noHeight"),
 * e.rpDetail.addClass("noHeight"), e.arrow.removeClass("down") }) }, error:
 * function(e, t) { console.log("Ajax error!") } }) } ,
 * p.prototype.checkOutCondition = function(e, t) { for (var a, i, s = this, o =
 * n(e), r = n(s.checkIn.attr("data-day")), c = !0, l = !0; c; ) { if (a =
 * r.getFullYear() + "-" + (r.getMonth() + 1) + "-" + r.getDate(), i =
 * d('[data-day="' + a + '"]', s.element), i.hasClass("norder")) { l = !1; break }
 * r.setDate(r.getDate() + 1), c = r < o } l ? (s.addSelected(t, "checkOut"),
 * s.selectRange(), s.done()) : alert("选择日期期间包含不可预订日期，请重新选择") } ,
 * p.prototype.nextBtnOperate = function(e, t, a) { var i = this; 0 == e ?
 * i.nextBtn.removeClass(t).text(a) : i.nextBtn.addClass(t).text(a) } ,
 * p.prototype.init = function() { var e = this , t = e.currentDate , a = new
 * Date(t.getFullYear(),t.getMonth(),1,0,0,0) , i = a.getFullYear() , s =
 * a.getMonth() , r = [] , l = []; e.element.empty(); for (var p = 0; p < 3;
 * p++) r[p] = i, l[p] = s, a.setMonth(s + 1), i = a.getFullYear(), s =
 * a.getMonth(); d.ajax({ type: "GET", url: window.g_base.apibase +
 * "/order/calculate_price_calendar", xhrFields: { withCredentials: !0 }, data: {
 * room_type_id: e.room_type_id, begin_date: o(i, s - 3), end_date: o(i, s),
 * platform: 3 }, dataType: "json", success: function(a) { if (0 != a.status ||
 * !a.data || a.data.length <= 0) return e.nextBtnOperate(1, "noclick",
 * "请重新选择房型"), ""; var i = []; a.data.map(function(e) { for (var t =
 * n(e.date).getMonth(), a = 0; a < l.length; a++) t == l[a] && (i[a] =
 * Array.isArray(i[a]) ? i[a] : [], i[a].push(e)) }); for (var s = 0; s < 3;
 * s++) e.element.append(c(i[s], r[s], l[s], t)); for (var o in a.data) { var p =
 * a.data[o]; if (0 == p.is_full_booked) { e.isAllFull = !1; break } } var m =
 * d(".rpWrapper") , h = d(".rpWrapper").offset().top , g =
 * d(".today").offset().top , u = g - h; m.scrollTop(u); var _ = []; e.beginDate &&
 * e.endDate && (e.element.find("td").each(function() { var t = d(this) , a =
 * t.attr("data-day") , i = !!t.hasClass("norder"); a && (n(a) - n(e.beginDate)
 * === 0 && e.addSelected(t, "checkIn", i), n(a) - n(e.endDate) === 0 &&
 * e.addSelected(t, "checkOut"), n(a) - n(e.beginDate) >= 0 && n(a) -
 * n(e.endDate) < 0 && _.push(i)) }), e.selectRange()), d.inArray(!0, _) > -1 ?
 * e.isAllFull ? e.nextBtnOperate(1, "noclick", "请重新选择房型") : e.nextBtnOperate(1,
 * "noclick", "请重新选择日期") : e.done(), e.bindEvent() }, error: function(e, t) {
 * console.log("Ajax error!") } }) } , p.prototype.addSelected = function(e, t,
 * a) { var i = this , n = "" , s = e.data("lowprice") , o = e.data("aifee");
 * e.data("status"); if (a) n = "满房"; else { switch (t) { case "checkIn": n =
 * "入住", n += "<span>￥" + s + "</span>"; break; case "checkOut": n = "退房" } 1 ==
 * o && (n += "<i></i>") } e.addClass("selected " + t).find("p").html(n), i[t] =
 * e } , p.prototype.removeSelected = function(e) { var t = this; if (t[e]) {
 * var a = t[e].attr("data-time") , i = t[e].attr("data-aifee"); if (a) { var n =
 * t[e].attr("data-lowprice"); t[e].hasClass("norder") ?
 * t[e].removeClass("selected " + e).find("p").html("满房") :
 * t[e].hasClass("today") ? (t[e].removeClass("selected " +
 * e).find("p").html("今天<span>￥" + n + "</span>"), 1 == i &&
 * t[e].removeClass("selected " + e).find("p").html("今天<span>￥" + n + "</span><i></i>")) :
 * (t[e].removeClass("selected " + e).find("p").html(a + "<span>￥" + n + "</span>"),
 * 1 == i && t[e].removeClass("selected " + e).find("p").html(a + "<span>￥" + n + "</span><i></i>")),
 * t[e] = void 0 } } } , p.prototype.selectRange = function() { for (var e, t, a =
 * this, i = n(a.checkIn.attr("data-day")), s = n(a.checkOut.attr("data-day")),
 * o = !0; o; ) e = i.getFullYear() + "-" + (i.getMonth() + 1) + "-" +
 * i.getDate(), t = d('[data-day="' + e + '"]'), t.addClass("range"),
 * a.range.push(t), i.setDate(i.getDate() + 1), o = i <= s } ,
 * p.prototype.removeRange = function() { for (var e, t = this, a = t.range;
 * a.length; ) e = a.pop(), e.removeClass("range"); t.td.removeClass(".range") }
 */