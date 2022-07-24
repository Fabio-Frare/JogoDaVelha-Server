package utils;

import controller.Controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import org.json.simple.parser.ParseException;

/**
 * Classe responsável pelo tratamento de sockets na conversação entre cliente e
 * servidor.
 *
 * @author Fabio e Lucas Nogueira
 * @since 07/2022
 */
public class SocketServer {

    private static Socket       s;
    private static ServerSocket ss;
    private static PrintWriter  pr;
    private static final int    port = 80;
    private static Controller  controller;
    private static String       retorno;

    public SocketServer() throws IOException {
        controller = new Controller();
        ss = new ServerSocket(port);
        ss.setReuseAddress(true);
    }
    
    public  void receberDados() throws IOException, ParseException {
        s = ss.accept();
//        String clienteIP = s.getInetAddress().getHostAddress();

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf    = new BufferedReader(in);
        String msg           = bf.readLine();

        retorno = controller.trataDados(msg);
        System.out.println("Retorno receber dados: " + retorno);
        enviarDados(retorno);
    }
    
     public static void enviarDados(String msg) throws IOException {
        pr = new PrintWriter(s.getOutputStream());
        pr.println(msg);
        pr.flush();
    }

}
