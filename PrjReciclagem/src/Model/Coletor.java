/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Frederico
 */
public class Coletor extends Usuario {
    //Propriedades
    private String telefone;
    private String endereco;
    private String email;
    private Date dataContrato;
    private String setor;

    //Construtores
    public Coletor(int idUsuario, String nome, String Sobrenome, String login, String senha, boolean administrador, String telefone, String endereco, String email, String dataContrato, String setor) {
        super(idUsuario, nome, Sobrenome, login, senha, administrador);
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        try 
        {
            this.dataContrato = new SimpleDateFormat("dd/MM/yy").parse(dataContrato);
        } 
        catch (ParseException ex) 
        {
            Logger.getLogger(Coletor.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setor = setor;
    }

    public Coletor(int idUsuario, String nome, String setor) {
        super(idUsuario, nome);
        this.setor = setor;
    }
    
    //Metodos Publicos
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(Date dataContrato) {
        this.dataContrato = dataContrato;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

  
    
    
}
