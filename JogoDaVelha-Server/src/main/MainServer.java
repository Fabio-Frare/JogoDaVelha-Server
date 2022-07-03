package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import org.json.simple.parser.ParseException;

/**
 * Classe de inicialização do Jogo da Velha no servidor.
 *
 * @author Fábio e Lucas Nogueira
 * @since 07/2022
 */
public class MainServer {
    private static Socket s;
    private static ServerSocket ss;
    private static PrintWriter pr;

    public static void main(String[] args) throws IOException, ParseException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Informe a porta para a aplicação servidor: ");
        int port = sc.nextInt();

        ss = new ServerSocket(port);
        ss.setReuseAddress(true);
//        controller = new Controller();
        System.out.println("Iniciado");

        while (true) {
            receberDados();
        }

    }

    public static void receberDados() throws IOException, ParseException {
        s = ss.accept();
        String clienteIP = s.getInetAddress().getHostAddress();
        System.out.println("Cliente IP " + clienteIP + " conectado.");

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf    = new BufferedReader(in);
        String msg = bf.readLine();

        System.out.println("msg: " + msg);

//        String retorno = controller.trataDados(msg);  
//        enviarDados(retorno);
    }

    public static void enviarDados(String msg) throws IOException {
        pr = new PrintWriter(s.getOutputStream());
        pr.println(msg);
        pr.flush();
    }

}
