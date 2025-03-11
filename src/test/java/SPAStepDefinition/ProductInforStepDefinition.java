package SPAStepDefinition;

import Core.ScreenRecorderUtil;
import SearchPage.ProductInfoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

import static SPAStepDefinition.DivisionStepDefinition.driver;

public class ProductInforStepDefinition {
    ProductInfoPage productInfoPage;
    @And("user click on category product info")
    public void userClickOnCategoryProductInfo() {
        ScreenRecorderUtil.startRecord("Product list");
        productInfoPage = new ProductInfoPage(driver);
        productInfoPage.clickProductInfo();
        
    }

    @And("user click on add product info")
    public void userClickOnAddProductInfo() {
        productInfoPage.addProductButton();
        
    }

    @And("user enter product code, product name and all information")
    public void userEnterProductCodeProductNameAndAllInformation() throws IOException, InterruptedException {
        productInfoPage.addInformation();
        
    }

    @Then("successfully create the product info information")
    public void successfullyCreateTheProductInfoInformation() {
        System.out.println("Successfully create the product info information");
        ScreenRecorderUtil.stopRecord();
    }
}
