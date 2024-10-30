package models;

public class Compra {
    private Pagamento formaDepagamento;

    public void realizarPagamento(double valor){
        formaDepagamento.executarPagamento(valor);
    }

    public void setFormaDepagamento(Pagamento formaDepagamento) {
        this.formaDepagamento = formaDepagamento;
    }

}
