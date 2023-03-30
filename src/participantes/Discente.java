package src.participantes;

import javax.swing.*;
import java.util.Date;

// Classe de Responsabilidade do Daniel
public class Discente {

    // Atributos da classe Discente
    private String nome;
    private Date dataNascimento;
    private int cpf;
    private int numeroMatricula;
    private String curso;
    private String turno;

    // Métodos Getters e Setters da Classe Discente
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(int numeroMatricula) {
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

    public void cadastrarDiscente(){
        //code
    }

}
