/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se2.shopaholics.shopinshop.ui.views;

import com.google.gwt.dom.client.Style;
import com.vaadin.cdi.CDIView;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import java.text.DecimalFormat;
import java.util.List;
import javax.inject.Inject;
import org.bonn.se2.shopaholics.shopinshop.model.Product;
import org.bonn.se2.shopaholics.shopinshop.ui.controller.ProductOverviewController;
import org.bonn.se2.shopaholics.shopinshop.ui.views.components.LoginNeededComponent;
import org.bonn.se2.shopaholics.shopinshop.util.StyleNames;

/**
 *
 * @author frank
 */
@CDIView(ViewNames.PRODUCTS)
public class ProductsView extends LoginNeededComponent {

    @Inject
    ProductOverviewController poc;

    @Override
    public void viewEntered(ViewChangeListener.ViewChangeEvent event) {
        VerticalLayout verticalLayout = new VerticalLayout();
        setCompositionRoot(verticalLayout);

        List<Product> result = poc.getAllProducts();
//        
//        BeanContainer<Integer, Product> data = new BeanContainer<Integer, Product>(Product.class);
//        data.setBeanIdProperty("art_nr");
//        data.addAll(result);
//        Table table = new Table("Produktübersicht", data);
//        table.setSelectable(true);
//        verticalLayout.addComponent(table);
        
        for (int i = 0; i < result.size(); ++i) {
            
            Label productName = new Label(result.get(i).getArt_name());
            productName.addStyleName(StyleNames.PRODUCTNAME);
            verticalLayout.addComponent(productName);
            
            Label productId = new Label("Artikelnummer: " + result.get(i).getArt_nr() + "");
            productId.addStyleName(StyleNames.PRODUCTID);
            verticalLayout.addComponent(productId);
            
            Label productDescription = new Label(result.get(i).getArt_beschr(), ContentMode.PREFORMATTED);
            productDescription.addStyleName(StyleNames.PRODUCTDESCRIPTION);
            verticalLayout.addComponent(productDescription);
            
            Label productPrice = new Label(new DecimalFormat("#.00€").format(result.get(i).getArt_preis()));
            productPrice.addStyleName(StyleNames.PRODUCTPRICE);
            verticalLayout.addComponent(productPrice);
            verticalLayout.setComponentAlignment(productPrice, Alignment.MIDDLE_RIGHT);
            
            Button cartButton = new Button();
            cartButton.setCaption("In den Warenkorb");
            cartButton.addStyleName(StyleNames.CARTBUTTON);
            verticalLayout.addComponent(cartButton);
            verticalLayout.setComponentAlignment(cartButton, Alignment.MIDDLE_RIGHT);
            
            Label separator = new Label();
            separator.addStyleName(StyleNames.SEPARATOR);
            verticalLayout.addComponent(separator);
            
        }
    }

}
