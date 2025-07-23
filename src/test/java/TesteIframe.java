import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TesteIframe {

    WebDriver driver;

    @Before
    public void before() {

        driver = new ChromeDriver();
        driver.get( "https://demo.automationtesting.in/Frames.html" );

    }

    @Test
    public void testeIframe() {

        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 30 ) );
        WebElement iframe = driver.findElement( By.id( "singleframe" ) );//NEssa linha procuro pelo ID do Igframe
        driver.switchTo().frame( iframe );//Fazemos a mudança do conexto para o novo iframe

        driver.findElement( By.tagName( "input" ) ).sendKeys( "Teste QA Academy Iframes!" );
        Assert.assertTrue( driver.getPageSource().contains( "iFrame Demo" ) );

    }

    @After
    public void after() {

        driver.quit();

    }

}
