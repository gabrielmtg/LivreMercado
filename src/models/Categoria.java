package models;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private String nome;
    private List<Produto> produtos;
    private List<Categoria> subCategorias;

    public Categoria(String nome){
        this.nome = nome;
        produtos = new ArrayList<Produto>();
        subCategorias = new ArrayList<Categoria>();
    }

    public void adicioneproduto(Produto produto){
        if(!produtos.contains(produto)){
            produto.setCategoria(this);
            produtos.add(produto);
        }
    }

    public void adicioneSubcategoria(Categoria categoria){
        subCategorias.add(categoria);
    }

    public void removaSubcategoria(Categoria subcategoria, boolean permanente) throws IllegalArgumentException{
        if(!subCategorias.contains(subcategoria)){
            throw new IllegalArgumentException("Categoria nao esta na lista");
        }
        if(!permanente){
            subCategorias.remove(subcategoria);
        }else{
            List<Produto> produtosSubcategoria = new ArrayList<Produto>(subcategoria.getProdutos());
            List<Categoria> subcategoriasDaSubcategoria = new ArrayList<Categoria>(subcategoria.getSubCategorias());
            produtos.addAll(produtosSubcategoria);
            subCategorias.addAll(subcategoriasDaSubcategoria);
            subCategorias.remove(subcategoria);
        }
    }

    public String getNome() {
        return nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public List<Categoria> getSubCategorias() {
        return subCategorias;
    }
}
