package ar.com.grupoesfera.registrarme.adaptadores;

/**
 * Created by diego on 9/25/18.
 */
public interface AdaptadorParaRegistrarme {

    String CLAVE_VALIDA = "123456";

    void noExisteUsuario(String usuario);

    void agregarUsuario(String usuario);

    void registrarme(String usuario);

    void registrarmeConClave(String clave);

    void usuarioSeCrea();

    void usuarioNoEstaRegistrado();

    void muestraMensaje(String mensaje);

    void meEncuentroEn(String vista);

    void borrarRepositorio();
}
