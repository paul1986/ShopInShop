/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se2.shopaholics.shopinshop.ui.views;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.bonn.se2.shopaholics.shopinshop.ui.views.components.LoginNeededComponent;

/**
 *
 * @author frank
 */
@CDIView(ViewNames.PRODUCTS)
public class ProductsView extends LoginNeededComponent {

    @Override
    public void viewEntered(ViewChangeListener.ViewChangeEvent event) {
        VerticalLayout verticalLayout = new VerticalLayout();
        setCompositionRoot(verticalLayout);
        verticalLayout.addComponent(new Label("Liste der Produkte"));
    }
    
}
