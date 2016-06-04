/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pa.javatur.views;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Properties;
import org.pa.javatur.views.lists.PessoaFisicaView;
import org.pa.javatur.views.formlist.TipoLocalView;
import org.pa.javatur.views.formlist.AtividadeView;
import org.pa.javatur.views.formlist.UsuarioView;
import org.pa.javatur.views.lists.LocalView;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.pa.javatur.daos.AtividadeDAO;
import org.pa.javatur.daos.AtividadeLocalDAO;
import org.pa.javatur.daos.AtividadeRotaTuristaDAO;
import org.pa.javatur.daos.FormaPagamentoDAO;
import org.pa.javatur.daos.LocalDAO;
import org.pa.javatur.daos.LocalRotaDAO;
import org.pa.javatur.daos.ParcelaDAO;
import org.pa.javatur.daos.ParcelaRotaDAO;
import org.pa.javatur.daos.RotaTuristaDAO;
import org.pa.javatur.interfaces.FormViewInterface;
import org.pa.javatur.javatur.Util;
import org.pa.javatur.models.Atividade;
import org.pa.javatur.models.AtividadeLocal;
import org.pa.javatur.models.AtividadeRotaTurista;
import org.pa.javatur.models.ConexaoBD;
import org.pa.javatur.models.FormaPagamento;
import org.pa.javatur.models.Local;
import org.pa.javatur.models.LocalRota;
import org.pa.javatur.models.Parcela;
import org.pa.javatur.models.ParcelaRota;
import org.pa.javatur.models.RotaTurista;
import org.pa.javatur.models.Usuario;
import org.pa.javatur.views.formlist.FormaPagamentoView;
import org.pa.javatur.views.forms.ParcelasView;
import org.pa.javatur.views.forms.Vendas;
import org.pa.javatur.views.lists.ParcelaView;
import org.pa.javatur.views.lists.RotaTuristaView;
import org.pa.javatur.views.lists.RotaView;

/**
 *
 * @author lucas
 */
public class PrincipalView extends javax.swing.JFrame implements FormViewInterface<RotaTurista>{

    public int codigoRota;
    public double valorRota;
    
    LocalDAO          lDAO;
    AtividadeLocalDAO atlDAO;
    LocalRotaDAO      lrDAO;
    AtividadeDAO      atDAO;
    FormaPagamentoDAO fpDAO;
    RotaTuristaDAO    rtDAO;
    AtividadeRotaTuristaDAO artDAO;
    ParcelaDAO              pDAO;
    ParcelaRotaDAO          prDAO;
    
    public PrincipalView() {
        initComponents();
        
        URL url = this.getClass().getResource(Util.getLogo());  
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);  
        super.setIconImage(iconeTitulo);
        
        lDAO   = new LocalDAO();
        atDAO  = new AtividadeDAO();
        lrDAO  = new LocalRotaDAO();
        atlDAO = new AtividadeLocalDAO();
        fpDAO  = new FormaPagamentoDAO();
        rtDAO  = new RotaTuristaDAO();
        artDAO = new AtividadeRotaTuristaDAO();
        pDAO   = new ParcelaDAO();
        prDAO  = new ParcelaRotaDAO();
        
        lblUser.setText("Olá, "+Usuario.getUsuarioLogado().getNome());
        
        
        preencherComboFormaPagamento();
                
        txfData.setText( Util.formatarData( new Date(System.currentTimeMillis()).toString() ) );        

        txfId.setVisible(false);
        codigoPessoa.setVisible(false);

