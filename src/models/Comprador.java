package models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        ArrayList<ItemCompra> itensComprados = new ArrayList<ItemCompra>();
        List<ItemCompra> copia = new ArrayList<>(carrinho.getItens());
       for(ItemCompra item : carrinho.getItens()){
           try{
               item.getVendedor().getEstoque().reduzaQuantidade(item.getProduto(), item.getQuantidade());
               itensComprados.add(item);
           }catch (IllegalArgumentException e){}
       }
       for(ItemCompra item : copia){
           if(itensComprados.contains(item)){
               carrinho.removaItem(item.getProduto());
           }
       }
    }

    public Carrinho getCarrinho(){
        return carrinho;
    }
}
