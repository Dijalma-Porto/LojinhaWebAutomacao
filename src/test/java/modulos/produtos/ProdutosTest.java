package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import paginas.LoginPage;
import java.time.Duration;

@DisplayName("Testes Web do Módulo Produtos")
public class ProdutosTest {
    private WebDriver navegador;
    @BeforeEach
    public void beforeEach(){
        //Abrir um navagador
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities cp = new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cp);

        System.setProperty("webdriver.chrome.driver", "G:\\Meu Drive\\TI\\PTQS - Turma 9\\Driver\\ChromeDriver\\chromedriver.exe");
        this.navegador = new ChromeDriver(options);

        //Vou maximizar a tela
        this.navegador.manage().window().maximize();
        //Tempo de espera da mensagem antes e dar o teste como falho por problemas de internet
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Navegar para a Página da lojinha Web
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");

    }
    @Test
    @DisplayName("Não é permitido registrar um produto com valor igual ou inferior R$ 0,00")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualAZero(){
        //Fazer Login
        String mensagemToast = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                // Ir para a pagina de adição de Produto
                .acessarOFormularioDeAdicaoDeNovoProduto()
                //Vou preencher dados do produto e o valor será igual a zero
                .informarNomeDoProduto("Umbú")
                .informarValorDoProduto("000")
                .informarCorDoProduto("Verde")
                //vou submeter o formulário
                .submeterFormularioComAdicaoComErro()
                //Vou capturar a mensagem de erro foi apresentada
                .capturarMensagemApresentada();

        //Validar a mensagem de erro que foi apresentada
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemToast);
    }
    @Test
    @DisplayName("Não é permitido registrar um produto com o valor maior que R$ 7.000,00")
    public void nãoEPermitidoRegistrarUmProdutoComOValorMaiorQueSeteMil(){
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .informarNomeDoProduto("Moto G")
                .informarValorDoProduto("700001")
                .informarCorDoProduto("preto ,verde")
                .submeterFormularioComAdicaoComErro()
                .capturarMensagemApresentada();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }
@Test
@DisplayName("Posso adicionar produtos que estejam na faixa de R$ 0,01 e R$ 7.000,00")
public void possoAdicionarProdutosQueEstejamNaFaixaDeUmCentavoESeteMil(){
        String mensagemApresentadaSucesso = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .informarNomeDoProduto("umbú")
                .informarValorDoProduto("10000")
                .informarCorDoProduto("verde")
                .submeterFormularioComAdicaoComSucesso()
                .capturarMensagemApresentadaSucesso();

        Assertions.assertEquals("Produto adicionado com sucesso",mensagemApresentadaSucesso);

}
    @Test
    @DisplayName("Posso adicionar produtos que estejam no Limite de R$ 0,01")
    public void possoAdicionarProdutosQueEstejaComValorDeUmCentavo(){
        String mensagemApresentadaSucesso = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .informarNomeDoProduto("Umbú")
                .informarValorDoProduto("001")
                .informarCorDoProduto("verde")
                .submeterFormularioComAdicaoComSucesso()
                .capturarMensagemApresentadaSucesso();

        Assertions.assertEquals("Produto adicionado com sucesso",mensagemApresentadaSucesso);

    }
    @Test
    @DisplayName("Posso adicionar produtos que estejam no limite de R$ 7.000,00")
    public void possoAdicionarProdutosComValorDeSeteMil(){
        String mensagemApresentadaSucesso = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .informarNomeDoProduto("umbú")
                .informarValorDoProduto("700000")
                .informarCorDoProduto("verde")
                .submeterFormularioComAdicaoComSucesso()
                .capturarMensagemApresentadaSucesso();

        Assertions.assertEquals("Produto adicionado com sucesso",mensagemApresentadaSucesso);

    }
    @AfterEach
    public void afterEach(){
        //Vou fechar o navegador
        navegador.quit();
    }
}
