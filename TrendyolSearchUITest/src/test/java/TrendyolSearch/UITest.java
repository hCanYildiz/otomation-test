package TrendyolSearch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.SearchKeywordControl;
import org.example.SearchKeywordNoFoundControl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UITest {
    @Test
    public void OpenOrNotOpen()  {
        //Url'in açılıp açılmadığın testi

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://useinsider.com/");
        WebElement open = driver.findElement(By.xpath("//*[@id=\"navigation\"]/div[2]/a[1]/img"));
        Assertions.assertTrue(open.isDisplayed());

        driver.close();
    }
    @Test
    public void SelectCompanyAndCareer() throws InterruptedException {
            //Company barındaki Career sekmesinin açılıp açılmadığının testi

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(6));
            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            driver.get("https://useinsider.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wt-cli-accept-all-btn\"]")));
            driver.findElement(By.xpath("//*[@id=\"wt-cli-accept-all-btn\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbarNavDropdown\"]/ul[1]/li[6]")));
         driver.findElement(By.xpath("//*[@id=\"navbarNavDropdown\"]/ul[1]/li[6]")).click();


         driver.findElement(By.xpath("//*[@id=\"navbarNavDropdown\"]/ul[1]/li[6]/div/div[2]/a[2]")).click();

        WebElement locationsBlock = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("career-our-location")));

        WebElement lifeAtInsiderBlock = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/section[4]/div/div/div/div[1]/div/h2")));

        WebElement teamsBlock = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("career-find-our-calling")));

        Assertions.assertTrue(teamsBlock.isDisplayed() && lifeAtInsiderBlock.isDisplayed()&&locationsBlock.isDisplayed() );

    }
    @Test
    public void QualityAssurance(){


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(6));
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://useinsider.com/careers/quality-assurance/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wt-cli-accept-all-btn\"]")));
        driver.findElement(By.xpath("//*[@id=\"wt-cli-accept-all-btn\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"page-head\"]/div/div/div[1]/div/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-filter-by-location-container\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Istanbul']")));
        driver.findElement(By.xpath("//li[text()='Istanbul']")).click();

        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"jobs-list\"]/div[1]/div")).isDisplayed());

    }

    @Test
    public void JobControl(){
        ////Birden fazla kelime ile aranan kelimenin bulunamama testi
        SearchKeywordNoFoundControl.targetKeyword = "qweqweqwe qweqweqweqwe";
        SearchKeywordNoFoundControl.SearchKeyword();
        Assertions.assertTrue(SearchKeywordNoFoundControl.response);
    }

    @Test
    public void InvalidSearch(){
        //Geçersiz format ile arama testi
        SearchKeywordNoFoundControl.targetKeyword = "'!^!'^!'^";
        SearchKeywordNoFoundControl.SearchKeyword();
        Assertions.assertTrue(SearchKeywordNoFoundControl.response);
    }

    @Test
    public void SpaceSearch(){
        //Aranan kelimenin başında ve sonunda boşluk varken arama testi
        SearchKeywordControl.targetKeyword = "    Kalem     ";
        SearchKeywordControl.SearchKeyword();
        Assertions.assertTrue(SearchKeywordControl.response);

}
    @Test
    public void FirstSpaceSearch(){
        //Aranan kelimenin başında boşluk varken arama testi
        SearchKeywordControl.targetKeyword = "     Kalem";
        SearchKeywordControl.SearchKeyword();
        Assertions.assertTrue(SearchKeywordControl.response);

    }
    @Test
    public void LastSpaceSearch(){
        //Aranan kelimenin sonunda boşluk varken arama testi
        SearchKeywordControl.targetKeyword = "Kalem            ";
        SearchKeywordControl.SearchKeyword();
        Assertions.assertTrue(SearchKeywordControl.response);

    }

    @Test
    public void UpperSearch(){
        //Büyük harflerle kelime arama testi
        SearchKeywordControl.targetKeyword = "KALEM";
        SearchKeywordControl.SearchKeyword();
        Assertions.assertTrue(SearchKeywordControl.response);

    }
    @Test
    public void LowerSearch(){
        //Kücük harflerle kelime arama testi
        SearchKeywordControl.targetKeyword = "kalem";
        SearchKeywordControl.SearchKeyword();
        Assertions.assertTrue(SearchKeywordControl.response);

    }
    @Test
    public void MixerSearch(){
        //Hem büyük hem kücük harfli kelimeyle arama testi
        SearchKeywordControl.targetKeyword = "KALem";
        SearchKeywordControl.SearchKeyword();
        Assertions.assertTrue(SearchKeywordControl.response);

    }
    @Test
    public void MixerSpaceSearch(){
        //Bosluk,büyük ve kücük harflerle olusan kelimenin arama testi
        SearchKeywordControl.targetKeyword = "K   Ale m";
        SearchKeywordControl.SearchKeyword();
        Assertions.assertTrue(SearchKeywordControl.response);
    }
}
