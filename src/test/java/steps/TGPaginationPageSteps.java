package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.TechGlobalBasePage;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalPaginationPage;
import utils.Driver;

public class TGPaginationPageSteps {

    WebDriver driver;
    TechGlobalFrontendTestingHomePage techGlobalFrontendTestingHomePage;
    TechGlobalPaginationPage techGlobalPaginationPage;
    TechGlobalBasePage techGlobalBasePage;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalPaginationPage = new TechGlobalPaginationPage();
        techGlobalBasePage = new TechGlobalBasePage();
    }
    @Given("user is on {string}")
    public void user_is_on(String url) {
       driver.get(url);
    }

    @When("user moves to Practices header dropdown")
    public void user_moves_to_Practices_header_dropdown() {
        techGlobalBasePage.headerDropdown.click();
    }

    @And("user clicks on Frontend Testing header dropdown option")
    public void user_clicks_on_Frontend_Testing_header_dropdown_option() {
        techGlobalBasePage.headerDropdownOptions.get(0).click();
    }

    @Then("user should be navigated to {string}")
    public void user_should_be_navigated_to(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @And("user clicks on {string} card")
    public void user_clicks_on_card(String cardName) {
        techGlobalFrontendTestingHomePage.clickOnCard(cardName);
    }

    @And("user should see {string} heading")
    public void user_should_see_heading(String heading) {
        switch (heading){
            case "Pagination":
                Assert.assertEquals(heading, techGlobalPaginationPage.headingH1.getText());
                break;
            case "World City Populations 2022":
                Assert.assertEquals(heading, techGlobalPaginationPage.headingH2.getText());
                break;
            default:
                throw  new NotFoundException("This is invalid heading text");
        }
    }

    @And("user should see {string} paragraph")
    public void user_should_see_paragraph(String paragraph) {
        Assert.assertEquals(paragraph, techGlobalPaginationPage.paragraph.getText());
    }

    @And("user should see {string} button is disabled")
    public void user_should_see_button_is_disabled(String button) {
        switch (button){
            case "Previous":
                Assert.assertFalse(techGlobalPaginationPage.previousButton.isEnabled());
                break;
            case "Next":
                Assert.assertFalse(techGlobalPaginationPage.nextButton.isEnabled());
                break;
            default:
                throw  new NotFoundException("This is invalid button!");
        }
    }

    @And("user should see {string} button is enabled")
    public void user_should_see_button_is_enabled(String button) {
        switch (button){
            case "Previous":
                Assert.assertTrue(techGlobalPaginationPage.previousButton.isEnabled());
                break;
            case "Next":
                Assert.assertTrue(techGlobalPaginationPage.nextButton.isEnabled());
                break;
            default:
                throw  new NotFoundException("This is invalid button!");
        }
    }

    @When("user clicks on Next button")
    public void user_clicks_on_Next_button() {
        techGlobalPaginationPage.nextButton.click();
    }
    @When("user clicks on Next button till it becomes disabled")
    public void user_clicks_on_Next_button_till_it_becomes_disabled() {
        while (techGlobalPaginationPage.nextButton.isEnabled()){
            techGlobalPaginationPage.nextButton.click();
        }
    }

    @And("user should see Tokio city with info below and an image")
    public void user_should_see_Tokio_city_with_info_below_and_an_image(DataTable tokioContent) {
        Assert.assertTrue(techGlobalPaginationPage.image.isDisplayed());
        for (int i = 0; i < techGlobalPaginationPage.citiesContent.size(); i++) {
            Assert.assertEquals(tokioContent.asList().get(i),techGlobalPaginationPage.citiesContent.get(i).getText());
        }
    }
    @And("user should see Delhi city with info below and an image")
    public void user_should_see_Delhi_city_with_info_below_and_an_image(DataTable delhiContent) {
        Assert.assertTrue(techGlobalPaginationPage.image.isDisplayed());
        for (int i = 0; i < techGlobalPaginationPage.citiesContent.size(); i++) {
            Assert.assertEquals(delhiContent.asList().get(i),techGlobalPaginationPage.citiesContent.get(i).getText());
        }
    }
    @And("user should see Shangai city with info below and an image")
    public void user_should_see_Shangai_city_with_info_below_and_an_image(DataTable shangaiContent) {
        Assert.assertTrue(techGlobalPaginationPage.image.isDisplayed());
        for (int i = 0; i < techGlobalPaginationPage.citiesContent.size(); i++) {
            Assert.assertEquals(shangaiContent.asList().get(i),techGlobalPaginationPage.citiesContent.get(i).getText());
        }
    }
    @And("user should see Sao Paulo city with info below and an image")
    public void user_should_see_Sao_Paulo_city_with_info_below_and_an_image(DataTable saoPauloContent) {
        Assert.assertTrue(techGlobalPaginationPage.image.isDisplayed());
        for (int i = 0; i < techGlobalPaginationPage.citiesContent.size(); i++) {
            Assert.assertEquals(saoPauloContent.asList().get(i),techGlobalPaginationPage.citiesContent.get(i).getText());
        }
    }
    @And("user should see Mexico City city with info below and an image")
    public void user_should_see_Mexico_City_city_with_info_below_and_an_image(DataTable mexicoCityContent) {
        Assert.assertTrue(techGlobalPaginationPage.image.isDisplayed());
        for (int i = 0; i < techGlobalPaginationPage.citiesContent.size(); i++) {
            Assert.assertEquals(mexicoCityContent.asList().get(i),techGlobalPaginationPage.citiesContent.get(i).getText());
        }
    }
}
