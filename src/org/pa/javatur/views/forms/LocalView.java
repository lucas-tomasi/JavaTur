
package org.pa.javatur.views.forms;

import org.pa.javatur.daos.AtividadeDAO;
import org.pa.javatur.daos.AtividadeLocalDAO;
import org.pa.javatur.daos.LocalDAO;
import org.pa.javatur.daos.TipoLocalDAO;
import org.pa.javatur.interfaces.FormViewInterface;
import java.awt.event.KeyEvent;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Vector;
import org.pa.javatur.javatur.Util;
import javax.swing.DefaultCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;
import org.pa.javatur.models.Atividade;
import org.pa.javatur.models.AtividadeLocal;
import org.pa.javatur.models.Local;
import org.pa.javatur.models.TipoLocal;
import org.pa.javatur.views.AtividadeValorView;

public class LocalView extends javax.swing.JDialog implements FormViewInterface<Local>{

    LocalDAO lDAO;
    AtividadeDAO atDAO;
    TipoLocalDAO tlDAO;
    AtividadeLocalDAO atlDAO;
    Vector<Atividade> atividadesDisponiveis;
    protected static ArrayList<AtividadeLocal> atividades;
    
    public LocalView(java.awt.Frame parent, boolean modal, int id ) {
        super(parent, modal);
        initComponents();
        
        lDAO  = new LocalDAO();
        atDAO = new AtividadeDAO();
        tlDAO = new TipoLocalDAO();
        atlDAO = new AtividadeLocalDAO();

        atividades = new ArrayList<>();
        atividadesDisponiveis = new Vector<>();
        
        iniciar( id );
        
        txfId.setVisible(false);
        
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        txfDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbxAtivo = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        cmbTiposLocais = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstAtividadesDisponiveis = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaObs = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        btnAdiciona = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txfId = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblAtvLocal = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("JavaTur/Módulos/Locais");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Locais");

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/undo_green.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel2.setText("Tipo de Local:");

        jLabel3.setText("Descrição:");

        cbxAtivo.setSelected(true);
        cbxAtivo.setText("Ativo");

        jLabel4.setText("Atividades do local:");

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/save.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lstAtividadesDisponiveis.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstAtividadesDisponiveis.setToolTipText("");
        lstAtividadesDisponiveis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lstAtividadesDisponiveis.setDragEnabled(true);
        lstAtividadesDisponiveis.setMinimumSize(new java.awt.Dimension(150, 0));
        lstAtividadesDisponiveis.setPreferredSize(new java.awt.Dimension(150, 0));
        lstAtividadesDisponiveis.setVerifyInputWhenFocusTarget(false);
        lstAtividadesDisponiveis.setVisibleRowCount(1);
        lstAtividadesDisponiveis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstAtividadesDisponiveisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstAtividadesDisponiveis);

        txaObs.setColumns(20);
        txaObs.setRows(5);
        jScrollPane2.setViewportView(txaObs);

