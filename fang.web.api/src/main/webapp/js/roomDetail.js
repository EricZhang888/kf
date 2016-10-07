//加载详情
$(document).ready(function(){
	getDetailAjax();
	
});


function getDetailAjax(){
	$.ajax({
        type: "GET",
        url: window.g_base.apibase + "/room/getRoomDetail" + window.location.search,
        xhrFields: {
            withCredentials: !0
        },
        success: function(t) {
            'A00000' == t.status ? (
            $(".es_content_relative").html(genHtml(t.data)),
            genSwiperSingle(t.data)
           ) :'';
           initMap(t.data);
        },
        error: function(e, t) {
            window.location.href = "/errors/404?msg=找不到房间&returnUrl=/"
        }
    })
}

function genSwiperSingle() {
    var e = $("#img-box");
    if (!(e.length <= 0)) {
        new Swiper(e,{
            initialSlide: 0,
            loop: !0,
            onSlideChangeEnd: function(t) {
                e.find(".curPage").text(+e.find(".swiper-slide-active").attr("data-swiper-slide-index") + 1)
            },
            onInit: function(t) {
                e.css({
                    height: document.body.clientWidth / 750 * 420 + "px"
                }),
                e.find("li").css({
                    height: document.body.clientWidth / 750 * 420 + "px"
                })
            },
            lazyLoading: !0
        })
    }
}

//计算html
function genHtml(data){
	roomId = data.roomId;
	return genImgs(data.roomImages.split(","), data.roomId) + genRoomInfo(data) +
	genRoomDesc(data) + genRoomAmenities(data) + genTips(data) ;
	//return genImgs(data.roomImages) + genRoomInfo(data) + genRoomDesc(data) + genRoomAmenities(data) + genComment(data) + genTips(data);
}


//计算图片部分
function genImgs(imgs,id) {
	var t = "";
    t += '<div class="apartment-box">',
    t += '<div class="img-box" id="img-box">', 
    t += '<ul class="swiper-wrapper">';
    for (var a = 0; a < imgs.length; a++)
        t += '<li class="swiper-slide">',
        t += '<img class="swiper-lazy" src="img/loading-replace.jpg" data-src="img/fang/'+ id + '/' + imgs[a] + '">',
        t += "</li>";
    return t += "</ul>",
    t += '<div class="pages"><span class="curPage">1</span>/<span class="totalPage">' + imgs.length + "</span></div>",
    t += "</div>",
    t += "</div>"
}

//房间信息Html
function genRoomInfo(e) {
	var t = "";
    if (t += '<div class="apartment-info">',
    t += '<div class="flex-item">',
    t += '<p class="nowrap"><strong>' + e.roomName + "</strong><br/>" + e.roomApartment.apartmentName + "</p>",
    t += '<p class="mr5">',
    e.roomBedroomCount > 0 && (t += e.roomBedroomCount + "室"),
    e.roomSittingCount > 0 && (t += e.roomSittingCount + "厅"),
    e.roomKitchenCount > 0 && (t += e.roomKitchenCount + "厨"),
    e.roomBathroomCount > 0 && (t += e.roomBathroomCount + "卫"),
    t += e.roomMinArea == e.roomMaxArea ? "<span>约" + e.roomMinArea + '<i class="icon-square"></i></span>' : "<span>" + e.roomMinArea + "-" + e.roomMaxArea + '<i class="icon-square"></i></span>',
    e.bed_types && e.bed_types.length > 0) {
        t += "<br/>",
        t += '<span style="line-height: 2rem;font-size: 1.2rem;">' + e.bed_count + "床</span>";
        for (var a = 0; a < e.bed_types.length; a++)
            (a + 1) % 3 == 0 && (t += "<br/>"),
            t += '<span style="line-height: 2rem;font-size: 1.2rem;">(' + e.bed_types[a].size + "&nbsp;" + e.bed_types[a].count + "张)</span>"
    }
    return t += "</p>",
    t += "</div>",
    (t += '<div class="price-box">&yen;<strong>' + e.roomPrice + "</strong>",
    t += '<div class="ms-box"><p class="ori-name">门市价</p><p class="ori-price">&yen;' + e.roomBasicPrice + "</p></div>",
    t += "</div>"),
    t += "</div>"
}

function genRoomDesc(e) {
	var t = "";
    t += '<div class="character">',
    t += "<h2>特色描述</h2>",
    t += '<p class="shortDes tc">' + e.roomTypeMiniDesc + "</p>",
    //t += "<ul>";
    //for (var a = 0; a < Math.min(e.room_type_tags.length, 3); a++)
   //     t += '<li><span class="tag">' + e.room_type_tags[a].tag_name + "</span></li>";
   // for (var i = 0; i < Math.min(e.apartment_tags.length, 6 - Math.min(e.room_type_tags.length, 3)); i++)
   //     t += '<li><span class="tag">' + e.apartment_tags[i].tag_name + "</span></li>";
   // return t += "</ul>",
  //  e.intro ? (t += '<img src="' + e.intro.cover_image + '" />',
   // t += '<p class="des">' + e.intro.cover_desc + "</p>",
  //  t += '<p class="tc"><a href="' + e.intro.desc_url + '" class="look-all-btn" id="findAllchar">查看全部</a></p>') : t += e.room_type_desc ? e.room_type_desc : "",
    t += "</div>"
}

