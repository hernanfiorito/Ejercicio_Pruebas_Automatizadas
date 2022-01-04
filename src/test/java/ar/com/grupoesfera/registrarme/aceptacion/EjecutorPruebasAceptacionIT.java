package ar.com.grupoesfera.registrarme.aceptacion;


import ar.com.grupoesfera.registrarme.adaptadores.FabricaDeAdaptadores;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber-report/cucumber.json"},
        features = "src/test/resources/features",
        objectFactory = FabricaDeAdaptadores.class )
public class EjecutorPruebasAceptacionIT {

}
