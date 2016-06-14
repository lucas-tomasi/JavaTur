package org.pa.javatur.views.seek;

import java.sql.Date;
import org.pa.javatur.daos.AtividadeDAO;
import org.pa.javatur.daos.AtividadeLocalDAO;
import org.pa.javatur.daos.LocalDAO;
import org.pa.javatur.daos.TipoLocalDAO;
import org.pa.javatur.interfaces.ListViewInterface;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import org.pa.javatur.javatur.Util;
import org.pa.javatur.models.Atividade;
import org.pa.javatur.models.Local;
import org.pa.javatur.models.LocalRota;
import org.pa.javatur.models.TipoLocal;
import org.pa.javatur.views.forms.RotaView;

public class LocalView extends javax.swing.JDialog implements ListViewInterface<Local>{

    LocalDAO lDAO;
    TipoLocalDAO tlDAO;
    AtividadeDAO aDAO;
    AtividadeLocalDAO atlDAO;
    RotaView janela;
    Vector<LocalRota>locaisrotas;
    
    private Local currentLocal;
    
    public LocalView(java.awt.Frame parent, boolean modal, RotaView janela, Vector<LocalRota> locais ) 
    {
        super(parent, modal);
        initComponents();    
        
        lDAO = new LocalDAO();
        tlDAO = new TipoLocalDAO();
        aDAO = new AtividadeDAO();
        atlDAO = new AtividadeLocalDAO();
        
        this.janela = janela;
        this.locaisrotas = locais;
        
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
        btnSelecionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLocais = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();
        txfDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbTiposLocais = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        cmbAtividade = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        txtLocal = new javax.swing.JTextField();
        txtDate = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("JavaTur/Locais");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Locais");

        btnSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/execute.png"))); // NOI18N
        btnSelecionar.setText("Selecionar");
        btnSelecionar.setMinimumSize(new java.awt.Dimension(80, 29));
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        tblLocais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Local", "Tipo", "Atividades"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
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
            tblLocais.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/undo_green.png"))); // NOI18N
        btnSair.setText("Voltar");
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

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/add.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtLocal.setEditable(false);

        try {
            txtDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Local", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table2);
        if (table2.getColumnModel().getColumnCount() > 0) {
            table2.getColumnModel().getColumn(1).setMaxWidth(150);
        }

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/remove.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Local:");

        jLabel6.setText("Data:");

        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("*");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbAtividade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(398, 398, 398)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel6)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel7))
                                                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(btnBuscar))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(0, 111, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       atualizarTabela();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblLocaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLocaisMouseClicked
        if( evt.getClickCount() == 1)
        {
            if( tblLocais.getSelectedRow() != -1 )
            {
                Local l = (Local)tblLocais.getValueAt(tblLocais.getSelectedRow(), 0);
                currentLocal = l;
                
                txtLocal.setText( currentLocal.getDescricao() );
            }
        }
    }//GEN-LAST:event_tblLocaisMouseClicked

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        dispose();
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if( !Util.validarData( txtDate.getText() ) )
        {
            JOptionPane.showMessageDialog( rootPane, "Informe uma data válida !", "alerta", JOptionPane.WARNING_MESSAGE );
            return ;
        }
        
        Date date = Date.valueOf( Util.converterData(txtDate.getText()) );
        
        if( date.after( janela.getAteDate() ) || date.before( janela.getDeDate() ) )
        {
            JOptionPane.showMessageDialog( rootPane, "Informe uma data entre " +
                                                      Util.formatarData( janela.getDeDate().toString()  ) + " - " +
                                                      Util.formatarData( janela.getAteDate().toString()  ),
                                            "alerta", JOptionPane.WARNING_MESSAGE );
            return ;
        }
        
        boolean find = false;
        
        
            for( LocalRota localRota : locaisrotas )
        {
            find |= localRota.getDtRota().equals( date ) && localRota.getRefLocal() == currentLocal.getId();
        }
        
        if( find )
        {
            JOptionPane.showMessageDialog( rootPane, "Local já adicionado com está data", "alerta", JOptionPane.WARNING_MESSAGE );
            return;
        }
        
        LocalRota localRota = new LocalRota();
        localRota.setRefLocal( currentLocal.getId());
        localRota.setDtRota( date );
        
        locaisrotas.add(localRota);
        
        atualizarTabela();
        
        txtLocal.setText("");
        txtDate.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        if( table2.getSelectedRow() != -1 )
        {

            locaisrotas.remove( table2.getSelectedRow() );
            
            atualizarTabela();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
    
    public void atualizarTabela()
    {
        ArrayList<Local> locais = buscar(obterFiltros());
        
        if( locais != null )
        {
            redimencionarTabela( locais.size() );
            redimencionarTabelaDetalhe( locaisrotas.size() );
            
            int cont = 0;

            for (Local local : locais) 
            {
                TipoLocal  tl = tlDAO.buscar(local.getTipoLocal());
                String atividades = atlDAO.obterDescricoesAtividadesLocais(local.getId());
                tblLocais.setValueAt(local, cont, 0);
                tblLocais.setValueAt(tl   , cont, 1);
                tblLocais.setValueAt(atividades, cont, 2);
                cont++;
            }
            
            cont = 0;
            
            for (LocalRota local : locaisrotas ) 
            {
                table2.setValueAt( local, cont, 0);
                table2.setValueAt( Util.formatarData( local.getDtRota().toString() ), cont, 1);
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
            new Object [tamanho][3],
            new String [] {
                "Local", "Tipo", "Atividades"
            }
        ) {
            Class[] types = new Class [] {
               java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        tblLocais.setSelectionMode(0);
    }
    
    public void redimencionarTabelaDetalhe( int tamanho )
    {
        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [tamanho][2],
            new String [] {
                "Local", "Data"
            }
        ) {
            Class[] types = new Class [] {
              java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
               false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        table2.setSelectionMode(0);
    }
    
    public String obterFiltros()
    {
        String filtro = " 1=1 ";
        
        if( !txfDescricao.getText().trim().equals("") )
        {
            filtro += " AND descricao ilike '%"+txfDescricao.getText()+"%'";
        }
        else
        {
            filtro += "AND ativo";
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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LocalView dialog = new LocalView(new javax.swing.JFrame(), true, new RotaView(null, true, 0), new Vector<>());
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
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JComboBox<Atividade> cmbAtividade;
    private javax.swing.JComboBox<TipoLocal> cmbTiposLocais;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table2;
    private javax.swing.JTable tblLocais;
    private javax.swing.JTextField txfDescricao;
    private javax.swing.JFormattedTextField txtDate;
    private javax.swing.JTextField txtLocal;
    // End of variables declaration//GEN-END:variables

    @Override
    public void editar() {
    }
}
