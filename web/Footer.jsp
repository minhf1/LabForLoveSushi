<%-- 
    Document   : Footer
    Created on : Mar 2, 2020, 12:20:50 PM
    Author     : asus
--%>
<!--

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="CSS/footer.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="footer">
            <hr>
            <a href="#">Created with simple</a>
        </div>
    </body>
</html>-->


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="CSS/footer.css" rel="stylesheet" type="text/css"/>
        <%String[] array = new String[5];%>
    </head>
    <body>
        <div class="footer">
            <a>Created with Simple </a>         

            <div class="button">    
                   <%String view=(String)session.getAttribute("s") ;%>


                <%String num = String.valueOf(view);
                    array = num.split("");
                %>
                <%
                    for (int i = 0; i < array.length; i++) {%>
                <button><%=array[i]%></button>
                <%}%>

            </div>
        </div>
    </body>
</html>
