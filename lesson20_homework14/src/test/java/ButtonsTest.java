import com.github.kubrabal.Property;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;

public class ButtonsTest {

    Property property = new Property();
    static WebDriver driver = new ChromeDriver();

    @BeforeAll
    public static void openUrl() {
        driver.get("https://demoqa.com/elements");
    }

    @Test
    public void clickButtons() {
        WebElement buttons = driver.findElement(By.cssSelector("#item-4"));
        buttons.click();

        WebElement clickMeButton = driver.findElement(By.cssSelector(".col-md-6 div:nth-of-type(3) > .btn"));
        clickMeButton.click();

        WebElement dynamicMessage = driver.findElement(By.cssSelector("#dynamicClickMessage"));
        System.out.println(dynamicMessage.getText());
    }

    @AfterAll
    public static void closeConnection() {
        driver.close();
    }
}
