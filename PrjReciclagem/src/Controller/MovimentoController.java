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
import Model.Movimento;
import View.frmMovimento;
import java.util.ArrayList;
import java.util.List;
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
        try 
        {
            DefaultTableModel tabelaMovimento = (DefaultTableModel) view.getTblMovimento().getModel();
            Movimento mov = this.helper.obterModelo();
            if (mov != null && mov.getQuantidade() > 0) 
            {
                ItemDAO itemDao = new ItemDAO();
                Item prd = itemDao.GetItem(mov.getIdItem());
                Object[] obj = new Object[]{
                    prd.getIdItem(),
                    prd.getDescricao(),
                    mov.getQuantidade(), 
                    prd.getValorUnitario(),
                    mov.getQuantidade()*prd.getValorUnitario()           
                };
                tabelaMovimento.addRow(obj);
                this.helper.limparDados();
            }

        } 
        catch (Exception ex) 
        {
            this.view.exibeMensagem("Erro ao executar metodo AdicionarItem: " + ex.getMessage());
        }

    }
    
    public void RemoverItem()
    {
        try 
        {
            DefaultTableModel tabelaMovimento = (DefaultTableModel) view.getTblMovimento().getModel();
            int idRow = view.getTblMovimento().getSelectedRow();
            if (idRow >= 0)
            {
                tabelaMovimento.removeRow(idRow);
            }
            
        } 
        catch (Exception ex) 
        {
            this.view.exibeMensagem("Erro ao executar metodo RemoverItem: " + ex.getMessage());
        }

    }    

    public void RemoverTodosItens()
    {
        try 
        {
            DefaultTableModel tabelaMovimento = (DefaultTableModel) view.getTblMovimento().getModel();
            tabelaMovimento.setNumRows(0);            
        } 
        catch (Exception ex) 
        {
            this.view.exibeMensagem("Erro ao executar metodo RemoverTodosItens: " + ex.getMessage());
        }

    }       
    
    //Regras de Negocio
    public void GerarMovimento(){
        try
        {
            int idRow = view.getTblMovimento().getRowCount();
            if (idRow > 0)
            {
                Movimento mov  = helper.obterModelo();
                MovimentoDAO movDao = new MovimentoDAO();
                DefaultTableModel tabelaMovimento = (DefaultTableModel) view.getTblMovimento().getModel();
                int rowCountTabela = tabelaMovimento.getRowCount();
                List<Movimento> lstMov = new ArrayList<>();
                for(int i = 0; i < rowCountTabela; i++)
                {
                    Movimento tempMov = new Movimento();
                    tempMov.setIdColetor(mov.getIdColetor());
                    tempMov.setIdItem((int)tabelaMovimento.getValueAt(i, 0));
                    tempMov.setQuantidade((float)tabelaMovimento.getValueAt(i, 2));
                    tempMov.setDataMovimento(mov.getDataMovimento());              
                    lstMov.add(tempMov);
                }
            
                lstMov.stream().forEach((movInsert) -> {
                    movDao.InserirMovimento(movInsert);
                });
                
                this.view.exibeMensagem("Movimento salvo com suceesso");
                RemoverTodosItens();
            }
            
        }
        catch (Exception ex)
        {
            this.view.exibeMensagem("Erro ao executar metodo GerarMovimento: " + ex.getMessage());
        }
    }
       
}
