<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
detail<br/>
아이디 : ${member.id}<br/>
이름 : ${member.name}<br/>
주소 : ${member.addr}<br/>
이메일 : ${member.email}<br/><br/>
<a href = "/update/${member.id}">수정하기</a>

</body>
</html>