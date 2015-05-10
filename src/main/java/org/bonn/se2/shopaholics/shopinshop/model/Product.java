/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bonn.se2.shopaholics.shopinshop.model;

/**
 *
 * @author lucasprochnow
 */
public class Product {
    private int art_nr, verfuegbarkeit, shop_id;
    private String art_name, art_beschr;
    private double art_preis;

    public int getArt_nr() {
        return art_nr;
    }

    public void setArt_nr(int art_nr) {
        this.art_nr = art_nr;
    }

    public int getVerfuegbarkeit() {
        return verfuegbarkeit;
    }

    public void setVerfuegbarkeit(int verfuegbarkeit) {
        this.verfuegbarkeit = verfuegbarkeit;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public String getArt_name() {
        return art_name;
    }

    public void setArt_name(String art_name) {
        this.art_name = art_name;
    }

    public String getArt_beschr() {
        return art_beschr;
    }

    public void setArt_beschr(String art_beschr) {
        this.art_beschr = art_beschr;
    }

    public double getArt_preis() {
        return art_preis;
    }

    public void setArt_preis(double art_preis) {
        this.art_preis = art_preis;
    }
    
    
}
