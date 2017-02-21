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
    <link href="<%=request.getContextPath() %>/resource/cssfolder/animate.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resource/cssfolder/style.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resource/cssfolder/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">

</head>

<body class="gray-bg">
    
    <script src="<%=request.getContextPath() %>/resource/javascript/jquery.min.js?v=2.1.4"></script>
    <script src="<%=request.getContextPath() %>/resource/javascript/bootstrap.min.js?v=3.3.6"></script>
    <script src="<%=request.getContextPath() %>/resource/javascript/content.min.js?v=1.0.0"></script>
    <script src="<%=request.getContextPath() %>/resource/javascript/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="<%=request.getContextPath() %>/resource/javascript/plugins/dataTables/dataTables.bootstrap.js"></script>
    <script>
    $(document).ready(function() {
        $(".dataTables-example").dataTable({
        	"pages": 20,
        	"sort": false
        });
        //var oTable = $("#editable").dataTable();
        $("#adminCheckIn").on("click", function(){
        	$("#orderCheckInForm input[name='orderId']").val($(this).attr("data-orderId"));
        	$("#orderCheckInForm input[name='orderRoomId']").val($(this).attr("data-roomId"));
        })
        
        $("#checkinSubmit").on("click", function(){
        	$("#orderCheckInForm").submit();
        });
        
        $("#checkinSubmit").on("click", function(){
        	$("#orderCheckoutForm").submit();
        });
    });
    
    </script>

	<div class="" id="myModal5">
		<div class="modal-dialog">
			<div class="modal-content animated fadeIn">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">Close</span>
					</button>
					
					<h4 class="modal-title">退房办理</h4>
				</div>
				<form action="<%=request.getContextPath() %>/order/orderCheckOut" id="orderCheckoutForm">
					<div class="modal-body">
							<%-- <div class="form-group">
								<label>入住时间：${checkinInfo.createTime} </label> 
							</div> --%>
							<div class="form-group">
								<label>入住人数：${checkinInfo.peopleNumber} </label> 
							</div>
							<div class="form-group">
								<label>入住身份证：${checkinInfo.peopleIds} </label> 
							</div>
							<div class="form-group">
								<label>实收押金：${checkinInfo.yajinNum} 元</label> 
							</div>
							<div class="form-group">
								<label>退回押金：</label> 
								<input type="text" class="form-control" placeholder="">
							</div>
							<div class="form-group">
								<label>备注：</label> 
								<input type="text" class="form-control">
							</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary">保存</button>
					</div>
				</form>
			</div>
			<small> </small>
		</div>
		<small> </small>
	</div>
</body>


</html>