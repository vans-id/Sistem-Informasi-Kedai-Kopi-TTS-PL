/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.cart_items.CartDao;
import dao.cart_items.CartDatabase;
import dao.main_menu.MenuDao;
import dao.main_menu.MenuDatabase;
import dao.transactions.TransactionDao;
import dao.transactions.TransactionDatabase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Administrator
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static MenuDao menuDAO;
    private static CartDao cartDao;
    private static TransactionDao transactionDao;
    private static Session session;

//static SessionFactory sessionFactory;       
    public static Session getSession() {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            return session;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static MenuDao getMenuDao() {
        System.out.println("menu dao " + menuDAO);
        if (menuDAO == null) {
            menuDAO = new MenuDatabase(getSession());
        }
        return menuDAO;
    }
    
    public static CartDao getCartDao() {
        if (cartDao == null) {
            cartDao = new CartDatabase(getSession());
        }
        return cartDao;
    }
    
    public static TransactionDao getTransactionDao() {
        if (transactionDao == null) {
            transactionDao = new TransactionDatabase(getSession());
        }
        return transactionDao;
    }

    private static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
