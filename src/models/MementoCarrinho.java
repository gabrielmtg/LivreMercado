package models;

import java.util.List;

public class MementoCarrinho {
    private List<ItemCompra> itens;

    public MementoCarrinho(List<ItemCompra> itens){
        this.itens = itens;
    }

    public List<ItemCompra> getItens() {
        return itens;
    }
}
