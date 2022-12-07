<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container">
	<table class="table table-hover">
		<tr>
			<th>글번호</th>
			<td>${view.num}</td>
			<th>조회 수</th>
			<td>${view.hitcount}</td>
		</tr>

		<tr>
			<th>작성자</th>
			<td>${view.user.username}</td>
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
	
	<c:if test = "${principal.user.username == view.user.username}">
	<div class = "form-group text-right">
	<button class = "btn btn-primary">수정</button>
	<button class = "btn btn-danger">삭제</button>
	</div>
	</c:if>
	
</div>