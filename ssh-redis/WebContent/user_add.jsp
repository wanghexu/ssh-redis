<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.2.js"></script>

</head>	
<body>
<%-- 	<form action="${pageContext.request.contextPath}/customized_savecustomized.action" method="post">
	
		用户姓名：<input type="test" name="username">
		<!-- 用户openid -->
		userid：<input name="userid" type="text">
		<!-- 用户分数 -->	
		威信：<input name="weixin" type="text">
	
		<input type="submit" value="提交">
	</form> --%>
<%--  		<form action="${pageContext.request.contextPath}/customized_checkcustomized.action" method="post">
	
		<!-- 用户openid -->
		userid：<input name="userid" type="text">

	
		<input type="submit" value="提交">
	</form> --%>
<%--  		<form action="${pageContext.request.contextPath}/activity_getactbytypeid.action" method="post">
	
		<!-- 用户openid -->
		活动typeid：<input name="typeid" type="text">

	
		<input type="submit" value="提交">
	</form>  --%>
		<form action="${pageContext.request.contextPath}/activity_getactbyid.action" method="post">
	
		<!-- 用户openid -->
		活动id：<input name="activityid" type="text">

	
		<input type="submit" value="提交">
	</form>
</body>
</html>