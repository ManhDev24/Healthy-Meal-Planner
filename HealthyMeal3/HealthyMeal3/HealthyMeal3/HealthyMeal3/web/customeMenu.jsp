<%-- 
    Document   : orderhistory
    Created on : Jul 4, 2024, 8:07:44 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Custom Menu</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .badge-unfulfilled { background-color: #ffc107; }
        .badge-authorized { background-color: #007bff; }
    </style>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <div class="container mt-5">
        <h1>Customer Menu</h1>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th scope="col">Image</th>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Status</th>
                    <th scope="col">Add to cart</th>
                    <th scope="col">Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${sessionScope.WISHLIST != null && sessionScope.WISHLIST.size() != 0}">
                    <c:forEach var="w" items="${sessionScope.WISHLIST}">
                        <tr>
                            <td><a href="MainController?action=dishDetail&did=${w.id}"><img src="${w.imgurl}" width="150px;"></a></td>
                            <td>${w.name}</td>
                            <td>${w.price}$</td>
                            <td>${w.status ? "Con hang" : "Het hang"}</td>
                            <c:if test="${w.status == true}">
                                <td><a href="MainController?action=addDish&did=${w.id}&quantity=1"/>Add to cart</td>
                            </c:if>
                            <c:if test="${w.status == false}">
                                <td><a href="WishListServlet?action=delete&did=${w.id}"/>Remove</td>
                            </c:if>
                            <td><a href="WishListServlet?action=delete&did=${w.id}"/>X</td>
                        </tr>
                    </c:forEach>
                </c:if>
            </tbody>
        </table>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

