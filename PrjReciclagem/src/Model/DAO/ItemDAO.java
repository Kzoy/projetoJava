/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Item;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Frederico
 */
public class ItemDAO extends SqlDAO{
    
    //Construtores 
    public ItemDAO() {
        this.conexao = new Banco();
        this.conn = this.conexao.getConexao();
    }
    
    @Override
    public void InserirItem(Item produto){
        String sql = "Insert into Tab_Item " 
                + "(str_Descricao, str_Unidade, flt_valorUnitario) "
                + "Values "
                + "(?, ?, ?)"
                ;
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, produto.getDescricao());
            stmt.setString(2, produto.getUnidade());
            stmt.setFloat(3, produto.getValorUnitario());
            stmt.execute();
        } 
        catch (Exception e) {
            System.out.println("Erro no metodo InserirItem: " + e.getMessage());
        }
        
    }
    
    public Item GetItem(int idProduto){
        String sql = "Select * from Tab_Item Where pk_int_IdItem = ?";
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idProduto);
            ResultSet rs = stmt.executeQuery();
            rs.first();
            Item produto = new Item();
            produto.setIdItem(rs.getInt("pk_int_IdItem"));
            produto.setDescricao(rs.getString("str_Descricao"));
            produto.setValorUnitario(rs.getFloat("flt_valorUnitario"));
            produto.setUnidade(rs.getString("str_Unidade"));
            return produto;
        }
 
        catch (Exception e) {
            System.out.println("Erro no metodo GetItem: " + e.getMessage());
            return null;
        }
        
    }
    
    public List<Item> GetLstItem(Item produto){
        String sql = "Select * from Tab_Item Where str_Descricao Like ?";
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, "%" + produto.getDescricao() + "%");
            ResultSet rs = stmt.executeQuery();
            List<Item> lstItens = new ArrayList<>();
            while(rs.next())
            {
               Item prd = new Item();
               prd.setIdItem(rs.getInt("pk_int_IdItem"));
               prd.setDescricao(rs.getString("str_Descricao"));
               prd.setUnidade(rs.getString("str_Unidade"));
               prd.setValorUnitario(rs.getFloat("flt_valorUnitario"));
               lstItens.add(prd);
            }
            return lstItens;
        }
        catch (Exception e) {
            System.out.println("Erro no metodo GetLstItem: " + e.getMessage());
            return null;
        }
        
    }    
    
    public List<Item> GetLstItemAll(){
        String sql = "Select * from Tab_Item order by pk_int_IdItem";
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Item> lstItens = new ArrayList<>();
            while(rs.next())
            {
               Item prd = new Item();
               prd.setIdItem(rs.getInt("pk_int_IdItem"));
               prd.setDescricao(rs.getString("str_Descricao"));
               prd.setUnidade(rs.getString("str_Unidade"));
               prd.setValorUnitario(rs.getFloat("flt_valorUnitario"));
               lstItens.add(prd);
            }
            return lstItens;
        }
        catch (Exception e) {
            System.out.println("Erro no metodo GetLstItemAll: " + e.getMessage());
            return null;
        }
        
    } 
    
}
