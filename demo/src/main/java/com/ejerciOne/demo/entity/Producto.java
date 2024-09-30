package com.ejerciOne.demo.entity;

import com.ejerciOne.demo.dto.ProductoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String marca;
    private String nombre;
    private double costo;
    private double precio;
    private int cantidad;



    public Producto(ProductoDto productoDto) {
        this.nombre=productoDto.getNombre();
        this.marca= productoDto.getMarca();
        this.costo=productoDto.getCosto();
        this.cantidad= productoDto.getCantidad();
        this.precio=productoDto.getPrecio();
    }
}
