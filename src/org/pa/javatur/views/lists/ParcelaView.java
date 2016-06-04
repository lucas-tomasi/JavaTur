package org.pa.javatur.views.lists;

import java.awt.Color;
import java.awt.Component;
import java.sql.Date;
import org.pa.javatur.daos.ParcelaDAO;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import org.pa.javatur.javatur.Util;
import org.pa.javatur.models.Parcela;
import org.pa.javatur.views.PagarView;

public class ParcelaView extends javax.swing.JDialog{

    ParcelaDAO pDAO;
    
    public ParcelaView(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();    
        
        pDAO = new ParcelaDAO();
        
        codigoPessoa.setVisible( false );
        String de = Util.getDataHoje();
        String ate = Util.getDataProximoMes();
        ftfDe.setText(de);        
        ftfAte.setText(ate);

        atualizarTabela();
        
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnPagar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblParcelas = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txfTurrista = new javax.swing.JTextField();
        btnSeekTurista = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        ftfAte = new javax.swing.JFormattedTextField();
        ftfDe = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        codigoPessoa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbSituacao = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("JavaTur/Módulos/Parcelas");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Parcelas");

        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/money_bag.png"))); // NOI18N
        btnPagar.setText("Pagar");
        btnPagar.setMinimumSize(new java.awt.Dimension(80, 29));
        btnPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPagarMouseClicked(evt);
            }
        });

        tblParcelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pessoa", "Rota", "Parcela", "Vencimento", "Pagamento", "Valor Pago", "Valor", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblParcelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblParcelasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblParcelas);
        if (tblParcelas.getColumnModel().getColumnCount() > 0) {
            tblParcelas.getColumnModel().getColumn(2).setMaxWidth(100);
            tblParcelas.getColumnModel().getColumn(6).setMaxWidth(100);
            tblParcelas.getColumnModel().getColumn(7).setMaxWidth(100);
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

        jLabel5.setText("Venc.:");

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

        jLabel6.setText("Situação:");

        codigoPessoa.setText("0");

        jLabel7.setText("Até:");

        cmbSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "::Selecione::", "Aberta", "Cancelada", "Paga" }));

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
                        .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(codigoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5)
                        .addComponent(txfTurrista, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeekTurista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6)
                        .addComponent(ftfDe, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(6, 6, 6)
                        .addComponent(ftfAte, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(ftfDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(txfTurrista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(ftfAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar)
                        .addComponent(jLabel7)
                        .addComponent(cmbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSeekTurista))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPagarMouseClicked
        pagar();
    }//GEN-LAST:event_btnPagarMouseClicked

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

    private void tblParcelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblParcelasMouseClicked
        if( evt.getClickCount() > 1)
        {
            pagar();
        }
    }//GEN-LAST:event_tblParcelasMouseClicked

    public void pagar()
    {
        Parcela parcela = (Parcela)tblParcelas.getValueAt(tblParcelas.getSelectedRow(), 7);
        new PagarView(null, true, parcela, this);
    }
    
    public ArrayList<Parcela> buscar(String filtro) 
    {
        ArrayList<Parcela> locais;
        if( filtro == null )
        {
            locais = pDAO.buscar();
        }
        else
        {
            locais = pDAO.buscar(filtro);
        }
        return locais;
    }
    
    public void atualizarTabela()
    {
        ArrayList<Parcela> parcelas = buscar(obterFiltros());
        if( parcelas != null )
        {
            redimencionarTabela(parcelas.size());
            
            for (int i = 0; i < parcelas.size(); i++) 
            {
                Parcela parcela = parcelas.get(i);
                
                String dataPagamento = (parcela.getDtPagamento() != null)? Util.formatarData(parcela.getDtPagamento().toString()) : "";
                
                tblParcelas.setValueAt(pDAO.getTurista(parcela.getId()), i, 0);
                tblParcelas.setValueAt(pDAO.getRota(parcela.getId()), i, 1);
                tblParcelas.setValueAt(parcela.getParcela(), i, 2);
                tblParcelas.setValueAt(Util.formatarData(parcela.getDtVencimento().toString()), i, 3);
                tblParcelas.setValueAt(dataPagamento, i, 4);
                tblParcelas.setValueAt(Util.formatarValor(parcela.getValorRealizado()), i, 5);
                tblParcelas.setValueAt(Util.formatarValor(parcela.getValorEstimado()), i, 6);
                tblParcelas.setValueAt(parcela, i, 7);
            }
        }
    }
    
    public void redimencionarTabela( int tamanho )
    {
        tblParcelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [tamanho][8],
            new String [] {
                "Pessoa", "Rota", "Parcela", "Vencimento", "Pagamento", "Valor Pago", "Valor", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblParcelas);
        tblParcelas.getColumnModel().getColumn(2).setMaxWidth(100);
        tblParcelas.getColumnModel().getColumn(6).setMaxWidth(100);
        tblParcelas.getColumnModel().getColumn(7).setMaxWidth(100);
        
        tblParcelas.setSelectionMode(0);
        
        tblParcelas.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
            {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
                if (String.valueOf(table.getValueAt(row, 7)).equalsIgnoreCase(String.valueOf(Parcela.STATUS_CANCELADA))) {
                    if(column == 7)
                    {
                        setValue("Cancelada");
                    }
                    setBackground(new Color(242,222,222));
                    setForeground(new Color(255, 0, 0));
                } 
                else if(String.valueOf(table.getValueAt(row, 7)).equalsIgnoreCase(String.valueOf(Parcela.STATUS_PAGA))) 
                {
                    if(column == 7)
                    {
                        setValue("Paga");
                    }
                    setBackground(new Color(166,228,165));
                    setForeground(new Color(18,98,40));
                }
                else
                {
                    if(column == 7)
                    {
                        setValue("Aberta");
                    }
                    setBackground(new Color(248,239,192));
                    setForeground(new Color(138,109,59));
                }
                
                if( column == 6  || column == 3 || column == 4 || column == 5 || column == 2 )
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
            filtro += " AND exists ( SELECT pr.ref_parcela "
                    + "                FROM parcelas_rotas pr, "
                    + "                     rotas_turistas rt "
                    + "               WHERE pr.ref_rota_turista = rt.id "
                    + "                 AND parcelas.id = pr.ref_parcela "
                    + "                 AND rt.ref_turista = "+codigoPessoa.getText()+")";
        }
        if( cmbSituacao.getSelectedIndex() != 0)
        {
            if ( cmbSituacao.getSelectedIndex() == 1 )
            {
                filtro += " AND status_pagamento = 'A'";            
            }
            else if ( cmbSituacao.getSelectedIndex() == 2)
            {
                filtro += " AND status_pagamento = 'C'";
            }
            else
            {
                filtro += " AND status_pagamento = 'P'";
            }
        }
        if(!ftfDe.getText().trim().equals("/  /") || !ftfAte.getText().trim().equals("/  /"))
        {
            if( !ftfAte.getText().trim().equals("/  /") )
            {
                filtro += " AND dt_vencimento <= '"+Util.converterData(ftfAte.getText())+"'";
            }
            if( !ftfDe.getText().trim().equals("/  /"))
            {
                filtro += " AND dt_vencimento >= '"+Util.converterData(ftfDe.getText())+"'";
            }
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
            java.util.logging.Logger.getLogger(ParcelaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParcelaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParcelaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParcelaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ParcelaView dialog = new ParcelaView(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnSair;
    private javax.swing.JToggleButton btnSeekTurista;
    private javax.swing.JComboBox<String> cmbSituacao;
    private javax.swing.JTextField codigoPessoa;
    private javax.swing.JFormattedTextField ftfAte;
    private javax.swing.JFormattedTextField ftfDe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblParcelas;
    private javax.swing.JTextField txfTurrista;
    // End of variables declaration//GEN-END:variables
}
