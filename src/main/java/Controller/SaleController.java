/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ClientModel;
import Model.ProductModel;
import Model.SaleModel;
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
public class SaleController {
    ArrayList<SaleModel> saleList = new ArrayList<SaleModel>();
    
    public static void main(String[] args) {
        ArrayList<SaleModel> saleList = new ArrayList<>();
        ArrayList<ClientModel> clientList = new ArrayList<>();
        ArrayList<ProductModel> productList = new ArrayList<>();
        SaleController saleController = new SaleController();
        ProductController pController = new ProductController();
        ClientController clController = new ClientController();
        
        clientList = clController.index();
        productList = pController.index();
        
        //SaleModel sale = new SaleModel("12/07/2021", 2 , 20d, clientList.get(0).getName(), productList.get(0).getName());
        //saleList.add(sale);
        
        saleController.store(saleList);
        ArrayList<SaleModel> saleList2 = new ArrayList<>();
        saleList2 = saleController.index();
        
        for (int i=0; i < saleList2.size(); i++){
            System.out.print(saleList2.get(i));
        }
    }
    
    public void store(ArrayList<SaleModel> sale) {
        try {
            /*
             * A Classe FileOutputStream é responsável por criar
             * o arquivo fisicamente no disco, assim poderemos realizar a
             * escrita neste.
             * */
            FileOutputStream fos = new FileOutputStream("store.ser");

            /*
             * A Classe ObjectOutputStream escreve os objetos no FileOutputStream
             * */

            ObjectOutputStream oos = new ObjectOutputStream(fos); 
            
            // Gravando uma lista de objetos do tipo Client no arquivo client.ser
            oos.writeObject(sale);
            
            fos.close();
            oos.close();
            System.out.println("Done");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList index() {
        try {
            // Carrega o arquivo
            FileInputStream fin = new FileInputStream("client.ser");

            // Responsavel por ler o arquivo
            ObjectInputStream ois = new ObjectInputStream(fin);   
            saleList = (ArrayList<SaleModel>)ois.readObject();
            
            //for(int i=0; i < clientList.size(); i++){;;
                //System.out.println(clientList.get(i));
            //}
            
            fin.close();
            ois.close();
            return saleList;            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaleController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(SaleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return saleList;
    }
    
}
