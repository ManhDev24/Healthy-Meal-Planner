<%-- 
    Document   : DishDetail
    Created on : Jun 28, 2024, 7:56:52 PM
    Author     : NC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<jsp:include page="header.jsp"/>

<!-- dish detail -->

<!doctype html>
<html lang="en">

    <head>
        <title>Title</title>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

        <!-- Bootstrap CSS v5.2.1 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
        <link rel="stylesheet" href="./asset/dishDetail.css">
    </head>

    <body>


        <div class="single-product  " >
            <c:set var="d" value="${requestScope.nd}"/>
            <c:set var="calories" value="${requestScope.calories}" />
            <div class="container">
                <div class="row">
                    <div class="col-md-5">
                        <div class="single-product-img">
                            <img
                                style="height: 350px"
                                src=${d.imgurl}
                                alt="">
                        </div>
                    </div>
                    <div class="col-md-7">
                        <div class="single-product-content">
                            <h3>${d.name}</h3>
                            <p class="single-product-pricing"><strong style="font-size: 30px;font-weight: bold;color: red">${d.price}$</strong></p>
                            <p><strong>Calories: ${calo}</strong></p>
                            <p class="">${d.decreption}</p>

                            <c:choose>
                                <c:when test="${nd.status}">
                                    <div class="single-product-form">
                                        <form action="GetDishDetail" method="post">
                                            <input type="hidden" name="did" value="${d.id}">
                                            <input
                                                id="quantityInput"
                                                min="0"
                                                step="1"
                                                name="quantity"
                                                value="${empty quantity ? 1 : quantity}"
                                                type="number"
                                                class="form-control"
                                                onchange="this.form.submit();"
                                                style="width: 10%"
                                                />
                                        </form>



                                    </div>
                                    <br/>
                                    <div class="stockStatus mb-4">In Stock</div>
                                    <form action="AddToCart" method="post">
                                        <input type="hidden" name="did" value="${d.id}">
                                        <input type="hidden" name="quantity" value="${quantity}" >
                                        <button type="submit" class="cart-btn" style="
                                                font-family: 'Poppins', sans-serif;
                                                display: inline-block;
                                                background-color: #F28123;
                                                color: #fff;
                                                padding: 10px 20px;
                                                margin-bottom: 15px;
                                                border-radius:50px;
                                                list-style: none;
                                                text-decoration: none;
                                                border: none">
                                            <i class="fas fa-shopping-cart"></i> Add to Cart
                                        </button>
                                    </form>
                                </c:when>
                                <c:otherwise>
                                    <br>
                                    <div class="stockStatus mb-4" style="background-color: red">Out of Stock</div>
                                </c:otherwise>
                            </c:choose>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>

        <!-- Bootstrap JavaScript Libraries -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
                integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
                integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>
        <!--        <script>
                    document.getElementById('add-to-cart').addEventListener('click', function (event) {
                        event.preventDefault();
                        var quantity = document.getElementById('quantity-input').value;
                        var did = "${nd.id}";
                        this.href = "AddToCart?did=" + did + "&quantity=" + quantity;
                        window.location.href = this.href;
                    });
                </script>-->

    </body>

</html>
