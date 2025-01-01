
const userListResult = res => {
    let userList = `
        <table border="1" style="width: 500px;">
            <tr style="background-color:gold;height:50px;">
                <th>번호</th>
                <th>아이디</th>
                <th>이름</th>
            </tr>`;
    
    if(0 === res.result.length) {
        userList += `
            <tr style="height:300px;">
                <td colspan="3">조회 결과 없음</td>
            </tr>
        </table>`;
    } else {
        let idx=0;
        let id;
        let pw;
        for(let i=0;i<res.result.length;i++) {
            idx++;
            userList +=`<tr>
                <td>${idx}</td>
                <td>${res.result[i].id}</td>
                <td>${res.result[i].name}</td>
            </tr>`
        }
        userList += `</table>`;
    }
    
    $("#total").html(`총 <b style="color:red;">${res.result.length}</b> 건`)
    $("#userList").html(userList);
};

const searchAjax = () => {
    const searchSelect = $("#searchSelect").val();
    const searchText = $("#searchText").val();
    
    $.ajax({
        url: '/userList',       // 요청을 보낼 URL
        type: 'GET',          // 요청 방식 (GET, POST, PUT, DELETE 등)
        data: {               // 서버로 보낼 데이터 (옵션)
            search_select: searchSelect,
            search_text: searchText
        },
        dataType: 'json',     // 서버에서 응답받을 데이터 형식 (json, text, html 등)
        success: res => {   // 요청이 성공했을 때 호출되는 함수
            userListResult(res);
        },
        error: function(xhr, status, error) {   // 요청이 실패했을 때 호출되는 함수
            console.error('요청 실패:', xhr, status, error);
        }
    });
}

const fnSignUp=()=>{
    const id = $("#signUpId").val();
    const pw = $("#signUpPw").val();
    const name = $("#signUpName").val();
    
    if(!idCheck) {
        $("#idCheckResult").html("중복체크");
        $("#idCheckResult").css('color','red');
        return;
    } 
    
    if(0 === pw.length) {
        $("#idCheckResult").html("비밀번호 입력하세요");
        $("#idCheckResult").css('color','red');
        $("#signUpPw").focus();
        return;
    }
    
    if(!confirm('회원가입?')) return;
    
    $.ajax({
        url: '/signUp',       // 요청을 보낼 URL
        type: 'POST',          // 요청 방식 (GET, POST, PUT, DELETE 등)
        data: {               // 서버로 보낼 데이터 (옵션)
            id: id,
            pw: pw,
            name: name
        },
        dataType: 'json',     // 서버에서 응답받을 데이터 형식 (json, text, html 등)
        success: res => {   // 요청이 성공했을 때 호출되는 함수
            if(1 === res) {
                alert('회원가입 성공');
                $("#signUpId").val('');
                $("#signUpPw").val('');
                $("#signUpName").val('');
                $("#signUpId").focus();
            } else {
                alert('회원가입 실패');
            }
        },
        error: function(xhr, status, error) {   // 요청이 실패했을 때 호출되는 함수
            console.error('요청 실패:', xhr, status, error);
        }
    });
}

const fnCheckId=()=>{
    const id = $("#signUpId").val();
    if(0 === id.length) {
        $("#idCheckResult").html("아이디 입력하세요");
        $("#idCheckResult").css('color','red');
        $("#signUpId").focus();
        return;
    }
    
    $.ajax({
        url: '/idCheck',       // 요청을 보낼 URL
        type: 'GET',          // 요청 방식 (GET, POST, PUT, DELETE 등)
        data: {               // 서버로 보낼 데이터 (옵션)
            id: id,
        },
        dataType: 'json',     // 서버에서 응답받을 데이터 형식 (json, text, html 등)
        success: res => {   // 요청이 성공했을 때 호출되는 함수
            if(0 === res.result) {
                idCheck = true;
                $("#idCheckResult").html("사용가능");
                $("#idCheckResult").css('color','green');
                $("#signUpPw").focus();
            } else {
                idCheck = false;
                $("#idCheckResult").html("사용불가");
                $("#idCheckResult").css('color','red');
            }
            if(res?.error) alert(res.error);
        },
        error: function(xhr, status, error) {   // 요청이 실패했을 때 호출되는 함수
            console.error('요청 실패:', xhr, status, error);
        }
    });
} 

const fnLogin=()=>{
    $("#area1").show();
    $("#area2").hide();
    $("#area3").hide();     
} 

const userListAjax=()=>{
    $("#area1").hide();
    $("#area2").hide();
    $("#area3").show();
    
    $.ajax({
        url: '/userList',       // 요청을 보낼 URL
        type: 'GET',          // 요청 방식 (GET, POST, PUT, DELETE 등)
        dataType: 'json',     // 서버에서 응답받을 데이터 형식 (json, text, html 등)
        success: res => {   // 요청이 성공했을 때 호출되는 함수
            userListResult(res);
        }
    })
}

const fnMenuSignUp=()=>{
    // $("#area2").load("/signUp");
    $("#area1").hide();
    $("#area2").show();
    $("#area3").hide();
}

const loginAjax=()=>{
    const id = $("#id").val();
    const pw = $("#pw").val();
    
    console.log(`${id} ${pw}`);
    
    $.ajax({
        url: '/login',       // 요청을 보낼 URL
        type: 'GET',          // 요청 방식 (GET, POST, PUT, DELETE 등)
        data: {               // 서버로 보낼 데이터 (옵션)
            id: id,
            pw: pw
        },
        dataType: 'json',     // 서버에서 응답받을 데이터 형식 (json, text, html 등)
        success: res => {   // 요청이 성공했을 때 호출되는 함수
            if(res.result > 0) {
                alert('로그인 성공');
            } else if(0 === res.result){
                alert('아이디 또는 비밀번호 확인');
            } else {
                alert(res.result);
            }
        },
        error: function(xhr, status, error) {   // 요청이 실패했을 때 호출되는 함수
            console.error('요청 실패:', xhr, status, error);
        }
    });
}