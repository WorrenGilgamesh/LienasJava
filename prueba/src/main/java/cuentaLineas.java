/**
* The cuentaLineas program lee un documento y te pasa las lineas de comentario y codigo
*
*
* @author  WorrenGilgamesh
* @version 1.0
* @since   2018-04-19 
*/
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class cuentaLineas {

    public void imprimeln() throws IOException{
        RandomAccessFile file = new RandomAccessFile(System.getProperty("user.dir")+"/Archivo01.java", "r");

        FileChannel channel = file.getChannel();

        System.out.println("File size is: " + channel.size());

        ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());

        channel.read(buffer);

        buffer.flip();//Restore buffer to position 0 to read it

        System.out.println("Reading content and printing ... ");

        for (int i = 0; i < channel.size(); i++) {
            System.out.print((char) buffer.get());
        }

        channel.close();
        file.close();
    }

    
}
