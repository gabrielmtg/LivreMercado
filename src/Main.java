/**
 * implementar:
 *
 * formas de pagamento
 *      -pedidos tem que ser pagos pelo cliente ao comprador -> usar mediator com o mercado
 *          -transferencia, pix, mercado pago, cartao, boleto (fazer de forma que possam ser add novas formas de pagamento) usar strategy. --> feito
 *
 * historico de pedidos -> usar memento -> feito
 *
 * pesquisa por produtos similares -> usar Iterator
 *
 * ordenar produtos por preço, categotia, vendedor, (mais vendidios) (usar comparator [metodo do java])
 *
 * avisar comprador quando um produto de interesse voltar ao estoque ---> FEITO!!
 *
 * a efetuacao da compra passa por diferentes etapas -> usar state
 *
 *      -etapas: avaliando pagamento -> em preparaçao -> em transito -> entrege -> finalizado/perdido/sobReclamaçao
 *
 * cliente pode desfazer a inclusao ou exclusao de itens no carrinho -> usar memenro -> feito
 *
 * vendedor pode desfazer acoes sobre o carrinho -> usar memento
 */


import models.*;


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
        comprador.adicioneProdutoAoCarrinho(paoDeQueijo, vendedor, 3);
        //comprador.getCarrinho().desfazer();
        vendedor.adicioneProdutoAoEstoque(coco, 5);
        comprador.adicioneProdutoAoCarrinho(coco, vendedor, 4);

        //comprador.getCarrinho().desfazer();
        //comprador.getCarrinho().refazer();
        //comprador.getCarrinho().refazer();

        // testando adicioneProdutoAoCarrinho()
        System.out.println("\ntestando adicioneProdutoAoCarrinho()\n");
        for(ItemCompra item : comprador.getCarrinho().getItens()){
            System.out.println(item.getProduto().getNome());
            System.out.println(item.getQuantidade());
        }

        comprador.efetuarCompra();

        comprador.adicioneProdutoAoCarrinho(paoDeQueijo, vendedor, 1);
        comprador.adicioneProdutoAoCarrinho(coco, vendedor, 1);

        comprador.efetuarCompra();

        /*for(MementoHistoricoDeCompras mementos : comprador.getHistorico()){
            System.out.println(mementos);
        }*/

        for(int i = 0; i < comprador.getHistorico().size(); i++){
            System.out.printf("compra %d\n", i+1);
            comprador.getHistorico().get(i).getItens().forEach(item -> System.out.println(item.getProduto().getNome()));
            comprador.getHistorico().get(i).getItens().forEach(item -> System.out.println(item.getQuantidade()));
        }

        /*
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
        System.out.println();

        //teste pagamento
        PagamentoNavigator pagamento = new PagamentoNavigator(new PagamentoPix());
        pagamento.executarPagamento(420.69);

         */
    }
}

