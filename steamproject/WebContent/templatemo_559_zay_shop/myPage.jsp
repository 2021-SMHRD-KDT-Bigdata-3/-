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
										<button class="btn btn-success" type="button" onclick="location.href='join.jsp' ">회원삭제</button>
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
            <a class="navbar-brand text-success logo h1 align-self-center" href="mainPage.jsp">
                SUGE
            </a>

        </div>

    </nav>
    <br>
    <div align = "center">
    <br>
    <br>
    <br>
    <br>
    <h1 style="color:#59ab6e;">MYPAGE</h1>
    <br>
    		<input type ="text" placeholder="현재 비밀번호">
    		<div>
    		<br>
    		</div>
    		<input type ="text" placeholder="변경할 비밀번호">
    		<div>
    		<br>
    		</div>
    		<input type ="text" placeholder="비밀번호 확인">
    		<div>
    		<br>
    		</div>
    		<button class="btn btn-success">비밀번호 변경</button>
    		<br>
    		<br>
    		<button class="btn btn-success">회원 탈퇴</button>
    </div>
    <script src="assets/js/jquery-1.11.0.min.js"></script>
    <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="assets/js/bootstrap.bundle.min.js"></script>
    <script src="assets/js/templatemo.js"></script>
    <script src="assets/js/custom.js"></script>
    
</body>
</html>