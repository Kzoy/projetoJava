/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.MovimentoHelper;
import Model.DAO.ItemDAO;
import Model.DAO.MovimentoDAO;
import Model.Item;
import View.frmMovimento;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Frederico
 */
public class MovimentoController {
    //Propriedades
    private final frmMovimento view;
    private MovimentoHelper helper;
    private MovimentoDAO conexaoLogin;

    //Construtores
    public MovimentoController(frmMovimento view) {
        this.view = view;
        this.helper = new MovimentoHelper(view);
    }
    
    public void AdicionarItem()
    {
        //DefaultTableModel tabelaMovimento = (DefaultTableModel) view.getTblMovimento().getModel();
        //ItemDAO itemDao = new ItemDAO();
        //Item prd = itemDao.GetItem(view.getCmbItem().getSelectedIndex());
        //Object[] obj = new Object[]{
        //    prd.getDescricao(),
        //};
        //tabelaMovimento.

    }
    
    //Regras de Negocio
    public void GerarMovimento(){
        //try
        //{
        //    Movimento  = helper.obterModelo();
        //    LoginDAO lgnDao = new LoginDAO();
        //    usuario = lgnDao.LogarBanco(usuario); 
        //    if (usuario == null)
        //    {
        //        this.view.exibeMensagem("Usuario ou Senha invalido");
        //        return;
        //    }
        //    frmMenuPrincipal menu = new frmMenuPrincipal(usuario.getIdUsuario());
        //    menu.setVisible(true);
        //    this.view.setVisible(false);
        //}
        //catch (Exception ex)
        //{
        //    this.view.exibeMensagem("Erro ao executar metodo LogarController: " + ex.getMessage());
        //}
    }
       
}
