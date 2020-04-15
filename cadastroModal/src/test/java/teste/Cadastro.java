package teste;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import java.util.*;

public class Cadastro {

	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@After
	public void tearDown() {
		// driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get("http://localhost/projetoPatrimonio-master/paginas/scanner.php");
		driver.findElement(By.id("input_id")).sendKeys("52414213");
		driver.findElement(By.id("codigo_barras")).click();
		{
			WebElement element = driver.findElement(By.id("codigo_barras"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		{
			WebElement element = driver.findElement(By.tagName("body"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element, 0, 0).perform();
		}
		driver.findElement(By.id("botao_cadastrar")).click();
		{
			WebElement element = driver.findElement(By.id("botao_cadastrar"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		{
			WebElement element = driver.findElement(By.tagName("body"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element, 0, 0).perform();
		}
		driver.findElement(By.id("select_usuario")).click();
		{
			WebElement dropdown = driver.findElement(By.id("select_usuario"));
			dropdown.findElement(By.xpath("//option[. = 'Marcelo Araujo']")).click();
		}
		driver.findElement(By.cssSelector("#select_usuario > option:nth-child(2)")).click();
		driver.findElement(By.id("select_categoria")).click();
		{
			WebElement dropdown = driver.findElement(By.id("select_categoria"));
			dropdown.findElement(By.xpath("//option[. = 'moveis']")).click();
		}
		driver.findElement(By.cssSelector("#select_categoria > option:nth-child(2)")).click();
		driver.findElement(By.name("nome_item")).click();
		driver.findElement(By.name("nome_item")).sendKeys("PDC");
		driver.findElement(By.name("preco_item")).click();
		driver.findElement(By.name("preco_item")).sendKeys("5221");
		driver.findElement(By.name("dataAquisicao_item")).click();
		driver.findElement(By.name("dataAquisicao_item")).sendKeys("0001-11-26");
		driver.findElement(By.name("dataAquisicao_item")).sendKeys("0018-11-26");
		driver.findElement(By.name("dataAquisicao_item")).sendKeys("0187-11-26");
		driver.findElement(By.name("dataAquisicao_item")).sendKeys("1877-11-26");
		driver.findElement(By.id("select_status")).click();
		{
			WebElement dropdown = driver.findElement(By.id("select_status"));
			dropdown.findElement(By.xpath("//option[. = 'Ativo']")).click();
		}
		driver.findElement(By.cssSelector("#select_status > option:nth-child(2)")).click();
		driver.findElement(By.id("select_localizacao")).click();
		{
			WebElement dropdown = driver.findElement(By.id("select_localizacao"));
			dropdown.findElement(By.xpath("//option[. = 'TI']")).click();
		}
		driver.findElement(By.cssSelector("#select_localizacao > option:nth-child(2)")).click();
		driver.findElement(By.id("select_setor")).click();
		{
			WebElement dropdown = driver.findElement(By.id("select_setor"));
			dropdown.findElement(By.xpath("//option[. = 'Bloco A']")).click();
		}
		driver.findElement(By.cssSelector("#select_setor > option:nth-child(6)")).click();
		driver.findElement(By.id("enviar_formulario")).click();
		driver.findElement(By.cssSelector(".btn-success:nth-child(2)")).click();
		driver.findElement(By.cssSelector("#header_cadastro span")).click();
	}
}