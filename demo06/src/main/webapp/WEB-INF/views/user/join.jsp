<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %>    
Id : <input type = "text" id = "username" name = "username"/><br/>
Password : <input type = "text" id = "password" name = "password"/><br/>
Email : <input type = "text" id = "email" name = "email"/><br/>
<button id = "btnJoin">submit</button>
<script>
$("#btnJoin").click(function(){
	data = {
			"username" : $("#username").val(),
			"password" : $("#password").val(),
			"email" : $("#email").val()
	}
	if(("#username").val == ""){
		alert("id를 입력해주세요.")
		return false;
	}
	if(("#password").val == ""){
		alert("password를 입력해주세요.")
		return false;
	}
	if(("#email").val == ""){
		alert("email을 입력해주세요.")
		return false;
	}
	$.ajax({
		type : "post",
		url : "/register",
		contentType : "application/json;charset=utf-8",
		data : JSON.stringify(data)
	})
	.done(function(resp){
		if(resp == "success"){
			alert("회원가입에 성공하셨습니다.")
			location.href = "/user/login"
		} else if(resp == "fail"){
			alert("아이디가 중복되었습니다.")
			$("#username").val("")
		}
		
	})
	.fail(function(){
		alert("회원가입에 실패하셨습니다.")
	})
})
</script>
