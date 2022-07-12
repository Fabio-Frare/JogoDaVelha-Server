
package datasource;

import java.util.ArrayList;
import java.util.List;
import model.Player;
import org.json.simple.parser.ParseException;
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
    private static final List<Player> dadosPlayers = new ArrayList();

    public Datasource() {
        this.utils = new Utils();
    }
    
    public String addPlayer(String msg) throws ParseException {   
        player = utils.converteJsonToPlayer(msg);
        
        dadosPlayers.add(player);
        
//        System.out.println("Datasource: " + dadosPlayers.toString());
        
        return "Pessoa "+ player.getNome() + " inserida com sucesso.";
    }
    
    
}
