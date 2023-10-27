
import Model.Item;
import Model.Usuario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Frederico
 */
public class Main {
    
    public static void main(String[] args) {
        
        Item item = new Item(1, "Item Teste", 10);
        Usuario usuario = new Usuario(1, "usuario teste" , "Sobrenome teste", "login teste", "senhateste", false);
        
        System.out.println();
                
    }
    
}
