package pl.myapp.java.examples.jdbc;

import java.sql.*;

public class JdbcExample1 {
  private static final String URL = "jdbc:postgresql://localhost:54322/example_db";
  private static final String USER = "example_user";
  private static final String PASSWORD = "example_password";

  public static void main(String[] args) {
    // Step 1. Load the driver
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
      System.out.println("JDBC Driver not found");
      e.printStackTrace();
      return;
    }

    // Step 2. Establishing the connection
    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
      System.out.println("Connected to the database");

      // Step 3. Create statement
      String insertUser = "INSERT INTO users (name, email) VALUES (?, ?)";
      try (PreparedStatement preparedStatement = connection.prepareStatement(insertUser)) {
        preparedStatement.setString(1, "Janko Muzykant");
        preparedStatement.setString(2, "janek@example.com");
        int rowsInserted = preparedStatement.executeUpdate();
        System.out.println("Rows inserted: " + rowsInserted);
      }

      // Step 4. Execute a query
      String selectUser = "SELECT * FROM users";
      try (Statement statement = connection.createStatement();
          ResultSet resultSet = statement.executeQuery(selectUser)) {

        // Step 5. Process the ResultSet
        while (resultSet.next()) {
          int id = resultSet.getInt("id");
          String name = resultSet.getString("name");
          String email = resultSet.getString("email");
          System.out.printf("User [id=%d, name=%s, email=%s]%n", id, name, email);
        }
      }

    } catch (SQLException e) {
      System.out.println("Database connection failed");
      e.printStackTrace();
    }
  }
}
