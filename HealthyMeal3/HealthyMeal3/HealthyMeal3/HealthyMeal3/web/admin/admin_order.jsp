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
        <style>
            button[type="submit"]:hover {
                background-color: #e0e0e0;
            }
        </style>
    </head>

    <body onload="time()" class="app sidebar-mini rtl">
        <!-- Navbar-->
        <%@include file="../admin/admin--sideBar.jsp"%>
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb side">
                    <li class="breadcrumb-item active"><a href="#"><b>Danh sách đơn hàng</b></a></li>
                </ul>
                <div id="clock"></div>
            </div>
            <div class="row justify-content-center mb-2">
                <div class="col-md-4">
                    <form class="form-inline" action="ManageOrder" method="GET">
                        <input id="searchInput" name="search" class="form-control w-100" type="search" placeholder="Tìm kiếm" aria-label="Search" oninput="searchUsers()" value="${param.search}">
                    </form>
                </div>

            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <div class="tile-body">
                            <div class="row element-button"
                                 <div class="col-sm-2">
                                    <a class="btn btn-delete btn-sm print-file" type="button" title="In" onclick="myApp.printTable()"><i
                                            class="fas fa-print"></i> In dữ liệu</a>
                                </div>
                            </div>
                            <table class="table table-hover table-bordered" id="sampleTable">
                                <thead>
                                    <tr>
                                        <th>ID đơn hàng</th>
                                        <th>Khách hàng</th>
                                        <th>Số điện thoại</th>
                                        <th>Địa chỉ</th>
                                        <th>Ngày mua</th>
                                        <th>Tổng tiền</th>
                                        <th>Thanh Toán</th>
                                        <th>Trạng thái</th>
                                        <th>Tính năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${LIST_ORDERS}" var="b">
                                        <tr>
                                            <td>${b.id}</td>
                                            <td>${b.account.fullname}</td>
                                            <td>(+84) ${b.account.phone}</td>
                                            <td>${b.account.address}</td>
                                            <td>${b.order_date}</td>
                                            <td>${b.totalPrice}</td>
                                            <td>
                                                <span class="badge bg-success">${b.paymentMethod.paymentid == 1 ? 'Tiền mặt' : b.paymentMethod.paymentid == 2 ? 'Credit Card' : 'Unknown'}</span>
                                            <td style="display: flex; align-items: center; padding: 10px;">
                                                <form action="ManageOrder" method="POST" style="margin-left: auto;">
                                                    <span>${b.status ? "Đã giao" : "Chưa giao..."}</span>
                                                    <input type="hidden" name="action" value="changeStatus">
                                                    <input type="hidden" name="id" value="${b.id}">
                                                    <button type="submit" style="margin-left: 20px; cursor: pointer; padding: 5px 10px; background-color: #f0f0f0; border: none;">
                                                        <i style="color: green;" class="fa-solid fa-check"></i>
                                                    </button>
                                                </form>
                                            </td>

                                            <td><a style=" color: rgb(245 157 57);background-color: rgb(251 226 197); padding: 5px;border-radius: 5px;" href="ManageOrder?action=showdetail&bill_id=${b.id}"><i class="fa"></i>Chi tiết đơn hàng</a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>

                            </table>
                            <div class="row">
                                <div class="col-sm-12 col-md-7">
                                    <div class="dataTables_paginate paging_simple_numbers" id="sampleTable_paginate">
                                        <ul class="pagination">
                                            <li class="paginate_button page-item ${param.index <= 1 ? 'disabled' : ''}">
                                                <a href="ManageOrder?index=${param.index - 1}&search=${param.search}" aria-controls="sampleTable" data-dt-idx="0" tabindex="0" class="page-link">Lùi</a>
                                            </li>
                                            <c:forEach var="i" begin="1" end="${toTalPage}">
                                                <li class="paginate_button page-item ${param.index == i ? 'active' : ''}">
                                                    <a href="ManageOrder?index=${i}&search=${param.search}" aria-controls="sampleTable" data-dt-idx="${i}" tabindex="0" class="page-link">${i}</a>
                                                </li>
                                            </c:forEach>
                                            <li class="paginate_button page-item ${param.index >= totalPage ? 'disabled' : ''}">
                                                <a href="ManageOrder?index=${param.index + 1}&search=${param.search}" aria-controls="sampleTable" data-dt-idx="2" tabindex="0" class="page-link">Tiếp</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <!-- Essential javascripts for application to work-->
        <script src="view/assets/admin/js/jquery-3.2.1.min.js"></script>
        <script src="view/assets/admin/js/popper.min.js"></script>
        <script src="view/assets/admin/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="view/assets/admin/js/main.js"></script>
        <!-- The javascript plugin to display page loading on top-->
        <script src="view/assets/admin/js/plugins/pace.min.js"></script>
        <!-- Page specific javascripts-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
        <!-- Data table plugin-->
        <script type="text/javascript" src="view/assets/admin/js/plugins/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="view/assets/admin/js/plugins/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript">
                                        $('#sampleTable').DataTable();
                                        //Thời Gian
                                        function time() {
                                            var today = new Date();
                                            var weekday = new Array(7);
                                            weekday[0] = "Chủ Nhật";
                                            weekday[1] = "Thứ Hai";
                                            weekday[2] = "Thứ Ba";
                                            weekday[3] = "Thứ Tư";
                                            weekday[4] = "Thứ Năm";
                                            weekday[5] = "Thứ Sáu";
                                            weekday[6] = "Thứ Bảy";
                                            var day = weekday[today.getDay()];
                                            var dd = today.getDate();
                                            var mm = today.getMonth() + 1;
                                            var yyyy = today.getFullYear();
                                            var h = today.getHours();
                                            var m = today.getMinutes();
                                            var s = today.getSeconds();
                                            m = checkTime(m);
                                            s = checkTime(s);
                                            nowTime = h + " giờ " + m + " phút " + s + " giây";
                                            if (dd < 10) {
                                                dd = '0' + dd
                                            }
                                            if (mm < 10) {
                                                mm = '0' + mm
                                            }
                                            today = day + ', ' + dd + '/' + mm + '/' + yyyy;
                                            tmp = '<span class="date"> ' + today + ' - ' + nowTime +
                                                    '</span>';
                                            document.getElementById("clock").innerHTML = tmp;
                                            clocktime = setTimeout("time()", "1000", "Javascript");

                                            function checkTime(i) {
                                                if (i < 10) {
                                                    i = "0" + i;
                                                }
                                                return i;
                                            }
                                        }
        </script>
        <script>

            $(document).ready(jQuery(function () {
                jQuery(".trash").click(function () {
                    swal({
                        title: "Cảnh báo",
                        text: "Bạn có chắc chắn là muốn xóa sản phẩm này?",
                        buttons: ["Hủy bỏ", "Đồng ý"],
                    })
                            .then((willDelete) => {
                                if (willDelete) {
                                    window.location = "productmanager?action=deleteproduct&product_id=" + $(this).attr("value");
                                    swal("Đã xóa thành công.!", {
                                    });
                                }
                            });
                });
            }));
        </script>
        <script>
            var myApp = new function () {
                this.printTable = function () {
                    var tab = document.getElementById('sampleTable');
                    var win = window.open('', '', 'height=700,width=700');
                    win.document.write(tab.outerHTML);
                    win.document.close();
                    win.print();
                };
            };
        </script>
    </body>

</html>
