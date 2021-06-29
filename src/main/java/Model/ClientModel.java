/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Matheus
 */
public class ClientModel extends PersonModel {

    public ClientModel(int id, String name, String email, String address, char sex, String cpf, String tel, String date) {
        super(id, name, email, address, sex, cpf, tel, date);
    }
    
    public ClientModel(){
       super();
    }
}
