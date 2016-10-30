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
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="渲染引擎：激活排序列升序" style="width: 177px;">房源图</th>
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="浏览器：激活排序列升序" aria-sort="ascending" style="width: 216px;">房源信息</th>
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="平台：激活排序列升序" style="width: 196px;">联系人</th>
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="引擎版本：激活排序列升序" style="width: 127px;">联系人电话</th>
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="CSS等级：激活排序列升序" style="width: 127px;">付款信息</th>
							        <th  tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="平台：激活排序列升序" style="width: 200px;">操作</th>
							      </tr>
							    </thead>
							    <tbody>
							      <tr class="gradeA odd">
							        <td class="">Webkit</td>
							        <td class="sorting_1">Safari 1.2</td>
							        <td class="">OSX.3</td>
							        <td class="center">125.5</td>
							        <td class="center ">A</td>
							        <td class="center ">A</td>
							      </tr>
							    </tbody>
							  </table>
							  <div class="row">
							    <div class="col-sm-6">
							      <div class="dataTables_info" id="DataTables_Table_0_info" role="alert" aria-live="polite" aria-relevant="all">显示 1 到 1 项，共 1 项 </div>
							    </div>
							    <div class="col-sm-6">
							      <div class="dataTables_paginate paging_simple_numbers" id="DataTables_Table_0_paginate">
							        <ul class="pagination">
							          <li class="paginate_button previous disabled" aria-controls="DataTables_Table_0" tabindex="0" id="DataTables_Table_0_previous">
							            <a href="#">上一页</a></li>
							          <li class="paginate_button active" aria-controls="DataTables_Table_0" tabindex="0">
							            <a href="#">1</a></li>
							          <li class="paginate_button next disabled" aria-controls="DataTables_Table_0" tabindex="0" id="DataTables_Table_0_next">
							            <a href="#">下一页</a></li>
							        </ul>
							      </div>
							    </div>
							  </div>
						</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="<%=request.getContextPath() %>/resource/javascript/jquery.min.js?v=2.1.4"></script>
    <script src="<%=request.getContextPath() %>/resource/javascript/bootstrap.min.js?v=3.3.6"></script>
    <script src="<%=request.getContextPath() %>/resource/javascript/content.min.js?v=1.0.0"></script>
</body>


</html>
