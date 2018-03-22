package sifrovani;

import java.io.IOException;

/**
 * Interface sloužící ke tříde Sifra
 * 
 * @author Vít Vágner
 * @version 1.5
 *
 */

public interface ISifra {
	
	void setPathTo(String path) throws IOException;
	
	void setCode(String password) throws PassException;
	
	void cipher() throws IOException;
	
	void noCipher() throws IOException;
	
	
	
}
