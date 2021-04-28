/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import entity.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class ContactDAOImpl extends DBContextImpl implements dao.ContactDAO{

  

    public List<Contact> getListContact() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Contact> listContact = new ArrayList<>();
        String sql = "SELECT * FROM Contact";
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Contact c = new Contact();
                c.setId(rs.getInt("id"));
                c.setAddress(rs.getString("address"));
                c.setTel(rs.getString("tel"));
                c.setEmail(rs.getString("email"));
                c.setOpenday(rs.getString("openday"));
                listContact.add(c);
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }
        return listContact;
    }

    @Override
    public Contact getContact() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
