package ar.com.grupoesfera.registrarme.adaptadores;

/**
 * Created by diego on 9/25/18.
 */
public interface AdaptadorParaRegistrarme {

    void noExiteUsuario(String usuario);

    void ingresoUsuarioDuplicado(String usuario, String clave);

    void ingresoA(String path);

    void registrarme();

    void ingresoUsuario(String usuario);

    void ingresoClave(String clave);

    void usuarioSeCrea();

    void usuarioNoSeCrea();

    void vuelveARegistro(String mensaje);

    void redirigeA(String vista);
}
