package models;

public class Produto {
    private String nome;
    private String modelo;
    private String marca;
    private double preco;
    private Categoria categoria;

    public Produto(String nome, String modelo, String marca, double preco, Categoria categoria){
        this.nome = nome;
        this.modelo = modelo;
        this.marca = marca;
        this.preco = preco;
        this.categoria = categoria;
    }


    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public double getPreco() {
        return preco;
    }
}
