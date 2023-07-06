package Joc.Methods;

import Joc.RefLink;
import Joc.Tiles.Tile;

import java.awt.geom.Rectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Method {
    public static boolean tileIsAvailable(float x, float y, float width, float height, RefLink refLink) {
        if (!isSolid(x, y, refLink))
            if (!isSolid(x + width, y + height, refLink))
                if (!isSolid(x + width, y, refLink))
                    if (!isSolid(x, y + height, refLink))
                        return true;
        return false;
    }

    public static boolean hitboxCollision(Rectangle2D.Float h1, Rectangle2D.Float h2) {
        if (h1.intersects(h2))
            return true;
        return false;
    }

    private static boolean isSolid(float x, float y, RefLink refLink) {
        if (x < 0 || x >= refLink.GetGame().GetWidth())
            return true;
        if (y < 0 || y >= refLink.GetGame().GetHeight())
            return true;

        float xIndex = x / (Tile.TILE_WIDTH *  Tile.scale);
        float yIndex = y / (Tile.TILE_HEIGHT * Tile.scale);

        int id = refLink.GetMap().GetTile((int) yIndex, (int) xIndex).GetID();

        if(Tile.tiles[id].IsSolid())
            return true;
        return false;
    }
    public static void writeScore(int score1) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:leaderboard.db")) {
            String date = getFormattedDateTime(); // Get formatted date and time

            // Delete excess rows to maintain a maximum of seven rows, ordered by score
            String deleteQuery = "DELETE FROM LEADERBOARD WHERE rowid NOT IN (SELECT rowid FROM LEADERBOARD ORDER BY Score DESC LIMIT 7)";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
            deleteStatement.executeUpdate();

            String name = "nume";
            // Insert new row
            String insertQuery = "INSERT INTO LEADERBOARD (name, score, date) VALUES (?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, name);
            insertStatement.setInt(2, score1);
            insertStatement.setString(3, date);
            insertStatement.executeUpdate();

            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            System.err.println("Error writing to database: " + e.getMessage());
        }
    }

    private static String getFormattedDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
}
