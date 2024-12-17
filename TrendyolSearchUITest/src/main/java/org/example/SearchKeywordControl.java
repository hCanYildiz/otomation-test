package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SearchKeywordControl {

    public static String targetKeyword="";
    public static boolean response;

    public static void SearchKeyword() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 1- https://trendyol.com sayfasina gidilir.
        driver.get("https://useinsider.com/");
        // 2- Cookies çıkarsa kabul et işlemi



        /*
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        //3-Arama cubuguna tıklama
        driver.findElement(By.xpath("//input[@data-testid='suggestion']")).click();
        //4-Arama cubuguna keyword yazma
        WebElement word = driver.findElement(By.xpath("//input[@data-testid='suggestion']"));
        word.sendKeys(targetKeyword);
        //5-Arama cubugundaki search butonuna tıklama
        driver.findElement(By.xpath("//i[@data-testid='search-icon']")).click();
        //6-Aranılan keyword'un istenilen sayfayı görüntülemesi
        WebElement resultText = driver.findElement(By.xpath("//div[@class='dscrptn dscrptn-V2']"));
        response=resultText.isDisplayed();
        driver.close();

         */
    }

}