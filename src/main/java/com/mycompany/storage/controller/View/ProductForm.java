/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.storage.controller.View;

import Controller.ProductController;
import Model.ProductModel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import com.mycompany.storage.controller.View.ProductView;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFormattedTextField;

/**
 *
 * @author João Pedro e Matheus
 */
public class ProductForm extends javax.swing.JDialog {
    ProductController pController = new ProductController();
    ArrayList<ProductModel> productList = new ArrayList();
    
    /**
     * Creates new form ProductForm
     */
    public ProductForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        // Se o botao apertado foi o de editar
        // retorne o cliente daquela linha
        if (ProductView.btnChoose == 1){
            // Pegando a lista deserializada
            ArrayList<ProductModel> list = pController.index();

            nameTxt.setText(list.get(ProductView.index).getName());
            categoryTxt.setText(list.get(ProductView.index).getCategory());
            priceTxt.setText(Float.toString(list.get(ProductView.index).getPrice()));
            qntdTxt.setText(Integer.toString(list.get(ProductView.index).getAmount()));
        }
    }
    
    private int isValidFields(){
        // Verifico se o nome esta vazio ou passui numeros
        if (!nameTxt.getText().matches("[^0-9]") & nameTxt.getText().matches("^\\d+$")){
            JOptionPane.showMessageDialog(null, "Preencha o nome corretamente");
            return 0;
        }
        if (nameTxt.getText().length() <= 2 | nameTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o nome corretamente");
            return 0;
        }
        if (categoryTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha a categoria corretamente");
            return 0;
        }
        if (priceTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o preco corretamente");
            return 0;
        }
        if (qntdTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha a quantidade corretamente");
            return 0;
        }
        return 1;
    }
    
    private boolean isValidAmount(){
        try {
        String qntd = qntdTxt.getText();
        return qntd != null && qntd.matches("[0-9]*");
        } catch (Exception e) {
            return false;
        }        
    }    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        categoryTxt = new javax.swing.JTextField();
        qntdTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        priceTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(153, 0, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("                               Produto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("Nome:");

        nameTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102), 2));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 102));
        jLabel3.setText("Categoria:");

        categoryTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        categoryTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102), 2));

        qntdTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        qntdTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102), 2));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 102));
        jLabel4.setText("Preco(R$):");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 102));
        jLabel6.setText("Quantidade:");

        btnSave.setBackground(new java.awt.Color(43, 22, 109));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Salvar");
        btnSave.setBorder(null);
        btnSave.setContentAreaFilled(false);
        btnSave.setOpaque(true);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(186, 4, 48));
        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancelar");
        btnCancel.setBorder(null);
        btnCancel.setContentAreaFilled(false);
        btnCancel.setOpaque(true);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        priceTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        priceTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102), 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qntdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(categoryTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(priceTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(qntdTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private int generateID(){
        // Pegando a lista deserializada
        ArrayList<ProductModel> list = pController.index();
        
        // Quando não tiver nada cadastrado
        if (list.isEmpty())
            return 1;
        
        // Pego o id do ultimo elemento da lista
        int id = list.get(list.size() - 1).getId();
        
        // Retorno ele mais um
        return (id+1);
    }
    
    private void closeForm(){
        setVisible(false);
        dispose();
    }
    
    private ProductModel fillDataForm() {
        // Preenchendo um objeto do tipo Product
        ProductModel product = new ProductModel(generateID(), Integer.parseInt(qntdTxt.getText()),
        categoryTxt.getText(), Float.parseFloat(priceTxt.getText()), nameTxt.getText());
        
        return product;
    }
    
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        // Criando o objeto que sera preenchido
        ProductModel product = new ProductModel();

        // Preenchendo o objeto com os valores
        // dos inputs do form
        product = fillDataForm();

        // Verificando campos
        if (isValidFields() == 0){
            return;
        }
        
        // Verificando a quantidade
        if (isValidAmount() == false){
            JOptionPane.showMessageDialog(null, "Preencha uma quantidade valida");
            return;
        }

        // Pegando a lista que está sendo manipulada
        productList = pController.index();

        // Se o botao apertado foi o de registrar
        // ele irá fazer um cadastro
        if (ProductView.btnChoose == 0){

            // Adicionando o objeto a lista
            productList.add(product);

            // Chamando o metodo store
            pController.store(productList);

            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");

            // Fechando o formulario e destruindo o objeto
            closeForm();
        } else { // Senão ele irá atualizar

            // Passando o id do cliente atual
            product.setId(productList.get(ProductView.index).getId());

            // Com um objeto preenchido eu passo o que eu preciso para
            // o objeto naquela determinada posicao da lista de produtos
            productList.get(ProductView.index).setName(product.getName());
            productList.get(ProductView.index).setCategory(product.getCategory());
            productList.get(ProductView.index).setPrice(product.getPrice());
            productList.get(ProductView.index).setAmount(product.getAmount());

            // Serializando na lista com o cliente editado
            pController.store(productList);

            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso");

            // Fechando o formulario e destruindo o objeto
            closeForm();

        }
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProductForm dialog = new ProductForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JTextField categoryTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JTextField priceTxt;
    private javax.swing.JTextField qntdTxt;
    // End of variables declaration//GEN-END:variables
}
