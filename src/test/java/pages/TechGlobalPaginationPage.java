package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class TechGlobalPaginationPage extends TechGlobalBasePage{

    public TechGlobalPaginationPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "main_heading")
    public WebElement headingH1;

    @FindBy(id = "sub_heading")
    public WebElement headingH2;

    @FindBy(id = "content")
    public WebElement paragraph;


}
