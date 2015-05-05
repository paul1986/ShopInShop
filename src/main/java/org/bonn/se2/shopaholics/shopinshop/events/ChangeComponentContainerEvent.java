/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se2.shopaholics.shopinshop.events;

import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.SingleComponentContainer;

/**
 *
 * @author frank
 */
public class ChangeComponentContainerEvent {
    private SingleComponentContainer container;
    
    public ChangeComponentContainerEvent(SingleComponentContainer container) {
        this.container = container;
    }
    
    public SingleComponentContainer getComponentContainer() {
        return container;
    }
}
