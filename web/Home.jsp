<%-- 
    Document   : Home
    Created on : Mar 2, 2020, 12:30:51 PM
    Author     : asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="CSS/content.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/main.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/home.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <div class="main">
            <jsp:include page="Header.jsp"></jsp:include>
            <jsp:include page="Menu.jsp"></jsp:include>
                <div class="container">
                    <div class="content">
                        <div class="imgBox">
                            <img src="${imageArticle.img}" class="imgHome" />
                    </div>

                    <div>
                        <%-- test cho nay--%>                    
                        <c:forEach items="${listArticles}" var="x">
                            <div class="article">
                                <a href="ArticleDetailController?id=${x.id}"><h2>${x.title}</h2></a>
                                <div class="rowArticle">
                                    <div class="articleImg"><a href="ArticleDetailController?id=${x.id}"><img style="width: 400px; height: 350px;" src="${x.img}" class="InArticleImg border"></a></div>
                                    <div class="articleInfor">${x.preContent}</div>
                                </div>
                            </div>
                        </c:forEach>

                        <div class="pagination">
                            <c:forEach begin="1" end="${totalPage}" var="i">
                                <a href="ArticleController?index=${i}">${i}</a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <jsp:include page="Box.jsp"></jsp:include>
                </div>
            <jsp:include page="Footer.jsp"></jsp:include>
        </div>
    </body>
</html>
