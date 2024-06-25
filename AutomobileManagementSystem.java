package Admin;
import java.lang.Class;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
public class AutomobileManagementSystem {
private static final String url="jdbc:postgresql://localhost/Automobile";
private static final String username="postgres";
private static final String password="1111";
public static void main(String args[])
{
	
	Scanner scanner=new Scanner(System.in);
	try {
		Connection connection=DriverManager.getConnection(url,username,password);
		Admin ad=new Admin(connection,scanner);
		while(true)
		{
			System.out.println("*******A PART OF AUTOMOBILE INDUSTRY DBMS********");
			System.out.println("1. Add user by Admin");
			System.out.println("2. View all users ");
			System.out.println("3. Check by id");
			System.out.println("4. Delete users  ");
			System.out.println("5. Book an automobile");
			System.out.println("6. Exit");
			System.out.println("Enter your choice:");
			int choice=scanner.nextInt();
			
			switch(choice)
			{
			case 1:
				// Add users
				ad.addUser();
				break;
			case 2:
				// view all users
				ad.viewUser();
				break;
			case 3: 
				System.out.println("Enter id:");
				int id=scanner.nextInt();
				if(ad.getuserbyid(id)==true)
				{
					System.out.println("It is present.");
				}
				else
				{
					System.out.println("It is not present");
				}
				break;
				// check by id
			case 4:
				System.out.println("Enter id:");
				int id2=scanner.nextInt();
				ad.delUser(id2);
				// delete user
				break;
			case 5:
				AutomobileManagementSystem.bookcar();
				//book a car
			case 6:
				System.out.println("Thank you for USING automobile DBMS <3");
				return;
			default:System.out.println("Enter valid choice !'.'! ");
			}
		}
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
}
public static void bookcar()
{
	Scanner scanner=new Scanner(System.in);
	String q=scanner.nextLine();
	if(q!=null)
	{
		System.out.println("We will get back to you soon !!");
	}
}
}
