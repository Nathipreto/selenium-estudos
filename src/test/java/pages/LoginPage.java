package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public String imputEmail = "//form[@class='style__ContainerFormLogin-sc-1wbjw6k-0 eTrcYr']//input[@placeholder='Informe seu e-mail']";
    public String senha = "//form[@class='style__ContainerFormLogin-sc-1wbjw6k-0 eTrcYr']//input[@placeholder='Informe sua senha']";
    public String entrar = "//button[normalize-space()='Acessar']";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clicarElementos(String elemento) {
        driver.findElement( By.xpath( elemento ) ).click();

    }

    public void enviarTexto(String elemento, String texto) {
        driver.findElement( By.xpath( elemento ) ).sendKeys( texto);
    }


}
