package views;

import DAO.conexao;
import DAO.pacienteDAO;
import controller.pacienteController;
import model.Paciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class paciente extends JFrame{
    private JPanel telaPaciente;
    private JTextField tfNome;
    private JTextField tfIdade;
    private JTextField tfDocumento;
    private JTextField tfSintoma;
    private JTextField tfCondicao;
    private JButton btnCadastrar;
    private JButton btnConsultar;
    private JButton btnEditar;
    private JButton btnExcluir;
    private JButton btnLimpar;

    public paciente(){

        setContentPane(telaPaciente);  //Atributos da janela feitas pelo .form
        setTitle("Paciente");
        setSize(450, 330);
        setLocation(900, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Paciente paciente = new Paciente();
                paciente.setNome(tfNome.getText());
                paciente.setIdade(tfIdade.getText());
                paciente.setDocumento(tfDocumento.getText());
                paciente.setSintoma(tfSintoma.getText());
                paciente.setCondicao(tfCondicao.getText());

                pacienteController pacientecontrol = new pacienteController(null);
                pacientecontrol.cadastrar(paciente);

            }
        });


        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String  documento = tfDocumento.getText();

                try {
                    Connection con = new conexao().getConnection();
                    pacienteDAO PacienteDAO = new pacienteDAO(con);
                    Paciente paciente = PacienteDAO.consultar(documento);
                    if (paciente == null) {

                    } else {
                        tfNome.setText(paciente.getNome());
                        tfIdade.setText(paciente.getIdade());
                        tfDocumento.setText(paciente.getDocumento());
                        tfSintoma.setText(paciente.getSintoma());
                        tfCondicao.setText(paciente.getCondicao());

                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Paciente paciente = new Paciente();

                paciente.setNome(tfNome.getText());
                paciente.setIdade(tfIdade.getText());
                paciente.setDocumento(tfDocumento.getText());
                paciente.setSintoma(tfSintoma.getText());
                paciente.setCondicao(tfCondicao.getText());

                pacienteController pacienteControl = new pacienteController(null);
                pacienteControl.editar(paciente);
            }
        });


        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Paciente paciente = new Paciente();
                paciente.setDocumento(tfDocumento.getText());

                pacienteController pacienteControl = new pacienteController(null);
                pacienteControl.excluir(paciente);
            }
        });


        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfNome.setText("");
                tfIdade.setText("");
                tfDocumento.setText("");
                tfSintoma.setText("");
                tfCondicao.setText("");
            }
        });
    }
}
