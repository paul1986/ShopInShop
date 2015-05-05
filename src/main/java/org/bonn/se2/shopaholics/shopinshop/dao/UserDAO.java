/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se2.shopaholics.shopinshop.dao;

import org.bonn.se2.shopaholics.shopinshop.model.User;

/**
 *
 * @author frank
 */
public interface UserDAO {
    User getUser(String username, String password);
}
