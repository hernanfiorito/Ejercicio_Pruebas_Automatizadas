package ar.com.grupoesfera.registrarme.dominio;


public interface RepositorioUsuario {
	
	Usuario consultarUsuario(Usuario usuario);

    Usuario buscarPor(String email);

    void guardar(Usuario usuario);
}
