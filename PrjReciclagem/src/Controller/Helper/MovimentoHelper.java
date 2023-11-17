/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;

import Model.Login;
import Model.Movimento;
import View.frmMovimento;
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
        int idColetor = view.getIdUsuarioMov();
        int idItem = view.getCmbItem().getSelectedIndex();
        float quantidade = Float.valueOf(view.getTxtQuantidade().getText());
        Date dataMovimento = new Date();

        Movimento modelo = new Movimento ();        
        return modelo;
    }
    
    public Movimento limparModelo(){
        Movimento modelo = new Movimento ();        
        return modelo;
    }
    
}
