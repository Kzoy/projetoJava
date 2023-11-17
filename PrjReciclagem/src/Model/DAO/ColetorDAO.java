/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Coletor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Frederico
 */
public class ColetorDAO {
    private Banco conexao;
    private Connection conn;
    
        public ColetorDAO() {
        this.conexao = new Banco();
        this.conn = this.conexao.getConexao();
    }
    
    public Coletor GetColetor(int idUsuario){
        String sql = "Select * from Tab_Usuario Where pk_int_IdUsuario = ?";
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            rs.first();
            Coletor user = new Coletor();
            user.setNome(rs.getString("str_Nome"));
            user.setSobrenome(rs.getString("str_Sobrenome"));
            user.setLogin(rs.getString("str_login"));
            user.setSenha(rs.getString("str_senha"));
            user.setTelefone(rs.getString("str_telefone"));
            user.setEndereco(rs.getString("str_endereco"));
            user.setEmail(rs.getString("str_email"));
            user.setDataContrato(rs.getDate("dte_dataContrato"));
            user.setSetor(rs.getString("str_setor"));
            user.setAdministrador(rs.getBoolean("bln_administrador"));

            return user;
        }
 
        catch (Exception e) {
            System.out.println("Erro no metodo GetColetor: " + e.getMessage());
            return null;
        }
    }
    
    public List<Coletor> GetLstColetorAll(){
        String sql = "Select * from Tab_Usuario";
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Coletor> lstColetor = new ArrayList<>();
            while(rs.next())
            {
                Coletor userCol = new Coletor();
                userCol.setIdUsuario(rs.getInt("pk_int_IdUsuario"));
                userCol.setNome(rs.getString("str_Nome"));
                userCol.setSobrenome(rs.getString("str_Sobrenome"));
                userCol.setLogin(rs.getString("str_login"));
                userCol.setSenha(rs.getString("str_senha"));
                userCol.setTelefone(rs.getString("str_telefone"));
                userCol.setEndereco(rs.getString("str_endereco"));
                userCol.setEmail(rs.getString("str_email"));
                userCol.setDataContrato(rs.getDate("dte_dataContrato"));
                userCol.setSetor(rs.getString("str_setor"));
                userCol.setAdministrador(rs.getBoolean("bln_administrador"));
                lstColetor.add(userCol);
            }            
            return lstColetor;
        }
 
        catch (Exception e) {
            System.out.println("Erro no metodo GetColetor: " + e.getMessage());
            return null;
        }
        
    }    
}
