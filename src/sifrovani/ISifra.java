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
	
	void setPassword(String password) throws PassException;
	
	void XOR();
	
	String sifrovani(String [] pole);
	
	void createNewFile() throws IOException;
	
}
