/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.storage.controller.View;

import Controller.ClientController;
import Model.ClientModel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import com.mycompany.storage.controller.View.ClientView;
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
 * @author Matheus
 */
public class ClientForm extends javax.swing.JDialog {
    ClientController clController = new ClientController();
    ArrayList<ClientModel> clientList = new ArrayList();
    
    
    /**
     * Creates new form ClientForm
     */
    public ClientForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //fieldFormater();
        // Se o botao apertado foi o de editar
        // retorne o cliente daquela linha
        if (ClientView.btnChoose == 1){
            // Pegando a lista deserializada
            ArrayList<ClientModel> list = clController.index();

            nameTxt.setText(list.get(ClientView.index).getName());
            emailTxt.setText(list.get(ClientView.index).getEmail());
            enderecoTxt.setText(list.get(ClientView.index).getAddress());
            if (list.get(ClientView.index).getSex() == 'M')
                menCheck.setSelected(true);
            else 
                womanCheck.setSelected(true);
            cpfTxt.setText(list.get(ClientView.index).getCpf());
            telTxt.setText(list.get(ClientView.index).getTel());
            bornDateTxt.setText(list.get(ClientView.index).getDate());
        }
    }
    
    private int cpfFormat(String cpf){
        if (cpf.length() < 14){
            return 0;
        }
        return 1;
    }
    
    private int isValidCPF(){
        if (cpfTxt.getText().equals("000.000.000-00") |
            cpfTxt.getText().equals("111.111.111-11") |
            cpfTxt.getText().equals("222.222.222-22") |
            cpfTxt.getText().equals("333.333.333-33") |
            cpfTxt.getText().equals("444.444.444-44") |
            cpfTxt.getText().equals("555.555.555-55") |
            cpfTxt.getText().equals("666.666.666-66") |
            cpfTxt.getText().equals("777.777.777-77") |
            cpfTxt.getText().equals("888.888.888-88") |
            cpfTxt.getText().equals("999.999.999-99")){
            JOptionPane.showMessageDialog(null, "Preencha com um CPF valido ");
            return 0;
        }
        
        return 1;
    }
    
    private boolean isValidEmailAddress(){
        String email = emailTxt.getText();
        boolean result = false;
        
        if (email != null && email.length() > 0){
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()){
                result = true;
            }
        }
        return result;
    }
    
    private boolean isValidBornDate() {
        String date = bornDateTxt.getText();
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            //Aqui eu converto uma data em LocalDate
            //e digo que quero no formato do DateTimeFormatter
            //que criei acima
            LocalDate dateVerify = LocalDate.parse(date, dtf);
            //Esse comando pega a data de hoje
            LocalDate today = LocalDate.now();
            //Se dataVerificada comparada com hoje é
            //menor ou igual a zero então retorna verdadeiro
            return dateVerify.compareTo(today) <= 0;
        } catch (Exception e) {
            return false;
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
        // Verifico se o endereco esta vazio ou poucos caracteres
        if (enderecoTxt.getText().equals("") | enderecoTxt.getText().length() <= 3){
            JOptionPane.showMessageDialog(null, "Preencha o endereco corretamente");
            return 0;
        }
        if (cpfTxt.getText().trim().length() < 14){
            JOptionPane.showMessageDialog(null, "Preencha o CPF corretamente");
            return 0;
        }        
        if (telTxt.getText().trim().length() < 14){
            JOptionPane.showMessageDialog(null, "Preencha com um numero valido");
            return 0;
        }
        if (bornDateTxt.getText().trim().length() < 10){
            JOptionPane.showMessageDialog(null, "Preencha com uma data valida");
            return 0;
        }
        return 1;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        enderecoTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        menCheck = new javax.swing.JRadioButton();
        womanCheck = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        telTxt = new javax.swing.JFormattedTextField();
        cpfTxt = new javax.swing.JFormattedTextField();
        bornDateTxt = new javax.swing.JFormattedTextField();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(153, 0, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("                           Funcionário");

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
        jLabel3.setText("Email");

        emailTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        emailTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102), 2));

        enderecoTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        enderecoTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102), 2));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 102));
        jLabel4.setText("Endereço:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 102));
        jLabel5.setText("Sexo:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 102));
        jLabel6.setText("CPF:");

        menCheck.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(menCheck);
        menCheck.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        menCheck.setSelected(true);
        menCheck.setText("Masculino");

        womanCheck.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(womanCheck);
        womanCheck.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        womanCheck.setText("Feminino");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 102));
        jLabel7.setText("Telefone:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 0, 102));
        jLabel8.setText("Data Nascimento:");

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

        telTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102), 2));
        try {
            telTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        cpfTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102), 2));
        try {
            cpfTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        bornDateTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102), 2));
        try {
            bornDateTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

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
                        .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enderecoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(menCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(womanCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpfTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bornDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(emailTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(enderecoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menCheck)
                    .addComponent(womanCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(cpfTxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(telTxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(bornDateTxt))
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(416, 507));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private char getSex(){
        if(menCheck.isSelected())
            return 'M';
        
        return 'F';
    }
    
    private int generateID(){
        // Pegando a lista deserializada
        ArrayList<ClientModel> list = clController.index();
        
        // Quando não tiver nada cadastrado
        if (list.size() == 0)
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
    
    private ClientModel fillDataForm() {
        // Preenchendo um objeto do tipo Client
        ClientModel client = new ClientModel(generateID(), nameTxt.getText(), emailTxt.getText(),
        enderecoTxt.getText(), getSex(), cpfTxt.getText(), telTxt.getText(),
        bornDateTxt.getText());
        
        return client;
    }
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int id;
        char sex = getSex();
        
        // Criando o objeto que sera preenchido
        ClientModel client = new ClientModel();
        
        // Preenchendo o objeto com os valores
        // dos inputs do form
        client = fillDataForm();
        
        // Verificando campos
        if (isValidFields() == 0 | isValidCPF() == 0){
            return;
        }
        
        // Validando a data
        if (isValidBornDate() == false){
            JOptionPane.showMessageDialog(null, "Preencha um data valida");
            return;
        }
        
        // Validando o email
        if (isValidEmailAddress() == false){
            JOptionPane.showMessageDialog(null, "Preencha com um email valido");
            return;
        }
        
        // Pegando a lista que está sendo manipulada
        clientList = clController.index();
        
        // Se o botao apertado foi o de registrar
        // ele irá fazer um cadastro
        if (ClientView.btnChoose == 0){
            
            // Adicionando o objeto a lista
            clientList.add(client);
            
            // Chamando o metodo sotore
            clController.store(clientList);
            
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");

        } else { // Senão ele irá atualizar
            
            // Passando o id do cliente atual
            client.setId(clientList.get(ClientView.index).getId());
            
            // Com um objeto preenchido eu passo o que eu preciso para
            // o objeto naquela determinada posicao da lista de clientes
            clientList.get(ClientView.index).setName(client.getName());
            clientList.get(ClientView.index).setEmail(client.getEmail());
            clientList.get(ClientView.index).setAddress(client.getAddress());
            clientList.get(ClientView.index).setSex(client.getSex());
            clientList.get(ClientView.index).setCpf(client.getCpf());
            clientList.get(ClientView.index).setTel(client.getTel());
            clientList.get(ClientView.index).setDate(client.getDate()); 
            
            // Serializando na lista com o cliente editado
            clController.store(clientList);
            
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
        }
        // Fechando o formulario e destruindo o objeto
        closeForm();         
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        setVisible(false);
        dispose();        
    }//GEN-LAST:event_btnCancelActionPerformed
    
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
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ClientForm dialog = new ClientForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JFormattedTextField bornDateTxt;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFormattedTextField cpfTxt;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTextField enderecoTxt;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton menCheck;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JFormattedTextField telTxt;
    private javax.swing.JRadioButton womanCheck;
    // End of variables declaration//GEN-END:variables
}
