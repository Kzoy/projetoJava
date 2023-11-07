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
    private String email;
    private String telefone;
    
    //Construtores
    public Administrador(int idUsuario, String nome, String Sobrenome, String login, String senha, boolean administrador, String email) {
        super(idUsuario, nome, Sobrenome, login, senha, administrador);
        this.email = email ;
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

