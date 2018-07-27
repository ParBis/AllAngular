<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.4.3/css/foundation.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>View Subjects</h2>
		
			<table>
				<tr>
					<th align="center">Id</th>
					<th align="left">Title</th>
					<th align="center">Duration Hours</th>
				</tr>
				<c:forEach items="${subjectList}" var="subject">
					<tr>
						<td align="center">${subject.subjectId}</td>
						<td align="left">${subject.subtitle}</td>
						<td align="center">${subject.durationInHours}</td>
					</tr>
				</c:forEach>
			</table>
	    	<br>
		
	</body>
</html>