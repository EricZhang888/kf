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
        
        $("#submit").on("click", function(){
        	$("#roomHolderForm").submit();
        });
        
        $("#goback").on("click", function(){
			history.back();
		});
    });
    
    </script>

	<div class="" id="myModal5">
		<div class="modal-dialog">
			<div class="modal-content animated fadeIn">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<!-- <span aria-hidden="true">×</span><span class="sr-only">Close</span> -->
					</button>
					
					<h4 class="modal-title">房东管理</h4>
				</div>
				<form action="<%=request.getContextPath() %>/roomHolder/saveOrUpdateHolder" id="roomHolderForm" method="post">
					<input type="hidden" name="holderId" value="${holder.id}"/>
					<div class="modal-body">
							<div class="form-group">
								<label>房东姓名： </label> 
								<input type="text" class="form-control" name="fdName" value="${holder.name}" placeholder="">
							</div>
							<div class="form-group">
								<label>身份证号： </label> 
								<input type="text" class="form-control" name="idNum" value="${holder.idNum}" placeholder="">
							</div>
							<div class="form-group">
								<label>房东电话： </label> 
								<input type="text" class="form-control" name="mobile" value="${holder.mobile}" placeholder="">
							</div>
							<div class="form-group">
								<label>房东邮箱： </label> 
								<input type="text" class="form-control" name="email" value="${holder.email}" placeholder="">
							</div>
							<div class="form-group">
								<label>银行账号： </label> 
								<input type="text" class="form-control" name="bankNum" value="${holder.bankNum}" placeholder="">
							</div>
							<div class="form-group">
								<label>银行名称： </label> 
								<input type="text" class="form-control" name="bankName" value="${holder.bankName}" placeholder="">
							</div>
							<div class="form-group">
								<label>支行名： </label> 
								<input type="text" class="form-control" name="bankSite" value="${holder.bankSite}" placeholder="">
							</div>
							<div class="form-group">
								<label>状态：</label> 
								<select class="form-control" name="status">
									<option value="0" ${holder.status==0 ? 'selected':''}>合作中</option>
									<option value="1" ${holder.status==1 ? 'selected':''}>停止合作</option>
    							</select>
							</div>
					</div>
					<div class="modal-footer">
						<c:if test="${holder.id != ''}">
							<button type="button" class="btn btn-white" data-dismiss="modal" id="goback">返回</button>
						</c:if>
						<button type="submit" class="btn btn-primary" id="submit">保存</button>
					</div>
				</form>
			</div>
			<small> </small>
		</div>
		<small> </small>
	</div>
</body>


</html>
