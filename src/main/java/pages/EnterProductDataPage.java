package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnterProductDataPage {
	
	private WebDriver driver;
	
	private By dataDeInicio = By.id("startdate");
	
	private By botaoNext = By.id("nextselectpriceoption");
	
	private By itensObrigatoriosAindaNaoPreenchidos = By.cssSelector("#enterproductdata .counter");
	
	
	
	public EnterProductDataPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void dataDeInicioSeguro(String dataInicio) {
		driver.findElement(dataDeInicio).sendKeys(dataInicio);
	}
	
	public void selecionarSomaSeguro(String soma) {
		driver.findElement(By.cssSelector("#insurancesum option[value=\"" + soma  +"\"]")).click();
	}
	
	public void selecionarClasseDeBonus(String bonus) {
		driver.findElement(By.cssSelector("#meritrating option[value=\"" + bonus + "\"]")).click();
	}
	
	public void selecionarCoberturaDeDanos(String cobertura) {
		driver.findElement(By.cssSelector("#damageinsurance option[value=\"" + cobertura + "\"]")).click();
	}
	
	public void selecionarProdutosOpcionais(String produtoOpcional) {
		driver.findElement(By.xpath("//label[text()='" + produtoOpcional + "']/span")).click();
	}
	
	public void selecionarCarroCortesia(String carroCortesia) {
		driver.findElement(By.cssSelector("#courtesycar option[value=" + carroCortesia + "]")).click();
	}
	
	public Integer obterCountItensObrigatoriosNaoPreenchidos() {
		return Integer.parseInt(
				driver.findElement(itensObrigatoriosAindaNaoPreenchidos).getText()
				);
	}
	
	public SelectPriceOptionPage clicarNext() {
		driver.findElement(botaoNext).click();
		return new SelectPriceOptionPage(driver);
	}
	
}
