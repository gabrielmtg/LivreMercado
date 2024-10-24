package models;

public class PagamentoPix implements Pagamento{
    @Override
    public void pagamento(double valor) {

        System.out.println("pagamento efetuado no Pix");
    }
}
