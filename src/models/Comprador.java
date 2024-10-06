package models;

public class Comprador extends Pessoa {
    private Carrinho carrinho;

    public Comprador(String nome) {
        super(nome);
        carrinho = new Carrinho();
    }

    public void adicioneAoCarrinho(Produto produto, Vendedor vendedor, int quantidade){
        carrinho.adicioneItem(produto, vendedor, quantidade);
    }

    public void removerDoCarrinho(Produto produto){
        carrinho.removaItem(produto);
    }

    public void efetuarCompra(){
        //TODO
    }

    public Carrinho getCarrinho(){
        return carrinho;
    }
}
