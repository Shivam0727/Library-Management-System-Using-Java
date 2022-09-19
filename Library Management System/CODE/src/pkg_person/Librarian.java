package pkg_person;


public class Librarian extends Person 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id ;
	private String doj ;
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getDoj() 
	{
		return doj;
	}
	public void setDoj(String doj) 
	{
		this.doj = doj;
	}
	
	public Librarian() 
	{
		super();
	}
	
	@Override
	public String toString() 
	{
		return "Librarian [ Id = " + id + " , Date Of Joining = " + doj + " , Name = " + name + " , Email Id = " + emailId + " , Phone Number = " + phoneNumber + " , Address = " + address + " , Date Of Birth = " + dob + " ] ";
	}
	public Librarian(String name, String emailId, String phoneNumber, String address, String dob, int id, String doj)
	{
		super(name, emailId, phoneNumber, address, dob);
		this.id = id;
		this.doj = doj;
	}
	

	
	
}
