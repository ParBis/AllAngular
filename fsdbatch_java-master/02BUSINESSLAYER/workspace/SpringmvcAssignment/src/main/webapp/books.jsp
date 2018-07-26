<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.4.3/css/foundation.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script>
		/* function submitFormJavaScript(var bookId) {
			alert(bookId);
		    document.getElementById('multiCheckBox').action = "/SubBookController/book";
		    document.getElementById('multiCheckBox').submit();
		} */
		</script>
	</head>
	<body>
		<h4>View Subjects and Books</h4>
		<h4>${message}</h4>
		
			<table>
			<tr><td colspan="9" align="right" style="font-size: 14px">
				<a href="<c:url value="/openAddBooks" />">Add Book and Subject</a>
			</td></tr>
				<tr>
					<th align="center">Sub Id</th>
					<th align="left">Sub Title</th>
					<th align="center">Duration Hours</th>
					<th align="center">Book Id</th>
					<th align="left">Book Title</th>
					<th align="center">Price</th>
					<th align="center">Volume</th>
					<th align="center">Publish Date</th>
					<th align="center">Actions</th>
				</tr>
				<c:forEach items="${bookList}" var="book">
					<tr>
						<td align="center">${book.subject.subjectId}</td>
						<td align="left">${book.subject.subtitle}</td>
						<td align="center">${book.subject.durationInHours}</td>
						
						<td align="center">${book.bookId}</td>
						<td align="left">${book.title}</td>
						<td align="center">${book.price}</td>
						<td align="center">${book.volume}</td>
						<td align="center">${book.publishDate}</td>
						<td align="center">
							<a href="<c:url value="/book/${book.bookId}" />">Edit</a> / <a href="<c:url value="/removeBook/${book.bookId}" />">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
	    	<br>
		
	</body>
</html>