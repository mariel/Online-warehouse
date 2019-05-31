package presentation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import business_logic.*;
import data_access.*;
import javax.swing.*;
public class PlaceOrder extends JFrame {
	private JPanel panel;
	private JComboBox client,produs;
	private JTextArea bucati;
	private JButton confirm;
	private BD baza=new BD();
	public PlaceOrder(){
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,0,0,70));
		confirm = new JButton("Confirm");
		client = new JComboBox();
		try {
			baza.selectStatement = baza.connection.createStatement();
			baza.selectStatement.execute("SELECT * FROM Client");
			baza.rs = baza.selectStatement.getResultSet();
			baza.rsmd = baza.rs.getMetaData();
	        
			while(baza.rs.next())
				client.addItem(""+baza.rs.getString("id"));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		produs = new JComboBox();
		try {
			baza.selectStatement = baza.connection.createStatement();
			baza.selectStatement.execute("SELECT * FROM Product");
			baza.rs = baza.selectStatement.getResultSet();
			baza.rsmd = baza.rs.getMetaData();
	        
			while(baza.rs.next())
				produs.addItem(""+baza.rs.getString("id"));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		bucati = new JTextArea();
		panel.add(new JLabel("Please choose a client and a product then insert the number of pieces"));
		panel.add(client);
		panel.add(produs);
		panel.add(bucati);
		panel.add(confirm);
		
		confirm.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try {
					int i=0;
					baza.selectStatement = baza.connection.createStatement();
					baza.selectStatement.execute("SELECT * FROM ordermanagement.`order`;");
					baza.rs = baza.selectStatement.getResultSet();
					baza.rsmd = baza.rs.getMetaData();
					while(baza.rs.next())
						i++;
					baza.selectStatement = baza.connection.createStatement();
					baza.selectStatement.execute("SELECT * FROM Product where id ='"+produs.getSelectedIndex() +"'");
					baza.rs = baza.selectStatement.getResultSet();
					baza.rsmd = baza.rs.getMetaData();
					if(baza.rs.next())
					{	
						int j= baza.rs.getInt("Bucati");
						if(j < Integer.parseInt(bucati.getText()))
							{
								Eroare d = new Eroare();
								d.setVisible(true);
							}
						else{
							baza.insertStatement = baza.connection.createStatement();
							baza.insertStatement.execute("INSERT INTO ordermanagement.order (id,Quantity,Client_id,Product_id) " + " VALUES ("+ i +","+Integer.parseInt(bucati.getText()) + "," + client.getSelectedIndex() + ","+produs.getSelectedIndex() + ")");
							baza.updateStatement = baza.connection.createStatement();
							baza.updateStatement.execute("UPDATE Product set Bucati ='"+ (j - Integer.parseInt(bucati.getText()))+"' where id="+produs.getSelectedIndex() +"");
							baza.selectStatement = baza.connection.createStatement();
							baza.selectStatement.execute("SELECT * FROM Product where id ='"+produs.getSelectedIndex() +"'");
							baza.rs = baza.selectStatement.getResultSet();
							baza.rsmd = baza.rs.getMetaData();
							baza.rs.next();
							String pro = new String(baza.rs.getString("Nume"));
							
							baza.selectStatement.execute("SELECT * FROM Client where id ='"+client.getSelectedIndex() +"'");
							baza.rs = baza.selectStatement.getResultSet();
							baza.rsmd = baza.rs.getMetaData();
							baza.rs.next();
							String cli = new String(baza.rs.getString("Nume"));
							Bill x = new Bill(i,Integer.parseInt(bucati.getText()),cli,pro);
							Gui d = new Gui();
					        d.setVisible(true);
					        dispose();
							}
					}} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		this.setSize(500, 500);
		this.add(panel);
		this.setVisible(true);
	}
}