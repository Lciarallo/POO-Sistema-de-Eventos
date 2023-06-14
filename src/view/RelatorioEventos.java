package src.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import src.model.Evento;
import src.model.participantes.Organizador;

public class RelatorioEventos extends JFrame {

    private static JComboBox<String> fieldEventos;

    public RelatorioEventos(List<Evento> eventos) {

        setTitle("Relatório dos Eventos");

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        panel.setPreferredSize(new Dimension(500, 400));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 10, 5);

        JLabel labelEvento = new JLabel("Qual evento deseja-se obter relatório?");
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

        JButton buttonOk = new JButton("Consultar");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(buttonOk, constraints);

        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                relatorioEventos(eventos);
                setVisible(false);

            }
        });

        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void relatorioEventos(List<Evento> eventos) {

        for (Evento e : eventos) {
            String aux = "\nIndice: " + eventos.indexOf(e) + "\nNome: " + e.getNome() + "\nTítulo: " + e.getTitulo()
                    + "\nDescrição: " + e.getDescricao()
                    + "\nCategoria: " + e.getCategoria() + "\nLocal: " + e.getLocal() + "\nData de início: "
                    + e.getData_inicio() + "\nData de encerramento:" + e.getData_fim()
                    + "\nHorário: " + e.getHorario_inicio() + "h" + "\nCarga Horária: " + e.getCarga_horaria() + "h"
                    + "\nLimite de Participantes: " + e.getLimite_participantes() + "\n";

            String x = "\nOrganizadores:";
            List<Organizador> organizadoresAssociados = e.getOrganizadores();
            for (Organizador o : organizadoresAssociados) {
                x += "\n" + o.getNome();
            }

            String y = "\nParticipantes Inscritos: " + e.getParticipantes().size();

            JOptionPane.showMessageDialog(null, "Lista de Eventos:\n" + aux + x + "\n" + y + "\n");

        }

    }

}
