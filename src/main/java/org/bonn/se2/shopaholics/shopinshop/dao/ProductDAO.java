/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se2.shopaholics.shopinshop.dao;

import java.io.Serializable;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.bonn.se2.shopaholics.shopinshop.model.Product;
import org.bonn.se2.shopaholics.shopinshop.model.User;

/**
 *
 * @author lucasprochnow
 */
@RequestScoped
public class ProductDAO implements Serializable {

    public List<Product> getAllProducts() {
//        List<Product> tempList = new LinkedList<Product>();
//
//        //DB Mock-Up
//        Product mock1 = new Product();
//        Product mock2 = new Product();
//        mock1.setArt_name("Mitschrift DBS");
//        mock1.setArt_beschr("Es handelt sich um eine Mitschrift für das Fach Datenbanksysteme bei Prof. Dr. Knolle vom SS2014; Autor ist Otto Mueller");
//        mock1.setArt_nr(1);
//        mock1.setShop_id(1);
//        mock1.setVerfuegbarkeit(30);
//        mock1.setArt_preis(4.0);
//
//        mock2.setArt_name("Nachhilfe SEI");
//        mock2.setArt_beschr("Frank gibt gerne Nachhilfe in Software Engineering. Der Preis & die Verfügbarkeit bezieht sich auf Stunden die Woche");
//        mock2.setArt_nr(2);
//        mock2.setShop_id(2);
//        mock2.setVerfuegbarkeit(4);
//        mock2.setArt_preis(40.30);
//
//        tempList.add(mock1);
//        tempList.add(mock2);
//
//        return tempList;
        List<Product> tempList = new LinkedList<Product>();

        try {
            InitialContext cxt = new InitialContext();

            DataSource ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/shopDB");
            ResultSet res = ds.getConnection().createStatement().executeQuery("SELECT * FROM shop.artikel");

            while (res.next()) {
                Product p = new Product();
                p.setArt_nr(parseInt(res.getString("artikel_nr")));
                p.setArt_name(res.getString("artikel_name"));
                p.setArt_beschr(res.getString("artikel_beschreibung"));
                p.setVerfuegbarkeit(parseInt(res.getString("verfuegbarkeit")));
                p.setShop_id(parseInt(res.getString("shop_id")));
                p.setArt_preis(parseDouble(res.getString("artikel_preis")));
                tempList.add(p);
            }

        } catch (NamingException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tempList;

    }

    public List<Product> getProductsFromShop(String Shopname) {
        List<Product> tempList = new LinkedList<Product>();

        //DB Mock-Up
        Product mock1 = new Product();

        mock1.setArt_name("Nachhilfe SEI");
        mock1.setArt_beschr("Frank gibt gerne Nachhilfe in Software Engineering. Der Preis & die Verfügbarkeit bezieht sich auf Stunden die Woche");
        mock1.setArt_nr(2);
        mock1.setShop_id(2);
        mock1.setVerfuegbarkeit(4);
        mock1.setArt_preis(40.30);

        tempList.add(mock1);

        return tempList;
    }
}
