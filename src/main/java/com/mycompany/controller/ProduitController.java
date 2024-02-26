package com.mycompany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import com.mycompany.model.Produit;
import com.mycompany.service.ProduitService;

@RestController
@CrossOrigin(origins = "*")
// @RequestMapping("/produits")
public class ProduitController {
    
    @Autowired
    private ProduitService produitService;

    @RequestMapping("/produits")
    public List<Produit> getProduits() {
       return produitService.getProduits();   
    }

    @RequestMapping("/produits/{id}")
    public Produit getProduitById(@PathVariable Long id) {
        return produitService.getProduit(id);
    }

    @RequestMapping(value = "/produits", method = RequestMethod.POST)
    public void addProduit(@RequestBody Produit produit) {
        produitService.addProduit(produit);
    }

    @RequestMapping(value = "/produits/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody Produit produit, @PathVariable Long id){
        produitService.updateProduit(produit,id);
    }

    @RequestMapping(value = "/produits/{id}", method = RequestMethod.DELETE)
    public void deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
    }

}
