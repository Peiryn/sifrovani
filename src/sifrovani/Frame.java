package sifrovani;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

/**
 * Třída sloužící jako user interface k programu
 * 
 * @author Vít Vágner
 * @version 1.2
 *
 */
public class Frame extends JFrame {
	
	private ISifra sifra;
	
	private Font font = new Font("Tahoma", Font.PLAIN, 20);
	
	private JLabel pathLabel;
	private JTextField pathField;
	
	private JLabel passLabel;
	private JTextField passField;
	private JButton sifrButt;
	
	private JLabel infoLabel;
	
	
	private Frame() {
		sifra = new Sifra();
		
		JPanel mainPane = new JPanel();	
		
		/*
		 * Nastavení cesty k dokumentu
		 */
		JPanel pathPane = new JPanel();
		
		pathLabel = new JLabel("Zadej cestu:");
		pathLabel.setFont(font);
		
		pathField = new JTextField(10);
		pathField.setFont(font);
		
		pathPane.add(pathLabel);
		pathPane.add(pathField);
		mainPane.add(pathPane);
		
		/*
		 * Zadání binárního hesla
		 */
		JPanel passPane = new JPanel();
		
		passLabel = new JLabel("Zadej heslo k šifrování:");
		passLabel.setFont(font);
		
		passField = new JTextField(5);
		passField.setFont(font);
		
		sifrButt = new JButton("Šifruj!");
		sifrButt.setFont(font);
		sifrButt.addActionListener(new SetPathAction());
		
		passPane.add(passLabel);
		passPane.add(passField);
		passPane.add(sifrButt);
		mainPane.add(passPane);
		
		/*
		 * Info label
		 */
		infoLabel = new JLabel("");
		infoLabel.setFont(font);
		mainPane.add(infoLabel, Component.CENTER_ALIGNMENT);
		
		/*
		 * Přidání mainPane
		 */
		add(mainPane);
	}
	
	public static void makeFrame() {	
		Frame fr = new Frame();
		fr.setTitle("App by Rousek, Vágner");
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setLocationRelativeTo(null);
		fr.setSize(425, 200);
		fr.setVisible(true);
	}
	
	private class SetPathAction implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String path = pathField.getText();
			String code = passField.getText();
			
			try {
				sifra.setPathTo(path);
				sifra.setCode(code);
				sifra.cipher();
				
				infoLabel.setText("Nový soubor úspěšně zašifrován a vytvořen.");
				
			}catch(IOException ex) {
				System.out.println("Chyba při načtení souboru.");
			}
		}
		
	}

}
