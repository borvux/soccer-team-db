
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TPDataInsertion {

	public static void main(String[] args) {
		Connection conn;
		
		try 
		{
			
			//1. driver loading and DB connection
			conn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/SoccerTeam", "root", "Villablan2002.");
			System.out.println("DB Connection Success!!");
			
			//2. write SQL queries to create DB table
			String sql1 = "INSERT INTO Roster"
					+ " VALUES (12345, 'Benjamin', 'Harris', 7, 20, 165, 178, 'Forward'),"
                    + "(67890, 'Elijah', 'Turner', 12, 19, 150 , 175, 'Midfielder'),"
                    + "(23456, 'Wyatt', 'Mitchell', 5, 21, 170 , 185, 'Defender'),"
                    + "(78901, 'Jackson', 'Reynolds', 23, 20, 160, 180, 'Goalkeeper'),"
                    + "(34567, 'Caleb', 'Hayes', 14, 19, 155, 173, 'Forward'),"
                    + "(89012, 'Logan', 'Carter', 9, 20, 163, 178, 'Midfielder'),"
                    + "(45678, 'Oliver', 'White', 18, 21, 158, 175, 'Defender'),"
                    + "(90123, 'Henry', 'Bennett', 8, 19, 155, 173, 'Forward'),"
                    + "(56789, 'Liam', 'Thompson', 21, 20, 162, 178, 'Midfielder'),"
                    + "(12356, 'Owen', 'Harrison', 10, 19, 157, 175, 'Forward'),"
                    + "(78945, 'Noah', 'Mitchell', 3, 21, 168, 183, 'Defender'),"
                    + "(23457, 'Samuel', 'Foster', 6, 20, 161, 178, 'Midfielder'),"
                    + "(89013, 'Ethan', 'Reed', 16, 19, 156 , 175, 'Defender'),"
                    + "(34568, 'Oliver', 'Sullivan', 20, 20, 164, 173, 'Midfielder'),"
                    + "(90124, 'Mason', 'Lawson', 11, 19, 159, 175, 'Forward')";
			
			String sql2 = "INSERT INTO Personal_Info"
					+ " VALUES ('Benjamin', 'Harris', '123 Main St', 'Springfield', 'IL', 62701, '555-123-4567', '2003-08-02', 123456789, 7), "
			        + "('Elijah', 'Turner', '456 Elm St', 'Rivertown', 'OR', 97401, '555-234-5678', '2003-11-22', 987654321, 12), "
			        + "('Wyatt', 'Mitchell', '789 Oak St', 'Lakewood', 'NJ', 8701, '555-345-6789', '2001-01-29', 234567890, 5), "
			        + "('Jackson', 'Reynolds', '1010 Pine Ave', 'Hill Valley', 'CA', 93003, '555-456-7890', '2002-01-27', 876543210, 23), "
			        + "('Caleb', 'Hayes', '222 Cedar Ln', 'Brookside', 'MN', 55401, '555-567-8901', '2000-12-16', 345678901, 14), "
			        + "('Logan', 'Carter', '333 Maple Blvd', 'Sunnyside', 'WA', 98901, '555-678-9012', '2003-09-26', 789012345, 9), "
			        + "('Oliver', 'White', '444 Oakwood Ave', 'Clearwater', 'FL', 33755, '555-789-0123', '2001-04-18', 456789012, 18), "
			        + "('Henry', 'Bennett', '555 Pinecrest Dr', 'Springfield', 'MA', 1103, '555-890-1234', '2005-08-18', 890123456, 8), "
			        + "('Liam', 'Thompson', '666 Elmwood Rd', 'Greensboro', 'NC', 27401, '555-901-2345', '2002-06-04', 567890123, 21), "
			        + "('Owen', 'Harrison', '777 Maplewood Ln', 'Oakdale', 'CA', 95361, '555-012-3456', '2005-07-19', 210987654, 10), "
			        + "('Noah', 'Mitchell', '888 Oakhill Ave', 'Centerville', 'OH', 45459, '555-123-4567', '2002-03-12', 543210987, 3), "
			        + "('Samuel', 'Foster', '999 Pinehurst Dr', 'Pineville', 'LA', 71360, '555-234-5678', '2003-12-30', 109876543, 6), "
			        + "('Ethan', 'Reed', '111 Cedarwood Rd', 'Bel Air', 'MD', 21014, '555-345-6789', '2005-06-08', 765432109, 16), "
			        + "('Oliver', 'Sullivan', '222 Oakridge Blvd', 'Silver Spring', 'MD', 20901, '555-456-7890', '2003-04-18', 321098765, 20), "
			        + "('Mason', 'Lawson', '333 Birchwood Ct', 'Sunnyvale', 'CA', 94086, '555-567-8901', '2003-11-08', 678901234, 11)";
					
			String sql3 = "INSERT INTO Player_Statistics"
					+ " VALUES (12345, 7, 0, 2, 0, 340, 25, 15, 4, 7), "
			        + "(67890, 5, 0, 3, 1, 270, 18, 10, 6, 12), "
			        + "(23456, 1, 0, 1, 0, 420, 30, 20, 4, 5), "
			        + "(78901, 0, 10, 0, 0, 50, 5, 0, 0, 23), "
			        + "(34567, 8, 0, 4, 0, 310, 22, 12, 3, 14), "
			        + "(89012, 4, 0, 2, 0, 380, 28, 18, 5, 9), "
			        + "(45678, 0, 2, 0, 1, 290, 20, 11, 2, 18), "
			        + "(90123, 9, 0, 1, 0, 400, 35, 25, 6, 8), "
			        + "(56789, 4, 0, 3, 0, 360, 27, 17, 6, 21), "
			        + "(12356, 2, 0, 2, 0, 320, 24, 14, 8, 10), "
			        + "(78945, 1, 0, 1, 0, 200, 15, 8, 2, 3), "
			        + "(23457, 3, 0, 0, 1, 290, 21, 13, 4, 6), "
			        + "(89013, 0, 0, 4, 1, 380, 32, 22, 5, 16), "
			        + "(34568, 5, 0, 2, 0, 330, 25, 16, 9, 20), "
			        + "(90124, 6, 0, 2, 0, 350, 26, 15, 8, 11)";
			
			String sql4 = "INSERT INTO Injuries"
					+ " VALUES (12345, 'Knee', 'ACL Tear', '2023-11-25', '2024-01-15', 'Injured', 'Benjamin', 'Harris', 1234, 123456789),"
					+ "(67890, 'Ankle', 'Sprained Ankle', '2023-11-27', '2023-12-20', 'Injured', 'Elijah', 'Turner', 5678, 987654321),"
					+ "(23456, 'Hamstring', 'Strained Hamstring', '2023-11-28', '2023-12-15', 'Recovered', 'Wyatt', 'Mitchell', 9012, 234567890),"
					+ "(78901, 'Shoulder', 'Rotator Cuff Injury', '2023-11-30', '2024-01-10', 'Injured', 'Jackson', 'Reynolds', 3456, 876543210),"
					+ "(34567, 'Back', 'Lower Back Strain', '2023-12-01', '2023-12-25', 'Injured', 'Caleb', 'Hayes', 7890, 345678901),"
					+ "(89012, 'Ankle', 'Fractured Ankle', '2023-12-03', '2024-02-01', 'Injured', 'Logan', 'Carter', 2345, 789012345),"
					+ "(45678, 'Knee', 'Meniscus Tear', '2023-12-05', '2024-02-20', 'Injured', 'Oliver', 'White', 6789, 456789012),"
					+ "(90123, 'Elbow', 'Tendonitis', '2023-12-07', '2024-01-05', 'Recovered', 'Henry', 'Bennett', 1523, 890123456),"
					+ "(56789, 'Thigh', 'Pulled Muscle', '2023-12-10', '2024-01-15', 'Injured', 'Liam', 'Thompson', 4567, 567890123)";
			
			String sql5 = "INSERT INTO Gear "
					+ " VALUES (12345, 'M', 'M', 'Red', 'L', '32', 'Blue', 'None',7), "
			        + "(67890, 'L', 'L', 'Black', 'M', '34', 'Green', 'Head Guard',12), "
			        + "(23456, 'M', 'M', 'White', 'XL', '36', 'Red', 'Headband',5), "
			        + "(78901, 'L', 'L', 'Blue', 'L', '32', 'Black', 'None',23), "
			        + "(34567, 'XL', 'XL', 'Green', 'S', '30', 'Yellow', 'Headband',14), "
			        + "(89012, 'S', 'S', 'Orange', 'XL', '38', 'Purple', 'None',9), "
			        + "(45678, 'M', 'M', 'Yellow', 'L', '34', 'Blue', 'None',18), "
			        + "(90123, 'L', 'L', 'Red', 'M', '32', 'Black', 'None',8), "
			        + "(56789, 'XL', 'XL', 'Blue', 'L', '36', 'Green', 'Glasses',21), "
			        + "(12356, 'S', 'S', 'Black', 'XL', '30', 'Red', 'None',10), "
			        + "(78945, 'M', 'M', 'White', 'S', '32', 'Purple', 'None',3), "
			        + "(23457, 'L', 'L', 'Blue', 'L', '34', 'Yellow', 'None',6), "
			        + "(89013, 'XL', 'XL', 'Green', 'XL', '36', 'Black', 'Mouth Guard',16), "
			        + "(34568, 'S', 'S', 'Red', 'M', '30', 'Blue', 'None',20), "
			        + "(90124, 'L', 'L', 'Black', 'L', '32', 'Green', 'Headband',11)";
			
			
			//3. Create the statement object to execute SQL query
			Statement stmt = conn.createStatement();
			
			//4. Execute SQL query using the execute(String sql) method of the Statement object
			boolean result1 = stmt.execute(sql1);
			boolean result2 = stmt.execute(sql2);
			boolean result3 = stmt.execute(sql3);
			boolean result4 = stmt.execute(sql4);
			boolean result5 = stmt.execute(sql5);

			System.out.println("Inserting data is successful!");
			
			//5. close
			if(stmt!=null)
				stmt.close();
			if(conn!=null)
				conn.close();
		}
		catch(Exception e)
		{
			System.out.println("Error: "+e);
		}
	}
}