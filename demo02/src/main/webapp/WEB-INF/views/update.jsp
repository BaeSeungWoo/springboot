<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="include/header.jsp"%>      
<div class="container">
<input type = "hidden" id = "num" name = "num" value = "${board.num}"/>
		<div class="form-group">
			<label for="title">제목 :</label> <input type="text"
				class="form-control" id="title" name="title" value = "${board.title}">
		</div>

		<div class="form-group">
			<label for="email">글쓴이 :</label> <input type="text"
				class="form-control" id="writer" name="writer" value = "${board.writer}">
		</div>
		<div class="form-group">
			<label for="content">내용 :</label>
			<textarea class="form-control" rows="5" id="content" name="content"></textarea>
		</div>
		    <button type="button" class="btn btn-primary" id = "btnModify">수정</button>	
</div>
<script>
$("#btnModify").click(function(){
	data = {
			"num" : $("#num").val,
			"title" : $("#title").val,
			"content" : $("#content").val,
	}
	$.ajax({
		type : "put",
		url : "/update",
		contentType : "application/json;charset=utf-8",
		data : JSON.stringify(data),
		success: function(resp){
			if(resp == success){
				alert("수정 성공")
				location = "/list"
			}
		}
	})
})
</script>