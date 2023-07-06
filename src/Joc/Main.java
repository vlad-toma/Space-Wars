package Joc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void deleteAllScores() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:leaderboard.db")) {
            String query = "DELETE FROM LEADERBOARD";
            Statement statement = connection.createStatement();
            int rowsDeleted = statement.executeUpdate(query);

            System.out.println(rowsDeleted + " rows deleted from the database.");
        } catch (SQLException e) {
            System.err.println("Error deleting scores from database: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Game paooGame = new Game("Space Wars", 1280, 832);
        paooGame.StartGame();
//          deleteAllScores();
    }
}