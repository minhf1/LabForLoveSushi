<%-- 
    Document   : ArticleDetail
    Created on : Mar 2, 2020, 12:20:51 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="CSS/content.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/main.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/ArticleDetail.css" rel="stylesheet" type="text/css"/>
      
    </head>
        <div class="main">
            <jsp:include page="Header.jsp"></jsp:include>
            <jsp:include page="Menu.jsp"></jsp:include>
                <div class="container">
                    <div class="content">
                        <div class="article">
                            <div class="tittleName">${article.title}</div>
                        <div class="rowArticle">
                            <div class="articleImg"><img style="width: 410px; height: 360px;" src="${article.img}" class="InArticleImg border"></div>
                            <div class="articleInfor">${article.content}</div>
                        </div>
                    </div>
                </div>
                <jsp:include page="Box.jsp"></jsp:include>

                </div>
            <jsp:include page="Footer.jsp"></jsp:include>
        </div>
    </body>
</html>
