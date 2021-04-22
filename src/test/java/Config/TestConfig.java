package Config;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static Config.WebDriverSignleton.getInstance;
import static Config.WebDriverSignleton.quit;
import static utility.Screenshot.captureScreenshot;


public class TestConfig {

    private WebDriver driver;

    @BeforeEach

    public void setUp(){


        String baseUrl="http://automationpractice.com/index.php";
        driver=getInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);

    }

    @AfterEach

    public void tearDown(){

        captureScreenshot();
        quit();
    }


}
