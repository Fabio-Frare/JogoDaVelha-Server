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
    

    public String trataDados(String msg, String clientIP) throws ParseException {
        utils           = new Utils();    
        datasource      = new Datasource();
        String operacao = utils.retornaOperacao(msg);
                
        
        
        switch (operacao) {
            case "1": 
                return datasource.addPlayer(msg);
             
                
        }
        
        
        
       return "deu erro"; 
    }
    
    
    
    
    
    
}
