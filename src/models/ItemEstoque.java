package models;

public class ItemEstoque {
    private Produto produto;
    private int quantidade;

    public ItemEstoque(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public void adicioneQuantidade(int quantidade){
        this.quantidade += quantidade;
    }

    public void removaQuantidade(int quantidade) throws IllegalCallerException{
        if(quantidade > this.quantidade){
            throw new IllegalCallerException();
        }
        else{
            this.quantidade -= quantidade;
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int novaQuantidade) {
        this.quantidade = novaQuantidade;
    }

    public Produto getProduto() {
        return produto;
    }
}
