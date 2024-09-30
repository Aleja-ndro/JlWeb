package com.ejerciOne.demo.controller;

import com.ejerciOne.demo.dto.ProductoDto;
import com.ejerciOne.demo.entity.Producto;
import com.ejerciOne.demo.service.IProductoService;
import com.ejerciOne.demo.service.ProductoServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductosController {

private IProductoService service;

    public ProductosController(IProductoService service) {
        this.service = service;
    }

    @PutMapping("/{id}")
    public Producto actualizarPrecio
        (@PathVariable Integer id,@RequestBody ProductoDto productoDto){
        return service.actualizarProducto(id, productoDto);
}
    @GetMapping("/listarProductos")
    public List<Producto>listaProducto(){
        return service.listaProductos();
}

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarProducto(@RequestBody ProductoDto productoDto){
        return new ResponseEntity<>(service.guardarProducto(productoDto), HttpStatus.OK) ;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Integer id){
         service.eliminarProducto(id);
         return ResponseEntity.noContent().build();
    }
    @GetMapping("buscarMarca")
    public ResponseEntity<?>busquedaPorMarca(@RequestParam String marca){
        List<ProductoDto>productoDtos=service.busquedaPorMarca(marca);
        return new  ResponseEntity<>(productoDtos,HttpStatus.OK);
    }
}
