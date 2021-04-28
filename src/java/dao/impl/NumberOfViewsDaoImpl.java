/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.impl.DBContextImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author lqhuy
 */
public class NumberOfViewsDaoImpl extends DBContextImpl implements dao.NumberOfViewsDAO{

    public int getNumber() throws Exception{ 
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from NumberOfViews ";
        try {
            con = new DBContextImpl().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("NumOfViews");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }

        return -1;
    }

    public void UpdateNumber1() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "update NumberOfViews set NumOfViews = NumOfViews + 1";
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();
        } catch (Exception e) {
            throw e;
        }
    }

    
}
