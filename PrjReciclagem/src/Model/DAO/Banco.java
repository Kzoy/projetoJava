/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;



/**
 *
 * @author tiago
 */
public class Banco {
    
    public Connection getConexao(){
        try 
        {
            Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/prjreciclagem?serverTimezone=UTC", //Conexao
                        "root", //Usuario
                        "123456"); //senha
            return conn;
        } 
        catch (Exception e) {
            System.out.println("Erro ao conectar" + e.getMessage());
            return null;
        }
    }
    
}
