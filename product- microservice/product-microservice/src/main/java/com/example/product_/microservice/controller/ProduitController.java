package com.example.product_.microservice.controller;

import com.example.product_.microservice.entities.Produit;
import com.example.product_.microservice.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;



import java.util.List;

@RestController
@RequestMapping("/products")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @Autowired
    private RestTemplate restTemplate;

    // Exemple de méthode pour récupérer les détails d'un utilisateur via le service utilisateur
    @GetMapping("/userDetails/{userId}")
    public String getUserDetails(@PathVariable Long userId) {
        String userServiceUrl = "http://user-microservice/users/" + userId; // L'URL logique du service utilisateur (avec Ribbon)
        return restTemplate.getForObject(userServiceUrl, String.class);
    }

    // Crée un produit
    @PostMapping
    public Produit createProduct(@RequestBody Produit produit) {
        return produitService.creerProduit(produit);
    }

    // Récupère tous les produits
    @GetMapping
    public List<Produit> getAllProducts() {
        return produitService.obtenirTousProduits();
    }
}
