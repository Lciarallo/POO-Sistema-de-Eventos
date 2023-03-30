package src.aplicacao;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JOptionPane.showInternalMessageDialog(null,"Bem vindo ao Event System!\nPor favor clique em 'ok' para continuar");
        Object[] pessoa = {"Discente", "Docente", "Sair"};
        int op = 0;

        while (op != 4){
            String option = JOptionPane.showInputDialog(null,"Insira a opção desejada: \n" +
                    "1 - Cadastrar Docente ou discente\n" +
                    "2 - Cadastrar Evento\n" +
                    "3 - Listar Eventos ou Pessoas\n" +
                    "4 - Sair\n");
            op = Integer.parseInt(option);
            switch (op){
                case 1:
                    op = JOptionPane.showOptionDialog(null, "Escolha uma opção a baixo: ", "Cadastro", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, pessoa, pessoa[0]);
                    switch (op) {
                        case 0:
                            JOptionPane.showInternalMessageDialog(null, "Você selecionou Discente");
                            break;
                        case 1:
                            JOptionPane.showInternalMessageDialog(null, "Você selecionou Docente");
                            break;
                        case 4:
                            break;


                    }
            }






        }
    }
}
