package com.ejerciOne.demo.service;

import com.ejerciOne.demo.dto.ProductoDto;
import com.ejerciOne.demo.entity.Producto;
import com.ejerciOne.demo.repository.ProductoRepositoryI;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
public
class ProductoServiceImp implements IProductoService {
    ProductoRepositoryI productoRepositoryI;

    public ProductoServiceImp(ProductoRepositoryI productoRepositoryI) {
        this.productoRepositoryI = productoRepositoryI;
    }

    @Override
    public List<Producto> listaProductos() {
        return productoRepositoryI.findAll();
    }


    @Override
    public Producto guardarProducto(ProductoDto productoDto) {
        Producto producto= new Producto(productoDto);
              return productoRepositoryI.save(producto);
    }

    @Override
    public Producto actualizarProducto(Integer id, ProductoDto productoDto) {
        Producto productoExistente=productoRepositoryI.findById(id)
                .orElseThrow(()->new RuntimeException("Producto no encontrado "+ id));
        productoExistente.setMarca(productoDto.getMarca());
        productoExistente.setCosto(productoDto.getCosto());
        productoExistente.setPrecio(productoDto.getPrecio());
        productoExistente.setCantidad(productoDto.getCantidad());
        return productoRepositoryI.save(productoExistente);
    }
    @Override
    public void eliminarProducto(Integer id) {
        Producto producto=productoRepositoryI.findById(id).orElseThrow(()->new RuntimeException("Producto "+id + " no encontrado "));
        productoRepositoryI.deleteById(id); ;
    }
    @Override
    public List<ProductoDto> busquedaPorMarca(String marca) {
        System.out.println(marca);
        List<Producto>productos=productoRepositoryI.findByMarca(marca);
        System.out.println("productos encontrados"+productos.size());
        List<ProductoDto>productoDtos= productos.stream().
           map(ProductoDto::new).collect(Collectors.toList());
        return productoDtos;
    }
    }