        txfTotal.setText("0.00");
        txfValorParcelas.setText("0.00");
        valorRota = 0.00;
        super.setExtendedState(JFrame.MAXIMIZED_BOTH);
        super.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu4 = new javax.swing.JMenu();
        lblJavaTur = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbFormaDePagamento = new javax.swing.JComboBox<>();
        txfTurrista = new javax.swing.JTextField();
        btnSeekTurista = new javax.swing.JToggleButton();
        txfRota = new javax.swing.JTextField();
        btnSeekRota = new javax.swing.JToggleButton();
        txfData = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txfParcela = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAtividades = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txfValorParcelas = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txfTotal = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txfId = new javax.swing.JTextField();
        codigoPessoa = new javax.swing.JTextField();
        lblUser = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        minPessoaFisica = new javax.swing.JMenu();
        mitTiposLocais = new javax.swing.JMenuItem();
        mitLocais = new javax.swing.JMenuItem();
        mitAtividades = new javax.swing.JMenuItem();
        mitPessoasFisicas = new javax.swing.JMenuItem();
        mitRotas = new javax.swing.JMenuItem();
        mitFormaPagamento = new javax.swing.JMenuItem();
        menuRelatorio = new javax.swing.JMenu();
        mitParcelas = new javax.swing.JMenuItem();
        mitRotasRelatorio = new javax.swing.JMenuItem();
        mitAtividadeRelatorio = new javax.swing.JMenuItem();
        mitVendasRelatorio = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        mitRegistrarPagamento = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuSistema = new javax.swing.JMenu();
        mitUsuarios = new javax.swing.JMenuItem();
        MenuSair = new javax.swing.JMenuItem();
        gerarBkp = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("File");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JavaTur");

        lblJavaTur.setFont(new java.awt.Font("Ubuntu", 3, 24)); // NOI18N
        lblJavaTur.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblJavaTur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/logo24.png"))); // NOI18N
        lblJavaTur.setText("    JavaTur - Sistemas de Turismo");

        jLabel1.setText("Turista:");

        jLabel2.setText("Data:");

        jLabel3.setText("Rota:");

        jLabel4.setText("Forma de pagamento:");

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

        txfRota.setEditable(false);
        txfRota.setBackground(new java.awt.Color(220, 218, 216));
        txfRota.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        txfRota.setForeground(new java.awt.Color(1, 1, 1));
        txfRota.setEnabled(false);
        txfRota.setMinimumSize(new java.awt.Dimension(10, 28));
        txfRota.setOpaque(false);
        txfRota.setPreferredSize(new java.awt.Dimension(10, 28));

