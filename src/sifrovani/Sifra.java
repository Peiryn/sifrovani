package sifrovani;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Sifra implements ISifra {
	
	private File file;
	private BufferedReader bf;
	private String textInFile;
	
	private void ReadFile() throws IOException {
		bf = new BufferedReader(new FileReader(file));
		String s;
		while((s = bf.readLine())!= null) {
			textInFile += s;
		}
		bf.close();
	}

	@Override
	public void setPathTo(String path) throws IOException {
		
		file = new File(path);
		  ReadFile();
		
		
	}

	@Override
	public void XOR() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String sifrovani(String[] pole) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	private static String AsciiToBinary(String asciiString){  

        byte[] bytes = asciiString.getBytes();  
        StringBuilder binary = new StringBuilder();  
        for (byte b : bytes)  
        {  
           int val = b;  
           for (int i = 0; i < 8; i++)  
           {  
              binary.append((val & 128) == 0 ? 0 : 1);  
              val <<= 1;  
           }  
          // binary.append(' ');  
        }  
        return binary.toString();  
  }  
	
}
