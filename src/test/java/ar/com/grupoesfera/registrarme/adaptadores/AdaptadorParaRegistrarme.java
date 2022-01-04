package ar.com.grupoesfera.registrarme.adaptadores;

/**
 * Created by diego on 9/25/18.
 */
public interface AdaptadorParaRegistrarme {

    String CLAVE_VALIDA = "1234";

    void noExisteUsuario(String usuario);

    void ingresoUsuarioDuplicado(String usuario);

    void ingresoA(String path);

    void registrarme();

    void ingresoUsuario(String usuario);

    void ingresoClave(String clave);

    void usuarioSeCrea();

    void usuarioNoSeCrea();

    void vuelveARegistro(String mensaje);

    void redirigeA(String vista);
}
