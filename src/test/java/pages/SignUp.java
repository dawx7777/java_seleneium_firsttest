package pages;

import org.hamcrest.core.IsCollectionContaining;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;
import utility.DataFaker;

import java.util.ArrayList;
import java.util.List;

import static utility.Screenshot.captureScreenshot;

public class SignUp extends  BasePage{

    public SignUp(){super();}

    private DataFaker faker= new DataFaker();

    @FindBy(id = "id_gender1")
    private WebElement maleTitleRadioBtn;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstname;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastname;

    @FindBy(id = "passwd")
    private WebElement customerPassword;

    @FindBy(id = "days")
    private WebElement Days;

    @FindBy(id = "months")
    private WebElement Months;

    @FindBy(id = "years")
    private WebElement Years;

    @FindBy(id = "unifrom-newsletter")
    private WebElement Newsletter;

    @FindBy(id = "company")
    private WebElement Company;

    @FindBy(id = "address1")
    private WebElement Address1;

    @FindBy(id = "address2")
    private WebElement Address2;

    @FindBy(id = "city")
    private WebElement City;

    @FindBy(id = "id_state")
    private WebElement SelectState;

    @FindBy(id = "postcode")
    private WebElement Postcode;

    @FindBy(id = "id_country")
    private WebElement SelectCountry;

    @FindBy(id = "other")
    private WebElement OtherInformation;

    @FindBy(id = "phone")
    private WebElement HomePhone;

    @FindBy(id = "phone_mobile")
    private WebElement PhoneMobile;

    @FindBy(id = "alias")
    private WebElement myaddress;

    @FindBy(id = "submitAccount")
    private WebElement submitAccount;

    @FindBy(css = "center_column > .alert li")
    private List<WebElement> alertMessageContent;

    private void fillInRegistrationForm(boolean validForm){

        maleTitleRadioBtn.click();
        if(validForm){

            customerFirstname.sendKeys(faker.getFakeFirstname());
        }

        customerLastname.sendKeys(faker.getFakeLastname());
        customerPassword.sendKeys(faker.getFakePassword());

        new Select(Days).selectByValue("4");
        new Select(Months).selectByValue("10");
        new Select(Years).selectByValue("2020");

        Address1.sendKeys(faker.getFakeStreet());
        Address2.sendKeys(faker.getFakeStreet());

        City.sendKeys(faker.getFakeCity());
        new Select(SelectState).selectByValue("4");
        Postcode.sendKeys("12345");
        PhoneMobile.sendKeys(faker.getFakeMobilePhone());

    }

    @Step

    public Profile submitFormWithValidData(){

        fillInRegistrationForm(true);
        captureScreenshot();
        submitAccount.click();
        return new Profile();
    }

    @Step

    public SignUp submitFormWithInValidData(){

        fillInRegistrationForm(false);
        captureScreenshot();
        submitAccount.click();
        return this;
    }

    @Step

    public void userShouldSeeRegistrationFormAlert(){
        String EXPECTED_MESSAGE="firstname is required";
        Assert.assertThat(getAlertMessageContent(), IsCollectionContaining.hasItem(EXPECTED_MESSAGE));


    }
    @Step
    private List<String> getAlertMessageContent(){

        List<String> alertMessages=new ArrayList<>();

        for(WebElement message : alertMessageContent){

            alertMessages.add(message.getText());
        }
        System.out.println(alertMessages);
        return alertMessages;
    }



}
