package scenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CadastroPage;

import java.time.Duration;

public class CadastroScenario {

    WebDriver driver; //Variaavel de escopo global
    CadastroPage cadastroPage;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 10 ) );
        driver.manage().timeouts().pageLoadTimeout( Duration.ofSeconds( 10 ) );
        driver.manage().window().maximize();
        cadastroPage = new CadastroPage(driver);
        driver.get( "https://bugbank.netlify.app/" );

    }

    @Test
    public void testeCadastro() {

        cadastroPage.clicarElemento( cadastroPage.registrarBtn );
        cadastroPage.enviarTexto( cadastroPage.nome, "Nathali" );
        cadastroPage.enviarTexto( cadastroPage.email, "nathali.preto@gmail.com" );
        cadastroPage.enviarTexto( cadastroPage.senha, "1234" );
        cadastroPage.enviarTexto( cadastroPage.confirmaSenha, "1234" );
        cadastroPage.clicarElemento( cadastroPage.criarComSaldo );
        cadastroPage.clicarElemento( cadastroPage.cadastrar );


    }

    @After
    public void after() {
        driver.quit();
    }
}
