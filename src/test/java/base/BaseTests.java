package base;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.EnterVehicleDataPage;

public class BaseTests {
	
	private String paginaInicial = "http://sampleapp.tricentis.com/101/app.php";
	
	private static WebDriver driver;
	protected EnterVehicleDataPage enterVehicleDataPage;
	
	@BeforeAll
	public static void inicializar() {
		//configuracao para executar no macos
		File chromeDriver = new File("/usr/local/bin/chromedriver");
		System.setProperty("webdriver.chrome.driver",chromeDriver.getAbsolutePath());
		//caso for utilizar no windows colocar o arquivo chromedriver em uma pasta ("C:\\Tools\\selenium\\chromedriver.exe")
		//comentar as duas linhas anteriores e remover comentario da linha seguinte
		//System.setProperty("webdriver.chrome.driver", "C:\\Tools\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeEach
	public void carregarPaginaInicial() {
		driver.get(paginaInicial);
		enterVehicleDataPage = new EnterVehicleDataPage(driver);
	}

	@AfterAll
	public static void finalizar() {
		driver.quit();
	}
}
