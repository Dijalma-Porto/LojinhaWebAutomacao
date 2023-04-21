package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver navegador;

    public LoginPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public LoginPage informarOUsuario(String usuario){

        navegador.findElement(new By.ByCssSelector("label[for='usuario']")).click();
        navegador.findElement(new By.ById("usuario")).sendKeys(usuario);

        return this;
    }
    public LoginPage informarASenha(String senha){
        navegador.findElement(new By.ByCssSelector("label[for='senha']")).click();
        navegador.findElement(new By.ById("senha")).sendKeys(senha);

        return this;
    }
    public ListaDeProdutosPage submeterFormularioDeLogin(){
        navegador.findElement(new By.ByCssSelector("button[type='submit']")).click();

        return new ListaDeProdutosPage(navegador);
    }
}
