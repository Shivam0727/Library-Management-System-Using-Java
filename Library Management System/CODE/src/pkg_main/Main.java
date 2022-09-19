package pkg_main;

import java.util.Scanner;

import pkg_book.Book;
import pkg_book.BookManager;
import pkg_exception.BookNotFoundException;
import pkg_exception.StudentNotFoundException;
import pkg_person.Student;
import pkg_person.StudentManager;
import pkg_transactions.BookTransactionManager;

public class Main 
{

	
	
	@SuppressWarnings("null")
	public static void main(String[] args) 
	{
		int choice ;
		Scanner sc = new Scanner(System.in);
		BookManager bm = new BookManager();
		StudentManager sm = new StudentManager();
		BookTransactionManager btm = new BookTransactionManager();
		System.out.println("");
		System.out.println("|********************************************| WELCOME TO LIBRARY MANAGEMENT SYSTEM |****************************************************|");
		System.out.println("");
		do
		{
			@SuppressWarnings("unused")
			String option;
			System.out.println("");
			System.out.println(" Please Select From The Given Options Below : ");
			System.out.println("");
			System.out.println(" Enter '1' : if you are Student \n Enter '2' : if you are Librarian \n Enter '3' : if you want to Exit ");
			System.out.print("\n User Choice : ");
			choice = sc.nextInt();
			if(choice == 1)	// if user is student 
			{
				System.out.println("");
				System.out.println(" <----------------------------------------------- As You Press '1' , So You Are Student ----------------------------------------------->");
				System.out.println("");
				System.out.println(" ---> STUDENT MENU");
				System.out.println("");
				System.out.println("");
				System.out.print(" Enter Your Roll Number : ");
				int rollNo = sc.nextInt();
				try
				{
					Student s = sm.get(rollNo);
					if(s == null)
					{
						throw new StudentNotFoundException() ;
					}
					int stud_choice ;
					do
					{
						System.out.println("");
						System.out.println(" Please Select From The Given Options Below : ");
						System.out.println("");
						System.out.println(" Enter 1 to view All Books \n Enter 2 to Search Book by ISBN \n Enter 3 to List Books By Subject \n Enter 4 to Issue a Book \n Enter 5 to Return a Book \n Enter 99 to Exit");
						System.out.println("");
						System.out.print("Enter Choice : ");	
					stud_choice = sc.nextInt();
					System.out.println("");
						switch(stud_choice)
						{
						case 1 :	// View All Books
							System.out.println("");
							System.out.println(" All the Book List Are : ");
							System.out.println("");
							bm.viewAllBooks();
							System.out.println("");
							System.out.print(" Enter Any Key To Go Student Menu : ");
							sc.nextLine();
							option = sc.nextLine();
							
							break ;
						case 2 :	// Search Book By ISBN
							System.out.println("");
							System.out.print(" Enter ISBN of the Book to Search : ");
							 int search_isbn = sc.nextInt();
							Book book = bm.searchBookByIsbn(search_isbn);
							System.out.println("");
							if(book == null)
							{
								System.out.println(" Oops Sorry !!! No Book with this ISBN is Exist in our Library ... ");
							}
							else
							{				
								System.out.println(book);
							}
							System.out.println("");
							System.out.print(" Enter Any Key To Go Student Menu : ");
							sc.nextLine();
						    option = sc.nextLine();
							break;

						case 3 :	// List Book By Subject
							System.out.println("");
							System.out.print(" Enter the Subject to search : ");
							sc.nextLine();
							String search_subject = sc.nextLine();
							System.out.println("");
							bm.listBookBySubject(search_subject);
							System.out.println("");
							System.out.print(" Enter Any Key To Go Student Menu : ");
							sc.nextLine();
						    option = sc.nextLine();
							break ;

						case 4 :	// Issue a Book
							System.out.println("");
							System.out.print(" Enter the ISBN to issue the Book : ");
							int issue_isbn = sc.nextInt();
							System.out.println("");
							 book = bm.searchBookByIsbn(issue_isbn);
							 try
							 {
								 if(book == null)
								 { 
									 throw new BookNotFoundException();
								 }
								 if(book.getAvailable_quantity()>0)
								 {
									 if(btm.issueBook(rollNo, issue_isbn))
									 {
										book.setAvailable_quantity(book.getAvailable_quantity()-1);
										System.out.println("");
										System.out.println(" Congratulations !!! Book Has Been Issued ...");
										System.out.println("");
									 }
								 }
								 else
								 {
									 System.out.println("");
									 System.out.println(" Oops Sorry !!! Currently Book Is Not Available As All Book Has Been issued ...");
									 System.out.println("");
								 }
							 }
							 catch(BookNotFoundException bnfe)
							 {
								 System.out.println(bnfe);
							 }
							 	System.out.println("");
								System.out.print(" Enter Any Key To Go Student Menu : ");
								sc.nextLine();
							    option = sc.nextLine();
							break ;
							
						case 5 :	// Return a Book
							System.out.println("");
							System.out.print(" Please enter the ISBN to return the Book : ");
							int return_isbn = sc.nextInt();
							book = bm.searchBookByIsbn(return_isbn);
							System.out.println("");
							if(book != null)
							{
								if(btm.returnBook(rollNo, return_isbn))
								{
									book.setAvailable_quantity(book.getAvailable_quantity()+1);
									System.out.println("");
									System.out.println(" Thank-You For Returning The Book ... ");
									System.out.println("Have A Nice Day !!!");
									System.out.println("");
								}
								else
								{
									System.out.println("");
									System.out.println(" Could not Return the Book");
									System.out.println("");
								}
							}
							else
							{
								System.out.println("");
								System.out.println(" Book with this ISBN does not Exists");
								System.out.println("");
							}
							System.out.println("");
							System.out.print(" Enter Any Key To Go Student Menu : ");
							sc.nextLine();
						    option = sc.nextLine();
							break ;
							
						case 99 :	// Exit 
							System.out.println("");
							System.out.println(" Thank-You for Using Our LMS-App !!!");
							System.out.println(" See You Soon ...");
							System.out.println();
							break ;

							default :
							System.out.println(" Invalid Choice");
						}
						
					}
					while(stud_choice != 99);
				}
				catch(StudentNotFoundException snfe)
				{
					System.out.println(snfe);
				}
			}
			
			else if(choice == 2)	// If User Is Librarian  
			{
				System.out.println("");
				System.out.println(" <----------------------------------------------- As You Press '2' , So You Are Librarian ----------------------------------------------->");
				System.out.println("");
				
			int lib_choice ;
			do
			  {
				@SuppressWarnings("unused")
				String opt ;
				System.out.println("");
				System.out.println(" ---> LIBRARIAN MENU");
				System.out.println("");
				System.out.println("");
				System.out.println(" Please Select From The Given Options Below : ");
				System.out.println("");
				System.out.println(" Enter 11 to view all Students \n Enter 12 to print a Student by Roll Number \n Enter 13 to Register a Student \n Enter 14 to Update a Student \n Enter 15 to Delete a Student ");
				System.out.println(" Enter 21 to view all Books \n Enter 22 to print a Book by ISBN \n Enter 23 to Add a New Book \n Enter 24 to Update a Book \n Enter 25 to Delete a Book ");
				System.out.println(" Enter 31 to view all Transactions");
				System.out.println(" Enter 99 to Exit");
				System.out.println("");
				System.out.print(" User Choice : ");
				lib_choice = sc.nextInt();
				switch(lib_choice)
				{
					case 11 :	// View All Student
						System.out.println("");
						System.out.println(" All Student Records : ");
						System.out.println("");
						sm.viewAllStudents();
						System.out.println("");
						System.out.print(" Enter Any Key To Go Librarian Menu : ");
						sc.nextLine();
						opt = sc.nextLine();
						break;
					
					case 12 :	// Search a Student Based On Roll Number
					
						System.out.println("");
						System.out.print(" Enter Roll Number to Fetch Student's Record : ");
						int get_rollNo = sc.nextInt();
						System.out.println("");
						Student student = sm.get(get_rollNo);
						if(student == null)
						{
							System.out.println(" No Record Found !!! ");
							System.out.println(" Please Verify Roll_No Again ...");
							
						}
						else
						{
							System.out.println(student);
						}
						System.out.println("");
						System.out.print(" Enter Any Key To Go Librarian Menu : ");
						sc.nextLine();
						opt = sc.nextLine();
						break ;
					
					case 13 :	// Add a Student Details
						System.out.println("");
						System.out.println(" Enter Students Details to Add in Records : ");
						System.out.println("");
						String name ;
						String emailId ;
						String phoneNumber ;
						String address ;
						String dob ;
						int rollNo ;
						int std ;
						String division ;
						sc.nextLine();
						System.out.print(" Name : ");
						name = sc.nextLine();
						System.out.print(" EmailId : ");
						emailId = sc.nextLine();
						System.out.print(" Phone Number : ");
						phoneNumber = sc.nextLine();
						System.out.print(" Address : ");
						address = sc.nextLine();
						System.out.print(" Date Of Birth : ");
						dob = sc.nextLine();
						System.out.print(" Roll Number : ");
						rollNo = sc.nextInt();
						System.out.print(" Standard : ");
						std = sc.nextInt();
						sc.nextLine();
						System.out.print(" Division : ");
						division = sc.nextLine();
						
						student  = new Student(name , emailId , phoneNumber , address , dob , rollNo , std , division);
						sm.addAStudent(student);
						System.out.println("");
						System.out.println(" Congratulations !!! Student is added SuccessFully ...");
						System.out.println("");
						
						System.out.print(" Enter Any Key To Go Librarian Menu : ");
						sc.nextLine();
						opt = sc.nextLine();
						break;
						
					case 14 : // Update a Student
						System.out.println("");
						System.out.print(" Enter the Roll Number to Modify the Record : ");
						int modify_rollNo ;
						modify_rollNo = sc.nextInt();
						student = sm.get(modify_rollNo);
						System.out.println("");
						try
						{
						if(student == null)
						{
							throw new StudentNotFoundException();
						}
						sc.nextLine();
						System.out.print(" Name : ");
						name = sc.nextLine();
						System.out.print(" EmailId : ");
						emailId = sc.nextLine();
						System.out.print(" Phone Number : ");
						phoneNumber = sc.nextLine();
						System.out.print(" Address : ");
						address = sc.nextLine();
						System.out.print(" Date Of Birth : ");
						dob = sc.nextLine();
						System.out.print(" Standard : ");
						std = sc.nextInt();
						 sc.nextLine();
						System.out.print(" Division : ");
						division = sc.nextLine();
						
						sm.updateStudent(modify_rollNo, name, emailId, phoneNumber, address, dob, std, division);
						System.out.println("");
						System.out.println(" Congratulations !!! Student Record is Updated ...");
						System.out.println("");
						}
						catch(StudentNotFoundException snfe)
						{
							System.out.println(snfe);
						}
						System.out.print(" Enter Any Key To Go Librarian Menu : ");
						sc.nextLine();
						opt = sc.nextLine();
						break ;
						
					case 15 : 	// To Delete a Student
						System.out.println("");
						System.out.print(" Enter the Roll Number to Delete the Record : ");
						int delete_rollNo ;
						delete_rollNo = sc.nextInt();
						if(sm.deleteStudent(delete_rollNo))
						{
							System.out.println("");
							System.out.println(" Congratulations !!! Student Record is Removed ...");
							System.out.println("");
						}
						else
						{
							System.out.println("");
							System.out.println(" No record with Given Roll Number Exists ");
							System.out.println(" Please Check Roll-Number Which You Enter Once ...");
							System.out.println("");
						}
						System.out.print(" Enter Any Key To Go Librarian Menu : ");
						sc.nextLine();
						opt = sc.nextLine();
						break ;
						
					case 21 : 	// View All Books 
						System.out.println("");
						System.out.println(" List Of Books : ");
						System.out.println("");
						bm.viewAllBooks();
						System.out.println("");
						System.out.print(" Enter Any Key To Go Librarian Menu : ");
						sc.nextLine();
						opt = sc.nextLine();
						System.out.println("");
						break;
						
					case 22 :	// Search a Book By ISBN
						int search_isbn ;
						System.out.println("");
						System.out.print(" Enter ISBN of the Book to Search : ");
						search_isbn = sc.nextInt();
						Book book = bm.searchBookByIsbn(search_isbn);
						if(book == null)
						{
							System.out.println("");
							System.out.println(" No Book with this ISBN is Exist in our Library ");
						}
						else
						{
							System.out.println("");
							System.out.println(book);
						}
						System.out.println("");
						System.out.print(" Enter Any Key To Go Librarian Menu : ");
						sc.nextLine();
						opt = sc.nextLine();
						System.out.println("");
						break;
						
					case 23 :	// Add a Book 
						System.out.println("");
						System.out.println(" Please enter Book Details to Add : ");
						System.out.println("");
						 int isbn ;
						 String title ;
						 String author ;
						 String publisher ;
						 int edition ;
						 String subject ;
						 int available_quantity ;
						 
						 System.out.print(" ISBN : ");
						 isbn = sc.nextInt();
						 sc.nextLine();
						 
						System.out.print(" Title : ");
						title = sc.nextLine();
						
						System.out.print(" Author : ");
						author = sc.nextLine();
						
						System.out.print(" Publisher : ");
						publisher = sc.nextLine();
						
						System.out.print(" Edition : ");
						edition = sc.nextInt();
						sc.nextLine();
						
						System.out.print(" Subject : ");
						subject = sc.nextLine();
						
						System.out.print(" Available Quantity : ");
						available_quantity = sc.nextInt();
						
						book = new Book(isbn , title, author, publisher, edition, subject, available_quantity);
						bm.addABook(book);
						System.out.println("");
						System.out.println(" Congratulations !!! A book record is added ...");
						System.out.println("");
						System.out.print(" Enter Any Key To Go Librarian Menu : ");
						sc.nextLine();
						opt = sc.nextLine();
						System.out.println("");
						break ;
						
					case 24 : 	// Update a Record
						System.out.println("");
						System.out.print(" Please enter the ISBN to update the Record : ");
						int update_isbn ;
						update_isbn = sc.nextInt();
						System.out.println("");
						try
						{
							book = bm.searchBookByIsbn(update_isbn);
							if(book == null)
							{
								throw new BookNotFoundException();
							}
							System.out.println(" Enter Book Details to Modify : ");
							System.out.println("");
							 sc.nextLine();
							 
							System.out.print(" Title : ");
							title = sc.nextLine();
							
							System.out.print(" Author : ");
							author = sc.nextLine();
							
							System.out.print(" Publisher : ");
							publisher = sc.nextLine();
							
							System.out.print(" Edition : ");
							edition = sc.nextInt();
							sc.nextLine();
							
							System.out.print(" Subject : ");
							subject = sc.nextLine();
							
							System.out.print(" Available Quantity : ");
							available_quantity = sc.nextInt();
							
							bm.updateBook(update_isbn, title, author, publisher, edition, subject, available_quantity);
						}
						catch(BookNotFoundException bnfe)
						{
							System.out.println(bnfe);
						}
						System.out.println("");
						System.out.print(" Enter Any Key To Go Librarian Menu : ");
						sc.nextLine();
						opt = sc.nextLine();
						System.out.println("");
						break ;
						
					case 25 : 	// Delete a Record Of Book 
						System.out.println("");
						System.out.print(" Please enter the ISBN to Delete the Record : ");
						int delete_isbn ;
						delete_isbn = sc.nextInt();
						try
						{
							book = bm.searchBookByIsbn(delete_isbn);
							if(book == null)
							{
								throw new BookNotFoundException();
							}	
							else
							{
								bm.deleteBook(delete_isbn);
								System.out.println("");
								System.out.println(" Congratulations !!! Book record is Deleted ...");
							}
						}
						catch(BookNotFoundException bnfe)
						{
							System.out.println(bnfe);
						}
						System.out.println("");
						System.out.print(" Enter Any Key To Go Librarian Menu : ");
						sc.nextLine();
						opt = sc.nextLine();
						System.out.println("");
						break ;
						
					case 31 : 	// To View All Transaction
						System.out.println("");
						System.out.println(" All The Transactions Of Books Are :  ");
						System.out.println("");
						btm.showAll();
						System.out.println("");
						System.out.print(" Enter Any Key To Go Librarian Menu : ");
						sc.nextLine();
						opt = sc.nextLine();
						System.out.println("");
						break ;
					
					case 99 :	// Exit
						System.out.println("");
						System.out.println(" Thank-You Librarian for Using This Application !!!");
						System.out.println(" Have A Nice Day ...");
						System.out.println("");
						break ;

					default :
						System.out.println("");
						System.out.println(" Invalid Choice");
						System.out.println("");
						
				}
			  }
			while(lib_choice != 99);
			}
			
			else if(choice == 3)
			{
				break;
			}
			else
			{
				System.out.println("");
				System.out.println(" Invalid Choice");
				System.out.println(" Please Try Again ...");
				System.out.println("");
			}
			
		}
		while(choice != 3);
		System.out.println("");
		System.out.println(" Thank-You For Using Our LMS-App ... ");
		System.out.println(" See You Soon !!!");
		System.out.println("");
		sm.writeToFile();
		bm.writeToFile();
		btm.writeToFile();
		sc.close();
	}

}
