package utils;

import controller.Controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 * Classe responsável pelo tratamento de sockets na conversação entre cliente e
 * servidor.
 *
 * @author Fabio e Lucas Nogueira
 * @since 07/2022
 */
public class SocketServer {

    public static Socket       s;
    public static ServerSocket ss;
    private static PrintWriter  pr;
    private static final int    port = 80;
    private static Controller   controller;
    private static String       retorno;
    
    private static SocketServer server;

    public SocketServer() throws IOException {
        controller = new Controller();
        ss = new ServerSocket(port);
        ss.setReuseAddress(true);
    }
    
    public static SocketServer getInstance() {
        if (server == null) {
            try {
                server = new SocketServer();
            } catch (IOException ex) {
                Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return server;
    }
    
    
    public  void receberDados() throws IOException, ParseException {
        s = ss.accept();
//        String clienteIP = s.getInetAddress().getHostAddress();

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf    = new BufferedReader(in);
        String msg           = bf.readLine();

        retorno = controller.trataDados(s, msg);
//        System.out.println("Retorno receber dados: " + retorno);
        enviarDados(retorno);
    }
    
    public static void enviarDados(String msg) throws IOException {
        pr = new PrintWriter(s.getOutputStream());
        pr.println(msg);
        pr.flush();
    }

    public static Socket getS() {
        return s;
    }

    public static void setS(Socket s) {
        SocketServer.s = s;
    }
     
     

}
