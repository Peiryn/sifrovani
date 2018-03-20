package sifrovani;

import java.io.IOException;

/**
 * Interface sloužící ke tříde Sifra
 * 
 * @author Vít Vágner
 * @version 1.3
 *
 */

public interface ISifra {
	
	void setPathTo(String path) throws IOException;
	
	void setPassword(int password);
	
	void XOR();
	
	String sifrovani(String [] pole);
	
	void createNewFile() throws IOException;
	
}
