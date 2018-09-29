package ar.com.grupoesfera.registrarme.dominio.servicios;


import ar.com.grupoesfera.registrarme.dominio.Usuario;

public interface ServicioMail {

    void enviarMailDeBienvenida(Usuario usuario);
}
