import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
 
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
 
public class SeleniumTest {
    
    private WebDriver driver;
    
    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        assertNotNull(driver);
        driver.manage().window().maximize();
        driver.get("https://www.habbo.com.br");
    }
    
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    @Test
    public void test01() {
        WebElement queryInput = driver.findElement(By.xpath("/html/body/div[1]/habbo-header-large/div[1]/div/div/h1"));
        assertNotNull(queryInput);
    
        String currentUrl = driver.getCurrentUrl();
        String expected = "https://www.habbo.com.br/";
    
        assertEquals(expected, currentUrl);
    }
    
    @Test
    public void teste02() {
        WebElement elemento = driver.findElement(By.xpath("/html/body/div[1]/habbo-header-large/div[1]/div/div/h2"));
        assertTrue(elemento.isDisplayed());
    }
    
	 
	@Test
	 public void teste03() {
	     boolean elementoAusente = !driver.findElements(By.id("terms-of-service")).isEmpty();
	     assertFalse(elementoAusente);
	} 

    @Test
    public void teste04() {
    
        WebElement campoUsuario = driver.findElement(By.name("email"));
        WebElement campoSenha = driver.findElement(By.name("password"));
    
        campoUsuario.sendKeys("Iasmim Holanda");
        campoSenha.sendKeys("123456");
        campoSenha.submit();
    }

    @Test
    public void teste05() {
    
        WebElement contact = driver.findElement(By.id("onetrust-accept-btn-handler"));
        Actions actions = new Actions(driver);
    
        actions.moveToElement(contact).perform();
        contact.click();
    }

    @Test
    public void teste06(){

        WebElement contact = driver.findElement(By.id("onetrust-accept-btn-handler"));
        Actions actions = new Actions(driver);
    
        actions.moveToElement(contact).perform();
        contact.click();

        WebElement cadastrar = driver.findElement(By.xpath("/html/body/div[1]/habbo-header-large/div[1]/div/div/a"));
        cadastrar.click();
    }

    @Test
    public void teste07(){
        WebElement contact = driver.findElement(By.id("onetrust-accept-btn-handler"));
        Actions actions = new Actions(driver);
    
        actions.moveToElement(contact).perform();
        contact.click();

        WebElement cadastrar = driver.findElement(By.xpath("/html/body/div[1]/habbo-header-large/div[1]/div/div/a"));
        cadastrar.click();

		WebElement newaccount = driver.findElement(By.xpath("//*[@id=\"birthdate-day\"]"));
		Select select = new Select(newaccount);
		int indiceOpcaoDesejada = 27;
		select.selectByIndex(indiceOpcaoDesejada);
    }

    @Test
	public void teste08() {
        WebElement contact = driver.findElement(By.id("onetrust-accept-btn-handler"));
        Actions actions = new Actions(driver);
    
        actions.moveToElement(contact).perform();
        contact.click();

		WebElement campoUsuario = driver.findElement(By.name("email"));
		WebElement campoSenha = driver.findElement(By.name("password"));
		campoUsuario.sendKeys("Lucas Medeiros");
		campoSenha.sendKeys("123456");
		campoSenha.submit();
	}

    @Test
    public void teste09(){
        WebElement contact = driver.findElement(By.id("onetrust-accept-btn-handler"));
        Actions actions = new Actions(driver);
    
        actions.moveToElement(contact).perform();
        contact.click();

        WebElement comunidade = driver.findElement(By.xpath("//*[@id=\"ga-linkid-community\"]"));
        comunidade.click();
    }

    @Test
    public void teste10(){
        WebElement contact = driver.findElement(By.id("onetrust-accept-btn-handler"));
        Actions actions = new Actions(driver);
    
        actions.moveToElement(contact).perform();
        contact.click();

        WebElement colecionaveis = driver.findElement(By.xpath("//*[@id=\"ga-linkid-habbo-nft\"]"));
        colecionaveis.click();
 
		String urlAtual = driver.getCurrentUrl();
		String esperado = "https://www.habbo.com.br/habbo-nft/habbo-avatars";
		assertEquals(esperado, urlAtual);
    }


 

}