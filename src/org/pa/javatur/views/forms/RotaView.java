
package org.pa.javatur.views.forms;

import org.pa.javatur.daos.LocalDAO;
import org.pa.javatur.daos.LocalRotaDAO;
import org.pa.javatur.daos.RotaDAO;
import org.pa.javatur.interfaces.FormViewInterface;
import java.sql.Date;
import java.util.Vector;
import org.pa.javatur.javatur.Util;
import javax.swing.DefaultCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;
import org.pa.javatur.models.LocalRota;
import org.pa.javatur.models.Rota;
import org.pa.javatur.views.seek.LocalView;

public class RotaView extends javax.swing.JDialog implements FormViewInterface<Rota>{

    LocalDAO lDAO;
    RotaDAO  rDAO;
    LocalRotaDAO rlDAO;
    protected static Vector<LocalRota> locais;
    
    public RotaView(java.awt.Frame parent, boolean modal, int id ) {
        super(parent, modal);
        initComponents();
        
        lDAO  = new LocalDAO();
        rDAO = new RotaDAO();
        rlDAO = new LocalRotaDAO();
        locais = new Vector<>();

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
        btnSalvar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaObs = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txfId = new javax.swing.JTextField();
        ftfDe = new javax.swing.JFormattedTextField();
        ftfAte = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txfvagas = new javax.swing.JTextField();
        txfValor = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstLocais = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("JavaTur/Módulos/Rotas");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Rotas");

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/undo_green.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel2.setText("De:");

        jLabel3.setText("Descrição:");

        cbxAtivo.setSelected(true);
        cbxAtivo.setText("Ativo");

        jLabel4.setText("Locais:");

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/save.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        txaObs.setColumns(20);
        txaObs.setRows(5);
        jScrollPane2.setViewportView(txaObs);

        jLabel5.setText("Observação:");

        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("*");

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("*");

        txfId.setText("0");

        try {
            ftfDe.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            ftfAte.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Até:");

        jLabel9.setText("Valor:");

        jLabel10.setText("Vagas:");

        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("*");

        txfvagas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfvagasKeyTyped(evt);
            }
        });

        txfValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfValorKeyTyped(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/remove.png"))); // NOI18N
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/add.png"))); // NOI18N
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        lstLocais.setModel(new javax.swing.table.DefaultTableModel(
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
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        lstLocais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstLocaisMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(lstLocais);
        if (lstLocais.getColumnModel().getColumnCount() > 0) {
            lstLocais.getColumnModel().getColumn(1).setMaxWidth(120);
        }

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/calendar2.png"))); // NOI18N

        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("*");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(299, 299, 299))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11))
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfDescricao)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txfvagas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxAtivo)
                                .addGap(105, 105, 105)
                                .addComponent(txfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ftfDe, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ftfAte, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addGap(6, 6, 6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 246, Short.MAX_VALUE)
                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ftfDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(ftfAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel8))
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txfvagas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(txfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(174, 174, 174))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxAtivo))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnVoltar))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalvar)))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.setVisible(false);
        new org.pa.javatur.views.lists.RotaView(null, true);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if( verificaDatas() )
        {
            if( verificarCampos() )
            {
                Rota rota = new Rota();
                rota.setAtivo(cbxAtivo.isSelected());
                rota.setDescricao(txfDescricao.getText());
                rota.setId(Integer.valueOf(txfId.getText()));
                rota.setObs(txaObs.getText());
                rota.setDtFim( Date.valueOf(Util.converterData(ftfAte.getText())) );
                rota.setDtInicio(Date.valueOf(Util.converterData(ftfDe.getText())) );
                rota.setVagas( Integer.parseInt( txfvagas.getText() ) );
                rota.setValor( Double.parseDouble( txfValor.getText() ) );
                salvar(rota);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Preencha campos obrigatórios(*)" , "alerta!", JOptionPane.WARNING_MESSAGE );
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Existem incoerências com as datas" , "erro!", JOptionPane.ERROR_MESSAGE );
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txfValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfValorKeyTyped
        // CopyPaste
        if( !Util.isNumero(evt.getKeyChar()) )
        {
            evt.consume();
        }
    }//GEN-LAST:event_txfValorKeyTyped

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
       
        if( !Util.validarData( ftfAte.getText() ) || !Util.validarData( ftfDe.getText() ) )
        {
            JOptionPane.showMessageDialog( rootPane, "Informe as datas antes de adicionar locais!", "alerta", JOptionPane.WARNING_MESSAGE );
            return;
        }
        this.setVisible(false);
        new LocalView(null, true, this, locais);
        this.setVisible(true);
        atualizarTabela();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void txfvagasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfvagasKeyTyped
        // CopyPaste
        if( !Util.isNumero(evt.getKeyChar()) )
        {
            evt.consume();
        }
    }//GEN-LAST:event_txfvagasKeyTyped

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        removerLocal();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void lstLocaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstLocaisMouseClicked
        btnDelete.setEnabled(true);
    }//GEN-LAST:event_lstLocaisMouseClicked
    
    public boolean salvar(Rota object) 
    {
        if( verificarCampos() )
        {
            if (rDAO.salvar(object)) 
            {
                int id = ( object.getId() == 0 )? rDAO.lastID() : object.getId();
                rlDAO.delete(id);
                for( LocalRota localRota : locais)
                {
                    localRota.setId(0);
                    localRota.setRefRota(id);
                    rlDAO.salvar(localRota);
                }
                
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
        return true;
    }
    
    public void removerLocal()
    {      
        if( lstLocais.getSelectedRow() >= 0 )
        {
            locais.remove( lstLocais.getSelectedRow() );
            atualizarTabela();
        }
    }
    
    public void adicionarLocal()
    {
        new LocalView(null, true, this, locais);
    }
    
    public void atualizarTabela()
    {
        redimencionarTabela(locais.size());
        if( !locais.isEmpty() )
        {
            for (int i = 0; i < locais.size(); i++) 
            {
                lstLocais.setValueAt( locais.get(i) , i , 0 );
                lstLocais.setValueAt( Util.formatarData(String.valueOf(locais.get(i).getDtRota())), i , 1 );
            }
        }
        this.repaint();
    }
    
    public void redimencionarTabela( int tamanho )
    {
        lstLocais.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(lstLocais);
        lstLocais.getColumnModel().getColumn(1).setMaxWidth(150);
        
       
    }
    
    public boolean verificarCampos()
    {
        if( txfDescricao.getText().equalsIgnoreCase("") )
        {
            return false;
        }
        if( !Util.validarData(ftfAte.getText() ) )
        {
            return false;
        }
        if( !Util.validarData(ftfDe.getText()) )
        {
            return false;
        }
        if( txfvagas.getText().equalsIgnoreCase(""))
        {
            return false;
        }
        if( txfValor.getText().equalsIgnoreCase(""))
        {
            return false;
        }
        if( locais.isEmpty() )
        {
            return false;
        }        
        
        return true;
    }
    
    public boolean verificaDatas()
    {
        if( !locais.isEmpty() )
        {
            for (int i = 0; i < locais.size(); i++) 
                {
                    LocalRota lr = (LocalRota) locais.get(i);
                    if( lr.getDtRota() != null )
                    {
                        if( lr.getDtRota().after( Date.valueOf( Util.converterData(ftfAte.getText()) ) ) || lr.getDtRota().before(Date.valueOf( Util.converterData(ftfDe.getText()) ) ))
                        {
                            return false;
                        }
                    }
                    else
                    {
                        return false;
                    }
                }
        }
        return true;
    }
    
    public void limparCampos()
    {
        txfDescricao.setText("");
        cbxAtivo.setSelected(true);
        txaObs.setText("");
        
        ftfAte.setText("");
        ftfDe.setText("");
        txfValor.setText("");
        txfId.setText("0");
        txfvagas.setText("");
        
        locais.clear();
        
        atualizarTabela();
        
        this.repaint();
    }
    
    public Date getAteDate()
    {
        return Date.valueOf( Util.converterData( ftfAte.getText() ) );
    }
    
    public Date getDeDate()
    {
        return Date.valueOf( Util.converterData( ftfDe.getText() ) );
    }
    
    private void iniciar(int id)
    {
        if( id != 0 )
        {
            Rota rota  = rDAO.buscar(id);

            txfDescricao.setText(rota.getDescricao());
            txaObs.setText(rota.getObs());
            txfId.setText(String.valueOf(rota.getId()));
            cbxAtivo.setSelected(rota.isAtivo());
            ftfAte.setText(Util.formatarData(String.valueOf(rota.getDtFim())));
            ftfDe.setText(Util.formatarData(String.valueOf(rota.getDtInicio())));
            txfValor.setText(String.valueOf(rota.getValor()));
            txfvagas.setText(String.valueOf(rota.getVagas()));
            
            String filtro = "ref_rota = "+id;
            locais = new Vector(rlDAO.buscar(filtro));
            
            atualizarTabela();          
        }
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
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RotaView dialog = new RotaView(new javax.swing.JFrame(), true, new Integer("") );
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
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JCheckBox cbxAtivo;
    private javax.swing.JFormattedTextField ftfAte;
    private javax.swing.JFormattedTextField ftfDe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable lstLocais;
    private javax.swing.JTextArea txaObs;
    private javax.swing.JTextField txfDescricao;
    private javax.swing.JTextField txfId;
    private javax.swing.JTextField txfValor;
    private javax.swing.JTextField txfvagas;
    // End of variables declaration//GEN-END:variables


}
