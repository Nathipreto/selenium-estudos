import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TransferenciaBugBank {

    // Vamos fazer uma automatização que crie duas contas;
    // Transferira 200 reais da conta A para a Conta B
    // Valide que a transferencia foi feita corretamente


    WebDriver driver; //Variaavel de escopo global

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
        driver.findElement( By.xpath( "//div[@class='card__register']//input[@placeholder='Informe seu e-mail']" ) ).sendKeys( "nathali.preto1@gmail.com" );
        driver.findElement( By.xpath( "//input[@placeholder='Informe seu Nome']" ) ).click();
        driver.findElement( By.xpath( "//input[@placeholder='Informe seu Nome']" ) ).sendKeys( "Nathali Preto" );
        driver.findElement( By.xpath( "//div[@class='card__register']//input[@placeholder='Informe sua senha']" ) ).click();
        driver.findElement( By.xpath( "//div[@class='card__register']//input[@placeholder='Informe sua senha']" ) ).sendKeys( "Np063210!" );
        driver.findElement( By.xpath( "//input[@placeholder='Informe a confirmação da senha']" ) ).click();
        driver.findElement( By.xpath( "//input[@placeholder='Informe a confirmação da senha']" ) ).sendKeys( "Np063210!" );
        driver.findElement( By.xpath( "//label[@id='toggleAddBalance']" ) ).click();
        driver.findElement( By.xpath( "//button[normalize-space()='Cadastrar']" ) ).click();

        String msg = "A conta foi criada com sucesso";

        driver.findElement( By.xpath( "//a[@id='btnCloseModal']" ) ).click();


        driver.findElement( By.xpath( "//form[@class='style__ContainerFormLogin-sc-1wbjw6k-0 eTrcYr']//input[@placeholder='Informe seu e-mail']" ) ).click();
        driver.findElement( By.xpath( "//form[@class='style__ContainerFormLogin-sc-1wbjw6k-0 eTrcYr']//input[@placeholder='Informe seu e-mail']" ) ).sendKeys( "nathali.preto1@gmail.com" );
        driver.findElement( By.xpath( "//form[@class='style__ContainerFormLogin-sc-1wbjw6k-0 eTrcYr']//input[@placeholder='Informe sua senha']" ) ).click();
        driver.findElement( By.xpath( "//form[@class='style__ContainerFormLogin-sc-1wbjw6k-0 eTrcYr']//input[@placeholder='Informe sua senha']" ) ).sendKeys( "Np063210!" );
        driver.findElement( By.xpath( "//button[normalize-space()='Acessar']" ) ).click();


        String contaCompleta = driver.findElement(By.id("textAccountNumber")).getText().replace("Conta digital: ", "");
        String numeroConta1 = contaCompleta.split("-")[0];
        String digitoConta1 = contaCompleta.split("-")[1];

        System.out.println(contaCompleta);
        System.out.println(numeroConta1);
        System.out.println(digitoConta1);


        //String conta = driver.findElement(By.id("textAccountNumber")).getText().split(": ")[1];

// Criando segunda conta

        driver.get( "https://bugbank.netlify.app/" );

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


        driver.findElement( By.xpath( "//a[@id='btnCloseModal']" ) ).click();


        driver.findElement( By.xpath( "//form[@class='style__ContainerFormLogin-sc-1wbjw6k-0 eTrcYr']//input[@placeholder='Informe seu e-mail']" ) ).click();
        driver.findElement( By.xpath( "//form[@class='style__ContainerFormLogin-sc-1wbjw6k-0 eTrcYr']//input[@placeholder='Informe seu e-mail']" ) ).sendKeys( "nathali.preto@gmail.com" );
        driver.findElement( By.xpath( "//form[@class='style__ContainerFormLogin-sc-1wbjw6k-0 eTrcYr']//input[@placeholder='Informe sua senha']" ) ).click();
        driver.findElement( By.xpath( "//form[@class='style__ContainerFormLogin-sc-1wbjw6k-0 eTrcYr']//input[@placeholder='Informe sua senha']" ) ).sendKeys( "Np063210!" );
        driver.findElement( By.xpath( "//button[normalize-space()='Acessar']" ) ).click();


        String contaCompleta2 = driver.findElement(By.id("textAccountNumber")).getText().replace("Conta digital: ", "");
        String numeroConta2 = contaCompleta2.split("-")[0];
        String digitoConta2 = contaCompleta2.split("-")[1];
        //Transferindo

        driver.findElement( By.id( "btn-TRANSFERÊNCIA" ) ).click();
        driver.findElement( By.xpath( "//input[@placeholder='Informe o número da conta']" ) ).click();
        driver.findElement( By.xpath( "//input[@placeholder='Informe o número da conta']" ) ).sendKeys( numeroConta1 );
        driver.findElement( By.xpath( "//input[@placeholder='Informe o dígito da conta']" ) ).click();
        driver.findElement( By.xpath( "//input[@placeholder='Informe o dígito da conta']" ) ).sendKeys( digitoConta1);
        driver.findElement( By.xpath( "//input[@placeholder='Informe o valor da transferência']" ) ).click();
        driver.findElement( By.xpath( "//input[@placeholder='Informe o valor da transferência']" ) ).sendKeys( "50.00");
        driver.findElement( By.xpath( "//input[@placeholder='Informe uma descrição']" ) ).click();
        driver.findElement( By.xpath( "//input[@placeholder='Informe uma descrição']" ) ).sendKeys( "Deposito" );
        driver.findElement( By.xpath( "//button[@type='submit']" ) ).click();

        Thread.sleep( 1000 );
        String textoMensagemTransferencia = driver.findElement( By.id( "modalText" ) ).getText();
        Assert.assertEquals( "Transferencia realizada com sucesso",textoMensagemTransferencia);


    }
}