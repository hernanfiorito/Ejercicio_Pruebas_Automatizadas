package ar.com.grupoesfera.registrarme.aceptacion;

import ar.com.grupoesfera.registrarme.adaptadores.AdaptadorParaRegistrarme;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class PasosParaRegistrarme implements AdaptadorParaRegistrarme {

    private final AdaptadorParaRegistrarme adaptador;

    public PasosParaRegistrarme(AdaptadorParaRegistrarme adaptador ){
        this.adaptador = adaptador;
    }

    @Given("que no existe el usuario {}")
    public void noExisteUsuario(String usuario){
        adaptador.noExisteUsuario(usuario);
    }

    @Given("que ya existe el usuario {}")
    public void agregarUsuario(String usuario){
        adaptador.agregarUsuario(usuario);
    }

    @When("intento registrarme como {}")
    public void registrarme(String usuario){
        adaptador.registrarme(usuario);
    }

    @And("ingreso la clave {}")
    public void ingresoClave(String clave){
        adaptador.ingresoClave(clave);
    }

    @Then("el usuario se crea")
    public void usuarioSeCrea(){ adaptador.usuarioSeCrea();     }

    @Then("el usuario NO se crea")
    public void usuarioNoSeCrea(){ adaptador.usuarioNoSeCrea();     }

    @And("muestra el mensaje '{}'")
    public void vuelveARegistro(String mensaje){
        adaptador.vuelveARegistro(mensaje);
    }

    @And("me redirige a la vista {}")
    public void redirigeA(String vista){
        adaptador.redirigeA(vista);
    }

}
