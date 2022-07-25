package model;

import java.net.Socket;

/**
 * Classe model de Player do Jogo da Velha.
 *
 * @author Fábio e Lucas Nogueira
 * @since 07/2022
 */
public class Player {

    private String  nome;
    private boolean liberado;
    private String  endereco;
    private String caracter;
    private Socket socketCliente;
    
    public Player() { }
    
    public Player(String nome, boolean liberado, String endereco) {
        this.nome     = nome;
        this.liberado = liberado;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isLiberado() {
        return liberado;
    }

    public void setLiberado(boolean liberado) {
        this.liberado = liberado;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public Socket getSocketCliente() {
        return socketCliente;
    }

    public void setSocketCliente(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }

    @Override
    public String toString() {
        return "Player[" + "nome:" + nome + ", liberado:" + liberado 
                + ", caracter:" + caracter + ']';
    }

 
 
}
