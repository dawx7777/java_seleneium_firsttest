package tests;

import Config.TestConfig;
import org.junit.jupiter.api.Test;
import pages.Contact;
import pages.Home;

public class ContactUsTest extends TestConfig {


    @Test

    public void userShouldContactUs(){

new Contact()
        .openContactUs()
        .sendValidFormContact();





    }
}
