package sifrovani;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		

		try {	
			
			String codeString = "ahoj";			
			cipher(codeString.toCharArray(), "oldCipher.txt");		
			noCipher(codeString.toCharArray(), "newCipher.txt");	
			
		}catch(IOException e) {
			System.out.print("Error");
		}

	}
	
	public static void cipher(char[] code, String path) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF8"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("newCipher.txt"));
		
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

	public static void noCipher(char [] code, String path) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF8"));
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
