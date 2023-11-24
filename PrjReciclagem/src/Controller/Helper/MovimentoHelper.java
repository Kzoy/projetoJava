/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;


import Model.Movimento;
import View.frmMovimento;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Frederico
 */
public class MovimentoHelper {
    
    private final frmMovimento view;
    
    public MovimentoHelper(frmMovimento view) {
        this.view = view;
    }
    
    public Movimento obterModelo(){
        Movimento modelo = new Movimento(); 
        float quantidade = 0;
        try 
        {
            int idColetor = view.getIdUsuarioMov();
            String selectedItem[] = view.getCmbItem().getSelectedItem().toString().split(";");
            int idItem = Integer.parseInt(selectedItem[0]);
            if (!("".equals(view.getTxtQuantidade().getText())))
            {
                quantidade = Float.valueOf(view.getTxtQuantidade().getText());
            } 
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            String dataMovimento = df.format(new Date());
            
            modelo = new Movimento (0,idColetor,idItem,quantidade,dataMovimento);        
        } 
        catch (Exception e) 
        {
            this.view.exibeMensagem("Erro ao executar metodo GerarMovimento: " + e.getMessage());
            
        }
        
        return modelo;
    }
    
    public Movimento limparModelo(){
        Movimento modelo = new Movimento ();        
        return modelo;
    }
    
    public void limparDados(){
        view.getTxtQuantidade().setText("");
    }    
    
}
