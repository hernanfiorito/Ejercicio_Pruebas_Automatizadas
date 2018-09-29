package ar.com.grupoesfera.registrarme.dominio;

import ar.com.grupoesfera.registrarme.adaptadores.RepositorioUsuarioEnMemoria;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by diego on 9/26/18.
 */
public class RepositorioUsuarioEnMemoriaTest extends RepositorioUsuarioHibernateTest {

    private RepositorioUsuario repositorio = new RepositorioUsuarioEnMemoria();

    @Override
    public RepositorioUsuario repositorio() {
        return repositorio;
    }
}
