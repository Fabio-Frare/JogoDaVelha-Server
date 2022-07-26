package controller;

import datasource.ControllerJogo;
import datasource.Datasource;
import java.io.IOException;
import java.net.Socket;
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
    private ControllerJogo controllerJogo;
    

    public String trataDados(Socket socket, String msg) throws ParseException, IOException {
        utils           = new Utils();    
        datasource      = new Datasource();
        String operacao = utils.retornaOperacao(msg);
                
        
        
        switch (operacao) {
            case "1": // cadastra o cliente (player)                
                String resposta = datasource.addPlayer(socket, msg);    
//                System.out.println("Controller 1" + msg);
                return resposta;
                
            case "2": // recebe atualização do cliente
            // atualizo o jogo
            // verifico se niguem venceu
            // verifico se deu empate
            // atualiza os demais 
                
                System.out.println("Mensagem trata dados " + msg);
                controllerJogo = new ControllerJogo();
                controllerJogo.atualizaBotaoClicado(msg);
                controllerJogo.show();
                break;
//                return controllerJogo.atualizaPlayers();

            case "3": // envia atualização para o cliente
                
        }        
        
        
       return ""; 
    }
   
    
    
}
