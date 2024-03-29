package src.view.cadastroforms;

import javax.swing.*;

import src.model.Evento;
import src.model.participantes.Organizador;
import src.view.SelecaoOrganizadores;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
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

    private List<Organizador> todosOrganizadores;
    private DefaultListModel<Organizador> listModel;
    private List<Organizador> organizadoresSelecionados;

    private SelecaoOrganizadores selecaoOrganizadores;
    private boolean botaoPesquisarClicado = false;

    public CadastroEvento(List<Evento> eventos, List<Organizador> organizadores) {

        this.todosOrganizadores = new ArrayList<>(organizadores);
        listModel = new DefaultListModel<>();

        setTitle("Cadastro de Evento");

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        panel.setPreferredSize(new Dimension(500, 500));

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

        JLabel labelData_inicio = new JLabel("Data de início (dd/mm/yyyy): ");
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

        JLabel labelOrganizadores = new JLabel("Organizadores:");
        constraints.gridx = 0;
        constraints.gridy = 10;
        panel.add(labelOrganizadores, constraints);

        JButton pesquisar = new JButton();
        constraints.gridx = 1;
        constraints.gridy = 10;
        ImageIcon icon = new ImageIcon("src/img/lupa.png");
        pesquisar.setIcon(icon);

        panel.add(pesquisar, constraints);

        JButton buttonCadastrar = new JButton("Cadastrar");
        constraints.gridx = 1;
        constraints.gridy = 11;
        panel.add(buttonCadastrar, constraints);

        buttonCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (validarCampos() && botaoPesquisarClicado) {

                    if (cadastrarEvento(eventos)) {
                        JOptionPane.showMessageDialog(null, "Evento cadastrado com sucesso!");
                        limparCampos();
                        setVisible(false);
                    }

                } else {
                    JOptionPane.showMessageDialog(CadastroEvento.this, "Preencha todos os campos.", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        pesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                selecaoOrganizadores = new SelecaoOrganizadores(null, todosOrganizadores);
                selecaoOrganizadores.setVisible(true);

                organizadoresSelecionados = selecaoOrganizadores.getOrganizadoresSelecionados();
                if (organizadoresSelecionados != null) {
                    listModel.clear();
                    organizadoresSelecionados.forEach(listModel::addElement);
                } else {
                    listModel.clear();
                }

                botaoPesquisarClicado = true;

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

    private boolean validarCampos() {
        if (textFieldNome.getText().isEmpty()) {
            return false;
        }
        if (textFieldTitulo.getText().isEmpty()) {
            return false;
        }
        if (textFieldDescricao.getText().isEmpty()) {
            return false;
        }
        if (textFieldCategoria.getText().isEmpty()) {
            return false;
        }
        if (textFieldLocal.getText().isEmpty()) {
            return false;
        }

        if (textFieldData_inicio.getText().isEmpty()) {
            return false;
        }

        if (textFieldData_fim.getText().isEmpty()) {
            return false;
        }

        if (textFieldHorario_inicio.getText().isEmpty()) {
            return false;
        }
        if (textFieldCarga_horaria.getText().isEmpty()) {
            return false;
        }
        if (textFieldLimite_participantes.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean cadastrarEvento(List<Evento> eventos) {

        String mensagem = "Tipo de dado inválido: Campo ";
        String campo = "";

        boolean retorno = true;

        String nome = "";
        String titulo = "";
        String descricao = "";
        String categoria = "";
        String local = "";
        String data_inicio = "";
        String data_fim = "";
        String horario_inicio = "";
        String carga_horaria = "";
        float cargaHoraria = 0;
        String limite_participantes = "";
        int limite = 0;
        LocalDate dataini, datafim;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {

            campo = "Nome inválido";
            nome = textFieldNome.getText();
            campo = "Título inválido";
            titulo = textFieldTitulo.getText();
            campo = "Descrição inválida";
            descricao = textFieldDescricao.getText();
            campo = "Categoria inválido";
            categoria = textFieldCategoria.getText();
            campo = "Local inválido";
            local = textFieldLocal.getText();
            campo = "Data Inicial inválida";
            data_inicio = textFieldData_inicio.getText();
            dataini = LocalDate.parse(data_inicio, formatter);
            campo = "Data Final inválida";
            data_fim = textFieldData_fim.getText();
            datafim = LocalDate.parse(data_fim, formatter);
            campo = "Horário Inicial inválido";
            horario_inicio = textFieldHorario_inicio.getText();
            campo = "Carga Horária inválida";
            carga_horaria = textFieldCarga_horaria.getText();
            campo = "Carga Horária inválida";
            cargaHoraria = Float.parseFloat(carga_horaria);
            campo = "Limite de Participantes inválido";
            limite_participantes = textFieldLimite_participantes.getText();
            campo = "Limite de Participantes inválido";
            limite = Integer.parseInt(limite_participantes);

        } catch (Exception ex) {
            retorno = false;
            JOptionPane.showMessageDialog(CadastroEvento.this, mensagem + campo, "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        }

        if (retorno) {
            Evento evento = new Evento(nome, titulo, descricao, categoria, local, data_inicio, data_fim, horario_inicio,
                    cargaHoraria, limite);
            if (evento.validarEvento()) {
                evento.getOrganizadores().addAll(organizadoresSelecionados);
                eventos.add(evento);
            } else {
                JOptionPane.showMessageDialog(CadastroEvento.this, "Intervalo de datas inválido", "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                retorno = false;
            }
        }

        return retorno;

    }
}
