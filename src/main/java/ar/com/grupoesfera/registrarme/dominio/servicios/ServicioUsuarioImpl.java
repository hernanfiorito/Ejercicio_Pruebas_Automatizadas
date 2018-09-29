package ar.com.grupoesfera.registrarme.dominio.servicios;

import javax.inject.Inject;

import ar.com.grupoesfera.registrarme.dominio.Usuario;
import ar.com.grupoesfera.registrarme.dominio.UsuarioExistente;
import ar.com.grupoesfera.registrarme.dominio.RepositorioUsuario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("servicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

	@Inject
	private RepositorioUsuario repositorioUsuario;

	@Inject
	private ServicioMail servicioMail;

	@Override
	public Usuario consultarUsuario (Usuario usuario) {
		return repositorioUsuario.consultarUsuario(usuario);
	}

	@Override
	public void registrar(Usuario usuario) throws UsuarioExistente {
		Usuario usuarioEncontrado = repositorioUsuario.buscarPor(usuario.getEmail());
		if(usuarioEncontrado != null){
			throw new UsuarioExistente();
		}
		repositorioUsuario.guardar(usuario);
		servicioMail.enviarMailDeBienvenida(usuario);
	}

	// IoC setters
	public void setRepositorioUsuario(RepositorioUsuario repositorioUsuario) {
		this.repositorioUsuario = repositorioUsuario;
	}

	public void setServicioMail(ServicioMail servicioMail) {
		this.servicioMail = servicioMail;
	}
}
