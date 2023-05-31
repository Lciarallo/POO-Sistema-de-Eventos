package src.forms.cadastroforms;

import javax.swing.*;
import src.eventos.Evento;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CadastroEvento extends JFrame {

    private JTextField textFieldNome;
    private JTextField textFieldTitulo;
    private JTextField textFieldDescricao;
    private JTextField textFieldCategoria;
    private JTextField textFieldLocal;
    private JTextField textFieldData_inicio;
    private JTextField textFieldData_fim;
    private JTextField textFieldHorario_inicio;
    private JTextField textFieldCarga_horaria;
    private JTextField textFieldLimite_participantes;

    public CadastroEvento(List<Evento> eventos) {

        setTitle("Cadastro de Evento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        panel.setPreferredSize(new Dimension(450, 400));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelNome = new JLabel("Nome:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(labelNome, constraints);

        textFieldNome = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(textFieldNome, constraints);

        JLabel labelTitulo = new JLabel("Título:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(labelTitulo, constraints);

        textFieldTitulo = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(textFieldTitulo, constraints);

        JLabel labelDescricao = new JLabel("Descrição:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(labelDescricao, constraints);

        textFieldDescricao = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(textFieldDescricao, constraints);

        JLabel labelCategoria = new JLabel("Categoria:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(labelCategoria, constraints);

        textFieldCategoria = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(textFieldCategoria, constraints);

        JLabel labelLocal = new JLabel("Local:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(labelLocal, constraints);

        textFieldLocal = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(textFieldLocal, constraints);

        JLabel labelData_inicio = new JLabel("Data de início:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(labelData_inicio, constraints);

        textFieldData_inicio = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 5;
        panel.add(textFieldData_inicio, constraints);

        JLabel labelData_fim = new JLabel("Data de encerramento:");
        constraints.gridx = 0;
        constraints.gridy = 6;
        panel.add(labelData_fim, constraints);

        textFieldData_fim = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 6;
        panel.add(textFieldData_fim, constraints);

        JLabel labelhorario_inicio = new JLabel("Horário:");
        constraints.gridx = 0;
        constraints.gridy = 7;
        panel.add(labelhorario_inicio, constraints);

        textFieldHorario_inicio = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 7;
        panel.add(textFieldHorario_inicio, constraints);

        JLabel labelCarga_horaria = new JLabel("Carga Horária:");
        constraints.gridx = 0;
        constraints.gridy = 8;
        panel.add(labelCarga_horaria, constraints);

        textFieldCarga_horaria = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 8;
        panel.add(textFieldCarga_horaria, constraints);

        JLabel labelLimite_participantes = new JLabel("Limite de participantes:");
        constraints.gridx = 0;
        constraints.gridy = 9;
        panel.add(labelLimite_participantes, constraints);

        textFieldLimite_participantes = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 9;
        panel.add(textFieldLimite_participantes, constraints);

        JButton buttonCadastrar = new JButton("Cadastrar");
        constraints.gridx = 1;
        constraints.gridy = 11;
        panel.add(buttonCadastrar, constraints);

        buttonCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (cadastrarEvento(eventos)) {
                    JOptionPane.showMessageDialog(null, "Evento cadastrado com sucesso!");
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar Evento!");
                }
                setVisible(false);

            }
        });

        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
    }

    private void limparCampos() {
        textFieldNome.setText("");
        textFieldTitulo.setText("");
        textFieldDescricao.setText("");
        textFieldCategoria.setText("");
        textFieldLocal.setText("");
        textFieldData_inicio.setText("");
        textFieldData_fim.setText("");
        textFieldHorario_inicio.setText("");
        textFieldCarga_horaria.setText("");
        textFieldLimite_participantes.setText("");

    }

    public boolean cadastrarEvento(List<Evento> eventos) {

        String nome = textFieldNome.getText();
        String titulo = textFieldTitulo.getText();
        String descricao = textFieldDescricao.getText();
        String categoria = textFieldCategoria.getText();
        String local = textFieldLocal.getText();
        String data_inicio = textFieldData_inicio.getText();
        String data_fim = textFieldData_fim.getText();
        String horario_inicio = textFieldHorario_inicio.getText();
        String carga_horaria = textFieldCarga_horaria.getText();
        String limite_participantes = textFieldLimite_participantes.getText();
        int limite = Integer.parseInt(limite_participantes);

        Evento evento = new Evento(nome, titulo, descricao, categoria, local, data_inicio, data_fim, horario_inicio,
                carga_horaria, limite);

        if (evento.validarEvento()) {
            eventos.add(evento);
            return true;
        } else {
            return false;
        }

    }
}
