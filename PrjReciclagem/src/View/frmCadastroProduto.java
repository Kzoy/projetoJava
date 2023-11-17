/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author HP
 */
public class frmCadastroProduto extends javax.swing.JFrame {
    
    private JTextField txtIdProduto;
    private JTextField txtNome;
    private JTextField txtUnidade;
    private JTextField txtPreco;
    private JTextField txtDescricao;
    private JButton btnCadastrar;
    private JButton btnFiltrar;
    
    private ProdutoController produtoController;
    private DefaultListModel<String> listaProdutosModel;
    private JList<String> listaProdutos;

    /**
     * Creates new form frmCadastroProduto
     */
    public frmCadastroProduto() {
        //Configuração básica da janela
        setTitle("Cadastro de Produto");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Inicialização do controlador e do modelo da lista
        produtoController = new ProdutoController();
        listaProdutosModel = new DefaultListModel<>();

        // Criando os componentes
        JLabel lblIdProduto = new JLabel("ID do Produto:");
        JLabel lblNome = new JLabel("Nome:");
        JLabel lblUnidade = new JLabel("Unidade:");
        JLabel lblPreco = new JLabel("Preço:");
        JLabel lblDescricao = new JLabel("Descrição:");

        txtIdProduto = new JTextField(10);
        txtNome = new JTextField(20);
        txtUnidade = new JTextField(10);
        txtPreco = new JTextField(10);
        txtDescricao = new JTextField(20);

        btnCadastrar = new JButton("Cadastrar");
        btnFiltrar = new JButton("Filtrar");

        // Adicionando os ouvintes de eventos aos botões
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarProduto();
            }
        });

        btnFiltrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarProdutos();
            }
        });

        // Configurando a lista de produtos
        listaProdutos = new JList<>(listaProdutosModel);
        JScrollPane scrollPane = new JScrollPane(listaProdutos);

        // Configurando o layout
        setLayout(new BorderLayout());

        JPanel formularioPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        formularioPanel.add(lblIdProduto);
        formularioPanel.add(txtIdProduto);
        formularioPanel.add(lblNome);
        formularioPanel.add(txtNome);
        formularioPanel.add(lblUnidade);
        formularioPanel.add(txtUnidade);
        formularioPanel.add(lblPreco);
        formularioPanel.add(txtPreco);
        formularioPanel.add(lblDescricao);
        formularioPanel.add(txtDescricao);
        formularioPanel.add(btnCadastrar);
        formularioPanel.add(btnFiltrar);

        add(formularioPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Exibindo a janela
        setVisible(true);
    }
    
    private void cadastrarProduto() {
        String idProdutoStr = txtIdProduto.getText();
        String nome = txtNome.getText();
        String unidade = txtUnidade.getText();
        String precoStr = txtPreco.getText();
        String descricao = txtDescricao.getText();

        if (idProdutoStr.isEmpty() || nome.isEmpty() || unidade.isEmpty() || precoStr.isEmpty() || descricao.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int idProduto = Integer.parseInt(idProdutoStr);
            double preco = Double.parseDouble(precoStr);

            // Criando o produto
            Produto produto = new Produto(idProduto, nome, unidade, preco, descricao);

            // Adicionando o produto através do controlador
            produtoController.adicionarProduto(produto);

            // Adicionando o produto à lista de produtos na UI
            listaProdutosModel.addElement("ID: " + produto.getIdProduto() +
                    " | Nome: " + produto.getNome() +
                    " | Unidade: " + produto.getUnidade() +
                    " | Preço: " + produto.getPreco() +
                    " | Descrição: " + produto.getDescricao());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite valores numéricos válidos para ID e preço!", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        // Limpar os campos após o cadastro
        txtIdProduto.setText("");
        txtNome.setText("");
        txtUnidade.setText("");
        txtPreco.setText("");
        txtDescricao.setText("");
    }

    private void filtrarProdutos() {
        // Criar um array com as opções de filtro
        String[] opcoesFiltro = {"ID", "Nome", "Descrição", "Preço"};
        // Mostrar a caixa de diálogo para escolher o filtro
        String filtroSelecionado = (String) JOptionPane.showInputDialog(this,
                "Escolha o campo para filtrar:",
                "Filtrar Produtos",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoesFiltro,
                opcoesFiltro[0]);

        if (filtroSelecionado == null) {
            return; // Cancelou a operação
        }

        // Obter o valor para o filtro
        String valorFiltro = JOptionPane.showInputDialog(this, "Digite o valor para o filtro:");

        if (valorFiltro == null || valorFiltro.isEmpty()) {
            return; // Cancelou ou não forneceu um valor
        }

        try {
            // Filtrar produtos com base no critério escolhido
            List<Produto> produtosFiltrados;
            switch (filtroSelecionado) {
                case "ID":
                    int idFiltro = Integer.parseInt(valorFiltro);
                    produtosFiltrados = produtoController.getProdutos().stream()
                            .filter(produto -> produto.getIdProduto() == idFiltro)
                            .collect(Collectors.toList());
                    break;
                case "Nome":
                    produtosFiltrados = produtoController.getProdutos().stream()
                            .filter(produto -> produto.getNome().toLowerCase().contains(valorFiltro.toLowerCase()))
                            .collect(Collectors.toList());
                    break;
                case "Descrição":
                    produtosFiltrados = produtoController.getProdutos().stream()
                            .filter(produto -> produto.getDescricao().toLowerCase().contains(valorFiltro.toLowerCase()))
                            .collect(Collectors.toList());
                    break;
                case "Preço":
                    double precoFiltro = Double.parseDouble(valorFiltro);
                    produtosFiltrados = produtoController.getProdutos().stream()
                            .filter(produto -> produto.getPreco() > precoFiltro)
                            .collect(Collectors.toList());
                    break;
                default:
                    produtosFiltrados = produtoController.getProdutos();
            }

            // Exibir a lista filtrada em uma nova janela de diálogo
            exibirListaFiltrada(produtosFiltrados);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite um valor numérico válido para o filtro de preço ou ID!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exibirListaFiltrada(List<Produto> produtos) {
        // Construir uma representação de string para os produtos filtrados
        StringBuilder mensagem = new StringBuilder("Produtos Filtrados:\n");
        for (Produto produto : produtos) {
            mensagem.append("ID: ").append(produto.getIdProduto())
                    .append(" | Nome: ").append(produto.getNome())
                    .append(" | Unidade: ").append(produto.getUnidade())
                    .append(" | Preço: ").append(produto.getPreco())
                    .append(" | Descrição: ").append(produto.getDescricao())
                    .append("\n");
        }

        // Exibir a lista filtrada em uma nova janela de diálogo
        JOptionPane.showMessageDialog(this, mensagem.toString(), "Produtos Filtrados", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(frmCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmCadastroProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
class Produto {
    private int idProduto;
    private String nome;
    private String unidade;
    private double preco;
    private String descricao;

    public Produto(int idProduto, String nome, String unidade, double preco, String descricao) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.unidade = unidade;
        this.preco = preco;
        this.descricao = descricao;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public String getNome() {
        return nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }
}

class ProdutoController {
    private java.util.List<Produto> produtos;

    public ProdutoController() {
        produtos = new java.util.ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}