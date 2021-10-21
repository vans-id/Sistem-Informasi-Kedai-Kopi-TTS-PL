/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.cart_items.CartItem;
import dao.cart_items.CartService;
import dao.main_menu.MainMenu;
import dao.main_menu.MenuService;
import dao.transactions.Transaction;
import dao.transactions.TransactionService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import util.HibernateUtil;
import util.Mapper;
import util.Type;

/**
 *
 * @author IdeaPad
 */
@ManagedBean(eager = true)
@RequestScoped
public class TransactionsBean {
    
    // handle inputs
    String productName;
    String price;
    String stock;
    String productType;
    
    ArrayList<MainMenu> items = new ArrayList<>();
    ArrayList<CartItem> cartItems = new ArrayList<>();
    
    private final Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    
    private final Mapper mapper = new Mapper();
    
    MenuService menuService = new MenuService(HibernateUtil.getMenuDao()); 
    CartService cartService = new CartService(HibernateUtil.getCartDao()); 
    TransactionService transactionService = new TransactionService(HibernateUtil.getTransactionDao()); 

    
    public TransactionsBean() {
        this.items.addAll(menuService.getAllMenu());
        this.cartItems.addAll(cartService.getCartItems());
    }
    
    // Menu items
    public List<MainMenu> getAllFoods() {
        ArrayList<MainMenu> foods = new ArrayList<>();
        
        for (MainMenu item : items) {
            if (item.getType().equals(Type.FOOD)) {
                foods.add(item);
            }
        }
        return foods;
    }
    
    public List<MainMenu> getAllDrinks() {
        ArrayList<MainMenu> drinks = new ArrayList<>();
        
        for (MainMenu item : items) {
            if (item.getType().equals(Type.DRINK)) {
                drinks.add(item);
            }
        }
        
        return drinks;
    }
    
    public List<CartItem> getAllCartItems() {
        return cartItems;
    }
    
    // Menu
    public void removeItemFromMenu(MainMenu selectedItem) {
        // remove from UI
        int index = items.indexOf(selectedItem);
        if(index == -1) {
            return;
        }
        this.items.remove(selectedItem);
        
        MainMenu item = new MainMenu(
            selectedItem.getId(),
            selectedItem.getName(),
                selectedItem.getPrice(),
                selectedItem.getStock(),
                selectedItem.getType()
        );
        menuService.delete(item);
    }
    
    public String addItemToMenu() {
        MainMenu newItem = new MainMenu(
            (int) (Math.random() * 1000),
            productName,
            Integer.parseInt(price),
            Integer.parseInt(stock),
            mapper.mapStringToType(productType)
        );
        menuService.insert(newItem);
        System.out.println(newItem);
        
        return "index?faces-redirect=true";
    }

    public String onEdit(MainMenu curItem) {
        sessionMap.put("editItem", curItem);  
        return "edit?faces-redirect=true";
    }
    
    public String onSaveItem(MainMenu savedItem) {
        MainMenu item = new MainMenu(
            savedItem.getId(),
            savedItem.getName(),
                savedItem.getPrice(),
                savedItem.getStock(),
                savedItem.getType()
        );
        menuService.update(item);
        return "index?faces-redirect=true";
    }
    
    // Cart
    public void addToCart(MainMenu item) {
        CartItem selectedItem = new CartItem(
                (int) (Math.random() * 1000),
                item.getName(),
                item.getPrice()
        );
        
	this.cartService.insert(selectedItem);
        System.out.println("Menambahkan " + selectedItem.getName());

    }
    
    public void deleteFromCart(CartItem item) {
        int index = cartItems.indexOf(item);
        if(index == -1) {
            return;
        }
        this.cartItems.remove(item);
        
        CartItem selectedItem = new CartItem(
                item.getId(),
                item.getName(),
                item.getPrice()
        );
        this.cartService.delete(selectedItem);
    }
    
    public int getTotalPrice() {
        int totalPrice = 0;
        
        for (CartItem item : cartItems) {
            totalPrice += item.getPrice();
        }
        
        return totalPrice;
    }
    
    public String onCheckout() {
        Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss [EEEE]");  
        String strDate = dateFormat.format(date);  
        StringBuilder str
            = new StringBuilder();
        
        int totalPrice = 0;
        for (CartItem item : cartItems) {
            str.append("1x ").append(item.getName()).append(" - Rp ").append(item.getPrice()).append("\n");
            totalPrice += item.getPrice();
        }
        str.append("Total - Rp ").append(totalPrice);
        
        // add new transaction
        Transaction t = new Transaction(
            (int) (Math.random() * 1000000),
            strDate,
            str.toString()
        );
        this.transactionService.insert(t);
        
        // clear cart
        for (CartItem item : cartItems) {
            this.cartService.delete(item);
        }
        
        
        return "index?faces-redirect=true";
    }
    
    // Transactions
    public List<Transaction> getTransactions() {
        return this.transactionService.getAllTransactions();
    }
    
    // Getters and setters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
    
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
    
}
