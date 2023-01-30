import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.opentelemetry.sdk.logs.data.Body;

import static org.testng.Assert.assertEquals;

public class WebTest {

    private WebDriver drive;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.drive", System.getProperty("user.dir") + "../chromedriver");


        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extesions");
        options.addArguments("--disable-dev-shm-usage");

        drive = new ChromeDriver(options);

    }
   @AfterTest
   public void teardown(){
      if(drive != null){
            drive.quit();
        }
    }

    @Test 
    public void check(){
        String de = "de";
        assertEquals(de,"de");
    }

    @Test
    public void verifyResponseHome(){
        drive.get("http://localhost:8001/Home");
        String body = drive.findElement(By.tagName("body")).getText();
        System.out.println(body);
        

        assertEquals(body,"Bienvenido a la API MedicineInyourHands");
    }
    @Test
    public void verifyResponseDoctors(){
        drive.get("http://localhost:8001/doctors");
        String body = drive.findElement(By.tagName("body")).getText();
        System.out.println(body);
        

        assertEquals(body,"This is the Doctor directory");
    }

    @Test
    public void verifyResponseHospital(){
        drive.get("http://localhost:8001/hospitals");
        String body = drive.findElement(By.tagName("body")).getText();
        System.out.println(body);
        

        assertEquals(body,"This is the Hospital directory");
    }

    @Test
    public void verifyResponseMedicalSpeciality(){
        drive.get("http://localhost:8001/MedicalSpeciality");
        String body = drive.findElement(By.tagName("body")).getText();
        System.out.println(body);
        

        assertEquals(body,"This is the Medical Speciality directory");
    }
}

