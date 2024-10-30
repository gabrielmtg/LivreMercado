package models;

public class PagamentoPix implements Pagamento {
    @Override
    public void executarPagamento(double valor) {
        System.out.println("pagamento efetuado no Pix" + valor);
    }
}
