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
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import java.util.List;
import javax.inject.Inject;
import org.bonn.se2.shopaholics.shopinshop.model.Product;
import org.bonn.se2.shopaholics.shopinshop.ui.controller.ProductOverviewController;
import org.bonn.se2.shopaholics.shopinshop.ui.views.components.LoginNeededComponent;

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
        
        BeanContainer<Integer, Product> data = new BeanContainer<Integer, Product>(Product.class);
        data.setBeanIdProperty("art_nr");
        data.addAll(result);
        Table table = new Table("Produktübersicht", data);
        table.setSelectable(true);
        verticalLayout.addComponent(table);
    }

}
