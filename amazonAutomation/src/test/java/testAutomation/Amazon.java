package testAutomation;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.io.IOException;

public class Amazon {
    public static void main(String[] args) throws IOException {
        //a. https://www.amazon.com.tr/ adresine gidin ve bu adreste olduğunuzu doğrulayın.
        System.setProperty("chromeDriver","/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com.tr/");
        Assert.assertEquals("Amazon.com.tr: Elektronik, bilgisayar, akıllı telefon, kitap, oyuncak, yapı market, ev, mutfak, oyun konsolları ürünleri ve daha fazlası için internet alışveriş sitesi",driver.getTitle());
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='sp-cc-accept']")).click();

        //b. Arama çubuğundan “Macbook Pro” değerini aratın.
        WebElement searchElement=driver.findElement(By.id("twotabsearchtextbox"));
        searchElement.click();
        searchElement.sendKeys("Macbook Pro");
        WebElement searchButton=driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();

        //c. Sonuçlar sayfasında çıkan ilk sonucun detayını açın.
        driver.findElement(By.xpath("//img[@src='https://m.media-amazon.com/images/I/61NRYreJ2cL._AC_SR180,120_QL70_.jpg']")).click();

        //d. Ürünün fiyat, model adı ve CPU modeli bilgilerini bir dosyaya yazdırın.
        WebElement price=driver.findElement(By.xpath("//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']"));
        String prices=price.getText();

        WebElement model=driver.findElement(By.xpath("//*[text()='MacBook Pro']"));
        String models=model.getText();

        WebElement cpu=driver.findElement(By.xpath("//*[text()='Apple M1']"));
        String cpuu=cpu.getText();


        FileWriter file=new FileWriter("C:\\Users\\Nurmelek\\IdeaProjects\\amazonAutomation\\document\\test.text",true);
        file.write("Fiyat"+prices);
        file.write("Model"+models);
        file.write("CPU"+cpuu);
        file.close();

    }
}
