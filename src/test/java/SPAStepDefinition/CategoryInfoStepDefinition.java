package SPAStepDefinition;

import SearchPage.CategoryInfoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

import static SPAStepDefinition.DivisionStepDefinition.driver;

public class CategoryInfoStepDefinition {

    CategoryInfoPage categoryInfoPage;
    @And("user click on category info")
    public void userClickOnCategoryInfo() {

        categoryInfoPage = new CategoryInfoPage(driver);
        categoryInfoPage.clickCategoryInfo();
        
    }

    @And("user click on add category info")
    public void userClickOnAddCategoryInfo() {
        categoryInfoPage.addCategoryButton();
        
    }

    @And("user enter category code, category name, brand name and remarks")
    public void userEnterCategoryCodeCategoryNameBrandNameAndRemarks() throws IOException, InterruptedException {
        categoryInfoPage.addInformation();
        
    }

    @Then("successfully create the category info information")
    public void successfullyCreateTheCategoryInfoInformation() {
        System.out.println("Successfully create the category information");
    }
}
