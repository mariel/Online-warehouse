package presentation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Gui extends JFrame{
	private JPanel panel;
	private JButton Client,Product,Order;
	public Gui(){
		panel= new JPanel();
		panel.setLayout(new GridLayout(4,0,0,70));
		Client = new JButton("Client");
		Client.addActionListener(new ActionListener()
	    {
	      
		public void actionPerformed(ActionEvent e)
	      {
	        Client d = new Client();
	        d.setVisible(true);
	        dispose();	        
	      }
	    });
		panel.add(Client);
		Product = new JButton("Product");
		Product.addActionListener(new ActionListener()
	    {
	      
		public void actionPerformed(ActionEvent e)
	      {
	        Product d = new Product();
	        d.setVisible(true);
	        dispose();	        
	      }
	    });
		panel.add(Product);
		Order = new JButton("Order");
		Order.addActionListener(new ActionListener()
	    {
	      
		public void actionPerformed(ActionEvent e)
	      {
	        PlaceOrder d = new PlaceOrder();
	        d.setVisible(true);
	        dispose();	        
	      }
	    });
		panel.add(Order);
		this.setSize(500, 500);
		this.add(panel);
		this.setVisible(true);
	}

}