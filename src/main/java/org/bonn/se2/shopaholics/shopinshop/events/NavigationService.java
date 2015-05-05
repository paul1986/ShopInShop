/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se2.shopaholics.shopinshop.events;

import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.cdi.NormalUIScoped;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.UI;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 *
 * @author frank
 */
@NormalUIScoped
public class NavigationService implements Serializable {
    
    @Inject
    private CDIViewProvider viewProvider;
    
    //@Inject
    //private ErrorView errorView;

    @Inject
    private UI ui;

    @PostConstruct
    public void initialize() {
        if (ui.getNavigator() == null) {
            Navigator navigator = new Navigator(ui, ui);
            navigator.addProvider(viewProvider);
            //navigator.setErrorView(errorView);
        }
    }

    public void onNavigationEvent(@Observes NavigationEvent event) {
        try {
            ui.getNavigator().navigateTo(event.getNavigateTo());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void onContainerEvent(@Observes ChangeComponentContainerEvent event) {
        Navigator navigator = new Navigator(ui, event.getComponentContainer());
        navigator.addProvider(viewProvider);
    }
}
