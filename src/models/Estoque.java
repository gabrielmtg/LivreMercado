package models;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<ItemEstoque> itens;

    public Estoque(){
        itens = new ArrayList<>();
    }

    public void adicioneItem(Produto produto, int quantidade){
        boolean alterado = false;
        for (ItemEstoque item : itens){
            if (item.getProduto().equals(produto)){
                item.adicioneQuantidade(quantidade);
                alterado = true;
            }
        }
        if (!alterado){
            adicioneProduto(produto, quantidade);
        }
    }

    public void reduzaQuabtidade(Produto produto, int quantidade) throws IllegalArgumentException{
        for (ItemEstoque item : itens){
            if (item.getProduto().equals(produto)){
                if (quantidade > item.getQuantidade()) throw new IllegalArgumentException();
                else item.setQuantidade(item.getQuantidade() - quantidade);
            }
        }
    }

    public void adicioneProduto(Produto produto, int quantidade){
        ItemEstoque item = new ItemEstoque(produto, quantidade);
        itens.add(item);
    }

    public int quantidadeEmEstoque(Produto produto){
        for(ItemEstoque item : itens){
            if(item.getProduto().equals(produto)){
                return item.getQuantidade();
            }
        }
        return 0;
    }

    public void adicioneQuantidade(Produto produto, int quantidade){
        for(ItemEstoque item : itens){
            if(item.getProduto().equals(produto)){
                item.setQuantidade(item.getQuantidade() + quantidade);
            }
        }
    }

    public List<ItemEstoque> getItens() {
        return itens;
    }
}

