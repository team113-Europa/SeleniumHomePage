package HakanWQ;

import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = SetUpMethods.setup();

        HomePage homePage = new HomePage(driver);

        homePage.manageWindowAndGoToUrl();
        homePage.menuIconClick();
        homePage.subMenuOverviewObserve();
        homePage.PlanInteractifOpen();

        driver.quit();




    }
}
