package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnterInsurantDataPage {
	
	private WebDriver driver;
	
	private By itensObrigatoriosAindaNaoPreenchidos = By.cssSelector("#enterinsurantdata .counter");
	
	private By primeroNome = By.id("firstname");
	
	private By sobrenome = By.id("lastname");
	
	private By dataNascimento = By.id("birthdate");
	
	private By enderecoRua =  By.id("streetaddress");
	
	private By codigoPostal =  By.id("zipcode");
	
	private By cidade = By.id("city");
	
	private By webSite = By.id("website");
	
	private By botaoNext = By.id("nextenterproductdata");
	
	
	public EnterInsurantDataPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inserirPrimeiroNome(String nome) {
		driver.findElement(primeroNome).sendKeys(nome);
	}
	
	public void inserirSobrenome(String Sobrenome) {
		driver.findElement(sobrenome).sendKeys(Sobrenome);
	}
	
	public void inserirDataDeNascimento(String dataDeNascimento) {
		driver.findElement(dataNascimento).sendKeys(dataDeNascimento);	
	}
	
	public void selecionarGenero(String sexo) {
		driver.findElement(By.xpath("//label[text()='" + sexo + "']/span")).click();
	}
	
	public void inserirRua(String rua) {
		driver.findElement(enderecoRua).sendKeys(rua);
	}
	
	public void  selecionarPais(String pais) {
		driver.findElement(By.cssSelector("#country option[value="+ pais + "]")).click();
	}
	
	public void inserirCodigoPostal(String codPostal) {
		driver.findElement(codigoPostal).sendKeys(codPostal);
	}
	
	public void inserirCidade(String Cidade) {
		driver.findElement(cidade).sendKeys(Cidade);
	}
	
	public void selecionarEmprego(String emprego) {
		driver.findElement(By.cssSelector("#occupation option[value=" + emprego + "]")).click();
	}
	
	public void inserirHobbiee(String hobbie) {
		driver.findElement(By.xpath("//label[text()=' " + hobbie + "']/span")).click();
	}
	
	public void inserirWebSite(String site) {
		driver.findElement(webSite).sendKeys(site);
	}
	
	public Integer obterCountItensObrigatoriosNaoPreenchidos() {
		return Integer.parseInt(
				driver.findElement(itensObrigatoriosAindaNaoPreenchidos).getText()
				);
	}
	
	public EnterProductDataPage clicarNext() {
		driver.findElement(botaoNext).click();
		return new EnterProductDataPage(driver);
	}

}
