package ar.com.grupoesfera.registrarme.dominio.servicios;


import ar.com.grupoesfera.registrarme.dominio.Usuario;
import ar.com.grupoesfera.registrarme.dominio.UsuarioExistente;

public interface ServicioUsuario {

	Usuario consultarUsuario(Usuario usuario);

    void registrar(Usuario usuario) throws UsuarioExistente;
}
