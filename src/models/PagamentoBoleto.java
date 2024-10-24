package models;

public class PagamentoBoleto implements Pagamento{
    @Override
    public void pagamento(double valor) {
        System.out.println("pagamento efetuado no Boleto");
    }
}
