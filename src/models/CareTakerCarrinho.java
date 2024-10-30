package models;

import java.util.ArrayList;
import java.util.List;

public class CareTakerCarrinho {
    private List<MementoCarrinho> historico;
    private List<MementoCarrinho> historicoApagado;

    public CareTakerCarrinho(){
        historico = new ArrayList<>();
        historicoApagado = new ArrayList<>();
    }

    public void saveState(MementoCarrinho memento){
        historico.add(memento);
        if(!historicoApagado.isEmpty()) apagaHistoricoApagado();
    }

    public List<ItemCompra> desfazer(){
        if(historico.size() > 1 && !historico.isEmpty()){
            MementoCarrinho itemAtual = historico.get(-1);
            historicoApagado.add(itemAtual);
            historico.remove(-1);
            return historico.get(-1).getItens();
        }else return historico.get(-1).getItens();
    }

    public List<ItemCompra> refazer(){
        if(!historicoApagado.isEmpty()){
            MementoCarrinho retorna = historicoApagado.get(0);
            historicoApagado.remove(retorna);
            return retorna.getItens();
        }else return historico.get(-1).getItens();
    }

    public void apagaHistoricoApagado(){
        historicoApagado.clear();
    }
}
