/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.storage.controller.View;

import Controller.ClientController;
import Controller.ProductController;
import Controller.SaleController;
import Model.ClientModel;
import Model.ProductModel;
import Model.SaleModel;
import static com.mycompany.storage.controller.View.ClientView.btnChoose;
import static com.mycompany.storage.controller.View.ClientView.index;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus
 */
public class SaleView extends javax.swing.JFrame {
    ClientController clController = new ClientController();
    ProductController prController = new ProductController();
    SaleController slController = new SaleController();
    ArrayList<ClientModel> clientList = new ArrayList();
    ArrayList<ProductModel> productList = new ArrayList();
    ArrayList<SaleModel> saleList = new ArrayList();
    
    int qtdSell;
    //Vector<Integer> id_client = new Vector<Integer>();
    
    /**
     * Creates new form StoreView
     */
    
    public void LoadProductTable(){
        // Definindo as colunas da minha tabela
        Object columns[] = {"ID", "Nome", "Categoria", "Preço", "Quantidade"};
        
        // Criando um modelo padrao
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        productList = prController.index();
        
        // Dizendo o conteudo das minhas linhas a partir 
        // das colunas e de cada elemento da minha lista   
        for (int i=0; i < productList.size(); i++){
            if (productList.get(i).getAmount() != 0 && cbxClientFilter.getSelectedItem() == "Todos") {
                Object rows[] = new Object[]{productList.get(i).getId(),
                productList.get(i).getName(), productList.get(i).getCategory(),
                productList.get(i).getPrice(),productList.get(i).getAmount()};
                model.addRow(rows);
            } else if (productList.get(i).getCategory().equals(cbxClientFilter.getSelectedItem().toString()) && productList.get(i).getAmount() != 0){
                Object rows[] = new Object[]{productList.get(i).getId(),
                productList.get(i).getName(), productList.get(i).getCategory(),
                productList.get(i).getPrice(),productList.get(i).getAmount()};
                model.addRow(rows);                
            }
        }        
        productTable.setModel(model);
    }
    
    public Object[] columns() {      
        // Definindo as colunas da minha tabela
        Object columns[] = {"Produto", "Quantidade", "Valor",
        "Cliente", "Data da Compra"};
        
        return columns;
    } 
    
    public void LoadSaleTableAll() {
        // Criando um modelo padrao
        DefaultTableModel model = new DefaultTableModel(columns(), 0);
        saleList = slController.index();

        // Dizendo o conteudo das minhas linhas a partir 
        // das colunas e de cada elemento da minha lista 
        for (int i=0; i < saleList.size(); i++){
            //System.out.print(saleList.get(i).getClient());
            Object rows[] = new Object[]{saleList.get(i).getProduct(),
            saleList.get(i).getQuantity(),saleList.get(i).getValue(),
            saleList.get(i).getClient(),saleList.get(i).getDate()};
            model.addRow(rows);
        }
        saleTable.setModel(model);        
    }
    
    public void LoadSaleTableFilter() {
        
        // Criando um modelo padrao
        DefaultTableModel model = new DefaultTableModel(columns(), 0);
        saleList = slController.index();

        // Dizendo o conteudo das minhas linhas a partir 
        // das colunas e de cada elemento da minha lista 
        for (int i=0; i < saleList.size(); i++){
            if (saleList.get(i).getClient().equals(cbxForClients.getSelectedItem().toString())){
                //System.out.print(saleList.get(i).getClient());
                Object rows[] = new Object[]{saleList.get(i).getProduct(),
                saleList.get(i).getQuantity(),saleList.get(i).getValue(),
                saleList.get(i).getClient(),saleList.get(i).getDate()};
                model.addRow(rows);
            }
        }
        saleTable.setModel(model);
    }
    
    public SaleView() {
        initComponents();
        reloadComboBoxClient();
        reloadComboBoxClientForBuy();
        LoadProductTable();
        LoadSaleTableAll();
    }
    
    private void reloadComboBoxClient() {
        clientList = clController.index();
        for (int i=0; i < clientList.size(); i++){
            cbxClient.addItem(clientList.get(i).getName());
        }
    }
    
    private void reloadComboBoxClientForBuy() {
        clientList = clController.index();
        for (int i=0; i < clientList.size(); i++){
            cbxForClients.addItem(clientList.get(i).getName());
        }
    }    
    
    private int getRow() {
        index = productTable.getSelectedRow();
        if (index < 0){
            JOptionPane.showMessageDialog(null, "Selecione um produto");
            return 1;
        }
        return 0;
    }
    
    private int getQuantity(){
        if (Integer.parseInt(qtdTxt.getText()) <= 0){
            JOptionPane.showMessageDialog(null, "Coloque uma quantidade valida");
            return -1;
        }    
        return Integer.parseInt(qtdTxt.getText());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cbxClient = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        qtdTxt = new javax.swing.JTextField();
        plusQtdBtn = new javax.swing.JButton();
        minusQtdBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnShop = new javax.swing.JButton();
        cbxClientFilter = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        saleTable = new javax.swing.JTable();
        cbxForClients = new javax.swing.JComboBox<>();
        btnFilter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(153, 0, 102));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("                                                            LOJA DE CELULARES");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Categoria", "Preço", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Byte.class, java.lang.Byte.class, java.lang.Byte.class, java.lang.Byte.class, java.lang.Byte.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productTable);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("CLIENTE:");

