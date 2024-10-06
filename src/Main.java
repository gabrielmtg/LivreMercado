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
        comprador.adicioneAoCarrinho(paoDeQueijo, vendedor, 5);
        //comprador.adicioneAoCarrinho(paoDeQueijo, vendedor, 3);
        //comprador.removerDoCarrinho(paoDeQueijo);
        vendedor.adicioneProdutoAoEstoque(coco, 5);
        comprador.adicioneAoCarrinho(coco, vendedor, 4);

        for(ItemCompra item : comprador.getCarrinho().getItens()){
            System.out.println(item.getProduto().getNome());
            System.out.println(item.getQuantidade());
        }

        comprador.efetuarCompra();

        for(ItemCompra item : comprador.getCarrinho().getItens()){
            System.out.println(item.getProduto().getNome());
            System.out.println(item.getQuantidade());
        }

        for(ItemEstoque item : vendedor.getEstoque().getItens()){
            System.out.println(item.getProduto().getNome());
            System.out.println(item.getQuantidade());
        }
    }
}