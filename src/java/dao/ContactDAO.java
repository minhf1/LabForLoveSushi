/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Contact;
import java.util.List;

/**
 *
 * @author admin
 */
public interface ContactDAO extends DBContextDAO{

    public Contact getContact() throws Exception;

    public List<Contact> getListContact() throws Exception;

}
