package servieses;

import database.DatabaseManager;
import model.Task;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskServieces {
    public void addtask(String title, String description, String assignedTo, String status) {
        try (Connection conn = DatabaseManager.getConnection()) {
            String sql = "INSERT INTO tasks (title, description, assigned_to, status) VALUES (?, ?, ?, ?)";
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, title);
            prep.setString(2, description);
            prep.setString(3, assignedTo);
            prep.setString(4, status);
            prep.executeUpdate();
            System.out.println("the task added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        try (Connection conn = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM tasks";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                tasks.add(new Task(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getInt("assigned_to"),
                        rs.getDate("due_date"),
                        rs.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }


}
