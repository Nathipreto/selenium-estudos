package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroPage {

    WebDriver driver;

    public CadastroPage(WebDriver driver) {
        this.driver = driver;
    }

    //Elementos
    public String registrarBtn = "//button[normalize-space()='Registrar']";
    public String email = "//div[@class='card__register']//input[@placeholder='Informe seu e-mail']";
    public String nome = "//input[@placeholder='Informe seu Nome']";
    public String senha = "//div[@class='card__register']//input[@placeholder='Informe sua senha']";
    public String confirmaSenha = "//input[@placeholder='Informe a confirmação da senha']";
    public String criarComSaldo = "//label[@id='toggleAddBalance']";
    public String cadastrar = "//button[normalize-space()='Cadastrar']";


    //Ações
    public void clicarElemento(String elemento) {
        driver.findElement( By.xpath( elemento ) ).click();
    }

    public void enviarTexto(String elemento, String texto){
        driver.findElement( By.xpath( elemento ) ).sendKeys(texto);
    }

}
