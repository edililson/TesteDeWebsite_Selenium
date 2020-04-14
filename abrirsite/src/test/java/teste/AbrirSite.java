package teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbrirSite {

	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");//diz aonde o geckodriver está 
		driver = new FirefoxDriver();
	}
	

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}
	

	@Test
	public void test() throws InterruptedException {
		driver.get("http://localhost/projetoPatrimonio-master");
		assertTrue("Titulo da pagina não conside com o esperado", driver.getTitle().contentEquals("Chrome Book"));		
		driver.findElement(By.name("login")).sendKeys("123");//identificando o seletor do login e inserindo o valor nele
		driver.findElement(By.name("senha")).sendKeys("1234");//mesma coisa do login
		driver.findElement(By.name("quantidade")).click();// identificando o botão para logar no site e clicando nele
		
		
		boolean verificar = driver.findElement(By.className("alert-danger")).isEnabled();
		
		if(verificar == true) {
			driver.findElement(By.name("login")).sendKeys("123");
			driver.findElement(By.name("senha")).sendKeys("123");
			driver.findElement(By.name("quantidade")).click();
		}
		
		
		//Thread.sleep(3000);// da um timeout para o navegador ativar a função drive.quit() depois de 3 segundos == 3000 milesegundos
	}

}
