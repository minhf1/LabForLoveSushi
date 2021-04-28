/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.ArticleDAO;
import entity.Article;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class ArticleDAOImpl extends DBContextImpl implements dao.ArticleDAO{

    public Article GetImageArticle() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Article article = new Article();
        String sql = "SELECT Top (1) img FROM dbo.[Article] ORDER BY id desc";
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                article.setImg(rs.getString("img"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }
        return article;
    }

    public Article getArticleByID(int id) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Article c = new Article();
        String sql = "SELECT * from dbo.Article where id = ?";
        con = null;
        ps = null;
        rs = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setTitle(rs.getString("title"));
                c.setImg(rs.getString("img"));
                c.setContent(rs.getString("content"));
                c.setPreContent(rs.getString("preContent"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }
        return c;
    }

    public List<Article> getArticlePaging(int size, int index) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Article> listArticles = new ArrayList<>();
        String sql = " SELECT * from (SELECT ROW_NUMBER() OVER (ORDER BY id ASC) "
                + " AS Rownumber, * FROM dbo.Article) AS C "
                + " WHERE C.Rownumber BETWEEN ? AND ? ";
        int from = size * (index - 1) + 1;
        int to = size * index;
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, from);
            ps.setInt(2, to);
            rs = ps.executeQuery();
            while (rs.next()) {
                Article c = new Article();
                c.setId(rs.getInt("id"));
                c.setTitle(rs.getString("title"));
                c.setImg(rs.getString("img"));
                c.setContent(rs.getString("content"));
                c.setPreContent(rs.getString("preContent"));
                listArticles.add(c);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }
        return listArticles;
    }

    //Hàm thực hiện lấy hết dữ liệu cake.
    public int getTotal() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Article> listArticles = new ArrayList<>();
        String sql = "SELECT Count(*) as Total FROM dbo.Article";
        int total = 0;
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getInt("Total");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }
        return total;
    }
}
