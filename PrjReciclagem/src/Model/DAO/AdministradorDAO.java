/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Frederico
 */
public class AdministradorDAO {
    private Banco conexao;
    private Connection conn;
    
    //Construtores 

    public AdministradorDAO() {
        this.conexao = new Banco();
        this.conn = this.conexao.getConexao();
    }
    
    public void InserirAdm(Administrador userAdm){
        String sql = "Insert into Tab_Usuario " 
                + "(str_Nome, str_Sobrenome, str_login, str_senha,"
                + " str_telefone, str_email, str_emailEmergencial, bln_administrador) "
                + "Values "
                + "(?, ?, ?, ?,"
                + " ?, ?, ?, 1)"
                ;
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, userAdm.getNome());
            stmt.setString(2, userAdm.getSobrenome());
            stmt.setString(3, userAdm.getLogin());
            stmt.setString(4, userAdm.getSenha());
            stmt.setString(5, userAdm.getTelefone());
            stmt.setString(6, userAdm.getEmail());
            stmt.setString(7, userAdm.getEmailEmergencial());
            stmt.execute();
        } 
        catch (Exception e) {
            System.out.println("Erro no metodo InserirAdm: " + e.getMessage());
        }
        
    }
    
    public Administrador GetAdministrador(Administrador userAdministrador){
        String sql = "Select * from Tab_Usuario Where str_login = ? and str_senha = ? and bln_administrador = 1";
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, userAdministrador.getLogin());
            stmt.setString(2, userAdministrador.getSenha());
            ResultSet rs = stmt.executeQuery(sql);
            Administrador adm = new Administrador();
            rs.first();
            adm.setIdUsuario(rs.getInt("pk_int_IdUsuario"));
            return adm;
        }
 
        catch (Exception e) {
            System.out.println("Erro no metodo GetLogin: " + e.getMessage());
            return null;
        }
        
    }
    
    
}
