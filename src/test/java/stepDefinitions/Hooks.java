package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before("@Checkout")
    public void avantChaqueScenario(){
        System.out.println("début du scénario");
    }
    @After("@Checkout")
    public void apresChaqueScenario(){
        System.out.println("aprés chaque scénario");
    }
}
