<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src = "https://code.jquery.com//jquery-3.6.1.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>수정폼</h3>
id : <input type = "text" name = "id" id = "id" value="${member.id}" readonly = "readonly"/><br/>
Name : <input type = "text" name = "name" id = "name" value="${member.name}"/><br/>
Password : <input type = "text" name = "password" id = "password"/><br/>
Email : <input type = "text" name = "email" id = "email" value="${member.email}"/><br/>
Addr : <input type = "text" name = "addr" id = "addr" value="${member.addr}"/><br/>
memo : <textarea rows = "3" cols = "50" id = memo name = "memo"></textarea><br/>
<button type = "button" id = "btnUpdate">수정하기</button>
<script src = "/js/member.js"></script>
</body>
</html>