package leo.atividade2.models;

import javafx.collections.ObservableList;

public class Pessoa {
    private String nome;
    private String cpf;
    private int idade;
    private String nasc;
    private float peso;
    private float altura;


    public Pessoa(String nome, String cpf, int idade, String nasc, float peso, float altura) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.nasc = nasc;
        this.peso = peso;
        this.altura = altura;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNasc() {
        return nasc;
    }

    public void setNasc(String nasc) {
        this.nasc = nasc;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }


}
