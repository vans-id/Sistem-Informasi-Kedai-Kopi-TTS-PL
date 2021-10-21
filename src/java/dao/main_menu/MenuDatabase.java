
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.main_menu;

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
public class MenuDatabase implements MenuDao {
    
    private Session session;

    public MenuDatabase(Session session) {
        this.session = session;
    }

    @Override
    public boolean insert(MainMenu m) {
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            int kode = (int)session.save(m);
            session.getTransaction().commit();
            return kode != 0;
        } catch (Exception e) {
            Logger.getLogger(MenuDatabase.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(MainMenu m) {
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.update(m);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            Logger.getLogger(MenuDatabase.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(MainMenu m) {
        try {
            System.out.println(">>"+session.isConnected());
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.delete(m);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            Logger.getLogger(MenuDatabase.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public MainMenu getMenuItem(String id) {
        try {
            session = HibernateUtil.getSession();
            Query query = session.createQuery("FROM mainmenu m WHERE m.id=:id");
            query.setParameter("id", id);
            return (MainMenu) query.uniqueResult();
        } catch (Exception e) {
            Logger.getLogger(MenuDatabase.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<MainMenu> getAllMenu() {
        try {
            session = HibernateUtil.getSession();
            // System.out.println(Arrays.toString(session.createQuery("FROM MainMenu").list().toArray()));
            return session.createQuery("FROM MainMenu m ORDER BY m.name").list();
        } catch (HibernateException e) {
            System.out.println("ini custom log error: " + e.toString());
            // Logger.getLogger(MenuDatabase.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            session.close();
        }
        return null;
    }
    
}
