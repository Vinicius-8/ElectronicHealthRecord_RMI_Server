package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *  Classe servidor que define as configurações de acesso ao servidor
 * @author Vinicius
 */
public class Servidor {
    //java -Djava.rmi.server.hostname=192.168.0.102 -Djava.security.policy=server.policy -jar <<arquivo_jar>> &
    
    /**
     * Método principal da classe Servidor que define a interface de operação,
     * cria o registro do host e referencia remota ao mesmoss
     * @param args 
     */
    public static void main(String[] args) {        //servidor maven
        try{
            
            Operacoes servico = new ImpOperacoes();
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("operacoes", servico);
            System.out.println("Servidor rodando...");
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
