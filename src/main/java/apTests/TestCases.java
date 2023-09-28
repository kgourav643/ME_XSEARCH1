
package apTests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium Imports
import java.util.logging.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.BrowserType;
///
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestCases {
    RemoteWebDriver driver;
    boolean status = false;
    public TestCases() throws MalformedURLException {
        System.out.println("Constructor: TestCases");

        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(BrowserType.CHROME);
        driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);


        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.amazon.in/");
        System.out.println("Current title is: "+ driver.getTitle());
        String currenturl = driver.getCurrentUrl();
        if(currenturl.contains("amazon.in")){
            status = true;
            //System.out.println("Testcase 1 - Passed");
        }
        System.out.println("Testcase01 : " +( status ? "Pass" : "Fail"));
        System.out.println("end Test case: testCase01");
        status = false;
    }

    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");
        Thread.sleep(10000);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        searchBox.sendKeys("Laptop");
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(10000);

        List<WebElement> AlltextContains = driver.findElements(By.xpath("//h2[contains(@class, 's-line-clamp')]//span"));
        for(WebElement containsText : AlltextContains){
            String laptop_text_contains = containsText.getText().toLowerCase();
            if(laptop_text_contains.contains("laptop")){
                status = true;
                //System.out.println("Testcase02 - Passed");
                break;
            }
        }
        System.out.println("Testcase02 : " +( status ? "Pass" : "Fail"));
        System.out.println("end Test case: testCase02");
        status = false;

        }
        
        public void testCase03() throws InterruptedException{
            driver.get("https://www.amazon.in/");
            
            driver.findElement(By.xpath("//*[@id='nav-xshop']/a[9]")).click();
            Thread.sleep(3000);
            String currentUrl = driver.getCurrentUrl().toLowerCase();
            System.out.println("Current Url is " + currentUrl);
            if(currentUrl.contains("electronics")){
                status = true;
            }
            System.out.println("Testcase03 : " +( status ? "Pass" : "Fail"));

        }
        
    }



