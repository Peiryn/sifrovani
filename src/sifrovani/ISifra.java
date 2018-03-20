package sifrovani;


/**
 * 
 * @author Vít Vágner
 * @version 1.0
 *
 */

public interface ISifra {
	
	void setPathTo(String path);
	
	void XOR();
	
	String sifrovani(String [] pole);
	
}
