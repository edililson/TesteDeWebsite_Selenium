package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenSiteTest {
	
	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdrive.gecko.driver", "C:/geckodriver.exe");//diz aonde o geckodriver est� 
		driver = new FirefoxDriver();//atribui a variavel driver a fun��o do firefoxDriver
		
	}
	

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	

	@Test
	public void test() throws InterruptedException {
		driver.get("http://localhost/projetoPatrimonio-master");
		assertTrue("Titulo da pagina n�o conside com o esperado", driver.getTitle().contentEquals("Chrome Book"));
		Thread.sleep(3000);// da um timeout para o navegador ativar a fun��o drive.quit() depois de 3 segundos == 3000 milesegundos
	}

}
