import org.json.JSONException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.JiraTicketPage;
import pages.LoginPage;
import tests.BaseTest;

import java.io.IOException;

public class ParseTableToJSONTest extends BaseTest {

    @Test()
    public void goToLoginPage() throws IOException, JSONException {
        driver = initializeDriver();
        driver.get(getProperty("jiraUrl"));
        LoginPage loginPage = new LoginPage(this.driver);
        JiraTicketPage jiraTicketPage = loginPage.login(getProperty("jiraUser"), getProperty("jiraPassword"));
        jiraTicketPage.saveTableToToJSON();
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
       driver.quit();
    }
}
