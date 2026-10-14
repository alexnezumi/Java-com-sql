package DAO;

import BD.Cnx;
import modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements DAO<Usuario> {
    @Override
    public int cadastrar(Usuario usuario) {
        String sql = "INSERT INTO usuario(login, senha, admin) VALUES(?,?,?)";
        try (Connection conexao = Cnx.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.setBoolean(3, usuario.isAdmin());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int modificar(int id, Usuario usuario) {
        String sql = "UPADETE usuario SET login = ?, senha = ?, WHERE id = ?";
        try (Connection conexao = Cnx.getConexao();
             PreparedStatement stmt = conexao
                     .prepareStatement(sql)) {
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.setBoolean(3, usuario.isAdmin());
            stmt.setInt(4, id);

            return stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean excluir(int id) {
        String sql = "DELETE FROM usuario WHERE id = ?";
        try (Connection conexao = Cnx.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override

    public Usuario mostrar(int id) {
        String sql = "SELECT id, login, senha, admin FROM usuario WHERE id = ?";
        try (Connection conexao = Cnx.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setLogin(rs.getString("login"));
                    usuario.setSenha(rs.getString("senha"));
                    usuario.setAdmin(rs.getBoolean("admin"));
                    return usuario;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT id, login, senha, admin FROM usuario";
        try (Connection conexao = Cnx.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setAdmin(rs.getBoolean("admin"));
                lista.add(usuario);
            }
        }catch(SQLException e){
            e.printStackTrace();

        }
        return lista;
    }
}




