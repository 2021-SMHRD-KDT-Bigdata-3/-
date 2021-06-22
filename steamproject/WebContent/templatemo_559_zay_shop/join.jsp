<%@page import="DTO.memberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="apple-touch-icon" href="assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/templatemo.css">
    <link rel="stylesheet" href="assets/css/custom.css">

    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="assets/css/fontawesome.min.css">
    <link rel="stylesheet" href="assets/css/font.css">
    <style>
    	
    </style>
<script src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
   	$("#id").keyup(function()){
    	var id = $.trim($(this).val());
    	//trim은 공백기능없어주는애.
    	$(this).val(id);
    	if(id.length < 4)
    		$("#idInfo").html("<span>아이디는 4글자 이상이어야 합니다.</span>")
    	else{
    		//서버에 아이디 중복 체크 하러 갔다온다.->url이 안바뀌게 ajax이용.
    		$("#idInfo").load("idCheck.jsp?id="+id);
    	}
    }
    
    </script>
</head>
<body>
	<% memberDTO dto = (memberDTO)session.getAttribute("member");
						
							%>
    <!-- Start Top Nav -->
    <nav class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block" id="templatemo_nav_top">
                <div class="container text-light">
              		<div>
              		</div>
                	<div>
                	<%
							if(dto != null){
										out.print("<h1>"+dto.getName()+  "님 환영해요~😉");
							}else{
								out.print("<h1>로그인이 필요합니다!</h1>");
							}
							%>
                		<%
								if(dto==null){
									//out.print("<button class='btn btn-success' type='button' onclick='location.href='join.jsp' '>회원가입</button>");
									//out.print("<button class='btn btn-success' type='button' onclick='location.href='join.jsp' '>회원가입</button>");
									%>
									<button class="btn btn-success" type="button" onclick="location.href='join.jsp' ">회원가입</button>
			                		<button class="btn btn-success" type="button" onclick="location.href='login.jsp' ">로그인</button>
								
								<% }else{
									if(dto.getId().equals("admin")){
										//out.print("<a href ='delete.jsp'>회원삭제</a>");%>
										<button class="btn btn-success" type="button" onclick="location.href='guestmanage.jsp' ">회원관리</button>
										<button class="btn btn-success" type="button" onclick="location.href='../logout' ">로그아웃</button>
									<%}else{
									//out.print("<a href='update.jsp'>개인정보수정</a>");
									//out.print("<a href='LogoutServiceCon.do'>로그아웃</a>");%>
									<button class="btn btn-success" type="button" onclick="location.href='../logout' ">로그아웃</button>
								
									<% }}
								%>
								
								
                		
                	</div>
                </div>
    </nav>
     <nav class="navbar navbar-expand-lg navbar-light shadow">
        <div class="container d-flex justify-content-between align-items-center">

            <a class="navbar-brand text-primary logo h1 align-self-center" href="mainPage.jsp">
                SUGE
            </a>

            <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#templatemo_main_nav" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

                <div class="navbar align-self-center d-flex">
                    <div class="d-lg-none flex-sm-fill mt-3 mb-4 col-7 col-sm-auto pr-3">
                        <div class="input-group">
                            <input type="text" class="form-control" id="inputMobileSearch" placeholder="Search ...">
                            <div class="input-group-text">
                                <i class="fa fa-fw fa-search"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </nav>
    <br>
    <div align="center">
		<form action = '../join' method = "post" >	   
		 
		    <h1 style="color:navy; font-weight: 900;">회원가입</h1>
		    <br>
		    	<h4 class="join_title" style="color:black; font-weight: 900;">
		    		아이디
		    	</h4>
		    		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    	<div>
			    	<input type="text" id= "id" name = "id" style="text-align:center; width:300px; height:30px; ">
		    		<br>
		    		<span id = "idInfo">아이디는 4글자 이상 입력해주세요.</span>
		    	</div><br>
		    	
		    	<h4 class="join_title" style="color:black; font-weight: 900;">
		    		비밀번호
		    	</h4>
		    	<div>
			    	<input type="password" name = "pw" style="text-align:center; width:300px; height:30px; ">
		    		<br>
		    		<span>(비밀번호 확인)</span>
		    		<br>
		    		<input type="password" name="pwdCheck"style="text-align:center; width:300px; height:30px; "> 
		    		<br>
		    		<span>(영문+숫자 4~12자리)</span>
		    	</div>
		    	<br>
		    	<h4 class="join_title" style="color:black; font-weight: 900;">
		    		이름
		    	</h4>
		    	<div>
			    	<input type="text" name = "name" style="text-align:center; width:300px; height:30px; ">
		    	</div>
		    	<br>
		    	
		    	<h4 class="join_title" style="color:black; font-weight: 900;">
		    		나이
		    	</h4>
		    	<div>
			    	<input type="text" name = "age" style="text-align:center; width:300px; height:30px; ">
		    	</div>
		    	<br>
		    	
		    	<h4 class="join_title" style="color:black; font-weight: 900;">
		    		성별
		    	</h4>
		    	<div>
					<select name = "gender" style="width:300px; height:30px; ">
						<option>남자</option>
						<option>여자</option>
					</select>
		    	</div>
		    	<br>
		    	
		    	<h4 class="join_title" style="color:black; font-weight: 900;">
		    		연락처
		    	</h4>
		    	<div>
			    	<input type="text" name = "tel" style="text-align:center; width:300px; height:30px; ">
		    	</div>
		    	<br>
		    	<input type = "submit" class="btn btn-success" value = "가입하기">
		   		
    	</form>
    	
    </div>
    
		
    	
    
    
</body>
</html>