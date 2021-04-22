package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static utility.Screenshot.captureScreenshot;

public class Home extends BasePage {

    public Home() { super();}

    @FindBy(css="[title=\"Log in to your customer account\"]")

    private WebElement signButton;

    @Step

    public SignIn openSignInPage(){

        signButton.click();
        captureScreenshot();

        return new SignIn();
    }


}
