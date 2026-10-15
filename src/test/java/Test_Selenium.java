import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.*;

public class Test_Selenium {

    static WebDriver driver;

    @BeforeAll
    static void Settings() {
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    };

    @Test
    void testTextInput() {
        WebElement input = driver.findElement(By.xpath("//input[@id='my-text-id']"));
        input.clear();
        input.click();
        input.sendKeys("Hello Selenium");
        assertEquals("Hello Selenium", input.getAttribute("value"));
    };

    @Test
    void testTextArea() {
      WebElement textarea = driver.findElement(By.xpath("//textarea[@name='my-textarea']"));
      textarea.clear();
      textarea.click();
      textarea.sendKeys("This is a test message");
      assertEquals("This is a test message", textarea.getAttribute("value"));
    };

    @Test
    void testDisabledInput() {
        WebElement disabledInput = driver.findElement(By.xpath("//input[@name='my-disabled']"));
        boolean isDisabledInput = disabledInput.isEnabled();
        assertFalse(isDisabledInput);
    };

    @Test
    void testReadOnlyInput() {
        WebElement readOnly = driver.findElement(By.xpath("//input[@name='my-readonly']"));
        readOnly.click();
        readOnly.sendKeys("Check");
        assertEquals("Readonly input", readOnly.getAttribute("value"));
    };

    @Test
    void testDropDown() {
        WebElement dropDown = driver.findElement(By.xpath("//select[@name='my-select']"));
        Select select = new Select(dropDown);
        select.selectByValue("1");
        assertEquals("One", select.getFirstSelectedOption().getText());
    };

    @Test
    void testCheckBox() {
        WebElement checkBox = driver.findElement(By.xpath("//input[@id='my-check-2']"));
        if (!checkBox.isSelected()) {
            checkBox.click();
        };
        assertTrue(checkBox.isSelected(), "Чекбокс должен быть отмечен");
    };

    @Test
    void testRange() {
        WebElement slider = driver.findElement(By.xpath("//input[@name='my-range']"));
        slider.click();
        slider.sendKeys(Keys.ARROW_RIGHT);
        assertEquals("6", slider.getAttribute("value"));
    };

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
};
