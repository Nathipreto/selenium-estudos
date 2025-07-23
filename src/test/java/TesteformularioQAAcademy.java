import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


    public class TesteformularioQAAcademy {
    WebDriver driver; //Variaavel de escopo global
    @Before
    public void before(){
        driver = new ChromeDriver(); //Cria um Driver do Chrome para nos comunicarmos com o google chrome
        driver.get("https://www.qaacademy.com.br/");//Nos abrimos uma pagina utilizando o google chrome controlado pelo chromedriver
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(30) );//Estrategia de espera implicita

    }
    @Test
    public void TesteFormularioQAAcademy() throws InterruptedException {

        Thread.sleep( 1000 ); //Não é recomentdado por gerar flaky tests - Estrategia de espera explicita

        //Preenche formulario
        driver.findElement( By.xpath( "//p[@id='comp-k7g9c7sd1label']") ).click();
        driver.findElement( By.xpath( "//a[@aria-label='Saiba mais']") ).click();
        String curso = driver.findElement( By.xpath( "//span[contains(text(),'QA - E2E')]" )).getText();
        Assert.assertEquals( "QA - E2E", curso); // Validação utilizando o elemento e pegando o texto.
        Assert.assertTrue ("Falha ao validar a url", driver.getCurrentUrl().contains( "automatizacao-de-testes" )); //Valida se a rota (url) contem o texto automatizacao-de-testes
        Assert.assertTrue ("Falha ao validar o texto dentro do html",driver.getPageSource().contains( "QA - E2F" )); // Esta validação verifica dentro do HTML da pagina, se existe o textp QA - E2E

    }


    @After
    public void after(){
        driver.quit();
    }
}
