/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.transactions;

import java.util.List;

/**
 *
 * @author IdeaPad
 */
public interface TransactionDao {
    public boolean insert(Transaction t);
    public List<Transaction> getAllTransactions();
}
