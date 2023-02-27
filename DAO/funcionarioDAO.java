package DAO;

import model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class funcionarioDAO {
    private final Connection con;    // Conecta com a class dao.conexao do tipo Connection

    public funcionarioDAO(Connection con)
    {
        this.con = con;
    }


    public boolean autenticar(Funcionario Funcionario) {
        String sql = "SELECT *FROM funcionario WHERE nome = ? AND senha = ?";  // Comando que ira ser inserido no BD.
        boolean check = false;
        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, Funcionario.getNome());
            stmt.setString(2, Funcionario.getSenha());

            ResultSet rs = stmt.executeQuery(); // Armazena o resultado do comando SELECT.

            return rs.next();// Se tiver algum resultado ira retornar true e se não tiver ira retornar false.




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
