package presentation;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Client extends JFrame {
	private JPanel panel;
	private JButton btnAdd,btnEdit,btnDelete,btnView,Back;
	
	public Client(){
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,0,0,70));
		btnAdd = new JButton("Adaugare Client");
		btnAdd.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	        AddClient d = new AddClient();
	        d.setVisible(true);
	        dispose();
	      }
	    });


		btnEdit= new JButton("Editare Client");
		btnEdit.addActionListener(new ActionListener()
	    {
	      
		public void actionPerformed(ActionEvent e)
	      {
	        EditClient d = new EditClient();
	        d.setVisible(true);
	        dispose();	        
	      }
	    });
		btnDelete = new JButton("Stergere Client");
		btnDelete.addActionListener(new ActionListener()
	    {
	      
		public void actionPerformed(ActionEvent e)
	      {
	        DeleteClient d = new DeleteClient();
	        d.setVisible(true);
	        dispose();	        
	      }
	    });
		btnView = new JButton("Vizualizare Clienti");
		btnView.addActionListener(new ActionListener()
	    {
	      
		public void actionPerformed(ActionEvent e)
	      {
	        ViewClient d = new ViewClient();
	         d.setVisible(true);
	        dispose();	        
	      }
	    });
		
		Back = new JButton("Back");
		Back.addActionListener(new ActionListener()
	    {
	      
		public void actionPerformed(ActionEvent e)
	      {
	        Gui d = new Gui();
	        d.setVisible(true);
	        dispose();	        
	      }
	    });
		panel.add(btnAdd);
		panel.add(btnEdit);
		panel.add(btnDelete);
		panel.add(btnView);
		panel.add(Back);
		
		this.setSize(500, 500);
		this.add(panel);
		this.setVisible(true);
	}
}