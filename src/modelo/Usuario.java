package modelo;
import utils.Seguranca;

public class Usuario {
    private int id;
    private String login;
    private String senha;
    private String admin;
     public Usuario(){}
    public Usuario(String login, String senha, boolean admin){
         this.login = login;

    }
}
