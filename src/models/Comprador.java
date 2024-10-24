package models;

import java.util.ArrayList;
import java.util.List;

public class Comprador extends Pessoa implements Observer{
    private Carrinho carrinho;
    private List<String> notificacoes;

    public Comprador(String nome){
        super(nome);
        carrinho = new Carrinho();
        notificacoes = new ArrayList<String>();
    }

    public void adicioneProdutoAoCarrinho(Produto produto, Vendedor vendedor, int quantidade){
        carrinho.adicioneItem(produto, vendedor, quantidade);
    }

    public void efetuarCompra(){
        List<ItemCompra> copia = new ArrayList<>(carrinho.getItens());
        for(ItemCompra item : copia){
            Vendedor vendedor = item.getVendedor();
            try{
                vendedor.getEstoque().reduzaQuantidade(item.getProduto(), item.getQuantidade());
                carrinho.removaItem(item.getProduto());
            }catch (IllegalArgumentException e){}
        }
    }

    public Carrinho getCarrinho(){
        return carrinho;
    }

    @Override
    public void update(ItemEstoque item) {
        notificacoes.add(new String( "o item " + item.getProduto().getNome() + " esta com " + item.getQuantidade() + " itens no estoque"));
        System.out.println(notificacoes.size());
    }

    //metodo para o comprador pedir para ser notificado quando chegar novos produtos de interesse
    public void adicionarProdutoDeInteresse(Produto produto, Vendedor vendedor, int quantidade){
        vendedor.getEstoque().getItemDoestoque(produto).addObserver(this, quantidade);
    }
}