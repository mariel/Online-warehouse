package presentation;
import data_access.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class AddProduct extends JFrame {
	private JPanel panel;
	private JButton confirm,back;
	private JTextArea text1,text2;
	private BD baza = new BD();
	public AddProduct(){
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,0,0,70));
		confirm =new JButton("Confirmare");
		back = new JButton("Back");
		text1 = new JTextArea();
		text2 = new JTextArea();
		panel.add(new JLabel("Introduceti numele noului produs:"));
		panel.add(text1);
		panel.add(new JLabel("Introduceti numarul de bucati:"));
		panel.add(text2);
		panel.add(confirm);
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
						i=Integer.parseInt(baza.rs.getString("id"))+1;
					baza.insertStatement = baza.connection.createStatement();
					baza.insertStatement.execute(" INSERT INTO Product (id,Nume,Bucati) " + " VALUES (' " + i + " ',' " + text1.getText() + "','"+Integer.parseInt(text2.getText())+"')");
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