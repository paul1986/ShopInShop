/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se2.shopaholics.shopinshop.ui.views.components;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.CustomComponent;
import javax.inject.Inject;
import org.bonn.se2.shopaholics.shopinshop.ui.controller.UserController;
import org.bonn.se2.shopaholics.shopinshop.events.NavigationEvent;
import org.bonn.se2.shopaholics.shopinshop.ui.views.LoginView;
import org.bonn.se2.shopaholics.shopinshop.ui.views.ViewNames;

/**
 *
 * @author frank
 */
public abstract class LoginNeededComponent extends CustomComponent implements View {
 
    @Inject
    private javax.enterprise.event.Event<NavigationEvent> navigationEvent;

    @Inject
    private UserController controller;
    
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {      
        if (!controller.checkSession()) {
            navigationEvent.fire(new NavigationEvent(ViewNames.LOGIN));
        } else {
            this.setSizeFull();
            viewEntered(event);
        }
    }
    
    public abstract void viewEntered(ViewChangeListener.ViewChangeEvent event);
}
