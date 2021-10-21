
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.transactions;

import dao.transactions.TransactionDao;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author IdeaPad
 */
public class TransactionDatabase implements TransactionDao {
    
    private Session session;

    public TransactionDatabase(Session session) {
        this.session = session;
    }

    @Override
    public boolean insert(Transaction t) {
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            int kode = (int)session.save(t);
            session.getTransaction().commit();
            return kode != 0;
        } catch (Exception e) {
            Logger.getLogger(TransactionDatabase.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        try {
            session = HibernateUtil.getSession();
            return session.createQuery("FROM Transaction t ORDER BY t.timestamp DESC").list();
        } catch (HibernateException e) {
            System.out.println("ini custom log error: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }

    
    
}
