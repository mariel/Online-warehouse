package presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import data_access.*;
import javax.swing.*;
public class DeleteProduct extends JFrame {
	private JPanel panel;
	private JButton confirm,back;
	private JTextArea text1;
	BD baza = new BD();
	public DeleteProduct(){
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,0,0,70));
		text1= new JTextArea();
		
		panel.add(new JLabel("Introduceti id-ul produsului pe care doriti sa il stergeti"));
		panel.add(text1);
		confirm = new JButton("Confirm");
		panel.add(confirm);
		back = new JButton("Back");
		panel.add(back);
		confirm.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try {
					int i=0;
					baza.selectStatement = baza.connection.createStatement();
					baza.selectStatement.execute("SELECT * FROM Product");
					baza.rs = baza.selectStatement.getResultSet();
					baza.rsmd = baza.rs.getMetaData();
			        
					while(baza.rs.next())
						i++;
					baza.deleteStatement = baza.connection.createStatement();
					baza.deleteStatement.execute(" DELETE From product where id="+Integer.parseInt(text1.getText()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Product d = new Product();
		        d.setVisible(true);
		        dispose();
			}
		});
		back.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	        Product d = new Product();
	        d.setVisible(true);
	        dispose();
	      }
	    });
		this.setSize(500, 500);
		this.add(panel);
		this.setVisible(true);
	}
}