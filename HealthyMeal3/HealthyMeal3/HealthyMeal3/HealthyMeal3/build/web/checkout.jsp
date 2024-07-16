<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Checkout</title>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

        <!-- Bootstrap CSS v5.3.2 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
              crossorigin="anonymous"
              />
        <link rel="stylesheet" href="./asset/checkout.css" />
        <style>
            .container {
                max-width: 1300px;
            }
            .alert {
                margin-top: 20px;
            }
        </style>
    </head>
    <body>
        <div class="Checkout_section container card card-body">
            <div class="row">
                <div class="checkout_form">
                    <div class="row">
                        <div class="col-lg-6 col-md-6" style="padding: 0 36px">
                            <form style="padding: 20px; border: 1px black solid" action="UpdateProfileServlet" method="POST">
                                <h3>Billing Details</h3>
                                <div class="row">
                                    <div class="col-lg-12 mb-4">
                                        <label>Full Name <span>*</span></label>
                                        <input type="text" name="txtfullname" value="${sessionScope.LoggedInUser.fullname}" required />
                                    </div>
                                    <div class="col-12 mb-4">
                                        <label>Email</label>
                                        <input type="email" name="txtemail" value="${sessionScope.LoggedInUser.email}" required />
                                    </div>
                                    <div class="col-12 mb-4">
                                        <label>Address <span>*</span></label>
                                        <input placeholder="House number and street name" type="text" name="txtaddress" value="${sessionScope.LoggedInUser.address}" required />
                                    </div>
                                    <div class="col-lg-6 mb-4">
                                        <label>Phone<span>*</span></label>
                                        <input type="text" name="txtphone" value="${sessionScope.LoggedInUser.phone}" required />
                                    </div>
                                </div>
                                <c:if test="${empty sessionScope.LoggedInUser.fullname || empty sessionScope.LoggedInUser.email || empty sessionScope.LoggedInUser.address || empty sessionScope.LoggedInUser.phone}">
                                    <div class="alert alert-danger" role="alert">
                                        Vui lòng hoàn thiện thông tin cá nhân của bạn trước khi thanh toán.
                                    </div>
                                    <button name="action"
                                            value="checkout"
                                            type="submit" class="btn btn-primary">Cập nhật thông tin</button>
                                </c:if>
                            </form>
                        </div>
                        <div class="col-lg-6 col-md-6" style="padding: 0 36px">
                            <form action="PurchaseOrderServlet" method="POST">
                                <h3>Your order</h3>
                                <div class="order_table table-responsive mb-30">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>Product</th>
                                                <th>Total</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="item" items="${sessionScope.cart.items}">
                                                <tr>
                                                    <td>${item.dishes.name} <strong> × ${item.quantity}</strong></td>
                                                    <td>${item.dishes.price * item.quantity}$</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <th>Cart Subtotal</th>
                                                <td>${sessionScope.cart.totalPrice}$</td>
                                            </tr>
                                            <tr>
                                                <th>Shipping</th>
                                                <td><strong>Free Ship</strong></td>
                                            </tr>
                                            <tr class="order_total">
                                                <th>Order Total</th>
                                                <td><strong>${sessionScope.cart.totalPrice}$</strong></td>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>
                                <div class="payment_method">
                                    <h3>PAYMENT</h3>
                                    <div class="panel-default">
                                        <input id="paymentCash" name="paymentId" type="radio" value="1" checked />
                                        <label for="paymentCash">Tiền mặt</label>
                                    </div>
                                    <div class="panel-default">
                                        <input id="paymentCard" name="paymentId" type="radio" value="2" />
                                        <label for="paymentCard">Credit Card</label>
                                    </div>
                                </div>
                                <c:if test="${!empty sessionScope.LoggedInUser.fullname && !empty sessionScope.LoggedInUser.email && !empty sessionScope.LoggedInUser.address && !empty sessionScope.LoggedInUser.phone}">
                                    <div class="order_button">
                                        <button type="submit" class="btn btn-primary">Checkout</button>
                                    </div>
                                </c:if>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
                integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
                integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>
    </body>
</html>
