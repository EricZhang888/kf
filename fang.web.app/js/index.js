//index page js
var clientWidth = document.body.clientWidth;
var banner = $("#banner-box");
var room_list = $("#hotel_list");
$(document).ready(function(e) {
    banner.css("height", clientWidth / 720 * 420 + "px");
	banner.css("width", clientWidth + "px");
	banner.find("img").css("height", clientWidth / 720 * 420 + "px");
	banner.find("img").css("width", clientWidth + "px");
	room_list.find(".img-box").css("height", clientWidth / 750 * 420 + "px");
	room_list.find(".img-box").css("width", clientWidth + "px");
	var mySwiper = new Swiper('.swiper-container', {
		//autoplay: 5000,//可选选项，自动滑动
	});
	
	
	//请求房源列表
	
	
	
	//生成房源列表Html
	function n(e) {
            var t = document.body.clientWidth / 750 * 420;
             a = "";
            if (!e || e.length <= 0)
                return "";
            for (var i = 0; i < e.length; i++) {
                var s = e[i];
                var detailLink = "/apartment/detail?roomId=" + s.room_type_id;
                a += '<a class="apartment-box" href="' + detailLink + '">';
                a += '<div class="img-box" id="imgBox' + s.room_type_id + '" style="height:' + t + 'px" >';
                a += '<ul class="swiper-wrapper">';
                for (var o = 0; o < s.images.length; o++)
                    a += '<li class="swiper-slide">',
                    a += '<img class="swiper-lazy' + (0 == o ? " lazyload" : "") + '" src="img/loading-replace.jpg" data-src="' + s.images[o] + '" alt="">';
                    a += '<div class="pages"><span class="curPage">1</span>/<span class="totalPage">' + s.images.length + "</span></div>";
                    a += "</li>";
                a += "</ul>",
                a += '<span class="tag t4">' + s.apartment_name + "</span>";
                s.distance && (a += '<span class="tag t3"><i class="icon-location-hollow"></i>距您' + (Math.floor(s.distance) >= 1 ? Math.round(s.distance) + "km" : 1e3 * s.distance.toFixed(3) + "m") + "</span>");
                a += "</div>";
                a += '<div class="info">';
                a += '<p class="name nowrap"><span class="r-name">' + s.room_type_name + '</span>&nbsp&nbsp</i>' + s.apartment_name + '</p>';
                a += '<p class="facilities">' + (s.bedroom_count ? s.bedroom_count + '室' : '') + (s.sitting_room_count ? s.sitting_room_count + '厅' : '') + '<i>|</i>约' + s.max_area + '<i class="icon-square"></i><i>|</i>' + s.bed_count + '床' + (s.comment_avg_score > 0 ? '<i>|</i><span class="color-orange">' + Math.floor(10 * s.comment_avg_score) // 10 + '分</span>' : '') + '</p>';
                0 != s.fully_booked_type.key ? a += '<div class="price-box full-box">&yen;<strong>' + s.price + "</strong><br/><span>" + s.fully_booked_type.value + "</span></div>" : (a += '<div class="price-box">&yen;<strong>' + s.price + "</strong>";
                a += s.is_standard_price ? '<div class="ms-box"><p class="ori-name">门市价</p><p class="ori-price">&yen;' + s.basic_price + "</p></div>" : '<div class="ori-box"><p class="ori-name">特价</p><p class="ori-price">&yen;' + s.basic_price + "</p></div>";
                a += "</div>");
                a += "</div>";
                a += "</a>";
            }
            return a;
        }
	
});
