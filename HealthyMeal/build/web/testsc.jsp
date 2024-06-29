<%@page import="java.util.ArrayList"%>
<%@page import="dto.Dishes"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : testsc
    Created on : Jun 8, 2024, 7:22:23 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>scsc</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <img src="https://www.tasteofhome.com/wp-content/uploads/2018/07/The-Best-Ever-Tomato-Soup_EXPS_THSO18_222724_D03_06_5b-6.jpg" style="width: 100px; height: 100px;" alt="">
        <img src="https://www.herwholesomekitchen.com/wp-content/uploads/2021/03/chickensalad.jpg" style="width: 100px; height: 100px;" alt="">
    <c:forEach var="it" items="${ListItems}">
         <img src="${it.imgurl}" style="width: 100px; height: 100px;" alt="...">
            <p>
                ID: ${it.id}
                <br>
                Name: ${it.name}
                <br>
                Price: ${it.price}
                <br>
                
            </p>
    </c:forEach>
            
     <%
         ArrayList<Dishes> list = (ArrayList<Dishes>) request.getAttribute("ListItems");
            if (list != null) {
                for (Dishes it : list) {
     %>
             <p>
                 <%=it.getImgurl() %>
                 <%=it.getName() %>
                 <%=it.getPrice() %>
             </p>
     
     <%
                }
            }
        %>
    </body>
</html>
