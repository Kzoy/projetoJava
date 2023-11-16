/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;

import Model.Login;
import View.frmLogin;

/**
 *
 * @author Frederico
 */
public class LoginHelper {
    
    private final frmLogin view;
    
    public LoginHelper(frmLogin view) {
        this.view = view;
    }
    
    public Login obterModelo(){
        String nome = view.getTxtUsuario().getText();
        String senha = view.getTxtSenha().getText();
            
        Login modelo = new Login (0, nome, senha);        
        return modelo;
    }
    
    public void setarModelo(Login modelo){
        String nome = modelo.getNome();
        String senha = modelo.getSenha();
        
        view.getTxtUsuario().setText(nome);
        view.getTxtSenha().setText(senha);
    }
    
    public void limparDados(){
        view.getTxtUsuario().setText("");
        view.getTxtSenha().setText("");
    }
}
