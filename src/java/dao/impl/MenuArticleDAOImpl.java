/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import entity.Article;
import entity.MenuArticle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class MenuArticleDAOImpl extends DBContextImpl implements dao.MenuArticleDAO{

    public List<MenuArticle> getMenuArticlePaging(int size, int index) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<MenuArticle> listMenuArticles = new ArrayList<>();
        String sql = " SELECT * from (SELECT ROW_NUMBER() OVER (ORDER BY id ASC) "
                + " AS Rownumber, * FROM dbo.Menu) AS C "
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
                int id = rs.getInt("id");
                String priceTemp = rs.getString("price");
                String price = String.format(priceTemp, "##,##");
                String name = rs.getString("name");
                String content = rs.getString("content");
                listMenuArticles.add(new MenuArticle(id, price, name, content));
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }
        return listMenuArticles;
    }

    public int getTotal() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT Count(*) as Total FROM dbo.Menu";
        int total = 0;
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getInt("Total");
            }
        } catch (Exception e) {
            throw  e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }
        return total;
    }
}
