package presentation;
import java.awt.GridLayout;

import javax.swing.*;
public class Eroare extends JFrame{
	private JPanel panel;
	public Eroare(){
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,0,0,70));
		panel.add(new JLabel("Nu sunt destule bucati!"));
		this.setSize(500, 500);
		this.add(panel);
		this.setVisible(true);
	}
	
}