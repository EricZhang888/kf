//index page js
var clientWidth = document.body.clientWidth;
var banner = $("#banner-box");
var room_list = $("#hotel_list");
$(document).ready(function(e) {
	checkLogin(init);
	
	room_list.find(".img-box").css("height", clientWidth / 750 * 420 + "px");
	room_list.find(".img-box").css("width", clientWidth + "px");
	var mySwiper = new Swiper($("#banner-box"),{
        initialSlide: 0,
        pagination: ".swiper-pagination",
        autoplay: 5e3,
        speed: 200,
        touchMoveStopPropagation: !1,
        autoplayDisableOnInteraction: !1,
        onInit: function(a) {
        	$("#banner-box").css({
                height: clientWidth / 720 * 420 + "px"
            }),
            $("#banner-box").find("img").css({
                height: clientWidth / 720 * 420 + "px"
            })
        },
        lazyLoading: !0
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
            city: "深圳"
        },
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        success: function(a) {
            $("#hotel_list").html(genRoomListHtml(a.content))
            o(a.content);
        },
        error: function(a, t) {
        	$("#hotel_list").html(""),
            console.log("获取banner error")
        }
    })
	
});

//生成房源列表Html
function genRoomListHtml(content) {
    var deviceHeight = document.body.clientWidth / 750 * 420
    var html = "";
    if (!content || content.length <= 0)
        return "";
    for (var i = 0; i < content.length; i++) {
        var room = content[i];
        var imgs = room.roomImgs.split(",");
        var detailLink = "/room/detail.html?roomId=" + room.id;
        html += '<a class="apartment-box" href="' + detailLink + '">',
        html += '<div class="img-box" id="imgBox' + room.id + '" style="height:' + deviceHeight + 'px" >',
        html += '<ul class="swiper-wrapper">';
        for (var o = 0; o < imgs.length; o++)
        	html += '<li class="swiper-slide">',
        	html += '<img ' + (0==o ? 'class' : 'class="swiper-lazy"') + ' src="' + (o==0 ? 'img/fang/'+ room.id + '/' + imgs[o] : 'img/loading-replace.jpg' ) + '" data-src=img/fang/'+ room.id + '/' + imgs[o] + ' alt="">',
        	html += '<div class="pages"><span class="curPage">1</span>/<span class="totalPage">' + imgs.length + "</span></div>",
        	html += "</li>";
        html += "</ul>",
        html += '<span class="tag t4">' + room.apartment_name + "</span>",
        room.distance && (html += '<span class="tag t3"><i class="icon-location-hollow"></i>距您' + (Math.floor(room.distance) >= 1 ? Math.round(room.distance) + "km" : 1e3 * room.distance.toFixed(3) + "m") + "</span>"),
        html += "</div>",
        html += '<div class="info">',
        html += '<p class="name nowrap"><span class="r-name">' + room.roomName + "</span>&nbsp&nbsp</i>" + room.roomSite + "</p>",
        html += '<p class="facilities">' +  room.room_accessoryComment +'<i>|</i><span class="color-orange">' + room.roomRate + "分</span>"  + "</p>",
        room.room_salePoint !=null ? html += '<p class="facilities">大家都在说 ：<span class="color-orange"><B>' + room.room_salePoint + "</B></span>"  + "</p>" : "",
        //html += '<p class="facilities">' + (room.bedroom_count ? room.bedroom_count + "室" : "") + (room.sitting_room_count ? room.sitting_room_count + "厅" : "") + "<i>|</i>约" + room.max_area + '<i class="icon-square"></i><i>|</i>' + room.bed_count + "床" + (room.comment_avg_score > 0 ? '<i>|</i><span class="color-orange">' + Math.floor(10 * room.comment_avg_score) / 10 + "分</span>" : "") + "</p>",
        html += '<div class="price-box">&yen;<strong>' + room.roomPrice + "</strong>",
        		html += '<div class="ms-box"><p class="ori-name">门市价</p><p class="ori-price">&yen;' + (room.roomPrice + Math.round(10)) + "</p></div>" ,
        				html += "</div>",
        				html += "</div>",
        				html += "</a>"
    }
    return html;
};


function o(e) {
    if (e && !(e.length <= 0))
        for (var t in e) {
            var a = e[t]
              , i = (document.body.clientWidth / 750 * 420,
            $("#imgBox" + a.id));
            (function(e) {
                new Swiper(e,{
                    initialSlide: 0,
                    touchAngle: 30,
                    threshold: 10,
                    loop: !0,
                    touchMoveStopPropagation: !1,
                    preloadImages: !1,
                    onSlideChangeStart: function(t) {
                        if (1 != t.activeIndex) {
                            var a = e.find(".swiper-slide-active").find("img");
                            a.hasClass("swiper-lazy") && (a.attr({
                                src: a.data("src")
                            }),
                            a.removeClass("swiper-lazy"))
                        }
                    },
                    onSlideChangeEnd: function(t) {
                        e.find(".curPage").text(+e.find(".swiper-slide-active").attr("data-swiper-slide-index") + 1)
                    }
                })
            }
            ).bind(this, i)()
        }
}