package src.views.cadastroforms;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.participantes.Organizador;

public class CadastroOrganizador extends JFrame {

    private JTextField textFieldNome;
    private JTextField textFieldData_nascimento;
    private JTextField textFieldCpf;
    private JTextField textFieldArea_de_atuacao;
    private JTextField textFieldDepartamento;

    public CadastroOrganizador(List<Organizador> organizadores) {

        setTitle("Cadastro de Evento");

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

        JLabel labelData = new JLabel("Data de nascimento:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(labelData, constraints);

        textFieldData_nascimento = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(textFieldData_nascimento, constraints);

        JLabel labelCpf = new JLabel("CPF:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(labelCpf, constraints);

        textFieldCpf = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(textFieldCpf, constraints);

        JLabel labelDepartamento = new JLabel("Departamento:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(labelDepartamento, constraints);

        textFieldDepartamento = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(textFieldDepartamento, constraints);

        JLabel labelArea_atuacao = new JLabel("Área de Atuação:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(labelArea_atuacao, constraints);

        textFieldArea_de_atuacao = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(textFieldArea_de_atuacao, constraints);

        JButton buttonCadastrar = new JButton("Cadastrar");
        constraints.gridx = 1;
        constraints.gridy = 5;
        panel.add(buttonCadastrar, constraints);

        buttonCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cadastrarOrganizador(organizadores);
                JOptionPane.showMessageDialog(null, "Organizador cadastrado com sucesso!");
                limparCampos();
                setVisible(false);
            }
        });

        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);

    }

    private void limparCampos() {
        textFieldDepartamento.setText("");
        textFieldArea_de_atuacao.setText("");

    }

    public void cadastrarOrganizador(List<Organizador> organizadores) {

        String nome = textFieldNome.getText();
        String data = textFieldData_nascimento.getText();
        String cpf = textFieldCpf.getText();
        String departamento = textFieldDepartamento.getText();
        String area_de_atuacao = textFieldArea_de_atuacao.getText();

        Organizador organizador = new Organizador(nome, data, cpf, area_de_atuacao, departamento);

        organizadores.add(organizador);
    }

}
