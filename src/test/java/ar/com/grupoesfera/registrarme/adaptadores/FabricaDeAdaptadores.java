package ar.com.grupoesfera.registrarme.adaptadores;

import io.cucumber.core.backend.ObjectFactory;
import io.cucumber.picocontainer.PicoFactory;

/**
 * Extensión del PicoContainer ObjectFactory
 * que registra la implementación de AdaptadorDeTest apropiado
 * basado en una system property.
 */
public class FabricaDeAdaptadores implements ObjectFactory {

    private ObjectFactory picoDelegate = new PicoFactory();

    public FabricaDeAdaptadores(){
        if( "web".equals( System.getProperty("test.adapter")) ) {
            picoDelegate.addClass(AdaptadorParaRegistrarmeWeb.class) ;
        }
        else {
            picoDelegate.addClass(AdaptadorParaRegistrarmeControlador.class);
        }
    }

    public void start(){
        picoDelegate.start();
    }

    @Override
    public void stop() {
        picoDelegate.stop();
    }

    @Override
    public boolean addClass(Class<?> aClass) {
        picoDelegate.addClass(aClass);
        return true;
    }

    @Override
    public <T> T getInstance(Class<T> aClass) {
        return (T) picoDelegate.getInstance(aClass);
    }
}