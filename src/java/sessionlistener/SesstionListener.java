/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionlistener;

import dao.impl.NumberOfViewsDaoImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application life cycle listener.
 *
 */
public class SesstionListener implements HttpSessionListener { //Lưu ý: Nhớ khai báo sessionlistener trong xml thì nó mới tăng view được
/**
 * create session
 * @param hse 
 */
    @Override
    public void sessionCreated(HttpSessionEvent hse) {
       NumberOfViewsDaoImpl NumDao = new NumberOfViewsDaoImpl();
        try {
            NumDao.UpdateNumber1();
            String s= String.format("%06d", NumDao.getNumber());
            hse.getSession().setAttribute("s", s);  // Bên footer.jsp sẽ getattribute cái "s"
        } catch (Exception e) {
            Logger.getLogger(SesstionListener.class.getName()).log(Level.SEVERE,null,e);
        } 
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent hse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
