package models;

import java.util.ArrayList;
import java.util.List;

public class Comprador extends Pessoa{
    private Carrinho carrinho;

    public Comprador(String nome){
        super(nome);
        carrinho = new Carrinho();
    }

    public void adicioneProdutoAoCarrinho(Produto produto, Vendedor vendedor, int quantidade){
        carrinho.adicioneItem(produto, vendedor, quantidade);
    }

    public void efetuarCompra(){
        List<ItemCompra> copia = new ArrayList<>(carrinho.getItens());
        for(ItemCompra item : copia){
            Vendedor vendedor = item.getVendedor();
            try{
                vendedor.getEstoque().reduzaQuantidade(item.getProduto(), item.getQuantidade());
                carrinho.removaItem(item.getProduto());
            }catch (IllegalArgumentException e){}
        }
    }

    public Carrinho getCarrinho(){
        return carrinho;
    }

}