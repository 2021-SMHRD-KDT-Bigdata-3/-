<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Zay Shop - Product Listing Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/templatemo.css">
    <link rel="stylesheet" href="assets/css/custom.css">

    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="assets/css/fontawesome.min.css">
<!--
    
TemplateMo 559 Zay Shop

https://templatemo.com/tm-559-zay-shop

-->
</head>

<body>
    <!-- Start Top Nav -->
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
                <div class="navbar align-self-center d-flex">
                    <div class="d-lg-none flex-sm-fill mt-3 mb-4 col-7 col-sm-auto pr-3">
                        <div class="input-group">
                            <input type="text" class="form-control" id="inputMobileSearch" placeholder="Search ...">
                            <div class="input-group-text">
                                <i class="fa fa-fw fa-search"></i>
                            </div>
                        </div>
                    </div>
                    <input type= "text" name = "search" placeholder = "게임 검색"> 
                    <a class="nav-icon d-none d-lg-inline" href="" data-bs-toggle="modal" >
                        <i class="fa fa-fw fa-search text-dark mr-2"></i>
                    </a>
                </div>
            </div>

        </div>
    </nav>
    <!-- Close Header -->

    <!-- Modal -->
    <div class="modal fade bg-white" id="templatemo_search" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="w-100 pt-1 mb-5 text-right">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="" method="get" class="modal-content modal-body border-0 p-0">
                <div class="input-group mb-2">
                    <input type="text" class="form-control" id="inputModalSearch" name="q" placeholder="Search ...">
                    <button type="submit" class="input-group-text bg-success text-light">
                        <i class="fa fa-fw fa-search text-white"></i>
                    </button>
                </div>
            </form>
        </div>
    </div>



    <!-- Start Content -->
    <div class="container py-5">
        <div class="row">

            <div class="col-lg-3" >
                <!--<h1 class="h2 pb-4">카테고리</h1>-->
                <ul class="list-unstyled templatemo-accordion">
                    <li class="pb-3">
                        <a class="collapsed d-flex justify-content-between h3 text-decoration-none" href="category.jsp">
                            카테고리
                        </a>
                        <ul class="collapse show list-unstyled pl-3 action" >
                            <li><a class="text-decoration-none" href="#">액션</a></li>
                            <li><a class="text-decoration-none" href="#">RPG</a></li>
                            <li><a class="text-decoration-none" href="#">전략</a></li>
                            <li><a class="text-decoration-none" href="#">어드벤처 및 캐쥬얼</a></li>
                            <li><a class="text-decoration-none" href="#">시뮬레이션</a></li>
                            <li><a class="text-decoration-none" href="#">스포츠 및 레이싱</a></li>
                        </ul>
                    </li>
                    
                    
                </ul>
            </div>

            <div class="col-lg-9">
                <div class="row">
                    <div class="col-md-6">
                        <ul class="list-inline shop-top-menu pb-3 pt-1">
                            <li class="list-inline-item">
                                
                            </li>
                            <li class="list-inline-item">
                                
                            </li>
                            
                        </ul>
                    </div>
                    
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <div class="card mb-4 product-wap rounded-0">
                            <div class="card rounded-0">
                                <img class="card-img rounded-0 img-fluid" src="assets/img/1.jpg">
                               
                            </div>
                            <div class="card-body">
                                <a href="game-single.jsp" class="h3 text-decoration-none">게임이름</a>
                                
                                <div class="list-unstyled d-flex justify-content-center mb-1">
                                    <i>태그이름</i>
                                </div>
                                <p class="text-center mb-0">가격</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card mb-4 product-wap rounded-0">
                            <div class="card rounded-0">
                                <img class="card-img rounded-0 img-fluid" src="assets/img/1.jpg">
                               
                            </div>
                            <div class="card-body">
                                <a href="game-single.jsp" class="h3 text-decoration-none">게임이름</a>
                                
                                <div class="list-unstyled d-flex justify-content-center mb-1">
                                    <i>태그이름</i>
                                </div>
                                <p class="text-center mb-0">가격</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card mb-4 product-wap rounded-0">
                            <div class="card rounded-0">
                                <img class="card-img rounded-0 img-fluid" src="assets/img/1.jpg">
                               
                            </div>
                            <div class="card-body">
                                <a href="game-single.jsp" class="h3 text-decoration-none">게임이름</a>
                                
                                <div class="list-unstyled d-flex justify-content-center mb-1">
                                    <i>태그이름</i>
                                </div>
                                <p class="text-center mb-0">가격</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card mb-4 product-wap rounded-0">
                            <div class="card rounded-0">
                                <img class="card-img rounded-0 img-fluid" src="assets/img/1.jpg">
                               
                            </div>
                            <div class="card-body">
                                <a href="game-single.jsp" class="h3 text-decoration-none">게임이름</a>
                                
                                <div class="list-unstyled d-flex justify-content-center mb-1">
                                    <i>태그이름</i>
                                </div>
                                <p class="text-center mb-0">가격</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card mb-4 product-wap rounded-0">
                            <div class="card rounded-0">
                                <img class="card-img rounded-0 img-fluid" src="assets/img/1.jpg">
                               
                            </div>
                            <div class="card-body">
                                <a href="game-single.jsp" class="h3 text-decoration-none">게임이름</a>
                                
                                <div class="list-unstyled d-flex justify-content-center mb-1">
                                    <i>태그이름</i>
                                </div>
                                <p class="text-center mb-0">가격</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card mb-4 product-wap rounded-0">
                            <div class="card rounded-0">
                                <img class="card-img rounded-0 img-fluid" src="assets/img/1.jpg">
                               
                            </div>
                            <div class="card-body">
                                <a href="game-single.jsp" class="h3 text-decoration-none">게임이름</a>
                                
                                <div class="list-unstyled d-flex justify-content-center mb-1">
                                    <i>태그이름</i>
                                </div>
                                <p class="text-center mb-0">가격</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card mb-4 product-wap rounded-0">
                            <div class="card rounded-0">
                                <img class="card-img rounded-0 img-fluid" src="assets/img/1.jpg">
                               
                            </div>
                            <div class="card-body">
                                <a href="game-single.jsp" class="h3 text-decoration-none">게임이름</a>
                                
                                <div class="list-unstyled d-flex justify-content-center mb-1">
                                    <i>태그이름</i>
                                </div>
                                <p class="text-center mb-0">가격</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card mb-4 product-wap rounded-0">
                            <div class="card rounded-0">
                                <img class="card-img rounded-0 img-fluid" src="assets/img/1.jpg">
                               
                            </div>
                            <div class="card-body">
                                <a href="game-single.jsp" class="h3 text-decoration-none">게임이름</a>
                                
                                <div class="list-unstyled d-flex justify-content-center mb-1">
                                    <i>태그이름</i>
                                </div>
                                <p class="text-center mb-0">가격</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card mb-4 product-wap rounded-0">
                            <div class="card rounded-0">
                                <img class="card-img rounded-0 img-fluid" src="assets/img/1.jpg">
                               
                            </div>
                            <div class="card-body">
                                <a href="game-single.jsp" class="h3 text-decoration-none">게임이름</a>
                                
                                <div class="list-unstyled d-flex justify-content-center mb-1">
                                    <i>태그이름</i>
                                </div>
                                <p class="text-center mb-0">가격</p>
                            </div>
                        </div>
                    </div>
                    </div>
                </div>
                <div div="row">
                    <ul class="pagination pagination-lg justify-content-end">
                        <li class="page-item disabled">
                            <a class="page-link active rounded-0 mr-3 shadow-sm border-top-0 border-left-0" href="#" tabindex="-1">1</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 text-dark" href="#">2</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link rounded-0 shadow-sm border-top-0 border-left-0 text-dark" href="#">3</a>
                        </li>
                    </ul>
                </div>
            </div>

        </div>
    </div>
    <!-- End Content -->

 


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
</body>

</html>