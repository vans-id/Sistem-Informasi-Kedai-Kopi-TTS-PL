
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.cart_items;

import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author IdeaPad
 */
public class CartDatabase implements CartDao {

    private Session session;

    public CartDatabase(Session session) {
        this.session = session;
    }

    @Override
    public boolean insert(CartItem m) {
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            int kode = (int)session.save(m);
            session.getTransaction().commit();
            return kode != 0;
        } catch (Exception e) {
            Logger.getLogger(CartDatabase.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(CartItem m) {
        try {
            System.out.println(">>"+session.isConnected());
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.delete(m);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            Logger.getLogger(CartDatabase.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public List<CartItem> getCartItems() {
        try {
            session = HibernateUtil.getSession();
            return session.createQuery("FROM CartItem").list();
        } catch (HibernateException e) {
            System.out.println("ini custom log error: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public int deleteAll() {
        return 0;
    }
    
}
