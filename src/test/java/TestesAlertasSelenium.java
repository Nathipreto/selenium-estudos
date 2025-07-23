import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.time.Duration;

public class TestesAlertasSelenium {
    @Test
    public void testeAlertaSimples() throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get( "https://demo.automationtesting.in/Alerts.html" );
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(30) );

        driver.findElement( By.xpath( "//button[@class='btn btn-danger']" ) ).click();
        Alert alert = driver.switchTo().alert(); //Muda o contexto do driver para um aler
        String text = alert.getText(); //Pegamos o texto do Alerta e salvamos em uma variavel
        System.out.println(text); // Imprindo o texto do alerta
        Assert.assertEquals( "I am an alert box!", text ); //Comparação do texto esperado com o texto atual

        alert.accept(); //Clicar ok no alerta
        //alert.dismiss(); // FEchar alert
        Thread.sleep( 10000);
        driver.quit();

    }
}
