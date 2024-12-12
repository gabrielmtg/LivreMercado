package models;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Categoria {
    private String nome;
    private List<Produto> produtos;
    private List<Categoria> subcategorias;

    public Categoria(String nome){
        this.nome = nome;
        produtos = new ArrayList<Produto>();
        subcategorias = new ArrayList<Categoria>();
        Mercado.getMercado().adicioneCategoria(this);
    }

    public void adicioneProduto(Produto produto){
        if(produto == null) throw new IllegalArgumentException();
        if(!produtos.contains(produto)){
            if(produto.getCategoria() != this || produto.getCategoria() != null){
                produto.getCategoria().produtos.remove(produto);
            }
            produtos.add(produto);
            produto.setCategoria(this);
        } else if (produto.getCategoria() == null) {
            produtos.add(produto);
            produto.setCategoria(this);
        }
    }

    public void adicioneSubcategoria(Categoria categoria){
        subcategorias.add(categoria);
    }

    public void removaSubcategoria(Categoria subcategoria, boolean permanente){
        if(!permanente){
            subcategorias.remove(subcategoria);
        }else{
            for (Produto produto : subcategoria.getProdutos()){
                this.adicioneProduto(produto);
            }
            for (Categoria subSubcategoria : subcategoria.getSubcategorias()){
                this.adicioneSubcategoria(subSubcategoria);
            }
            subcategorias.remove(subcategoria);
        }
    }

    public static void salvarObjetoCategoria(Categoria categoria, String fileName) throws IOException {
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName))) {
            writer.writeObject(categoria);
        }
    }

    public static void salvarCategoria(Categoria categoria, String fileName) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            salvarCategoriaRecursivo(categoria, writer, 0);
        }
    }

    private static void salvarCategoriaRecursivo(Categoria categoria, BufferedWriter writer, int nivel) throws IOException{
        writer.write("CATEGORIA;" + nivel + ";" + categoria.getNome());
        writer.newLine();

        for(Produto produto : categoria.getProdutos()){
            writer.write(produto.salvaProduto());
            writer.newLine();
        }

        for(Categoria subcategoria : categoria.subcategorias){
            salvarCategoriaRecursivo(subcategoria, writer, nivel + 1);
        }
    }

    public static Categoria carregarObjetoCategoria(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Categoria) reader.readObject();
        }
    }

    public static Categoria carregarCategoria(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            ArrayList<Categoria> pilha = new ArrayList<>();
            Categoria raiz = null;

            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");

                if (partes[0].equals("CATEGORIA")) {
                    int nivel = Integer.parseInt(partes[1]);
                    Categoria novaCategoria = new Categoria(partes[2]);

                    while (pilha.size() > nivel) {
                        pilha.remove(pilha.size() - 1);
                    }

                    if (pilha.isEmpty()) {
                        raiz = novaCategoria;
                    } else {
                        pilha.get(pilha.size() - 1).adicioneSubcategoria(novaCategoria);
                    }

                    pilha.add(novaCategoria);
                } else if (partes[0].equals("PRODUTO")) {
                    Produto produto = Produto.carregarProduto(linha);
                    if (!pilha.isEmpty()) {
                        pilha.get(pilha.size() - 1).adicioneProduto(produto);
                    }
                }
            }

            return raiz;
        }
    }

    public String getNome() {
        return nome;
    }

    public List<Produto> getProdutos(){
        return produtos;
    }

    public List<Categoria> getSubcategorias(){
        return subcategorias;
    }
}