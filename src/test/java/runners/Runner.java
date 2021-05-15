package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/preencher_formularios_seguro.feature",
		glue     = "steps",
		tags     = "@PreencherFormularioSeguro",
		plugin   = {"pretty", "html:target/cucumber.html"},
		monochrome= true
		)


public class Runner {
	

}
