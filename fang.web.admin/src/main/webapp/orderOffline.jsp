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
                
            </div>
            <div class="col-sm-9">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>请填写入住以及订单信息</h5>
                    </div>
                    <div class="ibox-content">
                        <form action="<%=request.getContextPath() %>/order/submitOrderOffline" id="offlineOrderForm" method="post">
					<input type="hidden" name="beginDate" value="${beginDate}"/>
					<input type="hidden" name="endDate" value="${endDate}"/>
					<input type="hidden" name="roomId" value="${roomId}"/>
					<input type="hidden" name="totalPrice" value="${priceList.total_price}"/>
					<input type="hidden" name="basicPrice" value="${priceList.day_price_list[0].basic_price}"/>
					<input type="hidden" name="dayPrice" value="${priceList.day_price_list[0].standard_price}"/>
					<div class="modal-body">
							<div class="form-group">
								<label>入住时间：${beginDate} </label> <br>
								<label>退房时间：${endDate} </label> <br>
								<label>应收总房费：<font color="red">${priceList.total_price} </font></label> 
							</div>
							<div class="form-group">
								<label>房费明细：</label> <br>
								<c:forEach items="${priceList.day_price_list}" var="priceDetail">
									<label>日期：${ priceDetail.date}  费用：${priceDetail.standard_price} </label> <br>
								</c:forEach>
							</div>
							<div class="form-group">
								<label>入住人数： </label>
								<label><input type="text" name="number" class="form-control"> </label>  
							</div>
							<div class="form-group">
								<label>联系人： </label> 
								<label><input type="text" name="contact" class="form-control"></label> 
							</div>
							<div class="form-group">
								<label>联系电话： </label> 
								<label><input type="text" name="contactPhone" class="form-control"></label> 
							</div>
							<div class="form-group">
								<label>身份证：</label> 
								<input type="text" name="ids" class="form-control" placeholder="多人时用逗号隔开">
							</div>
							<div class="form-group">
								<label>房费付款方式：</label> 
								<select class="form-control" name="fangpayWay">
									<option value="-1">无</option>
									<option value="0">微信</option>
        							<option value="1">支付宝</option>
							        <option value="2">现金</option>
							        <option value="3">银联在线支付</option>
							        <option value="4">刷卡支付</option>
    							</select>
							</div>
							<div class="form-group">
								<label>实收押金：</label> 
								<input type="text" name="yajinNum" class="form-control" placeholder="">
							</div>
							<div class="form-group">
								<label>押金方式：</label> 
								<select class="form-control" name="yajinWay">
									<option value="-1">无</option>
									<option value="0">微信</option>
        							<option value="1">支付宝</option>
							        <option value="2">现金</option>
							        <option value="3">银联在线支付</option>
							        <option value="4">刷卡支付</option>
    							</select>
							</div>
							<div class="form-group">
								<label>备注：</label> 
								<input type="text" class="form-control" name="note" placeholder="">
							</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-white" data-dismiss="modal" id="goback">返回</button>
						<button type="button" class="btn btn-primary" id="orderSubmit">保存</button>
					</div>
				</form>
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
		$("#goback").on("click", function(){
			history.back();
		});
		$("#orderSubmit").on("click", function(){
			$("#offlineOrderForm").submit();
		})
	});
    </script>
</body>
</html>
