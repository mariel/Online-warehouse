package presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import data_access.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class EditClient extends JFrame {
	private JPanel panel;
	private JButton confirm,back;
	private JTextArea text1,text2;
	BD baza = new BD();
	public EditClient(){
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,0,0,70));
		text1 =new JTextArea();
		text2 = new JTextArea();
		panel.add(new JLabel("Alegeti clientul caruia ii schimbati numele: "));
		panel.add(text1);
		panel.add(new JLabel("Introduceti noul nume al clientului"));
		panel.add(text2);
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
					baza.selectStatement.execute("SELECT * FROM Client");
					baza.rs = baza.selectStatement.getResultSet();
					baza.rsmd = baza.rs.getMetaData();
			        
					while(baza.rs.next())
						i++;
					baza.updateStatement = baza.connection.createStatement();
					baza.updateStatement.execute(" UPDATE Client set Nume='"+text2.getText()+"' Where id ="+Integer.parseInt(text1.getText()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Client d = new Client();
		        d.setVisible(true);
		        dispose();
			}
		});
		back.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	        Client d = new Client();
	        d.setVisible(true);
	        dispose();
	      }
	    });
		this.setSize(500, 500);
		this.add(panel);
		this.setVisible(true);
	}
	
}