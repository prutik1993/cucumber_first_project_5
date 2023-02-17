package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import pages.TechGlobalBasePage;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalPaginationPage;
import utils.Driver;

public class Hooks {


    @After
    public void teardown(){
        Driver.quitDriver();
    }
}
