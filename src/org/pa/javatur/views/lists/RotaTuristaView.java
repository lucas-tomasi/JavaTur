package org.pa.javatur.views.lists;

import java.awt.Color;
import java.awt.Component;
import org.pa.javatur.daos.RotaTuristaDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import org.pa.javatur.daos.PessoaFisicaDAO;
import org.pa.javatur.models.PessoaFisica;
import org.pa.javatur.models.RotaTurista;
import org.pa.javatur.views.AlterarStatusView;

public class RotaTuristaView extends javax.swing.JDialog{

    RotaTuristaDAO rtDAO;
    PessoaFisicaDAO pfDAO;
    public RotaTuristaView(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();    
        
        rtDAO = new RotaTuristaDAO();
        pfDAO = new PessoaFisicaDAO();
        
        atualizarTabela();
        
        codigoPessoa.setVisible( false );
        codigoRota.setVisible(false);
        
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnStatus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRotaTuristas = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txfTurrista = new javax.swing.JTextField();
        btnSeekTurista = new javax.swing.JToggleButton();
        codigoPessoa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txfRota = new javax.swing.JTextField();
        btnSeekRota = new javax.swing.JToggleButton();
        codigoRota = new javax.swing.JTextField();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("JavaTur/Módulos/Rotas Turistas");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Rotas Turistas");

        btnStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/gear.png"))); // NOI18N
        btnStatus.setText("Alterar Status");
        btnStatus.setEnabled(false);
        btnStatus.setMinimumSize(new java.awt.Dimension(80, 29));
        btnStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStatusMouseClicked(evt);
            }
        });

        tblRotaTuristas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pessoa", "Rota", "Parcelas", "Valor", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tblRotaTuristas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRotaTuristasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRotaTuristas);
        if (tblRotaTuristas.getColumnModel().getColumnCount() > 0) {
            tblRotaTuristas.getColumnModel().getColumn(2).setMaxWidth(200);
            tblRotaTuristas.getColumnModel().getColumn(3).setMaxWidth(200);
            tblRotaTuristas.getColumnModel().getColumn(4).setMaxWidth(200);
        }

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/close_window.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel2.setText("Pessoa:");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/search.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txfTurrista.setEditable(false);
        txfTurrista.setBackground(new java.awt.Color(220, 218, 216));
        txfTurrista.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        txfTurrista.setForeground(new java.awt.Color(1, 1, 1));
        txfTurrista.setEnabled(false);
        txfTurrista.setMinimumSize(new java.awt.Dimension(10, 28));
        txfTurrista.setOpaque(false);
        txfTurrista.setPreferredSize(new java.awt.Dimension(10, 28));

        btnSeekTurista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/lupa.png"))); // NOI18N
        btnSeekTurista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeekTuristaActionPerformed(evt);
            }
        });

        codigoPessoa.setText("0");

        jLabel3.setText("Rota:");

        txfRota.setEditable(false);
        txfRota.setBackground(new java.awt.Color(220, 218, 216));
        txfRota.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        txfRota.setForeground(new java.awt.Color(1, 1, 1));
        txfRota.setEnabled(false);
        txfRota.setMinimumSize(new java.awt.Dimension(10, 28));
        txfRota.setOpaque(false);
        txfRota.setPreferredSize(new java.awt.Dimension(10, 28));

        btnSeekRota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/lupa.png"))); // NOI18N
        btnSeekRota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeekRotaActionPerformed(evt);
            }
        });

        codigoRota.setText("0");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "::Selecione::", "Marcada", "Concluida", "Cancelada" }));

        jLabel4.setText("Status:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(codigoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codigoRota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5)
                        .addComponent(txfTurrista, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btnSeekTurista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(5, 5, 5)
                        .addComponent(txfRota, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeekRota)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txfTurrista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSeekTurista)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txfRota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSeekRota)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscar)
                        .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoRota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatusMouseClicked
        alterarStatus();
    }//GEN-LAST:event_btnStatusMouseClicked

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       atualizarTabela();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSeekTuristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeekTuristaActionPerformed
        txfTurrista.setText("");
        codigoPessoa.setText("");
        new org.pa.javatur.views.seek.PessoaFisicaView(null, true, txfTurrista,codigoPessoa);
    }//GEN-LAST:event_btnSeekTuristaActionPerformed
    
    private void tblRotaTuristasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRotaTuristasMouseClicked
        if( evt.getClickCount() > 1)
        {
            alterarStatus();
        }
        else
        {
            btnStatus.setEnabled(true);
        }
    }//GEN-LAST:event_tblRotaTuristasMouseClicked

    private void btnSeekRotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeekRotaActionPerformed
        txfRota.setText("");
        codigoRota.setText("");
        new org.pa.javatur.views.seek.RotaView(null, true, txfRota, codigoRota);
    }//GEN-LAST:event_btnSeekRotaActionPerformed

    public void alterarStatus()
    {
        if( tblRotaTuristas.getSelectedRow() >= 0 )
        {
            RotaTurista rota = (RotaTurista)tblRotaTuristas.getValueAt(tblRotaTuristas.getSelectedRow(), 1);
            if( rota.getStatus() != RotaTurista.CANCELADA )
            {
                new AlterarStatusView(null, true, rota, this);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Você não pode mudar uma rota cancelada!", "Atenção" , JOptionPane.WARNING_MESSAGE );
            }
        }
    }
    
    public ArrayList<RotaTurista> buscar(String filtro) 
    {
        ArrayList<RotaTurista> locais;
        if( filtro == null )
        {
            locais = rtDAO.buscar();
        }
        else
        {
            locais = rtDAO.buscar(filtro);
        }
        return locais;
    }
    
    public void atualizarTabela()
    {
        ArrayList<RotaTurista> rotas = buscar(obterFiltros());
        if( rotas != null )
        {
            redimencionarTabela(rotas.size());
            
            for (int i = 0; i < rotas.size(); i++) 
            {
                RotaTurista rotaTurista = rotas.get(i);
                
                PessoaFisica pf = pfDAO.buscar(rotaTurista.getRefTurista());
                
                tblRotaTuristas.setValueAt(rotaTurista, i, 1);
                tblRotaTuristas.setValueAt(pf, i, 0);
                tblRotaTuristas.setValueAt(rotaTurista.getTotalParcelas(), i, 2);
                tblRotaTuristas.setValueAt(rotaTurista.getValorTotal(), i, 3);
                tblRotaTuristas.setValueAt(rotaTurista.getStatus(), i, 4);
            }
        }
    }
    
    public void redimencionarTabela( int tamanho )
    {
                tblRotaTuristas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [tamanho][5],
            new String [] {
                "Pessoa", "Rota", "Parcelas", "Valor", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tblRotaTuristas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRotaTuristasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRotaTuristas);
        tblRotaTuristas.getColumnModel().getColumn(2).setMaxWidth(200);
        tblRotaTuristas.getColumnModel().getColumn(3).setMaxWidth(200);
        tblRotaTuristas.getColumnModel().getColumn(4).setMaxWidth(200);
        
        tblRotaTuristas.setSelectionMode(0);
        
        tblRotaTuristas.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
            {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
                if (String.valueOf(table.getValueAt(row, 4)).equalsIgnoreCase(String.valueOf(RotaTurista.CANCELADA))) {
                    if(column == 4)
                    {
                        setValue("Cancelada");
                    }
                    setBackground(new Color(242,222,222));
                    setForeground(new Color(255, 0, 0));
                } 
                else if(String.valueOf(table.getValueAt(row, 4)).equalsIgnoreCase(String.valueOf(RotaTurista.MARCADA))) 
                {
                    if(column == 4)
                    {
                        setValue("Marcada");
                    }
                    setBackground(new Color(166,228,165));
                    setForeground(new Color(18,98,40));
                }
                else
                {
                    if(column == 4)
                    {
                        setValue("Concluida");
                    }
                    setBackground(new Color(248,239,192));
                    setForeground(new Color(138,109,59));
                }
                
                if( column == 3 || column == 4 )
                {
                    setHorizontalAlignment(RIGHT);
                }
                else
                {
                    setHorizontalAlignment(LEFT);
                }
                return this;
            }
        });
    }
    
    public String obterFiltros()
    {
        String filtro = " 1=1 ";
        
        if( !codigoPessoa.getText().equalsIgnoreCase("0"))
        {
            filtro += " AND ref_turista = "+codigoPessoa.getText();
        }
        if( cmbStatus.getSelectedIndex() != 0 )
        {
            if( cmbStatus.getSelectedIndex() == 1 )
            {
                filtro += " AND status = '"+RotaTurista.MARCADA+"'";
            }
            else 
            {
                if( cmbStatus.getSelectedIndex()  == 2 )
                {
                    filtro += " AND status = '"+RotaTurista.CONCLUIDA+"'";
                }
                else
                {
                    filtro += " AND status = '"+RotaTurista.CANCELADA+"'";
                }
            }
                
        }
        
        if( !codigoRota.getText().equalsIgnoreCase("0"))
        {
            filtro += " AND ref_rota = "+codigoRota.getText();
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
            java.util.logging.Logger.getLogger(RotaTuristaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RotaTuristaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RotaTuristaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RotaTuristaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RotaTuristaView dialog = new RotaTuristaView(new javax.swing.JFrame(), true);
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
    private javax.swing.JToggleButton btnSeekRota;
    private javax.swing.JToggleButton btnSeekTurista;
    private javax.swing.JButton btnStatus;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JTextField codigoPessoa;
    private javax.swing.JTextField codigoRota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRotaTuristas;
    private javax.swing.JTextField txfRota;
    private javax.swing.JTextField txfTurrista;
    // End of variables declaration//GEN-END:variables
}
