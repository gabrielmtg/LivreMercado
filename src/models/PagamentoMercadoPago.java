package models;

public class PagamentoMercadoPago implements Pagamento{
    @Override
    public void executarPagamento(double valor) {
        System.out.println("pagamento efetuado no Mercado pago" + valor);
    }
}
