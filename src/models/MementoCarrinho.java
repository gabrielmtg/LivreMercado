package models;

import java.util.ArrayList;
import java.util.List;

public class MementoCarrinho {
    private List<ItemCompra> itens;

    public MementoCarrinho(List<ItemCompra> itens){
        this.itens = new ArrayList<>();
        this.itens.addAll(itens);
    }

    public List<ItemCompra> getItens() {
        return itens;
    }
}
