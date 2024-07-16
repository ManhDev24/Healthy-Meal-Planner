<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : purchase
    Created on : Jun 30, 2024, 5:20:58 PM
    Author     : NC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Title</title>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

        <!-- Bootstrap CSS v5.2.1 -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="./asset/checkout.css" />
        <style>
            .container {
                max-width: 1300px;
            }
        </style>
    </head>

    <body>
        <div class="Checkout_section container card">
            <div class="row">
                <div class="checkout_form">
                    <div class="row">
                        <div class="col-lg-6 col-md-6" style="padding: 0 36px">
                            <c:choose>
                                <c:when test="${requestScope.isSuccess}">
                                    <h3 style="color: green">Order Success</h3>

                                </c:when>
                                <c:otherwise>
                                    <h3 style="color: red">Order Fail</h3>

                                </c:otherwise>
                            </c:choose>



                            <form style="padding: 20px; border: 1px black solid" action="#">
                                <h3>Billing Details</h3>
                                <div class="row">
                                    <div class="col-lg-6 mb-30">
                                        <label>Full Name <span>*</span></label>
                                        <input type="text" value="${loggedInUser.fullname}" readonly />
                                    </div>
                                    <div class="col-12 mb-30">
                                        <label>Email</label>
                                        <input type="email" value="${loggedInUser.email}" readonly />
                                    </div>
                                    <div class="col-12 mb-30">
                                        <label>Address <span>*</span></label>
                                        <input placeholder="House number and street name" type="text" value="${loggedInUser.address}" readonly />
                                    </div>
                                    <div class="col-lg-6 mb-30">
                                        <label>Phone<span>*</span></label>
                                        <input type="text" value="${loggedInUser.phone}" readonly />
                                    </div>
                                </div>
                            </form>

                        </div>
                        <div class="col-lg-6 col-md-6" style="padding: 0 36px">
                            <div style="text-align: center">
                                <img src="./asset/img/emptycart1.png" alt="Empty cart" />
                            </div>
                            <div class="order_button">
                                <a href="MainController?action=foodct">
                                    <button type="submit">Shop Now</button>
                                </a>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--Checkout page section end-->
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
</html>

