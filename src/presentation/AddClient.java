package presentation;
import data_access.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class AddClient extends JFrame {
	private JPanel panel;
	private JButton confirm,back;
	private JTextArea text;
	private BD baza = new BD();
	private int deleted =0;
	public AddClient(){
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,0,0,70));
		confirm =new JButton("Confirmare");
		back = new JButton("Back");
		text = new JTextArea();
		panel.add(new JLabel("Introduceti numele noului client"));
		panel.add(text);
		panel.add(confirm);
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
						i=Integer.parseInt(baza.rs.getString("id"))+1;
					baza.insertStatement = baza.connection.createStatement();
					baza.insertStatement.execute(" INSERT INTO Client (id,Nume) " + " VALUES (' " + (i+deleted) + " ',' " + text.getText() + "')");
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