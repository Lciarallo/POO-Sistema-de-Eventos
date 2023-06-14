package src.view.cadastroforms;

import src.model.Participante;
import src.model.participantes.Docente;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroDocente extends JFrame {
    private JTextField textFieldNome;
    private JTextField textFieldData_de_nascimento;
    private JTextField textFieldCpf;
    private JTextField textFieldTitulo;
    private JTextField textUnidadeCurricular;
    private JTextField textFieldCarga_horaria;
    private JTextField textFieldEspecializacao;
    private JTextField textFieldTurno;

    public CadastroDocente(List<Participante> participantes) {
        setTitle("Cadastro de Docente");
    
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        panel.setPreferredSize(new Dimension(450, 500));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        // Nome
        JLabel labelNome = new JLabel("Nome:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(labelNome, constraints);

        textFieldNome = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(textFieldNome, constraints);

        // Data de Nascimento
        JLabel labelDataDeNascimento = new JLabel("Data de Nascimento:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(labelDataDeNascimento, constraints);

        textFieldData_de_nascimento = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(textFieldData_de_nascimento, constraints);
        // CPF
        JLabel labelCPF = new JLabel("CPF:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(labelCPF, constraints);

        textFieldCpf = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(textFieldCpf, constraints);
        // Titulo
        JLabel labelTitulo = new JLabel("Titulo:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(labelTitulo, constraints);

        textFieldTitulo = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(textFieldTitulo, constraints);
        // Turno

        JLabel labelTurno = new JLabel("Turno:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(labelTurno, constraints);

        textFieldTurno = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(textFieldTurno, constraints);
        // Unidade Curricular

        JLabel labelUnidadeCurricular = new JLabel("Unidade Curricular:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(labelUnidadeCurricular, constraints);

        textUnidadeCurricular = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 5;
        panel.add(textUnidadeCurricular, constraints);
        // Especialização
        JLabel labelEspecializacao = new JLabel("Especialização:");
        constraints.gridx = 0;
        constraints.gridy = 6;
        panel.add(labelEspecializacao, constraints);

        textFieldEspecializacao = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 6;
        panel.add(textFieldEspecializacao, constraints);
        // Carga Horária
        JLabel labelCarga_horaria = new JLabel("Carga Horária:");
        constraints.gridx = 0;
        constraints.gridy = 7;
        panel.add(labelCarga_horaria, constraints);

        textFieldCarga_horaria = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 7;
        panel.add(textFieldCarga_horaria, constraints);

        JButton buttonCadastrar = new JButton("Cadastrar");
        constraints.gridx = 1;
        constraints.gridy = 8;
        panel.add(buttonCadastrar, constraints);

        buttonCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (CadastrarDocente(participantes)) {

                    JOptionPane.showMessageDialog(null, "Docente cadastrado com sucesso!");
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
        textFieldTitulo.setText("");
        textFieldData_de_nascimento.setText("");
        textFieldCpf.setText("");
        textFieldTurno.setText("");
        textFieldCarga_horaria.setText("");
        textFieldEspecializacao.setText("");

    }

    public boolean CadastrarDocente(List<Participante> participantes) {

        String mensagem = "Tipo de dado inválido: Campo ";
        String campo = "";

        boolean retorno = true;

        String nome = "";
        String titulo = "";
        String Data_de_nascimento = "";
        String cpf = "";
        String UnidadeCurricular = "";
        String CargaHoraria = "";
        float cargaH = 0;
        String Especializacao = "";
        String turno = "";

        try {

            nome = textFieldNome.getText();
            titulo = textFieldTitulo.getText();
            Data_de_nascimento = textFieldData_de_nascimento.getText();
            cpf = textFieldCpf.getText();
            UnidadeCurricular = textUnidadeCurricular.getText();
            campo = "Carga Horária Inválida";
            CargaHoraria = textFieldCarga_horaria.getText();
            cargaH = Float.parseFloat(CargaHoraria);
            Especializacao = textFieldEspecializacao.getText();
            turno = textFieldTurno.getText();

        } catch (Exception ex) {
            retorno = false;
            JOptionPane.showMessageDialog(CadastroDocente.this, mensagem + campo, "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        }

        if (retorno) {
            Docente docente = new Docente(nome, Data_de_nascimento, cpf, titulo, cargaH, turno, Especializacao,
                    UnidadeCurricular);

            participantes.add(docente);
        }

        return retorno;

    }

}
