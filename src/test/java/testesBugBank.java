import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class testesBugBank {

    // https://bugbank.netlify.app/
    // Fazer Cadastro
    // Fazer Login
    // Fazer um deposito
    // E validar o saldo, na conta


    WebDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 10 ) );
        driver.manage().timeouts().pageLoadTimeout( Duration.ofSeconds( 10 ) );
        driver.manage().window().maximize();
        driver.get( "https://bugbank.netlify.app/" );

    }

    @Test
    public void TestesBugBank() throws InterruptedException {

        driver.findElement( By.xpath( "//button[normalize-space()='Registrar']" ) ).click();
        driver.findElement( By.xpath( "//div[@class='card__register']//input[@placeholder='Informe seu e-mail']" ) ).click();
        driver.findElement( By.xpath( "//div[@class='card__register']//input[@placeholder='Informe seu e-mail']" ) ).sendKeys( "nathali.preto@gmail.com" );
        driver.findElement( By.xpath( "//input[@placeholder='Informe seu Nome']" ) ).click();
        driver.findElement( By.xpath( "//input[@placeholder='Informe seu Nome']" ) ).sendKeys( "Nathali Preto" );
        driver.findElement( By.xpath( "//div[@class='card__register']//input[@placeholder='Informe sua senha']" ) ).click();
        driver.findElement( By.xpath( "//div[@class='card__register']//input[@placeholder='Informe sua senha']" ) ).sendKeys( "Np063210!" );
        driver.findElement( By.xpath( "//input[@placeholder='Informe a confirmação da senha']" ) ).click();
        driver.findElement( By.xpath( "//input[@placeholder='Informe a confirmação da senha']" ) ).sendKeys( "Np063210!" );
        driver.findElement( By.xpath( "//label[@id='toggleAddBalance']" ) ).click();
        driver.findElement( By.xpath( "//button[normalize-space()='Cadastrar']" ) ).click();

        String msg = "A conta foi criada com sucesso";

        //Verificar se esta quebrando neste ponto
        driver.findElement( By.xpath( "//a[@id='btnCloseModal']" ) ).click();


        driver.findElement( By.xpath( "//form[@class='style__ContainerFormLogin-sc-1wbjw6k-0 eTrcYr']//input[@placeholder='Informe seu e-mail']" ) ).click();
        driver.findElement( By.xpath( "//form[@class='style__ContainerFormLogin-sc-1wbjw6k-0 eTrcYr']//input[@placeholder='Informe seu e-mail']" ) ).sendKeys( "nathali.preto@gmail.com" );
        driver.findElement( By.xpath( "//form[@class='style__ContainerFormLogin-sc-1wbjw6k-0 eTrcYr']//input[@placeholder='Informe sua senha']" ) ).click();
        driver.findElement( By.xpath( "//form[@class='style__ContainerFormLogin-sc-1wbjw6k-0 eTrcYr']//input[@placeholder='Informe sua senha']" ) ).sendKeys( "Np063210!" );
        driver.findElement( By.xpath( "//button[normalize-space()='Acessar']" ) ).click();

        driver.findElement( By.xpath( "//a[@id='btn-EXTRATO']/span/img" ) ).click();
        String valor = driver.findElement( By.xpath( "//p[@id='textBalanceAvailable']" ) ).getText();
        Assert.assertEquals( "R$ 1.000,00",valor );


    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep( 10000 );
        driver.quit();
    }


}
