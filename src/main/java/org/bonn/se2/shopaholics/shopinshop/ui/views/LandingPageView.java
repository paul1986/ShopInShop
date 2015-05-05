/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se2.shopaholics.shopinshop.ui.views;

import org.bonn.se2.shopaholics.shopinshop.ui.views.components.LoginNeededComponent;
import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import javax.inject.Inject;
import org.bonn.se2.shopaholics.shopinshop.ui.controller.UserController;

/**
 *
 * @author frank
 */
@CDIView(ViewNames.LANDING_PAGE)
public class LandingPageView extends LoginNeededComponent {
    
    @Inject
    private UserController userController;
    
    @Override
    public void viewEntered(ViewChangeListener.ViewChangeEvent event) {
        VerticalLayout verticalLayout = new VerticalLayout();
        setCompositionRoot(verticalLayout);
        verticalLayout.addComponent(new Label("Hallo " + userController.getVorname()));
    }
    
}
