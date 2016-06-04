/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pa.javatur.views.formlist;

import org.pa.javatur.daos.TipoLocalDAO;
import org.pa.javatur.interfaces.FormViewInterface;
import org.pa.javatur.interfaces.ListViewInterface;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.pa.javatur.models.TipoLocal;

public class TipoLocalView extends javax.swing.JDialog implements FormViewInterface<TipoLocal>, ListViewInterface<TipoLocal>
{

    private final TipoLocalDAO dao;

    public TipoLocalView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        txfId.setVisible(false);
        dao = new TipoLocalDAO();
        
        atualizarTabela();
        
        super.setLocationRelativeTo(null);
        
        super.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTipoLocal = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        txfDescricao = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTiposLocais = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnInativar = new javax.swing.JButton();
        txfId = new javax.swing.JTextField();
        cbxAtivo = new javax.swing.JCheckBox();
        btnSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txfFiltro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("JavaTur/Módulos/TiposLocais");
        setResizable(false);

        lblTipoLocal.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblTipoLocal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipoLocal.setText("Tipos De Locais");
        lblTipoLocal.setToolTipText("");
        lblTipoLocal.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lblDescricao.setText("Descrição:");

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/save.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalvarMouseClicked(evt);
            }
        });

        tblTiposLocais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Ativo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblTiposLocais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTiposLocaisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTiposLocais);
        if (tblTiposLocais.getColumnModel().getColumnCount() > 0) {
            tblTiposLocais.getColumnModel().getColumn(1).setMinWidth(50);
            tblTiposLocais.getColumnModel().getColumn(1).setMaxWidth(50);
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
        btnInativar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInativarMouseClicked(evt);
            }
        });

        txfId.setEditable(false);
        txfId.setText("0");
        txfId.setEnabled(false);

        cbxAtivo.setSelected(true);
        cbxAtivo.setText("Ativo");

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/close_window.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/filter.png"))); // NOI18N
        jLabel1.setText("Filtro:");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/search.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("*");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTipoLocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(txfId, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(cbxAtivo)))
                .addGap(329, 532, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDescricao, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txfFiltro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnInativar, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addGap(12, 12, 12))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTipoLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescricao)
                    .addComponent(txfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfId, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInativar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair)
                        .addGap(6, 6, 6))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseClicked
        TipoLocal tipoLocal = new TipoLocal();
        tipoLocal.setDescricao(txfDescricao.getText().trim());
        tipoLocal.setId( Integer.valueOf( txfId.getText()) );
        tipoLocal.setAtivo( cbxAtivo.isSelected() );
        String filtro = "descricao = '"+tipoLocal.getDescricao()+"'";
        if( dao.buscar( filtro ).isEmpty() )
        {
            salvar(tipoLocal);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Já existe um registro com essa descrição", "erro", JOptionPane.ERROR_MESSAGE );
        }
    }//GEN-LAST:event_btnSalvarMouseClicked

    private void tblTiposLocaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTiposLocaisMouseClicked
        if (evt.getClickCount() > 1) 
        {  
            editar();
        }
        else
        {
            btnEditar.setEnabled(true);
            btnInativar.setEnabled(true);   
        }
    }//GEN-LAST:event_tblTiposLocaisMouseClicked

    private void btnInativarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInativarMouseClicked
        
        TipoLocal tipoLocal;
        tipoLocal = (TipoLocal) tblTiposLocais.getValueAt( tblTiposLocais.getSelectedRow(), 0);        
        tipoLocal.setAtivo( !tipoLocal.isAtivo() );
        
        if(dao.salvar(tipoLocal))
        {
            JOptionPane.showMessageDialog(this, "Alterado com sucesso!","informação",2);
            atualizarTabela();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Erro ao alterar!","erro",0);
        }
    }//GEN-LAST:event_btnInativarMouseClicked

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_btnBuscarActionPerformed
   
    public void limparCampos()
    {
        txfDescricao.setText("");
        txfId.setText("0");
        cbxAtivo.setSelected(true);
        
        btnEditar.setEnabled(false);
        btnInativar.setEnabled(false);
        
        txfDescricao.requestFocus();
    }
    
    public void redimencionarTabela(int tamanho) 
    {
        tblTiposLocais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [tamanho][2],
            new String [] {
                "Descrição", "Ativo"
            }){
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class
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
        
        tblTiposLocais.setSelectionMode(0);
        tblTiposLocais.getColumnModel().getColumn(1).setMaxWidth(50);
    }
    
    public void editar()
    {
        TipoLocal tipoLocal;
        tipoLocal = (TipoLocal) tblTiposLocais.getValueAt( tblTiposLocais.getSelectedRow(), 0);        
        txfDescricao.setText(tipoLocal.getDescricao());
        txfId.setText( String.valueOf(tipoLocal.getId()) );
        cbxAtivo.setSelected(tipoLocal.isAtivo());
    }

    public boolean verificarCampos() 
    {
        if( txfDescricao.getText().equalsIgnoreCase("") )
        {
            return false;
        }    
        return true;
    }

    public boolean salvar(TipoLocal object) 
    {
        if( verificarCampos() )
        {
            if ( dao.salvar(object) ) 
            {
                JOptionPane.showMessageDialog(this, "Salvo com sucesso!", "informação", 1);
                atualizarTabela();
                limparCampos();
            } 
            else 
            {
                JOptionPane.showMessageDialog(this, "Erro ao salvar!", "erro", 0);
                return false;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Preencha os campos obrigatórios (*)", "atenção", 2);
            return false;
        }
        return true;
    }

    public void atualizarTabela() 
    {
        ArrayList<TipoLocal> tiposLocais = buscar(obterFiltros());
        
        if( tiposLocais != null )
        {
            redimencionarTabela(tiposLocais.size());
            int cont = 0;
            for (TipoLocal tipoLocal : tiposLocais) 
            {
                tblTiposLocais.setValueAt(tipoLocal, cont, 0);
                tblTiposLocais.setValueAt(tipoLocal.isAtivo(), cont, 1);
                cont++;
            }
        }
    }

    public String obterFiltros() 
    {
        String filtro = "descricao ilike '%" + txfFiltro.getText() +"%' ORDER BY descricao";
        return filtro;
    }

    public ArrayList<TipoLocal> buscar(String filtro) 
    {
        ArrayList<TipoLocal> tiposLocais;
        if( filtro != null )
        {
            tiposLocais = dao.buscar( filtro );
        }
        else
        {
            tiposLocais = dao.buscar();
        }
        return tiposLocais;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TipoLocalView dialog = new TipoLocalView(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox cbxAtivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblTipoLocal;
    private javax.swing.JTable tblTiposLocais;
    private javax.swing.JTextField txfDescricao;
    private javax.swing.JTextField txfFiltro;
    private javax.swing.JTextField txfId;
    // End of variables declaration//GEN-END:variables
}
