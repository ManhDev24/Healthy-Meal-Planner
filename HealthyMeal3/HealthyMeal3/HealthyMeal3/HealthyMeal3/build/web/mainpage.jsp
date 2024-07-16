<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : mainpage
    Created on : Jun 29, 2024, 3:34:32 PM
    Author     : NC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
<html lang="en">
    <head>
        <title>Title</title>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

        <!-- Font Awesome -->
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
            integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />

        <!-- Bootstrap CSS -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous"
            />

        <!-- Custom CSS -->
        <link rel="stylesheet" href="./asset/mainpage.css" />

        <!-- Owl Carousel CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css" />
        <!--slick-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.min.css" integrity="sha512-17EgCFERpgZKcm0j0fEq1YCJuyAWdz9KUtv1EjVuaOz8pDnh/0nZxmU6BBXwaaxqoi9PQXnRWqlcDB027hgv9A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.css" integrity="sha512-wR4oNhLBHf7smjy0K4oqzdWumd+r5/+6QO/vDda76MW5iug4PT7v86FoEkySIJft3XA0Ae6axhIvHrqwm793Nw==" crossorigin="anonymous" referrerpolicy="no-referrer" />        <style>
            .container {
                max-width: 1300px;
            }
            .item {
                margin-right:  10px; /* Add margin between items */
            }

            .card {
                border-radius: 15px; /* Add border radius to the cards */
                overflow: hidden; /* Ensure the border radius is applied to the images */
            }

            .card img {
                border-top-left-radius: 15px; /* Match card's border radius */
                border-top-right-radius: 15px; /* Match card's border radius */
            }
            .slick-prev, .slick-next{
                z-index: 2;

            }
            .slick-next:before, .slick-prev:before {
                font-size: 25px
            }
            .slick-prev{
                left: 25px;
            }
            .slick-next{
                right: 25px
            }
            .dishName, .dishImg {
                text-decoration: none;
                color: black;
            }

            .dishName:hover, .dishImg:hover {
                color: red;
                text-decoration: none;
                list-style: none;
            }
        </style>
    </head>

    <body>
        <div class="container">

            <div class="carouse-banner">
                <div><a href="MainController?action=foodct">
                        <img src="./asset/img/banner1.png" class="d-block w-100" alt="Slide 1" loading="lazy">
                    </a></div>
                <div>
                    <a href="MainController?action=foodct">
                        <img src="./asset/img/banner2.png" class="d-block w-100" alt="Slide 2" loading="lazy">

                    </a>
                </div>
                <div>
                    <a href="MainController?action=foodct">
                        <img src="./asset/img/banner3.png" class="d-block w-100" alt="Slide 3" loading="lazy">
                    </a>
                </div>
                <div>
                    <a href="MainController?action=foodct">
                        <img src="./asset/img/banner4.png" class="d-block w-100" alt="Slide 4" loading="lazy">
                    </a>
                </div>
                <div>
                    <a href="MainController?action=foodct">
                        <img src="./asset/img/banner5.png" class="d-block w-100" alt="Slide 5" loading="lazy">
                    </a>
                </div>
                <div>
                    <a href="MainController?action=foodct">
                        <img src="./asset/img/banner6.png" class="d-block w-100" alt="Slide 6" loading="lazy">
                    </a>
                </div>
            </div>


            <div class="dish m-4">
                <h3 class="title">Lunch</h3>
                <div class="owl-carousel owl-theme">
                    <c:forEach var="dish" items="${requestScope.lunch}">
                        <div class="item">
                            <div class="card dishImg" style="width: 18rem">

                                <a  href="MainController?action=dishDetail&did=${dish.id}" >
                                    <img style="height: 286px; object-fit: cover;object-position: center;background-size: cover" src="${dish.imgurl}" class="card-img-top img-fluid" alt="...">
                                </a>
                                <div class="card-body" >
                                    <a class="dishName" href="MainController?action=dishDetail&did=${dish.id}" style="text-decoration: none">
                                        <h5 class="card-title">${dish.name}</h5>
                                    </a>

                                    <div style="height: 50px"><p class="card-text">${dish.decreption}</p></div>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div style="font-size: 26px; font-weight: 600; line-height: 20px; color: #e30019;">${dish.price}$</div>
                                        
                                        <div class="d-flex">
                                            <a style="color: white; margin-right: 10px;" href="WishListServlet?action=add&did=${dish.id}">
                                                <div class="text-center rounded-circle bg-danger" style="padding: 6px; height: 36px; width: 36px; cursor: pointer;">
                                                    <i class="fa fa-heart"></i>
                                                </div>
                                            </a>
                                            <a style="color: white;" href="MainController?action=addDish&did=${dish.id}&quantity=1">
                                                <div class="text-center rounded-circle bg-danger" style="padding: 6px; height: 36px; width: 36px; cursor: pointer;">
                                                    <i class="fa fa-shopping-cart"></i>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <div class="m-4">
                <h3 class="title">Dinner</h3>
                <div class="owl-carousel owl-theme" id="carousel_2">
                    <c:forEach var="dish" items="${requestScope.dinner}">
                        <div class="item">
                            <div class="card dishImg" style="width: 18rem;">
                                <a href="GetDishDetail?did=${dish.id}" style="text-decoration: none">
                                    <img style="height: 286px;" src="${dish.imgurl}" class="card-img-top" alt="...">
                                </a>
                                <div class="card-body" >
                                    <a class="dishName" href="GetDishDetail?did=${dish.id}">
                                        <h5 class="card-title">${dish.name}</h5>
                                    </a>
                                    <div style="height: 50px"><p class="card-text">${dish.decreption}</p></div>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div style="font-size: 26px; font-weight: 600; line-height: 20px; color: #e30019;">${dish.price}$</div>
                                        <div class="d-flex">
                                            <a style="color: white; margin-right: 10px;" href="WishListServlet?action=add&did=${dish.id}">
                                                <div class="text-center rounded-circle bg-danger" style="padding: 6px; height: 36px; width: 36px; cursor: pointer;">
                                                    <i class="fa fa-heart"></i>
                                                </div>
                                            </a>
                                            <a style="color: white;" href="MainController?action=addDish&did=${dish.id}&quantity=1">
                                                <div class="text-center rounded-circle bg-danger" style="padding: 6px; height: 36px; width: 36px; cursor: pointer;">
                                                    <i class="fa fa-shopping-cart"></i>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <!--footer-->

            <footer
                class="text-center text-lg-start text-dark"
                style="background-color: #ECEFF1"
                >
                <!-- Section: Social media -->
                <section
                    class="d-flex justify-content-between p-4 text-white"
                    style="background-color: #21D192"
                    >
                    <!-- Left -->
                    <div class="me-5">
                        <span>Get connected with us on social networks:</span>
                    </div>
                    <!-- Left -->

                    <!-- Right -->
                    <div>
                        <a href="" class="text-white me-4">
                            <i class="fab fa-facebook-f"></i>
                        </a>
                        <a href="" class="text-white me-4">
                            <i class="fab fa-twitter"></i>
                        </a>
                        <a href="" class="text-white me-4">
                            <i class="fab fa-google"></i>
                        </a>
                        <a href="" class="text-white me-4">
                            <i class="fab fa-instagram"></i>
                        </a>
                        <a href="" class="text-white me-4">
                            <i class="fab fa-linkedin"></i>
                        </a>
                        <a href="" class="text-white me-4">
                            <i class="fab fa-github"></i>
                        </a>
                    </div>
                    <!-- Right -->
                </section>
                <!-- Section: Social media -->

                <!-- Section: Links  -->
                <section class="">
                    <div class="container text-center text-md-start mt-5">
                        <!-- Grid row -->
                        <div class="row mt-3">
                            <!-- Grid column -->
                            <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                                <!-- Content -->
                                <h6 class="text-uppercase fw-bold">Company name</h6>
                                <hr
                                    class="mb-4 mt-0 d-inline-block mx-auto"
                                    style="width: 60px; background-color: #7c4dff; height: 2px"
                                    />
                                <p>
                                    Here you can use rows and columns to organize your footer
                                    content. Lorem ipsum dolor sit amet, consectetur adipisicing
                                    elit.
                                </p>
                            </div>
                            <!-- Grid column -->

                            <!-- Grid column -->
                            <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                                <!-- Links -->
                                <h6 class="text-uppercase fw-bold">Products</h6>
                                <hr
                                    class="mb-4 mt-0 d-inline-block mx-auto"
                                    style="width: 60px; background-color: #7c4dff; height: 2px"
                                    />
                                <p>
                                    <a href="#!" class="text-dark">MDBootstrap</a>
                                </p>
                                <p>
                                    <a href="#!" class="text-dark">MDWordPress</a>
                                </p>
                                <p>
                                    <a href="#!" class="text-dark">BrandFlow</a>
                                </p>
                                <p>
                                    <a href="#!" class="text-dark">Bootstrap Angular</a>
                                </p>
                            </div>
                            <!-- Grid column -->

                            <!-- Grid column -->
                            <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                                <!-- Links -->
                                <h6 class="text-uppercase fw-bold">Useful links</h6>
                                <hr
                                    class="mb-4 mt-0 d-inline-block mx-auto"
                                    style="width: 60px; background-color: #7c4dff; height: 2px"
                                    />
                                <p>
                                    <a href="#!" class="text-dark">Your Account</a>
                                </p>
                                <p>
                                    <a href="#!" class="text-dark">Become an Affiliate</a>
                                </p>
                                <p>
                                    <a href="#!" class="text-dark">Shipping Rates</a>
                                </p>
                                <p>
                                    <a href="#!" class="text-dark">Help</a>
                                </p>
                            </div>
                            <!-- Grid column -->

                            <!-- Grid column -->
                            <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                                <!-- Links -->
                                <h6 class="text-uppercase fw-bold">Contact</h6>
                                <hr
                                    class="mb-4 mt-0 d-inline-block mx-auto"
                                    style="width: 60px; background-color: #7c4dff; height: 2px"
                                    />
                                <p><i class="fas fa-home mr-3"></i> New York, NY 10012, US</p>
                                <p><i class="fas fa-envelope mr-3"></i> info@example.com</p>
                                <p><i class="fas fa-phone mr-3"></i> + 01 234 567 88</p>
                                <p><i class="fas fa-print mr-3"></i> + 01 234 567 89</p>
                            </div>
                            <!-- Grid column -->
                        </div>
                        <!-- Grid row -->
                    </div>
                </section>
                <!-- Section: Links  -->

                <!-- Copyright -->
                <div
                    class="text-center p-3"
                    style="background-color: rgba(0, 0, 0, 0.2)"
                    >
                    © 2020 Copyright:
                    <a class="text-dark" href="https://mdbootstrap.com/"
                       >MDBootstrap.com</a
                    >
                </div>
                <!-- Copyright -->
            </footer>

        </div>


        <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
            integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
            crossorigin="anonymous"
        ></script>

        <!-- Owl Carousel JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>
        <!--slickjs-->
        <script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>


        <!--slickjs script-->
        <script>
            //       
            $(".owl-carousel").owlCarousel({
                items: 4,
                itemsDesktop: [1199, 4],
                itemsDesktopSmall: [980, 2],
                itemsTablet: [768, 1],
                itemsMobile: [479, 1],
                itemsCustom: false,
                itemsTabletSmall: false,
                singleItem: false,
                itemsScaleUp: false,
                slideSpeed: 200,
                autoplayTimeout: 2000,
                paginationSpeed: 800,
                rewindSpeed: 1000,
                stopOnHover: false,
                loop: true,
                //Autoplay
                autoplay: true,
                //Auto height
                autoHeight: true
            }
            );


            $('.carouse-banner').slick({
                arrows: true,
                autoplay: true,
                speed: 300,
                autoplaySpeed: 3000
            });


        </script>

    </body>
</html>
