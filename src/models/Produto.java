package models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        adicionaNaCategoria(this);
    }

    public Produto(String nome, String marca, String modelo, double preco, String nomeCategoria){
        this.nome = nome;
        this.modelo = modelo;
        this.marca = marca;
        this.preco = preco;
        //this.nomeCategoria = nomeCategoria;
        this.categoria = Mercado.getMercado().pegarCategoria(nomeCategoria);
        Mercado.getMercado().pegarCategoria(nomeCategoria);
    }

    public void adicionaNaCategoria(Produto produto){
        categoria.adicioneProduto(produto);
    }

    public static void salvarProdutos(List<Produto> produtos, String pathName) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(pathName))){
            for(Produto produto : produtos){
                writer.write(produto.salvaProduto());
                writer.newLine();
            }
        }
    }

    public String salvaProduto(){
        return "PRODUTO" + ";" + nome + ";" + modelo + ";" + marca + ";" + preco + ";" + (categoria != null ? categoria.getNome() : "sem_categoria");
    }

    public static Produto carregarProduto(String linha){
        String[] atributos = linha.split(";");
        if(atributos.length != 6){
            throw new IllegalArgumentException();
        }
        assert atributos[1].trim().equals("PRODUTO");
        return new Produto(atributos[1].trim(), atributos[2].trim(), atributos[3].trim(), Double.parseDouble(atributos[4].trim()), atributos[5].trim());
    }

    public static List<Produto> carregarProdutos(String pathName) throws IOException{
        List<Produto> produtos = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(pathName))){
            String linha;
            while ((linha = reader.readLine()) != null){
                produtos.add(carregarProduto(linha));
            }
        }
        return produtos;
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
