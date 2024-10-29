package models;

public class PagamentoNavigator {
    private Pagamento pagamento;

    public PagamentoNavigator(Pagamento pagamento){
        this.pagamento = pagamento;
    }

    public void executarPagamento(double valor){
        pagamento.executarPagamento(valor);
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}
