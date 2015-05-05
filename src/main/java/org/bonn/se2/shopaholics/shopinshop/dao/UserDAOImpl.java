/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se2.shopaholics.shopinshop.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;
import org.bonn.se2.shopaholics.shopinshop.model.User;

/**
 *
 * @author frank
 */
@RequestScoped
public class UserDAOImpl implements UserDAO, Serializable {
    
    
    @Resource
    private DataSource shopDS;
    
    
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
                Connection con = shopDS.getConnection();
                ResultSet res = con.createStatement().executeQuery("SELECT * FROM shop.user where username = '" + username + "';");
                while(res.next()) {
                String pw = res.getString("password").trim();
                    if (pw.equals(password)) {
                        user = new User();
                        user.setUsername(username);
                        user.setVorname(res.getString("vorname"));
                        user.setNachname(res.getString("nachname"));
                    }
                }
            }
            catch (Exception ex) {
            
            }
            
            return user;
            
            
            
            /*
        
            User user = null;
        
            try {
            
            DriverManager.registerDriver(new org.postgresql.Driver());
            String url = "jdbc:postgresql://dumbo.inf.fh-bonn-rhein-sieg.de:5432/kmisin2s";
            Properties pros = new Properties();
            pros.setProperty("user", "kmisin2s");
            pros.setProperty("password", "kmisin2s");
            
            Connection con = DriverManager.getConnection(url, pros);
            
            Statement st;
            st = con.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT * FROM shop.user;");
            
            while(rs.next()) {
                String pw = rs.getString("password");
                
                if (pw.equals(password)) {
                    user = new User();
                    user.setVorname(rs.getString("vorname"));
                    user.setNachname(rs.getString("nachname"));
                    user.setUsername(username);
                }
            } 
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return user;
                    
                    */
                
               
    }
    
}
