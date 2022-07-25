package datasource;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import model.Player;
import org.json.simple.parser.ParseException;
import utils.SocketServer;
import utils.Utils;

/**
 * Classe de simulação de um banco de dados.
 *
 * @author Fábio e Lucas Nogueira
 * @since 07/2022
 */
public class Datasource {

    private final Utils utils;
    private Player player;
    private static List<Player> dadosPlayers = new ArrayList();
    private int contador;

    public Datasource() {
        this.utils = new Utils();
        contador = 1;
    }

    public String addPlayer(Socket socket, String msg) throws ParseException {

        if (dadosPlayers.size() < 4) {
            player = utils.converteJsonToPlayer(msg);
            player.setSocketCliente(socket);
            dadosPlayers.add(player);
            atualizaVezPlayer();
            insereCaracterPlayer(); 
            System.out.println("Datasource - Lista: " + dadosPlayers.toString());
            return utils.liberaJogoPlayer(player); 
        } else {
            return utils.numeroMaximoPlayers();
        }        
    }    
    
    public void atualizaVezPlayer() {
        for (Player play : dadosPlayers) {
            if(dadosPlayers.indexOf(play) == (contador-1)) {
                play.setLiberado(true);
            } else {
                play.setLiberado(false);
            }
        }       
        atualizaContador();
    }
    
    public void atualizaContador() {
        if(contador%4 == 0) {
            this.contador = 1;
        } else {
            this.contador++;
        }
    }

    private void insereCaracterPlayer() {
       for (Player playCaracter : dadosPlayers) {
            if(dadosPlayers.indexOf(playCaracter)%2 == 0) {
                playCaracter.setCaracter("O");
            } else {
                playCaracter.setCaracter("X");
            }
        }   
    }

    public static List<Player> getDadosPlayers() {
        return dadosPlayers;
    }


 

  
    
    

}
