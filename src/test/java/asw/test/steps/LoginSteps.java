package asw.test.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import asw.services.AgentService;
import cucumber.api.cli.Main;
import cucumber.api.java.en.Given;

public class LoginSteps {
  
  private static final Logger LOG = LoggerFactory.getLogger(Main.class);
  
  @Autowired
  private AgentService aService;
  int cantidadBase;

 
@Given("^there are no users$")
  public void there_are_no_users() throws Throwable {
    cantidadBase = aService.prueba();
  }
/*
  @When("^I create a user \"([^\"]*)\" with password \"([^\"]*)\"$")
  public void i_create_a_user_with_password(String arg1, String arg2) throws Throwable {
     aService.addAgent(new Agent(arg1, arg2, "1"));
  }

  @SuppressWarnings("deprecation")
@Then("^The number of users is (\\d+)$")
  public void the_number_of_users_is(int arg1) throws Throwable {
     Assert.assertTrue(aService.prueba()==arg1+cantidadBase);

  }
*/
  

}
