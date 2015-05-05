/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se2.shopaholics.shopinshop.ui.views.components;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Runo;
import org.bonn.se2.shopaholics.shopinshop.util.StyleNames;

/**
 *
 * @author frank
 */
public class UserMenu extends Panel {
    
    private Label lblUser;
    private Button btnLogout;
    
    public UserMenu() {
        
        VerticalLayout holeUserMenuLayout = new VerticalLayout();
        lblUser = new Label();
        holeUserMenuLayout.addComponent(lblUser);
        holeUserMenuLayout.setComponentAlignment(lblUser, Alignment.MIDDLE_CENTER);
        
        VerticalLayout componentsLayout = new VerticalLayout();
        holeUserMenuLayout.addComponent(componentsLayout);
        componentsLayout.addStyleName(StyleNames.USER_MENU_ITEM_BOX);
        
        btnLogout = new Button("logout");
        
        componentsLayout.addComponent(btnLogout);
        componentsLayout.setComponentAlignment(btnLogout, Alignment.MIDDLE_CENTER);
        this.addStyleName(Runo.PANEL_LIGHT);
        this.addStyleName(StyleNames.USER_MENU);
        this.setContent(holeUserMenuLayout);
    }
    
    public Button getBtnLogout() {
        return btnLogout;
    }
    
    public Label getLblUser() {
        return lblUser;
    }
    
}
