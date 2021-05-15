package HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

import base.BaseTests;
import pages.EnterInsurantDataPage;
import pages.EnterProductDataPage;
import pages.SelectPriceOptionPage;
import pages.SendQuotePage;

public class HomePageTests extends BaseTests{
	
	// **** MASSA DE DADOS DO TESTE ****
	
	//Dados veiculo
	String marca = "Toyota";
	String performanceMotor = "127";
	String dataDeManufatura = "06/29/2015";
	String numeroDeLugares  = "5";
	String combustivel = "Gas";
	String precoDeTabela = "12500";
	String placa = "JST6099";
	String mileageAnual = "9400";
	
	//Dados do seguro
	String nome = "Adam";
	String sobrenome = "Stone";
	String dataDeNascimento = "03/07/1988";
	String genero = "Male";
	String rua = "Rua doze de Maio, numero 07";
	String pais = "Brazil";
	String codPostal = "14070007";
	String Cidade = "São Paulo";
	String emprego = "Employee";
	String [] Hobbies = {"Bungee Jumping","Cliff Diving","Other"};
	String webSite = "https://github.com/fabioej";
	// imagem
	
	//Dados do Produto
	String dataDeInicioSeguro = "07/07/2021";
	String somaSeguro = "25000000";
	String classeDeBonus = "Bonus 7";
	String coberturaSeguro = "Full Coverage";
	String [] produtosOpcionais = {"Euro Protection","Legal Defense Insurance"};
	String carroReserva = "Yes";
	
	//Tipo do Plano
	String plano = "Gold";
	String verCotacao = "View Quote";
	String downloadCotacao = "Download Quote";
			
	//Dados de Envio da Cotação
	String email = "adam_stone@google.com";
	String telefone = "011988213344";
	String usuario = "adam_stone";
	String senha =  "aA123456";
	String comentario = "Comment only for test propose";
	String enviadoComSucesso = "Sending e-mail success!";
	
	EnterInsurantDataPage enterInsurantDataPage;
	
	EnterProductDataPage enterProductDataPage;
	
	SelectPriceOptionPage selectPriceOptionPage;
	
	SendQuotePage sendQuotePage;
	
	@Test
	public void testPreencherDadosDoVeiculo(){
		carregarPaginaInicial();
		
		enterVehicleDataPage.selecionarCotacaoParaAutomovel();
		
		assertThat(enterVehicleDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(7));
		
		//Inserindo dados do veiculo
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
	}
	
	@Test
	public void testPreencherDadosSegurado(){
		testPreencherDadosDoVeiculo();
		
		assertThat(enterInsurantDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(7));
		
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
		
		for(String i : Hobbies) {
			enterInsurantDataPage.inserirHobbiee(i);
		}
		assertThat(enterInsurantDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(0));
		
		enterInsurantDataPage.inserirWebSite(webSite);
		
		enterProductDataPage = enterInsurantDataPage.clicarNext();
	}
	
	@Test
	public void testPreencherDadosDoSeguro(){
		testPreencherDadosSegurado();
		
		assertThat(enterProductDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(6));
		
		enterProductDataPage.dataDeInicioSeguro(dataDeInicioSeguro);
		assertThat(enterProductDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(5));
		
		enterProductDataPage.selecionarSomaSeguro(somaSeguro);
		assertThat(enterProductDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(4));
		
		enterProductDataPage.selecionarClasseDeBonus(classeDeBonus);
		assertThat(enterProductDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(3));
		
		enterProductDataPage.selecionarCoberturaDeDanos(coberturaSeguro);
		assertThat(enterProductDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(2));
		
		for(String i: produtosOpcionais) {
			enterProductDataPage.selecionarProdutosOpcionais(i);
		}
		assertThat(enterProductDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(1));
		
		enterProductDataPage.selecionarCarroCortesia(carroReserva);
		assertThat(enterProductDataPage.obterCountItensObrigatoriosNaoPreenchidos(), is(0));
		
		selectPriceOptionPage = enterProductDataPage.clicarNext();
	}
	
	@Test
	public void testSelecionarOpcaoDePreco(){
		testPreencherDadosDoSeguro();
		
		assertThat(selectPriceOptionPage.obterCountItensObrigatoriosNaoPreenchidos(), is(1));
		selectPriceOptionPage.selecionarPlano(plano);
		
		//assertTrue(selectPriceOptionPage.botaoNextEstaVisivel());
		assertThat(selectPriceOptionPage.obterCountItensObrigatoriosNaoPreenchidos(), is(0));
		sendQuotePage = selectPriceOptionPage.clicarNext();
		
	}
	
	@Test
	public void testEnviarCotacaoSeguro(){
		testSelecionarOpcaoDePreco();
		
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
		
		sendQuotePage.clicarEnviarEmail();
		
		assertThat(sendQuotePage.confirmacaoEnvioEmail(), is(enviadoComSucesso));

	}

}
