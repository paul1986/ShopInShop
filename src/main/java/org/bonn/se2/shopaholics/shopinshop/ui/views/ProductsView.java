/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se2.shopaholics.shopinshop.ui.views;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
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
//        verticalLayout.addComponent(new Label("Liste der Produkte"));
//        GridLayout columnNames = new GridLayout(4, 1);
//        column.addComponent(new Label());
//        
//        List<Product> result = poc.getAllProducts();
//        for(int i = 0; i < result.size(); ++i){
//            GridLayout grid = new GridLayout(4, 1);
//            grid.addComponent(new Label());
//
//            verticalLayout.addComponent(grid);
//        }

        //initialisiere
        List<Product> result = poc.getAllProducts();
        GridLayout myGrid = new GridLayout(4, result.size() + 1);

        //set Column Names
        myGrid.addComponent(new Label("Name"));
        myGrid.addComponent(new Label("Beschreibung"));
        myGrid.addComponent(new Label("Verfügbarkeit"));
        myGrid.addComponent(new Label("Preis"));
//
//        myGrid.setWidth("900px");
//        myGrid.setColumnExpandRatio(1, 1);

        verticalLayout.addComponent(myGrid);
    }

}
