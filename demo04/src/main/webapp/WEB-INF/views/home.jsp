<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "include/header.jsp" %>
<sec:authorize access = "isAnonymous()">
<a href = "/login">로그인</a>
</sec:authorize>
<sec:authorize access = "isAuthenticated()">
<a href = "/logout">로그아웃</a><br/>
principal : <sec:authentication property="principal"/><br/>
사용자 ID : <sec:authentication property="principal.username"/><br/>
사용자 이름 : <sec:authentication property="principal.member.username"/><br/>
사용자 권한 : <sec:authentication property="principal.member.authList"/><br/>
<hr>
Member : <sec:authentication property="principal.member"/><br/>
</sec:authorize>