package controller;

import DAO.conexao;
import DAO.funcionarioDAO;
import views.funcionario;
import model.Funcionario;
import views.paciente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class funcionarioController {
    private funcionario view;

    public funcionarioController(funcionario view) {
        this.view = view;
    }

    public void autenticar(Funcionario funcionario){

        try
        {
            Connection con = new conexao().getConnection(); // Cria a conexao
            funcionarioDAO ClienteDAO = new funcionarioDAO(con);    // Cria o objeto ProdutoDAO do tipo produtoDAO na qual tem como parametro a conexao com o meu BD.
            boolean existe = ClienteDAO.autenticar(funcionario); // Após o ClienteDAO estar com conexao e solicitado para que ele faça a função autenticar que esta no clienteDAO
            if (existe)
            { // Se 'existe' valor no SELECT da função autenticar ira retornar
                paciente telaMenu = new paciente();
                telaMenu.setVisible(true);
                JOptionPane.showMessageDialog(null, "Bem vindo!");
            } else
            { // Caso não 'existe' valor no SELECT
                JOptionPane.showMessageDialog(null, "Usuario ou senha incorreto");
            }
        } catch (SQLException ex) // Caso retorne erro do banco de dados
        {
            throw new RuntimeException(ex);
        }


    }
}