function genRoomAmenities(e){
	var t = "";
	t += '<div class="facilitiesAll">',
	t += "<h2>设施服务</h2>",
	t += '<ul class="fac-ul">';
	for (var a = 0; a < Math.min(e.tbRoomAmenities.length, 10); a++) {
		t += '<li><i class="icon-' + e.tbRoomAmenities[a].icon + '"></i><span>' + e.tbRoomAmenities[a].amenityName + "</span></li>";
	}
	if (Math.min(e.tbRoomAmenities.length, 10) < 10){
		for (var i = 0; i < Math.min(e.tbRoomAmenities.length, 10 - Math.min(e.tbRoomAmenities.length, 10)); i++) {
			t += '<li><i class="icon-' + e.tbRoomAmenities[i].icon + '"></i><span>' + e.tbRoomAmenities[i].amenityName + "</span></li>";
		}
	} 
	return t += "</ul>",
	e.tbRoomAmenities.length + e.tbRoomAmenities.length > 10 && (t += '<p><span class="look-all-btn" id="findAllFac">查看全部</span></p>'),
	t += "</div>"
}

function genTips(e) {
	var t = "";
    return t += '<div class="hotel-address" id="hotel-address">',
    t += '<div class="map-mask"></div>',
    t += '<p class="address"><span id="address">' + e.roomAddress + "</span></p>",
    t += '<div id="map_warp" class="clearfix"></div>',
    t += "</div>",
    t += '<div class="hotel-address-reminder">',
    t += '<h2>温馨提示</h2><div class="reminder">'  + "<br/>" + e.roomApartment.apartmentTips + "</div>",
    t += "</div>"
}

var map;

function initMap(room){
    createMap(room);//创建地图
    setMapEvent();//设置地图事件
    addMapControl();//向地图添加控件
    addMapOverlay(room);//向地图添加覆盖物
  }
  function createMap(room){ 
    map = new BMap.Map("map_warp"); 
    map.centerAndZoom(new BMap.Point(room.roomLongitude,room.roomLatitude),12);
  }
  function setMapEvent(){
    map.enableScrollWheelZoom();
    map.enableKeyboard();
    map.enableDragging();
    map.enableDoubleClickZoom()
  }
  function addClickHandler(target,window){
    target.addEventListener("click",function(){
      target.openInfoWindow(window);
    });
  }
  function addMapOverlay(room) {
	    var markers = [{
	        content: room.roomAddress,
	        title: room.roomApartment.apartmentName,
	        imageOffset: {
	            width: 0,
	            height: 3
	        },
	        position: {
	            lat: room.roomLatitude,
	            lng: room.roomLongitude
	        }
	    }];
	    for (var index = 0; index < markers.length; index++) {
	        var point = new BMap.Point(markers[index].position.lng, markers[index].position.lat);
	        var marker = new BMap.Marker(point, {
	            icon: new BMap.Icon("http://api.map.baidu.com/lbsapi/createmap/images/icon.png", new BMap.Size(20, 25), {
	                imageOffset: new BMap.Size(markers[index].imageOffset.width, markers[index].imageOffset.height)
	            })
	        });
	        var label = new BMap.Label(markers[index].title, {
	            offset: new BMap.Size(25, 5)
	        });
	        var opts = {
	            width: 200,
	            title: markers[index].title,
	            enableMessage: false
	        };
	        var infoWindow = new BMap.InfoWindow(markers[index].content, opts);
	        marker.setLabel(label);
	        addClickHandler(marker, infoWindow);
	        map.addOverlay(marker);
	    }
  }
  //向地图添加控件
  function addMapControl(){
    var scaleControl = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
    scaleControl.setUnit(BMAP_UNIT_IMPERIAL);
    map.addControl(scaleControl);
    var navControl = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
    map.addControl(navControl);
    //var overviewControl = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:true});
    //map.addControl(overviewControl);
  }
  
  
  $(".left-icon", ".detail").on("tap click", function(e) {
      document.referrer.length > 1 ? history.back() : window.location.href = "/"
  });
  
  $("#mask").on("click tap", function() {
      $(this).hide(),
      $("#all-fac").hide(),
      $(".book").removeClass("page-down"),
      $("#rp-calendar").addClass("page-down")
      $(".rpWrapper").html("");
  })
  //立即预定按钮
  $("#bookBtn").on("tap click", function() {
      $(this).parent(".book").addClass("page-down"),
      $("#mask").show(),
      $("#rp-calendar").removeClass("page-down"),
      initPrice();
      //B && B instanceof D || (B = new D(i("#rp-calendar"),S.room_type_id,S.checkin_date,S.checkout_date,currentDate,w))
  })
//function initMap(room) {
//	initMap();
//	//初始地图
//	var w = new Image;
////	var f = $("#map_warp");
////	var y = f.innerWidth
////    var b = f.innerHeight
////	f.innerHtml = "";
//	w.style.width = "100%";
//    w.style.height = "100%";
//    w.src = "http://api.map.baidu.com/staticimage/v2?ak=c1GsFcLI8eEllvlzDEUjNn5T&mcode=666666&center=" + room.roomLongitude + "," + room.roomLatitude + "&width=" + 500 + "&height=" + 400 + "&zoom=13&markers=" + room.roomLongitude + "," + room.roomLatitude + "&scale=2"
//    $("#map_warp").append(w);
//}