package ar.com.grupoesfera.registrarme.adaptadores;

import ar.com.grupoesfera.registrarme.controladores.ControladorRegistrarme;
import ar.com.grupoesfera.registrarme.dominio.Usuario;
import ar.com.grupoesfera.registrarme.dominio.servicios.ServicioMailImpl;
import ar.com.grupoesfera.registrarme.dominio.servicios.ServicioUsuarioImpl;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class AdaptadorParaRegistrarmeControlador implements AdaptadorParaRegistrarme {

    private ControladorRegistrarme controlador = new ControladorRegistrarme();

    private ServicioUsuarioImpl servicio = new ServicioUsuarioImpl();

    private RepositorioUsuarioEnMemoria repositorioUsuario = new RepositorioUsuarioEnMemoria();

    private Usuario usuario;

    private ModelAndView modelAndView;

    public AdaptadorParaRegistrarmeControlador(){
        servicio.setRepositorioUsuario( repositorioUsuario );
        servicio.setServicioMail(new ServicioMailImpl());
        controlador.setServicio( servicio );

        usuario = new Usuario();
        usuario.setEmail(EMAIL_VALIDO);
    }

    public void noExisteUsuario(String usuario){
        // no hace nada
    }

    public void agregarUsuario(String email){
        registrarmeConUsuario(email);
    }

    public void registrarmeConUsuario(String email){
        registrarme(email, CLAVE_VALIDA);
    }

    public void registrarmeConClave(String clave){
        registrarme(EMAIL_VALIDO, clave);
    }

    private void registrarme(String email, String clave) {
        this.usuario.setEmail(email);
        this.usuario.setPassword(clave);
        modelAndView = controlador.registrarme(this.usuario);
    }

    public void usuarioSeCrea() {
        assertThat(servicio.consultarUsuario(usuario).getEmail()).isEqualTo(usuario.getEmail());
    }

    public void usuarioNoEstaRegistrado(){
        Usuario usuarioBuscado = null;
        try{
            usuarioBuscado = servicio.consultarUsuario(this.usuario);
        }
        catch (Exception e){}
        assertThat(usuarioBuscado).isNull();
    }

    public void muestraMensaje(String mensaje){
        assertThat(modelAndView.getModel().get("error")).isEqualTo(mensaje);
    }

    public void meEncuentroEn(String vista){
        assertThat(modelAndView.getViewName()).contains(vista);
    }

    @Override
    public void borrarRepositorio() {
        repositorioUsuario.vaciar();
    }
}
