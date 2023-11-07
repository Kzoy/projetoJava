/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Administrador;
import java.util.ArrayList;

/**
 *
 * @author Frederico
 */
public class AdministradorDAO {
    
    /**
     * Insere um administrador dentro do banco de dados
     * @param administrador exige que seja passado um objeto do tipo administrador
     */
    public void insert(Administrador administrador){
        Banco.administrador.add(administrador);
    }
    
    /**
     * Atualiza um Objeto no banco de dados
     * @param administrador
     * @return 
     */
    public boolean update(Administrador administrador){
        
        for (int i = 0; i < Banco.administrador.size(); i++) {
            if(idSaoIguais(Banco.administrador.get(i),administrador)){
                Banco.administrador.set(i, administrador);
                return true;
            }
        }
        return false;      

    }
    
    /**
     * Deleta um objeto do banco de dados pelo id do administrador passado
     * @param administrador
     * @return 
     */
    public boolean delete(Administrador administrador){
        for (Administrador administradorLista : Banco.administrador) {
            if(idSaoIguais(administradorLista,administrador)){
                Banco.administrador.remove(administradorLista);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retorna um arraylist com todos os administradors do banco de dados
     * @return uma lista com todos os registros do banco
     */
    public ArrayList<Administrador> selectAll(){
        return Banco.administrador;
    }
    
    /**
     * Retorna um Objeto do tipo administrador se a funcao encontrar o administrador passado como parâmetro no banco, para considerar sao usado nome e senha
     * @param administrador
     * @return Administrador encontrado no banco de dados
     */
    public Administrador selectPorNomeESenha(Administrador administrador){
        for (Administrador administradorLista : Banco.administrador) {
            if(nomeESenhaSaoIguais(administradorLista,administrador)){
                return administradorLista;
            }
        }
        return null;
    }

    /**
     * Recebe dois objetos e verifica se são iguais verificando o nome e senha
     * @param administrador
     * @param administradorAPesquisar
     * @return verdadeiro caso sejam iguais e falso caso nao forem iguais
     */
    private boolean nomeESenhaSaoIguais(Administrador administrador, Administrador administradorAPesquisar) {
        return administrador.getNome().equals(administradorAPesquisar.getNome()) && administrador.getSenha().equals(administradorAPesquisar.getSenha());
    }

    /**
     * Compara se dois objetos tem a propriedade id igual
     * @param administrador
     * @param administradorAComparar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    private boolean idSaoIguais(Administrador administrador, Administrador administradorAComparar) {
        return administrador.getIdUsuario()==  administradorAComparar.getIdUsuario();
    }
    
    
    
}
