/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se2.shopaholics.shopinshop.ui.views.components;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Runo;
import java.util.ArrayList;
import java.util.List;
import org.bonn.se2.shopaholics.shopinshop.util.StyleNames;

/**
 *
 * @author frank
 */
public class Menu extends Panel {
    
    private List<MenuItem> menuItems;
    
    public Menu() {
        menuItems = new ArrayList<>();
        this.addStyleName(Runo.PANEL_LIGHT);
        this.addStyleName(StyleNames.MENU);
    }
    
    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }
    
    public boolean removeItem(MenuItem item) {
        return menuItems.remove(item);
    }
    
    public void build() {
        
        VerticalLayout holeMenuLayout = new VerticalLayout();
        Label label = new Label("Menu");
        holeMenuLayout.addComponent(label);
        holeMenuLayout.setComponentAlignment(label, Alignment.MIDDLE_CENTER);
        
        VerticalLayout itemsLayout = new VerticalLayout();
        itemsLayout.addStyleName(StyleNames.MENU_ITEM_BOX);
        holeMenuLayout.addComponent(itemsLayout);
        
        for(int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i);
            
            if (i % 2 == 0) {
                item.addStyleName(StyleNames.MENU_ITEM_ONE);
            } else {
                item.addStyleName(StyleNames.MENU_ITEM_TWO);
            }
            
            itemsLayout.addComponent(item);
        }
        
        this.setContent(holeMenuLayout);
    }
    
}
