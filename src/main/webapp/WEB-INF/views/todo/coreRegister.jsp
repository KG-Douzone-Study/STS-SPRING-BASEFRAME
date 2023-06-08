<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
</head>
<body>

<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  --%>
<!-- 스프링 프레임워크의 JSP 기술중에 form taglib가 있다. -->
<!-- form 태그라이브러리를 사용하면 HTML 폼에 데이터를 바인딩하거나 에러메시지 처리등을 간편하게 할 수 있다. -->

	<form action="/todo/register" method="post">
		<div>
			Title : <input type="text" name="title" >
		</div>	
		<div>
			DueDate: <input type="date" name="dueDate" value="2022-12-25" >
		</div>
		<div>
			Writer : <input type="text" name="writer" >
		</div>
		<div>
			Finished : <input type="checkbox" name="finished">
		</div>
		<div>
			<button type="submit">Register</button>
		</div>
	</form>
	
</body>
</html>