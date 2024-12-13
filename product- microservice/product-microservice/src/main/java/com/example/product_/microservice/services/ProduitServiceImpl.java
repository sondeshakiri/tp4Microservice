package com.example.product_.microservice.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product_.microservice.Repository.ProduitRepository;
import com.example.product_.microservice.entities.Produit;

import java.util.List;


@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public Produit creerProduit(Produit produit) {
        return produitRepository.save(produit);
    }
    // Exemple d'un champ servant à vérifier la condition
    private boolean someConditionCausingAnError = true;


    public List<Produit> obtenirTousProduits() {
        // Exemple : simuler une exception en cas de problème de réseau ou autre
        if (someConditionCausingAnError) {
            throw new RuntimeException("Erreur lors de la récupération des produits");
        }
        return produitRepository.findAll();
    }


    @Override
    public Produit obtenirProduitParId(Long id) {
        return produitRepository.findById(id).orElseThrow(() -> new RuntimeException("Produit introuvable"));
    }

    @Override
    public Produit modifierProduit(Long id, Produit produit) {
        Produit existant = obtenirProduitParId(id);
        existant.setNom(produit.getNom());
        existant.setPrix(produit.getPrix());
        existant.setQuantite(produit.getQuantite());
        return produitRepository.save(existant);
    }

    @Override
    public void supprimerProduit(Long id) {
        produitRepository.deleteById(id);
    }
}
