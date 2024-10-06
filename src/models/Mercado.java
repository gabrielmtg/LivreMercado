package models;

import java.util.ArrayList;
import java.util.List;

public class Mercado {
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
