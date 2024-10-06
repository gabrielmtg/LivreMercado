package models;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<ItemCompra> itens;

    public Carrinho(){
        itens = new ArrayList<ItemCompra>();
    }

    public void adicioneItem(Produto produto, Vendedor vendedor, int quantidade) throws IllegalArgumentException {
        boolean valido = false;
        boolean temNoEstoque = false;
        int quantidadeNoEstoque = 0;

        for (ItemEstoque item : vendedor.getEstoque().getItens()){
            if (item.getProduto().equals(produto)) {
                temNoEstoque = true;
                quantidadeNoEstoque = item.getQuantidade();
            }
        }

        if (!temNoEstoque) throw new IllegalArgumentException("nao tem no estoque");

        for (ItemCompra item : itens){
            boolean n = item.getProduto().equals(produto);
            if (n){
                if (quantidadeNoEstoque - (item.getQuantidade() + quantidade) >= 0){
                    itens.add(new ItemCompra(produto, vendedor, quantidade));
                    valido = true;
                }
            }else if(quantidadeNoEstoque - quantidade >= 0) {
                itens.add(new ItemCompra(produto, vendedor, quantidade));
                valido = true;
            }
        }

        /*for (ItemEstoque item : vendedor.getEstoque().getItens()) {
            if (item.getProduto().equals(produto)) {
                if (itens.contains(item)) {
                    int quantidadeCarrinho = item.getQuantidade();
                    if (item.getQuantidade() - (quantidadeCarrinho + quantidade) >= 0) {
                        itens.add(new ItemCompra(produto, vendedor, quantidade));
                        valido = true;
                    }
                } else {
                    if (item.getQuantidade() - quantidade >= 0) {
                        itens.add(new ItemCompra(produto, vendedor, quantidade));
                        valido = true;
                    }
                }
            }
        }*/
        if (!valido) throw new IllegalArgumentException("numero maior que do estoque");
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
