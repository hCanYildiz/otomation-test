package Insider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class UITest {
    private static final Logger log = LoggerFactory.getLogger(UITest.class);

    @Test
    public void OpenOrNotOpen()  {
        //Url'in açılıp açılmadığın testi

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(6));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://useinsider.com/"); //url'e gidilir
        //cookiesi bekler ve onu onaylar.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wt-cli-accept-all-btn\"]")));
        driver.findElement(By.xpath("//*[@id=\"wt-cli-accept-all-btn\"]")).click();
        //logo gorunurlugu ve urlde insider icerigi kontrol edilir.
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"navigation\"]/div[2]/a[1]/img")).isDisplayed() && driver.getCurrentUrl().contains("useinsider"));
        driver.close();
    }
    @Test
    public void SelectCompanyAndCareer()  {
            //Company barındaki Career sekmesinin açılıp açılmadığının testi

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(6));
            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            driver.get("https://useinsider.com/"); //url'e gidilir
        //cookiesi bekler ve onu onaylar.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wt-cli-accept-all-btn\"]")));
            driver.findElement(By.xpath("//*[@id=\"wt-cli-accept-all-btn\"]")).click();
        // company seceneginin gelmesini bekler ve tıklar
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbarNavDropdown\"]/ul[1]/li[6]")));
         driver.findElement(By.xpath("//*[@id=\"navbarNavDropdown\"]/ul[1]/li[6]")).click();

        //Career seçenegine tıklar.
         driver.findElement(By.xpath("//*[@id=\"navbarNavDropdown\"]/ul[1]/li[6]/div/div[2]/a[2]")).click();

       //Locations, life at insider ve teams alanlarının görünürlügünü bekler.
        WebElement locations = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("career-our-location")));

        WebElement lifeAtInsider = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/section[4]/div/div/div/div[1]/div/h2")));

        WebElement teams = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("career-find-our-calling")));
        // Locations, life at insider ve teams alanlarının görüntülenmesini teyit eder.
        Assertions.assertTrue(teams.isDisplayed() && lifeAtInsider.isDisplayed()&&locations.isDisplayed() );
        driver.close();
    }
    @Test
    public void QualityAssurance(){


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://useinsider.com/careers/quality-assurance/");
        //cookies bekle
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wt-cli-accept-all-btn\"]")));
        //cookies tıkla
        driver.findElement(By.xpath("//*[@id=\"wt-cli-accept-all-btn\"]")).click();


        //see all jobs tıkla
        driver.findElement(By.xpath("//*[@id=\"page-head\"]/div/div/div[1]/div/div/a")).click();

        //quality assurance yazısı gelene kadar bekle
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Quality Assurance']")));

        //filter by location'daki all alanına tıklama
        driver.findElement(By.xpath("//*[@id=\"top-filter-form\"]/div[1]/span/span[1]/span/span[2]")).click();
        //Istanbul,Turkey secenegine tiklanır.
        driver.findElement(By.xpath("//li[contains(@id, 'select2-filter-by-location-result') and text()='Istanbul, Turkey']")).click();
       //job list gelmesi beklenir.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"jobs-list\"]/div[2]/div")));
       //job list'in görüntülendiği teyitlenir ve içeriğinde Istanbul, Turkey lokasyonu olan iş denetlenir.
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"jobs-list\"]")).isDisplayed() && driver.findElement(By.xpath("//*[@id=\"jobs-list\"]")).getText().contains("Istanbul, Turkey") );
        driver.close();
    }

    @Test
    public void JobList() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));




        // Siteye git
        driver.get("https://useinsider.com/careers/quality-assurance/");
        //cookies bekle
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wt-cli-accept-all-btn\"]")));
        //cookies tıkla
        driver.findElement(By.xpath("//*[@id=\"wt-cli-accept-all-btn\"]")).click();
        //  "See all QA jobs" butonuna tıklar
        driver.findElement(By.xpath("//*[@id=\"page-head\"]/div/div/div[1]/div/div/a")).click();

        Thread.sleep(3000); //3 sn bekle


        // iş listesinin görüntülenmesini bekle
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("jobs-list")));

        // İşleri listele
        List<WebElement> jobCards = driver.findElements(By.xpath("//*[@id='jobs-list']//div[contains(@class, 'position-list-item-wrapper')]"));
        boolean allJobsValid = true; //koşul için başlangıç değer
        // iş ilanlarında gezin ve pozisyon departman ve lokasyon bilgilerini al.
        for (WebElement jobCard : jobCards) {
            String position = jobCard.findElement(By.xpath(".//p[contains(@class, 'position-title')]"))
                    .getText();
            String department = jobCard.findElement(By.xpath(".//span[contains(@class, 'position-department')]"))
                    .getText();
            String location = jobCard.findElement(By.xpath(".//div[contains(@class, 'position-location')]"))
                    .getText();



            // İstenilen iş kriterleri harici koşulları denetle
            if (!position.contains("Quality Assurance") ||
                    !department.contains("Quality Assurance") ||
                    !location.equals("İstanbul, Turkey")) {
                allJobsValid = false;

                System.out.println("Position: " + position);
                System.out.println("Department: " + department);
                System.out.println("Location: " + location);
                System.out.println("Job validation failed:");
                System.out.println("--------------------------");
            }
        }

        if (allJobsValid) {
            System.out.println("Tüm iş ilanları istenilen pozisyon,departman ve lokasyona göredir.");

        } else {
            System.out.println("Tüm iş ilanları istenilen pozisyon,departman ve lokasyon bilgisini sağlamamaktadır");
        }

        Assertions.assertTrue(allJobsValid);
        driver.close();

    }



    @Test
    public void ViewRole() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://useinsider.com/careers/quality-assurance/");
        //cookies bekle
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wt-cli-accept-all-btn\"]")));
        //cookies tıkla
        driver.findElement(By.xpath("//*[@id=\"wt-cli-accept-all-btn\"]")).click();


        //see all jobs tıkla
        driver.findElement(By.xpath("//*[@id=\"page-head\"]/div/div/div[1]/div/div/a")).click();

        //quality assurance yazısı gelene kadar bekle
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Quality Assurance']")));
        //iş ilanı listesi görünene kadar bekle
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"jobs-list\"]/div[1]/div")));
        //iş ilanı listesini al
        WebElement element =driver.findElement(By.xpath("//*[@id=\"jobs-list\"]/div[1]/div/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform(); //fareyi iş ilanı alanının üzerine getirir
        driver.findElement(By.xpath("//*[@id=\"jobs-list\"]/div[1]/div/a")).click(); //iş ilanına tıklar

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Yeni sekmeye geçme işlemi
        Set<String> allWindows = driver.getWindowHandles();
        String currentWindow = driver.getWindowHandle();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(currentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        //Site açıldığını logodan kontrol etme
        WebElement open = driver.findElement(By.xpath("/html/body/div[2]/div/div/a/img"));


       Assertions.assertTrue( open.isDisplayed());
        driver.close();
    }




        }







