<%@page import="java.util.ArrayList"%>
<%@page import="dto.Dishes"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
    Document   : food
    Created on : Jun 16, 2024, 9:59:52 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Title</title>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />

        <!-- font awesome -->
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
            integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <!-- Bootstrap CSS v5.2.1 -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous"
            />
        <style>
            .container{
                max-width: 1300px !important;
            }


            .card {
                border-radius: 1.25rem !important; /* Adjust the border radius to match the design */
                overflow: hidden;      /* Ensure the border radius is applied to the images */
                border: none;          /* Remove the default border */
            }


            .card img {
                border-top-left-radius: 1.25rem; /* Match card's border radius */
                border-top-right-radius: 1.25rem; /* Match card's border radius */
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
        <jsp:include page="header.jsp"/>

        <div class="container">
            <div class="filter-food py-2 m-5">
                <h2>Filter Ingredients</h2>
                <form class="row" action="GetDishServlet" >
                    <div class="col-12">
                        <div class="form-outline mb-4" data-mdb-input-init>
                            <input type="search" class="form-control" name="search" placeholder="search">
                            <label class="form-label" >Search</label>
                        </div>
                    </div>
                    <div class="col-6">
                        <label for="category">Category:</label>
                        <select class="form-select" name="cid">
                            <option value="">All</option>
                            <c:forEach var="c" items="${cl}">
                                <option value="${c.id}">${c.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-6">
                        <label for="filter">Lọc sản phẩm:</label>
                        <select class="form-select" id="filter" name="sortType">
                            <option value="1">Tên từ A-z</option>
                            <option value="2">Tên từ Z-a</option>
                            <option value="3">Giá từ cao đến thấp</option>
                            <option value="4">Giá từ thấp đến cao</option></select
                        ><br /><br />
                    </div>
                    <div class="col-6">
                        <label for="minPrice">Min Price:</label>
                        <input
                            class="form-control"
                            type="text"
                            name="min"

                            /><br /><br />
                    </div>
                    <div class="col-6">
                        <label for="maxPrice">Max Price:</label>
                        <input
                            class="form-control"
                            type="text"
                            name="max"
                            /><br /><br />
                    </div>
                    <div class="col-6">
                        <label for="status">Ngày:</label>
                        <select class="form-select"  name="date">
                            <option value="1">Mới nhất</option>
                            <option value="2">Cũ nhất</option>

                        </select>
                    </div>
                    <div class="col-6">
                        <label for="status">Tình trạng:</label>
                        <select class="form-select"  name="status">
                            <option value="1">Còn Món</option>
                            <option value="0">Hết Mon</option>
                        </select>
                    </div>

                    <button type="submit" class="btn btn-success mt-4">Filter</button>
                </form>
            </div>
            <div class="product row">
                <c:if test="${not empty ListItems}">
                    <c:forEach var="dish" items="${ListItems}">
                        <div class="item col-3 mb-3">
                            <div class="card dishImg" style="width: 18rem">
                                <a href="MainController?action=dishDetail&did=${dish.id}">
                                    <img style="height: 286px" src="${dish.imgurl}" class="card-img-top" alt="..." />
                                </a> 

                                <div class="card-body">
                                    <a href="GetDishDetail?did=${dish.id}">
                                        <h5 class="card-title">${dish.name}</h5>
                                    </a>
                                    <div style="height: 100px">
                                        <p class="card-text">${dish.decreption}</p>
                                    </div>

                                    <div class="d-flex justify-content-between align-items-center">
                                        <div style="font-size: 26px; font-weight: 600; line-height: 20px; color: #E30019;">
                                            <h2>${dish.price}$</h2>
                                        </div>

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
                </c:if>




                <div class="d-flex justify-content-end">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <li class="page-item">
                                <%-- Previous button --%>
                                <c:if test="${param.index > 1}">
                                    <a class="page-link"
                                       href="MainController?action=foodct&index=${param.index - 1}&search=${param.search}&cid=${param.cid}&sortType=${param.sortType}&min=${param.min}&max=${param.max}&date=${param.date}&status=${param.status}">Previous</a>
                                </c:if>
                                <c:if test="${param.index <= 1}">
                                    <span class="page-link">Previous</span>
                                </c:if>
                            </li>

                            <%-- Pagination numbers --%>
                            <c:forEach var="i" begin="1" end="${toTalPage}" step="1">
                                <li class="page-item ${param.index == i ? 'active' : ''}">
                                    <a class="page-link"
                                       href="MainController?action=foodct&index=${i}&search=${param.search}&cid=${param.cid}&sortType=${param.sortType}&min=${param.min}&max=${param.max}&date=${param.date}&status=${param.status}">${i}</a>
                                </li>
                            </c:forEach>

                            <li class="page-item">
                                <%-- Next button --%>
                                <c:if test="${param.index < toTalPage}">
                                    <a class="page-link"
                                       href="MainController?action=foodct&index=${param.index + 1}&search=${param.search}&cid=${param.cid}&sortType=${param.sortType}&min=${param.min}&max=${param.max}&date=${param.date}&status=${param.status}">Next</a>
                                </c:if>
                                <c:if test="${param.index >= toTalPage}">
                                    <span class="page-link">Next</span>
                                </c:if>
                            </li>
                        </ul>
                    </nav>
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
    </body>
    <%--<jsp:include page="footer.jsp"/>--%>

</html>
