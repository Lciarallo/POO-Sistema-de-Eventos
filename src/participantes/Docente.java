package src.participantes;

import javax.swing.*;

// Classe de Responsabilidade do Luiz
public class Docente {

    // Atributos da classe Docente
    private String nome;
    private String dataNascimento;
    private String cpf;
    private String Titulo;
    private float CargaHorária;
    private String Turno;
    private String Especialização;
    private String UnidadeCurricular;

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

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getTitulo() {
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
    public void cadastrarDiscente(){
        setNome(JOptionPane.showInputDialog("Digite o nome do Docente:"));
        setDataNascimento(JOptionPane.showInputDialog("Digite a data de nascimento do Docente:"));
        setTitulo(JOptionPane.showInputDialog("Digite o título: "));
        setCpf(JOptionPane.showInputDialog("Digite o número de CPF do Docente:"));
        setCargaHorária(Long.parseLong(JOptionPane.showInputDialog("Digite a Carga Horária do Docente:")));
        setEspecialização(JOptionPane.showInputDialog("Digite o a Especialização do profesor:"));
        setTurno(JOptionPane.showInputDialog("Digite o turno do Profesor:"));
        JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso!");
    }
    public void mostrarDiscente(){
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


}
