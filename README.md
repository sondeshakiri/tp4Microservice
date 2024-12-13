# tp4Microservice

*Intégration de Ribbon pour l'Équilibrage de Charge

Objectif

Ce projet intègre **Ribbon**, un client côté serveur pour l'équilibrage de charge, permettant de répartir les requêtes entre plusieurs instances des microservices `product-microservice` et `user-microservice`.

 Étapes principales

1. Ajout de la dépendance Ribbon 
   La dépendance Spring Cloud Netflix Ribbon a été ajoutée dans les fichiers `pom.xml` des microservices afin de permettre l'équilibrage de charge.

2. Configuration de Ribbon  
   Un RestTemplate a été configuré avec l'annotation `@LoadBalanced` dans chaque microservice pour activer l'équilibrage de charge.

3. Configuration des instances dans `application.properties` 
   Dans le fichier `application.properties` (ou `application.yml`), les instances des microservices ont été spécifiées manuellement pour permettre à Ribbon de distribuer les requêtes entre ces instances.

4. Utilisation de Ribbon dans les contrôleurs
   Le `product-microservice` utilise un **RestTemplate** équilibré par Ribbon pour faire des appels aux autres microservices, permettant ainsi une répartition des requêtes vers les instances disponibles du `user-microservice`.

 Test de l'équilibrage de charge

- **Deux instances du `user-microservice` ont été créées** et lancées sur les ports `8081` et `8082`.
- Lors de l'envoi de requêtes depuis le `product-microservice` vers le `user-microservice`, Ribbon a correctement réparti les requêtes entre les deux instances en utilisant un mécanisme round-robin.

 Résultat

Les requêtes envoyées au microservice `user-microservice` via le `product-microservice` sont maintenant réparties équitablement entre les différentes instances de `user-microservice`, garantissant ainsi une gestion optimale de la charge.

 Conclusion

Ce projet met en œuvre l'équilibrage de charge avec **Ribbon** pour améliorer la résilience et la scalabilité de l'architecture microservices, en permettant une distribution efficace des requêtes entre plusieurs instances.
