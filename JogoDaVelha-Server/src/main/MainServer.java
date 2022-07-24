package main;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import utils.SocketServer;

/**
 * Classe de inicialização do Jogo da Velha no servidor.
 *
 * @author Fábio e Lucas Nogueira
 * @since 07/2022
 */
public class MainServer {

    public static void main(String[] args) throws IOException, ParseException  {

        SocketServer socketServer = new SocketServer();
        System.out.println("Servidor iniciado.");

        while (true) {
            socketServer.receberDados();
        }

    }

}
