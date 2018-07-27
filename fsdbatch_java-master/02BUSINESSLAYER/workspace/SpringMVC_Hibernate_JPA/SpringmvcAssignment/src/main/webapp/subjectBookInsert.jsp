<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${message == 'edit'}">
		<h4>Edit Book Details</h4>
	</c:if>
	<c:if test="${message == 'add'}">
		<h4>Add Book Details</h4>
	</c:if>
	
	<c:if test="${message == 'edit'}">
		<form action="/SpringmvcAssignment/updatesubject" method="put">
	</c:if>
	<c:if test="${message == 'add'}">
		<form action="subject" method="post">
	</c:if>
		<table>
			<tr>
				<td colspan="8" align="right" style="font-size: 14px">
					<a href="<c:url value="/books" />">Back</a>
				</td>
			</tr>
			<tr>
				<td>Subject Title</td><td><input type="text" name="subtitle" value="${subtitle}"/></td>
				<td>Duration in Hours</td><td><input type="number" name="durationInHours" value="${durationInHours}"/></td>
			</tr>
			<tr>
				<td>Book</td><td><input type="text" name="title" value="${title}"/></td>
				<td>Price</td><td><input type="number" name="price" value="${price}"/></td>
				<td>Volume</td><td><input type="number" name="volume" value="${volume}"/></td>
				<td>Publish Date</td><td><input type="Date" name="publishDate" value="${publishDate}"/></td>
			</tr>
			<tr>
				<c:if test="${message == 'edit'}">
					<td colspan="8"><button type="submit">Edit Book</button></td>
				</c:if>
				<c:if test="${message == 'add'}">
					<td colspan="8"><button type="submit">Add Book</button></td>
				</c:if>
			</tr>
			<input type="hidden" name="bookId" value="${bookId}"/>
			<input type="hidden" name="subjectId" value="${subjectId}"/>
		</table>
	</form>
</body>
</html>
