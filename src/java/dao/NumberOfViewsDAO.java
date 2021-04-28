/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author admin
 */
public interface NumberOfViewsDAO extends DBContextDAO{

    public int getNumber() throws Exception;

    public void UpdateNumber1() throws Exception;

    
}
