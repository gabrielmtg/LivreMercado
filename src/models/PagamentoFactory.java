package models;

public class PagamentoFactory {
    public static Pagamento novoPagamento(TipoPagamento tipo) throws IllegalArgumentException{
        switch (tipo){
            case BOLETO: return new PagamentoBoleto();
            case CARTAO: return new PagamentoCartao();
            case MERCADOPAGO: return new PagamentoMercadoPago();
            case PIX: return new PagamentoPix();
            case TRANSFERENCIA: return new PagamentoTransferencia();
            default: throw new IllegalArgumentException("Forma de pagamento nao aceita pelo sistema");
        }
    }
}
