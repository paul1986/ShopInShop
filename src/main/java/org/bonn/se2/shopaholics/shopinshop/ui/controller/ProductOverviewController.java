/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se2.shopaholics.shopinshop.ui.controller;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.bonn.se2.shopaholics.shopinshop.dao.ProductDAO;
import org.bonn.se2.shopaholics.shopinshop.model.Product;

/**
 *
 * @author lucasprochnow
 */
@RequestScoped
public class ProductOverviewController implements Serializable {
    
    @Inject
    ProductDAO productDAO;
    
     public List<Product> getAllProducts() {
         return productDAO.getAllProducts();
     }
     
     public List<Product> getProductsFromShop(String Shopname) {
         return productDAO.getProductsFromShop(Shopname);
     }
    
}
