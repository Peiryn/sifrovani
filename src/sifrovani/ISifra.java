package sifrovani;

import java.io.IOException;

/**
 * 
 * @author Vít Vágner
 * @version 1.0
 *
 */

public interface ISifra {
	
	void setPathTo(String path) throws IOException;
	
	void XOR();
	
	String sifrovani(String [] pole);
	
}
