package presentation;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import data_access.*;

import javax.swing.*;
public class EditProduct extends JFrame {
	private JPanel panel;
	private JButton back,confirm;
	private JTextArea text1,text2,text3;
	BD baza = new BD();
	public EditProduct(){
		panel = new JPanel();
		text1 =new JTextArea();
		text2 =new JTextArea();
		text3 =new JTextArea();
		
		panel.setLayout(new GridLayout(4,0,0,70));
		
		
		panel.add(new JLabel("Introduceti numarul produsului pe care doriti sa il schimbati: "));
		panel.add(text1);
		panel.add(new JLabel("Introduceti noul nume al produsului"));
		panel.add(text2);
		panel.add(new JLabel("Introduceti numarul de bucati"));
		panel.add(text3);
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
					baza.updateStatement = baza.connection.createStatement();
					baza.updateStatement.execute(" UPDATE Product set Nume='"+text2.getText()+"' Where id ="+Integer.parseInt(text1.getText()));
					baza.updateStatement.execute(" UPDATE Product set bucati='"+Integer.parseInt(text3.getText())+"' Where id ="+Integer.parseInt(text1.getText()));
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