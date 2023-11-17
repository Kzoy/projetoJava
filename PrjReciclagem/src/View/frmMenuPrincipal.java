/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Frederico
 */
public class frmMenuPrincipal extends javax.swing.JFrame {

    private int idUsuarioLogin;
    /**
     * Creates new form frmMenuPrincipal
     */
    public frmMenuPrincipal() {
        initComponents();
    }
    public frmMenuPrincipal(int idUsuario) {
        this();
        this.idUsuarioLogin = idUsuario;
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        mnuCadastro = new javax.swing.JMenu();
        itmnuCadProdutos = new javax.swing.JMenuItem();
        itmnuCadUsuarios = new javax.swing.JMenuItem();
        mnuRegistro = new javax.swing.JMenu();
        itmnuRegMovimentacoes = new javax.swing.JMenuItem();
        mnuRegRelatorios = new javax.swing.JMenu();
        itmnuRelMovimentoDia = new javax.swing.JMenuItem();
        itmnuRelMovimentoColhedor = new javax.swing.JMenuItem();
        mnuOpcoes = new javax.swing.JMenu();
        itmnuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mnuCadastro.setText("Cadastros");

        itmnuCadProdutos.setText("Produtos");
        mnuCadastro.add(itmnuCadProdutos);

        itmnuCadUsuarios.setText("Usuarios");
        mnuCadastro.add(itmnuCadUsuarios);

        jMenuBar1.add(mnuCadastro);

        mnuRegistro.setText("Registros");

        itmnuRegMovimentacoes.setText("Movimentações");
        mnuRegistro.add(itmnuRegMovimentacoes);

        mnuRegRelatorios.setText("Relatórios");

        itmnuRelMovimentoDia.setText("Movimentos por Dia");
        mnuRegRelatorios.add(itmnuRelMovimentoDia);

        itmnuRelMovimentoColhedor.setText("Movimento por Colhedor");
        mnuRegRelatorios.add(itmnuRelMovimentoColhedor);

        mnuRegistro.add(mnuRegRelatorios);

        jMenuBar1.add(mnuRegistro);

        mnuOpcoes.setText("Opções");

        itmnuSair.setText("Sair");
        mnuOpcoes.add(itmnuSair);

        jMenuBar1.add(mnuOpcoes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 792, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itmnuCadProdutos;
    private javax.swing.JMenuItem itmnuCadUsuarios;
    private javax.swing.JMenuItem itmnuRegMovimentacoes;
    private javax.swing.JMenuItem itmnuRelMovimentoColhedor;
    private javax.swing.JMenuItem itmnuRelMovimentoDia;
    private javax.swing.JMenuItem itmnuSair;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnuCadastro;
    private javax.swing.JMenu mnuOpcoes;
    private javax.swing.JMenu mnuRegRelatorios;
    private javax.swing.JMenu mnuRegistro;
    // End of variables declaration//GEN-END:variables
}
