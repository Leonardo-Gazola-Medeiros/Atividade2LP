package leo.atividade2.models;

public class Pessoa {
    private int id;
    private String nome;
    private String cpf;
    private String idade;
    private String nasc;
    private double peso;
    private double altura;
    private double imc;


    public Pessoa(String nome, String cpf, String idade, String nasc, double peso, double altura, double imc) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.nasc = nasc;
        this.peso = peso;
        this.altura = altura;
        this.imc = imc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getNasc() {
        return nasc;
    }

    public void setNasc(String nasc) {
        this.nasc = nasc;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }
}
