package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SearchKeywordNoFoundControl {
    public static String targetKeyword="";
    public static boolean response;

    public static void SearchKeyword() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 1- https://trendyol.com sayfasina gidilir.
        driver.get("https://www.trendyol.com");
        // 2- Cookies çıkarsa kabul et işlemi
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        //3-Arama cubuguna tıklama
        driver.findElement(By.xpath("//input[@data-testid='suggestion']")).click();
        //4-Arama cubuguna keyword yazma
        WebElement word = driver.findElement(By.xpath("//input[@data-testid='suggestion']"));
        word.sendKeys(targetKeyword);
        //5-Arama cubugundaki search butonuna tıklama
        driver.findElement(By.xpath("//i[@data-testid='search-icon']")).click();
        //6-Aranılan keyword'un istenilen sayfayı görüntülemesi
        WebElement noResultText = driver.findElement(By.xpath("//div[@class='no-rslt-text no-rslt-title']"));
        response = noResultText.isDisplayed();
        driver.close();
    }
}
