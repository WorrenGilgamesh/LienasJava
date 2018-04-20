import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.io.BufferedReader;
import java.io.FileReader;

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
        for(int i=1; i<=5;i++){
            System.out.println("Estoy en prueba "+i);
            String file = System.getProperty("user.dir")+"/Archivo0"+i+".java";
            BufferedReader br = new BufferedReader(new FileReader(file));
            String lineas = bla.imprimeln(br);
            System.out.println(lineas);
        }
    }
}
