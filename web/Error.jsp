<%-- 
    Document   : Error
    Created on : Nov 17, 2020, 9:20:43 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/main.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="main">
            <jsp:include page="Header.jsp"></jsp:include>
            <jsp:include page="Menu.jsp"></jsp:include>
                <div class="container">

                <c:if test="${error1!=null}">
                    <h3>${error1}</h3>
                </c:if>
                <c:if test="${error2!=null}">
                    <h3>${error2}</h3>
                </c:if>
                <c:if test="${error3!=null}">
                    <h3>${error3}</h3>
                </c:if>
                <c:if test="${error4!=null}">
                    <h3>${error4}</h3>
                </c:if>
            </div>

        </div>


    </body>
</html>
