package pages;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.JSONHelper;

import java.io.FileWriter;
import java.util.List;


public class JiraTicketPage {

    public WebDriver driver;
    By table = By.xpath("//table");


    public JiraTicketPage(WebDriver driver) {
        this.driver = driver;
    }
    private WebElement getTable(){
        return driver.findElement(table);
    }
    public void saveTableToToJSON() {
        JSONArray jsonArray = new JSONArray();
        List<WebElement> tableRows = getTable().findElements(By.xpath(".//tr"));
        List<WebElement> headers = tableRows.get(0).findElements(By.tagName("th"));

        for (int i = 1; i < tableRows.size(); i++) {
            List<WebElement> cells = tableRows.get(i).findElements(By.tagName("td"));
            JSONObject jsonObject = new JSONObject();
            for (int с = 0; с < headers.size(); с++) {
                try {
                    jsonObject.put(headers.get(с).getText(), cells.get(с).getText());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            jsonArray.put(jsonObject);
        }
        JSONHelper.writeJSONObjectToFile(jsonArray);
    }
}
