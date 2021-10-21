/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.main_menu;

import dao.main_menu.MainMenu;
import java.util.List;

/**
 *
 * @author IdeaPad
 */
public class MenuService implements MenuDao {
    
    private final MenuDao dao;

    public MenuService(MenuDao dao) {
        this.dao = dao;
    }
    
    @Override
    public boolean insert(MainMenu m) {
        return dao.insert(m);
    }

    @Override
    public boolean update(MainMenu m) {
        return dao.update(m);
    }

    @Override
    public boolean delete(MainMenu m) {
        return dao.delete(m);
    }

    @Override
    public MainMenu getMenuItem(String id) {
        return dao.getMenuItem(id);
    }

    @Override
    public List<MainMenu> getAllMenu() {
        return dao.getAllMenu();
    }
    
}
