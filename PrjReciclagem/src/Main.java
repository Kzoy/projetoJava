
import Model.DAO.Banco;
import Model.Item;
import Model.Usuario;
import View.frmLogin;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Frederico
 */
public class Main {
    
    public static void main(String[] args) {
        Banco c = new Banco();
        if (c.getConexao() == null)
        {
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco. VERIFIQUE!");
            return;
        }
        new frmLogin().setVisible(true);
    }
    
}
/*
NÂO MUDAR NENHUM NOME DE CAMPO JÁ CRIADO POIS PODE ESTAR SENDO UTILIZADO EM 
ALGUMA PARTE DE CODIGO

ATENÇÂO AS REGRAS DE CRIAÇÃO DE CAMPOS NAS TELAS
-TODO CAMPO DEVE TER O NOME EM CAMELCASE, CARA PALAVRA NO NOME DEVE TER A 
    PRIMEIRA LETRA MAIUSCULA, MENOS A PRIMEIRA PALAVRA, E DEVE SER INICIADO 
    COM O TIPO DO CAMPO CONFORME TABELA A BAIXO

Tabela Tipo Campo
    Label:      lbl
    TextBox     txt
    Frame:      frm
    ComboBox:   cmb
    Table:      tbl

    EX: Criar uma label na tela para especificar o campo endereço = lblEndereco
        Criar um campo texto na tela para inserção do numero do endereço = txtNumEndereco
        Criar uma label na tela para especificar o campo email = lblEmail
        Criar uma nova tela para cadastrar produto = frmCadastroProduto
*/