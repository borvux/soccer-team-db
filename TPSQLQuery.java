import java.sql.*;

public class TPSQLQuery {

    public static void main(String[] args) {
        Connection conn;
        CallableStatement cstmt;

        try {
            // JDBC connection code (replace with your database details)
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SoccerTeam", "root", "Villablan2002.");
            System.out.println("DB Connection Success!!");

            // Creating the GetPlayerInfoByJersey stored procedure
            String createProcedure = "CREATE PROCEDURE GetPlayerInfoByJersey(IN jerseyNumber INT) " +
                                     "BEGIN " +
                                     "    SELECT R.First_Name, R.Last_Name, PI.Street_Name, PI.City, " +
                                     "    PI.State, PI.Zip_Code, PS.Goals, PS.Saves " +
                                     "    FROM Roster R " +
                                     "    JOIN Personal_Info PI ON R.Jersey_number = PI.Jersey_number " +
                                     "    JOIN Player_Statistics PS ON R.Player_id = PS.Player_ID " +
                                     "    WHERE R.Jersey_number = jerseyNumber; " +
                                     "END";
            cstmt = conn.prepareCall(createProcedure);
            cstmt.execute();
            System.out.println("GetPlayerInfoByJersey Stored Procedure Created!");
            
           // Creating the Top5GoalScorers view
            String createView = "CREATE OR REPLACE VIEW Top5GoalScorers AS " +
                                 "SELECT R.First_Name, R.Last_Name, PS.Goals " +
                                 "FROM Roster R " +
                                 "JOIN Player_Statistics PS ON R.Player_id = PS.Player_ID " +
                                 "ORDER BY PS.Goals DESC " +
                                 "LIMIT 5";
            cstmt = conn.prepareCall(createView);
            cstmt.execute();
            System.out.println("Top5GoalScorers View Created!");
            
            // Creating the CheckGoalStatusWithNames function
            String createFunction = "CREATE FUNCTION CheckGoalStatusWithNames(playerID INT, goalThreshold INT) RETURNS VARCHAR(100)\n"
            		+ "READS SQL DATA\n"
            		+ "BEGIN\n"
            		+ "    DECLARE playerGoals INT;\n"
            		+ "    DECLARE playerName VARCHAR(100);\n"
            		+ "    DECLARE status VARCHAR(100);\n"
            		+ "\n"
            		+ "    -- Get the total goals and player name for the given player ID\n"
            		+ "    SELECT PS.Goals, CONCAT(PI.First_Name, ' ', PI.Last_Name) INTO playerGoals, playerName \n"
            		+ "    FROM Player_Statistics PS \n"
            		+ "    JOIN Personal_Info PI ON PS.jersey_number = PI.jersey_number \n"
            		+ "    WHERE PS.Player_ID = playerID;\n"
            		+ "\n"
            		+ "    -- Check the player's goal status based on the threshold\n"
            		+ "    IF playerGoals > goalThreshold THEN\n"
            		+ "        SET status = CONCAT(playerName, ' has Exceeded the goal threshold.');\n"
            		+ "    ELSE\n"
            		+ "        SET status = CONCAT(playerName, ' has Not Exceeded the goal threshold.');\n"
            		+ "    END IF;\n"
            		+ "\n"
            		+ "    RETURN status;\n"
            		+ "END \n";
            		
            cstmt = conn.prepareCall(createFunction);
            cstmt.execute();
            System.out.println("CheckGoalStatusWithNames Function Created!");
            
            // Calling the created stored procedure
            String callProcedure = "{ CALL GetPlayerInfoByJersey(?) }";
            cstmt = conn.prepareCall(callProcedure);
            int jerseyNumber = 5; // Replace with the desired jersey number
            cstmt.setInt(1, jerseyNumber);

            // Execute the stored procedure
            ResultSet rs = cstmt.executeQuery();
            System.out.println("=======GetPlayerInfoByJersey Output=======");
            while (rs.next()) {
                // Process the retrieved data here
                // Example: Retrieve and print data
                String firstName = rs.getString("First_Name");
                String lastName = rs.getString("Last_Name");
                String streetName = rs.getString("Street_Name");
                String city = rs.getString("City");
                String state = rs.getString("State");
                String zipCode = rs.getString("Zip_Code");
                int goals = rs.getInt("Goals");
                int saves = rs.getInt("Saves");

                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("Address: " + streetName + ", " + city + ", " + state + " " + zipCode);
                System.out.println("Goals: " + goals);
                System.out.println("Saves: " + saves);
            }
            
            // Executing and printing the Top5GoalScorers view
            ResultSet viewResult = cstmt.executeQuery("SELECT * FROM Top5GoalScorers");
            System.out.println("=======Top 5 Goal Scorers=======");
            while (viewResult.next()) {
                String firstName = viewResult.getString("First_Name");
                String lastName = viewResult.getString("Last_Name");
                int goals = viewResult.getInt("Goals");

                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("Goals: " + goals);
            }
            
         // Calling the stored function CheckGoalStatusWithNames
            String callFunction = "{ ? = CALL CheckGoalStatusWithNames(?, ?) }";
            cstmt = conn.prepareCall(callFunction);
            int playerId = 12345; // Replace with the desired player ID
            int goalThreshold = 4; // Replace with the desired goal threshold
            cstmt.registerOutParameter(1, Types.VARCHAR);
            cstmt.setInt(2, playerId);
            cstmt.setInt(3, goalThreshold);

            // Execute the stored function
            cstmt.execute();
            String status = cstmt.getString(1);
            System.out.println("=======CheckGoalStatusWithNames Output=======");
            System.out.println("Status: " + status);

            // Close resources
            if (rs != null) rs.close();
            if (cstmt != null) cstmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
