/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se2.shopaholics.shopinshop.model;

import org.bonn.se2.shopaholics.shopinshop.model.User;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author frank
 */
@SessionScoped
public class UserSession implements Serializable {
    
    private User user;
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public User getUser() {
        return user;
    }
}
