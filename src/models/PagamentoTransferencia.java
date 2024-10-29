package models;

public class PagamentoTransferencia implements Pagamento{
    @Override
    public void executarPagamento(double valor) {
        System.out.println("pagamento efetuado no transferencia" + valor);
    }
}