        jLabel5.setText("Observação:");

        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("*");

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("*");

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/arrow_right.png"))); // NOI18N
        btnRemove.setMaximumSize(new java.awt.Dimension(28, 35));
        btnRemove.setMinimumSize(new java.awt.Dimension(28, 35));
        btnRemove.setPreferredSize(new java.awt.Dimension(30, 35));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnAdiciona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/arrow_left.png"))); // NOI18N
        btnAdiciona.setMaximumSize(new java.awt.Dimension(28, 35));
        btnAdiciona.setMinimumSize(new java.awt.Dimension(28, 35));
        btnAdiciona.setPreferredSize(new java.awt.Dimension(30, 35));
        btnAdiciona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionaActionPerformed(evt);
            }
        });

        jLabel6.setText("Atividades disponiveis:");

        txfId.setText("0");

        tblAtvLocal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Atividade", "Hr Inicial", "Hr Fim", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblAtvLocal);
        if (tblAtvLocal.getColumnModel().getColumnCount() > 0) {
            tblAtvLocal.getColumnModel().getColumn(1).setMaxWidth(80);
            tblAtvLocal.getColumnModel().getColumn(2).setMaxWidth(60);
            tblAtvLocal.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxAtivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2)
                                .addComponent(cmbTiposLocais, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txfDescricao)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                    .addComponent(btnAdiciona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel4))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbTiposLocais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbxAtivo)
                                    .addComponent(txfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnAdiciona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnVoltar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.setVisible(false);
        new org.pa.javatur.views.lists.LocalView(null, true);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
       
        if( validarHorarios() )
        {
            Local local = new Local();
            TipoLocal tipoLocal = (TipoLocal) cmbTiposLocais.getSelectedItem();
            local.setAtivo(cbxAtivo.isSelected());
            local.setDescricao(txfDescricao.getText());
            local.setId(Integer.valueOf(txfId.getText()));
            local.setTipoLocal(tipoLocal.getId());
            local.setObs(txaObs.getText());

            salvar(local);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAdicionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionaActionPerformed
        adicionarAtividade();
    }//GEN-LAST:event_btnAdicionaActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        removerAtividade();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void lstAtividadesDisponiveisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstAtividadesDisponiveisMouseClicked
        if( evt.getClickCount() > 1 )
        {
            adicionarAtividade();
        }        
    }//GEN-LAST:event_lstAtividadesDisponiveisMouseClicked

    private boolean validarHorarios()
    {
        boolean situacao = false;
        for(int linha =0; linha < tblAtvLocal.getRowCount(); linha++)
        {        
            AtividadeLocal atl = (AtividadeLocal) tblAtvLocal.getValueAt(linha, 0);

            atividades.remove(atl);
            try
            {
                if(tblAtvLocal.getValueAt(linha,1) != null)
                {
                    atl.setHrIni(Time.valueOf(String.valueOf(tblAtvLocal.getValueAt(linha,1))));
                }
                if(tblAtvLocal.getValueAt(linha,2) != null)
                {
                    atl.setHrFim(Time.valueOf(String.valueOf(tblAtvLocal.getValueAt(linha,2))));
                }
                if(tblAtvLocal.getValueAt(linha,3) != null)
                {
                    atl.setValor(Double.valueOf(String.valueOf(tblAtvLocal.getValueAt(linha,3))));
                }
                atividades.add(atl);
                situacao = true;
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, "Algum(ns) dados estão inválidos");
                System.err.println(e);
                return false;
            }
        }
        
        return situacao;
    }
        
    private void redimencionarTabela( int tamanho )
    {
        tblAtvLocal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [tamanho][4],
            new String [] {
                "Atividade", "Hr Inicial", "Hr Fim", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
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
        tblAtvLocal.setSelectionMode(0);
       
        
    }
    
    private void atualizarTabela()
    {
        if( atividades != null )
        {
            redimencionarTabela(atividades.size());
            for (int i = 0; i < atividades.size(); i++) 
            {
                tblAtvLocal.setValueAt(atividades.get(i), i, 0);
                tblAtvLocal.setValueAt(atividades.get(i).getHrIni(), i, 1);
                tblAtvLocal.setValueAt(atividades.get(i).getHrFim(), i, 2);
                tblAtvLocal.setValueAt(atividades.get(i).getValor(), i, 3);
            }
        }
    }
    
    public boolean salvar(Local object) 
    {
        if( verificarHoras() )
        {
            if( verificarCampos() )
            {
                if (lDAO.salvar(object)) 
                {
                    int id = ( object.getId() == 0 )? lDAO.lastID() : object.getId() ;

                    atlDAO.excluirAtividades(id);
                    atividades.forEach( (at) ->{
                        AtividadeLocal al = new AtividadeLocal();
                        al.setLocal(id);
                        al.setAtividade(at.getAtividade());
                        al.setHrFim(at.getHrFim());
                        al.setHrIni(at.getHrIni());
                        al.setValor(at.getValor());
                        atlDAO.salvar(al);
                    });

                    JOptionPane.showMessageDialog(this, "Salvo com sucesso!", "informação", 1);
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
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Existem inconformidades com os horarios!" , "atenção" ,2);
            return false;
        }
        return true;
    }
    
    public void removerAtividade()
    {     
        if(tblAtvLocal.getSelectedRow() >= 0 )
        {
            AtividadeLocal atividadeLocal = (AtividadeLocal)tblAtvLocal.getValueAt(tblAtvLocal.getSelectedRow(),0);
            if( atividadeLocal != null )
            {
                atividades.remove(atividadeLocal);

                atualizarTabela();

                this.repaint();
            }
        }
    }
    
    public void adicionarAtividade()
    {     
        Atividade atividade = lstAtividadesDisponiveis.getSelectedValue();
        if( atividade != null )
        {   
            AtividadeLocal atl = new AtividadeLocal();
            
            atl.setAtividade(atividade.getId());
            
            new AtividadeValorView(null,true, atl);
            if( atl.getAtividade() != 0 )
            {
                atividades.add(atl);
                atualizarTabela();
            }

            this.repaint();
        }
    }
    
    private boolean verificarHoras()
    {
        for (int i = 0; i < atividades.size(); i++) 
        {
            AtividadeLocal atl = atividades.get(i);
            if( atl.getHrFim() != null && atl.getHrIni() != null )
            {
                if( atl.getHrFim().before(atl.getHrIni()))
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
        return true;
    }
    
    public boolean verificarCampos()
    {
        if( txfDescricao.getText().equalsIgnoreCase("") )
        {
            return false;
        }
        else if( cmbTiposLocais.getSelectedIndex() == 0 )
        {
            return false;
        }
        
        return true;
    }
    
    public void limparCampos()
    {
        txfDescricao.setText("");
        cmbTiposLocais.setSelectedIndex(0);
        cbxAtivo.setSelected(true);
        txaObs.setText("");
        atividades.clear();
        atualizarTabela();
        this.repaint();
    }
    
    private void preencherComboTipoLocal( int idSelecionado )
    {
        ArrayList<TipoLocal> tipos = tlDAO.buscar("ativo");
        cmbTiposLocais.addItem( new TipoLocal(":: Selecione ::") );
        tipos.forEach( (tipo)-> {
            cmbTiposLocais.addItem(tipo);
        });
        
        cmbTiposLocais.setSelectedIndex( idSelecionado );
    }
    
    private void preencherListaAtividadesDisponiveis()
    {
        String filtro = "ativo";
        
        ArrayList<Atividade> ats = atDAO.buscar( filtro );
        atividadesDisponiveis = new Vector<>(ats);
        lstAtividadesDisponiveis.setListData(new Vector(atividadesDisponiveis ));
        this.repaint();
    }
    
    private void preencherListaAtividades(  int id )
    {
        String filtro = " ( id in ( SELECT id FROM atividades_locais WHERE ref_local = " + id + ") )";   
        
        
        atividades = atlDAO.buscar( filtro );
        
        atualizarTabela();
    }
    
    private void iniciar(int id)
    {
        int idTipoLocal = 0;
        if( id != 0 )
        {
            Local local  = lDAO.buscar(id);

            txfDescricao.setText(local.getDescricao());
            txaObs.setText(local.getObs());
            txfId.setText(String.valueOf(local.getId()));
            cbxAtivo.setSelected(local.isAtivo());
            idTipoLocal = local.getTipoLocal();
        }
        
        preencherComboTipoLocal(idTipoLocal);
        preencherListaAtividades(id);
        preencherListaAtividadesDisponiveis();
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
                LocalView dialog = new LocalView(new javax.swing.JFrame(), true, new Integer("") );
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
    private javax.swing.JButton btnAdiciona;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JCheckBox cbxAtivo;
    private javax.swing.JComboBox<TipoLocal> cmbTiposLocais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<Atividade> lstAtividadesDisponiveis;
    private javax.swing.JTable tblAtvLocal;
    private javax.swing.JTextArea txaObs;
    private javax.swing.JTextField txfDescricao;
    private javax.swing.JTextField txfId;
    // End of variables declaration//GEN-END:variables

}
