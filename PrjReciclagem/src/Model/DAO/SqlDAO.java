/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Item;
import java.sql.Connection;

/**
 *
 * @author Frederico
 */
public class SqlDAO {
    protected Banco conexao;
    protected Connection conn;
    
    //Construtores 

    public SqlDAO() {
        this.conexao = new Banco();
        this.conn = this.conexao.getConexao();
    }
    
    public void InserirItem(Item produto){
        String sql = "Insert into Tab_Item ";
    }
    
}
