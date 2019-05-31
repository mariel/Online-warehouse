package business_logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Bill {
	public Bill(int id,int quantity,String client, String produs){
		File file = new File("C://Users//petra//workspace//order"+id+".txt");		 
		
		try {
			FileWriter writer = new FileWriter(file);
			writer.write("Am emis bonul pentru comanda "+id+"\n Clientul: "+client+" are luat "+quantity+" bucati de "+produs);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}