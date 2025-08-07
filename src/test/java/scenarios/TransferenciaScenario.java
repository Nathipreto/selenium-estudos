package scenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CadastroPage;
import pages.LoginPage;

import java.time.Duration;

public class TransferenciaScenario {

    WebDriver driver; //Variaavel de escopo global
    CadastroPage cadastroPage;
    LoginPage loginPage;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 10 ) );
        driver.manage().timeouts().pageLoadTimeout( Duration.ofSeconds( 10 ) );
        driver.manage().window().maximize();
        cadastroPage = new CadastroPage( driver );
        loginPage = new LoginPage( driver );
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

        loginPage.enviarTexto( loginPage.imputEmail,"nathali.preto@gmail.com" );
        loginPage.enviarTexto( loginPage.senha,"1234" );
        loginPage.clicarElementos( loginPage.entrar );

        //Realizar a transferencia- Criar a Page, colocar os elementos, e as ações. Depois incluir e fazer as chamadas neste Cenario


    }

    @After
    public void after() {
        driver.quit();
    }
}
