package org.pa.javatur.views;

import org.pa.javatur.daos.UsuarioDAO;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.JOptionPane;
import org.pa.javatur.javatur.Util;
import org.pa.javatur.models.Usuario;

public class LoginView extends javax.swing.JFrame {
    
    UsuarioDAO dao;
    public LoginView() {
        initComponents();

        //DEFINE LOGO
        URL url = this.getClass().getResource(Util.getLogo());  
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);  
        super.setIconImage(iconeTitulo);


        dao = new UsuarioDAO();
        lblError.setVisible(false);
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setVisible(true);        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogin = new javax.swing.JButton();
        txfLogin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        pasSenha = new javax.swing.JPasswordField();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JavaTur/Login");
        setResizable(false);

        btnLogin.setText("Entrar");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        btnLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLoginKeyPressed(evt);
            }
        });

        txfLogin.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        txfLogin.setForeground(new java.awt.Color(193, 189, 189));
        txfLogin.setText("login");
        txfLogin.setAutoscrolls(false);
        txfLogin.setPreferredSize(new java.awt.Dimension(306, 28));
        txfLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txfLoginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txfLoginFocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("JavaTur");

        pasSenha.setForeground(new java.awt.Color(193, 189, 189));
        pasSenha.setText("*****");
        pasSenha.setPreferredSize(new java.awt.Dimension(306, 27));
        pasSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pasSenhaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pasSenhaFocusLost(evt);
            }
        });

        lblError.setBackground(new java.awt.Color(242, 222, 222));
        lblError.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        lblError.setForeground(new java.awt.Color(169, 68, 66));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblError.setText("login e/ou senha inválidos");
        lblError.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txfLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pasSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(200, 200, 200))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addComponent(txfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(pasSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnLogin)
                .addGap(20, 20, 20)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfLoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfLoginFocusGained
        if( txfLogin.getText().equalsIgnoreCase("login") )
        {
            txfLogin.setText("");
            txfLogin.setForeground(Color.black);
        }
    }//GEN-LAST:event_txfLoginFocusGained

    private void txfLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfLoginFocusLost
        if( txfLogin.getText().equalsIgnoreCase("") )
        {
            txfLogin.setText("login");
            txfLogin.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txfLoginFocusLost

    private void pasSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pasSenhaFocusGained
        if( String.valueOf(pasSenha.getPassword() ).equalsIgnoreCase("*****") )
        {
            pasSenha.setText("");
            pasSenha.setForeground(Color.black);
        }
    }//GEN-LAST:event_pasSenhaFocusGained

    private void pasSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pasSenhaFocusLost
        if( String.valueOf(pasSenha.getPassword()).equalsIgnoreCase("") )
        {
            pasSenha.setText("****");
            txfLogin.setForeground(Color.gray);
        }
    }//GEN-LAST:event_pasSenhaFocusLost

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
       onLogin();      
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLoginKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            onLogin();
        }
    }//GEN-LAST:event_btnLoginKeyPressed

    private void onLogin()
    {
        String login = txfLogin.getText();
        String senha = String.valueOf(pasSenha.getPassword() );
        
        if(!login.equalsIgnoreCase("") && !login.equalsIgnoreCase("login") && !senha.equalsIgnoreCase("") && !senha.equalsIgnoreCase("*****"))
        {
            
            Usuario usuario = dao.validar(login, senha);
            if( usuario != null )
            {
                if( usuario.isAtivo() )
                {
                    Usuario.setUsuarioLogado(usuario);
                    this.setVisible(false);
                    PrincipalView view = new PrincipalView();
                    view.setVisible(true);
                }
                else
                {
                    lblError.setVisible(true);
                }
            }
            else
            {
                lblError.setVisible(true);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Preencha login e senha", "atenção", 2);
        }
    }
    
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
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblError;
    private javax.swing.JPasswordField pasSenha;
    private javax.swing.JTextField txfLogin;
    // End of variables declaration//GEN-END:variables
}
