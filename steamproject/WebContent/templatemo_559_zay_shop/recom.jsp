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
</head>
<body>
	 <nav class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block" id="templatemo_nav_top">
                <div class="container text-light">
              		<div>
              		</div>
                	<div>
                		<button class="btn btn-success" type="button" onclick="location.href='join.jsp' ">회원가입</button>
                		<button class="btn btn-success" type="button" onclick="location.href='login.jsp' ">로그인</button>
                	</div>
                </div>
    </nav>
    <!-- Close Top Nav -->


    <!-- Header -->
    <nav class="navbar navbar-expand-lg navbar-light shadow">
        <div class="container d-flex justify-content-between align-items-center">

            <a class="navbar-brand text-success logo h1 align-self-center" href="mainPage.jsp">
                SUGE
            </a>

            <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#templatemo_main_nav" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>


            <div class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between" id="templatemo_main_nav">
                <div class="flex-fill">
                    <ul class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
                       <li class="nav-item">
                            <a class="nav-link" href="recom.jsp" >추천</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="categoryMain.jsp" >카테고리</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="popChart.jsp" >인기순위</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="board.jsp" >게시판</a>
                        </li>
                    </ul>
                </div>
                    <input type= "text" name = "search" placeholder = "게임 검색"> 
                    	<a class="nav-icon d-none d-lg-inline" href="" data-bs-toggle="modal" >
                        	<i class="fa fa-fw fa-search text-dark mr-2"></i>
                    	</a>

                </div>
            </div>

    </nav><br><br>
        <div class="row text-center pt-3">
            <div class="col-lg-6 m-auto">
                <h1 class="h1">게임 추천이에용</h1>
                <p>
                    20개 골라야함
                </p>
            </div>
        </div>
        <div class="row">
            
            <div class="col-12 col-md-4 p-5 mt-3" align="center">
                <img src="./assets/img/3.jpg" class="rounded-circle img-fluid border">
                <h2 class="h5 text-center mt-3 mb-3">Accessories</h2>
                <p class="text-center"><button class="btn btn-success">선택</button></p>
            </div>
            <div class="col-12 col-md-4 p-5 mt-3" align="center">
                <img src="./assets/img/3.jpg" class="rounded-circle img-fluid border">
                <h2 class="h5 text-center mt-3 mb-3">Accessories</h2>
                <p class="text-center"><button class="btn btn-success">선택</button></p>
            </div>
            <div class="col-12 col-md-4 p-5 mt-3" align="center">
                <img src="./assets/img/3.jpg" class="rounded-circle img-fluid border">
                <h2 class="h5 text-center mt-3 mb-3">Accessories</h2>
                <p class="text-center"><button class="btn btn-success">선택</button></p>
            </div>
            <div class="col-12 col-md-4 p-5 mt-3" align="center">
                <img src="./assets/img/3.jpg" class="rounded-circle img-fluid border">
                <h2 class="h5 text-center mt-3 mb-3">Accessories</h2>
                <p class="text-center"><button class="btn btn-success">선택</button></p>
            </div>
            <div class="col-12 col-md-4 p-5 mt-3" align="center">
                <img src="./assets/img/3.jpg" class="rounded-circle img-fluid border">
                <h2 class="h5 text-center mt-3 mb-3">Accessories</h2>
                <p class="text-center"><button class="btn btn-success">선택</button></p>
            </div>
            <div class="col-12 col-md-4 p-5 mt-3" align="center">
                <img src="./assets/img/3.jpg" class="rounded-circle img-fluid border">
                <h2 class="h5 text-center mt-3 mb-3">Accessories</h2>
                <p class="text-center"><button class="btn btn-success">선택</button></p>
            </div>
            <div class="col-12 col-md-4 p-5 mt-3" align="center">
                <img src="./assets/img/3.jpg" class="rounded-circle img-fluid border">
                <h2 class="h5 text-center mt-3 mb-3">Accessories</h2>
                <p class="text-center"><button class="btn btn-success">선택</button></p>
            </div>
            <div class="col-12 col-md-4 p-5 mt-3" align="center">
                <img src="./assets/img/3.jpg" class="rounded-circle img-fluid border">
                <h2 class="h5 text-center mt-3 mb-3">Accessories</h2>
                <p class="text-center"><button class="btn btn-success">선택</button></p>
            </div>
            <div class="col-12 col-md-4 p-5 mt-3" align="center">
                <img src="./assets/img/3.jpg" class="rounded-circle img-fluid border">
                <h2 class="h5 text-center mt-3 mb-3">Accessories</h2>
                <p class="text-center"><button class="btn btn-success">선택</button></p>
            </div>
            <div class="col-12 col-md-4 p-5 mt-3" align="center">
                <img src="./assets/img/3.jpg" class="rounded-circle img-fluid border">
                <h2 class="h5 text-center mt-3 mb-3">Accessories</h2>
                <p class="text-center"><button class="btn btn-success">선택</button></p>
            </div>
            <div class="col-12 col-md-4 p-5 mt-3" align="center">
                <img src="./assets/img/3.jpg" class="rounded-circle img-fluid border">
                <h2 class="h5 text-center mt-3 mb-3">Accessories</h2>
                <p class="text-center"><button class="btn btn-success">선택</button></p>
            </div>
            <div class="col-12 col-md-4 p-5 mt-3" align="center">
                <img src="./assets/img/3.jpg" class="rounded-circle img-fluid border">
                <h2 class="h5 text-center mt-3 mb-3">Accessories</h2>
                <p class="text-center"><button class="btn btn-success">선택</button></p>
            </div>
            
        </div>
        <div align="center">
        	<button class="btn btn-success" style="width:200px;height:50px">원하는 게임 찾기</button>
        </div>
        <br><br>
    </section>
    
    <!-- Start Footer -->
    <footer class="bg-dark" id="tempaltemo_footer">
        <div class="container">
            <div class="row right" >

                <div class="col-md-4 pt-5" >
                    <h2 class="h2 text-success border-bottom pb-3 border-light logo">SUGE</h2>
                    <ul class="list-unstyled text-light footer-link-list">
                        <li>
                            <i class="fas fa-map-marker-alt fa-fw"></i>
                            광주광역시 남구 송암동 CGI센터
                        </li>
                        <li>
                            <i class="fa fa-phone fa-fw"></i>
                            <a class="text-decoration-none" href="tel:010-020-0340">010-0000-0000</a>
                        </li>
                        <li>
                            <i class="fa fa-envelope fa-fw"></i>
                            <a class="text-decoration-none" href="mailto:info@company.com">suge@suge.com</a>
							<br><br><br><br>
                        </li>
                    </ul>
                </div>
                <!-- <div class="col-md-4 pt-5">
                    <h2 class="h2 text-light border-bottom pb-3 border-light">Index</h2>
                    <ul class="list-unstyled text-light footer-link-list">
                        <li><a class="text-decoration-none" href="#">추천</a></li>
                        <li><a class="text-decoration-none" href="#">카테고리</a></li>
                        <li><a class="text-decoration-none" href="#">인기순위</a></li>
                        <li><a class="text-decoration-none" href="#">게시판</a></li>
                       
                    </ul>
                </div>  -->

                

            </div>

            <div class="row text-light mb-4">
                <div class="col-12 mb-3">
                    <div class="w-100 my-3 border-top border-light"></div>
                </div>
                 </div>
                <div class="col-auto me-auto">
                    <ul class="list-inline text-left footer-icons">
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank" href="http://facebook.com/"><i class="fab fa-facebook-f fa-lg fa-fw"></i></a>
                        </li>
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank" href="https://www.instagram.com/"><i class="fab fa-instagram fa-lg fa-fw"></i></a>
                        </li>
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank" href="https://twitter.com/"><i class="fab fa-twitter fa-lg fa-fw"></i></a>
                        </li>
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank" href="https://www.linkedin.com/"><i class="fab fa-linkedin fa-lg fa-fw"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="w-100 bg-black py-3">
            <div class="container">
                <div class="row pt-2">
                    <div class="col-12">
                        <p class="text-left text-light">
                            Suggest Steam Games &copy; 2021 SUGE 
                            | Designed by <a rel="sponsored" href="#" target="_blank">SUGE</a>
                        </p>
                    </div>
                </div>
            </div>
        </div>

    </footer>
    <!-- End Footer -->    
    
    



    <!-- Start Script -->
    <script src="assets/js/jquery-1.11.0.min.js"></script>
    <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="assets/js/bootstrap.bundle.min.js"></script>
    <script src="assets/js/templatemo.js"></script>
    <script src="assets/js/custom.js"></script>
    <!-- End Script -->
    
    <script src="assets/js/jquery-1.11.0.min.js"></script>
    <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="assets/js/bootstrap.bundle.min.js"></script>
    <script src="assets/js/templatemo.js"></script>
    <script src="assets/js/custom.js"></script>
    
</body>
</html>