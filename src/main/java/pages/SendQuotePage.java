package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class SendQuotePage {
	
	private WebDriver driver;
	
	private By email = By.id("email");
	
	private By telefone = By.id("phone");
	
	private By usuario = By.id("username");
	
	private By senha = By.id("password");
	
	private By confirmarSenha = By.id("confirmpassword");
	
	private By comentario = By.id("Comments");
	
	private By sendButton = By.id("sendemail");
	
	private By confirmarcaoEnvio = By.cssSelector("div.sweet-alert h2");
	
	private By itensAindaNaoPreenchidos = By.cssSelector("#sendquote .counter");
	
	public SendQuotePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inserirEmail(String Email) {
		driver.findElement(email).sendKeys(Email);
	}

	public void inserirTelefone(String Telefone) {
		driver.findElement(telefone).sendKeys(Telefone);
	}
	
	public void inserirUsuario(String Usuario) {
		driver.findElement(usuario).sendKeys(Usuario);
	}
	
	public void inserirSenha(String Senha) {
		driver.findElement(senha).sendKeys(Senha);
	}
	
	public void inserirConfirmacaoSenha(String Senha) {
		driver.findElement(confirmarSenha).sendKeys(Senha);
	}
	
	public void inserirComentarios(String Comentarios) {
		driver.findElement(comentario).sendKeys(Comentarios);
	}
	
	public void clicarEnviarEmail() {
		driver.findElement(sendButton).click();
	}
	
	public String confirmacaoEnvioEmail() {
		return driver.findElement(confirmarcaoEnvio).getText();
	}
	
	public Integer obterCountItensObrigatoriosNaoPreenchidos() {
		FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(itensAindaNaoPreenchidos));
		return Integer.parseInt(
				driver.findElement(itensAindaNaoPreenchidos).getText()
				);
	}
	
}
