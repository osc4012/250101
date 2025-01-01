<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="/resources/js/test1.js"></script>
</head>
<script>
	// jQuery를 이용한 DOM 조작
	$(document).ready(function() {
		$("#btn").click(test1);
	});
	const test1=()=>{
	    const id = $("#id").val();
	    const pw = $("#pw").val();
	    
		console.log(`${id} ${pw}`);
		
		$.ajax({
		    url: '/test1Ajax',       // 요청을 보낼 URL
		    type: 'GET',          // 요청 방식 (GET, POST, PUT, DELETE 등)
		    dataType: 'json',     // 서버에서 응답받을 데이터 형식 (json, text, html 등)
		    data: {               // 서버로 보낼 데이터 (옵션)
		        id: id,
		        pw: pw
		    },
		    success: res => {   // 요청이 성공했을 때 호출되는 함수
		        console.log('서버 응답:', res);
		        if(res?.error) alert(res.error);
		    },
		    error: function(xhr, status, error) {   // 요청이 실패했을 때 호출되는 함수
		        console.error('요청 실패:', xhr, status, error);
		    }
		});
	}
</script>
<body>
	<div>
		id<input id="id">
	</div>
	<div>
		pw<input type="password" id="pw">
	</div>
	<div>
		<button id="btn" type="button">버튼</button>
	</div>
</body>
</html>