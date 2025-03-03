Feature: Tester les fonctionnalités Login, AddProduct, Checkout, Logout sur le site web Swag Labs

  Background: Tester Login sur le site web Swag Labs
    Given je suis sur le page de connexion de site web Swag Labs
    When je saisie username "standard_user"
    And je saisie password "secret_sauce"
    And je clique sur login
    Then connexion sur le site web Swag Labs avec succès
    And je clique sur add to chart du produit "Sauce Labs Backpack"
    And je clique sur add to chart du produit "Sauce Labs Bike Light"
    And je clique sur panier
    Then les produits sont ajoutés avec succès
  @Checkout
  Scenario: Tester la confirmation et le paiement des produits ajoutés aprés la connexion
    And je clique sur un bouton Checkout
    And je saisie FirstName "Chaker"
    And je saisie LastName "Ben Said"
    And je saisie ZipCode "44556"
    And je clique Continue
    And je clique Finish
    Then Confirmation et paiement des produits ajoutés avec succès
  @Logout
  @Test
  Scenario: Tester Logout sur le site web Swag Labs
    And je clique sur un bouton Burger Menu
    And je clique sur un bouton Logout
    Then déconnexion et redirection vers la page login