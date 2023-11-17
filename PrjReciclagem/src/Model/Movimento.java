/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Frederico
 */
public class Movimento {
    //Propriedades
    private int idMovimento;
    private int idColetor;
    private int idItem;
    private float quantidade;
    private Date dataMovimento;
    private String Observacao;

    //Construtores
    public Movimento() {
    }

    public Movimento(int idMovimento, int coletor, int item, float quantidade, String dataMovimento) {
        this.idMovimento = idMovimento;
        this.idColetor = coletor;
        this.idItem = item;
        this.quantidade = quantidade;
        try 
        {
            this.dataMovimento = new SimpleDateFormat("dd/MM/yy HH:mm").parse(dataMovimento);
        }
        catch (ParseException ex) 
        {
            Logger.getLogger(Movimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Metodos Publicos
    public int getIdMovimento() {
        return idMovimento;
    }

    public void setIdMovimento(int idMovimento) {
        this.idMovimento = idMovimento;
    }

    public int getIdColetor() {
        return idColetor;
    }

    public void setIdColetor(int idColetor) {
        this.idColetor = idColetor;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String Observacao) {
        this.Observacao = Observacao;
    }
    
    
    
}
