package org.pa.javatur.views.lists;

import org.pa.javatur.daos.AtividadeDAO;
import org.pa.javatur.daos.AtividadeLocalDAO;
import org.pa.javatur.daos.LocalDAO;
import org.pa.javatur.daos.TipoLocalDAO;
import org.pa.javatur.interfaces.ListViewInterface;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.pa.javatur.models.Atividade;
import org.pa.javatur.models.Local;
import org.pa.javatur.models.TipoLocal;

public class LocalView extends javax.swing.JDialog implements ListViewInterface<Local>{

    LocalDAO lDAO;
    TipoLocalDAO tlDAO;
    AtividadeDAO aDAO;
    AtividadeLocalDAO atlDAO;
    
    public LocalView(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();    
        
        lDAO = new LocalDAO();
        tlDAO = new TipoLocalDAO();
        aDAO = new AtividadeDAO();
        atlDAO = new AtividadeLocalDAO();
        
        
        preencherComboAtividades();
        preencherComboTiposLocais();
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbTiposLocais = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        cmbAtividade = new javax.swing.JComboBox<>();
        cmbSituacao = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("JavaTur/Módulos/Locais");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Locais");

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/add_button.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setMinimumSize(new java.awt.Dimension(80, 29));
        btnNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNovoMouseClicked(evt);
            }
        });

        tblLocais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Local", "Tipo", "Atividades", "Ativo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
            tblLocais.getColumnModel().getColumn(3).setMaxWidth(50);
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

        jLabel2.setText("Tipo de Local:");

        jLabel3.setText("Descrição:");

        jLabel4.setText("Atividade:");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/search.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        cmbSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "::Selecione::", "Ativo", "Inativo" }));

        jLabel5.setText("Situação:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInativar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txfDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(cmbTiposLocais, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbAtividade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbSituacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(cmbTiposLocais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(cmbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar)
                    .addComponent(btnInativar)
                    .addComponent(btnSair))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoMouseClicked
        this.setVisible(false);
        org.pa.javatur.views.forms.LocalView view = new org.pa.javatur.views.forms.LocalView(null, true, 0 );
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
        Local local = (Local)tblLocais.getValueAt(tblLocais.getSelectedRow(), 0);
        
        if( inativar(local) )
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

    public ArrayList<Local> buscar(String filtro) 
    {
        ArrayList<Local> locais;
        if( filtro == null )
        {
            locais = lDAO.buscar();
        }
        else
        {
            locais = lDAO.buscar(filtro);
        }
        return locais;
    }
    
    private boolean inativar( Local local )
    {
        try 
        {
            local.setAtivo(!local.isAtivo() );
            lDAO.salvar(local);
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
        Local local = (Local) tblLocais.getValueAt(tblLocais.getSelectedRow(),0);
        new org.pa.javatur.views.forms.LocalView(null, true, local.getId() );
    }
    
    public void atualizarTabela()
    {
        ArrayList<Local> locais = buscar(obterFiltros());
        
        if( locais != null )
        {
            redimencionarTabela( locais.size() );
        
            int cont = 0;

            for (Local local : locais) 
            {
                TipoLocal  tl = tlDAO.buscar(local.getTipoLocal());
                String atividades = atlDAO.obterDescricoesAtividadesLocais(local.getId());
                tblLocais.setValueAt(local, cont, 0);
                tblLocais.setValueAt(tl   , cont, 1);
                tblLocais.setValueAt(atividades, cont, 2);
                tblLocais.setValueAt(local.isAtivo() , cont, 3);
                cont++;
            }
        }
    }
    
    private void preencherComboTiposLocais()
    {
        TipoLocalDAO dao = new TipoLocalDAO();
        ArrayList<TipoLocal> tipos = dao.buscar();
        cmbTiposLocais.addItem( new TipoLocal(":: Selecione ::") );
        tipos.forEach( (tipo)-> {
            cmbTiposLocais.addItem(tipo);
        });
    }
    
    private void preencherComboAtividades()
    {
        AtividadeDAO dao = new AtividadeDAO();
        ArrayList<Atividade> tipos = dao.buscar();
        cmbAtividade.addItem( new Atividade(":: Selecione ::") );
        tipos.forEach( (tipo)-> {
            cmbAtividade.addItem(tipo);
        });
    }
    
    public void redimencionarTabela( int tamanho )
    {
        tblLocais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [tamanho][4],
            new String [] {
                "Local", "Tipo", "Atividades", "Ativo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLocais.setSelectionMode(0);
        tblLocais.getColumnModel().getColumn(3).setMaxWidth(50);
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
        if( cmbAtividade.getSelectedIndex() != 0 )
        {
            Atividade at = (Atividade)cmbAtividade.getSelectedItem();
            filtro += " AND id in ( " + 
                                     " SELECT ref_local FROM atividades_locais WHERE ref_atividade = "+ at.getId() + ") ";
        }
        if( cmbTiposLocais.getSelectedIndex() != 0 )
        {
            TipoLocal tl = (TipoLocal)cmbTiposLocais.getSelectedItem();
            filtro += " AND ref_tipo_local = " + tl.getId() + " ";
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
            java.util.logging.Logger.getLogger(LocalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LocalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LocalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LocalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LocalView dialog = new LocalView(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<Atividade> cmbAtividade;
    private javax.swing.JComboBox<String> cmbSituacao;
    private javax.swing.JComboBox<TipoLocal> cmbTiposLocais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLocais;
    private javax.swing.JTextField txfDescricao;
    // End of variables declaration//GEN-END:variables
}
