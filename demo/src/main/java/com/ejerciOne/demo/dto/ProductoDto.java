package com.ejerciOne.demo.dto;

import com.ejerciOne.demo.entity.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductoDto {
    private String marca;
    private String nombre;
    private double costo;
    private double precio;
    private int cantidad;

    public ProductoDto(Producto producto) {
        this.marca = producto.getMarca();
        this.nombre = producto.getNombre();
        this.costo = producto.getCosto();
        this.precio = producto.getPrecio();
        this.cantidad = producto.getCantidad();
    }

}
