import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TPTableCreation {

	public static void main(String[] args) {
Connection conn;
		
		try 
		{
			
			//1. driver loading and DB connection
			conn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/SoccerTeam"	+ "", "root", "Villablan2002.");
			System.out.println("DB Connection Success!!");
			
			//2. write SQL queries to create DB table
			String sql1 = "Create Table Roster"
					+ "(Player_id int not null,"
					+ "First_Name varchar(20) not null,"
					+ "Last_Name varchar(20) not null,"
					+ "Jersey_number int (2) not null primary key,"
					+ "Age int not null,"
					+ "Weight int not null,"
					+ "Height int not null,"
					+ "Position varchar(20) not null)";
			
			String sql2 = "Create Table Personal_Info "
					+ "(First_Name varchar(20) not null,"
					+ "Last_Name varchar(20) not null,"
					+ "Street_Name varchar(20) not null,"
					+ "City varchar(45) null,"
					+ "State varchar(2) null,"
					+ "Zip_Code int(5) null,"
					+ "Phone_Number varchar (45) null,"
					+ "DOB date null,"
					+ "SSN int not null primary key,"
					+ "Jersey_number int(2) not null,"
					+ "foreign key(jersey_number) references roster(jersey_number))";
					
			
			String sql3 = "create table Player_Statistics"
                    + "(Player_ID int not null primary key,"
                    + "Goals int,"
                    + "Saves int,"
                    + "Yellow_Cards int,"
                    + "Red_Cards int,"
                    + "Completed_Passes int,"
                    + "Tackles int,"
                    + "Headers int,"
                    + "Assists int,"
                    + "Jersey_number int(2) not null,"
                    + "foreign key(jersey_number) references roster(jersey_number))";
			
			String sql4 = "Create Table Injuries"
		            + "(Player_ID int not null,"
		            + "Body_Part varchar(45) null,"
		            + "Injury_Name varchar(45) null,"
		            + "Injury_Date date null,"
		            + "Estimated_Recovery varchar(45) null,"
		            + "Injured_Status varchar(45) null,"
		            + "First_Name varchar(20) not null,"
		            + "Last_Name varchar(20) not null,"
		            + "Injury_id int not null primary key,"
		            + "SSN int not null,"
		            + "foreign key(SSN) references Personal_info(SSN),"
		            + "foreign key(Player_ID) references player_statistics(player_id))";

			
			String sql5 = "create table Gear"
                    + "(Gear_ID int not null primary key,"
                    + "Jersey_size varchar(5),"
                    + "Shorts_size varchar(5),"
                    + "Cleats_color varchar(15),"
                    + "Sweatshirt_size varchar(5),"
                    + "Pants_size varchar(5),"
                    + "Backpack_color varchar(20),"
                    + "Headgear varchar(20),"
                    + "Jersey_number int(2) not null,"
                    + "foreign key(jersey_number) references roster(jersey_number))";

			
			//3. create statement object to execute SQL queries.
			Statement smt = conn.createStatement();
			
			//4. execute SQL query using the execute method of the statement object
			
			boolean result1 = smt.execute(sql1);
			boolean result2 = smt.execute(sql2);
			boolean result3 = smt.execute(sql3);
			boolean result4 = smt.execute(sql4);
			boolean result5 = smt.execute(sql5);
			System.out.println("Result: " + result1);
			System.out.println("Result: " + result2);
			System.out.println("Result: " + result3);
			System.out.println("Result: " + result4);
			System.out.println("Result: " + result5);

			//5. close
			if (smt != null)
				smt.close();
			if (conn != null)
				conn.close();
		}catch(Exception e) {
			System.out.println("Error: " + e);
		}

	}

}