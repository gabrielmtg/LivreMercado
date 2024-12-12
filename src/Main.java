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


//import models.*;
//
//
//class Main{
//    public static void main(String[] args){
//        Comprador comprador = new Comprador("gabriel");
//        Vendedor vendedor = new Vendedor("pedro");
//        Estoque estoque = new Estoque();
//        Categoria foda = new Categoria("foda");
//        Produto paoDeQueijo = new Produto("pao de queijo", "novo", "balduco", 3.00, foda);
//        Produto coco = new Produto("coco", "coco", "coco", 2.50, foda);
//
//        vendedor.adicioneProdutoAoEstoque(paoDeQueijo, 10);
//        comprador.adicioneProdutoAoCarrinho(paoDeQueijo, vendedor, 5);
//        comprador.adicioneProdutoAoCarrinho(paoDeQueijo, vendedor, 3);
//        //comprador.getCarrinho().desfazer();
//        vendedor.adicioneProdutoAoEstoque(coco, 5);
//        comprador.adicioneProdutoAoCarrinho(coco, vendedor, 4);
//
//        //comprador.getCarrinho().desfazer();
//        //comprador.getCarrinho().refazer();
//        //comprador.getCarrinho().refazer();
//
//        // testando adicioneProdutoAoCarrinho()
//        System.out.println("\ntestando adicioneProdutoAoCarrinho()\n");
//        for(ItemCompra item : comprador.getCarrinho().getItens()){
//            System.out.println(item.getProduto().getNome());
//            System.out.println(item.getQuantidade());
//        }
//
//        comprador.efetuarCompra();
//
//        comprador.adicioneProdutoAoCarrinho(paoDeQueijo, vendedor, 1);
//        comprador.adicioneProdutoAoCarrinho(coco, vendedor, 1);
//
//        comprador.efetuarCompra();
//
//        /*for(MementoHistoricoDeCompras mementos : comprador.getHistorico()){
//            System.out.println(mementos);
//        }*/
//
//        for(int i = 0; i < comprador.getHistorico().size(); i++){
//            System.out.printf("compra %d\n", i+1);
//            comprador.getHistorico().get(i).getItens().forEach(item -> System.out.println(item.getProduto().getNome()));
//            comprador.getHistorico().get(i).getItens().forEach(item -> System.out.println(item.getQuantidade()));
//        }
//
//        /*
//        comprador.efetuarCompra();
//
//        //testando efetuarCompra()
//        System.out.println("\ntestando efetuarCompra()\n");
//        for(ItemCompra item : comprador.getCarrinho().getItens()){
//            System.out.println(item.getProduto().getNome());
//            System.out.println(item.getQuantidade());
//        }
//
//        for(ItemEstoque item : vendedor.getEstoque().getItens()){
//            System.out.println(item.getProduto().getNome());
//            System.out.println(item.getQuantidade());
//        }
//
//        //testando adicioneProduto() -> classe categoria
//
//        System.out.println("\ntestando adicioneProduto() --> classe categoria\n");
//        System.out.println(paoDeQueijo.getCategoria().getNome());
//        Categoria legal = new Categoria("legal");
//        legal.adicioneProduto(paoDeQueijo);
//        System.out.println(paoDeQueijo.getCategoria().getNome());
//        System.out.println();
//
//        //testando removaSubcategoria()
//        System.out.println("\ntestando removaSubcategoria()\n");
//        Categoria abacaxi = new Categoria("abacaxi");
//        Categoria divertidamente = new Categoria("divertidamente");
//        abacaxi.adicioneSubcategoria(divertidamente);
//        abacaxi.adicioneProduto(coco);
//        legal.adicioneSubcategoria(foda);
//        legal.adicioneSubcategoria(abacaxi);
//
//        for (Categoria categoria : legal.getSubcategorias()){
//            System.out.println(categoria.getNome());
//        }
//        for (Produto produto : legal.getProdutos()){
//            System.out.println(produto.getNome());
//        }
//
//        legal.removaSubcategoria(abacaxi, true);
//        System.out.println();
//
//        for (Categoria categoria : legal.getSubcategorias()){
//            System.out.println(categoria.getNome());
//        }
//        for (Produto produto : legal.getProdutos()){
//            System.out.println(produto.getNome());
//        }
//
//        //legal.removaSubcategoria(abacaxi, true);
//
//        //teste Observer
//
//        comprador.adicionarProdutoDeInteresse(paoDeQueijo, vendedor, 6);
//        vendedor.getEstoque().getItemDoestoque(paoDeQueijo).adicioneQuantidade(8);
//        System.out.println();
//
//        //teste pagamento
//        PagamentoNavigator pagamento = new PagamentoNavigator(new PagamentoPix());
//        pagamento.executarPagamento(420.69);
//
//         */
//    }
//}

/**
 UFSC/CTC/INE/INE5404
 Description:

 @author Professor Cancian
 @version
 @since
 */
import models.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 Programa principal para testar leitura e escrita de produtos.
 */
