<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<c:if test="${sessionScope.LoggedInUser == null}">
    <c:redirect url="MainController?action=Home" />
</c:if>
<jsp:include page="header.jsp"/>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
    <link rel="stylesheet" type="text/css" href="./asset/profile.css" />
</head>

<body>
<form action="UpdateProfileServlet" method="post" style="position: absolute; top:250px">
    <c:if test="${sessionScope.updateStatus == true}">
        <div><h2 style="color: green; text-transform: capitalize">Update successful!!!</h2></div>
    </c:if>
    <c:if test="${sessionScope.updateStatus == false}">
        <div><h2 style="color: red; text-transform: capitalize">Update Fail!!</h2></div>
    </c:if>
    <c:remove var="updateStatus" scope="session" />

    <div class="profile-user pt-3">
        <div class="container">
            <div class="row gutters">
                <div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
                    <div class="card h-100">
                        <div class="card-body">
                            <div class="account-settings">
                                <div class="user-profile">
                                    <div class="profile-pic">
                                        <label class="-label" for="file">
                                            <span class="glyphicon glyphicon-camera"></span>
                                            <span>Change Image</span>
                                        </label>
                                        <input id="file" type="file" onchange="loadFile(event)" />
                                        <c:choose>
                                            <c:when test="${empty sessionScope.LoggedInUser.avatar}">
                                                <img src="https://www.iconpacks.net/icons/2/free-user-icon-3296-thumb.png" id="output" width="200" />
                                            </c:when>
                                            <c:otherwise>
                                                <img src="${sessionScope.LoggedInUser.avatar}" id="output" width="200" />
                                            </c:otherwise>
                                        </c:choose>
                                    </div>

                                    <h5 class="user-name">${sessionScope.LoggedInUser.fullname}</h5>
                                    <h6 class="user-email">${sessionScope.LoggedInUser.email}</h6>
                                </div>
                            </div>
                            <div class="logout text-center">
                                <a href="OrdersHistoryServlet" class="btn btn-primary btn-sm">View Orders</a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
                    <div class="card h-100">
                        <div class="card-body">
                            <div class="row gutters">
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                    <h6 class="mb-2 text-primary">Personal Details</h6>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                    <div class="form-group">
                                        <label for="fullName">Full Name</label>
                                        <input name="txtfullname" type="text" class="form-control" id="fullName" value="${sessionScope.LoggedInUser.fullname}" />
                                    </div>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                    <div class="form-group">
                                        <label for="ePhone">Email</label>
                                        <input name="txtemail" type="email" class="form-control" id="eEmail" value="${sessionScope.LoggedInUser.email}" />
                                    </div>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                    <div class="form-group">
                                        <label for="phone">Phone</label>
                                        <input name="txtphone" type="text" class="form-control" id="phone" value="${sessionScope.LoggedInUser.phone}" />
                                    </div>
                                </div>
                            </div>
                            <div class="row gutters">
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                    <h6 class="mt-3 mb-2 text-primary">Address</h6>
                                </div>
                                <div class="col-xl-1- col-lg-10 col-md-10 col-sm-10 col-12">
                                    <div class="form-group">
                                        <label for="ciTy"></label>
                                        <input name="txtaddress" type="name" class="form-control" id="ciTy" value="${sessionScope.LoggedInUser.address}" />
                                    </div>
                                </div>
                            </div>
                            <div class="row gutters">
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                    <div class="text-right">
                                        <button type="submit" name="action"
                                                value="profile" class="btn btn-primary">
                                            Update
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>
