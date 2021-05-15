package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class SelectPriceOptionPage {

	private WebDriver driver;
	
	private By itensAindaNaoPreenchidos = By.cssSelector("#selectpriceoption .counter");
	
	private By botaoNext = By.id("nextsendquote");
	
	private By silver = By.cssSelector("tfoot label:nth-child(1)");
	
	private By gold = By.cssSelector("tfoot label:nth-child(2)");
	
	private By platinum = By.cssSelector("tfoot label:nth-child(3)");
	
	private By ultimate = By.cssSelector("tfoot label:nth-child(4)");
	
	
	public SelectPriceOptionPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selecionarPlano(String plano) {
		if (plano == "Silver") {
			driver.findElement(silver).click();
		}
		else if(plano == "Gold") {
			driver.findElement(gold).click();
		}
		else if(plano == "Platinum") {
			driver.findElement(platinum).click();
		}
		else {
			driver.findElement(ultimate).click();
		}
	}
	
	public Integer obterCountItensObrigatoriosNaoPreenchidos() {
		FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(itensAindaNaoPreenchidos));
		return Integer.parseInt(
				driver.findElement(itensAindaNaoPreenchidos).getText()
				);
	}

	public boolean botaoNextEstaVisivel() {
		return driver.findElement(botaoNext).isEnabled();
	}
	
	public SendQuotePage clicarNext() {
		driver.findElement(botaoNext).click();
		return new SendQuotePage(driver);
	}
}
