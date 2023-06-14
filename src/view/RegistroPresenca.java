package src.view;

import src.model.Evento;
import src.model.Participante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RegistroPresenca extends JFrame {
    private static JComboBox<String> fieldEventos;
    private static JTextField fieldParticipantes;
    private static JComboBox<String> fieldPresente;
    private Participante participante;


    public RegistroPresenca(List<Evento> eventos, Evento evento) {
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
        for (Evento i : eventos) {
            model.addElement(i.getNome());
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
                registrarPresenca(eventos, evento);
                setVisible(false);
            }
        });

        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void registrarPresenca(List<Evento> eventos, Evento evento) {
        String nomeEvento = (String) fieldEventos.getSelectedItem();
        int eventoSelecionado = encontrarEventoPorNome(nomeEvento, eventos);

        List<Participante> participantes =  evento.getParticipantes();
        List<Participante> participantesPresentes = evento.getParticipantesPresentes();

        String cpfParticipante = fieldParticipantes.getText();
        boolean participanteEncontrado = false;

        for (Participante participante : participantes) {
            if (cpfParticipante.equals(participante.getCpf())) {
                participantesPresentes.add(participante);
                participanteEncontrado = true;
                break;
            }
        }

        if (participanteEncontrado && eventoSelecionado >= 0) {
            JOptionPane.showMessageDialog(null, "Presença registrada com sucesso!");
            evento.setParticipantesPresentes(participantesPresentes);
            eventos.set(eventoSelecionado, evento);
        } else {
            if (eventoSelecionado < 0) {
                JOptionPane.showMessageDialog(null, "Erro desconhecido");
            } else {
            JOptionPane.showMessageDialog(null, "Participante não encontrado pelo CPF, por favor tente outro!");
            }
        }
    }


    private int encontrarEventoPorNome(String nome, List<Evento> eventos) {
        int i = 0;
        int aux = -1;
        for (Evento evento : eventos) {
            if (nome.equals(evento.getNome())) {
                aux = i;
            }
            i++;
        }
        return aux;
    }
}
