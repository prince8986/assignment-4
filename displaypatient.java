import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
    public static void main(String[] args) {
        String dburl = "jdbc:oracle:thin:@localhost:1521:xe"; 
        String user = "INK @1234"; 
        String password = "ink2259"; // Update with your password

        // Create a connection
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to Oracle database!");

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute query to get patient information
            String query = "SELECT id, name, problem, bill FROM Patients";
            ResultSet resultSet = statement.executeQuery(query);

            // Print header
            System.out.println("Patient ID\tName\t\tProblem\t\tBill");

            // Iterate through the result set and display data
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String problem = resultSet.getString("problem");
                double bill = resultSet.getDouble("bill");

                // Print patient details
                System.out.println(id + "\t\t" + name + "\t\t" + problem + "\t\t" + bill);
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}