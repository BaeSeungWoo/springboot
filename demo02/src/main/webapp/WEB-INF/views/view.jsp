<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file = "include/header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
<input type = "hidden" value = "${view.num}" id = "num" name = "num">
	<table class="table table-hover">
		<tr>
			<th>글번호</th>
			<td>${view.num}</td>
			<th>조회 수</th>
			<td>${view.hitcount}</td>
		</tr>

		<tr>
			<th>작성자</th>
			<td>${view.writer}</td>
			<th>작성일</th>
			<td><fmt:formatDate value="${view.regdate}" pattern="yyyy-MM-dd" /></td>
		</tr>

		<tr>
			<th>글제목</th>
			<td colspan="3">${view.title}</td>
		</tr>
		<tr>
			<th>글내용</th>
			<td colspan="3">${view.content}</td>
		</tr>
		<tr>
			<th>댓글 조회수</th>
			<td colspan="3">${view.replycnt}</td>
		</tr>


	</table>
	<div class = "form-group text-right">
<button class="btn btn-primary" id="btnUpdate">수정</button>
	<button class="btn btn-secondary" id="delBtn">삭제</button>
</div>
</div>	

<br/>
<br/>
<div align = "center">
<textarea rows = "3" cols = "50" id = msg></textarea>
<button class = "btn btn-secondary btn-sm" id = "btnComment">댓글쓰기</button>
</div>
<br/>
<div id = "replyResult"></div>

<script>
// 댓글 리스트
function init(){
		$.ajax({
			type : "get",
			// url : "/reply/commentList/${view.num}"
			url : "/reply/commentList",
			data : {"bnum" : $("#num").val()}
		})
		.done( function(resp){
			var str = "<div class = 'container'>";
			str += "<table class = 'table table-hover'>";
			$.each(resp, function(key, val){
				str += "<tr>",
				str += "<td>" + val.userid + "</td>",
				str += "<td>" + val.content + "</td>",
				str += "<td>" + val.regdate + "</td>",
				str += "<td><a href = 'javascript:fdel("+val.cnum+")'>삭제</a></td></tr>"					
			})
			str += "</table>";
			str += "</div>";
			$("#replyResult").html(str);
			})		
}
// 댓글 삭제
function fdel(cnum){
	$.ajax({		
		type : "delete",
		url : "/reply/del/"+cnum	
	})
	.done(function(resp){
		alert(resp + "번 댓글 삭제 성공")
		init();
	})
	.fail(function(e){
		alert("댓글 삭제 실패")
	})
}

// 게시글 삭제
$("#delBtn").click(function(){
	if(confirm("정말 삭제할까요?") == false) return false;
	$.ajax({
		type : "delete",
		url : "/delete/${view.num}",
		success : function(resp){
			alert(resp + "번 글 삭제 성공")
			location.href = "/list"
		}
	})
})

// 게시글 수정 폼
$("#btnUpdate").click(function(){
	if(confirm("정말 수정할까요?")){
		location.href = "/update/${view.num}"
	}
})

// 댓글 삽입
$("#btnComment").click(function(){
	if($("#msg").val() == ""){
		alert("댓글을 입력해주세요")
		return false;
	}
	data = {
			"bnum" : $("#num").val(),
			"content" : $("#msg").val()
	}
	$.ajax({
		type : "post",
		url : "/reply/commentInsert",
		contentType : "application/json;charset=utf-8",
		data : JSON.stringify(data)
	})
	.done(function(resp){
		alert("댓글 추가 성공")
		init()
	})
	.fail(function(e){
		alert("댓글 추가 실패")
	})
})
init();
</script>

	

