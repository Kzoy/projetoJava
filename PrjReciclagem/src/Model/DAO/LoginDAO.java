/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Frederico
 */
public class LoginDAO {
    private Banco conexao;
    private Connection conn;
    
        public LoginDAO() {
        this.conexao = new Banco();
        this.conn = this.conexao.getConexao();
    }
    
    public Login LogarBanco(Login userLogin){
        String sql = "Select * from Tab_Usuario Where str_login = ?"
                    + " and str_senha = ?";
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, userLogin.getLogin());
            stmt.setString(2, userLogin.getSenha());
            ResultSet rs = stmt.executeQuery();
            Login login = new Login();
            rs.first();
            login.setIdUsuario(rs.getInt("pk_int_IdUsuario"));
            return login;
        }
 
        catch (Exception e) {
            System.out.println("Erro no metodo GetLogin: " + e.getMessage());
            return null;
        }
        
    }
    
    
}
