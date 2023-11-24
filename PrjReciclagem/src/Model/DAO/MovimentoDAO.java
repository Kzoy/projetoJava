/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Movimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Frederico
 */
public class MovimentoDAO {
    private Banco conexao;
    private Connection conn;
    
    //Construtores 

    public MovimentoDAO() {
        this.conexao = new Banco();
        this.conn = this.conexao.getConexao();
    }
    
    public void InserirMovimento(Movimento movItem){
        String sql = "Insert into Tab_Movimento " 
                + "(fk_int_IdColetor, fk_int_IdItem, flt_Quantidade,"
                + " dte_DataMovimento, str_Observacao) "
                + "Values "
                + "(?, ?, ?,"
                + " ?, ?)"                
                ;
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, movItem.getIdColetor());
            stmt.setInt(2, movItem.getIdItem());
            stmt.setFloat(3, movItem.getQuantidade());
            java.sql.Date sqlConvertDate = new java.sql.Date(movItem.getDataMovimento().getTime());
            stmt.setDate(4, sqlConvertDate);
            stmt.setString(5, movItem.getObservacao());
            stmt.execute();
        } 
        catch (Exception e) {
            System.out.println("Erro no metodo InserirMovimento: " + e.getMessage());
        }
        
    }
    
    public Movimento GetMovimento(Movimento movItem){
        String sql = "Select * from Tab_Movimento Where pk_int_IdMovimento = ?";
        try 
        {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, movItem.getIdMovimento());
            ResultSet rs = stmt.executeQuery();
            rs.first();
            movItem.setIdColetor(rs.getInt("fk_int_IdColetor"));
            movItem.setIdItem(rs.getInt("fk_int_IdItem"));
            movItem.setQuantidade(rs.getFloat("flt_Quantidade"));
            movItem.setDataMovimento(rs.getDate("dte_DataMovimento"));
            movItem.setObservacao(rs.getString("str_Observacao"));
            return movItem;
        }
 
        catch (Exception e) {
            System.out.println("Erro no metodo GetMovimento: " + e.getMessage());
            return null;
        }
        
    }
    
    public List<Movimento> GetLstMov(String dataInicial, String dataFinal, int idColetor){
        String sql = "Select * from Tab_Movimento Where dte_DataMovimento >= ? "
                   + "and dte_DataMovimento <= ? and fk_int_IdColetor = ?";
        try 
        {
            String startDate = dataInicial;
            String endDate = dataFinal;
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date dateIni = sdf1.parse(startDate);
            java.util.Date dateFim = sdf1.parse(endDate);
            java.sql.Date sqlStartDate = new java.sql.Date(dateIni.getTime()); 
            java.sql.Date sqlEndingDate = new java.sql.Date(dateFim.getTime()); 
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idColetor);
            stmt.setDate(2, sqlStartDate);
            stmt.setDate(3, sqlEndingDate);
            ResultSet rs = stmt.executeQuery();
            List<Movimento> lstMovimentos = new ArrayList<>();
            while(rs.next())
            {
               Movimento mvt = new Movimento();
               mvt.setIdMovimento(rs.getInt("pk_int_IdMovimento"));
               mvt.setIdColetor(rs.getInt("fk_int_IdColetor"));
               mvt.setIdItem(rs.getInt("pk_int_IdItem"));
               mvt.setQuantidade(rs.getFloat("flt_Quantidade"));
               mvt.setDataMovimento(rs.getDate("dte_DataMovimento"));
               mvt.setObservacao(rs.getString("str_Observacao"));
               lstMovimentos.add(mvt);
            }
            return lstMovimentos;
        }
        catch (ParseException | SQLException ex) {
            System.out.println("Erro no metodo GetLstMov: " + ex.getMessage());
            return null;
        }

        
    }        
}
