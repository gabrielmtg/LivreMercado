package models;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private String nome;
    private List<Produto> produtos;
    private List<Categoria> subcategorias;

    public Categoria(String nome){
        this.nome = nome;
        produtos = new ArrayList<Produto>();
        subcategorias = new ArrayList<Categoria>();
    }

    public void adicioneProduto(Produto produto){
        produtos.add(produto);
    }

    public void adicioneSubcategoria(Categoria categoria){
        subcategorias.add(categoria);
    }

    public void removaSubcategoria(Categoria subcategoria, boolean permanente){
        if(!permanente){
            subcategorias.remove(subcategoria);
        }else{
            List<Produto> produtosNovos = new ArrayList<>(subcategoria.getProdutos());
            List<Categoria> subcategoriasNovos = new ArrayList<>(subcategoria.getSubcategorias());
            produtos.addAll(produtosNovos);
            subcategorias.addAll(subcategoriasNovos);
            subcategorias.remove(subcategoria);
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