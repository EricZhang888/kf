<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="cn">
<head>
	<meta charset="UTF-8">
	
	<div>
		<form>
			房东姓名:<input type="text" name="holderName" value="${room.tbRoomHolder.name}"><br/><br/>
			房东电话:<input type="text" name="holderPhone" value="${room.tbRoomHolder.mobile}"><br/><br/>
			房间设施:
				<c:forEach items="${amenity}" var="obj">
				
					<c:forEach items="${room.tbRoomAmenities}" var="rooms">
						
					</c:forEach>
						<input type="checkbox" name="amenities1" value="${obj.amenityName}" "${obj.amenitiesId == rooms.amenitiesId ? 'checked':''}">${obj.amenityName}
					
				</c:forEach>
				<br/><br/>
				
			房源图片:<input type="image" src="../img/fang/1546845454857489764/xj78sfff.jpg" align="top" width="300" height="300">
		</form>	
	</div>
	
</head>
<body>
	
</body>
</html>