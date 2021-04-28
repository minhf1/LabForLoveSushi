/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.MenuArticle;
import java.util.List;

/**
 *
 * @author admin
 */
public interface MenuArticleDAO {
     public List<MenuArticle> getMenuArticlePaging(int size, int index) throws Exception;
      public int getTotal() throws Exception;
    
}
