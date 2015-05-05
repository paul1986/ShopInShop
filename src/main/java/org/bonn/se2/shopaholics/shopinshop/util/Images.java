/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se2.shopaholics.shopinshop.util;

import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Image;
import java.io.File;

/**
 *
 * @author frank
 */
public class Images {
    public static final String HEADER = "/WEB-INF/images/Header.png";
    public static final String SHOP_HEADER = "/WEB-INF/images/ShopLogo.png";
    
    public static Image getImageByImageName(String imageName) {
        String basePath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
        
        FileResource resource = new FileResource(new File(basePath + imageName));
        
        return new Image("", resource);
    }
    
}
