package src.aplicacao;

import src.eventos.Evento;
import src.participantes.Discente;
import src.participantes.Docente;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        // Instanciação dos objetos das classes Evento, Discente e Docente
        Evento evento = new Evento();
        Discente discente = new Discente();
        Docente docente = new Docente();

        // Menu
        int op;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog("""
                    Selecione uma opção:
                    1 - Cadastrar Evento
                    2 - Cadastrar Participante
                    3 - Listar evento cadastrado
                    4 - Listar participante cadastrado
                    5 - Sair"""));

            switch (op) {
                case 1 -> evento.cadastrarEvento();
                case 2 -> {
                    int opcao = Integer.parseInt(JOptionPane.showInputDialog("""
                    Selecione o tipo de participante:
                    1 - Cadastrar um discente
                    2 - Cadastrar um docente"""));
                    switch (opcao){
                        case 1 -> discente.cadastrarDiscente();
                        case 2 -> docente.cadastrarDocente();
                    }
                }
                case 3 -> evento.mostrarEvento();
                case 4 -> {
                    int opcao = Integer.parseInt(JOptionPane.showInputDialog("""
                    Selecione o tipo de participante:
                    1 - Listar discente cadastrado
                    2 - Listar docente cadastrado"""));
                    switch (opcao){
                        case 1 -> discente.mostrarDiscente();
                        case 2 -> docente.mostrarDocente();
                    }
                }
                case 5 -> JOptionPane.showMessageDialog(null, "Saindo...\n" +
                        "Pressione 'ENTER' para sair.");
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }while (op != 5);
    }
}
