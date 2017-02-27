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
                        <h5>修改房价(允许修改未来三个月的房价) </h5>
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
        $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",});$("#external-events div.external-event").each(function(){var d={title:$.trim($(this).text())};$(this).data("eventObject",d);$(this).draggable({zIndex:999,revert:true,revertDuration:0})});var b=new Date();var c=b.getDate();var a=b.getMonth();var e=b.getFullYear();$("#calendar").fullCalendar({header:{left:"prev,next",center:"title",right:"month,agendaWeek,agendaDay"},editable:true,droppable:true,drop:function(g,h){var f=$(this).data("eventObject");var d=$.extend({},f);d.start=g;d.allDay=h;$("#calendar").fullCalendar("renderEvent",d,true);if($("#drop-remove").is(":checked")){$(this).remove()}},events:[{title:"日事件",start:new Date(e,a,1)},{title:"长事件",start:new Date(e,a,c-5),end:new Date(e,a,c-2),},{id:999,title:"重复事件",start:new Date(e,a,c-3,16,0),allDay:false,},{id:999,title:"重复事件",start:new Date(e,a,c+4,16,0),allDay:false},{title:"会议",start:new Date(e,a,c,10,30),allDay:false},{title:"午餐",start:new Date(e,a,c,12,0),end:new Date(e,a,c,14,0),allDay:false},{title:"生日",start:new Date(e,a,c+1,19,0),end:new Date(e,a,c+1,22,30),allDay:false},{title:"打开百度",start:new Date(e,a,28),end:new Date(e,a,29),url:"http://baidu.com/"}],})});
    </script>
</body>
</html>