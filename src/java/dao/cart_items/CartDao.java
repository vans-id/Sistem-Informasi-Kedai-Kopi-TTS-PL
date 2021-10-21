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
public interface CartDao {
    public boolean insert(CartItem m);

    public boolean delete(CartItem m);
    
    public int deleteAll();

    public List<CartItem> getCartItems();
}
