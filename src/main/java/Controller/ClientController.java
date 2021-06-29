/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ClientModel;
import com.mycompany.storage.controller.View.Client;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public class ClientController {
   ArrayList<ClientModel> clients = new ArrayList<>();
    
    public static void main(String[] args) {
        
    }
    
    public void store(ClientModel client) {
        //ArrayList<Object> data = new ArrayList<Object>();
        //data.add(client.getId());
        clients.add(client);
        
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            //Inicializando na pasta local do projeto
            fos = new FileOutputStream("client.ser");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(client);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo nao encontrado");
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo");
        } finally {
            if (oos != null)
                try {
                    oos.close();
                } catch (IOException e){
                    System.out.println("Erro ao fechar o arquivo");
            }
        }
    }
    
    public void index(){
        // Criando um arrayList para deserializar os objetos
        //ArrayList<Object> c = new ArrayList<Object>();
        ArrayList<ClientModel> c = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("client.ser");
            ois = new ObjectInputStream(fis);
            c = (ArrayList<ClientModel>)ois.readObject();
            
            for(int i=0; i < c.size(); i++){
                System.out.println("Cliente: " + c.get(i));
            }
            
            //System.out.printf("Id: %2d\nNome: %s\nCPF: %s",
                    //c.getId(), c.getName(), c.getCpf());
        } catch (FileNotFoundException e) {
            System.out.println("Classe nao encontrado");
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ois != null)
                try {
                    ois.close();
                } catch (IOException e){
                    System.out.println("Erro ao fechar o arquivo");
            }
        }
    }
  
}
