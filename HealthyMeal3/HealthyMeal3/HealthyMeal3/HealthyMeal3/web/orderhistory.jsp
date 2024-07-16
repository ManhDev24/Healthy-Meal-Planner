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
                        <th scope="col">Order ID</th>
                        <th scope="col">Date</th>
                        <th scope="col">Total</th>
                        <th scope="col">Status</th>
                        <th scope="col">View</th>

                    </tr>
                </thead>
                <tbody>
                    <c:if test="${not empty OrdersHistory}">
                        <c:forEach var="o" items="${OrdersHistory}">
                            <tr>
                                <td>${o.id}</td>
                                <td>${o.order_date}</td>
                                <td>${o.totalPrice}$</td>
                                <td>${o.status ? "Da giao":"Chua giao"}</td>
                                <td><a href="OrdersHisDetailServlet?action=showdetail&bill_id=${o.id}"/>View</td>
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
