/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se2.shopaholics.shopinshop.ui.views.components;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import org.bonn.se2.shopaholics.shopinshop.util.StyleNames;

/**
 *
 * @author frank
 */
public class MenuItem extends HorizontalLayout {
    
    private Label label;
    
    public MenuItem(String title) {
        label = new Label(title);
        this.addComponent(label);
    }
    
}
