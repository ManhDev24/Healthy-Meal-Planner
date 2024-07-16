
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="./taglib.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.LoggedInUser.role == true}">
    <% response.sendRedirect("/HealthyMeal/403page.jsp");%>
</c:if>
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
    </head>

    <body onload="time()" class="app sidebar-mini rtl">
        <!-- Navbar-->
        <%@include file="../admin/admin--sideBar.jsp"%>
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb side">
                    <li class="breadcrumb-item active"><a href="#"><b>Danh sách danh mục</b></a></li>
                </ul>
                <div id="clock"></div>
            </div>

            <div class="row justify-content-center mb-2">
                <div class="col-md-4">
                    <form class="form-inline" action="ManageProduct" method="GET">
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
                                    <a class="btn btn-add btn-sm" href="ManageCategory?action=Insert" title="Thêm"><i class="fas fa-plus"></i>
                                        Tạo mới danh mục</a>
                                </div>
                                <div class="col-sm-2">
                                    <a class="btn btn-delete btn-sm print-file" type="button" title="In" onclick="myApp.printTable()"><i
                                            class="fas fa-print"></i> In dữ liệu</a>
                                </div>
                            </div>
                            <h3 style="color: green; text-align: center; margin: 20px 0">${requestScope.mess}</h3>
                            <table class="table table-hover table-bordered" id="sampleTable">
                                <thead>
                                    <tr>
                                        <th>Mã</th>
                                        <th>Tên danh mục</th>
                                        <th>Status</th>
                                        <th>Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${LIST_CATEGORIES}" var="c">
                                        <tr>
                                            <td>${c.id}</td>
                                            <td>${c.name}</td>
                                            <td>${c.status ? "Normal" :"Hidden"}</td>
                                            <td>
                                                <a class="btn btn-primary btn-sm trash" id="logout" data-toggle="modal" data-target="#modal_box" href="#" onclick="confirmHidden('modal_box', ${c.id})">
                                                    <i class="fas fa-trash-alt"></i>
                                                </a>
                                                <button class="btn btn-primary btn-sm edit" type="button" title="Sửa" id="show-emp"
                                                        data-toggle="modal" data-target="#ModalUP${c.id}"><i class="fas fa-edit"></i>
                                                </button>
                                            </td>
                                        </tr>

                                        <!--
                                        MODAL
                                        -->

                                    <div  class="modal fade" id="ModalUP${c.id}" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static"
                                          data-keyboard="false">
                                        <div class="modal-dialog modal-dialog-centered" role="document">
                                            <div class="modal-content">
                                                <div class="modal-body">
                                                    <div class="row">
                                                        <div class="form-group  col-md-12">
                                                            <span class="thong-tin-thanh-toan">
                                                                <h5>Chỉnh sửa thông tin sản phẩm</h5>
                                                            </span>
                                                        </div>
                                                    </div>
                                                    <form action="EditCategory" method="GET">
                                                        <div class="row">
                                                            <div class="form-group col-md-6">
                                                                <label class="control-label">Mã danh mục</label>
                                                                <input class="form-control" type="text" readonly name="category_id" value="${c.id}">
                                                            </div>
                                                            <div class="form-group col-md-6">
                                                                <label class="control-label">Tên</label>
                                                                <input class="form-control" type="text" name="category_name" value="${c.name}">
                                                            </div>

                                                        </div>
                                                        <BR>
                                                        <button class="btn btn-save" type="submit">Lưu lại</button>
                                                        <button class="btn btn-cancel" type="button" onclick="closeModal()">Hủy bỏ</button>
                                                        <BR>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <!--
                                  MODAL
                                    -->
                                </c:forEach>
                                </tbody>
                                <div class="row">
                                    <div class="col-sm-12 col-md-7">
                                        <div class="dataTables_paginate paging_simple_numbers" id="sampleTable_paginate">
                                            <ul class="pagination">
                                                <li class="paginate_button page-item ${param.index <= 1 ? 'disabled' : ''}">
                                                    <a href="ManageProduct?index=${param.index - 1}&search=${param.search}" aria-controls="sampleTable" data-dt-idx="0" tabindex="0" class="page-link">Lùi</a>
                                                </li>
                                                <c:forEach var="i" begin="1" end="${toTalPage}">
                                                    <li class="paginate_button page-item ${param.index == i ? 'active' : ''}">
                                                        <a href="ManageProduct?index=${i}&search=${param.search}" aria-controls="sampleTable" data-dt-idx="${i}" tabindex="0" class="page-link">${i}</a>
                                                    </li>
                                                </c:forEach>
                                                <li class="paginate_button page-item ${param.index >= totalPage ? 'disabled' : ''}">
                                                    <a href="ManageProduct?index=${param.index + 1}&search=${param.search}" aria-controls="sampleTable" data-dt-idx="2" tabindex="0" class="page-link">Tiếp</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </table>
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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
        <script src="view/assets/admin/js/main.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <!-- The javascript plugin to display page loading on top-->
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
                                                                            window.location.href = 'DeleteCategory?ccid=' + id;
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
            function closeModal() {
                $('#myModal').modal('hide');
            }
        </script>
        <script>
            $(document).ready(function () {
                // Khi click vào nút "Sửa"
                $('.edit').click(function () {
                    // Lấy ID của modal từ thuộc tính data-target của nút "Sửa"
                    var modalId = $(this).attr('data-target');
                    // Hiển thị modal
                    $(modalId).modal('show');
                });
            });
        </script>
    </body>

</html>
