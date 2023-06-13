package src.view.cadastroforms;

import src.model.Participante;
import src.model.participantes.Discente;
import src.model.participantes.Docente;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroDiscente extends JFrame{

    //Atributos
    private JTextField textFieldNome;
    private JTextField textFieldData_de_nascimento;
    private JTextField textFieldCpf;
    private JTextField textFieldNumeroMatricula;
    private JTextField textFieldCurso;
    private JTextField textFieldTurno;

    //Método Construtor
    public CadastroDiscente(List<Participante> participantes) {

        //Definições Principais
        setTitle("Cadastro de Discente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        panel.setPreferredSize(new Dimension(450, 500));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        //Nome
        JLabel labelNome = new JLabel("Nome:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(labelNome, constraints);
        textFieldNome = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(textFieldNome, constraints);

        //Data de Nascimento
        JLabel labelDataDeNascimento = new JLabel("Data de Nascimento:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(labelDataDeNascimento, constraints);
        textFieldData_de_nascimento = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(textFieldData_de_nascimento, constraints);

        //CPF
        JLabel labelCPF = new JLabel("CPF:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(labelCPF, constraints);
        textFieldCpf = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(textFieldCpf, constraints);

        //Número de Matrícula
        JLabel labelNumeroDeMatricula = new JLabel("Número de Matrícula:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(labelNumeroDeMatricula, constraints);
        textFieldNumeroMatricula = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(textFieldNumeroMatricula, constraints);

        //Curso
        JLabel labelCurso = new JLabel("Curso:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(labelCurso, constraints);
        textFieldCurso = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(textFieldCurso, constraints);

        //Turno
        JLabel labelTurno = new JLabel("Turno:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(labelTurno, constraints);
        textFieldTurno = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 5;
        panel.add(textFieldTurno, constraints);

        //Botão Cadastrar
        JButton buttonCadastrar = new JButton("Cadastrar");
        constraints.gridx = 1;
        constraints.gridy = 8;
        panel.add(buttonCadastrar, constraints);

        buttonCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (CadastrarDiscente(participantes)) {

                    JOptionPane.showMessageDialog(null, "Discente cadastrado com sucesso!");
                    limparCampos();
                    setVisible(false);
                }
            }
        });

        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);

    }

    private void limparCampos() {
        textFieldNome.setText("");
        textFieldData_de_nascimento.setText("");
        textFieldCpf.setText("");
        textFieldNumeroMatricula.setText("");
        textFieldCurso.setText("");
        textFieldTurno.setText("");
    }

    public boolean CadastrarDiscente(List<Participante> participantes) {
        String mensagem = "Tipo de dado inválido: Campo ";
        String campo = "";

        boolean retorno = true;

        String nome = "";
        String Data_de_nascimento = "";
        String cpf = "";
        String numero_de_matricula = "";
        long numeroMatricula = 0;
        String curso = "";
        String turno = "";

        try {
            nome = textFieldNome.getText();
            Data_de_nascimento = textFieldData_de_nascimento.getText();
            cpf = textFieldCpf.getText();
            campo = "Número de Matrícula Inválido!";
            numero_de_matricula = textFieldNumeroMatricula.getText();
            numeroMatricula = Long.parseLong(numero_de_matricula);
            curso = textFieldCurso.getText();
            turno = textFieldTurno.getText();

        } catch (Exception ex) {
            retorno = false;
            JOptionPane.showMessageDialog(CadastroDiscente.this, mensagem + campo, "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        }

        if (retorno) {

            Discente discente = new Discente (nome, Data_de_nascimento, cpf, numeroMatricula, curso, turno);

            participantes.add(discente);
        }

        return retorno;
    }

}
