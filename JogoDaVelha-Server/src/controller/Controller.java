package controller;

import datasource.Datasource;
import org.json.simple.parser.ParseException;
import utils.Utils;

/**
 * Classe controller.
 *
 * @author Fábio e Lucas Nogueira
 * @since 07/2022
 */
public class Controller {
    private Utils utils;
    private Datasource datasource;
    

    public String trataDados(String msg) throws ParseException {
        utils           = new Utils();    
        datasource      = new Datasource();
        String operacao = utils.retornaOperacao(msg);
                
        
        
        switch (operacao) {
            case "1": // cadastra o cliente (player)                
                String resposta = datasource.addPlayer(msg);                
                return resposta;
                
            case "2": // recebe atualização do cliente
                System.out.println("Mensagem trata dados " + msg);
            case "3": // envia atualização para o cliente
                
        }        
        
        
       return "retorno trataDados()"; 
    }
    
    
    
    
    
    
}
