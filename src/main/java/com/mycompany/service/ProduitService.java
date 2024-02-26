package com.mycompany.service;

import java.util.ArrayList;
// import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.model.Produit;
import com.mycompany.repository.ProduitRepository;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

//    static ArrayList<Produit> produits = new ArrayList<>(Arrays.asList(
//     new Produit(1,"Lait",14.5),
//     new Produit(2,"Macaroni",18.5),
//     new Produit (3,"Pain", 3.99),
//     new Produit (4,"lait", 1.79),
//     new Produit (6,"fromage", 5.49),
//     new Produit (7,"poulet", 7.99),
//     new Produit (8,"poisson", 8.49),
//     new Produit (9,"yaourt", 0.99),
//     new Produit (10,"œuf", 2.29),
//     new Produit (11,"banane", 0.79)
//    ));

   public List<Produit> getProduits() {
        List <Produit> produits = new ArrayList<>();
        produitRepository.findAll().forEach(produit-> {
            produits.add(produit);
        });
        return produits;
   }

    public Produit getProduit(Long id) {
        return produitRepository.findById(id).orElse(null);
        // return produits.stream().filter(produit -> produit.getId() == id).findFirst().orElse(null); 
    }

    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    //    produits.removeIf(produit -> produit.getId() == id);
    }

    public void addProduit(Produit produit) {
        // produits.add(produit);
        produitRepository.save(produit);
    }

    public void updateProduit(Produit produit, Long id) {

        // produits.forEach(produit1 -> {
        //     if (produit1.getId() == id) {
        //         produits.set(produits.indexOf(produit1),produit);
        //     }
        // });
        produitRepository.save(produit);
    }

   
}