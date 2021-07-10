/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Jota
 */
public class ProductModel {
    private int id;
    private String name;
    private String category;
    private float price;
    private int amount;

    public ProductModel() {
    }

    public ProductModel(int id, int amount, String category, float price, String name) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    @Override
    public String toString(){
        return  this.getId() + ";" + this.getAmount() 
                + ";" + this.getCategory() + ";" + this.getPrice()
                + ";" + this.getName();
    }
}
