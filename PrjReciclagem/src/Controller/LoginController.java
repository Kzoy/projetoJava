/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.LoginHelper;
import Model.Login;
import Model.Usuario;
import View.frmLogin;

/**
 *
 * @author Frederico
 */
public class LoginController {
    //Propriedades
    private final frmLogin view;
    private LoginHelper helper;

    //Construtores
    public LoginController(frmLogin view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    //Regras de Negocio
    public void logar(){
        try
        {
            //Obter Usuario da view
            Login usuario = helper.obterModelo();
            
            
            //validar usuario no banco
            //analisar usuario e senha da tela com o do banco
            //// se sim abrir tela menu
            //// se não mensagem de login incorreto e manter na tela
            
            tarefaExecutada();
        }
        catch (Exception ex)
        {
            this.view.exibeMensagem("Erro ao executar metodo logar");
        }
    }
    
    public void tarefaExecutada(){
        System.out.println("Processo finalizado com banco");
        this.view.exibeMensagem("Tarefa realizada com sucesso");
    }
}
