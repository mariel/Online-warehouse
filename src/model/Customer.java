package model;
import java.io.Serializable;


public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String Name;
	
	public Customer(int id, String Name){
		super();
		this.setId(id);
		this.setName(Name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	
}