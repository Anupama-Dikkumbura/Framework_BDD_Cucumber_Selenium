package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class LoginStepsDefinition {
    static WebDriver driver;

    @Given("User is on login page")
    public void user_is_on_login_page() {
        driver =  new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.saucedemo.com/v1/");
    }
    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

    }
    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        driver.findElement(By.id("login-button")).click();
    }
    @Then("User is navigated to home page")
    public void user_is_navigated_to_home_page() {
        assertTrue(!driver.findElements(By.xpath("//div[@class='app_logo']")).isEmpty(),"User is navigated to Home Page");
    }

    @Then("Close the browser")
    public void close_the_browser() {
        driver.close();
        driver.quit();
    }

}
