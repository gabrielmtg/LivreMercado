package models;

public class Vendedor extends Pessoa{
    private Estoque estoque;

    public Vendedor(String nome) {
        super(nome);
        estoque = new Estoque();
        Mercado.getMercado().adicioneVendedor(this);
    }

    public void adicioneProdutoAoEstoque(Produto produto, int quantidade){
        estoque.adicioneItem(produto, quantidade);
    }

    public Estoque getEstoque() {
        return estoque;
    }
}
