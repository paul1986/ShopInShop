package org.bonn.se2.shopaholics.shopinshop.ui;

import org.bonn.se2.shopaholics.shopinshop.ui.views.LoginView;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import javax.inject.Inject;
import org.bonn.se2.shopaholics.shopinshop.ui.controller.UserController;
import org.bonn.se2.shopaholics.shopinshop.events.NavigationEvent;
import org.bonn.se2.shopaholics.shopinshop.ui.views.MainView;
import org.bonn.se2.shopaholics.shopinshop.ui.views.ViewNames;
import org.bonn.se2.shopaholics.shopinshop.util.StyleNames;

/**
 *
 */
@Theme("mytheme")
@Widgetset("org.bonn.se2.shopaholics.shopinshop.MyAppWidgetset")
@CDIUI("")
public class MyUI extends UI {
    
    @Inject
    private javax.enterprise.event.Event<NavigationEvent> navigationEvent;
    
    @Inject
    private UserController controller;
    
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        
        //ACHTUNG
        //ACHTUNG
        //ACHTUNG
        //Diese Anwendung muss im TomEE deployed werden und NICHT
        //im Standard-Tomcat, da wir CDI einsetzen.
        //TomEE ist eine andere Version des Tomcatservers (Webprofile), diese findet sich unter dem folgenden Link:
        //http://tomee.apache.org/downloads.html
        //Installation: 
        //1: Entpacken, ggf chmod auf alle *.sh Datein im Ordner Bin
        //2: In NetBeans unter Services Server hinzufügen - Fertig
        
        this.addStyleName(StyleNames.APP);
        
        if (!controller.checkSession()) {
            navigationEvent.fire(new NavigationEvent(ViewNames.LOGIN));
        } else {
            navigationEvent.fire(new NavigationEvent(ViewNames.MAIN));
        }
    }
}
