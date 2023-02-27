package DAO;

import model.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pacienteDAO {
    private final Connection conexao;

    public pacienteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void cadastrar(Paciente paciente)
    {
        String sql = "INSERT INTO paciente(nome, idade, documento, sintoma, condicao) VALUES (?, ?, ?, ?, ?);";
        try
        {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getIdade());
            stmt.setString(3, paciente.getDocumento());
            stmt.setString(4, paciente.getSintoma());
            stmt.setString(5, paciente.getCondicao());

            stmt.execute(); // Realiza o comando no BD.
            conexao.close();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public Paciente consultar(String documento){

        Paciente paciente = new Paciente();
        String sql = "SELECT *FROM paciente WHERE documento = ?";
        try
        {

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, documento);

            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                paciente.setNome(rs.getString("nome"));
                paciente.setIdade(rs.getString("idade"));
                paciente.setDocumento(rs.getString("documento"));
                paciente.setSintoma(rs.getString("sintoma"));
                paciente.setCondicao(rs.getString("condicao"));
                return paciente;
            }else
            {
                return null;
            }

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }

    public void editar(Paciente paciente)
    {
        String sql = "UPDATE paciente SET nome = ?, idade = ?, documento = ?, sintoma = ?, condicao = ? WHERE (documento = ?);";
        try
        {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getIdade());
            stmt.setString(3, paciente.getDocumento());
            stmt.setString(4, paciente.getSintoma());
            stmt.setString(5, paciente.getCondicao());
            stmt.setString(6, paciente.getDocumento());

            stmt.execute(); // Realiza o comando no BD.
            conexao.close();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void excluir(Paciente paciente)
    {
        String sql = "DELETE FROM paciente WHERE (documento = ?);;";
        try
        {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, paciente.getDocumento());

            stmt.execute(); // Realiza o comando no BD.
            conexao.close();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
