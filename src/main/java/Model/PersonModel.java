/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Matheus
 */
public abstract class PersonModel implements Serializable {
    private int id;
    private String name;
    private String email;
    private String address;
    private char sex;
    private String cpf;
    private String tel;
    private String date;

    public PersonModel(int id, String name, String email, String address, char sex, String cpf, String tel, String date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.sex = sex;
        this.cpf = cpf;
        this.tel = tel;
        this.date = date;
    }    

    public PersonModel() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
