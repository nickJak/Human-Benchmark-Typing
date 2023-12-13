import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

public class Main {
    static WebDriver driver = new FirefoxDriver();
    public static void main(String[] args) throws InterruptedException {
        String username = "username";
        String password = "password";

        driver.get("https://humanbenchmark.com/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/a[2]")).click();
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/form/p[3]/input")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@href='/tests/typing']")).click();


        WebElement parentElement = driver.findElement(By.xpath("/html/body/div/div/div[4]/div[1]/div/div[2]/div"));
        List<WebElement> allChildElements = parentElement.findElements(By.xpath("*"));
        String text = "";

        for (int i = 0; i < allChildElements.size(); i++)
        {
            if(allChildElements.get(i).getText().isEmpty())
            {
                text = text.concat(" ");
            }
            else
            {
                text = text.concat(allChildElements.get(i).getText());
            }
        }


        driver.findElement(By.xpath("/html/body/div/div/div[4]/div[1]/div/div[2]/div")).sendKeys(text);

    }
}