package sifrovani;

import java.io.*;
/**
 * 
 * @author Tomáš Rousek
 * @version 1.0
 */

public class Sifra implements ISifra {
	
	private File file;
	private BufferedReader bf;
	private String textInFile;
	private char [] code;
	
	/*
	 * Konstruktor
	 */
	public Sifra(String code, String path) throws IOException {
		this.setPathTo(path);
		this.setCode(code);
	}
	
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
	public void setCode(String code) {
		this.code = code.toCharArray();
	}  
	
	@Override
	public void cipher() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("encrypted_"+file.getName()));
		
		String word;
		String [] array;
		char[] letters;
		int indexCode = 0;
		
		while((word = br.readLine()) != null) {			
			array = word.split(" ");
			
			for(int j = 0; j < array.length; j++) {
				letters = array[j].toCharArray();
				for(int i = 0; i < letters.length; i++) {
					char x = letters[i];
					
					bw.write(Integer.toHexString(x ^ code[indexCode++])+" ");	
					if(indexCode == code.length)
						indexCode = 0;
				}
				bw.newLine();
			}
			
		}
		
		br.close();
		bw.close();
	}
	  
	@Override
	public void noCipher() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
		String textInFile = "";
		String load = "";	
		String [] array;
		
		int indexCode = 0;
		
		System.out.print("Toto je ten zašifrovaný text: ");
		
		while ((load = br.readLine())!= null) {
			array = load.split(" ");
			
			for(int i = 0; i < array.length; i++) {
				int letter = Integer.decode("#"+array[i]);
				char c = (char) (letter ^ code[indexCode++]);
				textInFile += c;
				
				if(indexCode == code.length)
					indexCode = 0;
			}
			textInFile += " ";
			
		}

		System.out.println(textInFile);
		
		br.close();
	}
	
	
}
