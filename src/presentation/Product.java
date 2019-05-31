package presentation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Product extends JFrame {
	private JPanel panel;
	private JButton btnAdd,btnEdit,btnDelete,btnView,back;
	public Product(){
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,0,0,70));
		btnAdd = new JButton("Adaugare Produs");
		btnEdit= new JButton("Editare Produs");
		btnDelete = new JButton("Stergere Produs");
		btnView = new JButton("Vizualizare Produse");
		back = new JButton("Back");
		
		panel.add(btnAdd);
		panel.add(btnEdit);
		panel.add(btnDelete);
		panel.add(btnView);
		panel.add(back);
		
		btnAdd.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	        AddProduct d = new AddProduct();
	        d.setVisible(true);
	        dispose();
	      }
	    });
		btnEdit.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	        EditProduct d = new EditProduct();
	        d.setVisible(true);
	        dispose();
	      }
	    });
		btnDelete.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	        DeleteProduct d = new DeleteProduct();
	        d.setVisible(true);
	        dispose();
	      }
	    });
		btnView.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	        ViewProduct d = new ViewProduct();
	        //d.setVisible(true);
	        dispose();
	      }
	    });
		back.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	        Gui d = new Gui();
	        d.setVisible(true);
	        dispose();
	      }
	    });
		this.setSize(500, 500);
		this.add(panel);
		this.setVisible(true);
	}
}