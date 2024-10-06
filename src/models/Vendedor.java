package models;

public class Vendedor extends Pessoa{
    private Estoque estoque;

    public Vendedor(String nome){
        super(nome);
        estoque = new Estoque();
    }

    public void adicioneProdutoAoEstoque(Produto produto, int quantidade){
        estoque.adicioneProduto(produto, quantidade);
    }

    public Estoque getEstoque() {
        return estoque;
    }
}
