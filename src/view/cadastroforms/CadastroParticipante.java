package src.view.cadastroforms;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import src.model.Participante;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CadastroParticipante extends JFrame {

    public CadastroParticipante(List<Participante> participantes) {

        setTitle("Cadastro de Participantes");

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        panel.setPreferredSize(new Dimension(400, 250));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 10, 5);

        JButton buttonCadastrarDocente = new JButton("Cadastrar Docente");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(buttonCadastrarDocente, constraints);

        JButton buttonCadastrarDiscente = new JButton("Cadastrar Discente");
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(buttonCadastrarDiscente, constraints);

        buttonCadastrarDocente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroDocente cadastroDocente = new CadastroDocente(participantes);
                cadastroDocente.setVisible(true);
            }
        });

        buttonCadastrarDiscente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
    }
}
