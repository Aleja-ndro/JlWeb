package com.ejerciOne.demo.service;

import com.ejerciOne.demo.dto.ProductoDto;
import com.ejerciOne.demo.entity.Producto;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IProductoService {
    List<Producto> listaProductos();
    Producto guardarProducto(ProductoDto productoDto);
    Producto actualizarProducto(Integer id , ProductoDto productoDto);
    void eliminarProducto(Integer id);

    List<ProductoDto>busquedaPorMarca( String marca);
}
