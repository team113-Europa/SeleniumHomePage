package HakanWQ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonComponent {
    WebDriver driver;

    public CommonComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    protected void manageWindowAndGoToUrl(){
        driver.manage().window().maximize();
        driver.get("https://atoumod.fr/");
    }
    protected WebDriverWait waitImplicitAndExplicit(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        return wait;
    }
    protected void sleepOneSecond() throws InterruptedException {
        Thread.sleep(1000L);
    }
}
