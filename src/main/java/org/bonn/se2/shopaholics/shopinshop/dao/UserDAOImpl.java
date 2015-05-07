/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se2.shopaholics.shopinshop.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.bonn.se2.shopaholics.shopinshop.model.User;

/**
 *
 * @author frank
 */
@RequestScoped
public class UserDAOImpl implements UserDAO, Serializable {
   
    @Override
    public User getUser(String username, String password) {

       /*
            
            User ret = new User();
            ret.setUsername(username);
            ret.setNachname("Müller");
            ret.setVorname("Peter");
            return ret;
            
            
            */
            
                    User user = null;

        try {
            InitialContext cxt = new InitialContext();

            DataSource ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/shopDB");
            ResultSet res = ds.getConnection().createStatement().executeQuery("SELECT * FROM shop.user where username = '" + username + "';");

            while (res.next()) {
                String pw = res.getString("password").trim();
                if (pw.equals(password)) {
                    user = new User();
                    user.setUsername(username);
                    user.setVorname(res.getString("vorname"));
                    user.setNachname(res.getString("nachname"));
                }
            }

        } catch (NamingException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
               
    }
    
}
