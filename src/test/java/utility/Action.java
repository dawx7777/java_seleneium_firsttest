package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static Config.WebDriverSignleton.getInstance;

public class Action {

    static  final int WAIT_TIMEOUT=10;
    private static WebDriverWait wait= new WebDriverWait(getInstance(), WAIT_TIMEOUT);

    public static void waitForVisibilityOfElement(WebElement element){

        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
