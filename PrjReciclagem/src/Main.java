
import Model.Item;
import Model.Usuario;

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
        
        Item item = new Item(1, "Item Teste", 10);
        
        
        System.out.println();
                
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