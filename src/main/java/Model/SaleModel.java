/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Matheus
 */
public class SaleModel implements Serializable {
    private int id;
    private Date date;
    private int quantity;
    private double value;
    private String client;
    private String product;

    public SaleModel(int id, Date date, int quantity, double value, String client, String product) {
        this.id = id;
        this.date = date;
        this.quantity = quantity;
        this.value = value;
        this.client = client;
        this.product = product;
    }

    public SaleModel() {
        
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
