package ar.edu.unju.fi.tp4.service;

import ar.edu.unju.fi.tp4.model.Producto;

public interface IProductoService {
    public void agregarProducto(Producto producto);
    public Producto obtenerUltimoProducto();
    
}
