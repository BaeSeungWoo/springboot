<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %>    
<div class="container">
<form action = "/login" method = "post">
		<div class="form-group">
			<label for="username">ID :</label> 
			  <input type="text" class="form-control" id="username" name="username">
		</div>

		<div class="form-group">
			<label for="password">Pwd :</label> 
			  <input type="password" class="form-control" id="password" name="password">
		</div>
		    <button id = "btnLogin" class="btn btn-primary">로그인</button>
		    </form>
</div>
<!-- 로그인형태로 데이터를 보낼때는 json 형태로 데이터를 보내면 안됨. json으로 컨버트 되지 않음. -->
<script>
$("#btnLogin").click(function(){
		
	if($("#username").val() == ""){
		alert("아이디를 입력해주세요.")
		return false;
	}
	if($("#password").val() == ""){
		alert("비밀번호를 입력해주세요.")
		return false;
	}		
})
</script>