import com.github.kubrabal.Property;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddRecordTest {

    Property property = new Property();
    static WebDriver driver = new ChromeDriver();


    @BeforeAll
    public static void openUrl() {
        driver.get("https://demoqa.com/webtables");
    }

    @Test
    public void addRecord() {
        WebElement buttons = driver.findElement(By.cssSelector("#addNewRecordButton"));
        buttons.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registration-form-modal")));

        WebElement firstNameField = driver.findElement(By.cssSelector("#firstName"));
        firstNameField.sendKeys("Joh");

        WebElement lastNameField = driver.findElement(By.cssSelector("#lastName"));
        lastNameField.sendKeys("Doe");

        WebElement emailField = driver.findElement(By.cssSelector("#userEmail"));
        emailField.sendKeys("john.doe@email.com");

        WebElement ageField = driver.findElement(By.cssSelector("#age"));
        ageField.sendKeys("25");

        WebElement salaryField = driver.findElement(By.cssSelector("#salary"));
        salaryField.sendKeys("35000");

        WebElement departmentField = driver.findElement(By.cssSelector("#department"));
        departmentField.sendKeys("Sales");

        WebElement submitButton = driver.findElement(By.cssSelector("#submit"));
        submitButton.click();

        WebElement editButton = driver.findElement(By.cssSelector("#edit-record-4"));
        editButton.click();

        WebElement updatedFirstNameField = driver.findElement(By.cssSelector("#firstName"));
        updatedFirstNameField.clear();
        updatedFirstNameField.sendKeys("John");

        WebElement updateSubmitButton = driver.findElement(By.cssSelector("#submit"));
        updateSubmitButton.click();

        WebElement updatedFirstNameCell = driver.findElement((By.cssSelector("div.rt-tbody > div:nth-child(4) > div > div:nth-child(1)")));
        System.out.println("Field modified as:" + " " + updatedFirstNameCell.getText());
    }

    @AfterAll
    public static void closeConnection() {
        driver.close();
    }
}
