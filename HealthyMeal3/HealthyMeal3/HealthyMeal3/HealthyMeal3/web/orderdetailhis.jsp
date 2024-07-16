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
    <title>Orders</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .badge-unfulfilled { background-color: #ffc107; }
        .badge-authorized { background-color: #007bff; }
    </style>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <div class="container mt-5">
        <h1>Orders</h1>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                   
                    <th scope="col">Image</th>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Price</th>
                   
                </tr>
            </thead>
            <tbody>
                 
                     <c:forEach var="d" items="${LIST_PRODUCTS_IN_ORDER}">
                         <tr>
                             <td><a href="MainController?action=dishDetail&did=${dish.id}"><img src="${d.dish.imgurl}"alt="" width="100px;"></a></td>
                             <td>${d.dish.id}</td>
                             <td>${d.dish.name}</td>
                             <td>${d.quantity}</td>
                             <td>${d.price}</td>
                         </tr>
                 </c:forEach>
                
            </tbody>
        </table>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>