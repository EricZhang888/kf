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
                            <form action="<%=request.getContextPath() %>/roomHolder/queryRoomHolder" method="POST">
                            	<!-- <input class="" type="hidden" name="sort" value="roomCreateTime,desc"> -->
                                <div class="input-group">
                                	<div class="col-sm-4">
										<input type="text" placeholder="姓名" name="holderName" class="form-control input-lg">
                                	</div>
                                	<div class="col-sm-4">
                                    <input type="text" placeholder="联系电话" name="holderMobile" class="col-md-4 form-control input-lg">
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
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 177px;">房东姓名</th>
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-sort="ascending" style="width: 216px;">身份证号</th>
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 196px;">房东电话</th>
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 127px;">房东邮箱</th>
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 127px;">银行账号</th>
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 200px;">开户行</th>
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 200px;">支行名称</th>
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 200px;">状态</th>
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 200px;">操作</th>
							      </tr>
							    </thead>
							    <tbody>
								    <c:forEach items="${list}" var="holder">
								    
								    	<tr class="gradeA odd">
									        <td class="">${holder.name }</td>
									        <td class="sorting_1">${holder.idNum }</td>	
									       	<td class="">${holder.mobile}</td>
									        <td class="center">${holder.email}</td>
									        <td class="center">${holder.bankNum}</td>
									        <td class="center">${holder.bankName}</td>
									        <td class="center">${holder.bankSite}</td>
									        <td class="center">
												<c:choose>
								        		<c:when test="${holder.status == '0'}">
								        			合作中
								        		</c:when>
								        		<c:when test="${holder.status == '1'}">
								        			停止合作
								        		</c:when>
								        	</c:choose>
											</td>
									        <td class="center"><a href="#">房源</a> <a href="./editRoomHolder?holderId=${holder.id }">修改</a></td>
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
        	"pages": 5,
        	"sort": false,
        	"serverSide":true
        });
        //var oTable = $("#editable").dataTable();
        
    });
    
    </script>
</body>


</html>
