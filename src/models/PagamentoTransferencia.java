package models;

public class PagamentoTransferencia implements Pagamento{
    @Override
    public void pagamento(double valor) {

        System.out.println("pagamento efetuado no transferencia");
    }
}
