package presentation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import data_access.BD;
public class ViewProduct extends JFrame {
	private JButton back = new JButton("back");
	private JPanel panel = new JPanel();
	private JLabel clienti = new JLabel();
	private BD baza = new BD();
	
	public ViewProduct()
	{
		
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));	
			try {
				baza.selectStatement = baza.connection.createStatement();
				baza.selectStatement.execute("SELECT * FROM Product");
				baza.rs = baza.selectStatement.getResultSet();
				baza.rsmd = baza.rs.getMetaData();
		        while(baza.rs.next()){
		        	panel.add(new JLabel("    "+ baza.rs.getString("id")+"    " + baza.rs.getString("Nume")+"     "+ baza.rs.getString("bucati")));
		            
		         }
			} 
	       
	        catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			finally {
			       if (baza.rs != null) { 
			          try { 
			              baza.rs.close();  
			          } 
			          catch(SQLException e) {
			          }  
			          baza.rs = null;  
			       }
			       if (baza.selectStatement != null) { 
			          try { 
			              baza.selectStatement.close();  
			          } 
			          catch(SQLException e) {}  
			          baza.selectStatement = null;  
			       }
			       if (baza.insertStatement != null) { 
			          try { 
			              baza.insertStatement.close();  
			          } 
			          catch(SQLException e) {}  
			          baza.insertStatement = null;  
			       }
			       if (baza.connection != null) { 
			          try { 
			              baza.connection.close();  
			          } 
			          catch(SQLException e) {}  
			          baza.connection = null;  
			       }
			    }
		clienti.setText(" ");
		panel.add(clienti);
		panel.add(back);
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