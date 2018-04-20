/**
* The cuentalineaaas program lee un documento y te pasa las lineaaas de comentario y codigo
*
*
* @author  WorrenGilgamesh
* @version 1.0
* @since   2018-04-19 
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class cuentaLineas {

    public String imprimeln(BufferedReader bReader) throws IOException{
		int count = 0,countComent = 0;
		boolean prinComent = false;
        String linea=null,linea2 = null;
        Pattern pattern =null;
        Matcher matcher = null;
		while ((linea = bReader.readLine()) != null) {
			linea = linea.trim();
			if ("".equals(linea) || linea.startsWith("//"))continue;
			if (prinComent) {
				if (terminaComent(linea)) {
					linea = linea.substring(linea.indexOf("*/") + 2).trim();
					prinComent = false;
					if ("".equals(linea) || linea.startsWith("//")) {
						continue;
					}
				} else
					continue;
			}
			if (esCodigo(linea)) count++;
            pattern = Pattern.compile("(?://.*)");
            matcher = pattern.matcher(linea);
            while (matcher.find()) countComent++;
            linea2+=linea;
			if (empiezaComent(linea)) {
				prinComent = true;
			}
        }
        pattern = Pattern.compile("/\\*(.|[\\r\\n])*?\\*/");
        matcher = pattern.matcher(linea2);
        while (matcher.find()) countComent++;
		return countCode+""+countComent;
		return count+"";
    }

public boolean empiezaComent(String lineaaa){
    int index = lineaaa.indexOf("/*");
		if (index < 0) {
			return false;
		}
		int indexComQuote = lineaaa.indexOf("\"");
		if (indexComQuote != -1 && indexComQuote < index) {
			while (indexComQuote > -1) {
				lineaaa = lineaaa.substring(indexComQuote + 1);
				int indexFinQuote = lineaaa.indexOf("\"");
				lineaaa = lineaaa.substring(indexFinQuote + 1);
				indexComQuote = lineaaa.indexOf("\"");
			}
			return empiezaComent(lineaaa);
		}
		return !terminaComent(lineaaa.substring(index + 2));
}

public boolean terminaComent(String lineaaa){
    int index = lineaaa.indexOf("*/");
		if (index < 0) {
			return false;
		} else {
			String subString = lineaaa.substring(index + 2).trim();
			if ("".equals(subString) || subString.startsWith("//")) {
				return true;
			}
			if(empiezaComent(subString))
			{
				return false;
			}
			else
			{
				return true;
			}
		}
}

public boolean esCodigo(String lineaa){
    boolean siCodigo = false;
		lineaa = lineaa.trim();
		if ("".equals(lineaa) || lineaa.startsWith("//")) {
			return siCodigo;
		}
		if (lineaa.length() == 1) {
			return true;
		}
		int index = lineaa.indexOf("/*");
		if (index != 0) {
			return true;
		} else {
			while (lineaa.length() > 0) {
				lineaa = lineaa.substring(index + 2);
				int finPosComentn = lineaa.indexOf("*/");
				if (finPosComentn < 0) {
					return false;
				}
				if (finPosComentn == lineaa.length() - 2) {
					return false;
				} else {
					String subString = lineaa.substring(finPosComentn + 2)
							.trim();
					if ("".equals(subString) || subString.indexOf("//") == 0) {
						return false;
					} else {
						if (subString.startsWith("/*")) {
							lineaa = subString;
							continue;
						}
						return true;
					}
				}

			}
		}
		return siCodigo;
	}
}

    

