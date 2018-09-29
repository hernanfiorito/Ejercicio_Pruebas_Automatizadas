package ar.com.grupoesfera.registrarme.adaptadores;

import cucumber.runtime.java.picocontainer.PicoFactory;

/**
 * Extensión del PicoContainer ObjectFactory
 * que registra la implementación de AdaptadorDeTest apropiado
 * basado en una system property.
 */
public class FabricaDeAdaptadores extends PicoFactory {

    public FabricaDeAdaptadores(){
        if( "web".equals( System.getProperty("test.adapter")) ) {
            addClass(AdaptadorParaRegistrarmeWeb.class) ;
        }
        else {
            addClass(AdaptadorParaRegistrarmeControlador.class);
        }
    }
}