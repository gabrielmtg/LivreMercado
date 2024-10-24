package models;

public class PagamentoCartao implements Pagamento{
    @Override
    public void pagamento(double valor) {

        System.out.println("pagamento efetuado no Cartao");
    }
}
