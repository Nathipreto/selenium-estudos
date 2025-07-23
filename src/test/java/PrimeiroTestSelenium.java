import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;


public class PrimeiroTestSelenium {
    WebDriver driver; //Variaavel de escopo global
    @Before
    public void before(){
        driver = new ChromeDriver(); //Cria um Driver do Chrome para nos comunicarmos com o google chrome
        driver.get( "https://demo.automationtesting.in/Register.html" );//Nos abrimos uma pagina utilizando o google chrome controlado pelo chromedriver
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 10 ) );//Estrategia de espera implicita

    }
    @Test
    public void testeFormularioHomePage_2() throws InterruptedException {

        Thread.sleep( 1000 ); //Não é recomentdado por gerar flaky tests - Estrategia de espera explicita

        //Preenche formulario
        driver.findElement( By.xpath( "//*[@placeholder='First Name']" ) ).click();
        driver.findElement( By.xpath( "//input[@placeholder='First Name']" ) ).sendKeys( "Nathali" );// Localiza o elemento e depois escreve o nome Nathali.
        driver.findElement( By.xpath( "//input[@placeholder='Last Name']" ) ).click();
        driver.findElement( By.xpath( "//input[@placeholder='Last Name']" ) ).sendKeys( "Preto" );
        driver.findElement( By.xpath( "//textarea[@ng-model='Adress']" ) ).click();
        driver.findElement( By.xpath( "//textarea[@ng-model='Adress']" ) ).sendKeys( "Av Paulista, 509" );
        driver.findElement( By.xpath( "//input[@type='tel']" ) ).sendKeys( "9911089561" );
        driver.findElement( By.xpath( "//input[@type='email']" ) ).sendKeys( "nathali.preto@gmail.com" );
        driver.findElement( By.xpath( "//input[@value='FeMale']" ) ).click();
        driver.findElement( By.xpath( "//input[@id='checkbox2']" ) ).click();
        driver.findElement( By.xpath( "//div[@id='msdd']" ) ).click();
        driver.findElement( By.xpath( "//a[normalize-space()='Italian']" ) ).click();
        driver.findElement( By.xpath( "//label[normalize-space()='Languages']" ) ).click();
        //Lista do tipo UL/LI - Consegue com click
        driver.findElement( By.xpath( "//span[@role='combobox']" ) ).click();
        driver.findElement( By.xpath( "//li[normalize-space()='United States of America']" ) ).click();

        driver.findElement( By.xpath( "//input[@id='firstpassword']" ) ).sendKeys( "1112303" );
        driver.findElement( By.xpath( "//input[@id='secondpassword']" ) ).sendKeys( "1112303" );

        //Mapeamento de listas do tipo Select/Option - Não Consegue com click
        Select listaSelect  = new Select( driver.findElement( By.xpath( "//select[@id='Skills']" )));
        listaSelect.selectByVisibleText("Java");

        Select listaAno  = new Select( driver.findElement( By.xpath( "//select[@id='yearbox']" )));
        listaAno.selectByVisibleText("1999");

        Select listaMes  = new Select( driver.findElement( By.xpath( "//select[@placeholder='Month']" )));
        listaMes.selectByVisibleText("January");

        Select listaDia  = new Select( driver.findElement( By.xpath( "//select[@id='daybox']" )));
        listaDia .selectByVisibleText("27");

        String nomeBotao = driver.findElement( By.xpath( "//button[@id='submitbtn']" )).getText(); // Variavel de escopo local
        Assert.assertEquals("Submit", nomeBotao);
        driver.findElement( By.xpath( "//button[@id='submitbtn']" ) ).click();


    }


    @After
    public void after(){
        driver.quit();
    }
}
