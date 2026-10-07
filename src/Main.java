import BD.Cnx;

import java.sql.SQLException;
import java.sql.Connection;


public class Main {
    public static void main(String[] args) {
        System.out.println("Testando conexão...");
        try (Connection conexao = Cnx.getConexao()) {
            if (conexao != null && !conexao.isClosed()){
                System.out.println("Sucesso conexao");
            }
        }
        catch(SQLException e){
            System.err.println("Falha");
            e.printStackTrace();
        }

    }
}