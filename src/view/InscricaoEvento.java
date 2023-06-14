package src.view;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.model.Evento;
import src.model.Participante;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

public class InscricaoEvento extends JFrame {

    private static JComboBox<String> fieldEventos;
    private static JComboBox<String> fieldParticipantes;

    public InscricaoEvento(List<Evento> eventos, List<Participante> participantes) {

        setTitle("Inscrição de Participantes");

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        panel.setPreferredSize(new Dimension(500, 400));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 10, 5);

        JLabel labelEvento = new JLabel("Qual evento deseja-se inscrever?");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(labelEvento, constraints);

        fieldEventos = new JComboBox<>();
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(fieldEventos, constraints);

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Evento evento : eventos) {
            model.addElement(evento.getNome());
        }

        fieldEventos.setModel(model);

        JLabel labelParticipante = new JLabel("Qual participante deseja-se inscrever?");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(labelParticipante, constraints);

        fieldParticipantes = new JComboBox<>();
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(fieldParticipantes, constraints);

        DefaultComboBoxModel<String> aux = new DefaultComboBoxModel<>();
        for (Participante participante : participantes) {
            aux.addElement(participante.getNome());
        }

        fieldParticipantes.setModel(aux);

        JButton buttonInscrever = new JButton("Inscrever");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(buttonInscrever, constraints);

        buttonInscrever.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                inscreverParticipante(eventos, participantes);
                setVisible(false);

            }
        });

        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    Evento evento = new Evento();

    public void inscreverParticipante(List<Evento> eventos, List<Participante> participantes) {

        String nomeEvento = (String) fieldEventos.getSelectedItem();
        int eventoSelecionado = encontrarEventoPorNome(nomeEvento, eventos);

        String nomeParticipante = (String) fieldParticipantes.getSelectedItem();
        int participanteSelecionado = encontrarParticipantePorNome(nomeParticipante, participantes);

        if (eventoSelecionado != -1 && participanteSelecionado != -1) {
            Evento evento = eventos.get(eventoSelecionado);
            Participante participante = participantes.get(participanteSelecionado);

            evento.getParticipantes().add(participante);

            JOptionPane.showMessageDialog(null, "Participante inscrito com sucesso no evento!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao inscrever participante no evento!");
        }

    }

    private int encontrarEventoPorNome(String nome, List<Evento> eventos) {

        for (int i = 0; i < eventos.size(); i++) {
            Evento evento = eventos.get(i);
            if (evento.getNome().equals(nome)) {
                return i;
            }
        }

        return -1;
    }

    private int encontrarParticipantePorNome(String nome, List<Participante> participantes) {

        for (int i = 0; i < participantes.size(); i++) {
            Participante participante = participantes.get(i);
            if (participante.getNome().equals(nome)) {
                return i;
            }
        }

        return -1;
    }

}
