<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="/resources/js/test1.js"></script>
</head>
<script>
let idCheck = false;
	// jQuery를 이용한 DOM 조작
	$(document).ready(function() {
		/* $("#btn").on('click',()=>{
		    loginAjax();  
		}) */
		$("#btn").click(loginAjax);
		$("#menuSignUp").click(fnMenuSignUp);
		$("#menuArea3").click(userListAjax);
		$("#menuLogin").click(fnLogin);
		$("#btnCheckId").click(fnCheckId);
		$("#btnSignUp").click(fnSignUp);
		$("#btnSeach").click(searchAjax)
		
		$("#id, #pw").keydown((e)=>{
            if(32 === e?.keyCode) e.preventDefault(); // 공백 입력을 차단
		    if(13 === e?.keyCode) loginAjax();
		})
		
		$("#signUpPw, #signUpName").keydown((e)=>{
		    if(32 === e?.keyCode) e.preventDefault(); // 공백 입력을 차단
		    if(13 === e?.keyCode) fnSignUp();
		})
		
		$("#searchText").keydown((e) => {
		    if(13 === e?.keyCode) searchAjax();
		})
		
		$("#id, #signUpId").keydown((e)=>{
            if(32 === e?.keyCode) e.preventDefault(); // 공백 입력을 차단
		    if(13 === e?.keyCode) loginAjax();
		})
	});
</script>
<body>
	<div>
		<div>
			<button id="menuLogin" type="button">로그인</button>
			<button id="menuSignUp" type="button">회원가입</button>
			<button id="menuArea3" type="button">회원목록</button>
		</div>
		<div id="area1">
			<h1>로그인</h1>
			<table>
				<tr>
					<td>id</td>
					<td><input id="id"></td>
				</tr>
				<tr>
					<td>pw</td>
					<td><input type="password" id="pw"></td>

				</tr>
				<tr>
					<td colspan="2">
						<button id="btn" type="button" style="width: 100%;">로그인</button>
					</td>
					<td></td>
				</tr>
			</table>
		</div>
		<div id="area2" style="display: none;">
			<h1>회원가입</h1>
			<p id="idCheckResult">아이디 입력 후 중복체크</p>
			<table>
				<tr>
					<td>id</td>
					<td><input id="signUpId">
						<button id="btnCheckId" type="button">중복체크</button></td>
				</tr>
				<tr>
					<td>pw</td>
					<td style="text-align: left;"><input type="password"
						id="signUpPw"></td>
					<td></td>
				</tr>
				<tr>
					<td>name</td>
					<td style="text-align: left;"><input id="signUpName"></td>
				</tr>
				<tr>
					<td colspan="2">
						<button id="btnSignUp" type="button" style="width: 100%;">회원가입</button>
					</td>
					<td></td>
				</tr>
			</table>
		</div>
		<div id="area3" style="display: none;">
			<h1>회원목록</h1>
			<div>
				<table>
					<tr>
						<td><span id="total"></span></td>
						<td><select id="searchSelect"
							style="width: 100px; height: 25px;">
								<option value="1">아이디</option>
								<option value="2">이름</option>
								<option value="3">임시2</option>
						</select></td>
						<td><input id="searchText" style="height: 20px;"></td>
						<td><button id="btnSeach" type="button" style="width: 100px;">검색</button>
				</table>
			</div>
			<div id="userList">
				<!-- <table border="1" style="width: 500px;">
					<tr style="background-color: gold;">
						<th>번호</th>
						<th>이름</th>
					</tr>
					<tr style="height: 300px;">
						<td colspan="3">조회 결과 없음</td>
					</tr>
				</table> -->
			</div>
		</div>
	</div>
</body>
</html>
<style>
div {
	text-align: center;
}

table {
	margin: 0 auto;
}

td {
	text-align: center;
}

button {
	cursor: pointer;
}
</style>