package src.participantes;

import javax.swing.*;

// Classe de Responsabilidade do Luiz
public class Docente {


    // Atributos da classe Docente
    private String nome;
    private String dataNascimento;
    private int cpf;
    private String Titulo;
    private float CargaHorária;
    private String Turno;
    private String Especialização;
    private String UnidadeCurricular;

    //Método construtor

    public Docente(String nome, String dataNascimento, int cpf, String titulo, float cargaHorária, String turno, String especialização, String unidadeCurricular) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        Titulo = titulo;
        CargaHorária = cargaHorária;
        Turno = turno;
        Especialização = especialização;
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

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public float getCargaHorária() {
        return CargaHorária;
    }

    public void setCargaHorária(float cargaHorária) {
        CargaHorária = cargaHorária;
    }

    public String getTurno() {
        return Turno;
    }

    public void setTurno(String turno) {
        Turno = turno;
    }

    public String getEspecialização() {
        return Especialização;
    }

    public void setEspecialização(String especialização) {
        Especialização = especialização;
    }

    public String getUnidadeCurricular() {
        return UnidadeCurricular;
    }

    public void setUnidadeCurricular(String unidadeCurricular) {
        UnidadeCurricular = unidadeCurricular;
    }
    public void cadastrarDocente(){
        setNome(JOptionPane.showInputDialog("Digite o nome do Docente:"));
        setDataNascimento(JOptionPane.showInputDialog("Digite a data de nascimento do Docente:"));
        setTitulo(JOptionPane.showInputDialog("Digite o título: "));
        setCpf(Integer.parseInt(String.valueOf(Integer.parseInt(  JOptionPane.showInputDialog("Digite o número de CPF do Docente:")))));
        setCargaHorária(Long.parseLong(JOptionPane.showInputDialog("Digite a Carga Horária do Docente:")));
        setEspecialização(JOptionPane.showInputDialog("Digite o a Especialização do profesor:"));
        setTurno(JOptionPane.showInputDialog("Digite o turno do Profesor:"));
        JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso!");
    }
    public void mostrarDocente(){
        JOptionPane.showMessageDialog(null,
                "\nDados do Docente:\n" +
                        "Nome: "+ getNome() +"\n" +
                        "Data de nascimento: " + getDataNascimento() + "\n" +
                        "CPF: "+ getCpf() +"\n" +
                        "Titulo: " + getTitulo() +
                        "Especialização: "+ getEspecialização() +"\n" +
                        "Carga Horária: "+ getCargaHorária() +"\n" +
                        "Turno: "+ getTurno() +"\n");
    }

}



