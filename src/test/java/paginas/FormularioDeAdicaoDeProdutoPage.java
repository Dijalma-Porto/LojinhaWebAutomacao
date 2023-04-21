package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioDeAdicaoDeProdutoPage {
    private WebDriver navegador;

    public FormularioDeAdicaoDeProdutoPage(WebDriver navegador){
        this.navegador = navegador;
    }
    public FormularioDeAdicaoDeProdutoPage informarNomeDoProduto(String produtoNome) {
        navegador.findElement(new By.ById("produtonome")).sendKeys(produtoNome);

        return this;
    }
    public FormularioDeAdicaoDeProdutoPage informarValorDoProduto(String produtoValor){
        navegador.findElement(new By.ByName("produtovalor")).sendKeys(produtoValor);

        return this;
    }
    public FormularioDeAdicaoDeProdutoPage informarCorDoProduto(String produtoCor){
        navegador.findElement(new By.ById("produtocores")).sendKeys(produtoCor);

        return this;
    }
    public ListaDeProdutosPage submeterFormularioComAdicaoComErro(){
        navegador.findElement(new By.ByCssSelector("button[type='submit']")).click();

        return new ListaDeProdutosPage(navegador);
    }
    public FormularioDeEdicaoDeProdutoPage submeterFormularioComAdicaoComSucesso(){
        navegador.findElement(new By.ByCssSelector("button[type='submit']")).click();

        return new FormularioDeEdicaoDeProdutoPage(navegador);

    }
}

