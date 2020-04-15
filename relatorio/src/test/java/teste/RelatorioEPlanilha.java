package teste;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RelatorioEPlanilha {

	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");// diz aonde o geckodriver está
		driver = new FirefoxDriver();
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get("http://localhost/projetoPatrimonio-master");
		assertTrue("Titulo da pagina não conside com o esperado", driver.getTitle().contentEquals("Chrome Book"));
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.findElement(By.name("login")).sendKeys("123");// identificando o seletor do login e inserindo o valor
																// nele
		driver.findElement(By.name("senha")).sendKeys("123");// mesma coisa do login
		driver.findElement(By.name("quantidade")).click();// identificando o botão para logar no site e clicando nele

		driver.findElement(By.xpath("/html/body/header/nav/div/div/ul/li[3]/a")).click();// está procurando na pagina um
																							// link com o texto Scanner
																							// e logo em seguida
																							// clicando

		Select dropdown = new Select(driver.findElement(By.id("select_um")));
		dropdown.selectByValue("setor");
		dropdown.getOptions().contains("setor");
		Select dropdown2 = new Select(driver.findElement(By.id("select_dois")));
		dropdown2.selectByValue("1");
		
		
		driver.findElement(By.id("pg_busca")).click();
		
		String vericar = driver.findElement(By.xpath("//*[@id=\"nome_setor\"]")).getText();
		assertEquals("Administrativo", vericar);
			
		driver.findElement(By.id("gerar_planilha")).click();
		
		
		


		// Thread.sleep(3000);// da um timeout para o navegador ativar a função
		// drive.quit() depois de 3 segundos == 3000 milesegundos
	}

}
