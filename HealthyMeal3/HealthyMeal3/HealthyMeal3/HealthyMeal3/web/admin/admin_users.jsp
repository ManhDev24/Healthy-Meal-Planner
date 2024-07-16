<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="./taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Danh sách nhân viên | Quản trị Admin</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="/HealthyMeal/asset/admin.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
    </head>
    <body onload="time()" class="app sidebar-mini rtl">
        <!-- Navbar-->
        <%@include file="./admin--sideBar.jsp"%>
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb side">
                    <li class="breadcrumb-item active"><a href="#"><b>Danh sách người dùng</b></a></li>
                </ul>
                <div id="clock"></div>
            </div>
            <div class="row justify-content-center mb-2">
                <div class="col-md-4">
                    <form class="form-inline" action="ManageUser" method="GET">
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
                                    <a class="btn btn-add btn-sm" href="ManageUser?action=Insert" title="Thêm">
                                        <i class="fas fa-plus"></i> Tạo mới tài khoản
                                    </a>
                                </div>
                                <div class="col-sm-2">
                                    <a class="btn btn-delete btn-sm print-file" type="button" title="In" onclick="myApp.printTable()">
                                        <i class="fas fa-print"></i> In dữ liệu
                                    </a>
                                </div>
                            </div>
                            <h3 style="color: green; text-align: center; margin: 20px 0">${requestScope.mess}</h3>
                            <table class="table table-hover table-bordered js-copytextarea" cellpadding="0" cellspacing="0" border="0" id="sampleTable">
                                <thead>
                                    <tr>
                                        <th>ID khách hàng</th>
                                        <th>Tên khách hàng</th>
                                        <th>Ảnh đại diện</th>
                                        <th>Email</th>
                                        <th>Địa chỉ</th>
                                        <th>Số điện thoại</th>
                                        <th>Status</th>
                                        <th>Role</th>
                                        <th width="70">Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.LISTUSERS}" var="u">
                                        <tr>
                                            <td>${u.id}</td>
                                            <td>${u.fullname}</td>
                                            <td><img src="${u.avatar}" width="50px" height="50px"></td>
                                            <td>${u.email}</td>
                                            <td>${u.address}</td>
                                            <td>${u.phone}</td>
                                            <td>${u.status ? "Normal":"Hidden"}</td>
                                            <td>${u.role ? "User" : "Admin"}</td>
                                            <td>
                                                <a class="btn btn-primary btn-sm trash" id="logout" data-toggle="modal" data-target="#modal_box" href="#" onclick="confirmBan('modal_box', ${u.id})">
                                                    <i class="fa fa-ban"></i>                                            
                                                </a>
                                                <a class="btn btn-primary btn-sm edit" href="EditUser?acid=${u.id}">
                                                    <i class="fas fa-edit"></i>
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
                                                <a href="ManageUser?index=${param.index - 1}&search=${param.search}" aria-controls="sampleTable" data-dt-idx="0" tabindex="0" class="page-link">Lùi</a>
                                            </li>
                                            <c:forEach var="i" begin="1" end="${toTalPage}">
                                                <li class="paginate_button page-item ${param.index == i ? 'active' : ''}">
                                                    <a href="ManageUser?index=${i}&search=${param.search}" aria-controls="sampleTable" data-dt-idx="${i}" tabindex="0" class="page-link">${i}</a>
                                                </li>
                                            </c:forEach>
                                            <li class="paginate_button page-item ${param.index >= totalPage ? 'disabled' : ''}">
                                                <a href="ManageUser?index=${param.index + 1}&search=${param.search}" aria-controls="sampleTable" data-dt-idx="2" tabindex="0" class="page-link">Tiếp</a>
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
        <!-- Modal -->
        <c:forEach items="${LISTUSERS}" var="u">
            <div class="modal fade" id="ModalUP${u.id}" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static" data-keyboard="false">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <form method="POST" action="ManageUserServlet?action=update">
                            <div class="modal-body">
                                <div class="row">
                                    <div class="form-group col-md-12">
                                        <span class="thong-tin-thanh-toan">
                                            <h5>Thêm Làm quản trị viên</h5>
                                        </span>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-md-6">
                                        <label for="exampleSelect1" class="control-label">Quyền quản trị</label>
                                        <input hidden name="user_id" value="${u.id}">
                                        <select name="permission" class="form-control" id="exampleSelect1">
                                            <option value="True">Cho phép</option>
                                            <option value="False">Hủy bỏ</option>
                                        </select>
                                    </div>
                                </div>
                                <br>
                                <button class="btn btn-save" type="submit">Lưu lại</button>
                                <a class="btn btn-cancel" data-dismiss="modal" href="#">Hủy bỏ</a>
                                <br>
                            </div>
                        </form>
                        <div class="modal-footer"></div>
                    </div>
                </div>
            </div>
        </c:forEach>
        <!-- Print modal -->
        <div class="modal fade" id="modal_box" role="dialog"></div>
        <!-- Essential javascripts for application to work-->
        <script src="view/assets/admin/js/jquery-3.2.1.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="view/assets/admin/js/popper.min.js"></script>
        <script src="view/assets/admin/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="view/assets/admin/js/main.js"></script>
        <!-- Page specific javascripts-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
        <!-- Data table plugin-->
        <script type="text/javascript" src="view/assets/admin/js/plugins/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="view/assets/admin/js/plugins/dataTables.bootstrap.min.js"></script>
        <script>
                                                    $('#sampleTable').DataTable();
                                                    function confirmBan(modalId, id) {
                                                        $.confirm({
                                                            title: 'Confirm!',
                                                            content: 'Are you sure you want to bann this user?',
                                                            buttons: {
                                                                confirm: function () {
                                                                    window.location.href = 'DeleteUserServlet?acid=' + id;
                                                                },
                                                                cancel: function () {
                                                                    $.alert('Canceled!');
                                                                }
                                                            }
                                                        });
                                                    }

                                                    function searchUsers() {
                                                        var searchQuery = $('#searchInput').val().trim();
                                                        $.ajax({
                                                            url: 'ManageUser', // Địa chỉ URL của servlet hoặc tập lệnh xử lý tìm kiếm
                                                            method: 'GET',
                                                            data: {search: searchQuery},
                                                            success: function (response) {
                                                                // Xử lý kết quả trả về từ máy chủ và cập nhật giao diện
                                                                // Ví dụ: cập nhật bảng hoặc danh sách kết quả tìm kiếm
                                                                console.log('Kết quả tìm kiếm:', response);
                                                                // Cập nhật giao diện với kết quả tìm kiếm
                                                                // Ví dụ: $('#searchResults').html(response);
                                                            },
                                                            error: function (xhr, status, error) {
                                                                console.error('Lỗi khi gửi yêu cầu tìm kiếm:', status, error);
                                                            }
                                                        });
                                                    }
        </script>
    </body>
</html>
