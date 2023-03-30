package src.participantes;

import javax.swing.*;

// Classe de Responsabilidade do Daniel
public class Discente {

    // Atributos da classe Discente
    private String nome;
    private String dataNascimento;
    private String cpf;
    private long numeroMatricula;
    private String curso;
    private String turno;

    // Método construtor


    // Métodos Getters e Setters da Classe Discente
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public long getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(long numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    // Métodos da Classe Discente
    public void cadastrarDiscente(){
        setNome(JOptionPane.showInputDialog("Digite o nome do discente:"));
        setDataNascimento(JOptionPane.showInputDialog("Digite a data de nascimento do discente:"));
        setCpf(JOptionPane.showInputDialog("Digite o número de CPF do discente:"));
        setNumeroMatricula(Long.parseLong(JOptionPane.showInputDialog("Digite o número de matrícula do discente:")));
        setCurso(JOptionPane.showInputDialog("Digite o curso do aluno:"));
        setTurno(JOptionPane.showInputDialog("Digite o turno do aluno:"));
        JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso!");
    }

    public void mostrarDiscente(){
        JOptionPane.showMessageDialog(null,
                "\nDados do Discente:\n" +
                        "Nome: "+ getNome() +"\n" +
                        "Data de nascimento: " + getDataNascimento() + "\n" +
                        "CPF: "+ getCpf() +"\n" +
                        "Número de matrícula: "+ getNumeroMatricula() +"\n" +
                        "Curso: "+ getCurso() +"\n" +
                        "Turno: "+ getTurno() +"\n");
    }

}
