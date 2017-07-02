/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Pedido;

import controller.ControleItemPedido;
import controller.ControlePedido;
import controller.ControleProduto;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.dao.PedidoDAO;
import model.entidades.Cliente;
import model.entidades.ItemPedido;
import model.entidades.Pedido;
import model.entidades.Produto;

/**
 *
 * @author Paulo
 */
public class FormPedido extends javax.swing.JFrame {
    
    private ControleItemPedido contItem = new ControleItemPedido();
    private ControlePedido contPed = null;
    private static int numLinhas;
    private FrmTabelaClientePedido listaCliente;
    private FrmTabelaProduto listaProduto;
    private JFrame janela;
    
    public FormPedido() {
        initComponents();
        
        this.setLocationRelativeTo(null);
         
        DefaultTableModel modelo = (DefaultTableModel) jTableProdutos.getModel();
        jTableProdutos.setRowSorter(new TableRowSorter(modelo));
        modelo.setNumRows(0);
        
        DefaultTableModel modelo2 = (DefaultTableModel) jTableItens.getModel();
        jTableItens.setRowSorter(new TableRowSorter(modelo2));
        modelo2.setNumRows(0);
        
        contPed =  new ControlePedido();
        for(Cliente c : contPed.listarCliente()){
            this.jComboBoxClientes.addItem(c);
        }
        
        try{
	MaskFormatter form = new MaskFormatter("##/##/####");
	this.jFormattedTextFieldData.setFormatterFactory(new DefaultFormatterFactory(form));
        }catch(ParseException ex){
	System.err.println(ex);
        }
    }
    public void recebeJanelaPrincipal(JFrame janela){
        this.janela = janela;
    }
        public void recebeLista(String dados[]){
        String lista[] = new String[5];
        lista = dados;
        ControleProduto cp = new ControleProduto();
        //if(indice >= 0 && indice < cl.retornaTamanhoDaLista()){
            this.jTextFieldCodProduto.setText(dados[0]);
            this.jTextFielNomeProduto.setText(dados[1]);
           // this.jTextFieldValor.setText(dados[2]);

    }
    private void limpaTabelaPedidos(){
        DefaultTableModel modelo = (DefaultTableModel) jTableItens.getModel();
        jTableItens.setRowSorter(new TableRowSorter(modelo));
        modelo.setNumRows(0);
        this.jTextFieldCodPedido.setText("");
        numLinhas = 0;
    }
     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabelCodProduto = new javax.swing.JLabel();
        jTextFieldCodProduto = new javax.swing.JTextField();
        jLabelNomeProduto = new javax.swing.JLabel();
        jTextFielNomeProduto = new javax.swing.JTextField();
        jLabelQuantidade = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jLabelValor = new javax.swing.JLabel();
        jTextFieldValorProduto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProdutos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldQtd = new javax.swing.JTextField();
        jButtonAdicionar = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldBuscaProduto = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jButtonListarProdutos = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelCodCliente = new javax.swing.JLabel();
        jTextFieldCodCliente = new javax.swing.JTextField();
        jLabelNomeCliente = new javax.swing.JLabel();
        jComboBoxClientes = new javax.swing.JComboBox<>();
        jLabelData = new javax.swing.JLabel();
        jLabelCodPedido = new javax.swing.JLabel();
        jTextFieldCodPedido = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableItens = new javax.swing.JTable();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jButtonConfirmarPedido = new javax.swing.JButton();
        jButtonLimparPedido = new javax.swing.JButton();
        jButtonListarClientes = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jButtonSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, -1, 320));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, -1, -1));
        getContentPane().add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 172, -1, 10));

        jPanel1.setBackground(new java.awt.Color(201, 207, 207));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelCodProduto.setText("Código do Produto");

        jTextFieldCodProduto.setEditable(false);
        jTextFieldCodProduto.setBackground(new java.awt.Color(255, 255, 102));

        jLabelNomeProduto.setText("Descrição");

        jTextFielNomeProduto.setEditable(false);
        jTextFielNomeProduto.setBackground(new java.awt.Color(255, 255, 102));

        jLabelQuantidade.setText("Quantidade");

        jLabelValor.setText("Valor Unitáiro");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Cod_Produto", "Descrição", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableProdutos.setColumnSelectionAllowed(true);
        jTableProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProdutosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableProdutos);
        jTableProdutos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel3.setText("Quantidade");

        jTextFieldQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQtdActionPerformed(evt);
            }
        });

        jButtonAdicionar.setBackground(new java.awt.Color(153, 153, 153));
        jButtonAdicionar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar pela Descrição");

        jTextFieldBuscaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBuscaProdutoActionPerformed(evt);
            }
        });

        jButtonBuscar.setBackground(new java.awt.Color(153, 153, 153));
        jButtonBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonListarProdutos.setBackground(new java.awt.Color(129, 176, 155));
        jButtonListarProdutos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonListarProdutos.setText("Listar Produtos");
        jButtonListarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarProdutosActionPerformed(evt);
            }
        });

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("RELAÇÃO DE PRODUTOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabelCodProduto)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabelNomeProduto)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jTextFielNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextFieldQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(37, 37, 37)
                                    .addComponent(jButtonAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldBuscaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonListarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelQuantidade)
                            .addComponent(jLabelValor))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldBuscaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonBuscar))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonListarProdutos))
                        .addComponent(jSeparator9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelValor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFielNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAdicionar)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 720, 250));

        jPanel2.setBackground(new java.awt.Color(201, 207, 207));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelCodCliente.setText("Códido do Cliente");

        jTextFieldCodCliente.setEditable(false);
        jTextFieldCodCliente.setBackground(new java.awt.Color(255, 255, 102));

        jLabelNomeCliente.setText("Nome do Cliente");

        jComboBoxClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxClientesActionPerformed(evt);
            }
        });

        jLabelData.setText("Data do Pedido");

        jLabelCodPedido.setText("Número do Pedido");

        jTextFieldCodPedido.setEditable(false);
        jTextFieldCodPedido.setBackground(new java.awt.Color(255, 255, 102));

        jTableItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cod_Poduto", "Descrição", "Valor", "Quantidade"
            }
        ));
        jScrollPane4.setViewportView(jTableItens);
        if (jTableItens.getColumnModel().getColumnCount() > 0) {
            jTableItens.getColumnModel().getColumn(0).setResizable(false);
            jTableItens.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTableItens.getColumnModel().getColumn(1).setResizable(false);
            jTableItens.getColumnModel().getColumn(2).setResizable(false);
            jTableItens.getColumnModel().getColumn(3).setResizable(false);
            jTableItens.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        jButtonConfirmarPedido.setBackground(new java.awt.Color(153, 153, 153));
        jButtonConfirmarPedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonConfirmarPedido.setText("Confirmar Pedido");
        jButtonConfirmarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarPedidoActionPerformed(evt);
            }
        });

        jButtonLimparPedido.setBackground(new java.awt.Color(153, 153, 153));
        jButtonLimparPedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonLimparPedido.setText("Limpar");
        jButtonLimparPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparPedidoActionPerformed(evt);
            }
        });

        jButtonListarClientes.setBackground(new java.awt.Color(129, 176, 155));
        jButtonListarClientes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonListarClientes.setText("Listar Clientes");
        jButtonListarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarClientesActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("LISTA DE PEDIDOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButtonConfirmarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(115, 115, 115)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonLimparPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextFieldCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonListarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBoxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCodPedido)
                            .addComponent(jLabelData))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCodPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelData, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonListarClientes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCodPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCodPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonConfirmarPedido)
                    .addComponent(jButtonLimparPedido, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 720, 230));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CADASTRO DE PEDIDOS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 720, 50));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, -1, -1));
        getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 342, -1, 30));

        jButtonSair.setBackground(new java.awt.Color(153, 153, 153));
        jButtonSair.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 580, 220, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    public void selecionaItemBox(int indice){
        this.jComboBoxClientes.setSelectedIndex(indice);
    }
    
    private void jComboBoxClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxClientesActionPerformed
        Cliente cliente = (Cliente)this.jComboBoxClientes.getSelectedItem();
        this.jTextFieldCodCliente.setText(String.valueOf(cliente.getIdCliente()));
    }//GEN-LAST:event_jComboBoxClientesActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        String nome = this.jTextFieldBuscaProduto.getText();
        DefaultTableModel modelo = (DefaultTableModel) jTableProdutos.getModel();
        //Object vetor[] = new Object[5];
        
        modelo.setNumRows(0);
        for( Produto p : contPed.selecionarProduto(nome)){
            modelo.addRow(new Object[]{
                p.getIdProduto(), p.getNomeProduto(), p.getValor()
                    
            });
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jTextFieldBuscaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscaProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBuscaProdutoActionPerformed

    private void jTableProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProdutosMouseClicked
        int indice = this.jTableProdutos.getSelectedRow();
        //Cliente cliente = new Cliente();
        ControlePedido cp= new ControlePedido();
        if(indice >= 0 && indice < cp.listarProduto().size()){
            this.jTextFieldCodProduto.setText(String.valueOf(cp.listarProduto().get(indice).getIdProduto()));
            this.jTextFielNomeProduto.setText(cp.listarProduto().get(indice).getNomeProduto());
        } 
        this.jTextFieldQtd.grabFocus();
    }//GEN-LAST:event_jTableProdutosMouseClicked

    private void jTextFieldQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldQtdActionPerformed

    private void jButtonLimparPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparPedidoActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTableItens.getModel();
        jTableItens.setRowSorter(new TableRowSorter(modelo));
        modelo.setNumRows(0);
        this.jTextFieldCodPedido.setText("");
        numLinhas = 0;
    }//GEN-LAST:event_jButtonLimparPedidoActionPerformed

    private void jButtonConfirmarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarPedidoActionPerformed
        Pedido pedido = new Pedido();
        ItemPedido itemPedido = new ItemPedido();
        String campoData = this.jFormattedTextFieldData.getText().trim();
        System.out.println("TAMANHO DATA = " + campoData.length());
        if(campoData.length() < 10){
            JOptionPane.showMessageDialog(null, "O campo da data está incompleto");}
        else{
            pedido.setCodCliente(Integer.parseInt(this.jTextFieldCodCliente.getText()));
            String dataText = this.jFormattedTextFieldData.getText();
            DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date data;
            try {
            data = new java.sql.Date(fmt.parse(dataText).getTime());
            pedido.setData(data);
            //System.out.println("Imprimindo data inserida na tabela " + fmt.format(data));
            } catch (ParseException ex) {
            Logger.getLogger(FormPedido.class.getName()).log(Level.SEVERE, null, ex);
            }

            ArrayList<Produto> produtos = new ArrayList<>();
            int totalRows = jTableItens.getRowCount();

            for (int i = 0; i < totalRows; i++) {
                Produto produto = new Produto();
                produto.setIdProduto((int) jTableItens.getModel().getValueAt(i, 0));
                produto.setNomeProduto((String) jTableItens.getModel().getValueAt(i, 1));
                produto.setValor((double) jTableItens.getModel().getValueAt(i, 2));

                itemPedido.setQuantidade(Integer.parseInt((String.valueOf(jTableItens.getModel().getValueAt(i, 3)))));
                itemPedido.setPedido(pedido);
                itemPedido.adicionaProdutos(produto);
            }
            ControleItemPedido contItem = new ControleItemPedido();
            contItem.confirmarPedido(itemPedido);
            //ControlePedido contPed = new ControlePedido();
            //contPed.confirmarPedido(itemPedido);
            this.jTextFieldCodPedido.setText(String.valueOf(itemPedido.getPedido().getIdPedido()));
            this.jFormattedTextFieldData.setText("");
        }
        this.jFormattedTextFieldData.setText("");
    }//GEN-LAST:event_jButtonConfirmarPedidoActionPerformed

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        int id = Integer.parseInt(this.jTextFieldCodProduto.getText());
        Produto p;
        p = contPed.retornaProduto(id);
        //numLinhas = 0;
        DefaultTableModel modelo2 = (DefaultTableModel) jTableItens.getModel();
        modelo2.setNumRows(numLinhas);
        modelo2.addRow(new Object[]{
            p.getIdProduto(), p.getNomeProduto(), p.getValor(), this.jTextFieldQtd.getText()
        });
        numLinhas++;
        this.jTextFieldQtd.setText("");
        this.jTextFieldCodProduto.setText("");
        this.jTextFielNomeProduto.setText("");
        this.jFormattedTextFieldData.grabFocus();
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jButtonListarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarClientesActionPerformed
        listaCliente = new FrmTabelaClientePedido();
        listaCliente.setVisible(true);
        //this.setVisible(false);
        listaCliente.recebeCliente(this);
        this.dispose();
    }//GEN-LAST:event_jButtonListarClientesActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        this.dispose();
        this.janela.setVisible(true);
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonListarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarProdutosActionPerformed
        listaProduto = new FrmTabelaProduto();
        listaProduto.setVisible(true);
        //this.setVisible(false);
        listaProduto.recebeProduto(this);
        this.dispose();
    }//GEN-LAST:event_jButtonListarProdutosActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FormPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonConfirmarPedido;
    private javax.swing.JButton jButtonLimparPedido;
    private javax.swing.JButton jButtonListarClientes;
    private javax.swing.JButton jButtonListarProdutos;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox<Object> jComboBoxClientes;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelCodCliente;
    private javax.swing.JLabel jLabelCodPedido;
    private javax.swing.JLabel jLabelCodProduto;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelNomeCliente;
    private javax.swing.JLabel jLabelNomeProduto;
    private javax.swing.JLabel jLabelQuantidade;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableItens;
    private javax.swing.JTable jTableProdutos;
    private javax.swing.JTextField jTextFielNomeProduto;
    private javax.swing.JTextField jTextFieldBuscaProduto;
    private javax.swing.JTextField jTextFieldCodCliente;
    private javax.swing.JTextField jTextFieldCodPedido;
    private javax.swing.JTextField jTextFieldCodProduto;
    private javax.swing.JTextField jTextFieldQtd;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldValorProduto;
    // End of variables declaration//GEN-END:variables
}
