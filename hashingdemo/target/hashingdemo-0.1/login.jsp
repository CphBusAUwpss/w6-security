<%-- 
    Document   : login
    Created on : Nov 24, 2016, 10:24:17 PM
    Author     : Thomas Hartmann - tha@cphbusiness.dk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Log in here</h1>
        <form action="UserControl" method="POST">
            <input type="text" name="username" placeholder="Enter your username" />
            <input type="password" name="password" placeholder="Enter your password" />
            <input type="hidden" name="origin" value="login" />
            <input type="submit" value="Log In" />
            
        </form>
    </body>
</html>
