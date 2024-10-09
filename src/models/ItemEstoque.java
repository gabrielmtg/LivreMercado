package models;

public class ItemEstoque {
    private Produto produto;
    private int quantidade;

    public ItemEstoque(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public void adicioneQuantidade(int quantidade){
        setQuantidade(this.quantidade + quantidade);
    }

    public void removaQuantidade(int quantidade) throws IllegalArgumentException{
        if(getQuantidade() - quantidade >= 0){
            setQuantidade(getQuantidade() - quantidade);
        }else throw new IllegalArgumentException();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }
}
