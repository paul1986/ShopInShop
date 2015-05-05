/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se2.shopaholics.shopinshop.ui.views;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import javax.inject.Inject;
import org.bonn.se2.shopaholics.shopinshop.util.Images;
import org.bonn.se2.shopaholics.shopinshop.ui.controller.LoginController;
import org.bonn.se2.shopaholics.shopinshop.events.NavigationEvent;
import org.bonn.se2.shopaholics.shopinshop.util.StyleNames;

/**
 *
 * @author frank
 */
@CDIView(ViewNames.LOGIN)
public class LoginView extends CustomComponent implements View {
    
    @Inject
    private LoginController controller;
    
    @Inject
    private javax.enterprise.event.Event<NavigationEvent> navigationEvent;
    
    private TextField txtUser;
    
    private PasswordField txtPassword;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        
        this.setSizeFull();
        this.addStyleName(StyleNames.LOGIN_VIEW);
       
        VerticalLayout contentLayout = new VerticalLayout();
        this.setCompositionRoot(contentLayout);
        contentLayout.setSizeFull();
        
        Image headerImage = Images.getImageByImageName(Images.HEADER);
        headerImage.addStyleName(StyleNames.HEADER_IMAGE);
        
        contentLayout.addComponent(headerImage);
        contentLayout.setComponentAlignment(headerImage, Alignment.TOP_CENTER);

        Panel loginPanel = new Panel("Login");
        contentLayout.addComponent(loginPanel);
        contentLayout.setComponentAlignment(loginPanel, Alignment.TOP_CENTER);
        
        VerticalLayout loginComponentsLayout = new VerticalLayout();
        loginPanel.setContent(loginComponentsLayout);
        loginPanel.setSizeUndefined();
        
        txtUser = new TextField("User: ");
        txtPassword = new PasswordField("Passwort: ");

        Button loginButton = new Button("Login");
        loginButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                doLogin();
            }
        });

        
        loginComponentsLayout.addComponent(txtUser);
        loginComponentsLayout.addComponent(txtPassword);
        loginComponentsLayout.addComponent(new Label("<br />", ContentMode.HTML));
        loginComponentsLayout.addComponent(loginButton);
        loginComponentsLayout.setComponentAlignment(loginButton, Alignment.MIDDLE_CENTER);
        
        txtUser.focus();
    }
    
    
    private void doLogin() {
        
        boolean felderGefuellt = checkFelder();
        
        if (felderGefuellt) {
            boolean loginErfolgreich = controller.login(txtUser.getValue(), txtPassword.getValue());
            
            if (loginErfolgreich) {
                navigationEvent.fire(new NavigationEvent(ViewNames.MAIN));
            } else {
                new Notification("Login fehlgeschlagen", "Die angegebenen Nutzerdaten sind leider nicht korrekt. Bitte überprüfen Sie Ihre Eingabe."
                        , Notification.Type.HUMANIZED_MESSAGE).show(getUI().getPage());
            }
            
        } else {
            new Notification("Userdaten eingeben", "Bitte geben Sie Nutzernamen "
                    + "und Password an", Notification.Type.HUMANIZED_MESSAGE)
                    .show(getUI().getPage());
        }
    }
    
    private boolean checkFelder() {
        if (txtPassword.getValue().equals("") || txtUser.getValue().equals("")) {
            return false;
        }
        
        return true;
    }
    
}
