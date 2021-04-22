package tests;

import Config.TestConfig;
import org.junit.jupiter.api.Test;
import pages.Home;

public class RegistrationTest extends TestConfig {


    @Test

    public void userShouldSuccessfullyRegister(){

        new Home()

                .openSignInPage()
                .submitCreateAccountFormWithValidEmail()
                .submitFormWithValidData()
                .userShouldBeSuccesfullyRegistered();
    }

    @Test

    public void registrationWithValidDataShouldFail(){

        new Home()
               .openSignInPage()
                .submitCreateAccountFormWithValidEmail()
                .submitFormWithInValidData()
                .userShouldSeeRegistrationFormAlert();

    }



}
