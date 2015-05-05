/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se2.shopaholics.shopinshop.ui.controller;

import org.bonn.se2.shopaholics.shopinshop.dao.UserDAO;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.bonn.se2.shopaholics.shopinshop.model.User;
import org.bonn.se2.shopaholics.shopinshop.model.UserSession;

/**
 *
 * @author frank
 */
@RequestScoped
public class LoginController implements Serializable {
    
    @Inject
    private UserSession userSession;
    
    @Inject
    private UserDAO userDAO;
    
    public boolean login(String username, String password) {
        
        User user = userDAO.getUser(username, password);
        
        if (user != null) {
            userSession.setUser(user);
            return true;
        }         
        return false;
    }
    
}
