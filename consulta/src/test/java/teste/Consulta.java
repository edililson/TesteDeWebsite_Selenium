package teste;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Consulta {

	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");//diz aonde o geckodriver está 
		driver = new FirefoxDriver();
	}
	

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	

	@Test
	public void test() throws InterruptedException {
		driver.get("http://localhost/projetoPatrimonio-master");
		assertTrue("Titulo da pagina não conside com o esperado", driver.getTitle().contentEquals("Chrome Book"));	
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.findElement(By.name("login")).sendKeys("123");//identificando o seletor do login e inserindo o valor nele
		driver.findElement(By.name("senha")).sendKeys("123");//mesma coisa do login
		driver.findElement(By.name("quantidade")).click();// identificando o botão para logar no site e clicando nele
		
		driver.findElement(By.xpath("/html/body/header/nav/div/div/ul/li[2]/a")).click();// está procurando na pagina um link com o texto Scanner e logo em seguida clicando
		
		driver.findElement(By.id("input_id")).sendKeys("123");//inserindo o valor 123 no imput
		driver.findElement(By.id("codigo_barras")).click();//clicando no botão para pesquisar o tombamento
		
		String verificar_tombo = driver.findElement(By.id("tombo_item")).getAttribute("value");
		assertEquals("123", verificar_tombo);
		
		
		//driver.findElement(By.className("modal-content")).findElement(By.className("modal-footer")).findElement(By.id("fechar_modal")).click();;
		
		Thread.sleep(3000);// da um timeout para o navegador ativar a função drive.quit() depois de 3 segundos == 3000 milesegundos
	}

}
