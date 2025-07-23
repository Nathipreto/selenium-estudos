import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TesteJanelas {
    @Test
    public void testeJanelasSelenium() {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get( "https://demo.automationtesting.in/Windows.html" );
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 30 ) );

        driver.findElement( By.xpath( "//a[@href='http://www.selenium.dev']//button[@class='btn btn-info'][normalize-space()='click']" ) ).click();

        Object[] janelas = driver.getWindowHandles().toArray();
        driver.switchTo().window( janelas[1].toString() ); //Faco a mudança do contexto
        String valorAtual = driver.getPageSource();
        Assert.assertTrue( valorAtual.contains( "Selenium automates browsers.") );
        //    0,        1,         2
        //[janela1, janela2, janela3]



    }
}
