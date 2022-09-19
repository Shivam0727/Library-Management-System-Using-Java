package pkg_person;

import java.io.Serializable;
import java.util.regex.Pattern;
// As Student and Librarian both having some common properties so we create a class name as Person which contains common attributes as Student and librarian like name , email , phone_no , address , dob ...

abstract public class Person implements Serializable	// as we cannot instantiate Person class i.e; we cant create any object for this class so we create this class as Abstract ...
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// If we make private attribute then we cannot inherit that attribute ...
	// as we want to inherit this fields so thats the reason instead of Private we set access specifier as protected ...
	
	protected String name ;
	protected String emailId ;
	protected String phoneNumber ;
	protected String address ;
	protected String dob ;
	
	// we add Constructor to access attributes ...
	
	public Person(String name, String emailId, String phoneNumber, String address, String dob)
	{
		super();
		this.setName(name);
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.setDob(dob);
	}
	
	// Now we add getter and setter for this five common fields ...
	
	public String getName()
	{
		return name;
	}
	public void setName(String name) 
	{
		boolean isValidName = Pattern.matches("[a-zA-Z][a-zA-Z ]+", name);
		if(isValidName)
		{
		this.name = name;
		}
		else
		{
			this.name = "default name";
		}
	}
	public String getEmailId()
	{
		return emailId;
	}
	public void setEmailId(String emailId) 
	{
		this.emailId = emailId;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() 
	{
		return address;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}
	public String getDob()
	{
		return dob;
	}
	public void setDob(String dob)
	{
		boolean isValidDob = Pattern.matches("[0123]\\d-[01]*[012]-\\d{4}", dob);
		if(isValidDob)
		{
			this.dob = dob;
		}
		else
		{
			this.dob= "01-06-2000";
		}
	}
	
	// we add one default constructor 
	
	public Person() 
	{
		super();
	}

}
