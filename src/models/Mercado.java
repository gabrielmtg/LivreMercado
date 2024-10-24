package models;

import java.util.ArrayList;
import java.util.List;

public final class Mercado {
    private static Mercado mercado; //instancia padrao singleton
    private List<Categoria> categorias;
    private List<Vendedor> vendedores;
    private List<Comprador> compradores;

    public Mercado(){
        categorias = new ArrayList<Categoria>();
        vendedores = new ArrayList<Vendedor>();
        compradores = new ArrayList<Comprador>();
    }

    public void adicioneCategoria(Categoria categoria){
        if(!categorias.contains(categoria)){
            categorias.add(categoria);
        }
    }

    public void adicioneVendedor(Vendedor vendedor){
        if (!vendedores.contains(vendedor)){
            vendedores.add(vendedor);
        }
    }

    public void adicioneComprador(Comprador comprador){
        if(!compradores.contains(comprador)){
            compradores.add(comprador);
        }
    }

    //getter do padrao singleton
    public static Mercado getMercado() {
        if( mercado == null){
            mercado = new Mercado();
        }
        return mercado;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public List<Comprador> getCompradores() {
        return compradores;
    }
}
