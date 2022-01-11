package ar.com.grupoesfera.registrarme.adaptadores;

import ar.com.grupoesfera.registrarme.dominio.Usuario;
import ar.com.grupoesfera.registrarme.dominio.RepositorioUsuario;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by diego on 9/26/18.
 */
public class RepositorioUsuarioEnMemoria implements RepositorioUsuario {

    private Map<String, Usuario> usuarios = new HashMap<>();

    @Override
    public Usuario consultarUsuario(Usuario usuario) {
        Usuario usuarioEncontrado = buscarPor( usuario.getEmail() );
        if ( usuarioEncontrado != null && !usuarioEncontrado.getPassword().equals( usuario.getPassword() ) ){
            throw new RuntimeException( "Usuario inexistente" );
        }
        return usuarioEncontrado;
    }

    @Override
    public Usuario buscarPor(String email) {
        return usuarios.get(email);
    }

    @Override
    public void guardar(Usuario usuario) {
        usuarios.put(usuario.getEmail(), usuario);
    }

    public void vaciar(){
        usuarios.clear();
    }
}
