checkLogin(orderDetailLogin);

var sPara = parseQuery(window.location.search);

function orderDetailLogin(user) {
	if(user ==null) {
		window.location.href="/html/user/login.html?redirect=" + encodeURIComponent(window.location.href);
	} else {
		init(user);
	}
}


$(document).ready(function(){
	$.ajax({
		type: "GET",
        url: window.g_base.apibase + "/order/getOrdersById?key=" + Math.random(),
        data: {
            id: sPara.order_id
        },
        cache: !1,
        dataType: "json",
        xhrFields: {
            withCredentials: !0
        },
        success: function(e) {
        	genHtml(e.order, e.room);
        }
    })
})

function genHtml(order,room) {
	$(".order-nu").text("订单号： " + order.orderNumber);
	$("#roomLink").attr("href","/roomDetail.html?id=" + room.roomId);
	$(".room-title").html(order.roomName + "&nbsp;&nbsp;<span>" + order.apartmentName);
	$("#total_pay").html("房费金额&nbsp;&nbsp;<i class=\"dolle\">￥" + order.price + "</i>");
	$("#pay_price").html("支付金额&nbsp;&nbsp;<i class=\"dolle\">￥" + order.price + "</i>");
	$(".to-map a").html("<i class=\"icon-location-hollow\"></i>" + room.roomAddress);
	$(".to-map a").html("<i class=\"icon-location-hollow\"></i>" + room.roomAddress);
	$("#contact_name").html("入住人姓名<span>" + order.contactName + "</span>");
	$("#contact_phone").html("联系电话<span>" + order.contactPhone + "</span>");
	$(".order-info img").attr("src", "/img/fang/" + room.roomId + "/" + order.roomImg);
	$("#checkIn").html("入住 &nbsp;&nbsp; " + order.dateStart);
	$("#checkOut").html("退房 &nbsp;&nbsp; " + order.dateEnd);
	$("#roomAcc").html(order.roomBedroomCount + "室" + order.roomBathroomCount + "卫");
}

