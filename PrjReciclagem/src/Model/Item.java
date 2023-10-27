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
public class Item {
    // Propriedades da classe
    private int idItem;
    private String descricao;
    private float valorUnitario;

    //Construtor
    public Item(int iditem, String descricao, float valorunitario) {
        this.idItem = iditem;
        this.descricao = descricao;
        this.valorUnitario = valorunitario;
    }
    
    //metodos publicos das propriedades
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValorunitario() {
        return valorUnitario;
    }

    public void setValorunitario(float valorunitario) {
        this.valorUnitario = valorunitario;
    }
    
}
