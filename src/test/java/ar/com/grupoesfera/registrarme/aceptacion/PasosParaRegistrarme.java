package ar.com.grupoesfera.registrarme.aceptacion;

import ar.com.grupoesfera.registrarme.adaptadores.AdaptadorParaRegistrarme;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
    public void muestraMensaje(String mensaje){
        adaptador.muestraMensaje(mensaje);
    }

    @And("me encuentro en {}")
    public void meEncuentroEn(String vista){
        adaptador.meEncuentroEn(vista);
    }
}
