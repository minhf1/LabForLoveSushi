<%-- 
    Document   : FindUs
    Created on : Mar 2, 2020, 12:40:38 PM
    Author     : asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Find us</title>
        <link href="CSS/content.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/main.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/FindUs.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <div class="main">
            <jsp:include page="Header.jsp"></jsp:include>
            <jsp:include page="Menu.jsp"></jsp:include>
                <div class="container">
                    <div class="content">
                        <div class="tittleName">Find Us</div>

                    <c:forEach items="${listContact}" var="x">
                        <div class="left">
                            <h3>Address and Contact</h3>
                            <p class="resTel">${x.address}</p>  

                            <p class="resTel">Tel:  ${x.tel}</p>  

                            <p class="resTel">Email:  ${x.email}</p>
                        </div> 
                        <div class="right">
                            <h3>Opening hour</h3>
                            ${x.openday}
                        </div>    
                    </c:forEach>

<img src="images/map.png" class="imgMap" />
                </div>
                <jsp:include page="Box.jsp"></jsp:include>
                </div>
            <jsp:include page="Footer.jsp"></jsp:include>
        </div>

    </body>
</html>
