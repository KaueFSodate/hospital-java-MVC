package views;

import controller.funcionarioController;
import model.Funcionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class funcionario extends JFrame{
    private JTextField tfNome;
    private JTextField tfSenha;
    private JButton btnAcessar;
    private JButton btnLimpar;
    private JPanel telaFuncionario;

    public funcionario(){

        setContentPane(telaFuncionario);  //Atributos da janela feitas pelo .form
        setTitle("Login");
        setSize(400, 330);
        setLocation(900, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        btnAcessar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Funcionario funcionario = new Funcionario();
                funcionario.setNome(tfNome.getText());
                funcionario.setSenha(tfSenha.getText());

                funcionarioController funcionarioControl = new funcionarioController(null);
                funcionarioControl.autenticar(funcionario);
            }
        });
    }



    public static void main (String[] args)
    {
        funcionario tela = new funcionario();     // Vai iniciar a tela de login.
        tela.setVisible(true);
    }
}
