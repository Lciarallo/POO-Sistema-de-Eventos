package src.participantes;

import javax.swing.*;

// Classe de Responsabilidade do Luiz
public class Docente {


    // Atributos da classe Docente
    private String nome;
    private String dataNascimento;
    private String cpf;
    private String titulo;
    private String CargaHoraria;
    private String Turno;
    private String Especializacao;
    private String UnidadeCurricular;

    //Método construtor

    public Docente(String nome, String dataNascimento, String cpf, String titulo, String CargaHoraria, String turno, String Especializacao, String unidadeCurricular) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.titulo = titulo;
        this.CargaHoraria = CargaHoraria;
        this.Turno = turno;
        this.Especializacao = Especializacao;
        UnidadeCurricular = unidadeCurricular;
    }

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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCargaHoraria() {
        return CargaHoraria;
    }

    public void setCargaHoraria(String CargaHoraria) {
        this.CargaHoraria = CargaHoraria;
    }

    public String getTurno() {
        return Turno;
    }

    public void setTurno(String turno) {
        Turno = turno;
    }

    public String getEspecializacao() {
        return Especializacao;
    }

    public void setEspecializacao(String Especializacao) {
        this.Especializacao = Especializacao;
    }

    public String getUnidadeCurricular() {
        return UnidadeCurricular;
    }

    public void setUnidadeCurricular(String unidadeCurricular) {
        this.UnidadeCurricular = unidadeCurricular;
    }
    public void cadastrarDocente(){
        setNome(JOptionPane.showInputDialog("Digite o nome do Docente:"));
        setDataNascimento(JOptionPane.showInputDialog("Digite a data de nascimento do Docente:"));
        setTitulo(JOptionPane.showInputDialog("Digite o título: "));
        setCpf(JOptionPane.showInputDialog("Digite o número de CPF do Docente:"));
        setCargaHoraria(JOptionPane.showInputDialog("Digite a Carga Horária do Docente:"));
        setEspecializacao(JOptionPane.showInputDialog("Digite o a Especializacao do Docente:"));
        setTurno(JOptionPane.showInputDialog("Digite o turno do Docente:"));
        setUnidadeCurricular(JOptionPane.showInputDialog(null,"Digite a unidade curricular: "));
        JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso!");
    }
    public void mostrarDocente(){
        JOptionPane.showMessageDialog(null,
                "\nDados do Docente:\n" +
                        "Nome: "+ getNome() +"\n" +
                        "Data de nascimento: " + getDataNascimento() + "\n" +
                        "CPF: "+ getCpf() +"\n" +
                        "Titulo: " + getTitulo() +"\n"+
                        "Especializacao: "+ getEspecializacao() +"\n" +
                        "Carga Horária: "+ getCargaHoraria() +"\n" +
                        "Turno: "+ getTurno() +"\n");
    }

}



