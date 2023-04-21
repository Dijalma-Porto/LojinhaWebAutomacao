package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioDeEdicaoDeProdutoPage {
    private WebDriver navegador;

    public FormularioDeEdicaoDeProdutoPage(WebDriver navegador){
        this.navegador = navegador;
    }
    public String capturarMensagemApresentadaSucesso(){
        return navegador.findElement(new By.ByCssSelector(".toast.rounded")).getText();
    }
}
