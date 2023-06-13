package src.view;

import src.controller.ControleEventos;
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

        ControleEventos controleEventos = new ControleEventos();
        JButton buttonPesquisarEvento = new JButton("Pesquisar Evento");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2; 
        panel.add(buttonPesquisarEvento, constraints);
        buttonPesquisarEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleEventos.pesquisarEvento(eventos, fieldEventos.getText());
                setVisible(true);
            }
        });




    }

}
