<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="cn">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="<%=request.getContextPath() %>/resource/cssfolder/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resource/cssfolder/font-awesome.min93e3.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resource/cssfolder/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resource/cssfolder/plugins/fullcalendar/fullcalendar.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resource/cssfolder/plugins/fullcalendar/fullcalendar.print.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resource/cssfolder/animate.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resource/cssfolder/style.min.css" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content">
        <div class="row animated fadeInDown">
            <div class="col-sm-3">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>房源信息</h5>
                    </div>
                    <div class="ibox-content">
                        <div id='external-events'>
                            <p>房间：${room.roomApartment.apartmentName}·${room.roomBuilding}·${room.roomFloor}层·${room.roomNumber}</p>
                            <p>面积：${room.roomMaxArea}</p>
                            <p>卧室：${room.roomBedroomCount}</p>
                            <p>床：${room.roomBedCount} 张</p>
                            <p>阳台：${room.roomBalconyCount}</p>
                            <p>挂牌价：${room.roomBasicPrice}</p>
                            <p>正常价：${room.roomPrice}</p>
                        </div>
                    </div>
                </div>
                <div class="ibox float-e-margins">
                    <div class="ibox-content">
                        <h2>快速设置</h2>
                        <p>
                        	周日至周四：<input name="SunThurPrice" value="" /> 元 
                        </p>
                        <p>
                        	周五至周六：<input name="FriSatPrice" value="" /> 元 
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-sm-9">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>修改房价(允许修改未来2个月的房价) </h5>
                    </div>
                    <div class="ibox-content">
                        <div id="calendar"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="<%=request.getContextPath() %>/resource/javascript/jquery.min.js?v=2.1.4"></script>
    <script src="<%=request.getContextPath() %>/resource/javascript/bootstrap.min.js?v=3.3.6"></script>
    <script src="<%=request.getContextPath() %>/resource/javascript/content.min.js?v=1.0.0"></script>
    <script src="<%=request.getContextPath() %>/resource/javascript/plugins/iCheck/icheck.min.js"></script>
    <script src="<%=request.getContextPath() %>/resource/javascript/plugins/fullcalendar/fullcalendar.min.js"></script>
    
	<script>
	$(document).ready(function() {
		var move = 0;
	    $(".i-checks").iCheck({
	        checkboxClass: "icheckbox_square-green",
	        radioClass: "iradio_square-green",
	    });
	    $("#external-events div.external-event").each(function() {
	        var d = {
	            title: $.trim($(this).text())
	        };
	        $(this).data("eventObject", d);
	        $(this).draggable({
	            zIndex: 999,
	            revert: true,
	            revertDuration: 0
	        })
	    });
	    var b = new Date();
	    var c = b.getDate();
	    var a = b.getMonth();
	    var e = b.getFullYear();
	    var priceBean = ${priceCalendar};
	    var start = 0;
	    var eventStr="";
	    var eventArray = new Array();
	    $.each(priceBean, function(n,value){
	    	start += 1;
	    	/* if(start !=1) {
	    		eventStr += ","
	    	} */
	    	//eventStr = "{title:'"+ value.price +"', start: '" + value.date +"'}";
	    	eventArray.push({title: value.price, start: value.date});
		});
	    $("#calendar").fullCalendar({
	        header: {
	            left: "prev,next",
	            center: "title",
	            right: "month"
	        },
	        editable: true,
	        weekends: true,
	        contentHeight: 250,
	        events: eventArray
	                
	        
	        	/* {
		            title: "￥233",
		            start: new Date(e, a, 1)
		        } */
	    	
	    });
	    
	    //设置上月按钮默认隐藏
	    $(".fc-corner-left").css("display","none");
	    $(".fc-corner-left").on("click",function(){
	    	--move;
	    	$(".fc-corner-right").css("display","");
	    	if(move === 0) {
	    		$(".fc-corner-left").css("display","none");
	    	}
	    });
		$(".fc-corner-right").on("click",function(){
			++move;
			$(".fc-corner-left").css("display","");
			if(move === 2) {
				$(".fc-corner-right").css("display","none");
			}
	    });
	});
    </script>
</body>
</html>
