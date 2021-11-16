package ar.com.grupoesfera.registrarme.aceptacion;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber-report/cucumber.json"},
        features = "src/test/resources/features")
public class EjecutorPruebasAceptacionIT {

}