public class Main {
    public static void main(String[] args) {
//         //Para o teste de persistência apenas da classe Produto em arquivo texto
//        try {
//            String filePath = "produtos.txt";
//
//            // Criação de instâncias de Produto
//            Produto p1 = new Produto("Smartphone", "Galaxy S21", "Samsung", 5000.0, "Eletrônicos");
//            Produto p2 = new Produto("Notebook", "XPS 13", "Dell", 9000.0, "Informática");
//            Produto p3 = new Produto("Smartwatch", "Apple Watch", "Apple", 3000.0, "Acessórios");
//
//            List<Produto> produtosOriginais = Arrays.asList(p1, p2, p3);
//
//            // Salvar os produtos no arquivo
//            Produto.salvarProdutos(produtosOriginais, filePath);
//            System.out.println("Produtos salvos no arquivo: " + filePath);
//
//            // Carregar os produtos do arquivo
//            List<Produto> produtosCarregados = Produto.carregarProdutos(filePath);
//            System.out.println("Produtos carregados do arquivo:");
//            for (Produto p : produtosCarregados) {
//                System.out.println(p);
//            }
//
//            // Comparar produtos originais com os carregados
//            boolean iguais = produtosOriginais.equals(produtosCarregados);
//            System.out.println("Os produtos carregados são iguais aos originais? " + (iguais ? "Sim" : "Não"));
//
//        } catch (IOException | IllegalArgumentException e) {
//            e.printStackTrace();
//        }
//
//        // Para o teste de persistência das classes Categoria e Produto, hierarquicamente, em arquivo texto
//        try {
//            String fileName = "categoria_hierarquia.txt";
//
//            // Criação da hierarquia de categorias e produtos
//            Categoria raiz = new Categoria("Raiz");
//            Categoria sub1 = new Categoria("Subcategoria 1");
//            Categoria sub2 = new Categoria("Subcategoria 2");
//            Categoria sub1_1 = new Categoria("Subcategoria 1.1");
//            Categoria sub1_2 = new Categoria("Subcategoria 1.2");
//            Categoria sub2_1 = new Categoria("Subcategoria 2.1");
//            Categoria sub2_2 = new Categoria("Subcategoria 2.2");
//
//            // Adicionando subcategorias
//            sub1.adicioneSubcategoria(sub1_1);
//            sub1.adicioneSubcategoria(sub1_2);
//            sub2.adicioneSubcategoria(sub2_1);
//            sub2.adicioneSubcategoria(sub2_2);
//            raiz.adicioneSubcategoria(sub1);
//            raiz.adicioneSubcategoria(sub2);
//
//            // Adicionando produtos às categorias
//            adicionarProdutos(raiz, "Produto Raiz");
//            adicionarProdutos(sub1, "Produto Sub1");
//            adicionarProdutos(sub2, "Produto Sub2");
//            adicionarProdutos(sub1_1, "Produto Sub1_1");
//            adicionarProdutos(sub1_2, "Produto Sub1_2");
//            adicionarProdutos(sub2_1, "Produto Sub2_1");
//            adicionarProdutos(sub2_2, "Produto Sub2_2");
//
//            // Salvar a categoria raiz
//            Categoria.salvarCategoria(raiz, fileName);
//            System.out.println("Categoria raiz salva com sucesso!");
//
//            // Carregar a categoria raiz
//            Categoria carregada = Categoria.carregarCategoria(fileName);
//            System.out.println("Categoria carregada: " + carregada);
//
//            // Comparação
//            System.out.println("Categorias iguais? " + raiz.equals(carregada));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    /**
//     Adiciona 3 produtos a uma categoria.
//
//     @param categoria A categoria à qual os produtos serão adicionados.
//     @param nomeBase  O nome base para os produtos.
//     */
//    private static void adicionarProdutos(Categoria categoria, String nomeBase) {
//        for (int i = 1; i <= 3; i++) {
//            Produto produto = new Produto(
//                    nomeBase + " " + i,
//                    "Marca " + nomeBase + " " + i,
//                    "Modelo " + nomeBase + " " + i,
//                    i * 100.0,
//                    categoria.getNome()
//            );
//            categoria.adicioneProduto(produto);
//        }

        // Criar o frame principal
        JFrame frame = new JFrame("Mercado Livre - Projeto Faculdade");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Criar o painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Criar barra de navegação superior
        JPanel navBar = new JPanel();
        navBar.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton btnHome = new JButton("Home");
        JButton btnCart = new JButton("Carrinho");
        JButton btnProfile = new JButton("Perfil");

        navBar.add(btnHome);
        navBar.add(btnCart);
        navBar.add(btnProfile);

        // Adicionar barra de busca
        JPanel searchBar = new JPanel();
        searchBar.setLayout(new FlowLayout(FlowLayout.CENTER));

        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Buscar");

        searchBar.add(searchField);
        searchBar.add(searchButton);

        // Adicionar lista de produtos (simulação com JLabel)
        JPanel productPanel = new JPanel();
        productPanel.setLayout(new GridLayout(0, 2, 10, 10)); // 2 colunas, espaço entre os itens

        for (int i = 1; i <= 6; i++) {
            JPanel product = new JPanel();
            product.setLayout(new BorderLayout());
            product.setBorder(BorderFactory.createLineBorder(Color.GRAY));

            JLabel productImage = new JLabel("Imagem do Produto " + i, SwingConstants.CENTER);
            JLabel productName = new JLabel("Produto " + i);
            JLabel productPrice = new JLabel("R$ " + (10 * i));

            JButton btnAddToCart = new JButton("Adicionar ao Carrinho");

            product.add(productImage, BorderLayout.CENTER);
            product.add(productName, BorderLayout.NORTH);
            product.add(productPrice, BorderLayout.SOUTH);
            product.add(btnAddToCart, BorderLayout.EAST);

            productPanel.add(product);
        }

        // Adicionar tudo ao painel principal
        mainPanel.add(navBar, BorderLayout.NORTH);
        mainPanel.add(searchBar, BorderLayout.CENTER);
        mainPanel.add(new JScrollPane(productPanel), BorderLayout.SOUTH);

        // Adicionar painel ao frame
        frame.add(mainPanel);

        // Tornar a janela visível
        frame.setVisible(true);
    }
}
