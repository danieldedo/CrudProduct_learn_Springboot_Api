package com.mycompany.repository;

import org.springframework.data.repository.CrudRepository;

import com.mycompany.model.Produit;



public interface ProduitRepository extends CrudRepository<Produit, Long> {
    
}
