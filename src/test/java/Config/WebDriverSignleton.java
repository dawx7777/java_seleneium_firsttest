package Config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverSignleton {

    private static WebDriver driver;
    private WebDriverSignleton(){};


    public static WebDriver getInstance(){
        if(null==driver){
            WebDriverManager.operadriver().setup();
            driver=new OperaDriver();
        }
        return driver;
    }

    public static void quit(){

        if(null!= driver){
            driver.quit();
        }
    }
}
