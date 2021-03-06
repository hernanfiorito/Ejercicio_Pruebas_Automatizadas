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

    public void noExiteUsuario(String usuario){
        // no hace nada
    }

    public void ingresoUsuarioDuplicado(String usuario, String clave){
        seleniumDriver.get(urlBase + "/nuevo-usuario");
        seleniumDriver.findElement(By.id("email")).sendKeys(usuario);
        seleniumDriver.findElement(By.id("password")).sendKeys(clave);
        seleniumDriver.findElement(By.id("btn-registrarme")).click();
    }

    public void ingresoA(String path){
        seleniumDriver.get(urlBase + "/" + path);
    }

    public void ingresoUsuario(String usuario){
        seleniumDriver.findElement(By.id("email")).sendKeys(usuario);
    }
    public void ingresoClave(String clave){
        seleniumDriver.findElement(By.id("password")).sendKeys(clave);
    }
    public void registrarme(){
        seleniumDriver.findElement(By.id("btn-registrarme")).click();
    }

    public void usuarioSeCrea(){}

    public void usuarioNoSeCrea(){}

    public void vuelveARegistro(String mensaje){
        assertThat(seleniumDriver.getPageSource()).contains(mensaje);
    }

    public void redirigeA(String vista){
        assertThat(seleniumDriver.getTitle()).isEqualToIgnoringCase(vista);
    }
}
