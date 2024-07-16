<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Access Denied</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                text-align: center;
                padding: 50px;
            }
            .container {
                background-color: #fff;
                border-radius: 8px;
                padding: 20px;
                box-shadow: 0 0 10px rgba(0,0,0,0.1);
                max-width: 400px;
                margin: 0 auto;
            }
            h1 {
                color: #d9534f;
            }
            p {
                color: #555;
            }
            a {
                color: #337ab7;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Access Denied</h1>
            <p>You are not authorized to view this page.</p>
            <p><a href="<%= request.getContextPath()%>/">Go to Homepage</a></p>
        </div>
    </body>
</html>
