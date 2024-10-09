package models;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<ItemEstoque> itens;

    public Estoque(){
        itens = new ArrayList<ItemEstoque>();
    }

    public int quantidadeEmEstoque(Produto produto){
        for(ItemEstoque item : itens){
            if(item.getProduto().equals(produto)){
                return item.getQuantidade();
            }
        }
        return 0;
    }

    public void adicioneItem(Produto produto, int quantidade){
        boolean temNoEstoque = false;
        for(ItemEstoque item : itens){
            if(item.getProduto().equals(produto)){
                item.adicioneQuantidade(quantidade);
                temNoEstoque = true;
                break;
            }
        }
        if(!temNoEstoque) itens.add(new ItemEstoque(produto, quantidade));
    }

    public void reduzaQuantidade(Produto produto, int quantidade) throws IllegalArgumentException{
        for(ItemEstoque item : itens){
            if(item.getProduto().equals(produto)){
                if(item.getQuantidade() - quantidade >= 0){
                    item.removaQuantidade(quantidade);
                }else throw new IllegalArgumentException();
                break;
            }
        }
    }

    public List<ItemEstoque> getItens() {
        return itens;
    }
}
