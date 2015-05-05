/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se2.shopaholics.shopinshop.ui.controller;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.bonn.se2.shopaholics.shopinshop.model.UserSession;

/**
 *
 * @author frank
 */
@RequestScoped
public class UserController implements Serializable {
    
    @Inject
    private UserSession userSession;
    
    public boolean checkSession() {
        return userSession.getUser() != null;
    }
    
    public String getVorname() {
        return userSession.getUser().getVorname();
    }
    
    public String getGanzerName() {
        return userSession.getUser().getVorname() + " " + userSession.getUser().getNachname();
    }
    
    public void logout() {
        userSession.setUser(null);
    }
    
}
