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
                            <form action="<%=request.getContextPath() %>/room/availableRoomOffline" method="POST">
                            	<input class="" type="hidden" name="sort" value="roomCreateTime,desc">
                                <div class="input-group">
                                        <label class="col-sm-1 control-label">入住日期:</label>
                                        <div class="col-sm-3">
                                            <input id="checkIn" class="laydate-icon form-control layer-date" name="checkinDate">
                                        </div>
                                    
                                        <label class="col-sm-1 control-label">退房日期:</label>
                                        <div class="col-sm-3">
                                            <input id="checkOut" class="laydate-icon form-control layer-date" name="checkoutDate">
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
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 127px;">价格</th>
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 127px;">状态</th>
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 200px;">操作</th>
							      </tr>
							    </thead>
							    <tbody>
								    <c:forEach items="${rooms}" var="room">
								    
								    	<c:set value="${ fn:split(room.roomImages, ',') }" var="images" />
										
								    	<tr class="gradeA odd">
								        <td class=""><img alt="" height="138" width="190" 
								        src="../img/fang/${room.roomId}/${images[0]}">
								        </td>
										
								        <td class="sorting_1">${room.roomApartment.apartmentName}·${room.roomBuilding}·${room.roomFloor}层·${room.roomNumber}</td>	
								       <td class="">${room.tbRoomHolder.name}</td>
								        <td class="center">${room.tbRoomHolder.mobile}</td>
								        <td class="center">
								        	
								        	挂牌价：${room.roomBasicPrice}<br>
								        	正常价：${room.roomPrice}<br>
								        </td>
								        <td class="center">
								        	
								        </td>
								        <td class="center">
								        	<a href="./orderOffline?roomId=${room.roomId}&beginDate=${beginDate}&endDate=${endDate}" >办理入住</a>
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
    <script src="<%=request.getContextPath() %>/resource/javascript/plugins/layer/laydate/laydate.js"></script>
    <script>
    $(document).ready(function() {
        $(".dataTables-example").dataTable({
        	"pages": 20,
        	"sort": false
        });
    });
    
    </script>
    <script>
        laydate({elem:"#checkIn",event:"focus"});laydate({elem:"#checkOut",event:"focus"});var start={elem:"#start",format:"YYYY/MM/DD hh:mm:ss",min:laydate.now(),max:"2099-06-16 23:59:59",istime:true,istoday:false,choose:function(datas){end.min=datas;end.start=datas}};var end={elem:"#end",format:"YYYY/MM/DD hh:mm:ss",min:laydate.now(),max:"2099-06-16 23:59:59",istime:true,istoday:false,choose:function(datas){start.max=datas}};laydate(start);laydate(end);
    </script>
</body>


</html>
