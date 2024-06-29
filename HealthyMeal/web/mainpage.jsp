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

        <style>
            .container {
                max-width: 1300px;
            }
        </style>
    </head>

    <body>
        <div class="container">



            <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel" data-bs-interval="2000">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <a href="MainController?action=foodct">
                            <img src="https://veganessentials.com/cdn/shop/files/ve-pre-4th-sale-d.webp?v=1719565610" class="d-block w-100" alt="Slide 1" loading="lazy">
                        </a>
                    </div>
                    <div class="carousel-item">
                        <a href="MainController?action=foodct">
                            <img src="https://veganessentials.com/cdn/shop/files/d-national-bbq-month.webp?v=1714580718" class="d-block w-100" alt="Slide 2" loading="lazy">

                        </a>
                    </div>
                    <div class="carousel-item">
                        <a href="MainController?action=foodct">
                            <img src="https://veganessentials.com/cdn/shop/files/rare-vegan-finds-d.webp?v=1708712202" class="d-block w-100" alt="Slide 3" loading="lazy">
                        </a>
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>



            <div class="m-4">
                <h3 class="title">Lunch</h3>
                <div class="owl-carousel owl-theme">
                    <c:forEach var="dish" items="${requestScope.lunch}">
                        <div class="item">
                            <div class="card" style="width: 18rem;">

                                <a href="GetDishDetail?did=${dish.id}" style="text-decoration: none">
                                    <img style="height: 286px; object-fit: cover;object-position: center;background-size: cover" src="${dish.imgurl}" class="card-img-top img-fluid" alt="...">
                                </a>
                                <div class="card-body" >
                                    <a href="GetDishDetail?did=${dish.id}" style="text-decoration: none">
                                        <h5 class="card-title">${dish.name}</h5>
                                    </a>

                                    <div style="height: 50px"><p class="card-text">${dish.decreption}</p></div>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div style="font-size: 26px; font-weight: 600; line-height: 20px; color: #e30019;">${dish.price}$</div>
                                        <div class="text-center rounded-circle bg-danger" style="margin-right: 35px;  padding: 7px; height: 36px; width: 36px; cursor: pointer;">
                                            <a style="color: white; width: 100%;" href="AddToCart?did=${dish.id}&quantity=1&action=homePage">
                                                <i class="fa fa-shopping-cart"></i>
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
                            <div class="card" style="width: 18rem;">
                                <a href="GetDishDetail?did=${dish.id}" style="text-decoration: none">
                                    <img style="height: 286px;" src="${dish.imgurl}" class="card-img-top" alt="...">
                                </a>
                                <div class="card-body" >
                                    <a href="GetDishDetail?did=${dish.id}" style="text-decoration: none">
                                        <h5 class="card-title">${dish.name}</h5>
                                    </a>
                                    <div style="height: 50px"><p class="card-text">${dish.decreption}</p></div>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div style="font-size: 26px; font-weight: 600; line-height: 20px; color: #e30019;">${dish.price}$</div>
                                        <div class="text-center rounded-circle bg-danger" style="margin-right: 35px;  padding: 7px; height: 36px; width: 36px; cursor: pointer;">
                                            <a style="color: white; width: 100%;" href="AddToCart?did=${dish.id}&quantity=1">
                                                <i class="fa fa-shopping-cart"></i>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

        </div>
    </div>

    <!-- Remove the container if you want to extend the Footer to full width. -->
    <div class="container my-5">

        <footer class="text-center text-white" style="background-color: #f1f1f1;">
            <!-- Grid container -->
            <div class="container pt-4">
                <!-- Section: Social media -->
                <section class="mb-4">
                    <!-- Facebook -->
                    <a
                        class="btn btn-link btn-floating btn-lg text-dark m-1"
                        href="#!"
                        role="button"
                        data-mdb-ripple-color="dark"
                        ><i class="fab fa-facebook-f"></i
                        ></a>

                    <!-- Twitter -->
                    <a
                        class="btn btn-link btn-floating btn-lg text-dark m-1"
                        href="#!"
                        role="button"
                        data-mdb-ripple-color="dark"
                        ><i class="fab fa-twitter"></i
                        ></a>

                    <!-- Google -->
                    <a
                        class="btn btn-link btn-floating btn-lg text-dark m-1"
                        href="#!"
                        role="button"
                        data-mdb-ripple-color="dark"
                        ><i class="fab fa-google"></i
                        ></a>

                    <!-- Instagram -->
                    <a
                        class="btn btn-link btn-floating btn-lg text-dark m-1"
                        href="#!"
                        role="button"
                        data-mdb-ripple-color="dark"
                        ><i class="fab fa-instagram"></i
                        ></a>

                    <!-- Linkedin -->
                    <a
                        class="btn btn-link btn-floating btn-lg text-dark m-1"
                        href="#!"
                        role="button"
                        data-mdb-ripple-color="dark"
                        ><i class="fab fa-linkedin"></i
                        ></a>
                    <!-- Github -->
                    <a
                        class="btn btn-link btn-floating btn-lg text-dark m-1"
                        href="#!"
                        role="button"
                        data-mdb-ripple-color="dark"
                        ><i class="fab fa-github"></i
                        ></a>
                </section>
                <!-- Section: Social media -->
            </div>
            <!-- Grid container -->

            <!-- Copyright -->
            <div class="text-center text-dark p-3" style="background-color: rgba(0, 0, 0, 0.2);">
                © 2020 Copyright:
                <a class="text-dark" href="https://mdbootstrap.com/">MDBootstrap.com</a>
            </div>
            <!-- Copyright -->
        </footer>

    </div>
    <!-- End of .container -->
    <!-- Bootstrap and Popper.js JavaScript -->
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
    <script>
        $('.owl-carousel').owlCarousel({
            loop: true,
            margin: 10,
            nav: false,
            autoplay: true,
            autoplayTimeout: 2000,
            dots: false,
            autoplayHoverPause: true,
            responsive: {
                0: {
                    items: 1,
                },
                600: {
                    items: 3,
                },
                1000: {
                    items: 5,
                },
            },
        })
        $('#carousel_2').owlCarousel({
            loop: true,
            margin: 10,
            nav: false,
            autoplay: true,
            autoplayTimeout: 2000,
            dots: false,
            autoplayHoverPause: true,
            responsive: {
                0: {
                    items: 1,
                },
                600: {
                    items: 3,
                },
                1000: {
                    items: 5,
                },
            },
        })
        $('#carousel_3').owlCarousel({
            items: 1,
            loop: true,
            margin: 10,
            nav: false,
            autoplay: true,
            autoplayTimeout: 2000,
            dots: false,
            responsive: {
                0: {
                    items: 1
                },
                600: {
                    items: 2
                },
                1000: {
                    items: 3
                }
            }
        });
    </script>

</body>
</html>
<%--<jsp:include page="footer.jsp"/>--%>
