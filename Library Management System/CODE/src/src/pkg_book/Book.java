package pkg_book;

import java.io.Serializable;

public class Book implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// we make private fields so that it could not be directly access by others and our code become secure ...
	// Here we need Encapsulation and Abstraction concepts to understand how it works ...
	private int isbn ;			
	private String title ;
	private String author ;
	private String publisher ;
	private int edition ;
	private String subject ;
	private int available_quantity ;
	
	// Now we need getter and setters to set value get value to this upper private fields .
	
	public int getIsbn()
	{
		return isbn;
	}
	public void setIsbn(int isbn)
	{
		this.isbn = isbn;
	}
	public String getTitle() 
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public String getPublisher() 
	{
		return publisher;
	}
	public void setPublisher(String publisher) 
	{
		this.publisher = publisher;
	}
	public int getEdition()
	{
		return edition;
	}
	public void setEdition(int edition)
	{
		this.edition = edition;
	}
	public String getSubject() 
	{
		return subject;
	}
	public void setSubject(String subject) 
	{
		this.subject = subject;
	}
	public int getAvailable_quantity() 
	{
		return available_quantity;
	}
	public void setAvailable_quantity(int available_quantity)
	{
		this.available_quantity = available_quantity;
	}
	
	
	// Now to access upper private fields we need Constructor which is basically public so that we can easily access all the private fields by using this keyword ...
	
	public Book(int isbn, String title, String author, String publisher, int edition, String subject, int available_quantity) 
	{
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.edition = edition;
		this.subject = subject;
		this.available_quantity = available_quantity;
	}
	
	// we also make one default constructor 
	
	public Book() 
	{
		super();
	}
	
	
	// Now we want to print books by using toString method , So we add toString() Method .
	
	@Override
	
	// by using @Override toString method will be override
	public String toString() 
	{
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher + ", edition=" + edition + ", Subject=" + subject + ", available_quantity=" + available_quantity + "]";
	}
	public static void main(String[] args) 
	{
	
	}

}
