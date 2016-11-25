<%-- 
    Document   : succes.jsp
    Created on : Nov 25, 2016, 12:27:01 AM
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
        <% Object u = session.getAttribute("username"); 
        if(u != null){
            String username = u.toString();
            out.println("<h1> Hello "+username+" you are now logged in</h1>");
        } else {
            out.println("<a href=\"login.jsp\">Login in here</a>");
        }
        %>
    </body>
</html>
