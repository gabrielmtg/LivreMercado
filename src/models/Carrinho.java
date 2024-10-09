package models;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<ItemCompra> itens;

    public Carrinho(){
        itens = new ArrayList<ItemCompra>();
    }

    public void adicioneItem(Produto produto, Vendedor vendedor, int quantidade) throws IllegalArgumentException{
        boolean adiconado = false;
        int quantidaEmEstoque = vendedor.getEstoque().quantidadeEmEstoque(produto);
        for(ItemCompra item : itens){
            if (item.getProduto().equals(produto)){
                if(quantidaEmEstoque - (item.getQuantidade() + quantidade) >= 0){
                    itens.add(new ItemCompra(produto, vendedor, quantidade));
                    adiconado = true;
                    break;
                }else throw new IllegalArgumentException();
            }
        }
        if(!adiconado || quantidaEmEstoque - quantidade >= 0){
            itens.add(new ItemCompra(produto, vendedor, quantidade));
        }else throw new IllegalArgumentException();
    }

    public void removaItem(Produto produto){
        for(ItemCompra item : itens){
            if(item.getProduto().equals(produto)){
                itens.remove(item);
                break;
            }
        }
    }

    public List<ItemCompra> getItens() {
        return itens;
    }
}
