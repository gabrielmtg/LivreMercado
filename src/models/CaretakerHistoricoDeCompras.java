package models;

import java.util.ArrayList;
import java.util.List;

public class CaretakerHistoricoDeCompras {
    private List<MementoHistoricoDeCompras> historicoDeCompras;

    public CaretakerHistoricoDeCompras(){
        historicoDeCompras = new ArrayList<MementoHistoricoDeCompras>();
    }

    public void saveState(MementoHistoricoDeCompras compra){
        historicoDeCompras.add(compra);
    }

    public List<MementoHistoricoDeCompras> getHistoricoDeCompras() {
        return historicoDeCompras;
    }
}
