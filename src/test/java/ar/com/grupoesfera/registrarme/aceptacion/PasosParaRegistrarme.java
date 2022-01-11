package ar.com.grupoesfera.registrarme.aceptacion;

import ar.com.grupoesfera.registrarme.adaptadores.AdaptadorParaRegistrarme;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasosParaRegistrarme implements AdaptadorParaRegistrarme {

    private final AdaptadorParaRegistrarme adaptador;

    public PasosParaRegistrarme(AdaptadorParaRegistrarme adaptador ){
        this.adaptador = adaptador;
    }

    @Before
    public void borrarRepositorio() {
        this.adaptador.borrarRepositorio();
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
    public void registrarmeConUsuario(String usuario){
        adaptador.registrarmeConUsuario(usuario);
    }

    @And("intento registrarme con clave {}")
    public void registrarmeConClave(String clave){
        adaptador.registrarmeConClave(clave);
    }

    @Then("el usuario se crea")
    public void usuarioSeCrea(){ adaptador.usuarioSeCrea();     }

    @Then("el usuario no está registrado")
    public void usuarioNoEstaRegistrado(){ adaptador.usuarioNoEstaRegistrado();     }

    @And("muestra el mensaje '{}'")
    public void muestraMensaje(String mensaje){
        adaptador.muestraMensaje(mensaje);
    }

    @And("me encuentro en {}")
    public void meEncuentroEn(String vista){
        adaptador.meEncuentroEn(vista);
    }
}
