<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Courses Page</title>
</head>
<body>

	<h2>View to render courses data</h2>
	
	<table>
    <tr>
        <th>Name</th>
        <th>Summary</th>
    </tr>
    <c:forEach items="${courses}" var="course" varStatus="status">
        <tr>
            <td>${course.name}</td>
            <td>${course.summary}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>