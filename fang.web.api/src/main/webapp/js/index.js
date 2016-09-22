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
	$.ajax({
        url: window.g_base.apibase + "/home/getAllAvaliableRooms?client=" + Math.floor(Math.random()*100+1),
        type: "GET",
        dataType: "json",
        xhrFields: {
            withCredentials: !0
        },
        data: {
            city: "深圳",
            site: "霞涌"
        },
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        success: function(a) {
            $("#hotel_list").html(genRoomListHtml(a.content))
        },
        error: function(a, t) {
            p.html(""),
            console.log("获取banner error")
        }
    })
	
	
	//生成房源列表Html
	function genRoomListHtml(content) {
        var deviceHeight = document.body.clientWidth / 750 * 420
        var html = "";
        if (!content || content.length <= 0)
            return "";
        for (var i = 0; i < content.length; i++) {
            var room = content[i];
            var imgs = room.roomImgs.split(",");
            var detailLink = "/room/detail?roomId=" + room.id;
            a += '<a class="apartment-box" href="' + detailLink + '">',
            a += '<div class="img-box" id="imgBox' + room.id + '" style="height:' + deviceHeight + 'px" >',
            a += '<ul class="swiper-wrapper">';
            for (var o = 0; o < imgs.length; o++)
                a += '<li class="swiper-slide">',
                a += '<img class="swiper-lazy' + (0 == o ? " lazyload" : "") + '" src="http://webpic.estay.com/webui/images/wap/loading-replace.jpg" data-src="' + imgs[o] + '" alt="">',
                a += '<div class="pages"><span class="curPage">1</span>/<span class="totalPage">' + imgs.length + "</span></div>",
                a += "</li>";
            a += "</ul>",
            a += '<span class="tag t4">' + room.apartment_name + "</span>",
            room.distance && (a += '<span class="tag t3"><i class="icon-location-hollow"></i>距您' + (Math.floor(room.distance) >= 1 ? Math.round(room.distance) + "km" : 1e3 * room.distance.toFixed(3) + "m") + "</span>"),
            a += "</div>",
            a += '<div class="info">',
            a += '<p class="name nowrap"><span class="r-name">' + room.room_type_name + "</span>&nbsp&nbsp</i>" + room.apartment_name + "</p>",
            a += '<p class="facilities">' + (room.bedroom_count ? room.bedroom_count + "室" : "") + (room.sitting_room_count ? room.sitting_room_count + "厅" : "") + "<i>|</i>约" + room.max_area + '<i class="icon-square"></i><i>|</i>' + room.bed_count + "床" + (room.comment_avg_score > 0 ? '<i>|</i><span class="color-orange">' + Math.floor(10 * room.comment_avg_score) / 10 + "分</span>" : "") + "</p>",
            0 != room.fully_booked_type.key ? a += '<div class="price-box full-box">&yen;<strong>' + room.price + "</strong><br/><span>" + room.fully_booked_type.value + "</span></div>" : (a += '<div class="price-box">&yen;<strong>' + room.price + "</strong>",
            a += room.is_standard_price ? '<div class="ms-box"><p class="ori-name">门市价</p><p class="ori-price">&yen;' + room.basic_price + "</p></div>" : '<div class="ori-box"><p class="ori-name">特价</p><p class="ori-price">&yen;' + room.basic_price + "</p></div>",
            a += "</div>"),
            a += "</div>",
            a += "</a>"
        }
        return a
    }
	
});
