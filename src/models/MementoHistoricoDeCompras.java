package models;

import java.util.ArrayList;
import java.util.List;

public class MementoHistoricoDeCompras {
    private List<ItemCompra> itens;

    public MementoHistoricoDeCompras(List<ItemCompra> itens){
        this.itens = new ArrayList<ItemCompra>();
        this.itens.addAll(itens);
    }

    public List<ItemCompra> getItens() {
        return itens;
    }
}

