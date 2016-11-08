<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>github trending 列表</p>
	
	<c:forEach items="${list }" var="t">
		<div>
			<div><span>标题:</span> <a href="https://github.com/${t.href }" target="_blank">${t.title }</a></div>
			<div><span>描述:</span> <span>${t.desc }</span> </div>
			<div><span>更新时间:</span> <span>${t.updated }</span> </div>
		</div>
	</c:forEach>

</body>
</html>