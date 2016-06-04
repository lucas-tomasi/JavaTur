package org.pa.javatur.views.lists;

import org.pa.javatur.daos.PessoaFisicaDAO;
import org.pa.javatur.interfaces.ListViewInterface;
import java.util.ArrayList;
import org.pa.javatur.javatur.Util;
import javax.swing.JOptionPane;
import org.pa.javatur.models.PessoaFisica;
import org.pa.javatur.views.PrincipalView;

public class PessoaFisicaView extends javax.swing.JDialog implements ListViewInterface<PessoaFisica>{

    PessoaFisicaDAO pfDAO;
    
    public PessoaFisicaView(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();    
        
        pfDAO = new PessoaFisicaDAO();
                  
        atualizarTabela();
        
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdgSexo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPessoasFisicas = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnInativar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        txfNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        ftfCPF = new javax.swing.JFormattedTextField();
        ftfData = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        rbtMasculino = new javax.swing.JRadioButton();
        rbtFeminino = new javax.swing.JRadioButton();
        rbtIndeterminado = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        cmbSituacao = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("JavaTur/Módulos/PessoasFiscias");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pessoas Físicas");

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/add_button.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setMinimumSize(new java.awt.Dimension(80, 29));
        btnNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNovoMouseClicked(evt);
            }
        });

        tblPessoasFisicas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Sexo", "Data Nasc.", "CPF", "E-mail", "Telefone", "Ativo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPessoasFisicas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPessoasFisicasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPessoasFisicas);
        if (tblPessoasFisicas.getColumnModel().getColumnCount() > 0) {
            tblPessoasFisicas.getColumnModel().getColumn(1).setMinWidth(50);
            tblPessoasFisicas.getColumnModel().getColumn(1).setMaxWidth(50);
            tblPessoasFisicas.getColumnModel().getColumn(6).setMaxWidth(50);
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

        jLabel2.setText("Nome:");

        jLabel3.setText("CPF:");

        jLabel4.setText("Sexo:");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/search.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        try {
            ftfCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfCPF.setText("");
        ftfCPF.setToolTipText("");
        ftfCPF.setMinimumSize(new java.awt.Dimension(112, 27));

        try {
            ftfData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfData.setText("");

        jLabel5.setText("Data Nasc.:");

        rdgSexo.add(rbtMasculino);
        rbtMasculino.setText("Masculino");

        rdgSexo.add(rbtFeminino);
        rbtFeminino.setText("Feminino");

        rdgSexo.add(rbtIndeterminado);
        rbtIndeterminado.setSelected(true);
        rbtIndeterminado.setText("ambos");

        jLabel6.setText("Situação:");

        cmbSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "::Selecione::", "Ativa", "Inativa" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ftfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ftfData, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbtMasculino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtFeminino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtIndeterminado)
                                .addGap(12, 12, 12))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnInativar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtMasculino)
                            .addComponent(rbtFeminino)
                            .addComponent(rbtIndeterminado)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnBuscar)
                    .addComponent(ftfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(cmbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
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
        new org.pa.javatur.views.forms.PessoaFisicaView(null, true, 0 );
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

    private void tblPessoasFisicasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPessoasFisicasMouseClicked
        if( evt.getClickCount() > 1)
        {
            editar();
        }
        else
        {
            btnEditar.setEnabled(true);
            btnInativar.setEnabled(true);
        }
    }//GEN-LAST:event_tblPessoasFisicasMouseClicked

    private void btnInativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInativarActionPerformed
        PessoaFisica local = (PessoaFisica)tblPessoasFisicas.getValueAt(tblPessoasFisicas.getSelectedRow(), 0);
        
        if( inativar(local) )
        {
            btnEditar.setEnabled(false);
            btnInativar.setEnabled(false);
            atualizarTabela();
        }
    }//GEN-LAST:event_btnInativarActionPerformed

    public ArrayList<PessoaFisica> buscar(String filtro) 
    {
        ArrayList<PessoaFisica> pessoas;
        if( filtro == null )
        {
            pessoas = pfDAO.buscar();
        }
        else
        {
            pessoas = pfDAO.buscar(filtro);
        }
        return pessoas;
    }
    
    private boolean inativar( PessoaFisica pessoa )
    {
        try 
        {
            pessoa.setAtivo(!pessoa.isAtivo() );
            pessoa.setCpf(Util.converterCPF(pessoa.getCpf()));
            
            pfDAO.salvar(pessoa);
            JOptionPane.showMessageDialog(this, "Alterado com sucesso!","informação",1);
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
        PessoaFisica local = (PessoaFisica) tblPessoasFisicas.getValueAt(tblPessoasFisicas.getSelectedRow(),0);
        new org.pa.javatur.views.forms.PessoaFisicaView(null, true, local.getId() );
    }
    
    public void atualizarTabela()
    {
        ArrayList<PessoaFisica> pessoas = buscar(obterFiltros());
        
        if( pessoas != null )
        {
            redimencionarTabela( pessoas.size() );
        
            int cont = 0;

            for (PessoaFisica pessoa : pessoas) 
            {
                String sexo = (pessoa.getSexo()=='M')?"Masculino":"Feminino";
                tblPessoasFisicas.setValueAt(pessoa, cont, 0);
                tblPessoasFisicas.setValueAt(sexo, cont, 1);
                tblPessoasFisicas.setValueAt(Util.formatarData( pessoa.getDtNascimento().toString()), cont, 2);
                tblPessoasFisicas.setValueAt(pessoa.getCpf(), cont, 3);
                tblPessoasFisicas.setValueAt(pessoa.getEmail(), cont, 4);
                tblPessoasFisicas.setValueAt(pessoa.getTelefone(), cont, 5);
                tblPessoasFisicas.setValueAt(pessoa.isAtivo() , cont, 6);
                cont++;
            }
        }
    }
    
    
    public void redimencionarTabela( int tamanho )
    {
        tblPessoasFisicas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [tamanho][7] ,
            new String [] {
                "Nome", "Sexo", "Data Nasc.", "CPF", "E-mail", "Telefone", "Ativo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPessoasFisicas.setSelectionMode(0);
    }
    
    public String obterFiltros()
    {
        String filtro = " 1=1 ";

        if( !txfNome.getText().trim().equals("") )
        {
            filtro += " AND descricao ilike '%"+txfNome.getText()+"%'";
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
        if( Util.validarData(ftfData.getText()))
        {
            if( !ftfData.getText().trim().equals("/  /"))
            {
                filtro += " AND dt_nascimento = '"+Util.converterData(ftfData.getText())+"'";
            }
        }
        if( Util.validarData(ftfCPF.getText()))
        {
            if( !ftfCPF.getText().trim().equals(".   .   -") )
            {
                filtro += " AND cpf = '"+Util.converterCPF(ftfCPF.getText())+"'";
            }
        }
        if(rbtFeminino.isSelected())
        {
            filtro += " AND sexo = 'F'";
        }
        else if(rbtMasculino.isSelected())
        {
            filtro += " AND sexo = 'M'";
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
            java.util.logging.Logger.getLogger(PessoaFisicaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PessoaFisicaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PessoaFisicaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PessoaFisicaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PessoaFisicaView dialog = new PessoaFisicaView(new javax.swing.JFrame(), true);
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
    private javax.swing.JFormattedTextField ftfCPF;
    private javax.swing.JFormattedTextField ftfData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtFeminino;
    private javax.swing.JRadioButton rbtIndeterminado;
    private javax.swing.JRadioButton rbtMasculino;
    private javax.swing.ButtonGroup rdgSexo;
    private javax.swing.JTable tblPessoasFisicas;
    private javax.swing.JTextField txfNome;
    // End of variables declaration//GEN-END:variables
}
