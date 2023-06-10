package src.view;

import javax.swing.*;

import src.model.participantes.Organizador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SelecaoOrganizadores extends JDialog {

    private JButton okButton;
    private JList<Organizador> list;
    private List<Organizador> todosOrganizadores;
    private List<Organizador> organizadoresSelecionados;

    public SelecaoOrganizadores(Frame parent, List<Organizador> organizadores) {
        super(parent, "Selecione os organizadores", true);

        todosOrganizadores = organizadores;

        DefaultListModel<Organizador> listModel = new DefaultListModel<>();
        for (Organizador organizador : todosOrganizadores) {
            listModel.addElement(organizador);
        }

        list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setCellRenderer(new CheckboxListCellRenderer());

        JLabel labelSelecionar = new JLabel("Aperte CTRL + click para selecionar mais de um organizador");
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(list), BorderLayout.CENTER);

        okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                organizadoresSelecionados = list.getSelectedValuesList();

                if (organizadoresSelecionados.isEmpty()) {
                    JOptionPane.showMessageDialog(SelecaoOrganizadores.this, "Selecione pelo menos um organizador!",
                            "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    dispose();
                }
            }
        });

        JPanel organizadoresPanel = new JPanel();
        organizadoresPanel.add(okButton);
        organizadoresPanel.add(labelSelecionar);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(organizadoresPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(parent);
    }

    public List<Organizador> getOrganizadoresSelecionados() {
        return organizadoresSelecionados;
    }

    private class CheckboxListCellRenderer extends JCheckBox implements ListCellRenderer<Object> {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            setComponentOrientation(list.getComponentOrientation());
            setFont(list.getFont());
            setBackground(list.getBackground());
            setForeground(list.getForeground());
            setSelected(isSelected);

            if (value instanceof Organizador) {
                setText(((Organizador) value).getNome());
            } else {
                setText(value.toString());
            }

            return this;
        }
    }
}
