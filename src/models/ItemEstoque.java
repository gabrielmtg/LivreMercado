package models;

import java.util.HashMap;

public class ItemEstoque {
    private Produto produto;
    private int quantidade;
    private HashMap<Observer, Integer> interessados;

    public ItemEstoque(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
        interessados = new HashMap<Observer, Integer>();
    }

    public void adicioneQuantidade(int quantidade){
        setQuantidade(this.quantidade + quantidade);
        notificaInteressados();

    }

    public void removaQuantidade(int quantidade) throws IllegalArgumentException{
        if(getQuantidade() - quantidade >= 0){
            setQuantidade(getQuantidade() - quantidade);
        }else throw new IllegalArgumentException("voce removeu uma quantidade maior que a do estoque");
    }

    public void addObserver(Observer usuario, int quantidade){
        interessados.put(usuario, quantidade);
    }

    public void removeObserver(Observer usuario) throws IllegalArgumentException{
        if(interessados.containsKey(usuario)){
            interessados.remove(usuario);
        }else throw new IllegalArgumentException("Comprador nao encontrado na lista de interessados");
    }

    public void notificaInteressados(){
        for(Observer interessado : interessados.keySet()){
            if(interessados.get(interessado) <= quantidade) {
                interessado.update(this);
                removeObserver(interessado);
            }
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        notificaInteressados();
    }

    public Produto getProduto() {
        return produto;
    }
}
