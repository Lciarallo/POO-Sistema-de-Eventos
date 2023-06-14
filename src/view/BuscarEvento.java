package src.view;

import src.model.Evento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BuscarEvento extends JFrame {
    private static JTextField fieldEventos;

    public BuscarEvento(List<Evento> eventos){
        setTitle("Pesquisar Evento:");
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        panel.setPreferredSize(new Dimension(500, 400));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 10, 5);


        JLabel labelEvento = new JLabel("Insira o nome do evento para pesquisar:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(labelEvento, constraints);

        fieldEventos = new JTextField();
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(fieldEventos, constraints);

        JButton buttonPesquisarEvento = new JButton("Pesquisar Evento");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        panel.add(buttonPesquisarEvento, constraints);
        buttonPesquisarEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarEventoPorNome(eventos, fieldEventos.getText());
                setVisible(true);
            }
        });

        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }



    public void buscarEventoPorNome(List<Evento> eventos, String pesquisa) {
        boolean encontrouEventos = false;

        for (Evento evento : eventos) {
            if (pesquisa.equals(evento.getNome())) {
                String mensagem =
                        "Evento: " + evento.getNome() + "\n" +
                                "Categoria: " + evento.getCategoria() + "\n" +
                                "Data Início: " + evento.getData_inicio() + "\n" +
                                "Data Fim: " + evento.getData_fim() + "\n" +
                                "Descrição: " + evento.getDescricao() + "\n" +
                                "Titulo: " + evento.getTitulo() + "\n" +
                                "Local do Evento: " + evento.getLocal() + "\n" +
                                "Limite de participantes: " + evento.getLimite_participantes() + "\n" +
                                "Carga Horária: " + evento.getCarga_horaria() + "\n" +
                                "Horário Inicio: " + evento.getHorario_inicio() + "\n";

                JOptionPane.showMessageDialog(null, mensagem);
                encontrouEventos = true;
            }
        }

        if (!encontrouEventos) {
            JOptionPane.showMessageDialog(null, "Nenhum evento encontrado com o nome fornecido.");
        }
    }


}
