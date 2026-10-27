//javac -cp ".;mysql-connector-j-9.x.x.jar" exp7.java
//java -cp ".;mysql-connector-j-9.x.x.jar" exp7
import java.sql.*;

public class exp7 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "password";

        try {
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            Statement stmt = con.createStatement();

            // Insert record
            String insert = "INSERT INTO students VALUES (1, 'Rahul', 85.5)";
            stmt.executeUpdate(insert);
            System.out.println("Record inserted successfully.");

            // Update record
            String update = "UPDATE students SET marks = 90 WHERE id = 1";
            stmt.executeUpdate(update);
            System.out.println("Record updated successfully.");

            // Retrieve records
            System.out.println("\nStudent Records:");

            ResultSet rs = stmt.executeQuery(
                "SELECT * FROM students"
            );

            while (rs.next()) {
                System.out.println(
                    "ID: " + rs.getInt("id")
                    + ", Name: " + rs.getString("name")
                    + ", Marks: " + rs.getDouble("marks")
                );
            }

            rs.close();

            // Delete record
            String delete = "DELETE FROM students WHERE id = 1";
            stmt.executeUpdate(delete);
            System.out.println("\nRecord deleted successfully.");

            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