        btnSeekRota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/lupa.png"))); // NOI18N
        btnSeekRota.setToolTipText("");
        btnSeekRota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeekRotaActionPerformed(evt);
            }
        });

        txfData.setEditable(false);
        txfData.setBackground(new java.awt.Color(220, 218, 216));
        txfData.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        txfData.setForeground(new java.awt.Color(1, 1, 1));
        txfData.setEnabled(false);
        txfData.setMinimumSize(new java.awt.Dimension(10, 28));
        txfData.setOpaque(false);
        txfData.setPreferredSize(new java.awt.Dimension(10, 28));

        jLabel5.setText("Parcelas:");

        txfParcela.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        txfParcela.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfParcela.setText("1");
        txfParcela.setPreferredSize(new java.awt.Dimension(10, 28));
        txfParcela.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txfParcelaFocusLost(evt);
            }
        });
        txfParcela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfParcelaKeyTyped(evt);
            }
        });

        tblAtividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Local", "Atividade", "Dia", "Hora Inicio", "Hora Fim", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tblAtividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAtividadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAtividades);
        if (tblAtividades.getColumnModel().getColumnCount() > 0) {
            tblAtividades.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        jLabel6.setText("Valor da Parcela:");

        txfValorParcelas.setEditable(false);
        txfValorParcelas.setBackground(new java.awt.Color(220, 218, 216));
        txfValorParcelas.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        txfValorParcelas.setForeground(new java.awt.Color(1, 1, 1));
        txfValorParcelas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfValorParcelas.setToolTipText("");
        txfValorParcelas.setAutoscrolls(false);
        txfValorParcelas.setEnabled(false);
        txfValorParcelas.setMinimumSize(new java.awt.Dimension(10, 28));
        txfValorParcelas.setOpaque(false);
        txfValorParcelas.setPreferredSize(new java.awt.Dimension(10, 28));

        jLabel7.setText("Total:");

        txfTotal.setEditable(false);
        txfTotal.setBackground(new java.awt.Color(220, 218, 216));
        txfTotal.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        txfTotal.setForeground(new java.awt.Color(1, 1, 1));
        txfTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfTotal.setEnabled(false);
        txfTotal.setMinimumSize(new java.awt.Dimension(10, 28));
        txfTotal.setOpaque(false);
        txfTotal.setPreferredSize(new java.awt.Dimension(10, 28));

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/save.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/pa/javatur/images/close_window.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("*");

        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*");

        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("*");

        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("*");

        txfId.setText("0");

        codigoPessoa.setText("0");

        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUser.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        minPessoaFisica.setText("Módulos");

        mitTiposLocais.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        mitTiposLocais.setText("Tipos de Locais");
        mitTiposLocais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitTiposLocaisActionPerformed(evt);
            }
        });
        minPessoaFisica.add(mitTiposLocais);

        mitLocais.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK));
        mitLocais.setText("Locais");
        mitLocais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitLocaisActionPerformed(evt);
            }
        });
        minPessoaFisica.add(mitLocais);

        mitAtividades.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        mitAtividades.setText("Atividades");
        mitAtividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitAtividadesActionPerformed(evt);
            }
        });
        minPessoaFisica.add(mitAtividades);

        mitPessoasFisicas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        mitPessoasFisicas.setText("Pessoas Fisicas");
        mitPessoasFisicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitPessoasFisicasActionPerformed(evt);
            }
        });
        minPessoaFisica.add(mitPessoasFisicas);

        mitRotas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        mitRotas.setText("Rotas");
        mitRotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitRotasActionPerformed(evt);
            }
        });
        minPessoaFisica.add(mitRotas);

        mitFormaPagamento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
        mitFormaPagamento.setText("Formas de Pagamentos");
        mitFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitFormaPagamentoActionPerformed(evt);
            }
        });
        minPessoaFisica.add(mitFormaPagamento);

        MenuBar.add(minPessoaFisica);

        menuRelatorio.setText("Relatórios");

        mitParcelas.setText("Parcelas");
        mitParcelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitParcelasActionPerformed(evt);
            }
        });
        menuRelatorio.add(mitParcelas);

        mitRotasRelatorio.setText("Rotas Em Andamento");
        mitRotasRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitRotasRelatorioActionPerformed(evt);
            }
        });
        menuRelatorio.add(mitRotasRelatorio);

        mitAtividadeRelatorio.setText("Atividades");
        mitAtividadeRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitAtividadeRelatorioActionPerformed(evt);
            }
        });
        menuRelatorio.add(mitAtividadeRelatorio);

        mitVendasRelatorio.setText("Vendas");
        mitVendasRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitVendasRelatorioActionPerformed(evt);
            }
        });
        menuRelatorio.add(mitVendasRelatorio);

        MenuBar.add(menuRelatorio);

        jMenu6.setText("Serviços");

        mitRegistrarPagamento.setText("Registrar Pagamentos");
        mitRegistrarPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitRegistrarPagamentoActionPerformed(evt);
            }
        });
        jMenu6.add(mitRegistrarPagamento);

        jMenuItem2.setText("Status das vendas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem2);

        MenuBar.add(jMenu6);

        menuSistema.setText("Sistema");

        mitUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        mitUsuarios.setText("Usuários");
        mitUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitUsuariosActionPerformed(evt);
            }
        });
        menuSistema.add(mitUsuarios);

        MenuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        MenuSair.setText("Sair");
        MenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSairActionPerformed(evt);
            }
        });
        menuSistema.add(MenuSair);

        gerarBkp.setText("GerarBackup");
        gerarBkp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerarBkpActionPerformed(evt);
            }
        });
        menuSistema.add(gerarBkp);

        MenuBar.add(menuSistema);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel8))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4)
                                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(5, 5, 5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel9)))
                                .addGap(5, 5, 5)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txfRota, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSeekRota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txfData, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbFormaDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txfTurrista, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSeekTurista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(txfParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(codigoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txfValorParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txfTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(49, 49, 49)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE))
                            .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblJavaTur, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJavaTur, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel8))
                            .addComponent(txfTurrista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSeekTurista))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txfRota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSeekRota)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbFormaDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txfParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codigoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txfValorParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnSair))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mitTiposLocaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitTiposLocaisActionPerformed
        new TipoLocalView(this, true);
    }//GEN-LAST:event_mitTiposLocaisActionPerformed

    private void MenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_MenuSairActionPerformed

    private void mitAtividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitAtividadesActionPerformed
        new AtividadeView(this, true);
    }//GEN-LAST:event_mitAtividadesActionPerformed

    private void mitUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitUsuariosActionPerformed
        new UsuarioView(this, true);
    }//GEN-LAST:event_mitUsuariosActionPerformed

    private void mitLocaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitLocaisActionPerformed
        new LocalView(this, true);
    }//GEN-LAST:event_mitLocaisActionPerformed

    private void mitPessoasFisicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitPessoasFisicasActionPerformed
        new PessoaFisicaView(this, true);
    }//GEN-LAST:event_mitPessoasFisicasActionPerformed

    private void mitRotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitRotasActionPerformed
        new RotaView(this, true);
    }//GEN-LAST:event_mitRotasActionPerformed

    private void mitFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitFormaPagamentoActionPerformed
        new FormaPagamentoView(this,true);
    }//GEN-LAST:event_mitFormaPagamentoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        RotaTurista rota = new RotaTurista();
        rota.setTotalParcelas(Integer.parseInt(txfParcela.getText()));
        rota.setId(Integer.parseInt(txfId.getText()));
        rota.setDtInscricao( new Date(System.currentTimeMillis()) );
        rota.setRefRota(codigoRota);
        rota.setRefTurista(Integer.parseInt(codigoPessoa.getText()));
        rota.setStatus(RotaTurista.MARCADA);
        rota.setStatusPagamento(RotaTurista.ABERTO);
        rota.setTotalParcelas(Integer.parseInt(txfParcela.getText()));
        rota.setValorRota(valorRota);
        rota.setValorTotal(Double.parseDouble(txfTotal.getText()));
        int ref = ( (FormaPagamento) cmbFormaDePagamento.getSelectedItem() ).getId();
        rota.setRefFormaPagameto(ref);
        
        salvar( rota );
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSeekTuristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeekTuristaActionPerformed
        new org.pa.javatur.views.seek.PessoaFisicaView(this, true, txfTurrista,codigoPessoa);
    }//GEN-LAST:event_btnSeekTuristaActionPerformed

    private void btnSeekRotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeekRotaActionPerformed
        new org.pa.javatur.views.seek.RotaView(this, true, txfRota,txfTotal,txfValorParcelas,this);
    }//GEN-LAST:event_btnSeekRotaActionPerformed

    private void tblAtividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAtividadesMouseClicked
        atualizarValorTotal();
        atualizarValorParcelas();
    }//GEN-LAST:event_tblAtividadesMouseClicked

    private void txfParcelaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfParcelaFocusLost
        atualizarValorParcelas();
    }//GEN-LAST:event_txfParcelaFocusLost

    private void txfParcelaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfParcelaKeyTyped
        if(!Util.isNumero(evt.getKeyChar()))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txfParcelaKeyTyped

    private void mitRegistrarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitRegistrarPagamentoActionPerformed
        new ParcelaView(this, true);
    }//GEN-LAST:event_mitRegistrarPagamentoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new RotaTuristaView(this, true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mitParcelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitParcelasActionPerformed
       new ParcelasView(this, true);
    }//GEN-LAST:event_mitParcelasActionPerformed

    private void mitRotasRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitRotasRelatorioActionPerformed
        new org.pa.javatur.reports.Rotas();
    }//GEN-LAST:event_mitRotasRelatorioActionPerformed

    private void mitAtividadeRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitAtividadeRelatorioActionPerformed
        new org.pa.javatur.reports.Atividades();
    }//GEN-LAST:event_mitAtividadeRelatorioActionPerformed

    private void mitVendasRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitVendasRelatorioActionPerformed
        new Vendas(this, true);
    }//GEN-LAST:event_mitVendasRelatorioActionPerformed

    private void gerarBkpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerarBkpActionPerformed
        try 
        {
            ProcessBuilder pb;

            Process p;
            
            HashMap configs = Util.getDadosConexao();
            
            SimpleDateFormat df = new SimpleDateFormat("ddMMyyyyHHmm");
            Date d = new Date( System.currentTimeMillis() );
            
            String nome = "bkps/dump" + df.format(d) + ".sql"; 
            
            pb = new ProcessBuilder( "pg_dump", "-U", configs.get("user").toString() ,"-h" , configs.get("host").toString() , configs.get("name").toString() , "-f", nome  );

            pb.environment().put("PGPASSWORD", configs.get("senha").toString() );

            pb.redirectErrorStream(true);

            p = pb.start();
            
            JOptionPane.showMessageDialog(this, "Backup gerado com sucesso " + "JavaTur/" + nome , "sucesso",JOptionPane.INFORMATION_MESSAGE );
        } 
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro ao executar backup: " + ex);
        }
    }//GEN-LAST:event_gerarBkpActionPerformed
    
    public boolean verificarCampos()
    {
        if( txfTurrista.getText().equalsIgnoreCase(""))
        {
            return false;
        }
        if( txfRota.getText().equalsIgnoreCase(""))
        {
            return false;
        }
        if( cmbFormaDePagamento.getSelectedIndex() == 0)
        {
            return false;
        }
        return true;
    }
    
    public void limparCampos()
    {
        txfTurrista.setText("");
        codigoPessoa.setText("");
        txfRota.setText("");
        codigoRota = 0;
        txfId.setText("0");
        txfParcela.setText("1");
        txfTotal.setText("");
        txfValorParcelas.setText("");
        valorRota = 0.0;
        cmbFormaDePagamento.setSelectedIndex(0);
        redimensionarTabela(0);
    }
    
    public boolean salvar( RotaTurista rota )
    {
        if( verificarCampos() )
        {
            try
            {
                if( rtDAO.salvar(rota) )
                {
                    int id = ( rota.getId() == 0 )? rtDAO.lastID() : rota.getId();

                    for (int i = 0; i < tblAtividades.getRowCount(); i++) 
                    {
                        if( (boolean)tblAtividades.getValueAt(i, 0))
                        {
                            AtividadeRotaTurista art = new AtividadeRotaTurista();

                            art.setRefAtividade( ( (Atividade)tblAtividades.getValueAt(i, 2)).getId() );
                            art.setRefRotaTurista(id );
                            art.setValor( Double.valueOf(String.valueOf(tblAtividades.getValueAt(i, 6)) ) );
         
                            artDAO.salvar(art);
                        }
                    }
                    Date dataParcela = Util.somarMesData(Date.valueOf(rota.getDtInscricao().toString()));
                    double valor     = Double.parseDouble(Util.formatarValor( ( rota.getValorTotal() / rota.getTotalParcelas() ) ) );
                    for (int i = 1; i <= rota.getTotalParcelas(); i++) 
                    {
                        Parcela parcela = new Parcela();
                        
                        parcela.setDtVencimento(dataParcela);
                        parcela.setParcela(i);
                        parcela.setStatusPagamento(Parcela.STATUS_ABERTA);
                        parcela.setValorEstimado(valor);
                        
                        pDAO.salvar(parcela);
                        
                        int idParcela = pDAO.lastID();
                        
                        ParcelaRota parcelaRota = new ParcelaRota();
                        
                        parcelaRota.setRefParcela(idParcela);
                        parcelaRota.setRefRota(id);
                        
                        prDAO.salvar(parcelaRota);
                        
                        dataParcela = Util.somarMesData( dataParcela );
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
            catch(Exception e)
            {
                System.err.println(e);
                JOptionPane.showMessageDialog(this, "Erro ao salvar!", "erro", 0);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Preencha os campos obrigatórios (*)", "atenção", 2);
            return false;
        }
        return true;
    }
    
    private void atualizarValorTotal()
    {
        double tt = valorRota;
        for (int i = 0; i < tblAtividades.getRowCount(); i++) 
        {
            if( (boolean) tblAtividades.getValueAt(i, 0) )
            {
                tt = tt + Double.valueOf(String.valueOf(tblAtividades.getValueAt(i, 6)));
            }
        }
        txfTotal.setText(Util.formatarValor(tt));
    }
    
    private void atualizarValorParcelas()
    {
        if( !txfParcela.getText().trim().equalsIgnoreCase("") )
        {
            double tt = Double.valueOf(txfTotal.getText());
            int parcelas = Integer.parseInt(txfParcela.getText());

            double valor =  tt / parcelas;

            txfValorParcelas.setText(Util.formatarValor(valor));
        }
    }
    
    public void atualizarTabela()
    {
        String filtro = " ref_rota = " + codigoRota;
        txfRota.getText();
        ArrayList<LocalRota> locais = lrDAO.buscar( filtro );
        ArrayList<Lista> values = new ArrayList<>();
        if( locais != null )
        {
            for( int i =  0; i < locais.size(); i ++ )
            {
                Local local = lDAO.buscar(locais.get(i).getRefLocal());
                
                ArrayList<AtividadeLocal> atividades = atlDAO.buscarAtividadesLocal(locais.get(i).getRefLocal() );
                
                if( atividades != null )
                {
                    for( int l =  0; l < atividades.size(); l ++ )
                    {
                        Atividade atividade = atDAO.buscar(atividades.get(l).getAtividade());
                        Lista lista = new Lista();
                        lista.setAttr("Local"    , local.getDescricao() );
                        lista.setAttr("Atividade", atividade );
                        lista.setAttr("Dia"      , Util.formatarData(locais.get(i).getDtRota().toString()));
                        lista.setAttr("Hora Ini" , atividades.get(l).getHrIni().toString() );
                        lista.setAttr("Hora Fim" , atividades.get(l).getHrFim().toString() );
                        lista.setAttr("Valor"    , Util.formatarValor(atividades.get(l).getValor()));
                        
                        values.add(lista);
                    }
                }
            }
        }
        
        if( values != null )
        {
            redimensionarTabela(values.size()); 
            
            for( int i = 0; i < values.size(); i++)
            {
                tblAtividades.setValueAt(false                              , i,0);
                tblAtividades.setValueAt(values.get(i).getAttr("Local")     , i,1);
                tblAtividades.setValueAt(values.get(i).getAttr("Atividade") , i,2);
                tblAtividades.setValueAt(values.get(i).getAttr("Dia")       , i,3);
                tblAtividades.setValueAt(values.get(i).getAttr("Hora Ini")  , i,4);
                tblAtividades.setValueAt(values.get(i).getAttr("Hora Fim")  , i,5);
                tblAtividades.setValueAt(values.get(i).getAttr("Valor")     , i,6);
            }
        }        
    }
    
    private void redimensionarTabela( int tamanho )
    {
        tblAtividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [tamanho][7],
            new String [] {
                "", "Local", "Atividade", "Dia", "Hora Inicio", "Hora Fim", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAtividades);
        tblAtividades.getColumnModel().getColumn(0).setMaxWidth(30);
    }
    
    private void preencherComboFormaPagamento()
    {
         ArrayList<FormaPagamento> formas = fpDAO.buscar( " ativo " );
         FormaPagamento forma = new FormaPagamento();
         forma.setDescricao("::Selecionar::");
         cmbFormaDePagamento.addItem(forma);
         
         if( formas != null)
         {
            for (int i = 0; i < formas.size(); i++) 
            {
                cmbFormaDePagamento.addItem(formas.get(i));
            }
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
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem MenuSair;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JToggleButton btnSeekRota;
    private javax.swing.JToggleButton btnSeekTurista;
    private javax.swing.JComboBox<FormaPagamento> cmbFormaDePagamento;
    private javax.swing.JTextField codigoPessoa;
    private javax.swing.JMenuItem gerarBkp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblJavaTur;
    private javax.swing.JLabel lblUser;
    private javax.swing.JMenu menuRelatorio;
    private javax.swing.JMenu menuSistema;
    private javax.swing.JMenu minPessoaFisica;
    private javax.swing.JMenuItem mitAtividadeRelatorio;
    private javax.swing.JMenuItem mitAtividades;
    private javax.swing.JMenuItem mitFormaPagamento;
    private javax.swing.JMenuItem mitLocais;
    private javax.swing.JMenuItem mitParcelas;
    private javax.swing.JMenuItem mitPessoasFisicas;
    private javax.swing.JMenuItem mitRegistrarPagamento;
    private javax.swing.JMenuItem mitRotas;
    private javax.swing.JMenuItem mitRotasRelatorio;
    private javax.swing.JMenuItem mitTiposLocais;
    private javax.swing.JMenuItem mitUsuarios;
    private javax.swing.JMenuItem mitVendasRelatorio;
    private javax.swing.JTable tblAtividades;
    private javax.swing.JTextField txfData;
    private javax.swing.JTextField txfId;
    private javax.swing.JTextField txfParcela;
    private javax.swing.JTextField txfRota;
    private javax.swing.JTextField txfTotal;
    private javax.swing.JTextField txfTurrista;
    private javax.swing.JTextField txfValorParcelas;
    // End of variables declaration//GEN-END:variables
    
    private class Lista
    {
        HashMap<String,Object> lista;
        
        public Lista()
        {
            lista = new HashMap();
        }
        
        public void setAttr( String chave, Object valor)
        {
            lista.put(chave, valor);
        }
    
        public Object getAttr( String chave)
        {
            return lista.get(chave); 
        }
    }
}