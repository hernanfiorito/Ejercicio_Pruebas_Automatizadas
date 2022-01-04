package ar.com.grupoesfera.registrarme.adaptadores;

import ar.com.grupoesfera.registrarme.controladores.ControladorRegistrarme;
import ar.com.grupoesfera.registrarme.dominio.Usuario;
import ar.com.grupoesfera.registrarme.dominio.RepositorioUsuario;
import ar.com.grupoesfera.registrarme.dominio.servicios.ServicioMailImpl;
import ar.com.grupoesfera.registrarme.dominio.servicios.ServicioUsuarioImpl;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class AdaptadorParaRegistrarmeControlador implements AdaptadorParaRegistrarme {

    private ControladorRegistrarme controlador = new ControladorRegistrarme();

    private ServicioUsuarioImpl servicio = new ServicioUsuarioImpl();

    private Usuario usuario;

    private ModelAndView modelAndView;

    public AdaptadorParaRegistrarmeControlador(){
        RepositorioUsuario repositorioUsuario = new RepositorioUsuarioEnMemoria();
        servicio.setRepositorioUsuario( repositorioUsuario );
        servicio.setServicioMail(new ServicioMailImpl());
        controlador.setServicio( servicio );

        usuario = new Usuario();
        usuario.setEmail("mail@usuario.com");
    }

    public void noExisteUsuario(String usuario){
        // no hace nada
    }

    public void agregarUsuario(String email){
        registrarme(email);
    }

    public void registrarme(String email){
        this.usuario.setEmail(email);
        this.usuario.setPassword(CLAVE_VALIDA);
        modelAndView = controlador.registrarme(this.usuario);
    }

    public void ingresoClave(String clave){
        this.usuario.setPassword(clave);
    }

    public void usuarioSeCrea() {
        assertThat(servicio.consultarUsuario(usuario).getEmail()).isEqualTo(usuario.getEmail());
    }

    public void usuarioNoSeCrea(){}

    public void vuelveARegistro(String mensaje){
        assertThat(modelAndView.getModel().get("error")).isEqualTo(mensaje);
    }

    public void redirigeA(String vista){
        assertThat(modelAndView.getViewName()).contains(vista);
    }
}
