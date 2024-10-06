package models;


public class ItemCompra {
    private Produto produto;
    private Vendedor vendedor;
    private int quantidade;

    public ItemCompra(Produto produto, Vendedor vendedor, int quantidade) throws IllegalArgumentException{
        if(produto != null){
            this.produto = produto;
        }else throw new IllegalArgumentException();
        if (vendedor != null){
            this.vendedor = vendedor;
        }else throw new IllegalArgumentException();
        if (quantidade >=0){
            this.quantidade = quantidade;
        }else throw new IllegalArgumentException();
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }
}
