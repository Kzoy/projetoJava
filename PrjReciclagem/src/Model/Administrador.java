/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Frederico
 */
public class Administrador extends Usuario {
    //Propriedades
    private String emailEmergencial;
    
    //Construtores

    public Administrador(String emailEmergencial, int idUsuario, String nome, String Sobrenome, String login, String senha, String email, String telefone, boolean administrador) {
        super(idUsuario, nome, Sobrenome, login, senha, email, telefone, administrador);
        this.emailEmergencial = emailEmergencial;
    }
 
    public Administrador(int idUsuario, String nome, String senha) {
        super(idUsuario, nome, senha);
    }
    

    //Metodos Publicos
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmailEmergencial() {
        return emailEmergencial;
    }

    public void setEmailEmergencial(String emailEmergencial) {
        this.emailEmergencial = emailEmergencial;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
}

