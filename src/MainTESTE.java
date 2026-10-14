import DAO.UsuarioDAO;
import  modelo.Usuario;

public class MainTESTE {
    public static void main(String[]dadosEntrada){
        System.out.println("Teste de cadastro");
        //instancia o novo usuario
        Usuario novoUsuario = new Usuario("Teste", "1234", false);
        //instancia a classe resposavel pela persistencia do banco
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        //tenta cadatrar no banco de dados
        int idGerado = usuarioDAO.cadastrar(novoUsuario);
        //verifica o resultao da operação
        if (idGerado > 0 ){
            System.out.println("Usuario cadastrado com sucesso");
            System.out.println("id gerado no banco " + idGerado);
            System.out.println("login: " + novoUsuario.getLogin());
            System.out.println("Senha (Hash SHA-256): "+ novoUsuario.getSenha());
            System.out.println("é admin? " + novoUsuario.isAdmin());
        }else{
            System.out.println("Falha ao cadastrar");
        }
    }
}
