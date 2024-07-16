<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Product</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/asset/admin.css">
    <script src="${pageContext.request.contextPath}/view/assets/admin/js/main.js"></script>
    <style>
        img {
            width: 200px;
            height: 120px;
        }
        select {
            width: 32.3%;
            margin: 0;
            font-size: 100%;
            padding: 5px 10px;
            font-family: Segoe UI, Helvetica, sans-serif;
            border: 1px solid #D0D0D0;
            border-radius: 20px;
            outline: none;
        }
        .error-message {
            color: red;
        }
    </style>
</head>
<body style="background-color: #21D192">
    <form id="form" action="EditProduct" method="post">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-body">
                    <div class="row">
                        <div class="form-group col-md-12">
                            <h5>Chỉnh sửa thông tin sản phẩm</h5>
                            <%-- Display error message if exists --%>
                            <c:if test="${not empty requestScope.error}">
                                <p class="error-message">${requestScope.error}</p>
                            </c:if>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="control-label">Mã sản phẩm</label>
                            <input class="form-control" type="text" readonly name="product_id" value="${pid}">
                        </div>
                        <div class="form-group col-md-6">
                            <label class="control-label">Số lượng</label>
                            <input class="form-control" type="text" name="product_stock" value="${pstock}">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="exampleSelect1" class="control-label">Danh mục</label>
                            <select name="category_id" class="form-control" id="exampleSelect1">
                                <c:forEach items="${requestScope.LIST_CATEGORIES}" var="cat">
                                    <option ${cat.id == pcategory.id ? "selected" : ""} value="${cat.id}">${cat.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="control-label">Tên sản phẩm</label>
                            <input class="form-control" type="text" name="product_name" required value="${pname}">
                        </div>
                        <div class="form-group col-md-6">
                            <label class="control-label">Link ảnh</label>
                            <input class="form-control" type="text" name="product_image" value="${pimage}">
                        </div>
                        <div class="form-group col-md-6">
                            <label class="control-label">Giá</label>
                            <input class="form-control" type="number" name="product_price" required value="${pprice}">
                        </div>
                        <div class="form-group col-md-12">
                            <label class="control-label">Thông tin</label>
                            <textarea class="form-control" name="product_description">${pdescription}</textarea>
                        </div>
                        <div class="form-group col-md-12">
                            <label class="control-label">Release Date</label><br/>
                            <input type="hidden" id="stringdateolb" value="${preleasedate}">
                            <input type="hidden" name="date" value="" id="here"/>
                            <select class="bear-dates" id="dobDay"></select>
                            <select class="bear-months" id="dobMonth"></select>
                            <select class="bear-years" id="dobYear"></select>
                        </div>
                    </div>
                    <br>
                    <input type="hidden" name="did" value="${did}">
                    <button class="btn btn-save" name="action" value="Update" type="submit">Lưu lại</button>
                    <a class="btn btn-cancel" href="${pageContext.request.contextPath}/ManageProductServlet">Hủy bỏ</a>
                    <br>
                </div>
            </div>
        </div>
    </form>

    <script>
        function addOption(selectElement, value, text) {
            var option = document.createElement("option");
            option.value = value;
            option.text = text;
            selectElement.add(option);
        }

        var defaultReleaseDate = document.getElementById("stringdateolb").value;
        var defaultDateArray = defaultReleaseDate.split('-');
        var defaultDay = parseInt(defaultDateArray[2]);
        var defaultMonth = parseInt(defaultDateArray[1]);
        var defaultYear = parseInt(defaultDateArray[0]);

        var daysSelect = document.getElementById('dobDay');
        var monthsSelect = document.getElementById('dobMonth');
        var yearsSelect = document.getElementById('dobYear');

        for (var day = 1; day <= 31; day++) {
            addOption(daysSelect, day, day);
        }

        for (var month = 1; month <= 12; month++) {
            addOption(monthsSelect, month, month);
        }

        var currentYear = new Date().getFullYear();
        for (var year = currentYear; year >= 1900; year--) {
            addOption(yearsSelect, year, year);
        }

        daysSelect.value = defaultDay;
        monthsSelect.value = defaultMonth;
        yearsSelect.value = defaultYear;

        function setValue() {
            var here = document.querySelector('#here');
            var dobDay = document.getElementById('dobDay').value;
            var dobMonthText = document.getElementById('dobMonth').value;
            var dobYear = document.getElementById('dobYear').value;
            var dobFull;

            if (dobMonthText < 10 && dobDay < 10) {
                dobFull = dobYear + '-0' + dobMonthText + '-0' + dobDay;
            } else if (dobMonthText < 10 && !(dobDay < 10)) {
                dobFull = dobYear + '-0' + dobMonthText + '-' + dobDay;
            } else if (dobDay < 10 && !(dobMonthText < 10)) {
                dobFull = dobYear + '-' + dobMonthText + '-0' + dobDay;
            } else {
                dobFull = dobYear + '-' + dobMonthText + '-' + dobDay;
            }

            here.value = dobFull;
        }

        document.getElementById('form').onsubmit = setValue;
    </script>
</body>
</html>
