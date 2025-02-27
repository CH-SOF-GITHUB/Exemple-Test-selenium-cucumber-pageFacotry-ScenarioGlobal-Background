package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageFactory.AddProductPage;
import pageFactory.CheckoutPage;
import pageFactory.LoginPage;
import pageFactory.LogoutPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SwagLabs {
    // controle et ouverture d'un navigateur Google Chrome
    WebDriver driver = new ChromeDriver();
    // déclaration d'une instance de classe LoginPage
    LoginPage loginPage = new LoginPage(driver);
    // déclaration d'une instance de classe AddProductPage
    AddProductPage addProductPage = new AddProductPage(driver);
    // déclaration d'une liste des noms des produits
    List<String> names = new ArrayList<>();
    // déclaration d'une instance de classe CheckoutPage
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    // déclaration d'une instance de classe LogoutPage
    LogoutPage logoutPage = new LogoutPage(driver);

    @Given("je suis sur le page de connexion de site web Swag Labs")
    public void je_suis_sur_le_page_de_connexion_de_site_web_swag_labs() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        // implicit wait de 10 s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("je saisie username {string}")
    public void jeSaisieUsername(String username) {
        loginPage.saisirUsername(username);
    }

    @And("je saisie password {string}")
    public void jeSaisiePassword(String password) {
        loginPage.saisirPassword(password);
    }

    @And("je clique sur login")
    public void jeCliqueSurLogin() {
        loginPage.clickLoginButton();
    }

    @Then("connexion sur le site web Swag Labs avec succès")
    public void connexionSurLeSiteWebSwagLabsAvecSuccès() {
        String url = driver.getCurrentUrl();
        if (url.equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("connexion sur le site web Swag Labs avec succès");
        } else {
            System.out.println("échec de connexion sur le site web Swag Labs");
        }
    }

    @And("je clique sur add to chart du produit {string}")
    public void jeCliqueSurAddToChartDuProduit(String produit) {
        addProductPage.clickAddToChart(produit);
        names.add(produit);
    }

    @And("je clique sur panier")
    public void jeCliqueSurPanier() {
        addProductPage.clickPanierIcon();
    }

    @Then("les produits sont ajoutés avec succès")
    public void lesProduitsSontAjoutésAvecSuccès() {
        String cartList = driver.findElement(By.className("cart_list")).getText();
        for (int i = 0; i < names.size(); i++) {
            if (cartList.contains(names.get(i))) {
                System.out.println("le produit: " + names.get(i) + " est ajouté avec succès");
            } else {
                System.out.println("échec d'ajout le produit: " + names.get(i));
            }
        }
    }

    @And("je clique sur un bouton Checkout")
    public void jeCliqueSurUnBoutonCheckout() {
        checkoutPage.clickCheckoutBtn();
    }

    @And("je saisie FirstName {string}")
    public void jeSaisieFirstName(String firstname) {
        checkoutPage.saisirFirstName(firstname);
    }

    @And("je saisie LastName {string}")
    public void jeSaisieLastName(String lastname) {
        checkoutPage.saisirLastName(lastname);
    }

    @And("je saisie ZipCode {string}")
    public void jeSaisieZipCode(String zipcode) {
        checkoutPage.saisirPostalCode(zipcode);
    }

    @And("je clique Continue")
    public void jeCliqueContinue() {
        checkoutPage.clickContinueBtn();
    }

    @And("je clique Finish")
    public void jeCliqueFinish() {
        checkoutPage.clickFinishBtn();
    }

    @Then("Confirmation et paiement des produits ajoutés avec succès")
    public void confirmationEtPaiementDesProduitsAjoutésAvecSuccès() {
        String msgconfirmation = driver.findElement(By.className("complete-text")).getText();
        if (msgconfirmation.equals("Your order has been dispatched, and will arrive just as fast as the pony can get there!")) {
            System.out.println("confirmation et paiement des produits avec succès");
        } else {
            System.out.println("échec confirmation et paiement des produits ajoutés");
        }
    }

    @And("je clique sur un bouton Burger Menu")
    public void jeCliqueSurUnBoutonBurgerMenu() {
        logoutPage.clickReactBurgerMenuBtn();

    }

    @And("je clique sur un bouton Logout")
    public void jeCliqueSurUnBoutonLogout() {
        logoutPage.clickLogoutSidebarLink();
    }

    @Then("déconnexion et redirection vers la page login")
    public void déconnexionEtRedirectionVersLaPageLogin() {
        String url = driver.getCurrentUrl();
        if (url.equals("https://www.saucedemo.com/")) {
            System.out.println("déconnexion avec succès et redirection vers la page login");
        } else {
            System.out.println("échec de déconnexion et redirection vers la page login");
        }
    }
}
