package Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class Admin
{
	private Connection connection;
	private Scanner scanner;
	public Admin(Connection connection, Scanner scanner )
	{
		this.connection=connection;
		this.scanner=scanner;
	}
	public void addUser()
	{
		System.out.println("Enter user id:");
		int id=scanner.nextInt();
		System.out.println("Enter user_name");
		String user=scanner.next();
		System.out.println("Enter user model:");
		String model=scanner.next();
		try {
		String query="INSERT INTO automob(user_id,user_name,user_model)VALUES(?,?,?)";
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, user);
		preparedStatement.setString(3,model);
		int affectedRows=preparedStatement.executeUpdate();
		if(affectedRows>0)
		{
			System.out.println("User added successfully.");
		}
		else
		{
			System.out.println("Failed to add!");
		}
		} catch(SQLException e) {
			e.printStackTrace(); 
		}
	}
		public void viewUser()
		{ 
			String query="SELECT * FROM public.automob";
			try {
				PreparedStatement preparedStatement=connection.prepareStatement(query);
				ResultSet resultSet=preparedStatement.executeQuery();
				System.out.println("Users:");
				System.out.println("+----------------+----------------+----------------+");
				System.out.println("|      User Id   |    User Name   |    User Model  |");
				System.out.println("+----------------+----------------+----------------+");
				while(resultSet.next())
				{
					int id=resultSet.getInt("user_id");
					String name=resultSet.getString("user_name");
					String model=resultSet.getString("user_model");
					System.out.printf("|%-16s|%-16s|%-16s|\n",id,name,model);
					System.out.println("+----------------+----------------+----------------+");
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		public boolean getuserbyid(int id)
		{
			String query=" SELECT * from automob WHERE user_id=?";
			try {
				PreparedStatement preparedStatement=connection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				ResultSet resultSet=preparedStatement.executeQuery();
				if(resultSet.next())
				{
					return true;
				}
				else
				{
					return false;
				}
			}catch(SQLException e) {
				e.printStackTrace(); 
		}
			return false;
		}
	public void delUser(int id)
	{
            String query="delete from automob where user_id=?";  
            try {
				PreparedStatement preparedStatement=connection.prepareStatement(query);
            	preparedStatement.setInt(1, id);
            	int val=preparedStatement.executeUpdate();
				System.out.println("Deleted Successfully!!");
            }
            catch(SQLException e)
            {
            	e.printStackTrace();
            }
	}
			
}