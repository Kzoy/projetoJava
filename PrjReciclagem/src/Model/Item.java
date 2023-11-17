/*
 
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
*/
package Model;

/**
 *
 
@author Frederico*/
public class Item {
    // Propriedades
    private int idItem;
    private String descricao;
    private float valorUnitario;
    private String unidade;

    //Construtores
    public Item(int iditem, String descricao, float valorunitario, String unidade) {
        this.idItem = iditem;
        this.descricao = descricao;
        this.valorUnitario = valorunitario;
        this.unidade = unidade;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getUnidade() {
        return unidade;
    }

    //metodos publicos
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}