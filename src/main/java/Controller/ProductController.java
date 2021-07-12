/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author João Pedro
 */

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import Model.ProductModel;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class ProductController {
    ArrayList<ProductModel> productList = new ArrayList<ProductModel>();
    
    public void store(ArrayList<ProductModel> product) {
        
        try {
            //Pegando o arquivos com os produotos
            String arquivo = "arquivos" +
                             System.getProperty("file.separator") +
                             "Products.txt";
            
            OutputStream os = new FileOutputStream(arquivo);
            PrintStream ps = new PrintStream(os);

            // Gravando um produto no arquivo product.txt
            ps.print(product.toString());
            ps.flush(); //Força a escrita no buffers
            ps.close(); //Fecha a Stream
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String lerArquivo(){
       
        String arquivo = "arquivos" +
             System.getProperty("file.separator") +
                                "Products.txt";
        
        try {
            
            InputStream entrada = new FileInputStream(arquivo);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            
            int i;
            while ((i = entrada.read()) != -1) {
            baos.write((byte) i);
            }
            
            entrada.close();
            
            return baos.toString();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<ProductModel> index(){
        
            productList.clear();    // Limpar a lista anterior para nao repeti-la
            
            ProductController pc = new ProductController();
            String[] prod = new String[5]; // Recebe os parametros do produto
                    
            String[] prods = pc.lerArquivo().split(","); // Separa cada produto da String lida
            
            //Criando objetos produto com a String lida
            for (int i=0; i<prods.length; i++){
               ProductModel pm = new ProductModel();
            prod = prods[i].split(";");
            
            pm.setId(i);
            pm.setAmount(Integer.parseInt(prod[1]));
            pm.setCategory(prod[2]);
            pm.setPrice(Float.parseFloat(prod[3]));
            pm.setName(prod[4].replace("]", ""));
                        
            productList.add(pm);}
            
            return productList;            
    }
    
    public static void main(String[] args) {
        ProductController prodController = new ProductController();
        ArrayList<ProductModel> productList = new ArrayList();
        ProductModel p = new ProductModel(06, 5, "Celular", 3500.00f, "Google Pixel XL" );
        
        productList = prodController.index();
        productList.add(p);
        
        prodController.store(productList);
        
    }
}



