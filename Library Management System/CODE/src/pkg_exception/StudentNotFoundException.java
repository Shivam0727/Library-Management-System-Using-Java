package pkg_exception;



public class StudentNotFoundException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5805882650954786302L;

	public StudentNotFoundException()
	{
		super();
	}

	@Override
	public String toString() 
	{
		return "StudentNotFoundException is Generated ...";
	}
	
}
