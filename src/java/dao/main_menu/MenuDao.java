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
public interface MenuDao {
    public boolean insert(MainMenu m);

    public boolean update(MainMenu m);

    public boolean delete(MainMenu m);

    public MainMenu getMenuItem(String id);

    public List<MainMenu> getAllMenu();
}
