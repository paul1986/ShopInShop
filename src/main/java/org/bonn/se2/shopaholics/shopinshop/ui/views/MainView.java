/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se2.shopaholics.shopinshop.ui.views;

import org.bonn.se2.shopaholics.shopinshop.ui.views.components.LoginNeededComponent;
import com.vaadin.cdi.CDIView;
import com.vaadin.event.LayoutEvents;
import com.vaadin.event.MouseEvents;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Runo;
import javax.inject.Inject;
import org.bonn.se2.shopaholics.shopinshop.ui.controller.UserController;
import org.bonn.se2.shopaholics.shopinshop.events.ChangeComponentContainerEvent;
import org.bonn.se2.shopaholics.shopinshop.events.NavigationEvent;
import org.bonn.se2.shopaholics.shopinshop.ui.views.components.Menu;
import org.bonn.se2.shopaholics.shopinshop.ui.views.components.MenuItem;
import org.bonn.se2.shopaholics.shopinshop.ui.views.components.UserMenu;
import org.bonn.se2.shopaholics.shopinshop.util.Images;
import org.bonn.se2.shopaholics.shopinshop.util.StyleNames;

/**
 *
 * @author frank
 */

@CDIView(ViewNames.MAIN)
public class MainView extends LoginNeededComponent{
    
    @Inject
    private javax.enterprise.event.Event<ChangeComponentContainerEvent> containerEvent;
    
    @Inject
    private javax.enterprise.event.Event<NavigationEvent> navigationEvent;
    
    @Inject
    private UserController userController;
    
    private Menu menu;
    
    private Panel contentPanel;
    
    private UserMenu usermenu;

    @Override
    public void viewEntered(ViewChangeListener.ViewChangeEvent event) {
        
        this.setHeight(null);
        this.addStyleName(StyleNames.MAIN_VIEW);
        
        VerticalLayout verticalLayout = new VerticalLayout();
        setCompositionRoot(verticalLayout);
        
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        
        menu = createMenu();
        usermenu = createUserMenu();
       
        contentPanel = new Panel();
        contentPanel.addStyleName(StyleNames.CONTENT_PANEL);
        contentPanel.addStyleName(Runo.PANEL_LIGHT);
        horizontalLayout.addComponent(menu);
        horizontalLayout.addComponent(contentPanel);
        horizontalLayout.addComponent(usermenu);
        
        Image image = Images.getImageByImageName(Images.SHOP_HEADER);
        image.addStyleName(StyleNames.SHOP_LOGO);
        image.addClickListener(new MouseEvents.ClickListener() {
            @Override
            public void click(MouseEvents.ClickEvent event) {
                navigationEvent.fire(new NavigationEvent(ViewNames.LANDING_PAGE));
            }
        });
        
        verticalLayout.addComponent(image);
        verticalLayout.addComponent(horizontalLayout);
        
        containerEvent.fire(new ChangeComponentContainerEvent(contentPanel));

        navigationEvent.fire(new NavigationEvent(ViewNames.LANDING_PAGE));
    }

    private Menu createMenu() {
        Menu menu = new Menu();
        
        MenuItem start = createMenuItem("Start", ViewNames.LANDING_PAGE);
        MenuItem shops = createMenuItem("Shops", ViewNames.SHOPS);
        MenuItem products = createMenuItem("Produkte", ViewNames.PRODUCTS);
        
        menu.addMenuItem(start);
        menu.addMenuItem(shops);
         
        menu.build();
        
        return menu;
        
    }
    
    private MenuItem createMenuItem(String title, final String viewname) {
        MenuItem item = new MenuItem(title);
        item.addLayoutClickListener(new LayoutEvents.LayoutClickListener() {

            @Override
            public void layoutClick(LayoutEvents.LayoutClickEvent event) {
                navigationEvent.fire(new NavigationEvent(viewname));
            }
        });
        
        return item;
    } 

    private UserMenu createUserMenu() {
        usermenu = new UserMenu();
        usermenu.getLblUser().setValue("Hallo " + userController.getGanzerName());
        usermenu.getBtnLogout().addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                performLogout();
            }
        });
        
        return usermenu;
    }
    
    private void performLogout() {
        userController.logout();
        new Notification("Logout erfolgreich", "Vielen Dank für Ihren Besuch", Notification.Type.HUMANIZED_MESSAGE).show(getUI().getPage());
        containerEvent.fire(new ChangeComponentContainerEvent(getUI()));
        navigationEvent.fire(new NavigationEvent(ViewNames.LOGIN));
    }

}
