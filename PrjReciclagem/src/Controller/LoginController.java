/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.LoginHelper;
import Model.DAO.LoginDAO;
import Model.Login;
import View.frmLogin;
import View.frmMenuPrincipal;

/**
 *
 * @author Frederico
 */
public class LoginController {
    //Propriedades
    private final frmLogin view;
    private LoginHelper helper;
    private LoginDAO conexaoLogin;

    //Construtores
    public LoginController(frmLogin view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    //Regras de Negocio
    public void LogarSistema(){
        try
        {
            //Obter Usuario da view
            Login usuario = helper.obterModelo();
            LoginDAO lgnDao = new LoginDAO();
            if (lgnDao.LogarBanco(usuario) == null)
            {
                this.view.exibeMensagem("Usuario ou Senha invalido");
                return;
            }
            frmMenuPrincipal menu = new frmMenuPrincipal();
            menu.setVisible(true);
        }
        catch (Exception ex)
        {
            this.view.exibeMensagem("Erro ao executar metodo LogarController: " + ex.getMessage());
        }
    }
    
    public void tarefaExecutada(){
        System.out.println("Processo finalizado com banco");
        this.view.exibeMensagem("Tarefa realizada com sucesso");
    }
}
