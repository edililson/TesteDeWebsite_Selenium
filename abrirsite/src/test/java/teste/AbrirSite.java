package teste;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

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
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");// diz aonde o geckodriver est�
		driver = new FirefoxDriver();// criando uma variavel para poder chama as fun��es do webDriver
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get("http://localhost/projetoPatrimonio-master");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		assertTrue("Titulo da pagina n�o conside com o esperado", driver.getTitle().contentEquals("Chrome Book"));
		driver.findElement(By.name("login")).sendKeys("123");// identificando o seletor do login e inserindo o valor
																// nele
		driver.findElement(By.name("senha")).sendKeys("1234");// mesma coisa do login
		driver.findElement(By.name("quantidade")).click();// identificando o bot�o para logar no site e clicando nele

		String verificar_alerta = driver.findElement(By.className("alert-danger")).getText();// pegando o valor do
																								// alerta
		assertEquals("Usu�rio ou senha inv�lidos!", verificar_alerta);// verificando se o valor esperado � o mesmo que o
																		// valor contido

		boolean verificar = driver.findElement(By.className("alert-danger")).isEnabled();// verificando se o alerta de
																							// usus�rio invalido foi
																							// exibido

		if (verificar == true) {// se foi exigido ele ira realizar o login com os dados corretos
			driver.findElement(By.name("login")).sendKeys("123");
			driver.findElement(By.name("senha")).sendKeys("123");
			driver.findElement(By.name("quantidade")).click();
		}

		Thread.sleep(3000);// da um timeout para o navegador ativar a fun��o drive.quit() depois de 3
							// segundos == 3000 milesegundos
	}

}
