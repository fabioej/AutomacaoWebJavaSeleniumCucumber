package steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.EnterInsurantDataPage;
import pages.EnterProductDataPage;
import pages.EnterVehicleDataPage;
import pages.SelectPriceOptionPage;
import pages.SendQuotePage;

public class PreencherFormulariosSeguroSteps {

	private static WebDriver driver;
	private EnterVehicleDataPage enterVehicleDataPage = new EnterVehicleDataPage(driver);
	
	EnterInsurantDataPage enterInsurantDataPage;
	EnterProductDataPage enterProductDataPage;
	SelectPriceOptionPage selectPriceOptionPage;
	SendQuotePage sendQuotePage;

	@Before
	public static void inicializar() {
		//configuracao para executar no macos
		File chromeDriver = new File("/usr/local/bin/chromedriver");
		System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
		//caso for utilizar no windows colocar o arquivo chromedriver em uma pasta ("C:\\Tools\\selenium\\chromedriver.exe")
		//comentar as duas linhas anteriores e remover comentario da linha seguinte
		//System.setProperty("webdriver.chrome.driver", "C:\\Tools\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Dado("que selecionei a cotacao do seguro para Automovel")
	public void que_selecionei_a_cotacao_do_seguro_para_automovel() {
		enterVehicleDataPage.carregarPaginaInicial();
		enterVehicleDataPage.selecionarCotacaoParaAutomovel();
		
		assertThat(enterVehicleDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(7));
	}

	@Quando("preecho o formulario com dados do veiculo: {string}, {string}, {string}, {string}, {string} , {string} , {string} e {string}")
	public void preecho_o_formulario_com_dados_do_veiculo_e(String marca, String performanceMotor, String dataDeManufatura, String numeroDeLugares, String combustivel, String precoDeTabela, String placa, String mileageAnual) {
		enterVehicleDataPage.selecionarMarca(marca);
		assertThat(enterVehicleDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(6));
		
		enterVehicleDataPage.inserirPerformanceMotor(performanceMotor);
		assertThat(enterVehicleDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(5));
	
		enterVehicleDataPage.inserirDataDeFabricacao(dataDeManufatura);
		assertThat(enterVehicleDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(4));
		
		enterVehicleDataPage.selecionarNumeroDeLugares(numeroDeLugares);
		assertThat(enterVehicleDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(3));
		
		enterVehicleDataPage.selecionarTipoDeCombustivel(combustivel);
		assertThat(enterVehicleDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(2));
		
		enterVehicleDataPage.inserirPreco(precoDeTabela);
		assertThat(enterVehicleDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(1));
		
		enterVehicleDataPage.inserirPlaca(placa);
		assertThat(enterVehicleDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(1));
		
		enterVehicleDataPage.inserirMileageAnual(mileageAnual);
		assertThat(enterVehicleDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(0));
		
		enterInsurantDataPage  = enterVehicleDataPage.clicarNext();
		assertThat(enterInsurantDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(7));
	}
	
	@Quando("preencho o formulario com os dados do segurado: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} e {string}")
	public void preencho_o_formulario_com_os_dados_do_segurado_e(String nome, String sobrenome, String dataDeNascimento, String genero, String rua, String pais, String codPostal, String Cidade, String emprego, String Hobbie, String webSite) {
		enterInsurantDataPage.inserirPrimeiroNome(nome);
		assertThat(enterInsurantDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(6));
		
		enterInsurantDataPage.inserirSobrenome(sobrenome);
		assertThat(enterInsurantDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(5));
		
		enterInsurantDataPage.inserirDataDeNascimento(dataDeNascimento);		
		enterInsurantDataPage.selecionarGenero(genero);
		enterInsurantDataPage.inserirRua(rua);
		assertThat(enterInsurantDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(4));
	
		
		enterInsurantDataPage.selecionarPais(pais);
		assertThat(enterInsurantDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(3));
		
		enterInsurantDataPage.inserirCodigoPostal(codPostal);
		enterInsurantDataPage.inserirCidade(Cidade);
		assertThat(enterInsurantDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(2));
		
		enterInsurantDataPage.selecionarEmprego(emprego);
		assertThat(enterInsurantDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(1));
		
		
		enterInsurantDataPage.inserirHobbiee(Hobbie);
		assertThat(enterInsurantDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(0));
		
		enterInsurantDataPage.inserirWebSite(webSite);
		
		enterProductDataPage = enterInsurantDataPage.clicarNext();
		assertThat(enterProductDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(6));
	}
	

	@Quando("preencho os dados do seguro desejado: {string}, {string}, {string}, {string}, {string} e {string}")
	public void preencho_os_dados_do_seguro_desejado_e(String dataDeInicioSeguro, String somaSeguro, String classeDeBonus, String coberturaSeguro,
			String produtosOpcionais, String carroReserva) {
assertThat(enterProductDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(6));
		
		enterProductDataPage.dataDeInicioSeguro(dataDeInicioSeguro);
		assertThat(enterProductDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(5));
		
		enterProductDataPage.selecionarSomaSeguro(somaSeguro);
		assertThat(enterProductDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(4));
		
		enterProductDataPage.selecionarClasseDeBonus(classeDeBonus);
		assertThat(enterProductDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(3));
		
		enterProductDataPage.selecionarCoberturaDeDanos(coberturaSeguro);
		assertThat(enterProductDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(2));
		
	
		enterProductDataPage.selecionarProdutosOpcionais(produtosOpcionais);
		assertThat(enterProductDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(1));
		
		enterProductDataPage.selecionarCarroCortesia(carroReserva);
		assertThat(enterProductDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(0));
		
		selectPriceOptionPage = enterProductDataPage.clicarNext();
	}

	@Quando("seleciono o {string} desejado")
	public void seleciono_o_desejado(String plano) {
		selectPriceOptionPage.selecionarPlano(plano);
		assertThat(selectPriceOptionPage.obterCountItensObrigatoriosNaoPreenchidos(), is(0));
		sendQuotePage = selectPriceOptionPage.clicarNext();
		
		assertThat(sendQuotePage.obterCountItensObrigatoriosNaoPreenchidos(), is(4));
	}

	@Quando("forneco os dados para envido da cotacao dos seguro: {string}, {string}, {string}, {string}, {string}")
	public void forneco_os_dados_para_envido_da_cotacao_dos_seguro(String email, String telefone, String usuario, String senha, String comentario) {
		
		assertThat(sendQuotePage.obterCountItensObrigatoriosNaoPreenchidos(), is(4));
		
		sendQuotePage.inserirEmail(email);
		
		assertThat(sendQuotePage.obterCountItensObrigatoriosNaoPreenchidos(), is(3));
		
		sendQuotePage.inserirTelefone(telefone);
		sendQuotePage.inserirUsuario(usuario);
		
		assertThat(sendQuotePage.obterCountItensObrigatoriosNaoPreenchidos(), is(2));
		
		sendQuotePage.inserirSenha(senha);
		
		assertThat(sendQuotePage.obterCountItensObrigatoriosNaoPreenchidos(), is(1));
		
		sendQuotePage.inserirConfirmacaoSenha(senha);
		sendQuotePage.inserirComentarios(comentario);
		
		assertThat(sendQuotePage.obterCountItensObrigatoriosNaoPreenchidos(), is(0));
			
	}

	@Entao("devo clicar em enviar")
	public void devo_clicar_em_enviar() {
		sendQuotePage.clicarEnviarEmail();
	}

	@Entao("devo ver a mensagem de {string}")
	public void devo_ver_a_mensagem_de(String enviadoComSucesso) {
		assertThat(sendQuotePage.confirmacaoEnvioEmail(), is(enviadoComSucesso));
	}

	//salva screenshot ao final da execucao do teste
	@After(order = 1)
	public void capturarTela(Scenario scenario) {
		TakesScreenshot camera = (TakesScreenshot) driver;
		File capturaDeTela = camera.getScreenshotAs(OutputType.FILE);
		String arquivoScreenshot = "src/test/resources/screenshots/" +  scenario.getName() + "_" + scenario.getStatus() + ".png";
		
		try {
			Files.move(capturaDeTela, new File(arquivoScreenshot));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@After(order = 0)
	public static void finalizar() {
		driver.quit();
	}

}
