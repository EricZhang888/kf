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
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-content">
                        <div class="search-form">
                            <form action="<%=request.getContextPath() %>/order/queryOrder" method="POST">
                            	<input class="" type="hidden" name="sort" value="createTime,desc">
                                <div class="input-group">
                                	<div class="col-sm-4">
										<input type="text" placeholder="姓名" name="bookerName" class="form-control input-lg">
                                	</div>
                                	<div class="col-sm-4">
                                    <input type="text" placeholder="联系电话" name="bookerMobile" class="col-md-4 form-control input-lg">
                                	</div>
                                	<div class="col-sm-4">
                                    <input type="text" placeholder="订单号" name="orderNo" class="form-control input-lg">
                                	</div>
                                    <div class="input-group-btn">
                                        <button class="btn btn-lg btn-primary" type="submit">
											搜索
                                        </button>
                                    </div>
                                </div>

                            </form>
                        </div>
                        <h4>
							为您找到相关结果约 ${total} 个
                        </h4>
                        <div id="DataTables_Table_0_wrapper" class="dataTables_wrapper form-inline" role="grid">
							  <table class="table table-bordered table-hover dataTables-example dataTable" id="DataTables_Table_0" aria-describedby="DataTables_Table_0_info">
							    <thead>
							      <tr role="row">
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 177px;">房源图</th>
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-sort="ascending" style="width: 216px;">房源信息</th>
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 196px;">联系人</th>
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 127px;">联系人电话</th>
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 127px;">付款信息</th>
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 200px;">操作</th>
							      </tr>
							    </thead>
							    <tbody>
								    <c:forEach items="${list }" var="roomOrder">
								    	<tr class="gradeA odd">
								        <td class=""><img alt="" height="138" width="190" src="../img/fang/${roomOrder.roomId}/${roomOrder.roomImg}"></td>
								        <td class="sorting_1">${roomOrder.apartmentName} </td>
								        <td class="">${roomOrder.contactName}</td>
								        <td class="center">${roomOrder.contactPhone}</td>
								        <td class="center">
								        	${roomOrder.price} 元<br>
								        	<c:choose>
								        		<c:when test="${roomOrder.status == '1'}">
								        			待支付	
								        		</c:when>
								        		<c:when test="${roomOrder.status == '2'}">
								        			已支付	
								        		</c:when>
								        		<c:when test="${roomOrder.status == '3'} ">
								        			超时取消	
								        		</c:when>
								        		<c:when test="${roomOrder.status == '4'}">
								        			客户退订	
								        		</c:when>
								        		<c:when test="${roomOrder.status == '5'}">
								        			已入住	
								        		</c:when>
								        		<c:otherwise>
								        			正常退房结束
								        		</c:otherwise>
								        	</c:choose>
								        	<br>
								        	<c:choose>
								        		<c:when test="${roomOrder.payment == '0'}">
								        			微信支付	
								        		</c:when>
								        		<c:when test="${roomOrder.payment == '1'}">
								        			支付宝支付
								        		</c:when>
								        		<c:when test="${roomOrder.payment == '2'}">
								        			现金
								        		</c:when>
								        		<c:when test="${roomOrder.payment == '3'} ">
								        			银联在线支付	
								        		</c:when>
								        		<c:when test="${roomOrder.payment == '4'}">
								        			刷卡支付
								        		</c:when>
								        	</c:choose>
								        </td>
								        <td class="center">
											<c:choose>
								        		<c:when test="${roomOrder.status == '1'}">
								        			<button id="adminPayCheckIn" class="button">付款并入住</button>
								        		</c:when>
								        		<c:when test="${roomOrder.status == '2'}">
								        			<button id="adminCheckIn" class="button" data-toggle="modal" data-target="#myModal4" data-orderId="${roomOrder.id}" data-roomId="${roomOrder.roomId}">入住</button>
								        		</c:when>
								        		<c:when test="${roomOrder.status == '5'}">
								        			<a href="orderCheckout?orderRoomId=${roomOrder.roomId}&orderId=${roomOrder.id}"><button id="adminCheckOut" class="button"  data-toggle="modal" data-target="#myModal5"">退房</button></a>
								        			<button id="adminModifyInfo" class="button">修改入住信息</button>
								        		</c:when>
								        	</c:choose>
										</td>
								      </tr>
								    </c:forEach>
							    </tbody>
							  </table>
							  <!-- paging -->
						</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
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

	<div class="modal inmodal" id="myModal4" tabindex="-1" role="dialog"
		aria-hidden="true" style="display: none;">
		<div class="modal-dialog">
			<div class="modal-content animated fadeIn">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">Close</span>
					</button>
					
					<h4 class="modal-title">入住办理</h4>
					<small>录入入住人相关必要信息</small>
				</div>
				<form action="<%=request.getContextPath() %>/order/orderCheckIn" method="POST" id="orderCheckInForm">
				<input type="hidden" name="orderRoomId" value=""/>
				<input type="hidden" name="orderId" value=""/>
					<div class="modal-body">
							<div class="form-group">
								<label>入住人数：</label> 
								<input type="text" name="number" class="form-control">
							</div>
							<div class="form-group">
								<label>身份证：</label> 
								<input type="text" name="ids" class="form-control" placeholder="多人时已都好隔开">
							</div>
							<div class="form-group">
								<label>押金：</label> 
								<input type="text" name="yajinNum"class="form-control">元
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
								<input type="text" name="note" class="form-control">
							</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" id="checkinSubmit">保存</button>
					</div>
				</form>
			</div>
			<small> </small>
		</div>
		<small> </small>
	</div>
	<div class="modal inmodal" id="myModal5" tabindex="-1" role="dialog"
		aria-hidden="true" style="display: none;">
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
							<div class="form-group">
								<label>应退押金：200 元</label> 
							</div>
							<div class="form-group">
								<label>实退押金：</label> 
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
