
package view.Pedido;

import view.produto.*;
import view.Cliente.*;
import controller.ControleCliente;
import controller.ControleProduto;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.entidades.Cliente;
import model.entidades.Produto;

/**
 *
 * @author Paulo
 */
public class FrmTabelaProduto extends javax.swing.JFrame {

    private ControleProduto contProd = new ControleProduto();
    private FormPedido fp;
    
    public FrmTabelaProduto() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTableProduto.getModel();
        jTableProduto.setRowSorter(new TableRowSorter(modelo));
        lerTabela();
    }
        public void recebeProduto(FormPedido p){
            this.fp = p;
        }
    
        public void lerTabela(){
        DefaultTableModel modelo = (DefaultTableModel) jTableProduto.getModel();
        Object vetor[] = new Object[5];
        
        modelo.setNumRows(0);
        for( Produto p : contProd.listarProduto()){
            modelo.addRow(new Object[]{
                p.getIdProduto(), p.getNomeProduto(), p.getValor()
                    
            });
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProduto = new javax.swing.JTable();
        jButtonRetornar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id_Produto", "Descrição", "Valor"
            }
        ));
        jTableProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProduto);
        if (jTableProduto.getColumnModel().getColumnCount() > 0) {
            jTableProduto.getColumnModel().getColumn(0).setPreferredWidth(70);
            jTableProduto.getColumnModel().getColumn(1).setPreferredWidth(280);
            jTableProduto.getColumnModel().getColumn(2).setPreferredWidth(80);
        }

        jButtonRetornar.setText("Retornar");
        jButtonRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRetornarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonRetornar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRetornar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProdutoMouseClicked
        int indice = this.jTableProduto.getSelectedRow();
        //System.out.println("ìndice da lista = " + indice);
        String dados[] = new String[5];
        ControleProduto cp = new ControleProduto();
        if(indice >= 0 && indice < cp.listarProduto().size()){
            dados[0] = String.valueOf(cp.listarProduto().get(indice).getIdProduto());
            dados[1] = cp.listarProduto().get(indice).getNomeProduto();
            dados[2] = String.valueOf(cp.listarProduto().get(indice).getValor());
        }
        fp.recebeLista(dados);
        fp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTableProdutoMouseClicked

    private void jButtonRetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRetornarActionPerformed
        fp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonRetornarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmTabelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTabelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTabelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTabelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTabelaProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRetornar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProduto;
    // End of variables declaration//GEN-END:variables
}