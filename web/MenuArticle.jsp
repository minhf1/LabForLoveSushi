<%-- 
    Document   : MenuArticle
    Created on : Mar 2, 2020, 14:50:23 PM
    Author     : asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu and Price</title>
        <link href="CSS/content.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/main.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/menuSushi.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="main">
            <jsp:include page="Header.jsp"></jsp:include>
            <jsp:include page="Menu.jsp"></jsp:include>
                <div class="container">
                    <div class="content">
                        <div class="tittleName">Menu and Price list</div>
                    <c:forEach items="${listMenuArticles}" var="x">
                        <div class="menuItem">
                            <div class="menuTittle">
                                <div class="left">Menu ${x.id}</div>
                                <div class="right">Price</div>
                            </div>
                            <div class="menuContainer">
                                <div class="menuTittle">
                                    <div class="left">${x.name}</div>
                                    <!--check-->
                                    <div class="right">&#128;${x.price}</div>
                                </div>
                                <div class="menuContain">
                                    <p>
                                        ${x.content}
                                    </p>
                                </div>

                            </div>
                        </div>

                    </c:forEach>

                    <div class="pagination">
                        <c:forEach begin="1" end="${totalPage}" var="i">
                            <a href="MenuArticleController?index=${i}">${i}</a>
                        </c:forEach>

                    </div>

                </div>
                <jsp:include page="Box.jsp"></jsp:include>

                </div>
            <jsp:include page="Footer.jsp"></jsp:include>
        </div>
    </body>
</html>
