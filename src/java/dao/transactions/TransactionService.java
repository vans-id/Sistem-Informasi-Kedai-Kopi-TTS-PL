/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.transactions;

import dao.main_menu.MainMenu;
import java.util.List;

/**
 *
 * @author IdeaPad
 */
public class TransactionService implements TransactionDao {
    
    private final TransactionDao dao;

    public TransactionService(TransactionDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean insert(Transaction t) {
        return dao.insert(t);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return dao.getAllTransactions();
    }
    
    
    
}
