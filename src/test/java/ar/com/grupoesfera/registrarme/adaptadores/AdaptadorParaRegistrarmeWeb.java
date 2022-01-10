package ar.com.grupoesfera.registrarme.adaptadores;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class AdaptadorParaRegistrarmeWeb implements AdaptadorParaRegistrarme {

    protected String port = System.getProperty("servlet.port", "8080");
    protected String urlBase = "http://localhost:" + port + "/sitio";
    protected WebDriver seleniumDriver;

    public AdaptadorParaRegistrarmeWeb() {
        usarPhantomJS(); //        usarChrome();

        seleniumDriver.manage().window().maximize();
        seleniumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        seleniumDriver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        seleniumDriver.close();
    }

    private void usarPhantomJS(){
        seleniumDriver = new PhantomJSDriver();
    }

    private void usarChrome(){
        System.setProperty("webdriver.chrome.driver", "/usr/bin/selenium-drivers/chromedriver");
        seleniumDriver = new ChromeDriver();
    }

    public void noExisteUsuario(String usuario){
        // no hace nada
    }

    public void agregarUsuario(String usuario){
        registrarme(usuario);
    }

    public void registrarme(String usuario){
        seleniumDriver.get(urlBase + "/nuevo-usuario");
        seleniumDriver.findElement(By.id("email")).sendKeys(usuario);
        seleniumDriver.findElement(By.id("password")).sendKeys(CLAVE_VALIDA);
        seleniumDriver.findElement(By.id("btn-registrarme")).click();
    }

    public void usuarioSeCrea(){}

    public void usuarioNoEstaRegistrado(){}

    public void muestraMensaje(String mensaje){
        assertThat(seleniumDriver.getPageSource()).contains(mensaje);
    }

    public void meEncuentroEn(String vista){
        assertThat(seleniumDriver.getTitle()).isEqualToIgnoringCase(vista);
    }
}
