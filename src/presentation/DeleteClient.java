package presentation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import data_access.*;
import javax.swing.*;
public class DeleteClient extends JFrame {
private JPanel panel;
private JButton back, confirm;
private JTextArea text1;
BD baza =new BD();
	public DeleteClient(){
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,0,0,70));
		text1= new JTextArea();
		panel.add(new JLabel("Introduceti id-ul Clientului pe care doriti sa il stergeti:"));
		panel.add(text1);
		confirm =  new JButton("Confirm");
		back = new JButton("Back");
		
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
					baza.deleteStatement = baza.connection.createStatement();
					baza.deleteStatement.execute(" DELETE From Client where id="+Integer.parseInt(text1.getText()));
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
		panel.add(confirm);
		panel.add(back);
		this.setSize(500, 500);
		this.add(panel);
		this.setVisible(true);
	}
}