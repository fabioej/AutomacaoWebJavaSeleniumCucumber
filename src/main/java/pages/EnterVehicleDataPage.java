package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnterVehicleDataPage {

	private WebDriver driver;
	
	private String paginaInicial = "http://sampleapp.tricentis.com/101/app.php";
	
	private By cotacaoParaAutomovel = By.cssSelector(".main-navigation #nav_automobile");
	
	private By itensAindaNaoPreenchidos = By.cssSelector("#entervehicledata .counter");
	
	private By enginePerformance = By.id("engineperformance");
	
	private By dataDeManufatura = By.id("dateofmanufacture");
	
	private By preco = By.id("listprice");
	
	private By placa = By.id("licenseplatenumber");
	
	private By mileageAnual = By.id("annualmileage");
	
	private By botaoNext = By.id("nextenterinsurantdata");
	
	public EnterVehicleDataPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selecionarCotacaoParaAutomovel() {
		driver.findElement(cotacaoParaAutomovel).click();
	}
	
	public void selecionarMarca(String marca){
		driver.findElement(By.cssSelector("#make option[value="  + marca + "]")).click();
	}
	
	public void inserirPerformanceMotor(String performance) {
		driver.findElement(enginePerformance).sendKeys(performance);
	}
	
	public void inserirDataDeFabricacao(String data) {
		driver.findElement(dataDeManufatura).sendKeys(data);
	}
	
	public void selecionarNumeroDeLugares(String lugares) {
		driver.findElement(By.cssSelector("#numberofseats option[value=\"" + lugares + "\"]")).click();
	}
	
	public void selecionarTipoDeCombustivel(String combustivel) {
		driver.findElement(By.cssSelector("#fuel option[value=\""  + combustivel + "\"]")).click();
	}
	
	public void inserirPreco(String precoDeTabela) {
		driver.findElement(preco).sendKeys(precoDeTabela);
	}
	
	public void inserirPlaca(String placaVeiculo) {
		driver.findElement(placa).sendKeys(placaVeiculo);
	}
	
	public void inserirMileageAnual(String milhas) {
		driver.findElement(mileageAnual).sendKeys(milhas);
	}
	
	public Integer obterCountItensObrigatoriosNaoPreenchidos() {
		return Integer.parseInt(
				driver.findElement(itensAindaNaoPreenchidos).getText()
				);
	}
	
	public EnterInsurantDataPage clicarNext() {
		driver.findElement(botaoNext).click();
		return new EnterInsurantDataPage(driver);
	}

	public void carregarPaginaInicial() {
		driver.get(paginaInicial);	
	}
	
}
