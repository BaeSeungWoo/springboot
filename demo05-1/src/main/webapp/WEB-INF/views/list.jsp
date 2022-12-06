<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<script src = "https://code.jquery.com//jquery-3.6.1.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id = "memberDiv">
<c:forEach items = "${lists}" var = "member">
아이디 : ${member.id}<br/>
이름 : ${member.name}<br/>
주소 : ${member.addr}<br/>
이메일 : ${member.email}<br/>
<a href = "detail/${member.id}">상세보기</a><br/>
<button type = "button" onclick = "fundelete(${member.id})">삭제하기</button>
<button type = "button" class = "btnDel" data-mid = "${member.id}">삭제class</button><br/><br/>
</c:forEach>
</div>
<script>
var delfun = function(){
	$.ajax({
		type : "delete",
		url : "/delete/"+$(this).data("mid")
	})
	.done(function(resp){
		alert(resp + "번 삭제 성공")
		location.href = "/list"
	})
	.fail(function(e){
		alert("삭제실패")
	})
}
$("#memberDiv").on("click", ".btnDel",delfun)

/* $("#memberDiv").on("click", ".btnDel", function(){
	$.ajax({
		type : "delete",
		url : "/delete/"+$(this).data("mid")
	})
	.done(function(resp){
		alert(resp + "번 삭제 성공")
		location.href = "/list"
	})
	.fail(function(e){
		alert("삭제실패")
	})
}) */
function fundelete(id){
	$.ajax({
		type : "delete",
		url : "/delete/"+id
	})
	.done(function(resp){
		alert(resp + "번 삭제 성공")
		location.href = "/list"
	})
	.fail(function(e){
		alert("삭제실패")
	})
}
</script>
</body>
</html>