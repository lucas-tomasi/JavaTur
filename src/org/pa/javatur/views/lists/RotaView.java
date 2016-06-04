package org.pa.javatur.views.lists;

import org.pa.javatur.views.forms.LocalView;
import org.pa.javatur.daos.LocalDAO;
import org.pa.javatur.daos.RotaDAO;
import org.pa.javatur.interfaces.ListViewInterface;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.pa.javatur.javatur.Util;
import org.pa.javatur.models.Rota;

public class RotaView extends javax.swing.JDialog implements ListViewInterface<Rota>{

    RotaDAO rDAO;
    LocalDAO lDAO;
    ArrayList<Rota> rotas;
    
    public RotaView(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();    
        
        rDAO = new RotaDAO();
        lDAO = new LocalDAO();
        rotas = new ArrayList<>();
     
        ftfAte.setText("  /  /   ");
        ftfDe.setText("  /  /   ");
        
        atualizarTabela();
        
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLocais = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnInativar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        txfDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        ftfAte = new javax.swing.JFormattedTextField();
        ftfDe = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbSituacao = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("JavaTur/Módulos/Rotas");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Rotas");

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/add_button.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setMinimumSize(new java.awt.Dimension(80, 29));
        btnNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNovoMouseClicked(evt);
            }
        });
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        tblLocais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rota", "Locais", "Valor", "Vagas", "Periodo", "Ativo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLocais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLocaisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLocais);
        if (tblLocais.getColumnModel().getColumnCount() > 0) {
            tblLocais.getColumnModel().getColumn(5).setMaxWidth(50);
        }

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/list.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnInativar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/cancel.png"))); // NOI18N
        btnInativar.setText("Inativar");
        btnInativar.setEnabled(false);
        btnInativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInativarActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/close_window.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel3.setText("Descrição:");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/search.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        try {
            ftfAte.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            ftfDe.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("Até:");

        jLabel5.setText("De:");

        jLabel6.setText("Situação:");

        cmbSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "::Selecione::", "Ativa", "Inativa" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInativar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel5)
                        .addGap(3, 3, 3)
                        .addComponent(ftfDe, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(ftfAte, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(ftfAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(cmbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar)
                    .addComponent(btnInativar)
                    .addComponent(btnSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoMouseClicked
        this.setVisible(false);
        LocalView view = new LocalView(null, true, 0 );
    }//GEN-LAST:event_btnNovoMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblLocaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLocaisMouseClicked
        if( evt.getClickCount() > 1)
        {
            editar();
        }
        else
        {
            btnEditar.setEnabled(true);
            btnInativar.setEnabled(true);
        }
    }//GEN-LAST:event_tblLocaisMouseClicked

    private void btnInativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInativarActionPerformed
        Rota rota = (Rota)tblLocais.getValueAt(tblLocais.getSelectedRow(), 0);
        
        if( inativar(rota) )
        {
            btnEditar.setEnabled(false);
            btnInativar.setEnabled(false);
            atualizarTabela();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!","erro",0);
        }
    }//GEN-LAST:event_btnInativarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.setVisible(false);
        new org.pa.javatur.views.forms.RotaView(null, true, 0);
    }//GEN-LAST:event_btnNovoActionPerformed

    public ArrayList<Rota> buscar(String filtro) 
    {
        ArrayList<Rota> rotas;
        if( filtro == null )
        {
            rotas = rDAO.buscar();
        }
        else
        {
            rotas = rDAO.buscar(filtro);
        }
        return rotas;
    }
    
    private boolean inativar( Rota rota )
    {
        try 
        {
            rota.setAtivo(!rota.isAtivo() );
            rDAO.salvar(rota);
            JOptionPane.showMessageDialog(this, "Alterado com sucesso!","informação",2);
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(this, "Erro ao alterar!","erro",0);
            System.err.println(e);
            return false;
        }
        return true;
    }
    
    public void editar() 
    {
        this.setVisible(false);
        Rota rota = (Rota) tblLocais.getValueAt(tblLocais.getSelectedRow(),0);
        new org.pa.javatur.views.forms.RotaView(null, true, rota.getId() );
    }
    
    public void atualizarTabela()
    {
        ArrayList<Rota> rotas = buscar(obterFiltros());
        
        if( rotas != null )
        {
            redimencionarTabela( rotas.size() );
        
            int cont = 0;

            for ( Rota rota : rotas) 
            {
                String periodo = Util.formatarData(rota.getDtInicio().toString() ) +"-"+Util.formatarData(rota.getDtFim().toString());
                String locais = lDAO.buscarLocais( rota.getId());
                tblLocais.setValueAt(rota, cont, 0);
                tblLocais.setValueAt(locais   , cont, 1);
                tblLocais.setValueAt(rota.getValor(), cont, 2);
                tblLocais.setValueAt(rota.getVagas(), cont, 3);
                tblLocais.setValueAt(periodo, cont, 4);
                tblLocais.setValueAt(rota.isAtivo(), cont, 5);
                cont++;
            }
        }
    }
  
    public void redimencionarTabela( int tamanho )
    {
        tblLocais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [tamanho][6] ,
            new String [] {
                "Rota", "Locais", "Valor", "Vagas", "Período", "Ativo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblLocais);
        tblLocais.getColumnModel().getColumn(5).setMaxWidth(50);
        tblLocais.getColumnModel().getColumn(3).setMaxWidth(50);
        tblLocais.getColumnModel().getColumn(2).setMaxWidth(50);
    }
    
    public String obterFiltros()
    {
        String filtro = " 1=1 ";
        
        if( !txfDescricao.getText().trim().equals("") )
        {
            filtro += " AND descricao ilike '%"+txfDescricao.getText()+"%'";
        }
        if( cmbSituacao.getSelectedIndex() != 0)
        {
            if ( cmbSituacao.getSelectedIndex() == 2 )
            {
                filtro += " AND ativo is false";            
            }
            else
            {
                filtro += " AND ativo";
            }
        }
        if( !ftfAte.getText().trim().equals("/  /") )
        {
            filtro += " AND dt_fim <= '"+Util.converterData(ftfAte.getText())+"'";
        }
        if( !ftfDe.getText().trim().equals("/  /"))
        {
            filtro += " AND dt_inicio >= '"+Util.converterData(ftfDe.getText())+"'";
        } 
        return filtro; 
    }
     
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
            java.util.logging.Logger.getLogger(RotaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RotaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RotaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RotaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RotaView dialog = new RotaView(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnInativar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> cmbSituacao;
    private javax.swing.JFormattedTextField ftfAte;
    private javax.swing.JFormattedTextField ftfDe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLocais;
    private javax.swing.JTextField txfDescricao;
    // End of variables declaration//GEN-END:variables
}
