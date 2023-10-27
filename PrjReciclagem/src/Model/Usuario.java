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
public class Usuario {
    
    //Propriedades
    private int idUsuario;
    private String nome;
    private String Sobrenome;
    private String login;
    private String senha;
    private boolean administrador;
    
    //Construtor
    public Usuario(int idUsuario, String nome, String Sobrenome, String login, String senha, boolean administrador) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.Sobrenome = Sobrenome;
        this.login = login;
        this.senha = senha;
        this.administrador = administrador;
    }
        
    //Metodos Publicos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String Sobrenome) {
        this.Sobrenome = Sobrenome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    
    
}
