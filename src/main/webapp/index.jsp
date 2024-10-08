<%-- 
    Document   : index
    Created on : 16/09/2024, 9:24:57 p. m.
    Author     : Marcos Gatica Paz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
       <head>
        <meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <body>
        <form class="login-form" action="<%=request.getContextPath()%>/LoginServlet" method="Post">
            <h2>Login</h2>
            <label>Email</label>
            <input type="email" value="" name="txtEmail" required>
            <label>Password</label>
            <input type="password" value="" name="txtPassword" required>
            <input type="submit" name="btnLogin" value="Ingresar">
        </form>
    </body>
</html>
