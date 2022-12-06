<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %>
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



	

