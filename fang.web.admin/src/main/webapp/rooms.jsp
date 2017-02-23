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
                            <form action="<%=request.getContextPath() %>/room/queryRoom" method="POST">
                            	<input class="" type="hidden" name="sort" value="roomCreateTime,desc">
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
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 196px;">房东</th>
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 127px;">房东电话</th>
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 127px;">状态</th>
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 200px;">操作</th>
							      </tr>
							    </thead>
							    <tbody>
								    <c:forEach items="${list}" var="room">
								    
								    	<c:set value="${ fn:split(room.roomImages, ',') }" var="images" />
										
								    	<tr class="gradeA odd">
								        <td class=""><img alt="" height="138" width="190" 
								        src="../img/fang/${room.roomId}/${images[0]}">
								        </td>
										
								        <td class="sorting_1">${room.roomApartment.apartmentName}·${room.roomBuilding}·${room.roomFloor}层·${room.roomNumber}</td>	
								       <td class="">${room.tbRoomHolder.name}</td>
								        <td class="center">${room.tbRoomHolder.mobile}</td>
								        <td class="center">
								        	${room.roomPrice} 元<br>
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
								        			银联支付	
								        		</c:when>
								        		<c:when test="${roomOrder.payment == '4'}">
								        			刷卡支付
								        		</c:when>
								        	</c:choose>
								        </td>
								        <td class="center">
											<%-- <c:choose>
								        		<c:when test="${roomOrder.status == '1'}">
								        			<button class="button">付款并入住</button>
								        		</c:when>
								        		<c:when test="${roomOrder.status == '2'}">
								        			<button class="button">入住</button>
								        		</c:when>
								        		<c:when test="${roomOrder.status == '5'}">
								        			<button class="button">退房</button>
								        			<button class="button">修改入住信息</button>
								        		</c:when>
								        	</c:choose> --%>
								        	<a href="./editRoom?roomId=${room.roomId}" >编辑</a>
								        	<a href="./roomEditPriceCalendar?roomId=${room.roomId}" >修改价格</a>
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
        
    });
    
    </script>
</body>


</html>
