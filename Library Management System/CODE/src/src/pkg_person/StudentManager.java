package pkg_person;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;

// to store student records , book records , transaction details etc permantly we use file handling (read and write and crud operation) ...
// Inside file to write , read and perform crud operations everytime makes us overhead . So to avoid such Overhead we use Arraylist ...
// As our program is load , we open file and all the records of student , books and all we get in the memory by using Collection Framework . we use Basically Arraylist ...
// At the end when we want to exit from program then we write this list in the file  to save ...

public class StudentManager 
{
	// for write object in file we use ObjectOutputStream
	ObjectOutputStream oos_student = null ;
	// for read object from file we use ObjectInputStream
	ObjectInputStream ois_student = null ;
	
	File student_file = null ;
	
	// we create arraylist for Student ...
	ArrayList<Student> student_list = null ;
	
	@SuppressWarnings("unchecked")
	//Comstructor for class StudentManager ...
	public StudentManager()
	{
		// Memory allocated .
		student_file = new File("Student.dat");
		student_list = new ArrayList<Student>();
		
		// if file present then records  populate from file  ...
		if(student_file.exists())
		{
			try 
			{
				ois_student = new ObjectInputStream(new FileInputStream(student_file));
				student_list = (ArrayList<Student>) ois_student.readObject();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
			
		}
	}
	
	
	public void addAStudent(Student student)
	{
		student_list.add(student);
	}
	
	public Student get(int rollNo)
	{
		for(Student student : student_list)
		{
			if(student.getRollNo()==rollNo)
			{
				return student ;
			}
		}
		return null ;
	}
	
	public void viewAllStudents()
	{
		for(Student student : student_list)
		{
			System.out.println(student);
		}
	}
	
	public boolean deleteStudent(int delete_rollNo)
	{
		ListIterator<Student> student_iterator = (ListIterator<Student>) student_list.listIterator();
		while(student_iterator.hasNext())
		{
			Student student = student_iterator.next();
			if(student.getRollNo()==delete_rollNo)
			{
				student_list.remove(student);
				return true ;
			}
		}
		return false ;
	}
	
	public boolean updateStudent(int update_rollNo , String name, String emailId, String phoneNumber, String address, String dob, int std, String division)
	{
		ListIterator<Student> student_iterator = (ListIterator<Student>) student_list.listIterator();
		while(student_iterator.hasNext())
		{
			Student student = student_iterator.next();
			if(student.getRollNo()==update_rollNo)
			{
				student.setAddress(address);
				student.setDivision(division);
				student.setDob(dob);
				student.setEmailId(emailId);
				student.setName(name);
				student.setPhoneNumber(phoneNumber);
				student.setStd(std);
				return true ;
			}
		}
		return false ;
	}
	
	public void writeToFile()
	{
		try
		{
			oos_student = new ObjectOutputStream(new FileOutputStream(student_file));
			oos_student.writeObject(student_list);
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	
	
	
}
