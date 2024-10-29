package models;

public class PagamentoBoleto implements Pagamento{

    @Override
    public void executarPagamento(double valor) {
        System.out.println("pagamentgo boleto " + valor);
    }
}
