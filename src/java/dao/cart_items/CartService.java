/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.cart_items;

import java.util.List;

/**
 *
 * @author IdeaPad
 */
public class CartService implements CartDao {
    
    private final CartDao dao;

    public CartService(CartDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean insert(CartItem m) {
        return dao.insert(m);
    }

    @Override
    public boolean delete(CartItem m) {
        return dao.delete(m);
    }

    @Override
    public List<CartItem> getCartItems() {
        return dao.getCartItems();
    }

    @Override
    public int deleteAll() {
        return dao.deleteAll();
    }
    
    
    
}