        cbxClient.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbxClient.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cbxClient.setBorder(null);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 102));
        jLabel3.setText("QUANTIDADE:");

        qtdTxt.setEditable(false);
        qtdTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        qtdTxt.setText("0");
        qtdTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));

        plusQtdBtn.setBackground(new java.awt.Color(102, 0, 102));
        plusQtdBtn.setForeground(new java.awt.Color(255, 255, 255));
        plusQtdBtn.setText("+");
        plusQtdBtn.setBorder(null);
        plusQtdBtn.setContentAreaFilled(false);
        plusQtdBtn.setOpaque(true);
        plusQtdBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusQtdBtnActionPerformed(evt);
            }
        });

        minusQtdBtn.setBackground(new java.awt.Color(102, 0, 102));
        minusQtdBtn.setForeground(new java.awt.Color(255, 255, 255));
        minusQtdBtn.setText("-");
        minusQtdBtn.setBorder(null);
        minusQtdBtn.setContentAreaFilled(false);
        minusQtdBtn.setOpaque(true);
        minusQtdBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusQtdBtnActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 102));
        jLabel5.setText("        LISTA DE PRODUTOS");

        btnShop.setBackground(new java.awt.Color(102, 0, 102));
        btnShop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnShop.setForeground(new java.awt.Color(255, 255, 255));
        btnShop.setText("Comprar");
        btnShop.setBorder(null);
        btnShop.setContentAreaFilled(false);
        btnShop.setOpaque(true);
        btnShop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShopActionPerformed(evt);
            }
        });

        cbxClientFilter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbxClientFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Celulares", "Cases", "Peliculas", "Audio" }));
        cbxClientFilter.setBorder(null);

        jButton1.setBackground(new java.awt.Color(102, 0, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("FILTRAR");
        jButton1.setContentAreaFilled(false);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 102));
        jLabel6.setText("             FILTRAR POR CATEGORIA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(325, 325, 325)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnShop, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(qtdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(minusQtdBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(plusQtdBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbxClient, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 358, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxClientFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(94, 94, 94))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnShop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxClientFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(qtdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plusQtdBtn)
                    .addComponent(minusQtdBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("LOJA", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(153, 0, 102));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("                                                          HISTÓRICO DE COMPRAS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        saleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Quantidade", "Valor", "Cliente", "Data da Compra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(saleTable);

        cbxForClients.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos" }));

        btnFilter.setBackground(new java.awt.Color(102, 0, 102));
        btnFilter.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnFilter.setForeground(new java.awt.Color(255, 255, 255));
        btnFilter.setText("Filtrar");
        btnFilter.setBorder(null);
        btnFilter.setContentAreaFilled(false);
        btnFilter.setOpaque(true);
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(cbxForClients, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFilter)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxForClients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFilter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("HISTORICO DE COMPRAS", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void plusQtdBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusQtdBtnActionPerformed
        qtdSell += 1;
        qtdTxt.setText(Integer.toString(qtdSell));
    }//GEN-LAST:event_plusQtdBtnActionPerformed

    private void minusQtdBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusQtdBtnActionPerformed
        qtdSell -= 1;
        qtdTxt.setText(Integer.toString(qtdSell));
    }//GEN-LAST:event_minusQtdBtnActionPerformed

    private void btnShopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShopActionPerformed
        // Verifico se eu selecionei o produto
        if (getRow() == 1)
                return;
        Object client;
        
        // Deserelizando a lista de produtos
        // e pego o que foi selecionado na tabela
        productList = prController.index();
        ProductModel product = productList.get(index);
        
        // Verifico se ele selecionou algum cliente
        if (cbxClient.getSelectedItem() == "Selecione"){
          JOptionPane.showMessageDialog(null, "Selecione um cliente"); 
          return;
        } else {
            // Se ele selecionou eue passo o cliente
            client = cbxClient.getSelectedItem();
        }
 
        // Crio uma sale ou "venda" 
        // passando os campos 
        SaleModel sale = new SaleModel();
        sale.setClient(client.toString());
        sale.setProduct(product.getName());
        sale.setValue((Integer.parseInt(qtdTxt.getText())* product.getPrice()));
        if (getQuantity() != -1)
            sale.setQuantity(getQuantity());
        else 
            return;
        
        // Pegando a data e horario da compra
        Calendar today = new GregorianCalendar();
        Date date = today.getTime();
        sale.setDate(date);
        
        // Efetuando a compra
        // Checando se o valor e valido
        if (getQuantity() <= product.getAmount()){
            product.sell(getQuantity());
            prController.store(productList);
        } else {
            JOptionPane.showMessageDialog(null, "Sem estoque");
            return;
        }
        
        // Deserializo a lista de vendas e adiciono um novo
        saleList = slController.index();
        saleList.add(sale);
        slController.store(saleList);
        
        // Atualizando as tabelas
        JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso");
        LoadSaleTableAll();
        LoadProductTable();
    }//GEN-LAST:event_btnShopActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        if (cbxForClients.getSelectedItem() == "Todos"){
            LoadSaleTableAll();
        }else 
            LoadSaleTableFilter();
        
    }//GEN-LAST:event_btnFilterActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LoadProductTable();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SaleView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaleView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaleView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaleView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SaleView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnShop;
    private javax.swing.JComboBox<String> cbxClient;
    private javax.swing.JComboBox<String> cbxClientFilter;
    private javax.swing.JComboBox<String> cbxForClients;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton minusQtdBtn;
    private javax.swing.JButton plusQtdBtn;
    private javax.swing.JTable productTable;
    private javax.swing.JTextField qtdTxt;
    private javax.swing.JTable saleTable;
    // End of variables declaration//GEN-END:variables
}
