package org.pa.javatur.views.seek;
import java.awt.Color;
import java.awt.Component;
import java.sql.Date;
import org.pa.javatur.daos.LocalDAO;
import org.pa.javatur.daos.RotaDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import org.pa.javatur.interfaces.SeekViewInterface;
import org.pa.javatur.javatur.Util;
import org.pa.javatur.models.Rota;
import org.pa.javatur.views.PrincipalView;

public class RotaView extends javax.swing.JDialog implements SeekViewInterface<Rota>{

    RotaDAO rDAO;
    LocalDAO lDAO;
    ArrayList<Rota> rotas;
    JTextField rota;
    JTextField valor;
    JTextField total;
    JTextField codigoRota;
    PrincipalView janela;
    
    public RotaView(java.awt.Frame parent, boolean modal, JTextField rota, JTextField valor,JTextField total, PrincipalView janela) 
    {
        super(parent, modal);
        initComponents();    
        
        rDAO = new RotaDAO();
        lDAO = new LocalDAO();
        rotas = new ArrayList<>();
     
        ftfAte.setText("  /  /   ");
        ftfDe.setText("  /  /   ");
        
        this.rota = rota;
        this.valor = valor;
        this.total = total;
        
        this.janela = janela;
        atualizarTabela();
        
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }
    
    public  RotaView(java.awt.Frame parent, boolean modal, JTextField rota, JTextField codigoRota )
    {
        super(parent, modal);
        initComponents();    
        
        rDAO = new RotaDAO();
        lDAO = new LocalDAO();
        rotas = new ArrayList<>();
     
        ftfAte.setText("  /  /   ");
        ftfDe.setText("  /  /   ");
        
        this.rota = rota;
        this.codigoRota = codigoRota;
        this.janela = null;
        
        
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
        tblRotas = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();
        txfDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        ftfAte = new javax.swing.JFormattedTextField();
        ftfDe = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxEsgotadas = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("JavaTur/Rotas");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Rotas");

        btnSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/execute.png"))); // NOI18N
        btnSelecionar.setText("Selecionar");
        btnSelecionar.setEnabled(false);
        btnSelecionar.setMinimumSize(new java.awt.Dimension(80, 29));
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        tblRotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rota", "Locais", "Valor", "Vagas", "Periodo"
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
        tblRotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRotasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRotas);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/undo_green.png"))); // NOI18N
        btnSair.setText("Voltar");
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

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/calendar2.png"))); // NOI18N

        jLabel5.setText("De:");

        jLabel2.setBackground(new java.awt.Color(242, 222, 222));
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("  Vagas Esgotadas");
        jLabel2.setOpaque(true);

        jLabel8.setBackground(new java.awt.Color(166, 228, 165));
        jLabel8.setForeground(new java.awt.Color(18, 98, 40));
        jLabel8.setText("  Rota em Andamento");
        jLabel8.setOpaque(true);

        cbxEsgotadas.setText("Esgotadas");

        jLabel6.setText("Até:");

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
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(1, 1, 1)
                        .addComponent(ftfDe, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(1, 1, 1)
                        .addComponent(ftfAte, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(cbxEsgotadas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnSelecionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(557, 557, 557)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar)
                        .addComponent(ftfAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ftfDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(cbxEsgotadas)
                        .addComponent(jLabel6)))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

    private void tblRotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRotasMouseClicked
        if( evt.getClickCount() > 1)
        {
            selecionar();
        }
        else
        {
            btnSelecionar.setEnabled(true);
        }
    }//GEN-LAST:event_tblRotasMouseClicked

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        selecionar();
    }//GEN-LAST:event_btnSelecionarActionPerformed

    public ArrayList<Rota> buscar(String filtro) 
    {
        ArrayList<Rota> rotas = new ArrayList<>();
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
    
    public void selecionar() 
    {
        Rota rota = (Rota) tblRotas.getValueAt(tblRotas.getSelectedRow(),0);
        if( !tblRotas.getValueAt(tblRotas.getSelectedRow(),3 ).toString().equalsIgnoreCase("0") || this.janela == null )
        {
            this.rota.setText(rota.getDescricao());
                
            if( this.janela != null ) // Frame Principal
            {
                this.valor.setText(String.valueOf(rota.getValor()));
                this.total.setText(String.valueOf(rota.getValor()));
                this.janela.valorRota = rota.getValor();
                this.janela.codigoRota = rota.getId();
                this.janela.atualizarTabela();
            }
            else
            {
                this.codigoRota.setText(String.valueOf(rota.getId()));
            }
            this.setVisible(false);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Você não pode selecionar uma rota sem vagas", "Erro!", 2);
        }
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
                int vagas = rDAO.getVagasRestantes(rota);
                tblRotas.setValueAt(rota, cont, 0);
                tblRotas.setValueAt(locais   , cont, 1);
                tblRotas.setValueAt(rota.getValor(), cont, 2);
                tblRotas.setValueAt(vagas, cont, 3);
                tblRotas.setValueAt(periodo, cont, 4);
                
                Component x = tblRotas.prepareRenderer(tblRotas.getCellRenderer(cont, 0),cont,0);
                
                cont++;
            }
        }
    }
  
    public void redimencionarTabela( int tamanho )
    {
        tblRotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [tamanho][5] ,
            new String [] {
                "Rota", "Locais", "Valor", "Vagas", "Período"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
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

        jScrollPane1.setViewportView(tblRotas);
        tblRotas.getColumnModel().getColumn(3).setMaxWidth(50);
        tblRotas.getColumnModel().getColumn(2).setMaxWidth(50);
        tblRotas.setSelectionMode(0);
        
        tblRotas.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                if (String.valueOf(table.getValueAt(row, 3)).equalsIgnoreCase("0")) {
                    setBackground(new Color(242,222,222));
                    setForeground(new Color(255, 0, 0));
                } else {
                    setBackground(new Color(166,228,165));
                    setForeground(new Color(18,98,40));
                }

                return this;
            }
        });
    }
    
    public String obterFiltros()
    {
        String filtro = " ativo ";
        
        if( !txfDescricao.getText().trim().equals("") )
        {
            filtro += " AND descricao ilike '%"+txfDescricao.getText()+"%'";
        }
        else
        {
            filtro += " AND ativo";
        }
        if( !ftfAte.getText().trim().equals("/  /") && !ftfDe.getText().trim().equals("/  /") )
        {
            if( !ftfAte.getText().trim().equals("/  /") )
            {
                filtro += " AND dt_fim <= '"+Util.converterData(ftfAte.getText())+"'";
            }
            if( !ftfDe.getText().trim().equals("/  /"))
            {
                filtro += " AND dt_inicio >= '"+Util.converterData(ftfDe.getText())+"'";
            }
        }
        else
        {
            Date data = new Date(System.currentTimeMillis());
//            filtro += " AND dt_inicio BETWEEN '" + data.toString() + "' AND '"+ Util.somarMesData(data).toString()+"'"; 
        }
        if( !cbxEsgotadas.isSelected() )
        {
            filtro += " AND rotas.vagas > ( select count(x.id) from rotas_turistas x where x.ref_rota = rotas.id and status <> 'C' ) ";
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
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RotaView dialog = new RotaView(new javax.swing.JFrame(), true, new JTextField(),new JTextField(), new JTextField(), new PrincipalView());
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
    private javax.swing.JCheckBox cbxEsgotadas;
    private javax.swing.JFormattedTextField ftfAte;
    private javax.swing.JFormattedTextField ftfDe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRotas;
    private javax.swing.JTextField txfDescricao;
    // End of variables declaration//GEN-END:variables
}
