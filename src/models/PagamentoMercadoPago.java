package models;

public class PagamentoMercadoPago implements Pagamento{
    @Override
    public void pagamento(double valor) {

        System.out.println("pagamento efetuado no Mercado pago");
    }
}
