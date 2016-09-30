//立即预定
$("#bookBtn").on(
		"tap click",
		function() {
			$(this).parent(".book").addClass("page-down"), I.show(), $(
					"#rp-calendar").removeClass("page-down"), B
					&& B instanceof D
					|| (B = new D($("#rp-calendar"), S.room_type_id,
							S.checkin_date, S.checkout_date, currentDate, w))
		})

/*
 * webpackJsonp([4], { 0: function(e, t, a) { a(2); var i = a(1) , n = a(13) , s =
 * a(4) , o = a(14); i(function() { function e() { var e, t =
 * o.parseQuery(window.location.search); for (e in t) t.hasOwnProperty(e) && e
 * in S && (S[e] = t[e]) } function t(e, t) { i.ajax({ type: "GET", url:
 * window.g_base.apibase + "/room_type/get_by_id?" + i.param(t), xhrFields: {
 * withCredentials: !0 }, success: function(t) { 0 == t.status ? (s.esLoaded(),
 * e.html(c(t.data)), v(t.data), b()) : window.location.href =
 * "/errors/404?msg=找不到房间&returnUrl=/" }, error: function(e, t) {
 * window.location.href = "/errors/404?msg=找不到房间&returnUrl=/" } }) } function
 * r() { var e = i("#img-box"); if (!(e.length <= 0)) { new n(e,{ initialSlide:
 * 0, loop: !0, onSlideChangeEnd: function(t) {
 * e.find(".curPage").text(+e.find(".swiper-slide-active").attr("data-swiper-slide-index") +
 * 1) }, onInit: function(t) { e.css({ height: document.body.clientWidth / 750 *
 * 420 + "px" }), e.find("li").css({ height: document.body.clientWidth / 750 *
 * 420 + "px" }) }, lazyLoading: !0 }) } } function c(e) { return l(e.images) +
 * p(e) + d(e) + m(e) + g(e) + u(e) } function l(e) { var t = ""; t += '<div
 * class="apartment-box">', t += '<div class="img-box" id="img-box">', t += '<ul class="swiper-wrapper">';
 * for (var a = 0; a < e.length; a++) t += '<li class="swiper-slide">', t += '<img
 * class="swiper-lazy"
 * src="http://webpic.estay.com/webui/images/wap/loading-replace.jpg"
 * data-src="' + e[a] + '">', t += "</li>"; return t += "</ul>", t += '<div
 * class="pages"><span class="curPage">1</span>/<span class="totalPage">' +
 * e.length + "</span></div>", t += "</div>", t += "</div>" } function p(e) {
 * var t = ""; if (t += '<div class="apartment-info">', t += '<div
 * class="flex-item">', t += '<p class="nowrap"><strong>' + e.room_type_name + "</strong><br/>" +
 * e.apartment_name + "</p>", t += '<p class="mr5">', e.bedroom_count > 0 &&
 * (t += e.bedroom_count + "室"), e.sitting_room_count > 0 && (t +=
 * e.sitting_room_count + "厅"), e.kitchen_count > 0 && (t += e.kitchen_count +
 * "厨"), e.bathroom_count > 0 && (t += e.bathroom_count + "卫"), t += e.min_area ==
 * e.max_area ? "<span>约" + e.min_area + '<i class="icon-square"></i></span>' : "<span>" +
 * e.min_area + "-" + e.max_area + '<i class="icon-square"></i></span>',
 * e.bed_types && e.bed_types.length > 0) { t += "<br/>", t += '<span
 * style="line-height: 2rem;font-size: 1.2rem;">' + e.bed_count + "床</span>";
 * for (var a = 0; a < e.bed_types.length; a++) (a + 1) % 3 == 0 && (t += "<br/>"),
 * t += '<span style="line-height: 2rem;font-size: 1.2rem;">(' +
 * e.bed_types[a].size + "&nbsp;" + e.bed_types[a].count + "张)</span>" } return
 * t += "</p>", t += "</div>", 0 != e.fully_booked_type.key ? t += '<div
 * class="price-box full-box">&yen;<strong>' + e.price + "</strong><br/><span>" +
 * e.fully_booked_type.value + "</span></div>" : (t += '<div
 * class="price-box">&yen;<strong>' + e.price + "</strong>", t +=
 * e.is_standard_price ? '<div class="ms-box"><p class="ori-name">门市价</p><p class="ori-price">&yen;' +
 * e.basic_price + "</p></div>" : '<div class="ori-box"><p class="ori-name">特价</p><p class="ori-price">&yen;' +
 * e.basic_price + "</p></div>", t += "</div>"), t += "</div>" } function
 * d(e) { var t = ""; t += '<div class="character">', t += "<h2>特色描述</h2>",
 * t += '<p class="shortDes tc">' + e.room_type_mini_desc + "</p>", t += "<ul>";
 * for (var a = 0; a < Math.min(e.room_type_tags.length, 3); a++) t += '<li><span
 * class="tag">' + e.room_type_tags[a].tag_name + "</span></li>"; for (var i =
 * 0; i < Math.min(e.apartment_tags.length, 6 -
 * Math.min(e.room_type_tags.length, 3)); i++) t += '<li><span class="tag">' +
 * e.apartment_tags[i].tag_name + "</span></li>"; return t += "</ul>",
 * e.intro ? (t += '<img src="' + e.intro.cover_image + '" />', t += '<p class="des">' +
 * e.intro.cover_desc + "</p>", t += '<p class="tc"><a href="' +
 * e.intro.desc_url + '" class="look-all-btn" id="findAllchar">查看全部</a></p>') :
 * t += e.room_type_desc ? e.room_type_desc : "", t += "</div>" } function m(e) {
 * var t = ""; t += '<div class="facilitiesAll">', t += "<h2>设施服务</h2>", t += '<ul class="fac-ul">';
 * for (var a = 0; a < Math.min(e.room_type_amenities.length, 10); a++) t += '<li><i
 * class="icon-' + e.room_type_amenities[a].icon + '"></i><span>' +
 * e.room_type_amenities[a].amenity_name + "</span></li>"; if
 * (Math.min(e.room_type_amenities.length, 10) < 10) for (var i = 0; i <
 * Math.min(e.apartment_amenities.length, 10 -
 * Math.min(e.room_type_amenities.length, 10)); i++) t += '<li><i
 * class="icon-' + e.apartment_amenities[i].icon + '"></i><span>' +
 * e.apartment_amenities[i].amenity_name + "</span></li>"; return t += "</ul>",
 * e.room_type_amenities.length + e.apartment_amenities.length > 10 && (t += '<p><span
 * class="look-all-btn" id="findAllFac">查看全部</span></p>'), t += "</div>" }
 * function h(e) { for (var t = "", a = 0; a < e.room_type_amenities.length;
 * a++) t += ' <li><i class="icon-' + e.room_type_amenities[a].icon + '"></i><span>' +
 * e.room_type_amenities[a].amenity_name + "</span></li>"; for (var n = 0; n <
 * e.apartment_amenities.length; n++) t += '<li><i class="icon-' +
 * e.apartment_amenities[n].icon + '"></i><span>' +
 * e.apartment_amenities[n].amenity_name + "</span></li>"; i("#all-fac
 * .fac-ul").html(t) } function g(e) { if (!e.first_comment) return ""; var t =
 * ""; t += '<div class="comment">', t += '<ul class="cNum">', t += "<li>",
 * t += '<span class="score">' + Math.floor(10 * e.comment_avg_score) / 10 + "</span>",
 * t += '<span class="name">评分</span>', t += "</li>", t += "<li>", t += '<span
 * class="score">' + e.comment_count + '</span><span class="name">点评数</span>',
 * t += "</li>", t += "</ul>", t += '<ul class="comment-list">', t += "<li>",
 * t += '<div class="head-info">', t += '<img src="' +
 * (e.first_comment.user_image ? e.first_comment.user_image :
 * "http://webpic.estay.com/webui/images/wap/head-img-replace.jpg") + '" alt="
 * ">', t += '<p class="nowrap">' + e.first_comment.user_name + "</p>", t += "</div>",
 * t += '<div class="comment-info">', t += '<p class="pscore">'; for (var a =
 * 0; a < 5; a++) t += e.first_comment.score > a ? '<span class="fl"><i
 * class="oran"></i></span>' : '<span class="fl"><i></i></span>'; if (t += '<span
 * class="fr">' + e.first_comment.create_time.substr(0, 4) + "年" +
 * e.first_comment.create_time.substr(5, 2) + "月" +
 * e.first_comment.create_time.substr(8, 2) + "日</span></p>", t += '<p class="tags">',
 * e.first_comment.comment_tag_list) for (var i = 0; i <
 * e.first_comment.comment_tag_list.length; i++) t += "<span>" +
 * e.first_comment.comment_tag_list[i].name + "</span>"; if (t += "</p>", t += '<p class="words">' +
 * e.first_comment.content + "</p>", e.first_comment.comment_image_url_list &&
 * e.first_comment.comment_image_url_list.length > 0) { t += '<p class="pic-list">';
 * for (var n = 0; n < e.first_comment.comment_image_url_list.length; n++) t += '<img
 * src="' + e.first_comment.comment_image_url_list[n] + '" alt="">'; t += "</p>" }
 * return t += "</div>", t += "</li>", e.comment_count > 1 && (t += '<p class="tc"><span
 * class="look-all-btn" id="findAllComments">查看全部</span></p>'), t += "</ul>",
 * t += "</div>" } function u(e) { var t = ""; return t += '<div
 * class="hotel-address" id="hotel-address">', t += '<div class="map-mask"></div>',
 * t += '<p class="address"><span id="address">' + e.address + "</span></p>",
 * t += '<div id="map_warp" class="clearfix"></div>', t += "</div>", t += '<div
 * class="hotel-address-reminder">', e.apartment_tips && (t += '<h2>温馨提示</h2><div
 * class="reminder">' + e.room_type_tips + "<br/>" + e.apartment_tips + "</div>"),
 * t += "</div>" } function _(e) { var t = e; i.ajax({ type: "POST", url:
 * window.g_base.apibase + "/room_type/get_list", xhrFields: { withCredentials:
 * !0 }, data: JSON.stringify({ apartment_id: e.apartment_id,
 * exclude_room_type_id: e.room_type_id, checkin_date: S.checkin_date,
 * checkout_date: S.checkout_date, page_index: 1, page_size: 4, show_small_img:
 * 1, show_test: S.show_test }), success: function(e) { 0 == e.status ?
 * (A.append(f(e.data.list)), y(t)) : console.log(e.msg) }, error: function(e,
 * t) {} }) } function f(e) { if (e.length <= 0) return ""; var t = ""; t += '<div
 * class="otherApartment">', t += "<h2>该公寓其他房型</h2>"; for (var a = 0; a <
 * Math.min(e.length, 3); a++) { var i = e[a] , n =
 * "/apartment/detail?room_type_id=" + i.room_type_id + "&apartment_id=" +
 * i.apartment_id + "&checkin_date=" + S.checkin_date + "&checkout_date=" +
 * S.checkout_date + "&longitude=" + (S.longitude ? S.longitude : "") +
 * "&latitude=" + (S.latitude ? S.latitude : "") + "&show_test=" + (S.show_test ?
 * S.show_test : ""); t += '<a class="apartment-box apartmentOtherRoom" href="' +
 * n + '">', t += '<div class="img-box">', t += '<img class="" src="' +
 * i.images[0] + '" alt="">', t += "</div>", t += '<div class="info">', t += '<p class="name nowrap"><span
 * class="r-name">' + i.room_type_name + "</span></p>", t += '<p class="facilities">' +
 * (i.bedroom_count ? i.bedroom_count + "室" : "") + (i.sitting_room_count ?
 * i.sitting_room_count + "厅" : "") + (i.kitchen_count ? i.kitchen_count + "厨" :
 * "") + "<i>|</i>约" + i.max_area + '<i class="icon-square"></i><i>|</i>' +
 * i.bed_count + "床</p>", 0 != i.fully_booked_type.key ? t += '<div
 * class="price-box full-box">&yen;<strong>' + i.price + "</strong><br/><span>" +
 * i.fully_booked_type.value + "</span></div>" : (t += '<div
 * class="price-box">&yen;<strong>' + i.price + "</strong>", t +=
 * i.is_standard_price ? '<div class="ms-box"><p class="ori-name">门市价</p><p class="ori-price">&yen;' +
 * i.basic_price + "</p></div>" : '<div class="ori-box"><p class="ori-name">特价</p><p class="ori-price">&yen;' +
 * i.basic_price + "</p></div>", t += "</div>"), t += "</div>", t += "</a>" }
 * return e.length > 3 && (t += '<p class="tc"><span class="look-all-btn"
 * id="findAllApartment">查看全部</span></p>'), t += "</div>" } function v(e) {
 * r(), _(e), h(e), 0 != e.fully_booked_type.key && "今日满房" ==
 * e.fully_booked_type.value && i("#bookBtn").text("预订其他日期"); var t =
 * i(".pic-wrap"); i(".pic-list").on("click tap", "img", function() { var e =
 * i(this) , a = e.index() , s = e.parent(".pic-list").find("img"); t.empty();
 * for (var o = '<div class="pic-box" id="picBox"><div
 * class="swiper-wrapper">', r = 0; r < s.length; r++) o += '<div
 * class="swiper-slide"><img src="' + s[r].src + '"></div>'; o += "</div>", o += "</div>",
 * o += '<div class="pages"><span class="curPage">1</span>/<span
 * class="totalPage">' + s.length + "</span></div>", t.html(o).show(); var c =
 * i("#picBox"); new n(c,{ pagination: ".swiper-pagination",
 * paginationClickable: !0, initialSlide: a, onSlideChangeEnd: function(e) {
 * c.next(".pages").find(".curPage").text(e.activeIndex + 1) }, onInit:
 * function(e) { var t = c.height() , a = i(window).height(); c.css({
 * "margin-top": (a - t) / 2 + "px" }), c.find("img").each(function(e) {
 * i(this).css({ "margin-top": (t - i(this).height()) / 2 + "px" }) }) } }) }),
 * t.on("click", function() { i(this).hide() }), e.contact_telephone &&
 * i(".phone").attr({ href: "tel:" + e.contact_telephone }); var s, o = a(15);
 * i("#findAllComments").length > 0 && i("#findAllComments").on("click tap",
 * function() { s && s instanceof o ? s.show() : (s = new o(C,k,S.room_type_id),
 * s.show()) }); var c = e.map_type , l = e.longitude , p = e.latitude , d =
 * e.address , m = e.apartment_name , g = a(17) , u = new g(C,k,c,p,l,d,m) , f =
 * document.getElementById("map_warp") , v = window.devicePixelRatio || 1 , y =
 * f.clientWidth , b = f.clientHeight , w = new Image; w.style.width = "100%",
 * w.style.height = "100%", f.innerHtml = "", 1 === +c ? w.src =
 * "http://api.map.baidu.com/staticimage/v2?ak=Kkh5WXsSFsCjV4HvZC7KZ0Ri&mcode=666666&center=" +
 * l + "," + p + "&width=" + y + "&height=" + b + "&zoom=13&markers=" + l + "," +
 * p + "&scale=2" : w.src =
 * "http://maps.google.cn/maps/api/staticmap?key=AIzaSyCzb_NdSvehHpAglVn1S-dozKvdAGXHAl0&center=" +
 * p + "," + l + "&zoom=13&size=" + y + "x" + b + "&scale=" + v +
 * "&maptype=roadmap?&markers=color:blue|label:S|" + p + "," + l +
 * "&language=zh-CN", f.appendChild(w), i("#hotel-address").on("click tap",
 * function() { u.show() }), i("#findAllFac").on("click tap", function() {
 * I.show(), i("#all-fac").show() }), i("#all-fac .close").on("click tap",
 * function() { I.hide(), i("#all-fac").hide() }), I.on("click tap", function() {
 * i(this).hide(), i("#all-fac").hide(), i(".book").removeClass("page-down"),
 * i("#rp-calendar").addClass("page-down") }) } function y(e) { var t, n =
 * a(18); i("#findAllApartment").length > 0 && i("#findAllApartment").on("click
 * tap", function() { t && t instanceof n ? t.show() : (t = new n(C,k,{
 * apartment_id: e.apartment_id, exclude_room_type_id: e.room_type_id,
 * checkin_date: S.checkin_date, checkout_date: S.checkout_date, longitude:
 * S.longitude, latitude: S.latitude, page_index: 1, page_size: 1e3, show_test:
 * S.show_test }), t.show()) }) } function b() { dplus.track("页面浏览", { "页面名称":
 * "公寓详情页", "房间名称": i(".flex-item .nowrap").html().replace("<strong>",
 * "").replace("</strong>", "") }), dplus.track("访问公寓详情页", { "房间名称":
 * i(".flex-item .nowrap").html().replace("<strong>", "").replace("</strong>",
 * "") }), i("#findAllComments").on("tap", function() { dplus.track("点击查看全部评论")
 * }), i("#findAllchar").on("tap", function() { dplus.track("点击查看全部特色描述") }),
 * i("#findAllFac").on("tap", function() { dplus.track("点击查看全部设施") }),
 * i("#findAllComments").on("tap", function() { dplus.track("点击查看全部评论") }),
 * i("#hotel-address").on("tap", function() { dplus.track("点击查看地图") }),
 * i("#findAllApartment").on("tap", function() { dplus.track("点击查看全部该公寓其他房型") }) }
 * var w, x = a(10); x(function(e) { w = e.user_info.is_login }), s.esLoading();
 * var k = i(".detail") , C = i(".components") , A = i(".es_content_relative") ,
 * I = i("#mask") , S = { room_type_id: "", checkin_date:
 * document.getElementById("startDate").value, checkout_date:
 * document.getElementById("endDate").value, latitude: "", longitude: "",
 * show_test: "" }; e(), !S.room_type_id && s.getQueryString("roomId") &&
 * (S.room_type_id = s.getQueryString("roomId")), t(A, S), i(".left-icon",
 * k).on("tap click", function(e) { document.referrer.length > 1 ?
 * history.back() : window.location.href = "/" }); var B, D = a(19);
 * i("#bookBtn").on("tap click", function() {
 * i(this).parent(".book").addClass("page-down"), I.show(),
 * i("#rp-calendar").removeClass("page-down"), B && B instanceof D || (B = new
 * D(i("#rp-calendar"),S.room_type_id,S.checkin_date,S.checkout_date,currentDate,w)) }) }) },
 * 15: function(e, t, a) { function i(e) { var t = e.comment_list_output , a =
 * ""; if (t) { a += '<div class="comment-list">'; for (var i in t) { var n =
 * t[i]; a += "<li>", a += '<div class="head-info">', a += '<img src="' +
 * (n.user_image ? n.user_image :
 * "http://webpic.estay.com/webui/images/wap/head-img-replace.jpg") + '">', a += '<p class="nowrap">' +
 * n.user_name + "</p>", a += "</div>", a += '<div class="comment-info">', a += '<p class="pscore">';
 * for (var s = 0; s < 5; s++) a += n.score > s ? '<span class="fl"><i
 * class="oran"></i></span>' : '<span class="fl"><i></i></span>'; if (a += '<span
 * class="fr">' + n.create_time.substr(0, 4) + "年" + n.create_time.substr(5, 2) +
 * "月" + n.create_time.substr(8, 2) + "日</span></p>", n.comment_tag_list &&
 * n.comment_tag_list.length > 1) { a += '<p class="tags">'; for (var i = 0; i <
 * n.comment_tag_list.length; i++) a += "<span>" + n.comment_tag_list[i].name + "</span>";
 * a += "</p>" } if (a += '<p class="words">' + n.content + "</p>",
 * n.comment_image_url_list && n.comment_image_url_list.length > 0) { var o =
 * n.comment_image_url_list; a += '<div class="pic-list">'; for (m in o) a += '<img
 * src="' + o[m] + '" alt="">'; a += "</div>" } n.is_reply && (a += '<div
 * class="reply" style="border-top: 1px solid #eee"><span>一呆回复：</span>' +
 * n.reply_content + "</div>"), a += "</div>", a += "</li>" } a += "</div>" }
 * return a } function n(e, t, a) { var i = this; i.section = s(c),
 * e.append(i.section), i.panel = t, i.esContent = s(".es_content", i.section),
 * i.commentBox = s(".comment-box", i.section), i.back = s(".left-icon",
 * i.section), i.picWrap = s(".pic-wrap", i.section), i.loadingGif =
 * s(".loading_gif", i.section), i.room_type_id = a, i.commentsInfo = {
 * room_type_id: a, page_index: 1, page_size: 10, isStopped: !1 },
 * i.commentScroll = new o("#es_content_comment",{ tap: !0, click: !0, scrollY:
 * !0 }), i.isAjaxLoading = !1, i.bindEvent(), i.init() } var s = a(1) , o =
 * (a(4), a(16)) , r = a(13) , c = '<section class="es_flow es-comment"><div
 * class="es_header"><i class="left-icon icon-left"></i><div class="title">评价</div></div><div
 * class="es_content" id="es_content_comment"><div class="wrap"><div
 * class="comment-box"></div><div style="text-align: center; padding-bottom:
 * 10px;visibility:hidden;" class="loading_gif"><img style="margin:0 auto"
 * src="http://webpic.estay.com/webui/images/wap/loading.gif" width="32"><p>正在加载中</p></div></div></div><div
 * class="pic-wrap"></div></section>'; n.prototype.bindEvent = function() {
 * var e = this; e.back.on("click", function(t) { e.hide() }),
 * e.esContent.on("click tap", ".pic-list img", function() { var t = s(this) , a =
 * t.index() , i = t.parent(".pic-list").find("img") , n = '<div
 * class="pic-box" id="pic-box"><div class="swiper-wrapper">';
 * e.picWrap.empty(); for (var o = 0; o < i.length; o++) n += '<div
 * class="swiper-slide"><img src="' + i[o].src + '"></div>'; n += "</div>", n += "</div>",
 * n += '<div class="pages"><span class="curPage">1</span>/<span
 * class="totalPage">' + i.length + "</span></div>", e.picWrap.html(n).show();
 * var c = s(".pic-box"); new r("#pic-box",{ pagination: ".swiper-pagination",
 * paginationClickable: !0, initialSlide: a, onSlideChangeEnd: function(e) {
 * c.next(".pages").find(".curPage").text(e.activeIndex + 1) }, onInit:
 * function(e) { var t = c.height() , a = s(window).height(); c.css({
 * "margin-top": (a - t) / 2 + "px" }), c.find("img").each(function(e) {
 * s(this).css({ "margin-top": (t - s(this).height()) / 2 + "px" }) }) } }) }),
 * e.picWrap.on("click", function() { s(this).hide() }); var t = e.commentsInfo ,
 * a = (e.esContent.scrollTop(), e); e.commentScroll.on("scrollEnd", function() {
 * this.y == this.maxScrollY && (t.isStopped || (e.loadingGif.css("visibility",
 * "visible"), t.isStopped = !0, this.maxScrollY = this.maxScrollY,
 * a.loadCommentList(t))) }) } , n.prototype.init = function() { function e(e) {
 * a.isAjaxLoading = !1, 0 == e.status && (e.data.list.comment_list_output &&
 * e.data.list.comment_list_output.length > 0 ?
 * (a.commentBox.append(i(e.data.list)), a.commentBox.scrollTop(0), 1 ==
 * a.commentsInfo.page_index && e.data.list.comment_list_output.length <
 * a.commentsInfo.page_size ? (a.commentBox.append('<li style="text-align: center;">暂时没有更多评价</li>'),
 * a.commentsInfo.isStopped = !0) : (a.commentsInfo.page_index =
 * a.commentsInfo.page_index - 0 + 1, a.commentsInfo.isStopped = !1)) :
 * (a.commentBox.append('<li style="text-align: center;">很抱歉，暂时没有搜索结果</li>'),
 * a.commentsInfo.isStopped = !0), a.loadingGif.css("visibility", "hidden"),
 * a.commentScroll.refresh()) } function t(e) { a.isAjaxLoading = !1,
 * a.commentsInfo.isStopped = !1, a.loadingGif.css("visibility", "hidden"), s &&
 * s.length > 0 || a.commentBox.append('<li class="error" style="text-align: center;">网速不给力啊，重新加载试试吧！</li>') }
 * var a = this; a.commentBox.empty(), a.loadingGif.css("visibility",
 * "visible"), a.commentsInfo.isStopped = !0, a.commentsInfo.page_index = 1; var
 * n = a.commentsInfo , s = a.commentBox.find(".error"); s.remove(),
 * a.commentsListInfoRequest(n, e, t) } , n.prototype.loadCommentList =
 * function(e) { function t(e) { n.isAjaxLoading = !1, 0 == e.status &&
 * (r.remove(), e.data.list.comment_list_output &&
 * e.data.list.comment_list_output.length > 0 ? (n.commentsInfo.page_index =
 * n.commentsInfo.page_index - 0 + 1, n.commentBox.append(i(e.data.list)),
 * n.commentsInfo.isStopped = !1) : (n.commentBox.append('<li style="text-align: center;">暂时没有更多评价</li>'),
 * n.commentsInfo.isStopped = !0), n.commentScroll.refresh(),
 * n.loadingGif.css("visibility", "hidden")) } function a(e) { n.isAjaxLoading =
 * !1, n.commentsInfo.isStopped = !1, n.loadingGif.css("visibility", "hidden"),
 * r && r.length > 0 || n.commentBox.append('<li class="error" style="text-align: center;">网速不给力啊，重新加载试试吧！</li>') }
 * var n = this; s(".no_more").remove(); var o = e; n.commentsInfo = e; var r =
 * n.commentBox.find(".error"); n.commentsListInfoRequest(o, t, a) } ,
 * n.prototype.commentsListInfoRequest = function(e, t, a) { var i = this;
 * i.isAjaxLoading || (i.isAjaxLoading = !0, s.ajax({ type: "GET", url:
 * window.g_base.apibase + "/comment/find_comment_paging", xhrFields: {
 * withCredentials: !0 }, data: e, cache: !1, timeout: 1e4, dataType: "json",
 * success: t, error: a })) } , n.prototype.show = function() { var e = this;
 * e.section.show().parent(".components").removeClass("page-right
 * page-left").addClass("page-in") } , n.prototype.hide = function() { var e =
 * this;
 * e.section.parent(".components").removeClass("page-in").addClass("page-right"),
 * setTimeout(function() { e.section.hide() }, 300) } , e.exports = n }, 17:
 * function(e, t, a) { function i(e, t, a, i, s, r, c) { var l = this; l.section =
 * n(o), e.append(l.section), l.panel = t, l.esContent = n(".es_content",
 * l.section), l.back = n(".left-icon", l.section), l.infoBox = n(".infoBox",
 * l.section), l.address = r, l.apartmentName = c, l.type = a, l.lat = i, l.lng =
 * s, l.init(), l.bindEvent() } var n = a(1) , s = a(12) , o = '<section
 * class="es_flow es-map"><div class="es_header"><i class="left-icon
 * icon-left"></i><div class="title" style="font-size:19px">公寓地图</div></div><div
 * class="es_content"><div id="map_wrap" class="clearfix"
 * style="position:absolute;top: 0;right: 0;bottom:60px;left: 0;"></div><div
 * class="infoBox"
 * style="position:absolute;left:3%;right:3%;bottom:0px;height:55px;display:-webkit-box;display:-webkit-flex;display:flex;"></div></div></section>';
 * i.prototype.bindEvent = function() { var e = this; e.back.on("click",
 * function(t) { e.hide() }) } , i.prototype.init = function() { var e = this;
 * if (e.infoBox.html('<div style="-webkit-box-flex:1;-webkit-flex:1;flex:1;"><p class="nowrap" style="color:#3E3A39;font-size:14px;">' +
 * e.apartmentName + '</p><p style="color:#008AE4;font-size:12px;max-height:33px;overflow:hidden;"><i
 * class="icon-location-hollow" style="position:relative;top:2px;"></i>' +
 * e.address + '</p></div><a id="navigationBtn"
 * style="display:block;width:86px;height:36px;line-height:36px;border:1px solid
 * #008AE4;color:#008AE4;text-align:center;border-radius:6px;margin-top:8px;margin-left:10px;"
 * >导航</a>'), 1 === +e.type) { var t = new BMap.Map("map_wrap") , a = new
 * BMap.Point((+e.lng),(+e.lat)) , i = new BMap.Marker(a); t.centerAndZoom(a,
 * 15), t.addOverlay(i), n("#navigationBtn").live("click tap", function() {
 * s.getCurPostion(function(t) { t && (window.location.href =
 * "http://api.map.baidu.com/direction?origin=latlng:" + t.coords.latitude + "," +
 * t.coords.longitude + "|name:我的位置&destination=latlng:" + e.lat + "," + e.lng +
 * "|name:" + e.apartmentName + "&mode=driving&region=广州&output=html") }, !0) }) }
 * else { var o = { lat: +e.lat, lng: +e.lng } , r = new
 * google.maps.Map(document.getElementById("map_wrap"),{ zoom: 14, center: o });
 * new google.maps.Marker({ position: o, map: r });
 * n("#navigationBtn").live("click tap", function() {
 * s.getCurPostion(function(t) { t && (window.location.href =
 * "http://maps.google.cn/maps?&key=AIzaSyCzb_NdSvehHpAglVn1S-dozKvdAGXHAl0&q=" +
 * e.address + "&origin=" + t.coords.latitude + "," + t.coords.longitude +
 * "&destination=" + e.lat + "," + e.lng) }, !0) }) } } , i.prototype.show =
 * function() { var e = this;
 * e.section.show().parent(".components").removeClass("page-right
 * page-left").addClass("page-in") } , i.prototype.hide = function() { var e =
 * this;
 * e.section.parent(".components").removeClass("page-in").addClass("page-right"),
 * setTimeout(function() { e.section.hide() }, 300) } , e.exports = i }, 18:
 * function(e, t, a) { function i(e) { if (e && !(e.length <= 0)) for (var t in
 * e) { var a = e[t] , i = (document.body.clientWidth / 750 * 420, o("#imgBox" +
 * a.room_type_id)); (function(e) { new c(e,{ initialSlide: 0, touchAngle: 30,
 * threshold: 10, loop: !0, touchMoveStopPropagation: !1, onSlideChangeEnd:
 * function(t) {
 * e.find(".curPage").text(+e.find(".swiper-slide-active").attr("data-swiper-slide-index") +
 * 1) }, lazyLoading: !0 }) } ).bind(this, i)() } } function n(e, t) { var a =
 * document.body.clientWidth / 750 * 420 , i = ""; if (!e || e.length <= 0)
 * return ""; for (var n = 0; n < e.length; n++) { var s = e[n] , o =
 * "/apartment/detail?room_type_id=" + s.room_type_id + "&apartment_id=" +
 * s.apartment_id + "&checkin_date=" + t.checkin_date + "&checkout_date=" +
 * t.checkout_date + "&longitude=" + (t.longitude ? t.longitude : "") +
 * "&latitude=" + (t.latitude ? t.latitude : "") + "&show_test=" + (t.show_test ?
 * t.show_test : ""); i += '<a class="apartment-box" href="' + o + '">', i += '<div
 * class="img-box" id="imgBox' + s.room_type_id + '" style="height:' + a + 'px"
 * >', i += '<ul class="swiper-wrapper">'; for (var r = 0; r <
 * s.images.length; r++) i += '<li class="swiper-slide">', i += '<img
 * class="swiper-lazy"
 * src="http://webpic.estay.com/webui/images/wap/loading-replace.jpg"
 * data-src="' + s.images[r] + '" alt="">', i += '<div class="pages"><span
 * class="curPage">1</span>/<span class="totalPage">' + s.images.length + "</span></div>",
 * i += "</li>"; i += "</ul>", i += '<span class="tag t4">' +
 * s.apartment_name + "</span>", s.distance && (i += '<span class="tag t3"><i
 * class="icon-location-hollow"></i>距您' + (Math.floor(s.distance) >= 1 ?
 * Math.round(s.distance) + "km" : 1e3 * s.distance.toFixed(3) + "m") + "</span>"),
 * i += "</div>", i += '<div class="info">', i += '<p class="name nowrap"><span
 * class="r-name">' + s.room_type_name + "</span>&nbsp&nbsp</i>" +
 * s.apartment_name + "</p>", i += '<p class="facilities">' +
 * (s.bedroom_count ? s.bedroom_count + "室" : "") + (s.sitting_room_count ?
 * s.sitting_room_count + "厅" : "") + "<i>|</i>约" + s.max_area + '<i
 * class="icon-square"></i><i>|</i>' + s.bed_count + "床" +
 * (s.comment_avg_score > 0 ? '<i>|</i><span class="color-orange">' +
 * Math.floor(10 * s.comment_avg_score) / 10 + "分</span>" : "") + "</p>", 0 !=
 * s.fully_booked_type.key ? i += '<div class="price-box full-box">&yen;<strong>' +
 * s.price + "</strong><br/><span>" + s.fully_booked_type.value + "</span></div>" :
 * (i += '<div class="price-box">&yen;<strong>' + s.price + "</strong>", i +=
 * s.is_standard_price ? '<div class="ms-box"><p class="ori-name">门市价</p><p class="ori-price">&yen;' +
 * s.basic_price + "</p></div>" : '<div class="ori-box"><p class="ori-name">特价</p><p class="ori-price">&yen;' +
 * s.basic_price + "</p></div>", i += "</div>"), i += "</div>", i += "</a>" }
 * return i } function s(e, t, a) { var i = this; i.section = o(l),
 * e.append(i.section), i.panel = t, i.esContent = o(".es_content", i.section),
 * i.otherApartmentBox = o(".otherApartment-box", i.section), i.back =
 * o(".left-icon", i.section), i.urlInfo = a, i.apartmentScroll = new
 * r("#es_content_apartment",{ tap: !0, click: !0, scrollY: !0, deceleration:
 * .002 }), i.bindEvent(), i.init() } var o = a(1) , r = (a(4), a(16)) , c =
 * a(13) , l = '<section class="es_flow es-comment"><div class="es_header"><i
 * class="left-icon icon-left"></i><div class="title">该公寓其他房型</div></div><div
 * class="es_content" id="es_content_apartment"><div
 * class="otherApartment-box"></div></div></section>'; s.prototype.bindEvent =
 * function() { var e = this; e.back.on("click", function(t) { e.hide() }) } ,
 * s.prototype.init = function() { function e(e) { var t = o(n(e.data.list,
 * a.urlInfo)); t.map(function(e, t) { o(t).on("click tap", function() {
 * location.href = o(t).attr("href") }) }), a.otherApartmentBox.html(t),
 * a.otherApartmentBox.lazyloading(), i(e.data.list),
 * a.apartmentScroll.refresh() } function t() { errorElement &&
 * errorElement.length > 0 || otherApartmentBox.append('<li style="list-style:none;text-align:center;margin-top:10px;color:#B4B4B5;"><img
 * src="http://webpic.estay.com/webui/images/wap/network.png"
 * style="width:44%;max-width:150px;margin:30px auto;"><p style="margin-bottom:20px;">网速不给力,请点击重新加载试试</p><p><span
 * style="display:inline-block;border:1px solid #008AE4;padding:4px
 * 20px;color:#008AE4;border-radius:5px;font-size:14px;"
 * onclick="javascript:window.location.reload();">重新加载</span></p></li>') }
 * var a = this; a.otherApartmentBox.html('<div
 * style="text-align:center;padding-top:30px;" class="loading_gif"><img
 * style="margin:0 auto;width:32px;"
 * src="http://webpic.estay.com/webui/images/wap/loading.gif" width="32"><p>正在加载中</p></div>'),
 * o.ajax({ type: "POST", dataType: "json", xhrFields: { withCredentials: !0 },
 * url: window.g_base.apibase + "/room_type/get_list", data:
 * JSON.stringify(a.urlInfo), cache: !1, timeout: 1e4, error: t, success: e }) } ,
 * s.prototype.show = function() { var e = this;
 * e.section.show().parent(".components").removeClass("page-right
 * page-left").addClass("page-in") } , s.prototype.hide = function() { var e =
 * this;
 * e.section.parent(".components").removeClass("page-in").addClass("page-right"),
 * setTimeout(function() { e.section.hide() }, 300) } , e.exports = s }, 19:
 * function(e, t, a) { function i(e, t) { return new Date(e,t + 1,0).getDate() }
 * function n(e) { return e = e.split("-"), new Date(e[0],e[1] - 1,e[2],0,0,0) }
 * function s(e, t) { return n(e) > n(t) } function o(e, t) { var a = new
 * Date(e,t,1) , i = a.getFullYear() , n = a.getMonth() + 1 , s = a.getDate();
 * return i + "-" + n + "-" + s } function r(e) { var t = new Date;
 * t.setTime((new Date).getTime() + 24 * e * 60 * 60 * 1e3); var a =
 * t.getFullYear() , i = t.getMonth() + 1 , n = t.getDate(); return a + "-" + i +
 * "-" + n } function c(e, t, a, s) { for (var o, r = d('<div
 * class="calendar-body"><table><tbody></tbody></table></div>'), c = new
 * Date(t,a,1,0,0,0), l = c.getDay(), p = i(t, a), m = c.getDate() - l, h = !0;
 * h; ) { o = d('<tr class="days"></tr>'); for (var g = 0; g < 7; g++) { var
 * u = [] , _ = "" , f = "" , v = "" , y = "" , b = "" , w = t + "-" + (a + 1) +
 * "-" + m , x = !1; isLast = !0, isFull = !1, 1 === m ? u.push("first-day") : m
 * === p && u.push("last-day"), m <= 0 || m > p ? u.push("null") : (e[m -
 * 1].is_full_booked && (u.push("norder"), isFull = !0), _ = 'data-day="' + w +
 * '"', f = 'data-time="' + m + '"', v = 'data-status="' + (m > 0 ? e[m -
 * 1].is_full_booked : "0") + '"', y = "data-lowprice=" + e[m - 1].price, b =
 * "data-aifee=" + e[m - 1].is_preferential_price, dataIsFavor = e[m -
 * 1].is_preferential_price, 1 === dataIsFavor && u.push("isFavor"), n(w) < s ?
 * (u.push("disabled"), isLast = !1) : +n(w) === +s && (u.push("today"), x =
 * !0)), u = u.length > 0 ? 'class="' + u.join(" ") + '"' : "", o.append("<td " + u + " " + v + " " + b + " " + y + " " + _ + " " + f + ">" +
 * (m > p || m <= 0 ? "" : function() { var t, i = e[m - 1].price, n = e[m -
 * 1].is_preferential_price; return t = isLast ? function() { return e[m -
 * 1].is_full_booked ? "<p>满房</p>" : function() { return x ? "今天" : 1 === m ?
 * a + 1 + "月" : m }() }() : 1 === m ? a + 1 + "月" : m, isLast ? function() {
 * return e[m - 1].is_full_booked ? "<p>满房</p>" : function() { return 1 == n ? "<p>" +
 * t + "<span>￥" + i + "</span><i></i></p>" : "<p>" + t + "<span>￥" + i + "</span></p>"
 * }() }() : "<section>" + t + "</section>" }()) + "</td>"), m++ }
 * d("tbody", r).append(o), h = m <= p } return r } function l(e, t, a) { var t =
 * n(t) , a = n(a) , i = ""; i += '<p class="date-w"><i class="icon-calendar"></i>' +
 * (t.getMonth() + 1) + "月" + t.getDate() + "日 入住 -- " + (a.getMonth() + 1) +
 * "月" + a.getDate() + '日 退房<span class="down"><i class="icon-left"></i></span></p>',
 * i += '<p class="tit">预订明细</p>', i += "<ul>"; for (var s = 0; s <
 * e.length; s++) { var o = e[s]; i += "<li>", i += '<div class="date">' +
 * (n(o.date).getMonth() + 1) + "月" + n(o.date).getDate() + "日</div>", i += '<div
 * class="price-w">', i += o.preferential_price && o.preferential_price !=
 * o.basic_price ? '<span class="line-thro">门市价&nbsp;&nbsp;&yen;' +
 * o.basic_price + "</span>特价&nbsp;&nbsp;&yen;" + o.preferential_price : "<span>门市价&nbsp;&nbsp;&yen;" +
 * o.basic_price + "</span>", i += "</div>", i += "<li>" } return i += "</ul>" }
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
 * a.length; ) e = a.pop(), e.removeClass("range"); t.td.removeClass(".range") } ,
 * e.exports = p } });
 */