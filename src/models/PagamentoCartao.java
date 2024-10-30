package models;

public class PagamentoCartao implements Pagamento {
    @Override
    public void executarPagamento(double valor) {
        System.out.println("pagamento efetuado no Cartao" + valor);
    }
}
