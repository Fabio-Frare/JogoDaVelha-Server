package utils;

import model.Player;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Classe utils.
 *
 * @author Fábio e Lucas Nogueira
 * @since 07/2022
 */
public class Utils {

//    public String convertePessoaToJson (Pessoa pessoa) {
//        
//        JSONObject pessoaJson = new JSONObject();  
//        pessoaJson.put("nome"    , pessoa.getNome());
//        pessoaJson.put("cpf"     , pessoa.getCpf());
//        pessoaJson.put("endereco", pessoa.getEndereco());
//
//        return pessoaJson.toJSONString();
//    }
//    
//    
//    public Empresa converteJsonToEmpresa(String msg) throws ParseException {
//        
//        JSONParser parser = new JSONParser(); 
//        JSONObject json = (JSONObject) parser. parse(msg);
//        
//        Empresa empresa = new Empresa();
//        empresa.setNome((String) json.get("nome"));  
//        empresa.setCnpj((String) json.get("cnpj"));
//        
//        return empresa;        
//
//    }
    // operacao 1 - cadastrar player
    public String retornaOperacao(String msg) throws ParseException {

        JSONObject jsonObject;
        JSONParser parser = new JSONParser();
        jsonObject = (JSONObject) parser.parse(msg);

        String operacao = (String) jsonObject.get("operacao");
        return operacao;
    }

//    public String retornaEntidade(String msg) throws ParseException {
//        
//        JSONObject jsonObject;
//        JSONParser parser = new JSONParser();        
//        jsonObject = (JSONObject) parser.parse(msg);        
//        String entidade = (String) jsonObject.get("entidade");      
//        
//        return entidade;
//    }
//
//    public String retornaCnpjEmpresa(String msg) throws ParseException {
//        JSONObject jsonObject;
//        JSONParser parser = new JSONParser();        
//        jsonObject = (JSONObject) parser.parse(msg);
//        String cnpjEmpresa = (String) jsonObject.get("cnpj");    
//        
//        return cnpjEmpresa;
//    }
//    
//    public String retornaCpfPessoa(String msg) throws ParseException {
//        JSONObject jsonObject;
//        JSONParser parser = new JSONParser();        
//        jsonObject = (JSONObject) parser.parse(msg);
//        String cpfPessoa = (String) jsonObject.get("cpf");    
//        
//        return cpfPessoa;
//    }
    
    public Player converteJsonToPlayer(String msg) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject json   = (JSONObject) parser.parse(msg);
        
        Player player = new Player();
        player.setNome((String) json.get("nome"));
        player.setEndereco((String) json.get("endereco"));
        player.setLiberado(false);
        
        return player;
    }

//    public String liberaJogoPlayer(String nomePlayer, boolean liberado) {  
//        JSONObject liberaJogo = new JSONObject();  
//        liberaJogo.put("operacao"  , "1");
//        liberaJogo.put("nomePlayer", nomePlayer);
//        liberaJogo.put("liberado"  , liberado);
//        
//        return liberaJogo.toJSONString();
//    }
    
        public String liberaJogoPlayer(Player player) {  
        JSONObject liberaJogo = new JSONObject();  
        liberaJogo.put("operacao"  , "1");
        liberaJogo.put("nomePlayer", player.getNome());
        liberaJogo.put("liberado"  , player.isLiberado());
        liberaJogo.put("caracter"  , player.getCaracter());
        
        return liberaJogo.toJSONString();
    }

    public String numeroMaximoPlayers() {
        String msg = "Número máximo de players cadastrado. Fica para a próxima!!!";
  
        JSONObject bloqueiaJogo = new JSONObject();  
        bloqueiaJogo.put("operacao", "2");
        bloqueiaJogo.put("msg"     , msg);
        
        return bloqueiaJogo.toJSONString();
    
    }
    
    
    

}
