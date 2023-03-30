package src.aplicacao;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JOptionPane.showInternalMessageDialog(null,"Bem vindo ao Event System!\nPor favor clique em 'ok' para continuar");
        Object[] options = {"Discente", "Docente"};
        int option = JOptionPane.showOptionDialog(null, "Escolha uma opção a baixo", "Cadastro", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        switch (option) {
            case 0:
                JOptionPane.showInternalMessageDialog(null, "Você selecionou Discente");
                break;
            case 1:
                JOptionPane.showInternalMessageDialog(null, "Você selecionou Docente");
                break;
        }





    }
}
