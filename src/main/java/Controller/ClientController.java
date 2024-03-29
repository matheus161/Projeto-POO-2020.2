/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Intefaces.Controller;
import Model.ClientModel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Matheus
 */
public class ClientController implements Controller {
    ArrayList<ClientModel> clientList = new ArrayList<ClientModel>();
    ArrayList<ClientModel> clientListDeleted = new ArrayList<ClientModel>();
    
    public static void main(String[] args) {
            
    }
 
    public void store(ArrayList<ClientModel> client) {
                
        try {
            /*
             * A Classe FileOutputStream é responsável por criar
             * o arquivo fisicamente no disco, assim poderemos realizar a
             * escrita neste.
             * */
            FileOutputStream fos = new FileOutputStream("client.ser");

            /*
             * A Classe ObjectOutputStream escreve os objetos no FileOutputStream
             * */

            ObjectOutputStream oos = new ObjectOutputStream(fos); 
            
            // Gravando um objeto do tipo Client no arquivo client.ser
            oos.writeObject(client);
            
            fos.close();
            oos.close();
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
        public void storeDeletedClient(ArrayList<ClientModel> client) {
                
        try {
            /*
             * A Classe FileOutputStream é responsável por criar
             * o arquivo fisicamente no disco, assim poderemos realizar a
             * escrita neste.
             * */
            FileOutputStream fos = new FileOutputStream("clientDeleted.ser");

            /*
             * A Classe ObjectOutputStream escreve os objetos no FileOutputStream
             * */

            ObjectOutputStream oos = new ObjectOutputStream(fos); 
            
            // Gravando um objeto do tipo Client no arquivo client.ser
            oos.writeObject(client);
            
            fos.close();
            oos.close();
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public ArrayList index() {
        //ArrayList<ClientModel> Clientlist = new ArrayList<ClientModel>();
        
        try {
            // Carrega o arquivo
            FileInputStream fin = new FileInputStream("client.ser");

            // Responsavel por ler o arquivo
            ObjectInputStream ois = new ObjectInputStream(fin);   
            clientList = (ArrayList<ClientModel>)ois.readObject();
            
            //for(int i=0; i < clientList.size(); i++){;;
                //System.out.println(clientList.get(i));
            //}
            
            fin.close();
            ois.close();
            return clientList;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientList;
    }
    
        public ArrayList indexDeletedClient() {
        //ArrayList<ClientModel> Clientlist = new ArrayList<ClientModel>();
        
        try {
            // Carrega o arquivo
            FileInputStream fin = new FileInputStream("clientDeleted.ser");

            // Responsavel por ler o arquivo
            ObjectInputStream ois = new ObjectInputStream(fin);   
            clientListDeleted = (ArrayList<ClientModel>)ois.readObject();
            
            //for(int i=0; i < clientList.size(); i++){;;
                //System.out.println(clientList.get(i));
            //}
            
            fin.close();
            ois.close();
            return clientListDeleted;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientListDeleted;
    }
}
