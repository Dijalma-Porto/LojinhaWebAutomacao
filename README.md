# Lojinha Web Automação
Esse é um repositório que contém a automação de alguns testes de uma aplicação Web de um software denominado Lojinha. Os subtítulos abaixo descrevem algumas decisões
tomadas na estruturação do projeto.

# Tecnologia usada
Java

https://www.oracle.com/java/technologies/javase/jdk19-archive-downloads.html

JUnit

https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine/5.8.0

WebDriver

https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.8.1

ChromeDriver

https://chromedriver.storage.googleapis.com/index.html?path=111.0.5563.64/

Maven

https://maven.apache.org/

# Testes Automatizados
Testes para validar as partições de equivalência e valor limite relacionadas ao valor do produto na
Lojinha, vinculadas diretamente a regra de negócio que diz que o valor do
produto deve estar entre R$ 0,01 e R$ 7.000,00. Foram gerados testes com o valor igual a R$ 0,00, R$ 1.000,00, R$ 7.000,00 e R$ 7.000,01.

# Notas Gerais

- Sempre utilizamos anotações @BeforeEach para configurar ações iniciais que são comuns a série de testes. Para as ações comuns ao final dos testes usamos o @AfterEach.
- Nesse projeto fazemos uso do JUnit 5 que nos dá a possiblidade de usar a
  anotação DisplayName para dar descrições em português para nossos testes.
- Usamos neste projeto o conceito de Design Pattern chamado Page Objects. Com o Page Objects criarmos Classes específicas para cada página da aplicação que precise ser usada nos scripts de testes.
- O Design Pattern do Fluente Page também é aplicado neste projeto. Usamos este padrão para retornar a própria página ou uma outra página de acordo com cada ação do usuário.