package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;
import utility.DataFaker;

import java.util.ArrayList;
import java.util.List;

import static utility.Screenshot.captureScreenshot;

public class ContactUs extends BasePage{

public ContactUs(){super();}

private DataFaker faker= new DataFaker();

@FindBy(id = "id_contact")
    private WebElement subjectHeading;


@FindBy(id = "email")
private  WebElement contactEmail;

@FindBy(id = "id_order")

    private WebElement orderReferences;

@FindBy(id = "fileUpload")

    private WebElement fileUpdate;

@FindBy(id = "message")
    private WebElement messageBox;

@FindBy(id = "submitMessage")
    private WebElement submitMessage;

    @FindBy(css = "center_column > .alert li")
    private List<WebElement> alertMessageContactUs;

    @Step
    private void fillContactForm(){


        contactEmail.sendKeys(faker.getFakeContactEmail());
        orderReferences.sendKeys(faker.getFakeOrderReferences());
        messageBox.sendKeys(faker.getFakeMessage());
        fileUpdate.sendKeys(faker.getFakeFile());


    }

    @Step

    public ContactUs sendValidFormContact(){

        fillContactForm();
        captureScreenshot();
        submitMessage.click();
        return this;
    }

    @Step

    private List<String> getAlertMessageContentContact(){

        List<String> alertMessages=new ArrayList<>();

        for(WebElement message : alertMessageContactUs){

            alertMessages.add(message.getText());
        }
        System.out.println(alertMessages);
        return alertMessages;
    }

}
