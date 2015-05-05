/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se2.shopaholics.shopinshop.events;

/**
 *
 * @author frank
 */
public class NavigationEvent {
    private final String navigateTo;

    public NavigationEvent(String navigateTo) {
        this.navigateTo = navigateTo;
    }

    public String getNavigateTo() {
        return navigateTo;
    }
}
