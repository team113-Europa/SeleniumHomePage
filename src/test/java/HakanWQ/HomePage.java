package HakanWQ;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HomePage extends CommonComponent {
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[contains(@class,'is-Header-Item-Nav')]")
    WebElement menuIcon;

    @FindBy(xpath = "//div[@id='is-TopSidebar']/ul[1]/li/ul/li")
    List<WebElement> subMenuList;

    By iconMenu = By.cssSelector("[class = 'is-Icon-com is-Icon-com-close-thin']");
    By iconMap = By.cssSelector("a[title='Plan interactif']");

    protected void menuIconClick(){
        menuIcon.click();
    }
    protected void subMenuOverviewObserve() throws InterruptedException {
        Actions a = new Actions(driver);

        for (var each: subMenuList) {
            sleepOneSecond();
            a.moveToElement(each).build().perform();
        }
        System.out.println("Overall Sub-Menu-items = "+subMenuList.size());

        a.click(driver.findElement(iconMenu)).build().perform();
    }
    protected String PlanInteractifOpen(){
        String tab = Keys.chord(Keys.COMMAND,Keys.ENTER);
        //  String clickOnLinkTab = Keys.chord(Keys.COMMAND,Keys.ENTER)
        driver.findElement(iconMap).sendKeys(tab);
        // driver.findElement(By.xpath("//a[@class='blinkingText']")).sendKeys(clickOnLinkTab);


        Set<String>window = driver.getWindowHandles();
        Iterator<String> it = window.iterator();
        String parent = it.next();
        String child = it.next();

        driver.switchTo().window(child);
        // altdaki metod buraya gelecek
        String depart = "Le Havre";
        String arrivee = "Paris";
        PlanInteractifObserve(depart,arrivee);
        return parent;


    }
    protected void PlanInteractifObserve(String depart,String Arrivee){
        //depart
        driver.findElement(By.xpath("//*[@id='is-Journey-Departure']")).sendKeys(depart);
        //Arrivee
        driver.findElement(By.xpath("//input[@id='is-Journey-Arrival']")).sendKeys(Arrivee);






    }

}
