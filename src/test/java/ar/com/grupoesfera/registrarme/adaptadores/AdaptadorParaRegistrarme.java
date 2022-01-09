package ar.com.grupoesfera.registrarme.adaptadores;

/**
 * Created by diego on 9/25/18.
 */
public interface AdaptadorParaRegistrarme {

    String CLAVE_VALIDA = "1234";

    void noExisteUsuario(String usuario);

    void agregarUsuario(String usuario);

    void registrarme(String usuario);

    void usuarioSeCrea();

    void usuarioNoSeCrea();

    void muestraMensaje(String mensaje);

    void meEncuentroEn(String vista);
}
