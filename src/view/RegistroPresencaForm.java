package src.view;

import src.model.Evento;
import src.model.Participante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RegistroPresencaForm extends JFrame {
    private static JComboBox<String> fieldEventos;
    private static JTextField fieldParticipantes;
    private static JComboBox<String> fieldPresente;
    private Participante participante;


    public RegistroPresencaForm(List<Evento> eventos, List<Participante> participantes, List<Participante> participantesPresentes) {
            setTitle("Registro de presença");


        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        panel.setPreferredSize(new Dimension(500, 400));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 10, 5);

        JLabel labelEvento = new JLabel("Qual evento você quer registrar presença?");
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

        JLabel labelParticipante = new JLabel("Insira o cpf do participante presente:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(labelParticipante, constraints);

        fieldParticipantes = new JTextField();
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(fieldParticipantes, constraints);

        JButton buttonRegistrarPresenca = new JButton("Registrar Presença");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2; 
        panel.add(buttonRegistrarPresenca, constraints);
        buttonRegistrarPresenca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarPresenca(eventos, participantes, participantesPresentes);
                setVisible(false);
            }
        });

        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void registrarPresenca(List<Evento> eventos, List<Participante> participantes, List<Participante> participantesPresentes) {
        String nomeEvento = (String) fieldEventos.getSelectedItem();
        int eventoSelecionado = encontrarEventoPorNome(nomeEvento, eventos);

        String cpfParticipante = fieldParticipantes.getText();
        boolean participanteEncontrado = false;
        for (Participante participante : participantes) {
            if (cpfParticipante.equals(participante.getCpf())) {
                participantesPresentes.add(participante);
                participanteEncontrado = true;
                break;
            }
        }

        if (participanteEncontrado) {
            JOptionPane.showMessageDialog(null, "Presença registrada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Participante não encontrado pelo CPF, por favor tente outro!");
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
}
