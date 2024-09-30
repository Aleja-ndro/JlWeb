package com.ejerciOne.demo.repository;

import com.ejerciOne.demo.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductoRepositoryI extends JpaRepository<Producto,Integer> {
List<Producto> findByMarca(String marca);

}
