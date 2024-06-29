<%-- 
    Document   : header
    Created on : Jun 7, 2024, 10:52:29 PM
    Author     : PC
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

        <!-- font-aewsome -->
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
        <!-- my css -->
        <link rel="stylesheet" href="./asset/header.css" />
        <!-- Bootstrap CSS -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
        <style>
            .btn-secondary {
                background-color: transparent !important;
                border: none !important;
                box-shadow: none !important;
            }

            .dropdown-toggle::after {
                display: none;
            }
            .container {
                max-width: 1300px !important;
            }
        </style>
    </head>

    <body>
        <div class="container header my-3">
            <div class="nav-bar row">
                <div class="nav-bar-left row col-md-10">
                    <h2 class="col-md-2 text-center"><a href="MainController?action=Home" style="text-decoration: none">Vegan</a></h2>

                    <div class="top-search col-md-10">
                        <form class="search-form text-center" action="#">
                            <input class="search" />
                            <button>
                                <i class="fa fa-search"></i>
                            </button>
                        </form>
                    </div>
                </div>
                <div class="nav-bar-right row col-md-2 justify-content-center align-items-center">
                    <div class="user-name col-md-6">
                        <c:if test="${not empty LogineUser}">
                            Hi,${sessionScope.LogineUser.fullname}
                        </c:if>
                    </div>
                    <div class="user col-md-3">
                        <c:if test="${not empty LogineUser}">
                            <div class="dropdown">
                                <a href="#" class="btn btn-secondary dropdown-toggle" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-user"></i> 
                                </a>
                                <div class="dropdown-menu" aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="profile.jsp">Profile</a>
                                    <a class="dropdown-item" href="LogoutServlet">Logout</a>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${empty LogineUser}">
                            <a href="MainController?action=loginpage"><i class="fa fa-user"></i></a>
                            </c:if>
                    </div>
                    <div class="shoping-cart col-md-3">
                        <a href="ViewCart"><i class="fa fa-shopping-cart"></i></a>
                    </div>
                </div>
                <div class="header-bottom d-flex justify-content-center my-3 py-2">
                    <ul class="d-flex justify-content-center align-items-center my-2">
                        <li class="mx-4"><a href="MainController?action=Home">Home</a></li>
                        <li class="mx-4"><a href="MainController?action=foodct">Vegan Food</a></li>
                        <li class="mx-4"><a href="#">About us</a></li>
                        <li class="mx-4"><a href="#">Contact</a></li>
                    </ul>
                </div>
            </div>
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
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>
