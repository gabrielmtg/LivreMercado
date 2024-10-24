/**
 * implementar:
 *
 * formas de pagamento
 *      -pedidos tem que ser pagos pelo cliente ao comprador
 *          -transferencia, pix, mercado pago, cartao, boleto (fazer de forma que possam ser add novas formas de pagamento) usar factory. --> feito mais ou menos
 *
 * historico de pedidos
 *
 * pesquisa por produtos similares
 *
 * ordenar produtos por preço, categotia, vendedor, (mais vendidios) (usar comparator [metodo do java])
 *
 * avisar comprador quando um produto de interesse voltar ao estoque ---> FEITO!!
 *
 * a efetuacao da compra passa por diferentes etapas
 *      -etapas: avaliando pagamento -> em preparaçao -> em transito -> entrege -> finalizado/perdido/sobReclamaçao
 *
 * cliente pode desfazer a inclusao ou exclusao de itens no carrinho
 *
 * vendedor pode desfazer acoes sobre o carrinho
 */


import models.*;

import java.util.Collections;


class Main{
    public static void main(String[] args){
        Comprador comprador = new Comprador("gabriel");
        Vendedor vendedor = new Vendedor("pedro");
        Estoque estoque = new Estoque();
        Categoria foda = new Categoria("foda");
        Produto paoDeQueijo = new Produto("pao de queijo", "novo", "balduco", 3.00, foda);
        Produto coco = new Produto("coco", "coco", "coco", 2.50, foda);

        vendedor.adicioneProdutoAoEstoque(paoDeQueijo, 10);
        comprador.adicioneProdutoAoCarrinho(paoDeQueijo, vendedor, 5);
        //comprador.adicioneAoCarrinho(paoDeQueijo, vendedor, 3);
        //comprador.removerDoCarrinho(paoDeQueijo);
        vendedor.adicioneProdutoAoEstoque(coco, 5);
        comprador.adicioneProdutoAoCarrinho(coco, vendedor, 4);

        // testando adicioneProdutoAoCarrinho()
        System.out.println("testando adicioneProdutoAoCarrinho()\n");
        for(ItemCompra item : comprador.getCarrinho().getItens()){
            System.out.println(item.getProduto().getNome());
            System.out.println(item.getQuantidade());
        }

        comprador.efetuarCompra();

        //testando efetuarCompra()
        System.out.println("\ntestando efetuarCompra()\n");
        for(ItemCompra item : comprador.getCarrinho().getItens()){
            System.out.println(item.getProduto().getNome());
            System.out.println(item.getQuantidade());
        }

        for(ItemEstoque item : vendedor.getEstoque().getItens()){
            System.out.println(item.getProduto().getNome());
            System.out.println(item.getQuantidade());
        }

        //testando adicioneProduto() -> classe categoria

        System.out.println("\ntestando adicioneProduto() --> classe categoria\n");
        System.out.println(paoDeQueijo.getCategoria().getNome());
        Categoria legal = new Categoria("legal");
        legal.adicioneProduto(paoDeQueijo);
        System.out.println(paoDeQueijo.getCategoria().getNome());
        System.out.println();

        //testando removaSubcategoria()
        System.out.println("\ntestando removaSubcategoria()\n");
        Categoria abacaxi = new Categoria("abacaxi");
        Categoria divertidamente = new Categoria("divertidamente");
        abacaxi.adicioneSubcategoria(divertidamente);
        abacaxi.adicioneProduto(coco);
        legal.adicioneSubcategoria(foda);
        legal.adicioneSubcategoria(abacaxi);

        for (Categoria categoria : legal.getSubcategorias()){
            System.out.println(categoria.getNome());
        }
        for (Produto produto : legal.getProdutos()){
            System.out.println(produto.getNome());
        }

        legal.removaSubcategoria(abacaxi, true);
        System.out.println();

        for (Categoria categoria : legal.getSubcategorias()){
            System.out.println(categoria.getNome());
        }
        for (Produto produto : legal.getProdutos()){
            System.out.println(produto.getNome());
        }

        //legal.removaSubcategoria(abacaxi, true);

        //teste Observer

        comprador.adicionarProdutoDeInteresse(paoDeQueijo, vendedor, 6);
        vendedor.getEstoque().getItemDoestoque(paoDeQueijo).adicioneQuantidade(8);

        //teste pagamento
        Pagamento pagamento = PagamentoFactory.novoPagamento(TipoPagamento.DINHEIRO);

    }
}