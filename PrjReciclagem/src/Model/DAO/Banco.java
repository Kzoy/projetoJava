/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Administrador;
import Model.Coletor;
import Model.Movimento;
import Model.Item;
import Model.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tiago
 */
public class Banco {
    
    public static ArrayList<Login> login;
    public static ArrayList<Administrador> administrador;
    public static ArrayList<Coletor> coletor;
    public static ArrayList<Item> item;
    public static ArrayList<Movimento> movimento;
    
    
    public Connection ConectaBD(){
        Connection conectar = null;
        try
        {
            String url = "jdbc:mysql://localhost:3306/BaseReciclagem?user=su&password=123456";
            conectar = DriverManager.getConnection(url);
        }       
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Erro no metodo ConectaBD, " + ex.getMessage());
        }
        return conectar;
    }
    
    public static void inicia(){
    
        //Instancia os Objetos
        login = new ArrayList<Login>();
        administrador = new ArrayList<Administrador>();
        coletor = new ArrayList<Coletor>();
        item = new ArrayList<Item>();
        movimento = new ArrayList<Movimento>();
        

        
        //criando elementos
        
        //Login login1 = new Login(1, "barbeiro", 'M', "09/05/1996", "30212121", "barbeiro@barbershop.com", "521454123", "barbeiro", "administrador");
        //Login login2 = new Login(2, "estagiario", 'M', "09/05/1996", "30212122", "estagiario@barbershop.com", "451244123", "estagiario", "funcionario");
         
        //Coletor coletor1 = new Coletor(1, "Alan Figueiredo", 'M', "30/01/1995", "30212126", "tiagoluz.h607@gmail.com", "5142487", "Rua jaboti 35 Canudos NH",  "93300012");
        //Coletor coletor2 = new Coletor(2, "Judite Oliveira", 'F', "30/08/1994", "30212127", "juditeoliveirapet@gmail.com", "5142487745", "Rua campo bom 78 Centro NH",  "93300045");
        //Coletor coletor3 = new Coletor(3, "Paulo Ricado", 'M', "24/04/1997", "30212128", "pauloricardopet@gmail.com", "78451458", "Rua Tres Irmaos 30 Vila Nova - NH",  "933007496");
        //Coletor coletor4 = new Coletor(4, "Neymar Santos", 'M', "20/08/1995", "30212130", "neymarsantospet@gmail.com", "2745487", "Rua Lombardi 40 Canudos NH",  "93300748");
        //Coletor coletor5 = new Coletor(5, "Debruine Pipoqueiro", 'M', "13/09/1992", "30212131", "debruinepet@gmail.com", "4742487", "Rua pedro quaresma 784 Canudos Belgica",  "933000847");
        //Coletor coletor6 = new Coletor(6, "Matuidi Pareira", 'M', "17/08/1994", "302122324", "matuidipet@gmail.com", "78512457", "Rua champions 10 Kephas Franca",  "933000782");
        //Coletor coletor7 = new Coletor(7, "Marta de Souza", 'F', "25/03/1993", "302121292", "martasouzapet@gmail.com", "4658237314", "Rua tesla 215 Canudos NH",  "93352012");
        //Coletor coletor8 = new Coletor(8, "Aline Ferrari", 'F', "04/03/1990", "302121451", "alineferraripet@gmail.com", "8475123687", "Rua hyrule 32 Canudos NH",  "9334714747");
        //Coletor coletor9 = new Coletor(9, "Samuel Coltinho", 'M', "09/02/1998", "302121189", "samuelcoltinhopet@gmail.com", "74595142487", "Rua floresta 12 Canudos NH",  "9330046364");
        //Coletor coletor10 = new Coletor(10, "Felipe Luis", 'M', "12/06/1999", "3021212478", "felipeluispet@gmail.com", "845713647", "Rua marechal 1023 Canudos NH",  "933000874");
        
        //Servico servico1 = new Servico(1, "Corte Simples", 18);
        //Servico servico2 = new Servico(2, "Corte Degrade", 30);
        //Servico servico3 = new Servico(3, "Barba Simples", 15);
        //Servico servico4 = new Servico(4, "Barba Desenhada", 25);
        //Servico servico5 = new Servico(5, "Sombrancelhas", 10);
        //Servico servico6 = new Servico(6, "Penteados", 3);

        //Agendamento agendamento1 = new Agendamento(1, coletor1, servico2, 30, "14/07/2018 09:30");
        //Agendamento agendamento2 = new Agendamento(2, coletor3, servico4, 40, "14/07/2018 10:00");
        //Agendamento agendamento3 = new Agendamento(3, coletor4, servico1, 18, "14/07/2018 10:30");
        
        //Adiciona Elementos na lista
        //login.add(login1);
        //login.add(login2);
        
        //coletor.add(coletor1);
        //coletor.add(coletor2);
        //coletor.add(coletor3);
        //coletor.add(coletor4);
        //coletor.add(coletor5);
        //coletor.add(coletor6);
        //coletor.add(coletor7);
        //coletor.add(coletor8);
        //coletor.add(coletor9);
        //coletor.add(coletor10);
        
        //servico.add(servico1);
        //servico.add(servico2);
        //servico.add(servico3);
        //servico.add(servico4);
        //servico.add(servico5);
        //servico.add(servico6);
        
        //agendamento.add(agendamento1);
        //agendamento.add(agendamento2);
        //agendamento.add(agendamento3);
        
    }
    
    
}
