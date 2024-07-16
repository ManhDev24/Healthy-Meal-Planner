<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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

        <!-- Bootstrap CSS v5.2.1 -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous"
            />
        <!-- font-awesome -->
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
            integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
    </head>

    <body>
        <jsp:include page="header.jsp"/>
        <section class="h-100 gradient-custom">
            <div class="container py-5">
                <div class="row d-flex justify-content-center my-4">
                    <div class="col-md-8">
                        <div class="card mb-4">
                            <div class="card-header py-3">
                                <!--<h5 class="mb-0">Cart - 2 items</h5>-->
                                <c:set var="totalItems" value="${fn:length(sessionScope.cart.items)}" />
                                <h5 class="mb-0">Cart - ${totalItems} items</h5>
                            </div>
                            <div class="card-body">
                                <!-- Single item -->
                                <c:forEach var="item" items="${sessionScope.cart.items}">
                                    <div class="row">
                                        <div class="col-lg-3 col-md-12 mb-4 mb-lg-0">
                                            <!-- Image -->
                                            <div
                                                class="bg-image hover-overlay hover-zoom ripple rounded"
                                                data-mdb-ripple-color="light"
                                                >
                                                <img
                                                    style="height: 150px"
                                                    src="${item.dishes.imgurl}"
                                                    class="w-100"
                                                    alt="Blue Jeans Jacket"
                                                    />
                                                <a href="#!">
                                                    <div
                                                        class="mask"
                                                        style="background-color: rgba(251, 251, 251, 0.2)"
                                                        ></div>
                                                </a>
                                            </div>
                                            <!-- Image -->
                                        </div>

                                        <div class="col-lg-5 col-md-6 mb-4 mb-lg-0">
                                            <!-- Data -->
                                            <p><strong>${item.dishes.name}</strong></p>
                                            <button
                                                type="button"
                                                data-mdb-button-init
                                                data-mdb-ripple-init
                                                class="btn btn-primary btn-sm me-1 mb-2"
                                                data-mdb-tooltip-init
                                                title="Remove item"
                                                >
                                                <a style="color: white" href="DeleteCartItem?did=${item.dishes.id}">
                                                    <i class="fas fa-trash"></i>

                                                </a>
                                            </button>

                                            <!-- Data -->
                                        </div>

                                        <div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
                                            <!-- Quantity -->
                                            <div class="d-flex mx-4" style="max-width: 300px">
                                                <a style="color: white;text-decoration: none" href="UpdateCart?did=${item.dishes.id}&quantity=${item.quantity-1}">
                                                    <button
                                                        style="padding: 18px; height: 20px"
                                                        data-mdb-button-init
                                                        data-mdb-ripple-init
                                                        class="btn btn-primary d-flex justify-content-center align-items-center"
                                                        >
                                                        <i class="fas fa-minus"></i>
                                                    </button></a>


                                                <div data-mdb-input-init class="form-outline text-center">
                                                    <form action="UpdateCart">
                                                        <input type="hidden" name="did" value="${item.dishes.id}">
                                                        <input
                                                            id="form1"
                                                            min="0"
                                                            step="1"
                                                            name="quantity"
                                                            onchange="this.form.submit()"
                                                            value="${item.quantity}"
                                                            type="number"
                                                            class="form-control"
                                                            />
                                                        <label class="form-label" for="form1"></label>
                                                    </form>

                                                </div>
                                                <a style="color: white; text-decoration: none" href="UpdateCart?did=${item.dishes.id}&quantity=${item.quantity+1}">
                                                    <button
                                                        data-mdb-button-init
                                                        data-mdb-ripple-init
                                                        class="btn btn-primary d-flex justify-content-center align-items-center"
                                                        style="padding: 18px; height: 20px"
                                                        >
                                                        <i class="fas fa-plus"></i>
                                                    </button>
                                                </a>

                                            </div>
                                            <!-- Quantity -->

                                            <!-- Price -->
                                            <p class="text-start text-md-center">
                                                <strong><fmt:formatNumber pattern="##.#" value="${item.dishes.price * item.quantity}"/>$</strong> 
                                            </p>

                                            <!-- Price -->
                                        </div>
                                    </div>
                                    <!-- Single item -->
                                    <hr class="my-4" />

                                </c:forEach>


                                <!-- Single item -->

                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-body">
                                <p><strong>Expected shipping delivery</strong></p>
                                <p class="mb-0">12.10.2020 - 14.10.2020</p>
                            </div>
                        </div>
                        <div class="card mb-4 mb-lg-0">
                            <div class="card-body">
                                <p><strong>We accept</strong></p>
                                <img
                                    class="me-2"
                                    width="45px"
                                    src="https://mdbcdn.b-cdn.net/wp-content/plugins/woocommerce-gateway-stripe/assets/images/visa.svg"
                                    alt="Visa"
                                    />
                                <img
                                    class="me-2"
                                    width="45px"
                                    src="https://mdbcdn.b-cdn.net/wp-content/plugins/woocommerce-gateway-stripe/assets/images/amex.svg"
                                    alt="American Express"
                                    />
                                <img
                                    class="me-2"
                                    width="45px"
                                    src="https://mdbcdn.b-cdn.net/wp-content/plugins/woocommerce-gateway-stripe/assets/images/mastercard.svg"
                                    alt="Mastercard"
                                    />
                                <img
                                    class="me-2"
                                    width="45px"
                                    src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQWjHVQbSNU0dwOGF5iuSO2xNAVfJXaZ8TlRg&s"
                                    alt="PayPal acceptance mark"
                                    />
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card mb-4">
                            <div class="card-header py-3">
                                <h5 class="mb-0">Summary</h5>
                            </div>
                            <div class="card-body">
                                <ul class="list-group list-group-flush">
                                    <li
                                        class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0"
                                        >
                                        Products
                                        <span>${cart.totalPrice}$</span> 
                                    </li>
                                    <li
                                        class="list-group-item d-flex justify-content-between align-items-center px-0"
                                        >
                                        Shipping
                                        <span>FreeShip</span>
                                    </li>
                                    <li
                                        class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3"
                                        >
                                        <div>
                                            <strong>Total amount</strong>
                                        </div>
                                        <span><strong>${cart.totalPrice}$</strong</span>
                                    </li>


                                    <a href="checkout.jsp" style="text-decoration:none ">
                                        <button  type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-lg btn-block">
                                            Go to checkout
                                        </button>   
                                    </a>
                                </ul>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Bootstrap JavaScript Libraries -->
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
