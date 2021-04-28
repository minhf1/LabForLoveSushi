/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Article;
import java.util.List;

/**
 *
 * @author admin
 */
public interface ArticleDAO extends DBContextDAO {

    /**
     * take image of articles 
     * @return @throws Exception
     */
    public Article GetImageArticle() throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */

    public Article getArticleByID(int id) throws Exception;

    /**
     *
     * @param size
     * @param index
     * @return
     * @throws Exception
     */

    public List<Article> getArticlePaging(int size, int index) throws Exception;

    /**
     *
     * @return @throws Exception
     */
    public int getTotal() throws Exception;
}
