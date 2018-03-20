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
 * @version 1.0
 *
 */
public class Frame extends JFrame {
	
	private ISifra sifra;
	
	private Font font = new Font("Tahoma", Font.PLAIN, 16);
	
	private JLabel pathLabel;
	private JTextField pathField;
	private JButton pathButt;
	
	private JLabel infoLabel;
	
	private Frame() {
		sifra = new Sifra();
		
		JPanel mainPane = new JPanel();
		
		/*
		 * Nastavení cesty k dokumentu
		 */
		pathLabel = new JLabel("Zadej cestu:");
		pathLabel.setFont(font);
		pathField = new JTextField(10);
		pathField.setFont(font);
		pathButt = new JButton("Nacti");
		pathButt.addActionListener(new SetPathAction());
		pathButt.setFont(font);
		
		mainPane.add(pathLabel);
		mainPane.add(pathField);
		mainPane.add(pathButt);
		add(mainPane);
		
		/*
		 * Info label
		 */
		infoLabel = new JLabel("");
		infoLabel.setFont(font);
		mainPane.add(infoLabel, Component.CENTER_ALIGNMENT);
	}
	
	public static void makeFrame() {	
		Frame fr = new Frame();
		fr.setTitle("App by Rousek, Vágner");
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setLocationRelativeTo(null);
		fr.setSize(350, 125);
		fr.setVisible(true);
	}
	
	private class SetPathAction implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String path = pathField.getText();
			try {
				sifra.setPathTo(path);
				
				infoLabel.setText("Soubor úspěšně zašifrován.");
			}catch(IOException ex) {
				System.out.println("Chyba při načtení souboru.");
			}
		}
		
	}

}
