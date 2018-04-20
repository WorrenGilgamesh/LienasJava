import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
public class TestCuentaLineas{
    cuentaLineas bla = new cuentaLineas();
    @Test
    public void prueba1() throws IOException{
        System.out.println("Estoy en prueba uno");
        bla.imprimeln();
    }
}
