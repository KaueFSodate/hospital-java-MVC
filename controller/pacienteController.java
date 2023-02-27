package controller;

import DAO.conexao;
import DAO.pacienteDAO;
import model.Paciente;
import views.funcionario;
import views.paciente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class pacienteController {
    private paciente view;

    public pacienteController(paciente view) {
        this.view = view;
    }

    public void cadastrar(Paciente paciente){

        try {
            Connection con = new conexao().getConnection(); // Cria a conexao
            pacienteDAO pacie = new pacienteDAO(con);
            pacie.cadastrar(paciente);
            JOptionPane.showMessageDialog(null, "Paciente cadastrado");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void editar(Paciente paciente){

        try {
            Connection con = new conexao().getConnection(); // Cria a conexao
            pacienteDAO pacie = new pacienteDAO(con);
            pacie.editar(paciente);
            JOptionPane.showMessageDialog(null, "Paciente editado");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void excluir(Paciente paciente){

        try {
            Connection con = new conexao().getConnection(); // Cria a conexao
            pacienteDAO pacie = new pacienteDAO(con);
            pacie.excluir(paciente);
            JOptionPane.showMessageDialog(null, "Paciente excluido");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
