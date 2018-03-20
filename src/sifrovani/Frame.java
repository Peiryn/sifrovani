package sifrovani;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class Frame extends JFrame {
	
	private ISifra sifra;
	
	private Font font = new Font("Tahoma", Font.PLAIN, 16);
	
	private JLabel pathLabel;
	private JTextField pathField;
	private JButton pathButt;
	
	private Frame() {
		
		JPanel mainPane = new JPanel();
		
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
	}
	
	public static void makeFrame() {	
		Frame fr = new Frame();
		fr.setTitle("App by Rousek, Vágner");
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setLocationRelativeTo(null);
		fr.setSize(350, 200);
		fr.setVisible(true);
		fr.pack();
	}
	
	private class SetPathAction implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String path = pathField.getText();
			try {
				sifra.setPathTo(path);
			}catch(IOException ex) {
				System.out.println("Chyba při načtení souboru.");
			}
		}
		
	}

}
