package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaDeProdutosPage {
    private WebDriver navegador;

    ListaDeProdutosPage(WebDriver navegador){
        this.navegador = navegador;
    }
    public FormularioDeAdicaoDeProdutoPage acessarOFormularioDeAdicaoDeNovoProduto(){
        navegador.findElement(new By.ByLinkText("ADICIONAR PRODUTO")).click();

        return new FormularioDeAdicaoDeProdutoPage(navegador);
    }
    public String capturarMensagemApresentada(){
        return navegador.findElement(new By.ByCssSelector(".toast.rounded")).getText();
    }
}
