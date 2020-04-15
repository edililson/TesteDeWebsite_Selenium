package teste;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class CadastrarSetor {

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
		 driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get("http://localhost/projetoPatrimonio-master");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.name("login")).sendKeys("123");
		driver.findElement(By.name("senha")).click();
		driver.findElement(By.name("senha")).sendKeys("123");
		driver.findElement(By.name("quantidade")).click();
		driver.findElement(By.linkText("Cadastrar")).click();
		driver.findElement(By.id("imputSetor")).click();
		driver.findElement(By.id("imputSetor")).sendKeys("Bloco C");
		driver.findElement(By.id("btnSetor")).click();
		
		Thread.sleep(3000);
		
	}
}