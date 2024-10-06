package models;

import java.util.List;

public class Categoria {
    private String nome;
    private List<Produto> produtos;
    private List<Categoria> subCategorias;

    public Categoria(String nome){
        this.nome = nome;
    }

    public void adicioneproduto(Produto produto){
        produtos.add(produto);
    }

    public void AdicioneSubcategorias(Categoria categoria){
        subCategorias.add(categoria);
    }

    public void removaSubcategoria(Categoria subcategoria){
        //TODO
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
