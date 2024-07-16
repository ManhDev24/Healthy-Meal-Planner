<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.LoggedInUser.role == true}">
    <% response.sendRedirect("/HealthyMeal/403page.jsp");%>
</c:if>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="./taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Danh sách sản phẩm | Quản trị Admin</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="/HealthyMeal/asset/admin.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <!-- or -->
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

        <!-- Font-icon css-->
        <link rel="stylesheet" type="text/css"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
        <style type="text/css">
            select {
                width: 32.3%;
                margin: 0;
                font-size: 100%;
                padding: 5px 10px 5px 10px;
                font-family: Segoe UI, Helvetica, sans-serif;
                border: 1px solid #D0D0D0;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                box-sizing: border-box;
                border-radius: 20px;
                outline: none;
            }
        </style>
    </head>

    <body onload="time()" class="app sidebar-mini rtl">
        <%@include file="../admin/admin--sideBar.jsp"%>
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb side">
                    <li class="breadcrumb-item active"><a href="#"><b>Danh sách sản phẩm</b></a></li>
                </ul>
                <div id="clock"></div>
            </div>
            <div class="row justify-content-center mb-2">
                <div class="col-md-4">
                    <form class="form-inline" action="ManageCategory" method="GET">
                        <input id="searchInput" name="search" class="form-control w-100" type="search" placeholder="Tìm kiếm" aria-label="Search" oninput="searchUsers()" value="${param.search}">
                    </form>
                </div>

            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <div class="tile-body">
                            <div class="row element-button">
                                <div class="col-sm-2">
                                    <a class="btn btn-add btn-sm" href="ManageProduct?action=Insert" title="Thêm"><i class="fas fa-plus"></i>
                                        Tạo mới sản phẩm</a>
                                </div>
                                <div class="col-sm-2">
                                    <a class="btn btn-delete btn-sm print-file" type="button" title="In" onclick="myApp.printTable()"><i
                                            class="fas fa-print"></i> In dữ liệu</a>
                                </div>
                            </div>
                            <h3 style="color: green; text-align: center; margin: 20px 0">${requestScope.mess}</h3>
                            <form action="EditProductServlet" method="POST">
                                <table class="table table-hover table-bordered" id="sampleTable">
                                    <thead>
                                        <tr>
                                            <th>Mã sản phẩm</th>
                                            <th>Danh mục</th>
                                            <th>Tên sản phẩm</th>
                                            <th>Giá</th>
                                            <th>Số lượng</th>
                                            <th>Status</th>
                                            <th>Ảnh</th>
                                            <th>Chức năng</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${requestScope.LIST_PRODUCTS}" var="p">
                                            <tr>
                                                <td>${p.id}</td>
                                                <td>${p.category.name}</td>
                                                <td style="max-width: 200px">${p.name}</td>
                                                <td>${p.price}</td>
                                                <td>${p.number}</td>
                                                <td>${p.status ? "Normal":"Hidden"}</td>
                                                <td><img src="${p.imgurl}" alt="" width="100px;"></td>

                                                <td>
                                                    <a class="btn btn-primary btn-sm trash" id="logout" data-toggle="modal" data-target="#modal_box" href="#" onclick="confirmHidden('modal_box', ${p.id})">
                                                        <i class="fa fa-eye-slash"></i>                                                    </a>
                                                    <a class="btn btn-primary btn-sm edit" href="EditProduct?did=${p.id}"><i class="fas fa-edit"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <div class="row">
                                    <div class="col-sm-12 col-md-7">
                                        <div class="dataTables_paginate paging_simple_numbers" id="sampleTable_paginate">
                                            <ul class="pagination">
                                                <li class="paginate_button page-item ${param.index <= 1 ? 'disabled' : ''}">
                                                    <a href="ManageCategory?index=${param.index - 1}&search=${param.search}" aria-controls="sampleTable" data-dt-idx="0" tabindex="0" class="page-link">Lùi</a>
                                                </li>
                                                <c:forEach var="i" begin="1" end="${toTalPage}">
                                                    <li class="paginate_button page-item ${param.index == i ? 'active' : ''}">
                                                        <a href="ManageCategory?index=${i}&search=${param.search}" aria-controls="sampleTable" data-dt-idx="${i}" tabindex="0" class="page-link">${i}</a>
                                                    </li>
                                                </c:forEach>
                                                <li class="paginate_button page-item ${param.index >= totalPage ? 'disabled' : ''}">
                                                    <a href="ManageCategory?index=${param.index + 1}&search=${param.search}" aria-controls="sampleTable" data-dt-idx="2" tabindex="0" class="page-link">Tiếp</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <div class="modal fade" id="modal_box" role="dialog"></div>
        <!-- Essential javascripts for application to work-->
        <script src="view/assets/admin/js/jquery-3.2.1.min.js"></script>
        <script src="view/assets/admin/js/popper.min.js"></script>
        <script src="view/assets/admin/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="view/assets/admin/js/main.js"></script>
        <!-- Page specific javascripts-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
        <!-- Data table plugin-->
        <script type="text/javascript" src="view/assets/admin/js/plugins/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="view/assets/admin/js/plugins/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript">
                                                        $('#sampleTable').DataTable();
                                                        function confirmHidden(modalId, id) {
                                                            $.confirm({
                                                                title: 'Confirm!',
                                                                content: 'Are you sure you want to bann this user?',
                                                                buttons: {
                                                                    confirm: function () {
                                                                        window.location.href = 'DeleteFoodServlet?did=' + id;
                                                                    },
                                                                    cancel: function () {
                                                                        $.alert('Canceled!');
                                                                    }
                                                                }
                                                            });
                                                        }

        </script>
        <script>
            //In
            $('#sampleTable').DataTable();
            var myApp = new function () {
                this.printTable = function () {
                    var tab = document.getElementById('sampleTable');
                    var win = window.open('', '', 'height=700,width=700');
                    win.document.write(tab.outerHTML);
                    win.document.close();
                    win.print();
                };
            }
            ;
        </script>
    </body>

</html>
